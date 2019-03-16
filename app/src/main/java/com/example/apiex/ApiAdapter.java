package com.example.apiex;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apiex.from.generate.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.List;

class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {
    Context context;
    List<ArticlesItem> data;

    public ApiAdapter(Context context, List<ArticlesItem> data) {
this.context = context;
this.data = data;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ApiViewHolder( LayoutInflater.from( context ).inflate( R.layout.tampilan_list,viewGroup,false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder apiViewHolder, final int i) {
apiViewHolder.tvApiAuthor.setText( data.get( i ).getAuthor() );
apiViewHolder.tvApi.setText( data.get( i ).getDescription() );

        Picasso.get().load( data.get( i ).getUrlToImage() ).into( apiViewHolder.imgApi );

        apiViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity( new Intent( context, WebView.class ).putExtra( "data",data.get( i ).getUrl() ) );

            }
        } );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {
        ImageView imgApi;
        TextView tvApi,tvApiAuthor;

        public ApiViewHolder(@NonNull View itemView) {
            super( itemView );

            imgApi = itemView.findViewById( R.id.img_api );
            tvApi = itemView.findViewById( R.id.tv_api );
            tvApiAuthor = itemView.findViewById( R.id.tv_api_author );

        }
    }
}
