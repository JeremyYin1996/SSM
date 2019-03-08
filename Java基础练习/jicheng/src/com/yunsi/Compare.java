/**
 * @author Jeremy
 * @date 2019-1-2
 * @time 下午1:40:37
 */

package com.yunsi;

public class Compare {
	public static void main(String[] args) {
		Person person1 =new Person();
		person1.setName("111");
		person1.setAge(24);
		Person person2 =new Person();
		person2.setName("122");
		person2.setAge(24);
		boolean com =  person1.compare(person2);
		System.out.println(com?"两个人是同龄人":"年龄不同");
	}
	
}
