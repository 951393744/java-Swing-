package com.ynu.dinnerorder.view;

import java.awt.BasicStroke;  
import java.awt.Color;  
import java.awt.Component;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;  
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;  
import java.util.Calendar;
import java.util.List;

import com.ynu.dinnerorder.databasemodel.ItemModel;  
  
//ʵ��Printable�ӿ� ���ڴ�����ӡ����  
public class OederDaYin implements Printable {  
    private List<ItemModel> list;   
    private Font font;
    private String total;
   
    // ���캯��  
    public OederDaYin(List<ItemModel> lcd,String total) {  
        this.list = lcd;  
       this.total=total;
    }  
  
    /** 
     * @param Graphicָ����ӡ��ͼ�λ��� 
     * @param PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ�ŵ�1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595�� 
     *            842�㣩 
     * @param pageIndexָ��ҳ�� 
     **/  
    @Override  
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {  
        Component c = null;  
        // ת����Graphics2D �õ�����  
        Graphics2D g2 = (Graphics2D) graphics;  
        // ���ô�ӡ��ɫΪ��ɫ  
        g2.setColor(Color.black);  
  
        // ��ӡ�������  
        double x = pageFormat.getImageableX();  
        double y = pageFormat.getImageableY();  
  
        // ����  
        float[] dash1 = { 4.0f };  
        // width - �� BasicStroke �Ŀ�ȡ��˿�ȱ�����ڻ���� 0.0f��������������Ϊ  
        // 0.0f���򽫱ʻ�����Ϊ������Ŀ���豸�Ϳ������ʾ���õ���ϸ������  
        // cap - BasicStroke �˵��װ��  
        // join - Ӧ����·���߶ν��㴦��װ��  
        // miterlimit - б�Ӵ��ļ������ơ�miterlimit ������ڻ���� 1.0f��  
        // dash - ��ʾ����ģʽ������  
        // dash_phase - ��ʼ����ģʽ��ƫ����  
  
        // ���û�����  
        g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));  
  
        // ���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�  
        font = new Font("����", Font.PLAIN, 11);  
        g2.setFont(font);// ��������  
        float heigth = font.getSize2D();// ����߶�  
        // ����  
        g2.drawString("��Ҷ̩���˲���", (float) x, (float) y + heigth);  
        float line = 2 * heigth;  
  
        font = new Font("����", Font.PLAIN, 8);  
        g2.setFont(font);// ��������  
        heigth = font.getSize2D();// ����߶�  
  
        
       
  
        line += heigth;  
        // ��ʾ����  
        g2.drawString("����", (float) x + 20, (float) y + line);  
        g2.drawString("����", (float) x + 60, (float) y + line);  
        g2.drawString("����", (float) x + 85, (float) y + line);  
        g2.drawString("�ܶ�", (float) x + 115, (float) y + line);  
        line += heigth;  
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));  
  
        // ��4��  
        line += heigth;  
  
        // ��ʾ����  
        for (ItemModel IM:list) {  
  
            
  
            g2.drawString(IM.getDishm().getDish_name(), (float) x, (float) y + line);  
            g2.drawString(String.valueOf(IM.getDishm().getDish_price())+"Ԫ", (float) x + 60, (float) y + line);  
            g2.drawString(String.valueOf(IM.getItem_num())+"��", (float) x + 90, (float) y + line);  
            g2.drawString(String.valueOf(IM.getItem_totalprice())+"Ԫ", (float) x + 120, (float) y + line);  
            line += heigth;  
  
        }  
        
        line += heigth;  
  
        g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));  
        line += heigth;  
  
        
        g2.drawString("�ϼ�:" + total, (float) x + 70, (float) y + line);  
        line += heigth;  
        line += heigth;  
        g2.drawString("ʱ��:" + Calendar.getInstance().getTime().toLocaleString(), (float) x, (float) y + line);  
  
        line += heigth;  
        g2.drawString("�����ٴι��ٽ�Ҷ̩���˲���!", (float) x + 20, (float) y + line);  
  
        line += heigth;  
        g2.drawString("ǮƱ�뵱����壬�뿪��̨ˡ������", (float) x, (float) y + line);  
        switch (pageIndex) {  
        case 0:  
  
            return PAGE_EXISTS;  
        default:  
            return NO_SUCH_PAGE;  
  
        }  
  
    } 
}
