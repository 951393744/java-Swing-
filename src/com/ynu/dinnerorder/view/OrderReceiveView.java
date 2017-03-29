package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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


public class OrderReceiveView extends JFrame {
	
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

	public OrderReceiveView(){
		init();
	}
	
	public void init(){
		setTitle("�����Ƿ��ʹ����");
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
		menuBar.setLayout(new FlowLayout());
		
		JButton jb1=new JButton("δ�ʹ�Ķ���");
		jb1.addActionListener(new queryDishAction());
		jb1.setActionCommand("δ�ʹ�");
		JButton jb2=new JButton("���ʹ�Ķ���");
		jb2.addActionListener(new queryDishAction());
		jb2.setActionCommand("���ʹ�");
		menuBar.add(jb1);
		menuBar.add(jb2);
		
		jpanel=new JPanel();
		l=new JLabel();
		JLabel l1=new JLabel("�����û�����");
		textName=new JTextField(5);
		JButton jb=new JButton("��ѯ");
		jb.addActionListener(new queryDishAction());
		jb.setActionCommand("��ѯ�û�������صĶ�����Ϣ");
		jpanel.add(l);
		jpanel.add(l1);
		jpanel.add(textName);
		jpanel.add(jb);
		
		JPanel panel1=new JPanel();
		JLabel label=new JLabel("���붩����");
		textID=new JTextField(20);
		JButton jb3=new JButton("ȷ���ʹ�");
		jb3.addActionListener(new queryDishAction());
		jb3.setActionCommand("ȷ���ʹ�");
		
		panel1.add(label);
		panel1.add(textID);
		panel1.add(jb3);
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
			if(e.getActionCommand().equals("δ�ʹ�")){
				//���δ�ʹ�״̬�ı�
				l.setText("�鿴δ�ʹﶩ����");
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
						s="��ȷ��,δ�ʹ�";
					}else if(im.getItem_state()==4){
						s="���ʹδ����";
					}else if(im.getItem_state()==5){
						s="�Ѹ���";
					}
					v.add(s);
					v.add(im.getN_user_m().getNu_telephone());
					v.add(im.getN_user_m().getNu_address());
					dtm.addRow(v);
				}
				jsp.repaint();
			}else if(e.getActionCommand().equals("���ʹ�")){
				//������ʹ�״̬�ı�
				l.setText("�鿴���ʹﶩ����");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByState(4);
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
						s="���ʹδ����";
					}else if(im.getItem_state()==5){
						s="�Ѹ���";
					}
					v.add(s);
					v.add(im.getN_user_m().getNu_telephone());
					v.add(im.getN_user_m().getNu_address());
					dtm.addRow(v);
				}
				jsp.repaint();
			}else if(e.getActionCommand().equals("ȷ���ʹ�")){
				//��ť�����󣬸ı�״̬
				String s=textID.getText().trim();
				ItemDao ID=new ItemDao();
				int i=0;
				List<ItemModel> lim=ID.equeryByOrderId(s);
				for(ItemModel im:lim){
					i=im.getItem_state();
				}
				if(i>=4){
					JOptionPane.showMessageDialog(null, "�ö������Ѿ��������ʹ�");
				}else{
				
				int i1=ID.UpdateStateByOrderId(s, 4);
				if(i1==0){
					JOptionPane.showMessageDialog(null, "�����Ų�����Ŷ,������һЩ");
				}else{
					JOptionPane.showMessageDialog(null, "ȷ���ʹ�ɹ���Ŷ");
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
			}
			
		}
		
	}

	public static void main(String[] args) {
		new OrderReceiveView();
	}

}
