package sort;

import java.util.Arrays;

/*
    삽입 정렬은 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후
    자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다.
    즉, 두 번째 자료는 첫 번째 자료,세 번째 자료는 두 번째와 첫 번째 자료, 네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비교한 후 자료가 삽입될 위치를 찾는다.
    자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.
    처음 Key 값은 두 번째 자료부터 시작한다.
 */
public class Insertion {
    private int size;
    private int density;

    public Insertion(int[] data, int size, int density) {
        this.size = size;
        this.density = density;
        int[] clone = data.clone();
        InsertionSort(clone);
    }

    private void InsertionSort(int[] data) {
        int key = 1;
        int count = 1;
        int[] original = data.clone();
        System.out.println("원본 배열 : ");
        PrintArray(data);
        for (int i = key; i < size; i++) {
            if (data[i] < data[i - 1]) {
                int j = i;
                while (data[j] < data[j - 1]) {
                    Swap(data, j, j - 1);
                    if (!(j == 1))
                        j--;
                }
            }
            System.out.println("\n" + count + "번째 정렬 : ");
            if (!(Arrays.equals(data, original)))
                PrintArray(data);
            else
                System.out.println("변동 없음");
            count++;
        }
    }

    private void PrintArray(int[] obj) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj[i] / density; j++)
                System.out.print("=");
            System.out.print(" " + obj[i] + "\n");
        }
    }

    private void Swap(int[] data, int end_index, int obj_index) {
        int temp;
        temp = data[obj_index];
        data[obj_index] = data[end_index];
        data[end_index] = temp;
    }
}
