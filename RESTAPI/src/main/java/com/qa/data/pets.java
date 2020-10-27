package com.qa.data;

public class pets {
	int petId;
	String name;
	String status;
	
	public pets(){
		
	}
	
	public pets(int petId, String name, String status){
		this.petId=petId;
		this.name=name;
		this.status=status;
		
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
	
	
	
}
