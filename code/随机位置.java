//��ʼ�������ά����
    public void initData(){
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16,17,18,19,20,21,22,23,24 };
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
