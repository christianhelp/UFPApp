package edu.utsa.cs3443.enk037_lab4.Model;

import androidx.annotation.NonNull;

/**
 * CrewMember is a java class that has two different constructors conditional upon the parameters provided by the user
 * The class contains a toString Method to be called by Starship (another java class) and contains the appropriate getters and setters 
 * 
 * @author Christian Walker (enk037)
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */

public class CrewMember {
	private String name, position, rank, species, registry;

	/**
	 * @param name, @param position, @param rank, @param species, @param assignment Sets all of the inputted parameters needed to construct the object
	 */
	public CrewMember(String name, String position, String rank, String registry,String species) {
		this.setName(name);
		this.setPosition(position);
		this.setRank(rank);
		this.setSpecies(species);
		this.setAssignment(registry);
		
	}
	/**
	 * @return the string representation of the CrewMember object
	 * Contains a ternary operator to determine which constructor was called in order to return the appropriate information
	 */
	@NonNull
	public String toString() {
		return " - "+ getName() + " (" + getRank() + ") " + "- " + getPosition() + " [" + getSpecies() + "]- " + getRegistry() + "\n";
									
		//return  " - "+ getName() + " (" + getRank() + ") " + "- " + getPosition() + " [" + getSpecies() + "]\n";
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
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the registry
	 */
	public String getRegistry() {
		return registry;
	}

	/**
	 * @param registry the aasignment to set
	 */
	public void setAssignment(String registry) {
		this.registry = registry;
	}
}
