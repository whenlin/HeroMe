package com.example.whenlin.herome.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.whenlin.herome.Fragments.BackstoryFragment;
import com.example.whenlin.herome.Fragments.MainFragment;
import com.example.whenlin.herome.Fragments.PickPowerFragment;
import com.example.whenlin.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener,PickPowerFragment.PickPowerInteractionListener, BackstoryFragment.BackStoryFragmentInteractionListener {

    private String primaryPower;
    private String secondaryPower;
    private final String accident = "Came by Accident";
    private final String genetic = "Genetic Mutation";
    private final String born = "Born with Them";
    private final String turtlePower = "Turtle Power";
    private final String lightning = "Lightning";
    private final String flight = "Flight";
    private final String webSlinging = "Web Slinging";
    private final String laserVision = "Laser Vision";
    private final String superStrength = "Super Strength";

    private enum powers {
        TURTLE_POWER, LIGHTNING, FLIGHT, WEB_SLINGING, LASER_VISION, SUPER_STRENGTH;
    }

    public void setPrimaryPower(String option){
        option = primaryPower;
    }

    public void setSecondaryPower(String option){
        option = secondaryPower;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        primaryPower = " ";
        secondaryPower = " ";

        if (fragment == null){
            fragment = new MainFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    public void loadPickPowerScreen(){
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadBackstoryScreen(){
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backstoryFragment).addToBackStack(null).commit();
    }

    public void loadMainScreen(){
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void BackStoryFragmentInteractionListener(Uri uri) {

    }
}
