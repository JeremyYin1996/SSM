package com.sqc.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.Category;
import com.sqc.bean.Drug;
import com.sqc.bean.DrugIndex;
import com.sqc.service.CategoryService;
//import cn.laosha.indices.service.CategoryService;
import com.sqc.utils.JsonResult;
import com.sqc.utils.Msg;
//import cn.laosha.indices.util.PageUtil;
import com.sqc.utils.PageUtil;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Resource
	private CategoryService categoryService;
	
	
	/**
	 * ������������������д����Ҫ��ʵ�������������Ϣ��
	 * @return
	 */
	@RequestMapping("/getClassifyByLarge")
	@ResponseBody
	public Msg getClassifyByLarge(){
		List<Category> classifybylarge=categoryService.getClassifyByLarge();
		return Msg.success().add("category", classifybylarge);
		
	}
	
	@RequestMapping("/getClassifyByMiddle")
	@ResponseBody
	public Msg getClassifyByMiddle(
			@RequestParam(value="classifybylargeId",required=false) String classifybylargeId)
{
		List<Category> classifybymiddle=categoryService.getClassifyByMiddle(classifybylargeId);
		return Msg.success().add("category", classifybymiddle);
		
	}
	
	@RequestMapping("/getClassifyBySmall")
	@ResponseBody
	public Msg getClassifyBySmall(
			@RequestParam(value="classifybymiddleId",required=false) String classifybymiddleId)
	
	{
		List<Category> classifybysmall=categoryService.getClassifyBySmall(classifybymiddleId);
		return Msg.success().add("category", classifybysmall);
		
	}
	
	
	@RequestMapping("/getClassifyByKinds")
	@ResponseBody
	public Msg getClassifyByKinds(
			@RequestParam(value="classifybysmallId",required=false) String classifybysmallId)
	
	{
		List<Category> classifybykinds=categoryService.getClassifyByKinds(classifybysmallId);
		return Msg.success().add("category", classifybykinds);
		
	}
	
	/**
	 * ��������Ϊ�������д����Ҫʵ�ַ���������ɾ���ġ�
	 * @param category
	 * @return
	 */
	
	//����new����
		@RequestMapping(value="/savenewcateg",method=RequestMethod.POST)
		@ResponseBody
		public Msg saveNewCateg(Category category){
			categoryService.saveNewCateg(category);
			System.out.println(category.getCategId());
			System.out.println(category.getCategName());
			System.out.println(category.getParentId());
			System.out.println(category.getLevel());
			
			return Msg.success();
		}
	
		@RequestMapping(value="/getCategInfo/{categid}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getCategInfo(@PathVariable("categid")String categid){
			System.out.println(categid);
			Category category=categoryService.getCategInfo(categid);
			
			return Msg.success().add("categ",category);
		}
		
		//��ȡ��maxcateg
		@RequestMapping(value="/getMaxCategId/{parentId}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getMaxCateg(@PathVariable("parentId") String parentId){
			String maxCategId=categoryService.getMaxCategId(parentId);
			/*System.out.println(maxCategId);*/
			
			
			int length=maxCategId.length();//����Ǵ��࣬����=1����������࣬����=3�������С�࣬����=5������Ǵ���Ʒ�࣬����=7��
			String str1=null;
			String str2=null;
			Integer maxNum;
			
			switch(length)
			{
			case 1:
			{
				System.out.println("�û�����Ӵ���");
				
			}	
			case 3:
			{
				str1=maxCategId.substring(0, 1);
				str2=maxCategId.substring(1, 3);
				maxNum=Integer.parseInt(str2)+1;
				if(maxNum<10)
					str2="0"+maxNum;
				else
					str2=""+maxNum;
				break;
				
			}
			case 5:
			{
				str1=maxCategId.substring(0, 3);
				str2=maxCategId.substring(3, 5);
				maxNum=Integer.parseInt(str2)+1;
				if(maxNum<10)
					str2="0"+maxNum;
				else
					str2=""+maxNum;
				break;
			}
				
			case 7:
			{
				str1=maxCategId.substring(0, 5);
				str2=maxCategId.substring(5, 7);
				maxNum=Integer.parseInt(str2)+1;
				if(maxNum<10)
					str2="0"+maxNum;
				else
					str2=""+maxNum;
				break;
			}
				
			default:
			{
				System.out.println("��ѯ�������~");
			}
				
			}
			
		
			String categId=str1+str2;
			 return Msg.success().add("categId",categId);
		}
		
		/*
		 * �ڷּ���ɾ��
		 * ���� ���� ����һ
		 * 
		 * ������1-2-3
		 * ������1
		 * */
		@ResponseBody
		@RequestMapping(value= "/categdel/{categIds}",method=RequestMethod.DELETE)
		public Msg deleteDrug(@PathVariable("categIds")String categIds){
			if (categIds.contains("-")){
				ArrayList<String> del_ids= new ArrayList<>();
				String[] str_ids = categIds.split("-");
				 for (String string : str_ids) {
					 del_ids.add(string);
				}
				 categoryService.deteleBatch(del_ids); 
			}else{
				String categId= categIds;
				categoryService.deleteCate(categId);
			}
			return Msg.success();
		}
		
		@RequestMapping(value="/updatecateg/{categId}",method=RequestMethod.PUT)
		@ResponseBody
		public Msg postUpdate(Category category){
			   categoryService.updateCateg(category);
	           return Msg.success();
			
		}
	
	/**
	 * ����������������д��ʵ�ַ���Ļ�����ѯ
	 * @param categId
	 * @return
	 */
	
	@RequestMapping("/getCategDetailById")
	@ResponseBody
	public Msg getCategDetailById(String categId){
		Category category= categoryService.getCategDetailById(categId);
		return Msg.success().add("category", category);
		
	}
	
	@ResponseBody
	@RequestMapping("/getCategories")
	public Msg getCategories(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="categName",required=false) String categName,
			@RequestParam(value="categLevel",required=false) String categLevel)
	{
		
		System.out.println("categName:"+categName);
		System.out.println("categLevel:"+categLevel);
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Category> categories = categoryService.getCategoriesByNameAndLevel
				(categName,categLevel);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categories, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@ResponseBody
	@RequestMapping("/getCategoriesByParentId")
	public Msg getCategoriesByParentId(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="parentId") String parentId
		)
	{
		
		System.out.println("parentId:"+parentId);
		
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Category> categories = categoryService.getCategoriesByParentId(parentId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categories, 5);
		return Msg.success().add("pageInfo", page);
	}


}
