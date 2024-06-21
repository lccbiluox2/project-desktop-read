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
	 
	
	/***********************************************************************/
	 public static boolean createFile(String destFileName) { 
	 	File file = new File(destFileName);  
	         if(file.exists()) {  
	             System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�");  
	             return false;  
	         }  
	         if (destFileName.endsWith(File.separator)) {  
	             System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ�����ΪĿ¼��");  
	             return false;  
	         }  
	         //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����  
	         if(!file.getParentFile().exists()) {  
	             //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼  
	             System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");  
	             if(!file.getParentFile().mkdirs()) {  
	                 System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");  
	                 return false;  
	             }  
	         }  
	         //����Ŀ���ļ�  
	         try {  
	             if (file.createNewFile()) {  
	                 System.out.println("���������ļ�" + destFileName + "�ɹ���");  
	                 return true;  
	             } else {  
	                 System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");  
	                return false;  
	             }  
	         } catch (IOException e) {  
	             e.printStackTrace();  
	             System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�" + e.getMessage());  
	             return false;  
	         }  
	     }  
	     
	      
	     public static boolean createDir(String destDirName) {  
	         File dir = new File(destDirName);  
	         if (dir.exists()) {  
	             System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����");  
	             return false;  
	         }  
	         if (!destDirName.endsWith(File.separator)) {  
	             destDirName = destDirName + File.separator;  
	       }  
	         //����Ŀ¼  
	         if (dir.mkdirs()) {  
	             System.out.println("����Ŀ¼" + destDirName + "�ɹ���");  
	             return true;  
	         } else {  
	             System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�");  
	             return false;  
	         }  
	     }  
	      
	      
	     public static String createTempFile(String prefix, String suffix, String dirName) {  
	         File tempFile = null;  
	         if (dirName == null) {  
	             try{  
	                 //��Ĭ���ļ����´�����ʱ�ļ�  
	                 tempFile = File.createTempFile(prefix, suffix);  
	                 //������ʱ�ļ���·��  
	                 return tempFile.getCanonicalPath();  
	             } catch (IOException e) {  
	                 e.printStackTrace();  
	                 System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());  
	                 return null;  
	             }  
	         } else {  
	             File dir = new File(dirName);  
	             //�����ʱ�ļ�����Ŀ¼�����ڣ����ȴ���  
	            if (!dir.exists()) {  
	                 if (!FileOption.createDir(dirName)) {  
	                     System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��");  
	                     return null;  
	                 }  
	             }  
	             try {  
	                 //��ָ��Ŀ¼�´�����ʱ�ļ�  
	                 tempFile = File.createTempFile(prefix, suffix, dir);  
	                 return tempFile.getCanonicalPath();  
	             } catch (IOException e) {  
	                 e.printStackTrace();  
	                 System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());  
	                 return null;  
	             }  
	         }  
	     }  
	      
	     public static void main(String[] args) {  
	         //����Ŀ¼  
	         String dirName = "D:/work/temp/temp0/temp1";  
	         FileOption.createDir(dirName);  
	         //�����ļ�  
	         String fileName = dirName + "/temp2/tempFile.txt";  
	         FileOption.createFile(fileName);  
	         //������ʱ�ļ�  
	         String prefix = "temp";  
	         String suffix = ".txt";  
	         for (int i = 0; i < 10; i++) {  
	             System.out.println("��������ʱ�ļ���"  
	                     + FileOption.createTempFile(prefix, suffix, dirName));  
	         }  
	         //��Ĭ��Ŀ¼�´�����ʱ�ļ�  
	         for (int i = 0; i < 10; i++) {  
	             System.out.println("��Ĭ��Ŀ¼�´�������ʱ�ļ���"  
	                     + FileOption.createTempFile(prefix, suffix, null));  
	         }  
	     }  
	  
	   

	
	
	
	/***********************************************************************/
}
