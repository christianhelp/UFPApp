package edu.utsa.cs3443.enk037_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import edu.utsa.cs3443.enk037_lab4.Controller.MainController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainController mainController = new MainController(this);
        Button ship1 = findViewById(R.id.USS_EnterpriseA);
        ship1.setOnClickListener(mainController);
        Button ship2 = findViewById(R.id.USS_EnterpriseD);
        ship2.setOnClickListener(mainController);
        Button ship3 = findViewById(R.id.USS_Voyager);
        ship3.setOnClickListener(mainController);
    }
}