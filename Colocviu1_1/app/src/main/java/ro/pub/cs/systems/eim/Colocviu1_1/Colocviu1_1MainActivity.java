package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
            if (savedInstanceState.containsKey(Constants.SAVED_SEQUENCE)) {
                textBox.setText(savedInstanceState.getString(Constants.SAVED_SEQUENCE));
            } else {
                textBox.setText("");
            }
            if (savedInstanceState.containsKey(String.valueOf(Constants.SAVED_COUNT))) {
                noPoints = Constants.SAVED_COUNT;
            } else {
                noPoints = 0;
            }
        } else {
            textBox.setText("");
            noPoints = 0;
        }




        Button northbtn = (Button) findViewById(R.id.north);
        northbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("North, ");
            }
        });
        Button southbtn = (Button) findViewById(R.id.south);
        southbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("South, ");
            }
        });
        Button eastbtn = (Button) findViewById(R.id.east);
        eastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("East, ");
            }
        });
        Button westbtn = (Button) findViewById(R.id.west);
        westbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.append("West, ");
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        TextView textBox = (TextView) findViewById(R.id.textView);
        savedInstanceState.putString(Constants.SAVED_SEQUENCE, textBox.getText().toString());
        savedInstanceState.putInt(String.valueOf(Constants.SAVED_COUNT), noPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView textBox = (TextView) findViewById(R.id.textView);
        if (savedInstanceState.containsKey(Constants.SAVED_SEQUENCE)) {
            textBox.setText(savedInstanceState.getString(Constants.SAVED_SEQUENCE));
        } else {
            textBox.setText("");
        }
        if (savedInstanceState.containsKey(String.valueOf(Constants.SAVED_COUNT))) {
            noPoints = Constants.SAVED_COUNT;
        } else {
            noPoints = 0;
        }
        Toast.makeText(getApplicationContext(),Constants.SAVED_SEQUENCE,Toast.LENGTH_SHORT).show();
    }
}