package test;

import javax.swing.JComboBox;
 import javax.swing.JFrame;
 
public class JComboBoxTest {
    
     private JComboBox comboBox;
     private String[] names;
     private JFrame frame;
    
     public void initUI(){
         names = new String[3];
         names[0] = "QQ����";
         names[1] = "�ֻ�����";
         names[2] = "С��ͨ����";
         comboBox = new JComboBox(names);
         comboBox.setEditable(false);
         frame = new JFrame("Frame");
         frame.getContentPane().add(comboBox);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);   
     }
    
     public static void main(String[] args) {
         new JComboBoxTest().initUI();   
     }
 }
