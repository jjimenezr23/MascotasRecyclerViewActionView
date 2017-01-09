package jjimenez.app.com.mascotasrecyclerviewactionview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.pageAdapter;
import jjimenez.app.com.mascotasrecyclerviewactionview.constantes.Confi;
import jjimenez.app.com.mascotasrecyclerviewactionview.fragment.RecyclerViewFragment;
import jjimenez.app.com.mascotasrecyclerviewactionview.fragment.PerfilFragment;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar mitoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mitoolbar = (Toolbar)findViewById(R.id.detalletoobar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();



        if(mitoolbar != null){setSupportActionBar(mitoolbar);}

    }
    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());


        return fragments;

    }

    private void setUpViewPager(){

        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite_dog);





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.about:
                Intent intent = new Intent(MainActivity.this, BioProgramador.class);
                startActivity(intent);
                break;
            case R.id.setting:
                Intent j = new Intent(this, ContactoSent.class);
                startActivity(j);
                break;

            case R.id.miactionmenu:
                Intent i = new Intent(MainActivity.this, Confi.DetalleMascota.class);
                startActivity(i);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
