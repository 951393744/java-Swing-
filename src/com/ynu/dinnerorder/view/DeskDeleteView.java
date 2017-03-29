package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.ynu.dinnerorder.databasedao.DeskDao;
import com.ynu.dinnerorder.databasemodel.DeskModel;

public class DeskDeleteView extends JFrame {
	
	private String[] s={"��λid","��λ����","��λ����","��λ״̬"};
	private JTable table;
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTextField jf;
	private String desk_name;
	
	public DeskDeleteView(){
		init();
	}

	public void init(){
		JPanel jp1=new JPanel();
		jp1.setBackground(Color.GRAY);
		JLabel jl1=new JLabel("������λ���֣�");
		jf=new JTextField(6);
		JButton jb1=new JButton("��ѯ");
		jb1.addActionListener(new DeskDeleteAction());
		jb1.setActionCommand("��ѯ");
		JButton jb2=new JButton("ɾ������λ��Ϣ");
		jb2.addActionListener(new DeskDeleteAction());
		jb2.setActionCommand("ɾ��");
		
		jp1.add(jl1);
		jp1.add(jf);
		jp1.add(jb1);
		
		JPanel jp2=new JPanel();
		jp2.setBackground(Color.GRAY);
		jp2.add(jb2);
		
		jsp=new JScrollPane();
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		
		
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setTitle("ɾ����λ��Ϣ");
		this.setVisible(true);
		this.setSize(400, 400);
		this.setLocation(500, 200);
		
	}
	
	public class DeskDeleteAction implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��ѯ")){
				desk_name=jf.getText().trim();
				DeskDao DD=new DeskDao();
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				jsp.setViewportView(table);
				DeskModel dm=DD.equeryDeskByName(desk_name);
				if(dm==null){
					JOptionPane.showMessageDialog(jsp, "��λ���ֲ����ڣ���������");
				}else{
				Vector v=new Vector();
				v.add(dm.getDesk_id());
				v.add(dm.getDesk_name());
				v.add(dm.getDesk_description());
				String state="";
				table.setGridColor(Color.orange);
				if(dm.getDesk_state()==0){
					state="�յ�";
				}else{
					state="������";
				}
				v.add(state);
				dtm.addRow(v);
				jsp.repaint();
				}
			}else if(e.getActionCommand().equals("ɾ��")){
				desk_name=jf.getText().trim();
				DeskDao DD=new DeskDao();
				boolean b=DD.deleteDesk(desk_name);
				if(b==true){
					JOptionPane.showMessageDialog(jsp, "ɾ���ɹ�");
					dtm.setColumnCount(0);
					jsp.repaint();
				}else{
					JOptionPane.showMessageDialog(jsp, "ɾ��ʧ��,�����������");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DeskDeleteView();
	}

}
