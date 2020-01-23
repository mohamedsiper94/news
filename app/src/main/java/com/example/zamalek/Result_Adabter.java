package com.example.zamalek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Result_Adabter extends  RecyclerView.Adapter<Result_Adabter.HoldView>{


    class HoldView extends RecyclerView.ViewHolder{
        TextView time_now,name_home,name_away,status,location,date,league_name,scour;

        public HoldView(@NonNull View itemView) {
            super(itemView);
            time_now=itemView.findViewById(R.id.time_now);
            name_home=itemView.findViewById(R.id.texthometeam);
            name_away=itemView.findViewById(R.id.textawayteam);
            status=itemView.findViewById(R.id.status);
            location=itemView.findViewById(R.id.location);
            date=itemView.findViewById(R.id.date);
            league_name=itemView.findViewById(R.id.leguename);
            scour=itemView.findViewById(R.id.reult);

        }
    }
    Context context;
    ArrayList<Resultsofmatchs> arrayList;

    public Result_Adabter(Context context, ArrayList<Resultsofmatchs> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Result_Adabter.HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.showresult,parent,false);
        return new HoldView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Result_Adabter.HoldView holder, int position) {
        Resultsofmatchs resultsofmatchs=arrayList.get(position);
        holder.time_now.setText(resultsofmatchs.getTime_now());
        holder.name_home.setText(resultsofmatchs.getName_home());
        holder.name_away.setText(resultsofmatchs.getName_away());
        holder.status.setText(resultsofmatchs.getStatus());
        holder.location.setText(resultsofmatchs.getLocation());
        holder.date.setText(resultsofmatchs.getDate());
        holder.league_name.setText(resultsofmatchs.getName_lega());
        holder.scour.setText(resultsofmatchs.getScore());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
