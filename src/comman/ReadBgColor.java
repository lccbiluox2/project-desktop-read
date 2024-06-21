package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadBgColor {
	
	 /*********************************************************/
    /**
     * @param args
     */

    public static int setBgColor(String value) {
    	String key = "bgcolor";
        Properties properties = new Properties(); // ����Properties����
        properties.setProperty(key, value); // ���������ļ�ֵ
        try {
            FileOutputStream out = new FileOutputStream("mybook\\ReadBgColor.properties");// �������������
            properties.store(out, "bgcolor"); // ����Ϣͨ����д�뵽�����ļ�
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
    public static String getBgColor() {
    	String key = "bgcolor";
    	Properties pps = new Properties();
        try {
			pps.load(new FileInputStream("mybook\\ReadBgColor.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String bgcolor = pps.getProperty(key);
		return bgcolor;
        
    }



    /*********************************************************/
    
}
