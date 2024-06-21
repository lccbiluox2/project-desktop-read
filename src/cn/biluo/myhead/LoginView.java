package cn.biluo.myhead;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {

	
		
		JLabel Jlabel1,Jlabel2;
		JFrame mainJFrame;
		Container con;
		JButton loginBtn,cancelBtn,registerBtn;
		JTextField userText;
		JPasswordField passwordField;
		HandleAction handleAction;
		
		public class HandleAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg;
				if(e.getSource() ==  loginBtn){
					String userName = userText.getText();
					String Password = new String(passwordField.getPassword());
					LoginSaveService loginSave = new LoginSaveService();
					try {
						int num = loginSave.checkUser(userName, Password);
						if(num == 1){
				         	   JOptionPane.showMessageDialog(null, "登录成功!", "提示",JOptionPane.INFORMATION_MESSAGE);
				        }else{
				         	   JOptionPane.showMessageDialog(null, "登录失败!", "提示",JOptionPane.INFORMATION_MESSAGE);
				        }
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}else if(e.getSource() ==  registerBtn){
					msg = "你的用户名是"+userText.getText()+"    mima:"+new String(passwordField.getPassword());
					String userName = userText.getText();
					String Password = new String(passwordField.getPassword());
					LoginSaveService loginSave = new LoginSaveService();
					int num = loginSave.save(userName, Password);
					if(num == 1){
			        	   JOptionPane.showMessageDialog(null, "注册成功!", "提示",JOptionPane.INFORMATION_MESSAGE);
			         }else{
			        	   JOptionPane.showMessageDialog(null, "注册失败!", "提示",JOptionPane.INFORMATION_MESSAGE);
			         }
					JOptionPane.showMessageDialog(mainJFrame, msg);
					
				}
				else if(e.getSource() ==  cancelBtn){
					passwordField.setText("");
					userText.setText("");
				}
			}
		}
		
	/********************************************************/
		public LoginView(){
			handleAction = new HandleAction();
			Jlabel1 = new JLabel("用户名：");
			Jlabel2 = new JLabel("密   码：");
			mainJFrame =  new JFrame("登录");
			con = mainJFrame.getContentPane();
			
			JPanel backgroundImg = new JPanel(){
			     public void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         ImageIcon img = new ImageIcon("images\\login.png");
			         g.drawImage(img.getImage(),0,0,null);
			          }
			       }; 
			       
			       
			loginBtn = new JButton("登录");
			loginBtn.addActionListener(handleAction);
			
			registerBtn = new JButton("注册");
			registerBtn.addActionListener(handleAction);
			
			cancelBtn = new JButton("取消");
			cancelBtn.addActionListener(handleAction);
			
			userText = new JTextField();
			userText.setColumns(20);
			passwordField = new JPasswordField();
			passwordField.setColumns(20);
			backgroundImg.setLayout(new FlowLayout());
			backgroundImg.add(Jlabel1);
			backgroundImg.add(userText);
			backgroundImg.add(Jlabel2);
			backgroundImg.add(passwordField);
			backgroundImg.add(loginBtn);
			backgroundImg.add(registerBtn);
			backgroundImg.add(cancelBtn);
			
			
			mainJFrame.add(backgroundImg);
			mainJFrame.setLocation(600, 300);
			mainJFrame.setSize(250, 250);
			mainJFrame.setVisible(true);
			mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		
	
}
