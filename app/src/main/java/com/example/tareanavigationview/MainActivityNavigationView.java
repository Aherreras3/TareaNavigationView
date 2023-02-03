package com.example.tareanavigationview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import com.google.android.material.navigation.NavigationView;

public class MainActivityNavigationView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnavigationview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarNavView);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuactionbar, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menuNuevoGrupo:
                fragment = new FragmentNuevoGrup();
                fragmentTransaction = true;
                break;
            case R.id.Contactos:
                fragment = new FragmentContac();
                fragmentTransaction = true;
                break;
            case R.id.Llamadas:
                fragment = new FragmentLlamadas();
                fragmentTransaction = true;
                break;
            case R.id.Personcerca:
                fragment = new FragmentPersonaC();
                fragmentTransaction = true;
                break;
            case R.id.mensajesguardados:
                fragment = new FragmentMensajesG();
                fragmentTransaction = true;
                break;
            case R.id.Ajustes:
                fragment = new FragmentAjust();
                fragmentTransaction = true;
                break;
            case R.id.InvitarAmigos:
                fragment = new FragmentInvitar();
                fragmentTransaction = true;
                break;
            case R.id.PreguntasFrecuentes:
                fragment = new FragmentAyuda();
                fragmentTransaction = true;
                break;
                
        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return false;
    }

}
