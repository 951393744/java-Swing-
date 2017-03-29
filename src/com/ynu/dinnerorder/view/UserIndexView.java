package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;



public class UserIndexView extends JFrame{

	private JPanel contentPane;
	private String nu_id;
	private String nu_name;
	private String nu_password;
	private String nu_telephone;
	private String nu_address;
	
	private String s1="�û����֣�";
	private String s2="�û��绰��";
	private String s3="�û���ַ��";
	
	JLabel IDlblNewLabel;
	JTextField jtf1;
	JLabel NAMElblNewLabel;
	JTextField jtf2;
	JLabel ACTORlblNewLabel;
	JTextField jtf3;
	
	
public void changeForLogin(){
	
	IDlblNewLabel.setText(s1);
	NAMElblNewLabel.setText(s2);
	ACTORlblNewLabel.setText(s3);
	jtf1.setText(nu_name);
	jtf2.setText(nu_telephone);
	jtf3.setText(nu_address);
}
	
	
	

	public String getNu_id() {
	return nu_id;
}




public void setNu_id(String nu_id) {
	this.nu_id = nu_id;
}




public String getNu_name() {
	return nu_name;
}




public void setNu_name(String nu_name) {
	this.nu_name = nu_name;
}




public String getNu_password() {
	return nu_password;
}




public void setNu_password(String nu_password) {
	this.nu_password = nu_password;
}




public String getNu_telephone() {
	return nu_telephone;
}




public void setNu_telephone(String nu_telephone) {
	this.nu_telephone = nu_telephone;
}




public String getNu_address() {
	return nu_address;
}




public void setNu_address(String nu_address) {
	this.nu_address = nu_address;
}




	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	/**
	 * ����
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserIndexView frame = new UserIndexView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��������
	 * 
	 * 
	 */
	public UserIndexView(){
		WaiterIndexViewInit();
	}
	
	public  void WaiterIndexViewInit() {
		/*ͼƬ�ز�*/
		Icon yhgl = new ImageIcon("E://�ز�//uyonghu.jpg");
		Icon cpxz = new ImageIcon("E://�ز�//ucaiping.jpg");
		Icon dingd = new ImageIcon("E://�ز�//65b1OOOPIC16.jpg");
		Icon name = new ImageIcon("E://�ز�//yhxm.jpg");
		Icon tel = new ImageIcon("E://�ز�//yhdh.jpg");
		Icon adre = new ImageIcon("E://�ز�//yhdz.jpg");
		Icon face = new ImageIcon("E://�ز�//123.jpg");
		
		
		this.setVisible(true);
		setTitle("��Ҷ̩�������û�ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 450, 300);
		setSize(1200, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnu = new JMenu("�û�����(U)");
		mnu.setIcon(yhgl);/**/
		menuBar.add(mnu);
		
		JMenuItem menuItem = new JMenuItem("�޸���Ϣ");
		menuItem.addActionListener(new updateWaiter());
		menuItem.setActionCommand("�޸�");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnu.add(menuItem);
		//�޸���Ϣ
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ע���û�");
		mntmNewMenuItem.addActionListener(new updateWaiter());
		mntmNewMenuItem.setActionCommand("ע��");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnu.add(mntmNewMenuItem);
		//ע���û�
		
		JMenu mnNewMenu = new JMenu("��Ʒѡ��(D)");
		mnNewMenu.setIcon(cpxz);/**/
		menuBar.add(mnNewMenu);
		//��Ʒ
		
		JMenuItem menuItem_1 = new JMenuItem("��Ʒѡ��");
		menuItem_1.addActionListener(new DishAction());
		menuItem_1.setActionCommand("��Ʒѡ��");
		mnNewMenu.add(menuItem_1);
		
		
		JMenu mnNewMenu_1 = new JMenu("����(O)");
		mnNewMenu_1.setIcon(dingd);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("��������");
		menuItem_5.addActionListener(new OrderAction());
		menuItem_5.setActionCommand("��������");
		mnNewMenu_1.add(menuItem_5);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		/**/
		JLabel imglb= new JLabel();
		imglb.setIcon(face);
		
		JPanel image = new JPanel();
		//image.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), null, new Color(218, 112, 214), null));
		contentPane.add(image, BorderLayout.CENTER);
		contentPane.add(imglb, BorderLayout.CENTER);/**/
		image.setLayout(new BorderLayout(0, 0));
		
		JPanel waiter = new JPanel();
		waiter.setBackground(new Color(176, 196, 222));
		waiter.setForeground(new Color(0, 139, 139));
		contentPane.add(waiter, BorderLayout.NORTH);
		waiter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		IDlblNewLabel= new JLabel(s1);
		IDlblNewLabel.setIcon(name);/**/
		jtf1=new JTextField(10);
		jtf1.setEditable(false);
		waiter.add(IDlblNewLabel);
		waiter.add(jtf1);
		
		NAMElblNewLabel= new JLabel(s2);
		NAMElblNewLabel.setIcon(tel);/**/
		jtf2=new JTextField(10);
		jtf2.setEditable(false);
		waiter.add(NAMElblNewLabel);
		waiter.add(jtf2);
		
		ACTORlblNewLabel= new JLabel(s3);
		ACTORlblNewLabel.setIcon(adre);/**/
		waiter.add(ACTORlblNewLabel);
		jtf3=new JTextField(30);
		jtf3.setEditable(false);
		waiter.add(jtf3);
	}
	
	/*
	 * ����¼�������Ա�û���Ϣ����
	 */
	
	
	
	private class updateWaiter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("�޸�")){
				UserUpdateView wiv=new UserUpdateView();
				int i=Integer.valueOf(nu_id);
				wiv.setNu_id(i);
				wiv.setS1(nu_name);
				wiv.setS2(nu_password);
				wiv.setS3(nu_telephone);
				wiv.setS4(nu_address);
				wiv.change();
				dispose();
			}else if(e.getActionCommand().equals("ע��")){
				dispose();
				new WaiterLoginView();
			}
		}
		
	}
	
	private class DishAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��Ʒѡ��")){
				UserChooseDishView ucd=new UserChooseDishView();
				int i=Integer.valueOf(nu_id);
				ucd.setU_id(i);
			}
			
		}
		
	}
	
	private class OrderAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��������")){
				OederManagerView omv=new OederManagerView();
				int i=Integer.valueOf(nu_id);
				omv.setU_id(i);
			}
		}
		
	}

}
