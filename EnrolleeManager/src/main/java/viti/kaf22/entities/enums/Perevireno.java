package viti.kaf22.entities.enums;

public enum Perevireno {
	None("Не перевірено"), Ready("Перевірено"), Error("Помилки");
	
	private String name;

	private Perevireno(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
