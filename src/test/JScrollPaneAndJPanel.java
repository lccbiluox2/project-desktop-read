//package test;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JColorChooser;
//import javax.swing.JFrame;
//import javax.swing.WindowConstants;
//   
//public class JScrollPaneAndJPanel extends JFrame  
//{   
//Container c;  
//JButton btn=new JButton("选背景色" );  
//Color color=new Color(200,200,200);  
//  
//public JScrollPaneAndJPanel()  
//{   
//  
//  
//  
//c=getContentPane();  
//c.setLayout(new FlowLayout());  
//c.add(btn);  
//btn.addActionListener(new ActionListener(){   
//public void actionPerformed(ActionEvent e)  
//{   
//color=JColorChooser.showDialog(null,"请选择你喜欢的颜色" ,color);  
//if (color==null ) color=Color.lightGray;  
//c.setBackground(color);  
//c.repaint();   
//}   
//} );  
//  
//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
//setSize(new Dimension(400,300));  
//show();  
//}   
//   
//public static void main(String[] args)  
//{   
//GraExp2 ge=new GraExp2();  
//}   
//}   
