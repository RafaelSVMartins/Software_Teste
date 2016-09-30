package br.com.livroandroid.carrosteste3.Activitys.activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.livroandroid.carrosteste3.Activitys.Fragments.CarroFragment;
import br.com.livroandroid.carrosteste3.Activitys.Fragments.CarrosTabFragment;
import br.com.livroandroid.carrosteste3.Activitys.Fragments.SiteLivroFragment;
import br.com.livroandroid.carrosteste3.R;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected DrawerLayout drawer;
    protected NavigationView navigationView;
    protected FloatingActionButton fab;
    protected ActionBarDrawerToggle toggle;
    protected void setuptoolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setUpDrawer();
    }
        protected void setUpDrawer() {
            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();

                    if (id == R.id.frag1) {
                        replaceFragment(new CarrosTabFragment());
                    } else if (id == R.id.frag2) {
                        replaceFragment(CarroFragment.newInstance(R.string.esportivos));
                    } else if (id == R.id.frag3) {
                        replaceFragment(CarroFragment.newInstance(R.string.classicos));
                    } else if (id == R.id.frag4) {
                        replaceFragment(CarroFragment.newInstance(R.string.luxo));
                    } else if (id == R.id.frag5) {
                        replaceFragment(new SiteLivroFragment());
                    }

                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            });
        }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    protected void replaceFragment(Fragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,frag,"tag").commit();
    }
}
