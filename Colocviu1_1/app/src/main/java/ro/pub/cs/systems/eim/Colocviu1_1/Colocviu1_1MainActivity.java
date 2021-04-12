package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_1MainActivity extends AppCompatActivity {
    int noPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);
        TextView textBox = (TextView) findViewById(R.id.textView);

        if (savedInstanceState != null) {
            Log.d("TAG", "On saved in created");
            if (savedInstanceState.containsKey(Constants.SAVED_SEQUENCE)) {
                textBox.setText(savedInstanceState.getString(Constants.SAVED_SEQUENCE));
            } else {
                textBox.setText("");
            }
            if (savedInstanceState.containsKey(Constants.SAVED_COUNT)) {
                noPoints = savedInstanceState.getInt(Constants.SAVED_COUNT);
            } else {
                noPoints = 0;
            }
        } else {
            Log.d("TAG", "NOT On saved in created");
            textBox.setText("");
            noPoints = 0;
        }




        Button northbtn = (Button) findViewById(R.id.north);
        northbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("North, ");
                noPoints++;
            }
        });
        Button southbtn = (Button) findViewById(R.id.south);
        southbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("South, ");
                noPoints++;
            }
        });
        Button eastbtn = (Button) findViewById(R.id.east);
        eastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("East, ");
                noPoints++;
            }
        });
        Button westbtn = (Button) findViewById(R.id.west);
        westbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("West, ");
                noPoints++;
            }
        });

        Button nextAct = (Button) findViewById(R.id.secButton);
        nextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Colocviu1_1MainActivity.this, Colocviu1_1SecondaryActivity.class);
                myIntent.putExtra("key", "Vlues"); //Optional parameters
                Colocviu1_1MainActivity.this.startActivity(myIntent);
                noPoints = 0;
                textBox.setText("");
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView textBox = (TextView) findViewById(R.id.textView);
        savedInstanceState.putString(Constants.SAVED_SEQUENCE, textBox.getText().toString());
        savedInstanceState.putInt(Constants.SAVED_COUNT, noPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textBox = (TextView) findViewById(R.id.textView);
        if (savedInstanceState.containsKey(Constants.SAVED_SEQUENCE)) {
            textBox.setText(savedInstanceState.getString(Constants.SAVED_SEQUENCE));
        } else {
            textBox.setText("");
        }
        if (savedInstanceState.containsKey(Constants.SAVED_COUNT)) {
            noPoints = savedInstanceState.getInt(Constants.SAVED_COUNT);
        } else {
            noPoints = 0;
        }
        Log.d("TAG", "On restore invoked " + savedInstanceState.getInt(Constants.SAVED_COUNT));
        Toast.makeText(getApplicationContext(),Constants.SAVED_SEQUENCE,Toast.LENGTH_SHORT).show();
    }
}