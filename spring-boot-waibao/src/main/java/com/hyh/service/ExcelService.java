package com.hyh.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.bean.UserKnowledgeBase;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectOptions;
import com.hyh.utils.ExcelImportUtils;

@Service
public class ExcelService {
	
	/** 
	 * 上传excel文件到临时目录后并开始解析 
	 * @param fileName 
	 * @param file 
	 * @param userName 
	 * @return 
	 */  
	public List<Subject> batchImport(
			String fileName
			,MultipartFile mfile
			//,String userName
			){  
	      
	       File uploadDir = new  File("E:\\fileupload");  
	       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）  
	       if (!uploadDir.exists()) 
	    	   uploadDir.mkdirs();  
	       //新建一个文件  
	       File tempFile = new File("E:\\fileupload\\" + new Date().getTime() + ".xlsx");   
	       //初始化输入流  
	       InputStream is = null;    
	       try{  
	           //将上传的文件写入新建的文件中  
	           mfile.transferTo(tempFile);  
	             
	           //根据新建的文件实例化输入流  
	           is = new FileInputStream(tempFile);  
	             
	           //根据版本选择创建Workbook的方式  
	           Workbook wb = null;  
	           //根据文件名判断文件是2003版本还是2007版本  
	           if(ExcelImportUtils.isExcel2007(fileName)){  
	              wb = new XSSFWorkbook(is);   
	           }else{  
	              wb = new HSSFWorkbook(is);   
	           }  
	           //根据excel里面的内容读取知识库信息  
	           return readExcelValue(wb
	        		   //,userName
	        		   ,tempFile);  
	      }catch(Exception e){  
	          e.printStackTrace();  
	      } finally{  
	          if(is !=null)  
	          {  
	              try{  
	                  is.close();  
	              }catch(IOException e){  
	                  is = null;      
	                  e.printStackTrace();    
	              }  
	          }  
	      }  
	       return "导入出错！请检查数据格式！";  
	   }  
	  
	  
	/** 
	   * 解析Excel里面的数据 
	   * @param wb 
	   * @return 
	   */  
	  private List<Subject> readExcelValue(Workbook wb
			  //,String userName
			  ,File tempFile){  
	        
	       //错误信息接收器  
	       String errorMsg = "";  
	       //得到第一个shell    
	       Sheet sheet=wb.getSheetAt(0);  
	       
	       //得到Excel的行数  
	       int totalRows=sheet.getPhysicalNumberOfRows();  
	       //总列数  
	       int totalCells = 0;   
	       //得到Excel的列数(前提是有行数)，从第二行算起  
	       if(totalRows>=2 && sheet.getRow(1) != null){  
	            totalCells=sheet.getRow(1).getPhysicalNumberOfCells();  
	       }  else{
	    	   errorMsg+="表内没有数据";
	       }

	         
	       String br = "<br/>";  
	       List<Subject> list = null;
	         
	       //循环Excel行数,从第二行开始。标题不入库  
	       for(int r=1;r<totalRows;r++){  
	           String rowMessage = "";  
	           Row row = sheet.getRow(r);  
	           if (row == null){  
	               errorMsg += br+"第"+(r+1)+"行数据有问题，请仔细检查！";  
	               continue;  
	           }  
	             
	           String question = "";  
	           String answer = "";  
	           String type="";
	           int count=0;
	           String []menu={"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	             
	           //循环Excel的列  
	           //创建实体类
	           Subject subject=new Subject();
	           for(int c = 0; c <totalCells; c++){  
	               Cell cell = row.getCell(c);  
	               if (null != cell){ 
	            	   if(c>3){
	                	   SubjectOptions option=new SubjectOptions();
	                	   option.setOptionName(menu[count]);
	                	   option.setContent(cell.getStringCellValue());
	                	   subject.addOption(option);
	                	   count++;
	                   } else if(c==0){  
	                	   //第一列题目类型
	                       type=cell.getStringCellValue();
	                       if(StringUtils.isEmpty(question)){  
	                           rowMessage += "类别不能为空；";  
	                       }else if(question.length()>10){  
	                           rowMessage += "类别的字数不能超过10；";  
	                       }  
	                       subject.setType(type); 
	                   }else if(c==1){ 
	                       question = cell.getStringCellValue();  
	                       if(StringUtils.isEmpty(answer)){  
	                           rowMessage += "题目不能为空；";  
	                       }else if(answer.length()>225){  
	                           rowMessage += "题目的字数不能超过225；";  
	                       }  
	                       subject.setContent(question);
	                   }else if(c==2){
	                	   answer = cell.getStringCellValue(); 
	                	   String []answers=answer.split("");
	                	   subject.setRealAnswer(answers);
	                   }else if(c==3){
	                	   String tip=cell.getStringCellValue();
	                	   subject.setTip(tip);
	                   }
	               }else{  
	                   rowMessage += "第"+(c+1)+"列数据有问题，请仔细检查；";  
	               }  
	               count=0;
	           }  
	           //拼接每行的错误提示  
	           if(!StringUtils.isEmpty(rowMessage)){  
	               errorMsg += br+"第"+(r+1)+"行，"+rowMessage;  
	           }
	           list.add(subject);
	       }  
	         
	       //删除上传的临时文件  
	       if(tempFile.exists()){  
	           tempFile.delete();  
	       }  
	         
	       
	       //全部数据集合
	       //userKnowledgeBaseList
	       //全部验证通过才导入到数据库  
//	       if(StringUtils.isEmpty(errorMsg)){  
//	           for(UserKnowledgeBase userKnowledgeBase : userKnowledgeBaseList){  
//	               this.saveUserKnowledge(userKnowledgeBase, userName);  
//	           }  
//	           errorMsg = "导入成功，共"+userKnowledgeBaseList.size()+"条数据！";  
//	       }  
	       
	       return list;
	  }  
}
