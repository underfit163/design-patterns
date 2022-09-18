package alg;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] mas = {4, 2, 3, 1, 5, 6, 7, 8, 0, 0, 0, -1, -2};
        int h = mas.length / 2;
//        while (h >= 1) {
//            for (int i = h; i < mas.length; i++) {
//                int k = i;
//                while (k >= h && mas[k] < mas[k - h]) {
//                    double temp = mas[k];
//                    mas[k] = mas[k - h];
//                    mas[k - h] = temp;
//                    k -= h;
//                }
//            }
//            h /= 2;
//        }

        h = 1;
        while (h >= 1) {
            for (int i = h; i < mas.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (mas[j] == 0) {
                        double temp = mas[j];
                        mas[j] = mas[j - h];
                        mas[j - h] = temp;
                    } //else break;// остановка перемещения солдата
                }
            }
            h /= 2;
        }

//        for (int i = 1; i < mas.length; i++) {
//            for (int j = i; j >= 1; j--) {
//                if (mas[j-1] == 0) {
//                    double temp = mas[j];
//                    mas[j] = mas[j - 1];
//                    mas[j - 1] = temp;
//                } //else break;// остановка перемещения солдата
//            }
//        }
        for (double ma : mas) {
            System.out.println(ma + " ");
        }
    }
}
