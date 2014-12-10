package com.theateamiu.barobazar.model;

public class Manager {
	private String name;
	private String phoneNo;
	private String email;
	private String imageUri;
	private int age;
	private String address;
	private long managerialId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getManagerialId() {
		return managerialId;
	}

	public void setManagerialId(long managerialId) {
		this.managerialId = managerialId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
