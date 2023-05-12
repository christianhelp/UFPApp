package edu.utsa.cs3443.enk037_lab4;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class StarshipActivity extends AppCompatActivity {
    TextView starShipText;
    TextView[] textViews = new TextView[8];
    int[] textResources = {R.id.personnel1,R.id.personnel2,R.id.personnel3,R.id.personnel4,R.id.personnel5,R.id.personnel6,R.id.personnel7,R.id.personnel8};
    int[] imageResources = {R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5,R.id.image6,R.id.image7,R.id.image8};
    int[] textsToDisplay = {R.string.Personnel1,R.string.Personnel2,R.string.Personnel3,R.string.Personnel4,R.string.Personnel5,R.string.Personnel6,R.string.Personnel7,R.string.Personnel8};
    ImageView[] imageViews = new ImageView[8];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);
        starShipText = findViewById(R.id.question_text_view);

        Intent intent = getIntent();
        setStarShipText(intent.getIntExtra("SHIPID",R.string.USS_EnterpriseACalled));
        String packageName = this.getPackageName();
        for(int i = 1; i<= textViews.length;i++){
            //Sets up textView
            textViews[i-1] = findViewById(textResources[i-1]);
            String[] person = intent.getStringArrayExtra("PERSON".concat(Integer.toString(i)));
            setPersonnel(textViews[i-1],textsToDisplay[i-1], person[1],person[2],person[0]);

            //Sets up imageviews
            imageViews[i-1] = findViewById(imageResources[i-1]);
            String name = intent.getStringExtra("IMAGE".concat(Integer.toString(i)));

            int res = this.getResources().getIdentifier(name,"drawable",packageName);
            System.out.println("Res:"+res+"Versus:"+R.drawable.kirk);
            imageViews[i-1].setImageResource(res);
        }
    }
    public void setStarShipText(int ResId) { starShipText.setText(ResId); }
    public void setPersonnel(TextView textView, int ID, String position, String rank,String name ){
        textView.setText(getString(ID,position,rank,name));
    }
}