/**
 * @author Jeremy
 * @date 2019-1-2
 * @time 上午11:02:23
 */

package com.yunsi;

public class Dog extends Animal implements Show {
	/*public Dog() {
		super();
		System.out.println("测试");
	}*/

	public void eat() {
		System.out.println("恰饭");
	}

	@Override
	public void introduce() {
		System.out.println("我是旺财");
		
	}

	@Override
	public void dance() {
		
		
	}
}
