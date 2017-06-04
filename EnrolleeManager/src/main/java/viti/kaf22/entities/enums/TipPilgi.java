package viti.kaf22.entities.enums;

public enum TipPilgi {

	PozaCherg("Позачергове"), PershoCherg("Першочергове"), None("Не класіфіковано");
	
	private String name;

	private TipPilgi(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
