package com.example.mike.materialdesignlistviewpopup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class PopUpArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> itemList;

    public PopUpArrayAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context = context;
        this.itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        }

        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.container);
        final TextView texxt = (TextView) convertView.findViewById(R.id.textView);
        final RelativeLayout layout = (RelativeLayout) convertView.findViewById(R.id.inner);
        final Button butt_in = (Button) convertView.findViewById(R.id.button);

//        boolean isExpanded = position;
//        linearLayout.setActivated(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {

            boolean visible = false;

            @Override
            public void onClick(View view) {
                visible = !visible;
                float elevation = visible ? 10.0f : 0.0f;
                float zVal = visible ? 20.0f : 0.0f;
                TransitionManager.beginDelayedTransition(parent);
                layout.setVisibility(visible ? View.VISIBLE : View.GONE);
//                notifyDataSetChanged();
                view.setElevation(zVal);
                view.setTranslationZ(zVal);
            }
        });

        String item = itemList.get(position);

        TextView text = (TextView) convertView.findViewById(R.id.textView);

        text.setText(item);

        return convertView;
    }
}
