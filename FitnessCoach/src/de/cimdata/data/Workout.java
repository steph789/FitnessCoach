package de.cimdata.data;

public class Workout {
	
	private String name;
	private String duration;
	private String pulse;
	private String type;
	private final static String[] fierce;
	private final static String[] types; 
	
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

	public String getName() {
		return name;
	}

	public String getDuration() {
		return duration;
	}

	public String getPulse() {
		return pulse;
	}

	public String getType() {
		return type;
	}

	public static String[] getFierce() {
		return fierce;
	}

	public static String[] getTypes() {
		return types;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
