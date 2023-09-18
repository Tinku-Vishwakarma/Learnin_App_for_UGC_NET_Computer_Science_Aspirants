package com.example.ugcnetapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ugcnetapp.R;
import com.example.ugcnetapp.WebActivity;
import com.example.ugcnetapp.WebActivity2;
import com.example.ugcnetapp.WebActivity3;
import com.example.ugcnetapp.WebActivity4;
import com.example.ugcnetapp.WebActivity5;
import com.example.ugcnetapp.WebActivity6;
import com.example.ugcnetapp.WebActivity7;
import com.example.ugcnetapp.WebActivity8;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

CardView heading1,heading2,heading3,heading4,heading5,heading6,heading7,heading8;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        heading1 = view.findViewById(R.id.heading1);
        heading2 = view.findViewById(R.id.heading2);
        heading3 = view.findViewById(R.id.heading3);
        heading4 = view.findViewById(R.id.heading4);
        heading5 = view.findViewById(R.id.heading5);
        heading6 = view.findViewById(R.id.heading6);
        heading7 = view.findViewById(R.id.heading7);
        heading8 = view.findViewById(R.id.heading8);


        heading1.setOnClickListener(this);
        heading2.setOnClickListener(this);
        heading3.setOnClickListener(this);
        heading4.setOnClickListener(this);
        heading5.setOnClickListener(this);
        heading6.setOnClickListener(this);
        heading7.setOnClickListener(this);
        heading8.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), WebActivity.class);
        switch (view.getId()){
            case R.id.heading1:
                startActivity(intent);
                break;
            case R.id.heading2:
                Intent intent1 = new Intent(getContext(), WebActivity2.class);
                startActivity(intent1);
                break;
            case R.id.heading3:
                Intent intent2 = new Intent(getContext(), WebActivity3.class);
                startActivity(intent2);
                break;
            case R.id.heading4:
                Intent intent3 = new Intent(getContext(), WebActivity4.class);
                startActivity(intent3);
                break;
            case R.id.heading5:
                Intent intent4 = new Intent(getContext(), WebActivity5.class);
                startActivity(intent4);
                break;
            case R.id.heading6:
                Intent intent5 = new Intent(getContext(), WebActivity6.class);
                startActivity(intent5);
                break;
            case R.id.heading7:
                Intent intent6 = new Intent(getContext(), WebActivity7.class);
                startActivity(intent6);
                break;
            case R.id.heading8:
                Intent intent7 = new Intent(getContext(), WebActivity8.class);
                startActivity(intent7);
                break;

        }

    }
}