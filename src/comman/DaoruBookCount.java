package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class DaoruBookCount {

	
	
	
	 /*********************************************************/
    /**
     * @param args
     */

    public static int setCount(String value) {
    	String key = "count";
        Properties properties = new Properties(); // ����Properties����
        properties.setProperty(key, value); // ���������ļ�ֵ
        try {
            FileOutputStream out = new FileOutputStream("mybook\\daorubookCount.properties");// �������������
            properties.store(out, "bookcount"); // ����Ϣͨ����д�뵽�����ļ�
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
    public static String getCount() {
    	String key = "count";
    	Properties pps = new Properties();
        try {
			pps.load(new FileInputStream("mybook\\daorubookCount.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String count = pps.getProperty(key);
		return count;
        
    }



    /*********************************************************/
}
