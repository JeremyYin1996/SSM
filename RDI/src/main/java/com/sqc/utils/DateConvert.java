package com.sqc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert  implements Converter<String, Date>{
	
	/**
	 * ȫ�����ڴ�����
	 * Convert<T,S>
	 *         ����T:����ͻ����ύ�Ĳ��� String
	 *         ����S:ͨ��convertת��������
	   
	 */
	
	    @Override
	    public Date convert(String stringDate) {
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return simpleDateFormat.parse(stringDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
	  

	}

}
