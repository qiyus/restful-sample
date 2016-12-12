package com.vigorx.business;

public class User {
	private String name;
	private String password;
	private int age;
	private Dept dept;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the dept
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @param dept
	 *            the dept to set
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
