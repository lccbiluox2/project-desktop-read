package cn.biluo.daoRu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileToMybook {
	
	  public static  boolean copy_file(String sourceFileName,String targetFileName,boolean overlay){
		  File srcFile = new File(sourceFileName);
		  if(!srcFile.exists()){
			  System.out.println("文件存在");
			  return false;
		  }else if(!srcFile.isFile()){
			  System.out.println("不是文件");
			  return false;
		  }
		  System.out.println(targetFileName);
		  File targetFile = new File(targetFileName);
		  System.out.println("-------"+targetFile);
		  if(targetFile.exists()){
			  System.out.println("目标文件存在");
			  if(overlay){
				  System.out.println("是否覆盖");
				  if(!deleteAnyone(targetFileName)){
					  System.out.println("删除目标文件成功");
					  return false;
				  }
			  }else{
				  System.out.println("删除目标文件失败");
				  return false;
			  }
		  }else{
			  System.out.println("目标文件不存在");
			  if(!targetFile.getParentFile().exists()){
				  System.out.println("目标文件所在父目录不存在");
				  if(!targetFile.getParentFile().mkdirs()){
					  System.out.println("目标文件所在父目录创建失败");
					  return false;
				  }
			  }
			 System.out.println("开始移动文件");
			  int byteread = 0;
			  InputStream in =null;
			  OutputStream out = null;
			  try{
				  in = new FileInputStream(srcFile);
				  out = new FileOutputStream(targetFile);
				  byte[] buffer = new byte[1024];
				  while((byteread =in.read(buffer)) != -1){
					  out.write(buffer,0,byteread);
				  }
				  return true;
			  }catch (Exception e){
				  return false;
			  }
			  
		  }
		  return false;
		 
		  
	  }


	private static boolean deleteAnyone(String targetFileName) {
		// TODO Auto-generated method stub
		return false;
	}
	  
}
