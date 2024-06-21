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
			  System.out.println("�ļ�����");
			  return false;
		  }else if(!srcFile.isFile()){
			  System.out.println("�����ļ�");
			  return false;
		  }
		  System.out.println(targetFileName);
		  File targetFile = new File(targetFileName);
		  System.out.println("-------"+targetFile);
		  if(targetFile.exists()){
			  System.out.println("Ŀ���ļ�����");
			  if(overlay){
				  System.out.println("�Ƿ񸲸�");
				  if(!deleteAnyone(targetFileName)){
					  System.out.println("ɾ��Ŀ���ļ��ɹ�");
					  return false;
				  }
			  }else{
				  System.out.println("ɾ��Ŀ���ļ�ʧ��");
				  return false;
			  }
		  }else{
			  System.out.println("Ŀ���ļ�������");
			  if(!targetFile.getParentFile().exists()){
				  System.out.println("Ŀ���ļ����ڸ�Ŀ¼������");
				  if(!targetFile.getParentFile().mkdirs()){
					  System.out.println("Ŀ���ļ����ڸ�Ŀ¼����ʧ��");
					  return false;
				  }
			  }
			 System.out.println("��ʼ�ƶ��ļ�");
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
