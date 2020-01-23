package com.example.zamalek;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.HolderView> {


    public static class HolderView extends RecyclerView.ViewHolder{
        private TextView title,duration;
        private ImageView url_image;


        public HolderView(@NonNull View itemView) {
            super(itemView);
              title=itemView.findViewById(R.id.text_headline);
              duration=itemView.findViewById(R.id.text_date);
              url_image=itemView.findViewById(R.id.view);


        }
    }
          Context context;
          ArrayList<NewsInaternational> arrayList;

    public RecycleviewAdapter(Context context, ArrayList<NewsInaternational> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecycleviewAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view,parent,false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleviewAdapter.HolderView holder, final int position) {
            NewsInaternational newsInaternational=arrayList.get(position);
            holder.title.setText(newsInaternational.getTitle());
            holder.duration.setText(newsInaternational.getDuration());
        Picasso.get().load(newsInaternational.getUrl_imag()).into(holder.url_image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder alertb=new AlertDialog.Builder(context,R.style.MyDialogTheme);


                alertb.setTitle(arrayList.get(position).getTitle()).setMessage(arrayList.get(position).getDescription());
                alertb.setPositiveButton("Go to for more detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                          Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(arrayList.get(position).getUrl()));
                        context.startActivity(intent);

                    }

                });
                 alertb.show();
             }
        });    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
