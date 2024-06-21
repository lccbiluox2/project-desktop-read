package cn.biluo.myhead;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LoginSaveService {
	
	public int save(String userName,String Password){
		String key = userName;
        String value = Password;
        if ((!key.equals("") && (key != null)) && ((!value.equals("")) && (value != null))) {
            MyProperties properties = new MyProperties();
            int num = properties.saveProperties(key, value);
            return num;
        }
		return 0;
	}
	
	public int checkUser(String userName,String Password) throws FileNotFoundException, IOException{
		String key = userName;
        String value = Password;
        if ((!key.equals("") && (key != null)) && ((!value.equals("")) && (value != null))) {
            MyProperties properties = new MyProperties();
            int num = properties.readProperties(key, value);
            return num;
        }
		return 0;
		
	}
}
