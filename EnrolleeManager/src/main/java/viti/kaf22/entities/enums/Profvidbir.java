package viti.kaf22.entities.enums;

public enum Profvidbir {
	None("Не розпочато"), Ready("Пройдено"), Failed("Провалено");
	
	private String name;

	private Profvidbir(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
