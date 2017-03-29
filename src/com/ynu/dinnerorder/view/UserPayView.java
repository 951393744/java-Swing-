package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
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

import com.ynu.dinnerorder.databasedao.DeskDao;
import com.ynu.dinnerorder.databasedao.ItemDao;
import com.ynu.dinnerorder.databasedao.NormalUserDao;
import com.ynu.dinnerorder.databasedao.OrderDao;
import com.ynu.dinnerorder.databasemodel.DeskModel;
import com.ynu.dinnerorder.databasemodel.ItemModel;
import com.ynu.dinnerorder.databasemodel.NormalUserModel;





public class UserPayView extends JFrame {

	private JPanel contentPane;
	//������
	private String[] s={"����id","������","��λ","��Ʒ��id","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ�ܼ�","��Ʒ����","����״̬","�û��绰","�û���ַ"};
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	private JTable table;
	//��ָ�봴��
	
	private JTextField textID;
	//����ID��
	private JPanel jpanel;
	private JTextField jtfTotalprice;
	//�ܼ۸��ı���
	
	private int u_id;
	
	private JTextField textName;
	//�����ı���
	private JLabel l;
	//�Ϸ�������ǩָ��
	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public UserPayView(){
		init();
	}
	
	public void init(){
		setTitle("����");
		jsp=new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//����ָ�룬����ʵ�����м���������
		
		contentPane = new JPanel();
		//ʵ����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setResizable(true);
		setVisible(true);
		setBounds(70, 20, 450, 300);
		setSize(1200,700);
		
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setLayout(new FlowLayout());
		
		JButton jb1=new JButton("δ����Ķ���");
		jb1.addActionListener(new queryDishAction());
		jb1.setActionCommand("δ����");
		JButton jb2=new JButton("�Ѹ���Ķ���");
		jb2.addActionListener(new queryDishAction());
		jb2.setActionCommand("�Ѹ���");
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
		JButton jb5=new JButton("�鿴�����ܶ�");
		jb5.addActionListener(new queryDishAction());
		jb5.setActionCommand("�ܶ�");
		JButton jb3=new JButton("ȷ�ϸ���");
		jb3.addActionListener(new queryDishAction());
		jb3.setActionCommand("ȷ�ϸ���");
		
		jtfTotalprice=new JTextField(15);
		jtfTotalprice.setEditable(false);
		JButton jb4=new JButton("��ӡ����");
		jb4.addActionListener(new queryDishAction());
		jb4.setActionCommand("��ӡ");
		
		
		panel1.add(label);
		panel1.add(textID);
		panel1.add(jb5);
		panel1.add(jtfTotalprice);
		panel1.add(jb3);
		
		panel1.add(jb4);
		
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
			if(e.getActionCommand().equals("δ����")){
				l.setText("�鿴δ�������");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				//�¼����������һϵ�б�����
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByState(4);
				//����δ����״̬��ѯ���ݿ�����������
				for(ItemModel im:lim){
					//���
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
						s="δ�ʹ�";
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
			}else if(e.getActionCommand().equals("�Ѹ���")){
				l.setText("�鿴�Ѹ������");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				jsp.setViewportView(table);
				
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryItemByState(5);
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
			}else if(e.getActionCommand().equals("ȷ�ϸ���")){
				String s=textID.getText().trim();
				ItemDao ID=new ItemDao();
				int i=0;
				List<ItemModel> lim=ID.equeryByOrderId(s);
				//ͨ��id��ѯ��������
				for(ItemModel im:lim){
					i=im.getItem_state();
				}
				if(i>=5){
					JOptionPane.showMessageDialog(null, "�ö����Ѿ�����");
				}else{
				int i_u_id=0;
				int i_desk_id=0;
				double totalprice=0;
				
				ItemDao ID1=new ItemDao();
				List<ItemModel> lim1=ID1.equeryByOrderId(s,4);
				if(lim==null){
					JOptionPane.showMessageDialog(null, "�����Ų�����Ŷ,������һЩ");
				}else{
					String u_dish="";
				for(ItemModel IM:lim1){
					totalprice=totalprice+IM.getItem_totalprice();
					//��ȡ�����Ŷ�Ӧ�����е�Ʒ�ļ۸��ܼ۸�
					i_u_id=IM.getN_user_m().getNu_id();
					//��ȡ�����Ŷ�Ӧ���û�id
					i_desk_id=IM.getDeskm().getDesk_id();
					//��ȡ��λid
					u_dish=u_dish+(IM.getDishm().getDish_name()+"("+IM.getItem_num()+"��)  ");
					//�����û���Ĳ�Ʒ�����ֺ͵�͵ķ���
					System.out.println(u_dish);
				}
				NormalUserDao NUD=new NormalUserDao();
				NormalUserModel NUM=NUD.equeryN_User(i_u_id);
				//��ѯ�û���
				
				DeskDao DD=new DeskDao();
				DeskModel DM=DD.equeryDeskById(i_desk_id);
				DD.updateDeskStateById(0,i_desk_id);
				//��ѯ��λid
				
				/*
				 * �Ѷ���д����ˮ��
				 */
				OrderDao OD=new OrderDao();
				Date d=new Date();
				int i1=OD.addOrder(d, NUM.getNu_name(), totalprice, s,DM.getDesk_name(),NUM.getNu_address(),NUM.getNu_telephone(),u_dish);
				//���²�Ʒ״̬������Ϊ�Ѹ���
				if(i1>0){
			       JOptionPane.showMessageDialog(null, "ȷ�ϳɹ���");
			       int i2=ID.UpdateStateByOrderId(s, 5);
				}else{
					JOptionPane.showMessageDialog(null, "����ʧ����");
				}
				}
				Double ble=new Double(totalprice);
				//��ʾ�ܼ۸�
				jtfTotalprice.setText(ble.toString()+"Ԫ");
				repaint();
				}
			}else if(e.getActionCommand().equals("��ѯ�û�������صĶ�����Ϣ")){
				//����������ѯ��������
				l.setText("�鿴�û�������ϸ��Ϣ��");
				dtm=new DefaultTableModel(s, 0);
				table=new JTable(dtm);
				table.setGridColor(Color.orange);
				table.setAutoResizeMode(WIDTH);
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
			else if(e.getActionCommand().equals("�ܶ�")){
				//�鿴�����ܶ�
				String s=textID.getText().trim();
				double totalprice=0;
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryByOrderId(s);
				if(lim==null){
					JOptionPane.showMessageDialog(null, "�����Ų�����Ŷ,������һЩ");
				}else{
				for(ItemModel IM:lim){
					totalprice=totalprice+IM.getItem_totalprice();
				}
				}
                 Double ble=new Double(totalprice);
				
				jtfTotalprice.setText(ble.toString()+"Ԫ");
				repaint();
			}else if(e.getActionCommand().equals("��ӡ")){
				//��ӡ��ʱ�����һϵ�в���
				String s1=textID.getText().trim();
				String s2=jtfTotalprice.getText().trim();
				ItemDao ID=new ItemDao();
				List<ItemModel> lim=ID.equeryByOrderId(s1);
				if(lim.get(0).getItem_state()==4){
					JOptionPane.showMessageDialog(contentPane, "������û����");
				}else{
				OederDaYin ODY=new OederDaYin(lim, s2);
				Book book = new Book();  
			      
		        //    ���ó�����  
		      
		        PageFormat pf = new PageFormat();  
		      
		        pf.setOrientation(PageFormat.PORTRAIT);  
		      
		        //    ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����  
		      
		        Paper p = new Paper();  
		      
		        p.setSize(590,840);//ֽ�Ŵ�С   
		      
		        p.setImageableArea(10,10, 590,840);//A4(595 X 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72  
		      
		        pf.setPaper(p);  
		        //    �� PageFormat �� Printable ��ӵ����У����һ��ҳ��  
		        book.append(ODY, pf);  
		      
		      
		      
		         //��ȡ��ӡ�������  
		         
		         PrinterJob job = PrinterJob.getPrinterJob();        
		      
		         // ���ô�ӡ��  
		      
		         job.setPageable(book);      
		         try {  
		      
		             //������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ  
		      
		             boolean a=job.printDialog();  
		      
		             if(a)  
		      
		             {          
		      
		             job.print();  
		      
		             }  
		      
		      
		      
		         } catch (PrinterException e1) {  
		      
		             e1.printStackTrace();  
		      
		         }  
			}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new UserPayView();
	}

}
