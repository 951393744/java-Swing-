package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
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

import com.ynu.dinnerorder.databasedao.DishDao;
import com.ynu.dinnerorder.databasedao.ItemDao;
import com.ynu.dinnerorder.databasemodel.DishModel;


public class UserChooseDishView extends JFrame {
	
	private JPanel contentPane;
	private String[] s={"��Ʒid","��Ʒ����","��Ʒ�۸�","��Ʒ����"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	
	private JTextField dishidchoose;
	private JTextField numchoose;
	private int u_id;
	
	
	
	
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public UserChooseDishView(){
		init();
	}

	public static void main(String[] args) {
		new UserChooseDishView();
	}
	
	public void init(){
		
		/*ͼƬ�ز�*/
		ImageIcon zw = new ImageIcon("E://�ز�//zwcx.jpg");
		ImageIcon cp = new ImageIcon("E://�ز�//cpcx.jpg");
		ImageIcon sure = new ImageIcon("E://�ز�//gou.jpg");
		
		setTitle("ѡ���Ʒ");
		jsp=new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		setResizable(true);
		setVisible(true);
		setBounds(300, 150, 450, 300);
		setSize(800,500);
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("��Ʒ��ѯ");
		menu.setIcon(cp);/**/
		menuBar.add(menu);
		
		
		JMenuItem menuItem_1 = new JMenuItem("��ѯȫ��");
		menuItem_1.addActionListener(new queryDishAction());
		menuItem_1.setActionCommand("��ѯȫ��");
		menu.add(menuItem_1);
		
		JMenu desk = new JMenu("��λ��ѯ");
		desk.setIcon(zw);/**/
		menuBar.add(desk);
		
		JMenuItem menuItem_2 = new JMenuItem("��ѯ����");
		menuItem_2.addActionListener(new queryDishAction());
		menuItem_2.setActionCommand("��ѯ��λ");
		desk.add(menuItem_2);
		
		JPanel panel1=new JPanel();
		JLabel jl=new JLabel("ѡ���Ʒid");
		dishidchoose=new JTextField(4);
		JLabel jn=new JLabel("����");
		numchoose=new JTextField(4);
		JButton jb=new JButton("ȷ��");
		jb.setIcon(sure);/**/
		jb.addActionListener(new queryDishAction());
		jb.setActionCommand("ȷ��");
		panel1.add(jl);
		panel1.add(dishidchoose);
		panel1.add(jn);
		panel1.add(numchoose);
		panel1.add(jb);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanel=new JPanel();
		JLabel l=new JLabel("��ӭ�鿴���в�Ʒ��ϢŶ��");
		jpanel.setBackground(Color.GREEN);
		jpanel.setForeground(Color.black);
		jpanel.add(l);
		
		contentPane.add(jpanel,BorderLayout.NORTH);
		contentPane.add(panel1,BorderLayout.SOUTH);
		
		contentPane.add(jsp,BorderLayout.CENTER);
		this.add(contentPane);
	
	}
	
	private class queryDishAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��ѯȫ��")){
				DishDao dd=new DishDao();
				List<DishModel> ldm=dd.equeryAllDish();
				System.out.println(ldm.size());
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
//				jsp=new JScrollPane(table);
				
				table.setSize(jsp.getWidth(),jsp.getHeight());
//				jsp.setRowHeaderView(table);
				
//				jsp.setColumnHeaderView(table);
//				jsp.setColumnHeaderView(table);
				jsp.setViewportView(table);
				for(DishModel dm:ldm){
					Vector v=new Vector();
					v.add(dm.getDish_id());
					v.add(dm.getDish_name());
					v.add(dm.getDish_price()+"Ԫ");
					v.add(dm.getDish_description());
					dtm.addRow(v);
				}
				
//				contentPane.add(jsp,BorderLayout.CENTER);
//				contentPane.repaint();
				jsp.repaint();
				
			}else if(e.getActionCommand().equals("��ѯ��λ")){
				new DeskUserView();
			}else if(e.getActionCommand().equals("ȷ��")){
				ItemDao ID=new ItemDao();
				String dish_id=dishidchoose.getText().trim();
				String dish_num=numchoose.getText().trim();
				Integer i1=Integer.valueOf(dish_id);
				Integer i2=Integer.valueOf(dish_num);
				Date d=new Date();
				int i3=ID.addItem(d, i2, u_id, i1);
				int i4=ID.updateTotalPrice(i1, u_id);
				if(i3>0){
					JOptionPane.showMessageDialog(contentPane, "�Ѿ��ɹ���ӵ��˵����뵽��������ȷ��");
				}
			}
			
		}
		
	}

}
