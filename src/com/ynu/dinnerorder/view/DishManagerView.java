package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ynu.dinnerorder.databasedao.DishDao;
import com.ynu.dinnerorder.databasemodel.DishModel;



public class DishManagerView extends JFrame{
	private JPanel contentPane;
	private String[] s={"��Ʒid","��Ʒ����","��Ʒ�۸�","��Ʒ����"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public DishManagerView(){
		DishManagerViewinit();
	}

	/**
	 * Create the frame.
	 */

	public void DishManagerViewinit() {
		/*ͼƬ�ز�*/
		ImageIcon zj = new ImageIcon("E://�ز�//jia.jpg");
		ImageIcon sj = new ImageIcon("E://�ز�//jian.jpg");
		ImageIcon cx = new ImageIcon("E://�ز�//select.jpg");
		ImageIcon gx = new ImageIcon("E://�ز�//suaxin.jpg");
		
		
//		dtm=new DefaultTableModel(s, 0);
//		table=new JTable(dtm);
		setTitle("��Ʒ����");
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
		menu.setIcon(cx);/**/
		menuBar.add(menu);
		
		JMenuItem mntmid = new JMenuItem("����ID");
		mntmid.addActionListener(new queryDishAction());
		mntmid.setActionCommand("id");
		menu.add(mntmid);
		
		JMenuItem menuItem = new JMenuItem("��������");
		menuItem.addActionListener(new queryDishAction());
		menuItem.setActionCommand("name");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("��ѯȫ��");
		menuItem_1.addActionListener(new queryDishAction());
		menuItem_1.setActionCommand("��ѯȫ��");
		menu.add(menuItem_1);
		
		JButton button = new JButton("��Ӳ�Ʒ");
		button.setIcon(zj);/**/
		button.addActionListener(new DishAddAction());
		button.setActionCommand("���");
		menuBar.add(button);
		
		JButton button_1 = new JButton("ɾ����Ʒ");
		button_1.setIcon(sj);/**/
		button_1.addActionListener(new DishDeleteAction());
		button_1.setActionCommand("ɾ��");
		menuBar.add(button_1);
		
		JMenu menu_1 = new JMenu("���²�Ʒ");
		menu_1.setIcon(gx);/**/
		menuBar.add(menu_1);
		
		JMenuItem mntmid_1 = new JMenuItem("ͨ��ID");
        mntmid_1.addActionListener(new UpdateDishAction());
        mntmid_1.setActionCommand("id����");
		menu_1.add(mntmid_1);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
      
		JPanel jpanel=new JPanel();
		JLabel l=new JLabel("��ӭ�鿴���в�Ʒ��ϢŶ��");
		jpanel.setBackground(Color.GREEN);
		jpanel.setForeground(Color.black);
		jpanel.add(l);
		
		contentPane.add(jpanel,BorderLayout.NORTH);
		
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
				
			}else if(e.getActionCommand().equals("id")){
				new DishQueryIdView();
			}else if(e.getActionCommand().equals("name")){
				new DishQueryNameView();
			}
		}
		
	}
	
	private class DishAddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("���")){
				new DishAddView();
			}
		}
		
	}

	private class DishDeleteAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("ɾ��")){
				new DishDeleteView();
			}
		}
		
	}
	
	private class UpdateDishAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("id����")){
				new DishUpdateByIdView();
			}
		}
		
	}
	public static void main(String[] args){
		new DishManagerView();
	}

}
