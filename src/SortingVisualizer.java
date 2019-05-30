import sort.*;
import java.util.Scanner;

public class SortingVisualizer {
    private static final int SIZE = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] random_array = Randomized(SIZE);

        while(true) {
            System.out.print("원본 배열 : " + toString(random_array) + "\n");
            System.out.println("############################");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Heap Sort");
            System.out.println("9. 배열 재설정");
            System.out.println("0. Exit");
            System.out.println("############################");
            System.out.print("Input >> ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    new Selection(random_array, SIZE);
                    Delay();
                    break;
                case 2:
                    new Insertion(random_array, SIZE);
                    Delay();
                    break;
                case 3:
                    new Merge(random_array, SIZE);
                    Delay();
                    break;
                case 4:
                    new Quick(random_array, SIZE);
                    Delay();
                    break;
                case 5:
                    new Heap(random_array, SIZE);
                    break;
                case 9:
                    random_array = Randomized(SIZE);
                    Delay();
                    break;
                case 0:
                    System.exit(-1);
                    break;
            }
        }
    }

    private static int[] Randomized(int size) {
        int[] random_array = new int[size];
        for(int i = 0; i < size; i++) {
            random_array[i] = (int) (Math.random() * 100) + 1;
            if(Duplication(random_array, i)) {
                i--;
            }
        }
        return random_array;
    }

    private static boolean Duplication(int[] obj, int i) {
        for(int j = 0; j < i; j++) {
            if(obj[i] == obj[j]) {
                return true;
            }
        }
        return false;
    }

    private static String toString(int[] obj) {
        StringBuilder string = new StringBuilder("{");
        for(int i = 0; i < SIZE-1; i++) {
            string.append(obj[i]).append(", ");
        }
        string.append(obj[SIZE-1]).append("}");
        return string.toString();
    }

    private static void Delay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("계속 하려면 아무키나 입력하세요...");
        scanner.nextLine();
    }

}
