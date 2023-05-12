package edu.utsa.cs3443.enk037_lab4.Model;

import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import edu.utsa.cs3443.enk037_lab4.MainActivity;
/**
 * Fleet is a java class that contains a construtor for the class along with a toString method and functions to attain and assign helpful information in the broader project
 * @author Christian Walker (enk037)
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class Fleet {
	private String name;
	private HashMap<String,Starship> ships;

	/**
	 * @param mainActivity Sets all of the inputted parameters needed to construct the object excluding the assignment
	 */
	public Fleet(MainActivity mainActivity) throws IOException {
		this.setShips(new HashMap<>());
		this.loadStarships(mainActivity);

	}
	/**
	 * @return the number of ship objects in our Fleet
	 */
	public int getSizeOfFleet() {
		return this.ships.size();
	}
	/**
	 * @param ship a ship object to add to the ArrayList
	 */
	public void addStarShip(String name,Starship ship) {
		this.ships.put(name, ship);
	}

	/**
	 * @return the string that represents the entire fleet utilizing the toString functions of the Starship class
	 */
	@NonNull
	public String toString() {
		String ret = "---------------------------- \n"
				+ "United Federation of Planets\n"
				+ "---------------------------- \n";
		for(Map.Entry<String,Starship> iterator: ships.entrySet()) {
			ret = ret.concat(iterator.toString());
		}
		return ret;
	}
	/**
	 *
	 */
	public void loadStarships( MainActivity mainActivity ) throws IOException {
		AssetManager am = mainActivity.getAssets();
		InputStream fleetStream = am.open("fleet.csv");
		InputStream personnelStream = am.open("personnel.csv");
		Scanner fleetScan = new Scanner(fleetStream);

		while (fleetScan.hasNextLine()){
			String[] parseData = fleetScan.nextLine().split(",");
			if(parseData[1].equals("NCC-1701-A") || parseData[1].equals("NCC-1701-D") || parseData[1].equals("NCC-74656")){
				Starship tempShip = new Starship(parseData[0],parseData[1],parseData[2]);
				addStarShip(parseData[1], tempShip);
			}
		}
		fleetScan.close();
		//System.out.println("Closed");
		Scanner personScan = new Scanner(personnelStream);
		//System.out.println(ships);
		while (personScan.hasNextLine()) {
			String[] data = personScan.nextLine().split(",");
			CrewMember tempMember = new CrewMember(data[0], data[1], data[2], data[3], data[4]);
			Objects.requireNonNull(ships.get(tempMember.getRegistry())).addCrewMember(tempMember);
			/*
			if (ships.get("NCC-1701-A").getRegistry().equals(tempMember.getRegistry()))
				ships.get("NCC-1701-A").addCrewMember(tempMember);
			else if(ships.get("NCC-1701-D").getRegistry().equals(tempMember.getRegistry()))
				ships.get("NCC-1701-D").addCrewMember(tempMember);
			else
				ships.get("NCC-74656").addCrewMember(tempMember);
		}
		*/
		}
		personScan.close();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ships
	 */
	public  HashMap<String,Starship> getShips() {
		return ships;
	}
	/**
	 * @param ships the ships to set
	 */
	public void setShips(HashMap<String,Starship> ships) {
		this.ships = ships;
	}

	
}
