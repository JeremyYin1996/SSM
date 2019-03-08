package com.sqc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.springframework.stereotype.Service;

import com.sqc.bean.Temp;
import com.sqc.bean.TempExample;
import com.sqc.bean.TempExample.Criteria;
import com.sqc.dao.TempMapper;

@Service
public class ExcelService {
	
	@Resource
	TempMapper tempMapper;
	/*
	 * json格式：
	 * 	[{sheetName:表格名称,headers:[],rows:[]}
	 * 	{sheetName:表格名称,headers:["列名1","列名2"....],rows:["列数据1","列数据2".....]}
	 * ]
	 */
	@SuppressWarnings("deprecation")
	public String parseExcel(File outFile) {
		HSSFWorkbook  wb = null;
		StringBuilder buff = new StringBuilder("[");
		try {
			InputStream in = new FileInputStream(outFile);
			wb = new HSSFWorkbook(in);
			
			Iterator<Sheet> itSheet = wb.sheetIterator();
			//Iterator<HSSFSheet> itSheet = wb.sheetIterator();
			boolean sheetStart = false;
			while(itSheet.hasNext()){
				Sheet sheet = itSheet.next();
				//HSSFSheet sheet = itSheet.next();
				sheetStart = true;
				String sheetName = sheet.getSheetName();
				buff.append("{");
				buff.append("\"sheetName\":\"").append(sheetName).append("\",");
				int firstRowNum = sheet.getFirstRowNum();
				Row firstRow = sheet.getRow(firstRowNum);
				buff.append("\"headers\":[");
				
				//System.out.println(buff);
				
				if(firstRow!=null){
					//处理表格头部
					int cellNum = 0;
					Iterator<Cell> itCell = firstRow.cellIterator();				
					boolean cellStart = false;
					while(itCell.hasNext()){
						Cell cell = itCell.next();
						
						buff.append("\"").append(cell.getStringCellValue()).append("\"");
						buff.append(",");
						cellStart = true;
						cellNum++;
					}
					if(cellStart){
						buff.deleteCharAt(buff.length()-1);
					}
					buff.append("]");
					//System.out.println(buff);
					//处理里面的内容
					buff.append(",\"rows\":[");
					for(int i=firstRowNum+1;i<=sheet.getLastRowNum();i++){
						Row r = sheet.getRow(i);
						//HSSFRow r = sheet.getRow(i);
						if(r==null){
							continue;
						}
						buff.append("[");
						for(int j=0;j<cellNum;j++){
							Cell cell = r.getCell(j);
							//HSSFCell cell = r.getCell(j);
							String cellValue = null;
							if(cell!=null){
								//cell.getCellStyle();
										
								switch(cell.getCellTypeEnum()){
									case NUMERIC: 
									{
										if(DateUtil.isCellDateFormatted(cell))
										{
											Date date = cell.getDateCellValue();
											DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
											cellValue = formater.format(date);
											//cellValue=NumberToTextConverter.toText(cell.getDateCellValue());
										}
											
										else
											cellValue =NumberToTextConverter.toText(cell.getNumericCellValue());
										break;
									}
									case BOOLEAN:
										cellValue = String.valueOf(cell.getBooleanCellValue());break;
									case STRING:
										cellValue = cell.getStringCellValue();break;
									case _NONE:
										cellValue="none";
									case FORMULA:
										cellValue="none";
								}
							}else{
								cellValue = "";
							}
							buff.append("\"").append(cellValue).append("\"");
							if(j<cellNum-1){
								buff.append(",");
							}
						}
						buff.append("]");
						if(i<sheet.getLastRowNum()){
							buff.append(",");
						}
					}
				}
				buff.append("]");
				buff.append("}");
				buff.append(",");//下一个sheet
			}
			if(sheetStart){
				buff.deleteCharAt(buff.length()-1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(wb!=null ){
				try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		buff.append("]");
		return buff.toString();
	}

	public List<Temp> getTempSalesByPharmIdAndStatisDate(String pharmId, Date statisDate) {
		
		TempExample example=null;
		if((pharmId!=null && pharmId.trim()!="") )
		{
			example=new TempExample();
			Criteria criteria=example.createCriteria();
			criteria.andPharmIdEqualTo(pharmId);
			if(statisDate!=null)
				criteria.andStatisDateEqualTo(statisDate);
			
		}

		return tempMapper.selectByExample(example);
	}

	public Integer maxIdFromTemp() {
		
		Integer maxId= tempMapper.selectMaxId();
		System.out.println("service:"+maxId);
		//maxId=maxId+1;
		tempMapper.alterAutoIncrement(maxId+1);
		System.out.println("service:"+maxId);
		return maxId;//返回的是当前最大的id值+1，这样下一次插入时，自增的id就会变为maxId的值。
	}

	public Temp getTempById(Long id) {
		// TODO Auto-generated method stub
		return tempMapper.selectByPrimaryKey(id);
	}

	public void updateTemp(Temp temp) {
		tempMapper.updateByPrimaryKeySelective(temp);
		
	}


	/**
	 *根据id删除销售数据
	 * @param id
	 */

	public void deleteTemp(Long id) {
		tempMapper.deleteByPrimaryKey(id);
		
	}
	
	/**
	 *根据id 批量删除销售数据
	 * @param id
	 */
	
	
	public void deleteTempBatch(List<Long> del_ids) {
		TempExample example=new TempExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdIn(del_ids);
		tempMapper.deleteByExample(example);
		
	}
	
	
	
}
