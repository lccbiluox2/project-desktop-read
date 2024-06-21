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
        Properties properties = new Properties(); // 定义Properties对象
        properties.setProperty(key, value); // 设置属性文件值
        try {
            FileOutputStream out = new FileOutputStream("ExportTemp\\ExportFormat.properties");// 创建输出流对象
            properties.store(out, "ExportFormat"); // 将信息通过流写入到属性文件
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
