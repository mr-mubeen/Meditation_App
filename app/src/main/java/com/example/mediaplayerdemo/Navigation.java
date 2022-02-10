package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Navigation extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        meowBottomNavigation = findViewById(R.id.meowbottom);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_accessibility_new_24 ));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_dashboard_24 ));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_person_24 ));


        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener(

        ) {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new meditation_frag();
                        break;
                    case 2:
                        fragment = new Dashboard_frag();
                        break;
                    case 3:
                        fragment = new Dashboard_frag();
                        break;






                }
                loadFragment(fragment);
            }
        });

        meowBottomNavigation.setCount(1 , "");
        meowBottomNavigation.show(2 , true);
        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext() , "You clicked" + item.getId(), Toast.LENGTH_SHORT).show();

                meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
                    @Override
                    public void onReselectItem(MeowBottomNavigation.Model item) {
//                        Toast.makeText(getApplicationContext() , "You reselected" + item.getId(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout , fragment).commit();
    }
}