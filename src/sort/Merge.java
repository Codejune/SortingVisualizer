package sort;

import java.util.Arrays;

public class Merge {
    private int size;
    private int count = 1;

    public Merge(int[] data, int size) {
        this.size = size;
        int[] clone = data.clone();
        System.out.println("원본 배열 : ");
        PrintArray(clone);
        MergeSort(clone, 0, size - 1);
    }

    private void MergeSort(int[] data, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            MergeSort(data, left, mid);
            MergeSort(data, mid + 1, right);
            Combine(data, left, mid, right);
        }
    }

    private void Combine(int[] data, int left, int mid, int right) {
        int[] temp = new int[size];
        int[] original = data.clone();
        int i = left;
        int j = mid + 1;
        int position = left;

        /* 분할 정렬된 list의 합병 */
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[position++] = data[i];
                i++;
            } else {
                temp[position++] = data[j];
                j++;
            }
        }

        // 남아 있는 값들을 일괄 복사
        if (i > mid) {
            for (int l = j; l <= right; l++)
                temp[position++] = data[l];
        }
        // 남아 있는 값들을 일괄 복사
        else {
            for (int l = i; l <= mid; l++)
                temp[position++] = data[l];
        }

        // 배열 sorted[](임시 배열)의 리스트를 배열 list[]로 재복사
        for (int l = left; l <= right; l++) {
            data[l] = temp[l];
        }

        System.out.println("\n" + count + "번째 정렬 : ");
        if (!(Arrays.equals(data, original)))
            PrintArray(data);
        else
            System.out.println("변동 없음");
        count++;
    }

    private void PrintArray(int[] obj) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj[i] / 2; j++)
                System.out.print("=");
            System.out.print(" " + obj[i] + "\n");
        }
    }
}
