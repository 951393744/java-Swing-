package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ynu.dinnerorder.databasedao.OrderDao;
import com.ynu.dinnerorder.databasemodel.OrderModel;

public class ThisYearFlowView extends JFrame {
	private JPanel contentPane;
	private String[] s={"��ˮ��","������","������","��λ","�����˵绰","�����˵�ַ","������ϸ","�����ܼ�","������������"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	private JTextField textID;
	private JPanel jpanel;
	private JTextField jtfTotalprice;
	private JPanel panel1;//�·�������
	
	public ThisYearFlowView(){
		init();
	}
	
	public void init(){
		setTitle("������ˮ");
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
		
        
		
		
		
		
		jpanel=new JPanel();//�����Ϸ������������������¼��ķ�������������
		JLabel l=new JLabel("��ӭ�鿴������ˮ");
		
		panel1=new JPanel();//�����·������������������¼���������������
		JLabel label=new JLabel("��ˮ�ܶ");
		jtfTotalprice=new JTextField(20);//�������Գ�����ˮ�ܶ���ı���
		jtfTotalprice.setEditable(false);//���ı��򲻿����޸�
		panel1.add(label);//�����ˮ�ܶ�ı�ǩ
		panel1.add(jtfTotalprice);
		
		jpanel.add(l);
		
		
		
		
		contentPane.add(panel1,BorderLayout.SOUTH);//�·�������������������ˮ�ܶ�
		contentPane.add(jpanel,BorderLayout.NORTH);//�Ϸ������������������¼�����������
		contentPane.add(jsp,BorderLayout.CENTER);//�м������������ʢ�ű��
		
		
		
		dtm=new DefaultTableModel(s, 0);
		table=new JTable(dtm);
		table.setGridColor(Color.orange);
		jsp.setViewportView(table);
		Date date1=new Date();
		Date nowMonth=new Date(date1.getYear(), 00, 01, 00, 00, 00); 
		Date nextMonth=new Date(date1.getYear()+1, 00, 01, 00, 00, 00); 
		OrderDao OD=new OrderDao();
		List<OrderModel> lom=OD.queryByDay(nowMonth, nextMonth);
		double totalpriceDay=0;
		if(lom.size()==0){
			JOptionPane.showMessageDialog(contentPane, "��������û����ˮŶ");
		}else{
		for(OrderModel om:lom){
			Vector v=new Vector();
			v.add(om.getOrder_id());
			v.add(om.getOrderId());
			v.add(om.getNu_name());
			v.add(om.getDesk_name());
			v.add(om.getU_telephone());
			v.add(om.getU_address());
			v.add(om.getU_dish());
			v.add(om.getTotalprice()+"Ԫ");
			v.add(om.getTime());
			dtm.addRow(v);
			totalpriceDay=totalpriceDay+om.getTotalprice();
		}
		}
		Double di=new Double(totalpriceDay);
		jtfTotalprice.setText(di.toString()+"Ԫ");
		
		
		
		this.add(contentPane);//����������ӵ�������
		
	}
	
	public static void main(String[] args) {
		new ThisYearFlowView();
	}
}
