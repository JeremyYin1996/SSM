/**
 * @author Jeremy
 * @date 2019-1-2
 * @time ионГ11:01:35
 */

package com.yunsi;

public abstract class Animal {
	String name;
	int age;

	public Animal() {
		super();
	}
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	public abstract void eat();
	
	public void introduce(String name,int age) {
		this.name = name;
		this.age = age;
		System.out.println(""+name+age+"");
	}
	
}
