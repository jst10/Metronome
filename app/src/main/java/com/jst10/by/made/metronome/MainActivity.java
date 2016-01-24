package com.jst10.by.made.metronome;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jst10.by.made.metronome.fragments.BottomFragment1;
import com.jst10.by.made.metronome.fragments.BottomFragment2;
import com.jst10.by.made.metronome.fragments.MiddleFragment1;
import com.jst10.by.made.metronome.fragments.TopFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_TOP_FRAGMENT = "top_fragment";
    private static final String TAG_BOTTOM_FRAGMENT = "bottom_fragment1";
    private static final String TAG_MIDDLE_FRAGMENT = "middle_fragment";

    public static final int DEFAULT_TEMPO = 60;
    public static final int MAX_TEMPO_LIMIT = 300;
    public static final int MINIMAL_TEMPO_LIMIT = 30;

    private static final int REP_DELAY = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    protected void onResume() {
        super.onResume();
        initFragments();
    }

    private void initFragments() {
        initTopFragment();
        initBottomFragment();
        initMiddleFragment();
    }

    private void initTopFragment() {
        Fragment fragment = new TopFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.top_fragment_container, fragment, TAG_TOP_FRAGMENT);
        transaction.commit();
    }

    private void initBottomFragment() {
        Fragment fragment = new BottomFragment2();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.bottom_fragment_container, fragment, TAG_BOTTOM_FRAGMENT);
        transaction.commit();
    }

    private void initMiddleFragment() {
        Fragment fragment = new MiddleFragment1();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.middle_fragment_container, fragment, TAG_MIDDLE_FRAGMENT);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
