/**
 * @author Jeremy
 * @date 2019-1-2
 * @time ����11:02:23
 */

package com.yunsi;

public class Dog extends Animal implements Show {
	/*public Dog() {
		super();
		System.out.println("����");
	}*/

	public void eat() {
		System.out.println("ǡ��");
	}

	@Override
	public void introduce() {
		System.out.println("��������");
		
	}

	@Override
	public void dance() {
		
		
	}
}
