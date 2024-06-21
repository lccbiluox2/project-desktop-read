package cn.biluo.main.Export;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EcportFormat {
	 /*********************************************************/
    /**
     * @param args
     */

    public static int setExportFormat(String value) {
    	String key = "ExportFormat";
        Properties properties = new Properties(); // ����Properties����
        properties.setProperty(key, value); // ���������ļ�ֵ
        try {
            FileOutputStream out = new FileOutputStream("ExportTemp\\ExportFormat.properties");// �������������
            properties.store(out, "ExportFormat"); // ����Ϣͨ����д�뵽�����ļ�
            out.close(); // �ر���
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    
    /*********************************************************/
    /**
     * @throws IOException 
     * @throws FileNotFoundException ****************************************************************/
    public static String getExportFormat() {
    	String key = "ExportFormat";
    	Properties pps = new Properties();
        try {
			pps.load(new FileInputStream("ExportTemp\\ExportFormat.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String ExportFormat = pps.getProperty(key);
		return ExportFormat;
        
    }



    /*********************************************************/
    
}
