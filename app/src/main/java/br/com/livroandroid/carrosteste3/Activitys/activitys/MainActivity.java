package br.com.livroandroid.carrosteste3.Activitys.activitys;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.livroandroid.carrosteste3.Activitys.Fragments.AboutDialog;
import br.com.livroandroid.carrosteste3.Activitys.Fragments.CarrosTabFragment;
import br.com.livroandroid.carrosteste3.R;

public class MainActivity extends BaseActivity  {
    protected MenuItem item1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setuptoolbar();
        setUpDrawer();
        replaceFragment(new CarrosTabFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Toast.makeText(this,"Clicou no sobre",Toast.LENGTH_SHORT).show();
            AboutDialog.showAbout(getSupportFragmentManager());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
