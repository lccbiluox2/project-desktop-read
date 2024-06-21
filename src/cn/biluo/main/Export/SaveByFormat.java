package cn.biluo.main.Export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class SaveByFormat {
	
	/**
	 * @param next *****************************************************/
	public void saveToText(String next){
		//�õ�ϵͳ����·��
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String targetPath = fsv.getHomeDirectory().toString();    //����Ƕ�ȡ����·���ķ����� 
		
		String[] nexts = next.split("##");
		
		String targetPaths = targetPath + "\\"+nexts[0]+".txt";
		String allUseFulStr = null;
		FileWriter writer = null;
		try {
			writer = new FileWriter(targetPaths);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
      
		String filestr = "ExportTemp\\"+nexts[0]+".txt";
		try {
			File file = new File(filestr);
			BufferedReader reader = new BufferedReader(new FileReader(file));// ��������������
            String line;
            while ((line = reader.readLine()) != null) {
				 allUseFulStr = allUseFulStr +  "\r\n" + line;
			}
            reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �����������д�뵽�ļ���
		try {
			writer.write(allUseFulStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Ȼ��ɾ�����ļ����µ���ʱ�ļ�
		deleteFile(filestr);
	}
	
	/*******************************************************/
	
	/** 
	 * ɾ�������ļ� 
	 * @param   sPath    ��ɾ���ļ����ļ��� 
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false 
	 */  
	public boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  

	/*******************************************************/
	
	
	public void saveToWord(String next){
		String[] nexts = next.split("##");
//		System.out.println("-----next---------------"+nexts[0]);
//		System.out.println("-----next---------------"+nexts[1]);
//		System.out.println("-----next---------------"+nexts[2]);
		JOptionPane.showMessageDialog(null, "�˷�����δд", "ע��", 0, null);
	}
	/*******************************************************/
	
	/*******************************************************/
	
	
	public void saveToCompress(String next){
		String[] nexts = next.split("##");
//		System.out.println("-----next---------------"+nexts[0]);
//		System.out.println("-----next---------------"+nexts[1]);
//		System.out.println("-----next---------------"+nexts[2]);
		JOptionPane.showMessageDialog(null, "�˷�����δд", "ע��", 0, null);
	}
	/*******************************************************/
	
	
	
	
	
}
