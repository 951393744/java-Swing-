package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ynu.dinnerorder.databasedao.ItemDao;
import com.ynu.dinnerorder.databasemodel.ItemModel;



public class WaiterManageOrderView extends JFrame {
	private JPanel contentPane;
	private String[] s={"����id","������","��λ","��Ʒ��id","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ�ܼ�","��Ʒ����","����״̬","�û��绰","�û���ַ"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	private JTextField textID;
	private JPanel jpanel;
	
	private int u_id;
	
	private JTextField textName;
	private JLabel l;
	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public WaiterManageOrderView(){
		init();
	}
	
	public void init(){
		setTitle("����Ա������");
		jsp=new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setResizable(true);
		setVisible(true);
		setBounds(70, 20, 450, 300);
		setSize(1200,700);
		
        JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("���ն���");
		menuBar.add(menu);
		
		JMenu menu1 = new JMenu("���ʹ�");
		menuBar.add(menu1);
		
		JMenu menu2 = new JMenu("����");
		menuBar.add(menu2);
		
		JMenuItem menuItem_1 = new JMenuItem("δȷ��");
		menuItem_1.addActionListener(new queryDishAction());
		menuItem_1.setActionCommand("δȷ��");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("��ȷ��");
		menuItem_2.addActionListener(new queryDishAction());
		menuItem_2.setActionCommand("��ѯ��ȷ�϶���");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("���ö����ʹ�");
		menuItem_3.addActionListener(new OrderReceiveAction());
		menuItem_3.setActionCommand("�����ʹ�");
		menu1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("����ͳ��");
		menuItem_4.addActionListener(new queryDishAction());
		menuItem_4.setActionCommand("����");
		menu2.add(menuItem_4);
		
		jpanel=new JPanel();
		l=new JLabel();
		JLabel l1=new JLabel("�����û�������");
		textName=new JTextField(5);
		JButton jb=new JButton("��ѯ");
		jb.addActionListener(new queryDishAction());
		jb.setActionCommand("��ѯ�û�������صĶ�����Ϣ");
		jpanel.add(l);
		jpanel.add(l1);
		jpanel.add(textName);
		jpanel.add(jb);
		
		JPanel panel1=new JPanel();
		JLabel label=new JLabel("���붩���ţ�");
		textID=new JTextField(20);
		JButton jb2=new JButton("ȷ�϶���");
		jb2.addActionListener(new queryDishAction());
		jb2.setActionCommand("ȷ�϶���");
		
		panel1.add(label);
		panel1.add(textID);
		panel1.add(jb2);
		contentPane.add(panel1,BorderLayout.SOUTH);
		
		
		contentPane.add(jpanel,BorderLayout.NORTH);
		
		contentPane.add(jsp,BorderLayout.CENTER);
		
		
		this.add(contentPane);
//		dtm=new DefaultTableModel(s, 0);
//		table=new JTable();
//		table.setGridColor(Color.orange);
		
	}
	
	private class queryDishAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("δȷ��")){
				//�鿴δȷ�϶�����������
				l.setText("�鿴δȷ�϶�����");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByState(2);
				for(ItemModel im:lim){
					Vector v=new Vector();
					v.add(im.getOrderId());
					v.add(im.getN_user_m().getNu_name());
					v.add(im.getDeskm().getDesk_name());
					v.add(im.getItem_id());
					v.add(im.getDishm().getDish_name());
					v.add(im.getDishm().getDish_price());
					v.add(im.getDishm().getDish_description());
					v.add(im.getItem_num());
					v.add(im.getItem_totalprice()+"Ԫ");
					v.addElement(im.getItem_date());
					String s="";
					if(im.getItem_state()==2){
						s="δȷ��";
					}else if(im.getItem_state()==3){
						s="ȷ��";
					}else if(im.getItem_state()==4){
						s="���ʹ�";
					}else if(im.getItem_state()==5){
						s="�Ѹ���";
					}
					v.add(s);
					v.add(im.getN_user_m().getNu_telephone());
					v.add(im.getN_user_m().getNu_address());
					dtm.addRow(v);
				}
				jsp.repaint();
			}else if(e.getActionCommand().equals("��ѯ��ȷ�϶���")){
				l.setText("�鿴��ȷ�϶�����");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByState(3);
				for(ItemModel im:lim){
					Vector v=new Vector();
					v.add(im.getOrderId());
					v.add(im.getN_user_m().getNu_name());
					v.add(im.getDeskm().getDesk_name());
					v.add(im.getItem_id());
					v.add(im.getDishm().getDish_name());
					v.add(im.getDishm().getDish_price());
					v.add(im.getDishm().getDish_description());
					v.add(im.getItem_num());
					v.add(im.getItem_totalprice()+"Ԫ");
					v.addElement(im.getItem_date());
					String s="";
					if(im.getItem_state()==2){
						s="δȷ��";
					}else if(im.getItem_state()==3){
						s="ȷ��";
					}else if(im.getItem_state()==4){
						s="���ʹ�";
					}else if(im.getItem_state()==5){
						s="�Ѹ���";
					}
					v.add(s);
					v.add(im.getN_user_m().getNu_telephone());
					v.add(im.getN_user_m().getNu_address());
					dtm.addRow(v);
				}
				jsp.repaint();
			}else if(e.getActionCommand().equals("ȷ�϶���")){
				//ȷ�϶������ı�״̬
				String s=textID.getText().trim();
				ItemDao ID=new ItemDao();
				int i=0;
				List<ItemModel> lim=ID.equeryByOrderId(s);
				for(ItemModel im:lim){
					i=im.getItem_state();
				}
				if(i>=3){
					JOptionPane.showMessageDialog(null, "�ö������Ѿ�ȷ�Ϲ���");
				}else{
				int i1=ID.UpdateStateByOrderId(s, 3);
				if(i1==0){
					JOptionPane.showMessageDialog(null, "�����Ų�����Ŷ,������һЩ");
				}else{
					JOptionPane.showMessageDialog(null, "ȷ�ϳɹ���Ŷ");
				}
				}
				
			}else if(e.getActionCommand().equals("��ѯ�û�������صĶ�����Ϣ")){
				l.setText("�鿴�û�������ϸ��Ϣ��");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByUserName(textName.getText().trim());
				for(ItemModel im:lim){
					Vector v=new Vector();
					v.add(im.getOrderId());
					v.add(im.getN_user_m().getNu_name());
					v.add(im.getDeskm().getDesk_name());
					v.add(im.getItem_id());
					v.add(im.getDishm().getDish_name());
					v.add(im.getDishm().getDish_price());
					v.add(im.getDishm().getDish_description());
					v.add(im.getItem_num());
					v.add(im.getItem_totalprice()+"Ԫ");
					v.addElement(im.getItem_date());
					String s="";
					if(im.getItem_state()==2){
						s="δȷ��";
					}else if(im.getItem_state()==3){
						s="��ȷ��,δ�ʹ�";
					}else if(im.getItem_state()==4){
						s="���ʹ�,δ����";
					}else if(im.getItem_state()==5){
						s="�Ѹ���";
					}
					v.add(s);
					v.add(im.getN_user_m().getNu_telephone());
					v.add(im.getN_user_m().getNu_address());
					dtm.addRow(v);
				}
				jsp.repaint();
			}else if(e.getActionCommand().equals("����")){
				//��������˴���
				new UserPayView();
			}
			
		}
		
	}
	
	private class OrderReceiveAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("�����ʹ�")){
				//�������ö���״̬�Ĵ���
				new OrderReceiveView();
			}
		}
		
	}

	public static void main(String[] args) {
		new WaiterManageOrderView();
	}

}
