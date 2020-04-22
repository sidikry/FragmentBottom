package com.timkontrakan.coronavirusinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.timkontrakan.coronavirusinfo.view.GlobalFragment;
import com.timkontrakan.coronavirusinfo.view.HomeFragment;
import com.timkontrakan.coronavirusinfo.view.InfoFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());
        BottomNavigationView navigationView = findViewById(R.id.bn_main);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.global_menu:
                fragment = new GlobalFragment();
                break;
            case R.id.info_menu:
                fragment = new InfoFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {

        if (fragment !=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
