/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����10:44:32
 */

package com.yunsi;

public class Printer { 
 	private String inkColor;
 	private String paperStyle;
 	
	public String getInkColor() {
		return inkColor;
	}
	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}
	public String getPaperStyle() {
		return paperStyle;
	}
	public void setPaperStyle(String paperStyle) {
		this.paperStyle = paperStyle;
	}
	String content;
	public void print(String inkColor,String paperStyle,String content){
		System.out.println("��ӡ������" + inkColor + "��" + paperStyle + "ֽ�ϴ�ӡ��"+content);
	}
	
}
