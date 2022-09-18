package proxy.my;

import java.util.Arrays;

public class Calculate {
    public static int getCountNotDuplicate(double[] mas) {
//        int count = 0;
//        boolean flag = true;
//        for (int i = 0; i < mas.length - 1; i++) {
//            for (int j = i + 1; j < mas.length; j++) {
//                if (mas[i] == mas[j]) {
//                    System.arraycopy(mas, j + 1, mas, j, mas.length - (j + 1));
//                    mas = Arrays.copyOf(mas, mas.length - 1);
//                    j--;
//                    flag = false;
//                }else if(j == mas.length-1) {
//                    count++;
//                }
//            }
//            if (flag) {
//                count++;
//            }
//            flag = true;
//        }
//        return count;
//
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            int w = 0;
            for (int j = 0; j < mas.length; j++)
                if (mas[i] == mas[j]) w++;
            if (w == 1)
                count++;
        }
        return count;
    }
}
