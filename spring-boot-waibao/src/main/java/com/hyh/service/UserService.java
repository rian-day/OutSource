package com.hyh.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.entity.UserInfo;
import com.hyh.repository.UserInfoDao;



@Service
public class UserService {
	private static String []suffix_arr={"gif","jpg","jpeg","png","bmp","tif","tiff"};
	static Logger log = Logger.getLogger (UserService.class.getName ());
	 /**
	 * 文件上传根目录(在Spring的application.yml的配置文件中配置):<br>
	 * web:
	 *  upload-path: （jar包所在目录）/resources/static/
	 */
	 @Value("${web.upload-path}")
	 private String webUploadPath;
	 @Resource
	 UserInfoDao userdao;
	 
	public String UploadUserHead(MultipartFile file,int userId){
//		int suffix_position=fileName.lastIndexOf(".");
//		String suffix=fileName.substring(suffix_position,fileName.length());
//		if(leagal(suffix)){
//			
//		}
		if (!file.isEmpty()) {
			  if (file.getContentType().contains("image")) {
				  //String path=this.getClass().getResource("/src").getPath();
				  String path=ClassUtils.getDefaultClassLoader().getResource("").getPath();
				  log.error(path);
				  path=path.replace("/target/classes/", "");
			  try {
			   // 获取图片的文件名
			   String fileName = file.getOriginalFilename();
			   // 获取图片的扩展名
			   int suffix_position=fileName.lastIndexOf(".");
			   String extensionName = fileName.substring(suffix_position,fileName.length());
			   // 新的图片文件名 = 获取时间戳+"."图片扩展名
			   String newFileName = 
					   //String.valueOf(System.currentTimeMillis()) 获取时间(精准到秒)
					   "userHead" + extensionName;
			   // 数据库保存的目录
			   //String datdDirectory = temp.concat(String.valueOf(userId)).concat(File.separator);
			   // 文件路径
			   String filePath = path.concat(webUploadPath);
			   log.warn(filePath);
			   log.warn(newFileName);
			   File dest = new File(filePath, newFileName);
			   if (!dest.getParentFile().exists()) {
			   dest.getParentFile().mkdirs();
			   }
			   //dest.createNewFile();
			   //判断是否有旧头像，如果有就先删除旧头像，再上传
//			   UserInfo userInfo = sUserService.findUserInfo(userId.toString());
//			   if (StringUtils.isNotBlank(userInfo.getUserHead())) {
//			   String oldFilePath = webUploadPath.concat(userInfo.getUserHead());
//			   File oldFile = new File(oldFilePath);
//			   if (oldFile.exists()) {
//			    oldFile.delete();
//			   }
			   
//			   }
			   // 上传到指定目录
			   file.transferTo(dest);
			 
			   // 将图片流转换进行BASE64加码
			   //BASE64Encoder encoder = new BASE64Encoder();
			   //String data = encoder.encode(file.getBytes());
			 
			   // 将反斜杠转换为正斜杠
//			   String data = datdDirectory.replaceAll("\\\\", "/") + newFileName;
//			   Map<String, Object> resultMap = new HashMap<>();
//			   resultMap.put("file", data);
			   //resultVo.setData(resultMap);
			   //resultVo.setError(1, "上传成功!");
			  } catch (Exception e) {
			   //resultVo.setError(0, "上传失败!");
			  }
			  } else {
			  //resultVo.setError(0, "上传的文件不是图片类型，请重新上传!");
			  }
			  //return resultVo;
			 } else {
//			  resultVo.setError(0, "上传失败，请选择要上传的图片!");
//			  return resultVo;
			 }
		return "";
	}
	
	public boolean leagal(String suffix){
		for(int i=0;i<suffix_arr.length;i++){
			if(suffix.equals(suffix_arr[i]))
				return true;
		}
		return false;
	}
}
