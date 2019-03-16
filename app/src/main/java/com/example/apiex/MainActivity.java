package com.example.apiex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.apiex.from.generate.ArticlesItem;
import com.example.apiex.from.generate.ResponseApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvApi;
    ApiAdapter adapter;
    List<ArticlesItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        rvApi = findViewById( R.id.rv_api );
        adapter = new ApiAdapter( this, data );

        getData();
    }

    private void getData() {
        ApiService api = ConfigRetrofit.getInstance();
        Call<ResponseApi> call = api.getDataApi();
        call.enqueue( new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                if (response.isSuccessful()) {
                   data = response.body().getArticles();
                   adapter = new ApiAdapter( MainActivity.this,data );
                   rvApi.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
                   rvApi.setAdapter( adapter );
                }
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Toast.makeText( MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );



    }
}
