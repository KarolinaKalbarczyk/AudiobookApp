package com.example.android.audiobookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samsung on 2018-03-22.
 */

public class Utwory5Adapter extends ArrayAdapter<com.example.android.audiobookapp.Utwory5>{

    public Utwory5Adapter(Context context, ArrayList<com.example.android.audiobookapp.Utwory5> utwory5) {
        super(context, 0, utwory5);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        com.example.android.audiobookapp.Utwory5 currentUtwory = getItem(position);

        TextView rozdzial = (TextView) listItemView.findViewById(R.id.rozdzial);
        rozdzial.setText(currentUtwory.getRozdzial());

        TextView czas = (TextView) listItemView.findViewById(R.id.czas);
        czas.setText(currentUtwory.getCzas());

        return listItemView;

    }

}
