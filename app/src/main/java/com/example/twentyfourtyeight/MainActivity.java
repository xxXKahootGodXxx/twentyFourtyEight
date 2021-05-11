package com.example.twentyfourtyeight;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View mView;
    private Grid grid = new Grid();
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //display = (TextView) findViewById(R.id.textview_testing);
        display = (TextView) findViewById(R.id.please_work);
        //display.setText(grid.toString());
        //display.setText("this works");
        grid.addRandom();
        setSupportActionBar(toolbar);
        //no
        //testing branch
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });



        mView = findViewById(R.id.swiping_test);
        mView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                grid.moveUp(true);
                grid.addRandom();
                //display.setText(grid.toString());
                Toast.makeText(MainActivity.this, "up", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                grid.moveRight(true);
                grid.addRandom();
                //display.setText(grid.toString());
            }
            public void onSwipeLeft() {
                grid.moveLeft(true);
                grid.addRandom();
                //display.setText(grid.toString());
            }
            public void onSwipeBottom() {
                grid.moveDown(true);
                grid.addRandom();
                //display.setText(grid.toString());

            }

        });
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