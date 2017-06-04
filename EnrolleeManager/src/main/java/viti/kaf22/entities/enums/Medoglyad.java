package viti.kaf22.entities.enums;

public enum Medoglyad {
	None("Не розпочато"), Ready("Пройдено"), Failed("Провалено");
	
	private String name;

	private Medoglyad(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
