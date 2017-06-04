package viti.kaf22.entities.enums;

public enum FizPidgotovka {
	None("Не розпочато"), Ready("Пройдено"), Failed("Провалено");
	
	private String name;

	private FizPidgotovka(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
