package fr.eazyender.donjon.utils;

public class IEvent {
	
	private String name;
	private String description;
	private boolean isEnable;
	private int duration;
	
	public IEvent(String name, String description, int duration) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.isEnable = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}
