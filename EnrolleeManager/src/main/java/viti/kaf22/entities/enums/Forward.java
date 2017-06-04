package viti.kaf22.entities.enums;

public enum Forward {
	
	INSTITUTE("ВІТІ"), COLLEGE("ВКСС");
	
	private String name;

	private Forward(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	
}
