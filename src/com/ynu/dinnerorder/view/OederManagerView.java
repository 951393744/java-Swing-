package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
import com.ynu.dinnerorder.databasemodel.DishModel;
import com.ynu.dinnerorder.databasemodel.ItemModel;



public class OederManagerView extends JFrame {
	
	
	private JPanel contentPane;
	private String[] s={"����id","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ�ܼ�","��Ʒ����","����״̬"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	private JTextField textID;
	
	private int u_id;
	
	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public OederManagerView(){
		init();
	}
	
	public void init(){
		setTitle("���˶�������");
		jsp=new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setResizable(true);
		setVisible(true);
		setBounds(300, 150, 450, 300);
		setSize(800,500);
		
        JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("��������");
		menuBar.add(menu);
		
		JMenu menu1 = new JMenu("�ռ�ѡ��");
		menuBar.add(menu1);
		
		JMenuItem menuItem_1 = new JMenuItem("������ѡ����");
		menuItem_1.addActionListener(new queryDishAction());
		menuItem_1.setActionCommand("��ѯ��ѡ����");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("�ύ��ȷ�϶���");
		menuItem_2.addActionListener(new queryDishAction());
		menuItem_2.setActionCommand("����ѡ��");
		menu1.add(menuItem_2);
		
		JPanel jpanel=new JPanel();
		JLabel l=new JLabel("�鿴������ж�����Ϣ��");
		jpanel.setBackground(Color.GREEN);
		jpanel.setForeground(Color.black);
		jpanel.add(l);
		
		JLabel label=new JLabel("�����Ʒ����");
		textID=new JTextField(4);
		JPanel panel1=new JPanel();
		JButton jb1=new JButton("ȡ����Ʒ");
		jb1.addActionListener(new queryDishAction());
		jb1.setActionCommand("ȡ��");
		JButton jb2=new JButton("ȷ�ϲ�Ʒ");
		jb2.addActionListener(new queryDishAction());
		jb2.setActionCommand("ȷ��");
		
		panel1.add(label);
		panel1.add(textID);
		panel1.add(jb1);
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
			dtm=new DefaultTableModel(s, 0);
			table=new JTable(dtm);
			table.setGridColor(Color.orange);
			
			if(e.getActionCommand().equals("��ѯ��ѡ����")){
				ItemDao ID=new ItemDao();
				List<ItemModel> LIM=ID.equeryItemByUserId(u_id);
//				DefaultTableModel dtk=(DefaultTableModeltable)table.getModel();
				
				jsp.setViewportView(table);
				for(ItemModel im:LIM){
					Vector v=new Vector();
					v.add(im.getItem_id());
					v.add(im.getDishm().getDish_name());
					v.add(im.getDishm().getDish_price());
					v.add(im.getDishm().getDish_description());
					v.add(im.getItem_num());
					v.add(im.getItem_totalprice()+"Ԫ");
					v.addElement(im.getItem_date());
					String s="";
					if(im.getItem_state()==0){
						s="�û�δȷ��";
					}else if(im.getItem_state()==1)
					{
						s="�û��Ѿ�ȷ��";
					}else if(im.getItem_state()==2){
						s="���ύ������";
					}else if(im.getItem_state()==3){
						s="����Ա��ȷ��";
					}else if(im.getItem_state()==4){
						s="��Ʒ�Ѿ��ʹ�";
					}else if(im.getItem_state()==5){
						s="�Ѿ�����";
					}
					v.add(s);
					dtm.addRow(v);
				}
				jsp.repaint();
				int row=table.getSelectedColumn();
//				System.out.println("ѡ�е�����"+row);
			}
			else if(e.getActionCommand().equals("ȡ��")){
				
				String sID=textID.getText().trim();
				if(sID.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "�����Ų���Ϊ��");
				}else{
				Integer item_id=Integer.valueOf(sID);
				ItemDao ID=new ItemDao();
				ItemModel IM=ID.equeryItemById(item_id);
				if(IM.getItem_state()==1){
					JOptionPane.showMessageDialog(contentPane, "���Ѿ�ȷ�ϸö���,����ȡ����,�������Ա����");
				}else if(IM.getItem_state()==0){
				int i2=ID.deleteItem(item_id);
				if(i2==0){
				JOptionPane.showMessageDialog(contentPane, "����ʧ��");
				}else{
					JOptionPane.showMessageDialog(contentPane, "�����ɹ�");
				}
				}
				}
				
			}else if(e.getActionCommand().equals("ȷ��")){
				
				String sID=textID.getText().trim();
				Integer item_id=Integer.valueOf(sID);
				ItemDao ID=new ItemDao();
				ItemModel IM=ID.equeryItemById(item_id);
				if(IM.getItem_state()>=1){
					JOptionPane.showMessageDialog(contentPane, "���Ѿ�ȷ�ϸö�����������ô�鷳���ظ�ȷ��Ŷ");
				}else if(IM.getItem_state()==0){
				int i_state=1;
				int i1=ID.updateState(item_id, i_state);
				if(i1==0){
					JOptionPane.showMessageDialog(contentPane, "ȷ��ʧ��"); 
				}else{
					JOptionPane.showMessageDialog(contentPane, "ȷ�ϳɹ�");
				}
				}
		}else if(e.getActionCommand().equals("����ѡ��")){
			OrderFinalChooseView ofc=new OrderFinalChooseView();
			ofc.setU_id(u_id);
			ofc.creatTable();
		}
		}
		
	}
	
	public static void main(String[] args) {
		new OederManagerView();
	}

}
