//初始化随机二维数组
    public void initData(){
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16,17,18,19,20,21,22,23,24 };
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
