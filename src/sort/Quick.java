package sort;

import java.util.Arrays;

public class Quick {
    private int size;
    private int density;
    private int count = 1;

    public Quick(int[] data, int size, int density) {
        this.size = size;
        this.density = density;
        int[] clone = data.clone();
        System.out.println("원본 배열 : ");
        PrintArray(data);
        QuickSort(clone, 0, size - 1);
    }

    private void QuickSort(int[] data, int left, int right) {
        if (left < right) {
            int p = Partition(data, left, right);
            QuickSort(data, left, p - 1);
            QuickSort(data, p + 1, right);
        }
    }

    private int Partition(int[] data, int left, int right) {
        int[] original = data.clone();
        int low = left;
        int high = right;
        int pivot = data[left];

        // low 와 high 가 교차할 때까지 반복(low < high)
        do {
            do { // data[low] 가 pivot 보다 작으면 계속 low 를 증가
                low++; // low = left + 1 에서 시작
            } while (low <= right && data[low] < pivot);

            // data[high] 가 pivot 보다 크면 계속 high 를 감소
            while (high >= left && data[high] > pivot)
                high--; // high 는 right 에서 시작

            // 만약 low 와 high 가 교차하지 않았으면 data[low]를 data[high]와 교환
            if (low < high) {
                Swap(data, low, high);
            }
        } while (low < high);

        // low 와 high 가 교차했으면 반복문을 빠져나와 data[left]와 data[high]를 교환
        Swap(data, left, high);
        System.out.println("\n" + count + "번째 정렬 : ");
        if (!(Arrays.equals(data, original)))
            PrintArray(data);
        else
            System.out.println("변동 없음");
        count++;
        // pivot 의 위치인 high 를 반환
        return high;
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
