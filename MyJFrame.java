package ��Դ��ϰ;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


//�̳�JFrame����Ӽ�����
public class MyJFrame extends JFrame implements KeyListener, ActionListener {
    //����һ����ά����
    int[][] datas = new int[5][5];
    //����һ����ά����Ϊʤ������µ���������ʤ���ж�
    int[][] victory = new int[][]{{1, 2, 3 ,4 ,5},{6, 7, 8 ,9 ,10},{11, 12, 13 ,14 ,15},{16, 17, 18 ,19 ,20} , {21, 22, 23 ,24 ,0}};
    //���㲽��
    int step = 0;
    int x0 = 0;
    int y0 = 0;
    
    
    public MyJFrame(){
        //��ʼ������
        JFrame();
        //��ʼ������
        initData();
        //��ʼ��ͼƬ
        initImage();
        //���ڿɼ�
        this.setVisible(true);
    }
    
    //���ڳ�ʼ��
    public void JFrame(){
    	JFrame frame = new JFrame();
        //���ô��ڿ��
    	this.setSize(830,800);
        //��������������Ļ������
        this.setLocationRelativeTo(null);
        //��������ʾ�����ϲ�
        this.setAlwaysOnTop(true);
        //�˳�����
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //���ڱ���
        this.setTitle("ƴͼ v1.0");
        //���̿���
        this.addKeyListener(this);
        //ȡ������
        this.setLayout(null);
        
        
        
        
    }
    
    
    
    //������ʼ��ͼƬ����
    public void initImage(){
        this.getContentPane().removeAll();
        JLabel label_step = new JLabel("����" + step);
        label_step.setBounds(50, 20,100,20);
        this.add(label_step);
        if (victory()){
            ImageIcon imageIcon = new ImageIcon("image\\win.png");
            JLabel jLabel = new JLabel(imageIcon);
            jLabel.setBounds(514/2 - 266/2,230,266,88);
            this.add(jLabel);
        }
        for (int i = 0; i < datas.length; i++){
            for (int j = 0; j < datas[i].length; j++) {
                int data = datas[i][j];
                if (data != 0){
                	ImageIcon imageIcon = new ImageIcon("D:\\ѧϰ\\��Դʵ��\\��ϰ��Ŀ\\29-WangXF-YuanZT\\image\\image\\img" + data + ".jpeg");
                	//ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ԭ\\Desktop\\31369f5b2f4b66ed605621e29c9dc3d.png");
                    //������һ��JLabel����
                    JLabel jLabel = new JLabel(imageIcon); 
                    //����jLabel�Ŀ������
                    jLabel.setBounds(j * 100 + 50,i *100 + 70,200,200);
                    this.add(jLabel);
                }
            }
        }
        //��ӱ���ͼƬ
        ImageIcon  background = new ImageIcon("C:\\Users\\Ԭ\\Desktop\\941a44b36c0a99b365cd75e197b9bce.jpg");
        JLabel backgroundJLabel = new JLabel(background);
        backgroundJLabel.setBounds(26, 30, 450,484);
        this.add(backgroundJLabel);
        //�������������»���
        this.getContentPane().repaint();
    }
    
    
    //�˷��������ж���Ϸ�Ƿ����
    public boolean victory() {
        //�ж������Ƿ����datas��victory
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] != victory[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    //��ʼ�������ά����
    public void initData(){
        int[] temp = new int[25];
        for (int i = 0; i < 25; i++) {
            temp[i] = i;
        }

        for (int i = 0; i < temp.length; i++) {
            Random r = new Random();
            //��Ϊtemp�ĳ���Ϊ25����.nextInt��temp.length����������˼�����ɷ�ΧΪ[0,25)�������
            int index = r.nextInt(temp.length);
            //�����ǻ���������������������Ҫ����������Ԫ�غ͵�ǰѭ����Ԫ�ػ�λ��
            int number = temp[i];
            temp[i] = temp[index];
            temp[index] = number;
        }
        for (int i = 0; i < temp.length; i++) {
            //���Ѿ������˺���������ڶ�ά�����б���
            datas[i /5][i % 5] = temp[i];
            if (temp[i] == 0){
                x0 = i / 5;
                y0 = i %5;
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    
    //��ѹ
    @Override
    public void keyPressed(KeyEvent e) {

    }
    
    
    //�ɿ�
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        move(keyCode);
        //���»��ƽ���
        initImage();
    }
    //ͼƬ�ƶ�����
    public void move(int keyCode){
        //37��������е����
        if (keyCode == 37){
            //��ֹ�����ұߵ�һ�л�Ҫ�����ƶ�����
            if (y0 == 4){
                return;
            }
            datas[x0][y0] = datas [x0][y0 + 1];
            datas[x0][y0 +1] = 0;
            y0++;
            step++;
        //38������
        }else if (keyCode == 38){
            if (x0 == 4){
                return;
            }
            datas[x0][y0] = datas [x0 + 1][y0];
            datas[x0 +1][y0] = 0;
            x0++;
            step++;
        //��
        }else if (keyCode == 39){
            if (y0 == 0){
                return;
            }
            datas[x0][y0] = datas [x0][y0 - 1];
            datas[x0][y0 - 1] = 0;
            y0--;
            step++;
        //��
        }else if (keyCode == 40){
            if (x0 == 0){
                return;
            }
            datas[x0][y0] = datas [x0 - 1][y0];
            datas[x0 - 1][y0] = 0;
            x0--;
            step++;
        }
        //ǿ�ƹ�λ   w��
        else if (keyCode == 87){
            datas = new int[][]{{1, 2, 3 ,4 ,5},{6, 7, 8 ,9 ,10},{11, 12, 13 ,14 ,15},{16, 17, 18 ,19 ,20} , {21, 22, 23 ,24 ,0},};
        }
        //���´���   Q��
        else if(keyCode == 81) {
        	actionPerformed(null);
        }
    }

    
    @Override
    //������Ϸ����ͼƬ������У���������
    public void actionPerformed(ActionEvent e) {
        initData();
        step = 0;
        initImage();
        
    }
    
    
    
}
    
