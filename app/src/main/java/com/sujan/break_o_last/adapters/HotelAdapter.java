package com.sujan.break_o_last.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.sujan.break_o_last.R;
import com.sujan.break_o_last.models.Hotel;
import com.sujan.break_o_last.ui.home.RoomActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    Context context;
    List<Hotel> hotelList;

    public HotelAdapter(Context context, List<Hotel> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public HotelAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contex, parent, false);
        return new HotelViewHolder(view);

    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, final int position) {
        String path="http://10.0.2.2:3012/profile/";
        final Hotel hotel = hotelList.get(position);
        Picasso.get().load(path+hotel.getRoomImage()).resize(120, 60).into(holder.imgProfile);
        holder.tvName.setText(hotel.getHotelName());
        holder.tvAddress.setText(hotel.getAddress());
        holder.tvBed.setText(hotel.getNoOfBed());


        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, RoomActivity.class);
                intent.putExtra("Image",hotel.getRoomImage());
                intent.putExtra("Name",hotel.getHotelName());
                intent.putExtra("Address",hotel.getAddress());
                intent.putExtra("Desc",hotel.getDescription());
                intent.putExtra("Id",hotel.getId());
                intent.putExtra("BedNo",hotel.getNoOfBed());
                intent.putExtra("RoomNo",hotel.getRoomNo());
                intent.putExtra("Phone",hotel.getPhone());

                context.startActivity(intent);

            }
        });


}

    @Override
    public int getItemCount() {
        return hotelList.size();
    }



    public class HotelViewHolder extends RecyclerView.ViewHolder {
    CircleImageView imgProfile;
    TextView tvName, tvAddress,tvBed;


    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
        imgProfile = itemView.findViewById(R.id.imgProfile);
        tvName = itemView.findViewById(R.id.tvName);
        tvAddress = itemView.findViewById(R.id.tvAddress);
        tvBed = itemView.findViewById(R.id.tvBed);


    }
}
}
