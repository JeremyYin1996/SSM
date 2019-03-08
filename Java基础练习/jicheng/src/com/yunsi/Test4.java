/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ионГ11:03:48
 */

package com.yunsi;

import java.util.Scanner;

public class Test4 {
	static String paper;
	static String ink;
	
	public static void main(String[] args) {
		A4 a4 = new A4();
		B5 b5 = new B5();
		Black black = new Black();
		Color color = new Color();
		Printer printer = new Printer();
		printer.print(a4.paper(), color.ink(),"1234567");
	}
}
