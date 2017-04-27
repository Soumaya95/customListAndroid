package com.example.soumayarebai.lab2;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.String;


class MyLineAdapter extends ArrayAdapter<String>
{
    Activity context;
    String[] items;
    MyLineAdapter(Activity context, String[] items){
        super(context,R.layout.customlayout,items);
        this.context=context;
        this.items=items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.customlayout,null);
            viewHolder=new ViewHolder();
            viewHolder.label=(TextView) convertView.findViewById(R.id.grade);
            viewHolder.image=(ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);

        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.label.setText(items[position]);
        float grade=Float.valueOf(items[position]);
        viewHolder.image.setImageResource((grade >= 10)?R.drawable.ic_mood:R.drawable.ic_mood_bad);

        return convertView;
}
}