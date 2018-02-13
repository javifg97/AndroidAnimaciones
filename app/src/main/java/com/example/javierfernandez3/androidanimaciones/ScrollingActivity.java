package com.example.javierfernandez3.androidanimaciones;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ScrollingActivity extends AppCompatActivity {

    ScrollingActivityEvents events;

    FloatingActionButton fab, fab1, fab2, fab3;
    Animation showFab1,hideFab1,showFab2,hideFab2,showFab3,hideFab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        events =new ScrollingActivityEvents(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(events);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(events);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(events);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab3.setOnClickListener(events);

        showFab1 = AnimationUtils.loadAnimation(this,R.anim.fab1_show);
        hideFab1 = AnimationUtils.loadAnimation(this,R.anim.fab1_hide);

        showFab2 = AnimationUtils.loadAnimation(this,R.anim.fab2_show);
        hideFab2 = AnimationUtils.loadAnimation(this,R.anim.fab2_hide);

        showFab3 = AnimationUtils.loadAnimation(this,R.anim.fab3_show);
        hideFab3 = AnimationUtils.loadAnimation(this,R.anim.fab3_hide);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    public void showFabs(){
        CoordinatorLayout.LayoutParams layoutParams1 = (CoordinatorLayout.LayoutParams) fab1.getLayoutParams();

        layoutParams1.rightMargin+=(int) (fab1.getWidth()*2);

        fab1.setLayoutParams(layoutParams1);
        fab1.startAnimation(showFab1);
        fab1.setClickable(true);

        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) fab2.getLayoutParams();

        layoutParams2.rightMargin+=(int) (fab2.getWidth()*3.4);

        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(showFab2);
        fab2.setClickable(true);

        CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) fab3.getLayoutParams();

        layoutParams3.rightMargin+=(int) (fab3.getWidth()*4.8);

        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(showFab3);
        fab3.setClickable(true);

    }

    public void hideFabs(){
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) fab1.getLayoutParams();

        layoutParams.rightMargin+=-(int) (fab1.getWidth()*2);

        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(hideFab1);
        fab1.setClickable(false);

        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) fab2.getLayoutParams();

        layoutParams2.rightMargin+=-(int) (fab2.getWidth()*3.4);

        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(hideFab2);
        fab2.setClickable(true);

        CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) fab3.getLayoutParams();

        layoutParams3.rightMargin+=-(int) (fab3.getWidth()*4.8);

        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(hideFab3);
        fab3.setClickable(true);
    }
}
class ScrollingActivityEvents implements View.OnClickListener{

        ScrollingActivity scrollingActivity;
        boolean fabsVisible=false;
    public ScrollingActivityEvents(ScrollingActivity scrollingActivity){
        this.scrollingActivity = scrollingActivity;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.fab){
            if(!fabsVisible){
                scrollingActivity.showFabs();
            }
            else{
                scrollingActivity.hideFabs();
            }
            fabsVisible = !fabsVisible;

        }

    }
}
