package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import com.ynu.dinnerorder.databasedao.NormalUserDao;
import com.ynu.dinnerorder.databasedao.WaiterDao;
import com.ynu.dinnerorder.databasemodel.NormalUserModel;
import com.ynu.dinnerorder.databasemodel.WaiterModel;

public class WaiterLoginView extends JFrame{
	/*
	 * @Author:��Ծ
	 * @Test:ͨ��
	 */
	private JLabel lab_1;//�ܱ���
	private JLabel usernameLabel;//�û���
	private JLabel passwordLabel;//����
	private JPanel indexPanel;//��ҳ����
	private JPanel usernamePanel;//�û�����һ�������
	private JPanel background;//������һ�������
	private JPanel passwordPanel;//������һ������
	private JPanel bottonPannel;//��ͨ��ť��һѡ�������
	private JPanel radioPanel;//��ѡ��ť��һѡ�������
	private JTextField usernameText;//�û������������
	private String u_s;
	private String p_s;
	private boolean b_for_jr1;
	private boolean b_for_jr2;
	private JPasswordField passwordText;//�������������
	private JButton loginBotton;//��½��ť
	private JButton registerBotton;//ע�ᰴť
	private JRadioButton jr1;
	private JRadioButton jr2;
	
	public WaiterLoginView(){
		//���췽��������ִ��init����
		init();
	}
	
/*
 * ���û�ע����֮��ע���ʱ��������û������������ʾ�ڵ�½ҳ���ϣ���������������Ǵﵽ���Ŀ��
 */
public void changeT(){
	usernameText.setText(u_s);
	passwordText.setText(p_s);
}

public void changeB(){
	jr1.setSelected(b_for_jr1);
	jr2.setSelected(b_for_jr2);
}
	

public boolean isB_for_jr1() {
	return b_for_jr1;
}

public void setB_for_jr1(boolean b_for_jr1) {
	this.b_for_jr1 = b_for_jr1;
}

public boolean isB_for_jr2() {
	return b_for_jr2;
}

public void setB_for_jr2(boolean b_for_jr2) {
	this.b_for_jr2 = b_for_jr2;
}

public String getU_s() {
		return u_s;
	}


	public void setU_s(String u_s) {
		this.u_s = u_s;
	}


	public String getP_s() {
		return p_s;
	}


	public void setP_s(String p_s) {
		this.p_s = p_s;
	}


public void init(){
	   setTitle("��½");
	   ImageIcon ic=new ImageIcon("images/loginindex.jpg");
	   JLabel  imageIndex=new JLabel();
	   imageIndex.setIcon(ic);
	   JPanel jp=new JPanel();
	   jp.add(imageIndex);
	   jp.setOpaque(false);//����͸��
//	   imageIndex.setBounds(0, 0, this.getWidth(), this.getHeight());
//	   getLayeredPane().add(imageIndex,new Integer(Integer.MIN_VALUE));
//	   JPanel jp=(JPanel)getContentPane(); 
//	   jp.setOpaque(false);//����͸��
	   
	
	   lab_1=new JLabel("��ӭ����**������ͽ���");
	   JPanel lab_1panel=new JPanel();
	   lab_1panel.add(lab_1);
	   
	   ImageIcon img = new ImageIcon("e:\\�ز�\\jiaoye1.jpg");
	   JLabel label = new JLabel(img);
	   
	   indexPanel=new JPanel();
	   BoxLayout bl=new BoxLayout(indexPanel, BoxLayout.Y_AXIS);
	   indexPanel.setLayout(bl);
	   //���к�ʽ���֣���ֱ����
	   indexPanel.setOpaque(false);
	   
	   
	   usernameLabel=new JLabel("�û���:");
	   usernameText=new JTextField(20);
	   usernamePanel=new JPanel();
	   usernamePanel.add(usernameLabel);
	   usernamePanel.add(usernameText);
	   usernamePanel.setSize(100, 100);
	   background = new JPanel();
	   background.add(label);
	   background.setSize(300, 300);
	   //�û�����һ�����в���
	   
	   passwordLabel=new JLabel("���룺");
	   passwordText=new JPasswordField(20);
	   passwordText.setEchoChar('*');
	   passwordPanel=new JPanel();
	   passwordPanel.add(passwordLabel);
	   passwordPanel.add(passwordText);
	   //������һ�����в���
	   
	   JPanel radiopanel=new JPanel();
	   jr1=new JRadioButton("��ͨ�û�");
	   jr2=new JRadioButton("����Ա");
	   radiopanel.add(jr1);
	   radiopanel.add(jr2);
	   //�����ͨ�û��ͷ���Ա��ť
	   
	   Icon denglu = new ImageIcon("E://�ز�//denglu.jpg");
	   Icon zhuce = new ImageIcon("E://�ز�//zhuce.jpg");
	  
	   
	   bottonPannel=new JPanel();
	   loginBotton=new JButton("��½",denglu);
	   loginBotton.addActionListener(new loginAction());
	   loginBotton.setActionCommand("��½");
	   //��½��ť����¼�
	   registerBotton=new JButton("ע��",zhuce);
	   registerBotton.addActionListener(new loginAction());
	   registerBotton.setActionCommand("ע��");
	   //ע�ᰴť����¼�
	   JButton j_not=new JButton("����");
	   j_not.addActionListener(new loginAction());
	   j_not.setActionCommand("����");
	   //���ð�ť����¼�
	   bottonPannel.add(loginBotton);
	   bottonPannel.add(registerBotton);
	   bottonPannel.add(j_not);
	   //��ť������в���
	   
	   indexPanel.add(lab_1panel);
	   indexPanel.add(usernamePanel);
	   indexPanel.add(passwordPanel);
	   indexPanel.add(radiopanel);
	   indexPanel.add(bottonPannel);
	   //�Ѹ���pannel�ӵ���ҳpannel��ȥ
	   
	   
	   this.add(indexPanel);
	 
	   //���ڼ�����ҳ
	   this.setResizable(false);
	   
	   this.setSize(300, 300);
	   this.setLocation(500, 200);
	   this.setVisible(true);
	   
   }
	
