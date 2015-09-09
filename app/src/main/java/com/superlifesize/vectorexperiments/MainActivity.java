package com.superlifesize.vectorexperiments;

import android.app.Activity;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView checkCross;
    private AnimatedVectorDrawable checkToCross;
    private AnimatedVectorDrawable crossToCheck;
    private boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCross = (ImageView) findViewById(R.id.check_cross);
        checkToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_check_to_cross);
        crossToCheck = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_check);

        checkCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateCheckCross();
            }
        });
    }


    public void animateCheckCross() {
        AnimatedVectorDrawable drawable = check ? checkToCross : crossToCheck;
        checkCross.setImageDrawable(drawable);
        drawable.start();
        check = !check;
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
}
