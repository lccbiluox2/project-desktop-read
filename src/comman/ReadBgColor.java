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
        Properties properties = new Properties(); // 定义Properties对象
        properties.setProperty(key, value); // 设置属性文件值
        try {
            FileOutputStream out = new FileOutputStream("mybook\\ReadBgColor.properties");// 创建输出流对象
            properties.store(out, "bgcolor"); // 将信息通过流写入到属性文件
            out.close(); // 关闭流
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
