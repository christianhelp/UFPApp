package edu.utsa.cs3443.enk037_lab4.Controller;

import android.view.View;

import java.io.IOException;


import edu.utsa.cs3443.enk037_lab4.MainActivity;

import edu.utsa.cs3443.enk037_lab4.R;



public class MainController implements View.OnClickListener{
    private MainActivity mainActivity;

    public MainController(MainActivity mainActivity){
        this.setMainActivity(mainActivity);
    }
    //Determine by ID which ship to throw into our starShipController
    @Override
    public void onClick(View view) {
        try {
            StarshipController shipController = new StarshipController(mainActivity,determineShip(view.getId()),determineShipID(view.getId()));
            shipController.shipDisplay();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    public String determineShip(int ID){
        return (ID == R.id.USS_EnterpriseA) ? "NCC-1701-A" : (ID == R.id.USS_EnterpriseD) ? "NCC-1701-D" : "NCC-74656";
    }
    public int determineShipID(int ID){
        return (ID == R.id.USS_EnterpriseA) ? R.string.USS_EnterpriseACalled : (ID == R.id.USS_EnterpriseD) ? R.string.USS_EnterpriseDCalled : R.string.USS_VoyagerCalled;
    }

}
