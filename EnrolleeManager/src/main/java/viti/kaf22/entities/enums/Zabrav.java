package viti.kaf22.entities.enums;

public enum Zabrav {
	None("В наявності"), Zabrav("Забрав");
	
	private String name;

	private Zabrav(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
