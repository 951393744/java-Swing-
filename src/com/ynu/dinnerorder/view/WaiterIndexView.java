package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;

public class WaiterIndexView extends JFrame {

	private JPanel contentPane;
	private String w_id;
	private String w_name;
	private String w_password;
	private String w_telephone;
	private String w_actor;
	
	private String s1="����Ա���ţ�";
	private String s2="����Ա������";
	private String s3="����Աְλ��";
	
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
	jtf1.setText(w_id);
	jtf2.setText(w_name);
	jtf3.setText(w_actor);
}
	
	
	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}

	public String getW_name() {
		return w_name;
	}

	public void setW_name(String w_name) {
		this.w_name = w_name;
	}

	public String getW_password() {
		return w_password;
	}

	public void setW_password(String w_password) {
		this.w_password = w_password;
	}

	public String getW_telephone() {
		return w_telephone;
	}

	public void setW_telephone(String w_telephone) {
		this.w_telephone = w_telephone;
	}

	public String getW_actor() {
		return w_actor;
	}

	public void setW_actor(String w_actor) {
		this.w_actor = w_actor;
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
					WaiterIndexView frame = new WaiterIndexView();
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
	public WaiterIndexView(){
		WaiterIndexViewInit();
	}
	
	
	
	public  void WaiterIndexViewInit() {
		this.setVisible(true);
		setTitle("��Ҷ̩����������Ա����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 450, 300);
		setSize(1200, 700);
		
		ImageIcon yhgl = new ImageIcon("E://�ز�//�û�����.jpg");/*dxx*/
		ImageIcon cp = new ImageIcon("E://�ز�//��Ʒ����.jpg");
		ImageIcon zw = new ImageIcon("E://�ز�//��λ.jpg");
		ImageIcon dd = new ImageIcon("E://�ز�//����.jpg");
		ImageIcon ls = new ImageIcon("E://�ز�//��ˮ.jpg");
		ImageIcon centu = new ImageIcon("E://�ز�//jiaoye1.jpg");
		ImageIcon soutu = new ImageIcon("E://�ز�//canting1.jpg");
		ImageIcon eastu = new ImageIcon("E://�ز�//canting.jpg");
		ImageIcon nortu = new ImageIcon("E://�ز�//canting2.jpg");
		
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
		
		JMenu mnNewMenu = new JMenu("��Ʒ(D)");
		mnNewMenu.setIcon(cp);/**/
		menuBar.add(mnNewMenu);
		//��Ʒ
		
		JMenuItem menuItem_1 = new JMenuItem("��Ʒ����");
		menuItem_1.addActionListener(new DishAction());
		menuItem_1.setActionCommand("��Ʒ����");
		mnNewMenu.add(menuItem_1);
		
		JMenu mnz = new JMenu("��λ(Z)");
		mnz.setIcon(zw);/**/
		menuBar.add(mnz);
		
		JMenuItem menuItem_4 = new JMenuItem("��λ����");
		menuItem_4.addActionListener(new DeskAction());
		menuItem_4.setActionCommand("��λ");
		mnz.add(menuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("����(O)");
		 mnNewMenu_1.setIcon(dd);/**/
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("��������");
		menuItem_5.addActionListener(new OrderAction());
		menuItem_5.setActionCommand("����");
		mnNewMenu_1.add(menuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("��ˮ(F)");
		mnNewMenu_2.setIcon(ls);/**/
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("��ˮ����");
		menuItem_2.addActionListener(new OrderAction());
		menuItem_2.setActionCommand("��ˮ");
		mnNewMenu_2.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/**/
		JLabel lbcp = new JLabel();
		lbcp.setIcon(centu);
		JLabel lbsp = new JLabel();
		lbsp.setIcon(soutu);
		JLabel lbnp = new JLabel();
		lbnp.setIcon(nortu);
		JLabel lbep = new JLabel();
		lbnp.setIcon(eastu);
		
		JPanel image = new JPanel();
		image.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));/**/
		contentPane.add(image, BorderLayout.CENTER);
		image.setLayout(new BorderLayout(0, 0));
		contentPane.add(lbcp,BorderLayout.EAST);
		contentPane.add(lbnp,BorderLayout.WEST);
		contentPane.add(lbep,BorderLayout.CENTER);
		
		
		JPanel waiter = new JPanel();
		waiter.setBackground(new Color(176, 196, 222));
		waiter.setForeground(new Color(0, 139, 139));
		contentPane.add(waiter, BorderLayout.NORTH);
		waiter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		IDlblNewLabel= new JLabel(s1);
		jtf1=new JTextField(10);
		jtf1.setEditable(false);
		waiter.add(IDlblNewLabel);
		waiter.add(jtf1);
		
		NAMElblNewLabel= new JLabel(s2);
		jtf2=new JTextField(10);
		jtf2.setEditable(false);
		waiter.add(NAMElblNewLabel);
		waiter.add(jtf2);
		
		ACTORlblNewLabel= new JLabel(s3);
		waiter.add(ACTORlblNewLabel);
		jtf3=new JTextField(10);
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
				WaiterUpdateView wuv=new WaiterUpdateView();
				int i=Integer.valueOf(w_id);
				wuv.setW_id(i);
				wuv.setS1(w_name);
				wuv.setS2(w_password);
				wuv.setS3(w_telephone);
				wuv.setS4(w_actor);
				wuv.change();
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
			if(e.getActionCommand().equals("��Ʒ����")){
				new DishManagerView();
			}
			
		}
		
	}
	
	private class DeskAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��λ")){
				new DeskManagerView();
			}
		}
		
	}
	
	private class OrderAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("����")){
				new WaiterManageOrderView();
			}else if(e.getActionCommand().equals("��ˮ")){
				new FlowManageView();
			}
		}
		
	}

}
