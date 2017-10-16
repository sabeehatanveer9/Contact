package com.example.naveed.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Naveed on 10/16/2017.
 */

public class detailFragment extends Fragment{
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private ImageView img1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_layout, container, false);

        text1= v.findViewById(R.id.tv2);
        text2= v.findViewById(R.id.tv4);
        text3= v.findViewById(R.id.tv6);
        text4= v.findViewById(R.id.tv8);


        return v;
    }
}
