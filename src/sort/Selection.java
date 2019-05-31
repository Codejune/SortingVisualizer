package sort;

import java.util.Arrays;

public class Selection {
    private int size;
    private int density;

    public Selection(int[] data, int size, int density) {
        this.size = size;
        this.density = density;
        int[] clone = data.clone();
        SelectionSort(clone);
    }

    private void SelectionSort(int[] data) {
        int obj_index;
        int count = 1;
        int[] original = data.clone();
        System.out.println("원본 배열 : ");
        PrintArray(data);
        for (int i = size - 1; i > 0; i--) {
            System.out.println("\n" + count + "번째 정렬 : ");
            obj_index = i;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[obj_index]) {
                    obj_index = j;
                }
            }
            Swap(data, i, obj_index);
            if (!(Arrays.equals(data, original)))
                PrintArray(data);
            else
                System.out.println("변동 없음");
            original = data.clone();
            count++;
        }
    }

    private void Swap(int[] data, int end_index, int obj_index) {
        int temp;
        temp = data[obj_index];
        data[obj_index] = data[end_index];
        data[end_index] = temp;
    }

    private void PrintArray(int[] obj) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj[i] / density; j++)
                System.out.print("=");
            System.out.print(" " + obj[i] + "\n");
        }
    }
}
