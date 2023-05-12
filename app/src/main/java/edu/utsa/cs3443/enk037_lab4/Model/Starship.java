package edu.utsa.cs3443.enk037_lab4.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
/**
 * Starship is a java class that contains a constructor for the class along with a toString method and functions to attain and assign helpful information in the broader project
 * The toString method of this class will be used to call CrewMember's toString
 * @author Christian Walker (enk037)
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class Starship {
	private String name, registry, starShipClass;
	private ArrayList<CrewMember> members;
	
	/**
	 * @param name, @param registry, @param starShipClass. Sets all of the inputted parameters needed to construct the object excluding the assignment
	 */
	public Starship(String name, String registry, String starShipClass) {
		this.setName(name);
		this.setRegistry(registry);
		this.setStarShipClass(starShipClass);
		this.setMembers();
	}
	/**
	 * @return the string representation of the starship object
	 */
	@NonNull
	public String toString() {
		String ret =  getName() +", " + getStarShipClass() + ". Registry: " + getRegistry() + "\n" + this.members.size() + " crew members assigned.\n";
		for(CrewMember member: this.members) {
			ret = ret.concat(member.toString());
		}
		return ret + "\n";
	}
	/**
	 * @param member adds member to the starShip
	 */
	public void addCrewMember(CrewMember member) {
		this.members.add(member);
	}
	/**
	 * @return the number of crewMember objects in the list
	 */
	public int getNumberOfPersonnel() {
		return this.members.size();
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
	 * @return the registry
	 */
	public String getRegistry() {
		return registry;
	}
	/**
	 * @param registry the registry to set
	 */
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	/**
	 * @return the starShipClass
	 */
	public String getStarShipClass() {
		return starShipClass;
	}
	/**
	 * @param starShipClass the starShipClass to set
	 */
	public void setStarShipClass(String starShipClass) {
		this.starShipClass = starShipClass;
	}
	/**
	 * Initializes the arraylist...pretty straightforward tbh 
	 */
	public void setMembers() {
		this.members = new ArrayList<>();
	}
	/**
	 * @return the ArrayList of Crew Members
	 */
	public ArrayList<CrewMember> getMembers(){
		return this.members;
	}
}
