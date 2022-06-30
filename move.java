   import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//继承JFrame类添加监听器

//图片移动方法
    public class move(int keyCode){
    	int[][] datas = new int[4][4];
    	 int[][] victory = new int[][]{{1, 2, 3 ,4},{5, 6, 7 ,8},{9, 10, 11 ,12},{13, 14, 15 ,0},};
    	 int step = 0;
    	    int x0 = 0;
    	    int y0 = 0;
    	    public MyJFrame(){
    }
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
        }}
    
   




