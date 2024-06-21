package cn.biluo.loginFoler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {

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
					LoginView frame = new LoginView();
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
	public LoginView() {
		
		/*
		 * �ܽ���
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùر�״̬
		int weight = 900;
		int height = 700;
		setBounds(300, 100, weight, height);// setBounds(������߾࣬�ұ߾࣬���ڳ��ȣ����ڿ��)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 5, 5, 5));
		Color bg = new Color(255, 255, 255);
		contentPane.setBackground(bg);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("�����Ķ���");

		/*********************************************************/
		//��������
		JPanel panel = new JPanel(){
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         ImageIcon img = new ImageIcon("images\\daohangTop.png");
		         g.drawImage(img.getImage(),0,0,null);
		          }
		       }; 
		panel.setBackground(Color.blue);
		// ���ݴ��ڵĴ�С�Զ��ı��С
		int daohangheight = 100;
		panel.setBounds(0, 0, weight, daohangheight);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		
		JPanel head = new JPanel();
		JPanel zifu = new JPanel();
		JPanel zaixian = new JPanel();
		JPanel shujia = new JPanel();
		JPanel ReadHistory =new JPanel() ;
		
		head.setSize(100, 100);
		
		head.setBackground(Color.blue);
		zifu.setBackground(Color.red);
		zaixian.setBackground(Color.pink);
		shujia.setBackground(Color.black);
		ReadHistory.setBackground(Color.white);
		
		//���ò��ֺ�ֻ���������ô�С
		head.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		zifu.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		zaixian.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		shujia.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		ReadHistory.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 

		
		panel.add(head);
		panel.add(zifu);
		panel.add(zaixian);
		panel.add(shujia);
		panel.add(ReadHistory);
		
		     
		  

		/*********************************************************/
		//��������ݽ���
		JPanel panelContent = new JPanel();
		panelContent.setBackground(Color.green);
		// ���ݴ��ڵĴ�С�Զ��ı��С
		int ContentChangdu = weight;
		int ContentGao = height - daohangheight;
		panelContent.setBounds(0, daohangheight, ContentChangdu, ContentGao);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		
		/*********************************************************/
		//�󵼺�
		JPanel panelContentLeftDaohang = new JPanel();
		panelContentLeftDaohang.setBackground(Color.lightGray);
		// ���ݴ��ڵĴ�С�Զ��ı��С
		int ContentLeftChangdu = 200;
		int ContentLeftGao = ContentGao;
		panelContentLeftDaohang.setBounds(0, 0, ContentLeftChangdu, ContentLeftGao);
		panelContent.add(panelContentLeftDaohang);
		panelContentLeftDaohang.setLayout(null);
		
		
	}
	
}
