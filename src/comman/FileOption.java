package comman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOption {
	
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
	 
	
	/***********************************************************************/
	 public static boolean createFile(String destFileName) { 
	 	File file = new File(destFileName);  
	         if(file.exists()) {  
	             System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");  
	             return false;  
	         }  
	         if (destFileName.endsWith(File.separator)) {  
	             System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");  
	             return false;  
	         }  
	         //判断目标文件所在的目录是否存在  
	         if(!file.getParentFile().exists()) {  
	             //如果目标文件所在的目录不存在，则创建父目录  
	             System.out.println("目标文件所在目录不存在，准备创建它！");  
	             if(!file.getParentFile().mkdirs()) {  
	                 System.out.println("创建目标文件所在目录失败！");  
	                 return false;  
	             }  
	         }  
	         //创建目标文件  
	         try {  
	             if (file.createNewFile()) {  
	                 System.out.println("创建单个文件" + destFileName + "成功！");  
	                 return true;  
	             } else {  
	                 System.out.println("创建单个文件" + destFileName + "失败！");  
	                return false;  
	             }  
	         } catch (IOException e) {  
	             e.printStackTrace();  
	             System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());  
	             return false;  
	         }  
	     }  
	     
	      
	     public static boolean createDir(String destDirName) {  
	         File dir = new File(destDirName);  
	         if (dir.exists()) {  
	             System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
	             return false;  
	         }  
	         if (!destDirName.endsWith(File.separator)) {  
	             destDirName = destDirName + File.separator;  
	       }  
	         //创建目录  
	         if (dir.mkdirs()) {  
	             System.out.println("创建目录" + destDirName + "成功！");  
	             return true;  
	         } else {  
	             System.out.println("创建目录" + destDirName + "失败！");  
	             return false;  
	         }  
	     }  
	      
	      
	     public static String createTempFile(String prefix, String suffix, String dirName) {  
	         File tempFile = null;  
	         if (dirName == null) {  
	             try{  
	                 //在默认文件夹下创建临时文件  
	                 tempFile = File.createTempFile(prefix, suffix);  
	                 //返回临时文件的路径  
	                 return tempFile.getCanonicalPath();  
	             } catch (IOException e) {  
	                 e.printStackTrace();  
	                 System.out.println("创建临时文件失败！" + e.getMessage());  
	                 return null;  
	             }  
	         } else {  
	             File dir = new File(dirName);  
	             //如果临时文件所在目录不存在，首先创建  
	            if (!dir.exists()) {  
	                 if (!FileOption.createDir(dirName)) {  
	                     System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");  
	                     return null;  
	                 }  
	             }  
	             try {  
	                 //在指定目录下创建临时文件  
	                 tempFile = File.createTempFile(prefix, suffix, dir);  
	                 return tempFile.getCanonicalPath();  
	             } catch (IOException e) {  
	                 e.printStackTrace();  
	                 System.out.println("创建临时文件失败！" + e.getMessage());  
	                 return null;  
	             }  
	         }  
	     }  
	      
	     public static void main(String[] args) {  
	         //创建目录  
	         String dirName = "D:/work/temp/temp0/temp1";  
	         FileOption.createDir(dirName);  
	         //创建文件  
	         String fileName = dirName + "/temp2/tempFile.txt";  
	         FileOption.createFile(fileName);  
	         //创建临时文件  
	         String prefix = "temp";  
	         String suffix = ".txt";  
	         for (int i = 0; i < 10; i++) {  
	             System.out.println("创建了临时文件："  
	                     + FileOption.createTempFile(prefix, suffix, dirName));  
	         }  
	         //在默认目录下创建临时文件  
	         for (int i = 0; i < 10; i++) {  
	             System.out.println("在默认目录下创建了临时文件："  
	                     + FileOption.createTempFile(prefix, suffix, null));  
	         }  
	     }  
	  
	   

	
	
	
	/***********************************************************************/
}
