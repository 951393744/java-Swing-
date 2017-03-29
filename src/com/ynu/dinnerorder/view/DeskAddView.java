package com.ynu.dinnerorder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.ynu.dinnerorder.databasedao.DeskDao;
import com.ynu.dinnerorder.databasedao.DishDao;


public class DeskAddView extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;


	
	public static void main(String[] args) {
		new DeskAddView();
	}
	
	public DeskAddView(){
		DeskAddViewInit();
	}
	
	/**
	 * Create the frame.
	 */
	public void DeskAddViewInit() {
		setResizable(false);
		setVisible(true);
		setTitle("�����λ��Ϣ");
		setBounds(400, 150, 450, 300);
		setSize(600,400);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		contentPane.add(panel,BorderLayout.NORTH);
		
		JLabel label = new JLabel("��λ���ƣ�");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JLabel label_2 = new JLabel("��λ������");
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3,BorderLayout.CENTER);
		panel_3.add(label_2);
		textArea = new JTextArea();
		textArea.setColumns(50);
		textArea.setRows(20);
		panel_3.add(textArea);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		contentPane.add(panel_4,BorderLayout.SOUTH);
		
		JButton button = new JButton("ȷ���ύ");
		button.addActionListener(new DishAddAction());
		button.setActionCommand("�ύ");
		button.setBackground(new Color(255, 0, 255));
		panel_4.add(button);
		
		JButton button_1 = new JButton("ȡ���ύ");
		button_1.addActionListener(new DishAddAction());
		button_1.setActionCommand("ȡ��");
		button_1.setBackground(new Color(255, 20, 147));
		panel_4.add(button_1);
	}
	
	private class DishAddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("�ύ")){
				DeskDao DD=new DeskDao();
				String d_name=textField.getText().trim();
				String d_desc=textArea.getText().trim();
			    DD.addDesk(d_name, d_desc);
				JOptionPane.showMessageDialog(contentPane, "��ӳɹ�");				
			}else if(e.getActionCommand().equals("ȡ��")){
				dispose();
			}
		}
		
	}

}
