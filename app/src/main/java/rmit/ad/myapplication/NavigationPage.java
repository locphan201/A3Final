package rmit.ad.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_page);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.frame_container);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadFragment(new GameLibrary());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_item1:
                        loadFragment(new GameLibrary());
                        break;
                    case R.id.nav_item2:
                        loadFragment(new GameStore());
                        break;
                    case R.id.nav_item3:
                        loadFragment(new Fragment());
                        break;
                    case R.id.nav_item4:
                        loadFragment(new UserProfile());
                        break;
                    case R.id.nav_item5:
                        loadFragment(new HelpAndSupport());
                        break;
                    case R.id.nav_item6:
                        setResult(RESULT_OK);
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.commit();

        // Fragment 1
        if (fragment instanceof GameLibrary) {
            getSupportActionBar().setTitle(R.string.app_name_fragment1);
        }

        // Fragment 2
        else if (fragment instanceof GameStore) {
            getSupportActionBar().setTitle(R.string.app_name_fragment2);
        }

//        // Fragment 3
//        else if (fragment instanceof Fragment) {
//            getSupportActionBar().setTitle(R.string.app_name_fragment3);
//        }

        // Fragment 4
        else if (fragment instanceof UserProfile) {
            getSupportActionBar().setTitle(R.string.app_name_fragment4);
        }

        // Fragment 5
        else if (fragment instanceof HelpAndSupport) {
            getSupportActionBar().setTitle(R.string.app_name_fragment5);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }
}