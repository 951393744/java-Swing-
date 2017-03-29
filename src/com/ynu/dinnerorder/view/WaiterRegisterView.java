package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ynu.dinnerorder.databasedao.WaiterDao;

public class WaiterRegisterView extends JFrame{
	/*
	 * @Author:����
	 * @Test:ͨ��
	 */
	private JTextField u_name_text;//
    private JPasswordField u_pass_text;//
    private JPasswordField u_pass_suretext;//
    private JTextField u_tel_text;//
    private JTextField u_a_text;//
    private JComboBox<String> sex;//
    private String[] s={"��","Ů"};//
    JPanel indexpanel;//
	
	
	public WaiterRegisterView(){
		init();
	}
	
	public void init(){
		/*ͼƬ�ز�*/
		ImageIcon x = new ImageIcon("E://�ز�//cha.jpg");
		ImageIcon v = new ImageIcon("E://�ز�//gou.jpg");
		
		indexpanel=new JPanel();
		//��ҳ������
		BoxLayout box=new BoxLayout(indexpanel, BoxLayout.Y_AXIS);
		indexpanel.setLayout(box);
		//���ú�ʽ���ֹ�����
		
		JPanel usernamepanel=new JPanel();
		JLabel usernameLab=new JLabel("�� �� ����");
		u_name_text=new JTextField(20);
		usernamepanel.add(usernameLab);
		usernamepanel.add(u_name_text);
		//Ϊ�û�������һ���ռ�
		
        JPanel passwordpanel=new JPanel();
        JLabel passwordLab=new JLabel("��       ��:");
        u_pass_text=new JPasswordField(20);
        u_pass_text.setEchoChar('*');
        passwordpanel.add(passwordLab);
        passwordpanel.add(u_pass_text);
        //Ϊ�������һ���ռ�
		
        JPanel passwordsurepanel=new JPanel();
        JLabel passwordsureLab=new JLabel("ȷ������:");
        u_pass_suretext=new JPasswordField(20);
        u_pass_suretext.setEchoChar('*');
        passwordsurepanel.add(passwordsureLab);
        passwordsurepanel.add(u_pass_suretext);
        //Ϊȷ���������ģ�����һ���ռ�
        
        JPanel telephonepanel=new JPanel();
        JLabel telephoneLab=new JLabel("�绰����:");
        u_tel_text=new JTextField(20);
        telephonepanel.add(telephoneLab);
        telephonepanel.add(u_tel_text);
        //Ϊ�绰�������һ���ռ�

        JPanel actorpanel=new JPanel();
        JLabel actorLab=new JLabel("����ְλ:");
        u_a_text=new JTextField(20);
        actorpanel.add(actorLab);
        actorpanel.add(u_a_text);
        //Ϊ����ְλ���ѡ�����һ���ռ�
        
        JPanel sexpanel=new JPanel();
        
        JLabel sexLab=new JLabel("�Ա�:");
        sex=new JComboBox<String>(s);
        sexpanel.add(sexLab,BorderLayout.EAST);
        sexpanel.add(sex,BorderLayout.EAST);
        sexpanel.setSize(10, 10);
        //Ϊ�Ա��ѡ�����һ���ռ�
        
        JPanel bottonpanel=new JPanel();
        JButton j1=new JButton("ȷ��ע��");
        j1.setIcon(v);/**/
        j1.addActionListener(new registerAction());
        j1.setActionCommand("ȷ��ע��");
        JButton j2=new JButton("ȡ��ע��");
        j2.addActionListener(new registerAction());
        j2.setActionCommand("ȡ��ע��");
        j2.setIcon(x);/**/
        bottonpanel.add(j1);
        bottonpanel.add(j2);
        //Ϊ��ť�������¼��ͺ���
        
		indexpanel.add(usernamepanel);
		indexpanel.add(passwordpanel);
		indexpanel.add(passwordsurepanel);
		indexpanel.add(telephonepanel);
		indexpanel.add(actorpanel);
		indexpanel.add(sexpanel);
		indexpanel.add(bottonpanel);
		//�����к�����ӵ���ҳ�Ŀռ���ȥ��Ȼ��ע���¼�
		
		this.add(indexpanel);
		//����ҳ�Ŀռ���ӵ�������ȥ
		
		this.setSize(400, 400);
		this.setLocation(500, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("�û�ע�����");
	}
	
	private class registerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("ȷ��ע��")){
				//��ȷ�ϰ�ť�����¼�ʱ�򣬾ͻ����������ݿ�Ĳ�����������д�����ݿ��С�
				String u_name=u_name_text.getText().trim();
				String u_pass=u_pass_text.getText().trim();
				String u_surepass=u_pass_suretext.getText().trim();
				String u_tel=u_tel_text.getText().trim();
				String u_a=u_a_text.getText().trim();
				String u_sex;
				if(sex.getSelectedItem().equals("��")){
					u_sex="��";
				}else{
					u_sex="Ů";
				}
				WaiterDao wd;
				if(!u_pass.equals(u_surepass))
				{
					JOptionPane.showMessageDialog(indexpanel,"����������벻һ��");
				}else if(u_pass.length()>=6&&u_pass.length()<=20)
				{
					if(u_name.isEmpty()){
						JOptionPane.showMessageDialog(indexpanel,"������������ǿյ�");
					}else{
				wd=new WaiterDao();
				boolean b=wd.registerWaiter(u_name, u_pass, u_tel, u_a, u_sex);
				if(b==true){
					JOptionPane.showMessageDialog(indexpanel,"ע��ɹ�");
						dispose();
						WaiterLoginView wlv=new WaiterLoginView();
						wlv.setP_s(u_pass);
						wlv.setU_s(u_name);
						wlv.setB_for_jr2(true);
						wlv.changeT();
						wlv.changeB();
				}else{
					JOptionPane.showMessageDialog(indexpanel,"��������Ѿ����ڣ��뻻һ��");
				}
					}
				}else if(u_pass.length()<6){
					JOptionPane.showMessageDialog(indexpanel,"���������̣�����6~20λ֮��");
				}else if(u_pass.length()>20){
					JOptionPane.showMessageDialog(indexpanel,"����������������6~20λ֮��");
				}
				
				
			}else if(e.getActionCommand().equals("ȡ��ע��")){
				u_name_text.setText("");
				u_pass_text.setText("");
				u_pass_suretext.setText("");
				u_tel_text.setText("");
				u_a_text.setText("");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new WaiterRegisterView();
	}

}
