package edu.utsa.cs3443.enk037_lab4.Controller;

import android.content.Intent;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Objects;


import edu.utsa.cs3443.enk037_lab4.MainActivity;

import edu.utsa.cs3443.enk037_lab4.Model.CrewMember;
import edu.utsa.cs3443.enk037_lab4.Model.Fleet;
import edu.utsa.cs3443.enk037_lab4.Model.Starship;
import edu.utsa.cs3443.enk037_lab4.StarshipActivity;

public class StarshipController {

    private MainActivity mainActivity;
    private StarshipActivity starshipActivity;
    private Fleet fleet;
    private String shipName;
    private int shipID;
    public StarshipController(MainActivity mainActivity, String shipName, int shipID) throws IOException {
        this.shipID = shipID;
        this.setMainActivity(mainActivity);
        this.setFleet(new Fleet(mainActivity));
        this.setShipName(shipName);
    }
    public void shipDisplay(){
        Starship starship = determineship(shipName);
        Intent intent = new Intent(mainActivity, StarshipActivity.class);
        intent.putExtra("SHIPID",shipID);
        intent.putExtra("SHIPREGISTRY",starship.getRegistry());
        ArrayList<CrewMember> crewMemberArrayList = starship.getMembers();
        //Go back and put in For Loop;

        for(int i=1; i <= crewMemberArrayList.size();i++){

            intent.putExtra("PERSON".concat(Integer.toString(i)), new String[]{crewMemberArrayList.get(i-1).getName(), crewMemberArrayList.get(i-1).getPosition(),crewMemberArrayList.get(i-1).getRank()});

            String crewName = crewMemberArrayList.get(i-1).getName();
            int ind = crewName.lastIndexOf(" ");

            String lastName = (ind >=0) ? crewName.substring(ind+1): crewName;
            lastName = lastName.toLowerCase();

            lastName = (lastName.equals("forge")) ? "laforge": lastName;

            intent.putExtra("IMAGE".concat(Integer.toString(i)),lastName);
        }
        mainActivity.startActivity(intent);
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }
    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }


    public Starship determineship(String shipName){
        return (Objects.requireNonNull(fleet.getShips().get("NCC-1701-A")).getRegistry().equals(shipName)) ? fleet.getShips().get("NCC-1701-A"): (Objects.requireNonNull(fleet.getShips().get("NCC-1701-D")).getRegistry().equals(shipName)) ? fleet.getShips().get("NCC-1701-D"): fleet.getShips().get("NCC-74656");
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public StarshipActivity getStarshipActivity() {
        return starshipActivity;
    }

    public void setStarshipActivity(StarshipActivity starshipActivity) {
        this.starshipActivity = starshipActivity;
    }
}
