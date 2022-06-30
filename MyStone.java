package com.study.work0630;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//继承JFrame类添加监听器
public class MyStone extends JFrame implements KeyListener, ActionListener {
    private final int width = 830;
    private final int height = 800;
    private final int bgWidth = 700;
    private final int bgHeight = 700;
    private final String bgPath = "D:\java\image\\bg7.jpg";
    // 切图
    int[][] datas = new int[5][5];

    //计算步骤
    int step = 0;
    int x0 = 0;
    int y0 = 0;
    public MyStone(){
        //初始化窗体
        initJFrame();
        //初始化菜单
        initMenu();
        //将创建的有序数组随机排列后重新存入二维数组
        initData();
        //初始化图片
        initImage();
        //创建窗体
        this.setVisible(true);
    }
    //创建初始化窗体方法
    public void initJFrame(){
        //设置窗体宽高
        this.setSize(width,height);
        //将窗体设置在屏幕正中央
        this.setLocationRelativeTo(null);
        //将窗体覆盖过其他窗体
        this.setAlwaysOnTop(true);
        //点击叉子退出程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //给窗体设置标题
        this.setTitle("开心拼图");
        //让界面添加键盘监听
        this.addKeyListener(this);
        //取消内部居中放置方式
        this.setLayout(null);
    }
    //创建初始化菜单方法
    public void initMenu(){
        //创建菜单对象
        JMenuBar jMenuBar;
        jMenuBar = new JMenuBar();
        //设置菜单宽高
        jMenuBar.setSize(514,20);
        //创建一个选项
        JMenu jMenu = new JMenu("功能");
        //创建一个条目
        JMenuItem jMenuItem = new JMenuItem("重新游戏");
        //将创建的条目绑定监听器
        jMenuItem.addActionListener(this);
        //把条目放到选项里
        jMenu.add(jMenuItem);
        //把选项放到菜单里
        jMenuBar.add(jMenu);
        //把菜单放到窗体里
        this.setJMenuBar(jMenuBar);
    }
    //创建初始化图片方法
    public void initImage(){
        this.getContentPane().removeAll();
        JLabel label_step = new JLabel("步数" + step);
        label_step.setBounds(50, 20,100,20);
        this.add(label_step);
        for (int i = 0; i < datas.length; i++){
            for (int j = 0; j < datas[i].length; j++) {
                int data = datas[i][j];
                if (data != 0){
                    ImageIcon imageIcon = new ImageIcon("D:\java\image\image\\img ("+data+").jpeg");
                    //创建了一个JLabel对象
                    JLabel jLabel = new JLabel(imageIcon);
                    //设置jLabel的宽高坐标
                    jLabel.setBounds(j * 92 + 165,i *92 + 120,100,100);
                    this.add(jLabel);
                }
            }
        }
        //添加背景图片
        ImageIcon  background = new ImageIcon(bgPath);
        JLabel backgroundJLabel = new JLabel(background);
        backgroundJLabel.setBounds(50, 0, bgWidth,bgHeight);
        this.add(backgroundJLabel);
        //将整个界面重新绘制
        this.getContentPane().repaint();
    }

    //初始化随机二维数组
    public void initData(){
        int[] temp = new int[25];
        for (int i = 0; i < 25; i++) {
            temp[i] = i;
        }

        for (int i = 0; i < temp.length; i++) {
            Random r = new Random();
            //因为temp的长度为16，而.nextInt（temp.length）方法的意思是生成范围为[0,16)的随机数
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
            if (y0 == 3){
                return;
            }
            datas[x0][y0] = datas [x0][y0 + 1];
            datas[x0][y0 +1] = 0;
            y0++;
            step++;
        //38代表上
        }else if (keyCode == 38){
            if (x0 == 3){
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
        //作弊键  一步胜利   w键
        else if (keyCode == 87){
            datas = new int[][]{{1, 2, 3 ,4},{5, 6, 7 ,8},{9, 10, 11 ,12},{13, 14, 15 ,0},};
        }
    }

    @Override
    //重新游戏，把图片随机排列，步数清零
    public void actionPerformed(ActionEvent e) {
        initData();
        step = 0;
        initImage();

    }

    public static void main(String[] args) {
        MyStone myJFrame = new MyStone();
        myJFrame.initJFrame();
    }
}

