package ro.pub.cs.systems.eim.Colocviu1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);

        Button cancelbtn = (Button) findViewById(R.id.cancelBtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Colocviu1_1SecondaryActivity.this, Colocviu1_1MainActivity.class);
                myIntent.putExtra("key", "Vlues"); //Optional parameters
                Colocviu1_1SecondaryActivity.this.startActivity(myIntent);
                Toast.makeText(getApplicationContext(),"Pressed Cancel",Toast.LENGTH_SHORT).show();
            }
        });

        Button registerbtn = (Button) findViewById(R.id.registerBtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Colocviu1_1SecondaryActivity.this, Colocviu1_1MainActivity.class);
                myIntent.putExtra("key", "Vlues"); //Optional parameters
                Colocviu1_1SecondaryActivity.this.startActivity(myIntent);
                Toast.makeText(getApplicationContext(),"Pressed Register",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
