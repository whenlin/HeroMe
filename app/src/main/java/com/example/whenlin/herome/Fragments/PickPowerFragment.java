package com.example.whenlin.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.whenlin.herome.Activity.MainActivity;
import com.example.whenlin.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PickPowerInteractionListener mListener;

    private Button turtlePower ;
    private Button lighting ;
    private Button flight ;
    private Button webSlinging ;
    private Button laser ;
    private Button strength ;
    private Button backstoryBtn ;
    private int leftDrawable;
    private Button btn;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

         turtlePower = (Button) view.findViewById(R.id.button3);
         lighting = (Button) view.findViewById(R.id.button4);
         flight = (Button) view.findViewById(R.id.button5);
         webSlinging = (Button) view.findViewById(R.id.button6);
         laser = (Button) view.findViewById(R.id.button7);
         strength = (Button) view.findViewById(R.id.button8);
         backstoryBtn = (Button) view.findViewById(R.id.button9);

        turtlePower.setOnClickListener(this);
        lighting.setOnClickListener(this);
        flight.setOnClickListener(this);
        webSlinging.setOnClickListener(this);
        laser.setOnClickListener(this);
        strength.setOnClickListener(this);
        backstoryBtn.setOnClickListener(this);

        backstoryBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();

                switch (leftDrawable) {

                    case R.drawable.turtle_power:
                        mainActivity.setSecondaryPower("Turtle Power");
                        break;

                    case R.drawable.lightning:
                        mainActivity.setSecondaryPower("Lightning");
                        break;

                    case R.drawable.superman_crest:
                        mainActivity.setSecondaryPower("Flight");
                        break;

                    case R.drawable.spiderweb:
                        mainActivity.setSecondaryPower("Web Slinging");
                        break;

                    case R.drawable.laser_vision:
                        mainActivity.setSecondaryPower("Laser Vision");
                        break;

                    case R.drawable.super_strength:
                        mainActivity.setSecondaryPower("Super Strength");
                        break;

                }

                mainActivity.loadBackstoryScreen();
            }
        });

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        turtlePower.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lighting.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        flight.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
        webSlinging.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,0,0);
        laser.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        strength.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

        btn = (Button) view;
        leftDrawable = 0;

        if(btn == turtlePower){
            leftDrawable = R.drawable.turtle_power;
        } else if (btn == lighting){
            leftDrawable = R.drawable.lightning;
        } else if (btn == flight) {
            leftDrawable = R.drawable.superman_crest;
        } else if (btn == webSlinging){
            leftDrawable = R.drawable.spiderweb;
        } else if (btn == laser){
            leftDrawable = R.drawable.laser_vision;
        } else if (btn == strength) {
            leftDrawable = R.drawable.super_strength;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
