package cn.biluo.myhead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class MyProperties {

	
	
	
	 /*********************************************************/
    /**
     * @param args
     */

    public int saveProperties(String key, String value) {
        Properties properties = new Properties(); // ����Properties����
        properties.setProperty(key, value); // ���������ļ�ֵ
        try {
            FileOutputStream out = new FileOutputStream("myproperties\\login.properties");// �������������
            properties.store(out, "test"); // ����Ϣͨ����д�뵽�����ļ�
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
    public int readProperties(String key, String value) throws FileNotFoundException, IOException {
    	Properties pps = new Properties();
        pps.load(new FileInputStream("myproperties\\login.properties"));
        Enumeration enum1 = pps.propertyNames();//�õ������ļ�������
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            if(key.equals(strKey) && value.equals(strValue)){
            	return 1;
            }else{
            	return -1;
            }
        }
		return 0;
    }
    
    /*********************************************************/
}