   private class loginAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��½")){
			//������ť�¼���ʱ�򣬶����ݿ�������Ӳ��ҽ��бȶ�
			String u_name=usernameText.getText().trim();
			String u_password=passwordText.getText().trim();
			if(jr2.isSelected()&&!jr1.isSelected()){
			WaiterDao wd=new WaiterDao();
			WaiterModel wm=wd.loginWaiter(u_name, u_password);
			if(wm==null){
				JOptionPane.showMessageDialog(indexPanel, "�û��������벻��ȷ����������һ��");
			}else{
				JOptionPane.showMessageDialog(indexPanel, "��½�ɹ�");
				//�����½�ɹ�����ô
				Integer i=wm.getW_id();
				i.toString();
				WaiterIndexView wiv=new WaiterIndexView();
				wiv.setW_id(i.toString());
				wiv.setW_name(wm.getW_name());
				wiv.setW_password(wm.getW_password());
				wiv.setW_telephone(wm.getW_telephone());
				wiv.setW_actor(wm.getW_actor());
				wiv.changeForLogin();
				dispose();
			}
			}else if(jr1.isSelected()&&!jr2.isSelected()){
				NormalUserDao nud=new NormalUserDao();
				NormalUserModel num=nud.loginNormalUser(u_name, u_password);
				if(num==null){
					JOptionPane.showMessageDialog(indexPanel, "�û��������벻��ȷ����������һ��");
				}else{
					JOptionPane.showMessageDialog(indexPanel, "��½�ɹ�");
					//�����½�ɹ�����ô
					Integer i=num.getNu_id();
					i.toString();
					UserIndexView wiv=new UserIndexView();
					wiv.setNu_id(i.toString());
					wiv.setNu_name(num.getNu_name());
					wiv.setNu_password(num.getNu_password());
					wiv.setNu_telephone(num.getNu_telephone());
					wiv.setNu_address(num.getNu_address());
					wiv.changeForLogin();
					dispose();
				}
				
			}else if(jr1.isSelected()&&jr2.isSelected()){
				JOptionPane.showMessageDialog(indexPanel, "ֻ��ѡ��һ����ɫ");
			}else if(!jr1.isSelected()&&!jr2.isSelected()){
				JOptionPane.showMessageDialog(indexPanel, "��ѡ����Ľ�ɫ");
			}
		}else if(e.getActionCommand().equals("ע��")){
			if(jr2.isSelected()&&!jr1.isSelected()){
				dispose();
			new WaiterRegisterView();
			}else if(jr1.isSelected()&&!jr2.isSelected()){
				dispose();
				new UserRegisterView();
			}else if(jr2.isSelected()&&jr1.isSelected()){
				JOptionPane.showMessageDialog(indexPanel, "ֻ��ѡ��һ����ɫע��");
			}else if(!jr2.isSelected()&&!jr1.isSelected()){
				JOptionPane.showMessageDialog(indexPanel, "��ѡ��һ����ɫע��");
			}
		}else if(e.getActionCommand().equals("����")){
			usernameText.setText("");
			passwordText.setText("");
		}
	}
	   
   }
   
	public static void main(String[] args) {
		new WaiterLoginView();
	}

}
