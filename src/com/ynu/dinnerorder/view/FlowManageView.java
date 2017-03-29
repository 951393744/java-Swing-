package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
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



public class FlowManageView extends JFrame {

	private JPanel contentPane;
	private String[] s={"��ˮ��","������","������","��λ","�����˵绰","�����˵�ַ","������ϸ","�����ܼ�","������������"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	private JTextField textID;
	private JPanel jpanel;
	private JTextField jtfTotalprice;
	private JPanel panel1;//�·�������
	
	private JLabel Year;//��ı�ǩָ��
	private JLabel Month;//�µı�ǩָ��
	private JLabel Day;//�յı�ǩָ��
	private JComboBox<Integer> YearForC;//��ĸ�ѡ��
	private JComboBox<Integer> MonthForC;//�µĸ�ѡ��
	private JComboBox<Integer> DayForC;//�յĸ�ѡ��
	private Integer[] yearI;//��ĸ�ѡ������
	private Integer[] monthI;//�µĸ�ѡ������
	private Integer[] dayI;//�յĸ�ѡ������
	private JButton buttonQuery;//��Ӳ�ѯ��ť
	
	
	
	private int u_id;
	
	
	private JLabel l;
	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public FlowManageView(){
		init();
	}
	
	public void init(){
		setTitle("��ˮ����");
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
		
		
		JLabel jb1=new JLabel("�ۺϲ�ѯ");
		
		JButton jb2=new JButton("������ˮ");
		jb2.addActionListener(new queryDishAction());
		jb2.setActionCommand("������ˮ");
		JButton jb3=new JButton("������ˮ");
		jb3.addActionListener(new queryDishAction());
		jb3.setActionCommand("������ˮ");
		JButton jb4=new JButton("������ˮ");
		jb4.addActionListener(new queryDishAction());
		jb4.setActionCommand("������ˮ");
		JButton jb5=new JButton("ɾ����ˮ");
		jb5.addActionListener(new queryDishAction());
		jb5.setActionCommand("ɾ����ˮ");
		menuBar.add(jb1);
		menuBar.add(jb2);
		menuBar.add(jb3);
		menuBar.add(jb4);
		menuBar.add(jb5);
		
		jpanel=new JPanel();//�����Ϸ������������������¼��ķ�������������
		l=new JLabel("");
		
		panel1=new JPanel();//�����·������������������¼���������������
		JLabel label=new JLabel("��ˮ�ܶ");
		jtfTotalprice=new JTextField(20);//�������Գ�����ˮ�ܶ���ı���
		jtfTotalprice.setEditable(false);//���ı��򲻿����޸�
		
		
		
		panel1.add(label);//�����ˮ�ܶ�ı�ǩ
		panel1.add(jtfTotalprice);
		
		Year=new JLabel("ѡ���꣺");
		Month=new JLabel("ѡ���£�");
		Day=new JLabel("ѡ���գ�");
		yearI=new Integer[100];
		int b=2015;
		for(int i=0;i<100;i++){
			//����forѭ�������������䵽��ѡ����
			yearI[i]=b+1;
			b=b+1;
		}
		monthI=new Integer[12];
		int c=0;
		for(int i=0;i<12;i++){
			monthI[i]=c+1;
			c=c+1;
		}
		dayI=new Integer[31];
		int d=0;
		for(int i=0;i<31;i++){
			dayI[i]=d+1;
			d=d+1;
		}
		
		YearForC=new JComboBox<Integer>(yearI);
		MonthForC=new JComboBox<Integer>(monthI);
		DayForC=new JComboBox<Integer>(dayI);
		buttonQuery=new JButton("��ѯ��ˮ");
		buttonQuery.addActionListener(new ButtonAction());
		buttonQuery.setActionCommand("��ѯ");
		
		jpanel.add(Year);
		jpanel.add(YearForC);
		jpanel.add(Month);
		jpanel.add(MonthForC);
		jpanel.add(Day);
		jpanel.add(DayForC);
		jpanel.add(buttonQuery);
		
		contentPane.add(panel1,BorderLayout.SOUTH);//�·�������������������ˮ�ܶ�
		contentPane.add(jpanel,BorderLayout.NORTH);//�Ϸ������������������¼�����������
		contentPane.add(jsp,BorderLayout.CENTER);//�м������������ʢ�ű��
		
		
		this.add(contentPane);//����������ӵ�������
		
	}
	private class queryDishAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("������ˮ")){
				new TodayFlowView();
			}else if(e.getActionCommand().equals("������ˮ")){
				new ThisMonthFlowView();
			}else if(e.getActionCommand().equals("������ˮ")){
				new ThisYearFlowView();
			}else if(e.getActionCommand().equals("ɾ����ˮ")){
				String s=JOptionPane.showInputDialog(null,"������ˮid");
				int i=Integer.valueOf(s);
				OrderDao OD=new OrderDao();
				int i1=OD.deleteOrder(i);
				if(i1==0){
					JOptionPane.showMessageDialog(null, "��ˮɾ��ʧ��");
				}else{
					JOptionPane.showMessageDialog(null, "��ˮ��Ϊ"+s+"�Ķ��������ѱ���ɾ����");
				}
			}
		}
		
	}
	
	public class ButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��ѯ")){
				jtfTotalprice.setText("");
				l.setText("�鿴�������ˮ");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				Integer year_l=(Integer)YearForC.getSelectedItem();
				Integer month_l=(Integer)MonthForC.getSelectedItem();
				Integer Day_l= (Integer)DayForC.getSelectedItem();
				int Day_2=Day_l.intValue()+1;
				Integer next_Day=new Integer(Day_2);
//				System.out.println("�꣺"+year_l+" �£�"+month_l+" �գ�"+Day_l);
				String now_year_m_d=year_l.toString()+"."+month_l.toString()+"."+Day_l.toString();
				String next_year_m_d=year_l.toString()+"."+month_l.toString()+"."+next_Day.toString();
				Date nowDay;
				Date nextDay;
				try {
					nowDay=new SimpleDateFormat("yyyy.MM.dd").parse(now_year_m_d);
					//���и�ʽת��
					nextDay=new SimpleDateFormat("yyyy.MM.dd").parse(next_year_m_d); 
//					System.out.println(nowDay);
					Timestamp t=new Timestamp(nowDay.getTime());
					Timestamp t1=new Timestamp(nextDay.getTime());
					OrderDao OD=new OrderDao();
					List<OrderModel> lom=OD.queryByDay(nowDay, nextDay);
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
					panel1.repaint();
				}catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				}
				
				jsp.repaint();
			}
		
		}
		
		
	
	public static void main(String[] args) {
		new FlowManageView();
	}

}
