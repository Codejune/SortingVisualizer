import sort.*;
import time.TimeMeasurement;

import java.util.Scanner;

public class SortingVisualizer {
    private static final int SIZE = 16;
    private static int density = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeMeasurement time = new TimeMeasurement();
        int[] random_array = Randomized();

        while (true) {
            System.out.print("원본 배열 : " + toString(random_array) + "\n");
            System.out.println("############################");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Heap Sort");
            System.out.println("8. 표현 밀도 재설정");
            System.out.println("9. 배열 재설정");
            System.out.println("0. Exit");
            System.out.println("############################");
            System.out.print("Input >> ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    time.start();
                    new Selection(random_array, SIZE, density);
                    System.out.println("측정 시간 : " + time.end());
                    Pause();
                    break;
                case 2:
                    time.start();
                    new Insertion(random_array, SIZE, density);
                    System.out.println("측정 시간 : " + time.end());
                    Pause();
                    break;
                case 3:
                    time.start();
                    new Merge(random_array, SIZE, density);
                    System.out.println("측정 시간 : " + time.end());
                    Pause();
                    break;
                case 4:
                    time.start();
                    new Quick(random_array, SIZE, density);
                    System.out.println("측정 시간 : " + time.end());
                    Pause();
                    break;
                case 5:
                    time.start();
                    new Heap(random_array, SIZE, density);
                    System.out.println("측정 시간 : " + time.end());
                    Pause();
                    break;
                case 8:
                    System.out.print("밀도(1 ~) [기본값 : 1] >> ");
                    density = scanner.nextInt();
                    break;
                case 9:
                    random_array = Randomized();
                    break;
                case 0:
                    System.exit(-1);
                    break;
            }
        }
    }

    private static int[] Randomized() {
        int[] random_array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            random_array[i] = (int) (Math.random() * 100) + 1;
            if (Duplication(random_array, i)) {
                i--;
            }
        }
        return random_array;
    }

    private static boolean Duplication(int[] obj, int i) {
        for (int j = 0; j < i; j++) {
            if (obj[i] == obj[j]) {
                return true;
            }
        }
        return false;
    }

    private static String toString(int[] obj) {
        StringBuilder string = new StringBuilder("{");
        for (int i = 0; i < SIZE - 1; i++) {
            string.append(obj[i]).append(", ");
        }
        string.append(obj[SIZE - 1]).append("}");
        return string.toString();
    }

    private static void Pause() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("계속 하려면 아무키나 입력하세요...\n");
        scanner.nextLine();
    }
}
