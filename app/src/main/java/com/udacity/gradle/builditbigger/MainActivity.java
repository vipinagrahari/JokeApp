package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements EndpointsAsyncTask.JokeLoadListener {

    ContentLoadingProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progress_spinner);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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


    public void tellJoke(View v){


        EndpointsAsyncTask ept = new EndpointsAsyncTask();
        ept.execute(MainActivity.this);
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void onJokeLoaded(String joke) {
        progressBar.setVisibility(View.GONE);
        MainActivityFragment fragment = (MainActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment.showJoke(joke);

    }

}
