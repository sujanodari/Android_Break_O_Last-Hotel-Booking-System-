package com.sujan.break_o_last.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sujan.break_o_last.R;
import com.sujan.break_o_last.adapters.HotelAdapter;
import com.sujan.break_o_last.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    static List<Hotel> hotelList = new ArrayList<>();
    int hotel1,hotel2,hotel3,hotel4,hotel5;

    private RecyclerView recycler_view, recycler_view_horizontal;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        hotel1=  R.drawable.hotel1 ;
        hotel2=  R.drawable.hotel2 ;
        hotel3=  R.drawable.hotel3 ;
        hotel4=  R.drawable.hotel4 ;
        hotel5=  R.drawable.hotel5 ;

        recycler_view = root.findViewById(R.id.recycler_view);
        recycler_view_horizontal = root.findViewById(R.id.recycler_view_horizontal);
        
        // Adding all the contacts object in list
        hotelList.add(new Hotel("Katayani", "Jhapa", hotel1));
        Hotel hotel1 = new Hotel("Katayani", "Jhapa", hotel2);
        hotelList.add(hotel1);

        Hotel hotel2 = new Hotel("Katayani", "Jhapa", hotel3);
        hotelList.add(hotel2);
        Hotel hotel3 = new Hotel("Katayani", "Jhapa", hotel4);
        hotelList.add(hotel3);

        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(), hotelList);
        recycler_view.setAdapter(hotelAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        HotelAdapter hotelAdapter1 = new HotelAdapter(getActivity(), hotelList);
        recycler_view_horizontal.setAdapter(hotelAdapter1);
        recycler_view_horizontal.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        //recycler_view_horizontal.smoothScrollToPosition(hotelAdapter1.getItemCount() -1);
        recycler_view_horizontal.smoothScrollToPosition(recycler_view_horizontal.getAdapter().getItemCount());


        return root;
    }
}