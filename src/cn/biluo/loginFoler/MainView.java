package cn.biluo.loginFoler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.biluo.daoRu.DaoRuView;
import cn.biluo.myhead.LoginView;

public class MainView extends JFrame {

	/**
     * 
     */
	private static final long serialVersionUID = -8061493305783207953L;
	private JPanel contentPane;
	private JTextField filePathTextField;
	private JTextField saveTextField;
	JComboBox typeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		
		/*
		 * 总界面
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭状态
		int weight = 900;
		int height = 700;
		setBounds(300, 100, weight, height);// setBounds(窗口左边距，右边距，窗口长度，窗口宽度)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("碧落阅读器");

		/*********************************************************/
		//导航界面
		JPanel panel = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\daohangTop.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		
		// 根据窗口的大小自动改变大小
		int daohangheight = 100;
		panel.setBounds(0, 0, weight, daohangheight);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		
		JPanel head = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\head.jpg");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		JPanel zifu = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\click.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		JPanel zaixian = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\zaixian.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		JPanel shujia = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\book.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		JPanel ReadHistory =new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\readhistory.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
       JPanel daoRu =new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\daoru.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		
		head.setBackground(Color.blue);
		zifu.setBackground(Color.red);
		zaixian.setBackground(Color.pink);
		shujia.setBackground(Color.black);
		ReadHistory.setBackground(Color.orange);
		daoRu.setBackground(Color.BLUE);
		
		//设置布局后，只能这样设置大小
		head.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 
		zifu.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 
		zaixian.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 
		shujia.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 
		ReadHistory.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 
		daoRu.setPreferredSize(new Dimension(100, 100));//关键代码,设置JPanel的大小 

	
		
		panel.add(head);
		panel.add(zifu);
		panel.add(zaixian);
		panel.add(shujia);
		panel.add(ReadHistory);
		panel.add(daoRu);
		
		//为各个加入点击事件
		/*****登录点击事件******/
		head.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "内部类事件监听监听", "注意", 0, null);
				LoginView login = new LoginView();
			}
		});
		
		/*******在线书城事件*******/
		zaixian.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "在线阅读", "注意", 0, null);
			}
		});

		
		/******书架事件********/
		shujia.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "查看书架", "注意", 0, null);
			}
		});
		
	
		/******阅读历史事件********/
		ReadHistory.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "阅读历史", "注意", 0, null);
			}
		});
		
		/******导入事件********/
		daoRu.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				DaoRuView daoru = new DaoRuView();
				daoru.go();
			}
		});
		/*********************************************************/
		//下面的内容界面
		JPanel panelContent = new JPanel();
		panelContent.setBackground(Color.green);
		// 根据窗口的大小自动改变大小
		int ContentChangdu = weight;
		int ContentGao = height - daohangheight;
		panelContent.setBounds(0, daohangheight, ContentChangdu, ContentGao);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		
		
		/*********************************************************/
		//左导航
		JPanel panelContentLeftDaohang = new JPanel();
		panelContentLeftDaohang.setBackground(Color.lightGray);
		// 根据窗口的大小自动改变大小
		int ContentLeftChangdu = 200;
		int ContentLeftGao = ContentGao;
		panelContentLeftDaohang.setBounds(0, 0, ContentLeftChangdu, ContentLeftGao);
		panelContent.add(panelContentLeftDaohang);
		panelContentLeftDaohang.setLayout(null);
		
		
		
	}
	
}
