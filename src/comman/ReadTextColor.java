package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadTextColor {
	
	
	 /*********************************************************/
    /**
     * @param args
     */

    public static int setTextColor(String value) {
    	String key = "ReadTextColor";
        Properties properties = new Properties(); // ����Properties����
        properties.setProperty(key, value); // ���������ļ�ֵ
        try {
            FileOutputStream out = new FileOutputStream("mybook\\ReadTextColor.properties");// �������������
            properties.store(out, "ReadTextColor"); // ����Ϣͨ����д�뵽�����ļ�
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
    public static String getTextColor() {
    	String key = "ReadTextColor";
    	Properties pps = new Properties();
        try {
			pps.load(new FileInputStream("mybook\\ReadTextColor.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String ReadTextColor = pps.getProperty(key);
		return ReadTextColor;
        
    }



    /*********************************************************/
	
	
}
