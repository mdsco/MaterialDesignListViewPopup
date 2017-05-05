package com.example.mike.materialdesignlistviewpopup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class CardViewRecyclerViewAdapter extends RecyclerView.Adapter<CardViewRecyclerViewAdapter.CardViewHolder> {

    private final List<String> list;
    private final Context context;

    public CardViewRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CardViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);

        CardViewHolder cardViewHolder = new CardViewHolder(listItem);
        final AutoTransition transition = new AutoTransition();
        transition.setDuration(100);



        cardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            boolean visible = false;

            @Override
            public void onClick(View view) {

                Log.v("Initial elevation", view.getElevation() + "");
                Log.v("Initial z", view.getZ() + "");


                LinearLayout hiddenLayout = (LinearLayout) view.findViewById(R.id.hiddenLayout);

                visible = !visible;
                float elevation = visible ? 10.0f : 7.0f;
                float zVal = visible ? 20.0f : 5.0f;

                TransitionManager.beginDelayedTransition(parent, transition);
                hiddenLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
                view.setElevation(elevation);
                view.setTranslationZ(zVal);
            }

        });

        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView text;

        public CardViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            text = (TextView) itemView.findViewById(R.id.textView);
        }

        @Override
        public void onClick(View view) {
//            Log.v("yeah", view.toString());
//            Log.v("What", "Da fuq");
//            CardView cardView = (CardView) view;
//            cardView.setElevation(40.0f);
//            cardView.setZ(40.0f);
//            TextView hidden = (TextView) view.findViewById(R.id.hiddenText);

//            TransitionManager.beginDelayedTransition(parent);
//            hidden.setVisibility(true);
        }

    }

}
