package 开源练习;

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


//继承JFrame类添加监听器
public class MyJFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个二维数组
    int[][] datas = new int[5][5];
    //创建一个二维数组为胜利情况下的数组用于胜利判断
    int[][] victory = new int[][]{{1, 2, 3 ,4 ,5},{6, 7, 8 ,9 ,10},{11, 12, 13 ,14 ,15},{16, 17, 18 ,19 ,20} , {21, 22, 23 ,24 ,0}};
    //计算步骤
    int step = 0;
    int x0 = 0;
    int y0 = 0;
    
    
    public MyJFrame(){
        //初始化窗口
        JFrame();
        //初始化数组
        initData();
        //初始化图片
        initImage();
        //窗口可见
        this.setVisible(true);
    }
    
    //窗口初始化
    public void JFrame(){
    	JFrame frame = new JFrame();
        //设置窗口宽高
    	this.setSize(830,800);
        //将窗口设置在屏幕正中央
        this.setLocationRelativeTo(null);
        //将窗口显示在最上层
        this.setAlwaysOnTop(true);
        //退出程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //窗口标题
        this.setTitle("拼图 v1.0");
        //键盘控制
        this.addKeyListener(this);
        //取消居中
        this.setLayout(null);
        
        
        
        
    }
    
    
    
    //创建初始化图片方法
    public void initImage(){
        this.getContentPane().removeAll();
        JLabel label_step = new JLabel("步数" + step);
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
                	ImageIcon imageIcon = new ImageIcon("D:\\学习\\开源实践\\练习项目\\29-WangXF-YuanZT\\image\\image\\img" + data + ".jpeg");
                	//ImageIcon imageIcon = new ImageIcon("C:\\Users\\袁\\Desktop\\31369f5b2f4b66ed605621e29c9dc3d.png");
                    //创建了一个JLabel对象
                    JLabel jLabel = new JLabel(imageIcon); 
                    //设置jLabel的宽高坐标
                    jLabel.setBounds(j * 100 + 50,i *100 + 70,200,200);
                    this.add(jLabel);
                }
            }
        }
        //添加背景图片
        ImageIcon  background = new ImageIcon("C:\\Users\\袁\\Desktop\\941a44b36c0a99b365cd75e197b9bce.jpg");
        JLabel backgroundJLabel = new JLabel(background);
        backgroundJLabel.setBounds(26, 30, 450,484);
        this.add(backgroundJLabel);
        //将整个界面重新绘制
        this.getContentPane().repaint();
    }
    
    
    //此方法用于判断游戏是否完成
    public boolean victory() {
        //判断数组是否相等datas和victory
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] != victory[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    //初始化随机二维数组
    public void initData(){
        int[] temp = new int[25];
        for (int i = 0; i < 25; i++) {
            temp[i] = i;
        }

        for (int i = 0; i < temp.length; i++) {
            Random r = new Random();
            //因为temp的长度为25，而.nextInt（temp.length）方法的意思是生成范围为[0,25)的随机数
            int index = r.nextInt(temp.length);
            //当我们获得索引的随机数后，我们需要将索引所在元素和当前循环的元素换位置
            int number = temp[i];
            temp[i] = temp[index];
            temp[index] = number;
        }
        for (int i = 0; i < temp.length; i++) {
            //将已经打乱了后的数组存放于二维数组中保存
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
    
    
    //按压
    @Override
    public void keyPressed(KeyEvent e) {

    }
    
    
    //松开
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        move(keyCode);
        //重新绘制界面
        initImage();
    }
    //图片移动方法
    public void move(int keyCode){
        //37代表键盘中的左键
        if (keyCode == 37){
            //防止在最右边的一列还要向右移动报错
            if (y0 == 4){
                return;
            }
            datas[x0][y0] = datas [x0][y0 + 1];
            datas[x0][y0 +1] = 0;
            y0++;
            step++;
        //38代表上
        }else if (keyCode == 38){
            if (x0 == 4){
                return;
            }
            datas[x0][y0] = datas [x0 + 1][y0];
            datas[x0 +1][y0] = 0;
            x0++;
            step++;
        //右
        }else if (keyCode == 39){
            if (y0 == 0){
                return;
            }
            datas[x0][y0] = datas [x0][y0 - 1];
            datas[x0][y0 - 1] = 0;
            y0--;
            step++;
        //下
        }else if (keyCode == 40){
            if (x0 == 0){
                return;
            }
            datas[x0][y0] = datas [x0 - 1][y0];
            datas[x0 - 1][y0] = 0;
            x0--;
            step++;
        }
        //强制归位   w键
        else if (keyCode == 87){
            datas = new int[][]{{1, 2, 3 ,4 ,5},{6, 7, 8 ,9 ,10},{11, 12, 13 ,14 ,15},{16, 17, 18 ,19 ,20} , {21, 22, 23 ,24 ,0},};
        }
        //重新打乱   Q键
        else if(keyCode == 81) {
        	actionPerformed(null);
        }
    }

    
    @Override
    //重新游戏，把图片随机排列，步数清零
    public void actionPerformed(ActionEvent e) {
        initData();
        step = 0;
        initImage();
        
    }
    
    
    
}
    
