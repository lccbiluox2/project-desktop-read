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
		 * �ܽ���
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùر�״̬
		int weight = 900;
		int height = 700;
		setBounds(300, 100, weight, height);// setBounds(������߾࣬�ұ߾࣬���ڳ��ȣ����ڿ��)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 5, 5, 5));
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
		
		// ���ݴ��ڵĴ�С�Զ��ı��С
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
		
		//���ò��ֺ�ֻ���������ô�С
		head.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		zifu.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		zaixian.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		shujia.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		ReadHistory.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 
		daoRu.setPreferredSize(new Dimension(100, 100));//�ؼ�����,����JPanel�Ĵ�С 

	
		
		panel.add(head);
		panel.add(zifu);
		panel.add(zaixian);
		panel.add(shujia);
		panel.add(ReadHistory);
		panel.add(daoRu);
		
		//Ϊ�����������¼�
		/*****��¼����¼�******/
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "�ڲ����¼���������", "ע��", 0, null);
				LoginView login = new LoginView();
			}
		});
		
		/*******��������¼�*******/
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "�����Ķ�", "ע��", 0, null);
			}
		});

		
		/******����¼�********/
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "�鿴���", "ע��", 0, null);
			}
		});
		
	
		/******�Ķ���ʷ�¼�********/
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "�Ķ���ʷ", "ע��", 0, null);
			}
		});
		
		/******�����¼�********/
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
				// һ�����򣬴˴���ϸ˵���﷨
				DaoRuView daoru = new DaoRuView();
				daoru.go();
			}
		});
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
