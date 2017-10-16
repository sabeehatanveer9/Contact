package com.example.naveed.contact;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Naveed on 10/15/2017.
 */

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> implements View.OnClickListener {



    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView txtView;
        public ImageButton imgBtn;
        public ImageView imgView;




        public ViewHolder(View itemView) {

            super(itemView);

            txtView = (TextView) itemView.findViewById(R.id.tv);
            imgBtn= (ImageButton) itemView.findViewById(R.id.img_btn);
            imgView = (ImageView) itemView.findViewById(R.id.img_view);

        }
    }
    @Override
    public void onClick(View view) {

    }
    private List<Data> mContacts;
    private Context mContext;
    private LayoutInflater inflater;
    int pos ;

    public customAdapter(Context context, List<Data> contacts) {
        mContacts = contacts;
        mContext = context;
        inflater = LayoutInflater.from(context);
    }
    private Context getContext() {
        return mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {



        // Inflate the custom layout
        final View contactView = inflater.inflate(R.layout.contact_layout, viewGroup, false);

        // Return a new holder instance
        final ViewHolder viewHolder = new ViewHolder(contactView);
        pos = i;
        viewHolder.imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContacts.remove(viewHolder.getPosition());
                Toast.makeText(getContext(),"Item deleted",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();


            }
        });

        viewHolder.txtView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), viewHolder.txtView.getText(), Toast.LENGTH_LONG).show();
                    }
                });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Data contact = mContacts.get(i);
        viewHolder.txtView.setText(contact.getName());
        Picasso.with(mContext).load("http://i.imgur.com/DvpvklR.png").placeholder(R.drawable.img2).
                resize(50, 50)
                .centerCrop()
                .into(viewHolder.imgView);



    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

}
