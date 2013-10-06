package de.cimdata.data;

public class Workout {
	
	static {
		types = new String[4];
		types[0] = "Laufen";
		types[1] = "Radfahren";
		types[2] = "Schwimmen";
		types[3] = "BodyPump";
		
		fierce = new String[4];
		fierce[0] = "Aktive Entspannung";
		fierce[1] = "Locker, aber entschlossen";
		fierce[2] = "Wirklich ENTSCHLOSSEN";
		fierce[3] = "Erschöpfend bis schmerzhaft";
		
	}
	
	private String name;
	private String duration;
	private String pulse;
	private String type;
	private final static String[] fierce;
	private final static String[] types; 
	

	
}
