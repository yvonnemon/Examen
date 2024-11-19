package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);
        if (toolbar == null) {
            Log.e("MainActivity", "Toolbar is null");
        } else {
            setSupportActionBar(toolbar);
        }

        System.out.println("ashdajkkcjnknajkdnjkandvavsb");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment fragment1 = new Fragment1();
        Fragment fragment2 = new Fragment2();
        Fragment fragment3 = new Fragment3();


        Log.d("SecondActivity", "Adding fragments to containers.");
        // Add the fragments to the appropriate containers
        transaction.add(R.id.fragmentContainer1, fragment1);
        transaction.add(R.id.fragmentContainer2, fragment2);
        transaction.add(R.id.fragmentContainer3, fragment3);

        transaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);  // Inflates the menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.smile) {
            // Navigate to Activity 1 when Button 1 is clicked
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            return true;
        } else if (id == R.id.moon) {
            // Navigate to Activity 2 when Button 2 is clicked

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
