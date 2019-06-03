package sort;

public class Heap {
    private int depth = 0;
    private int size;
    private int density;

    public Heap(int[] data, int size, int density) {
        int[] clone = new int[size + 1];
        this.size = size;
        this.density = density;
        System.arraycopy(data, 0, clone, 1, size);
        Heapify(clone);
    }

    private void Heapify(int[] data) {
        int[] temp = new int[size + 1];
        Initialization(temp);

        System.out.println("원본 배열 : ");
        PrintArray(data);

        for (int i = 1; i < data.length; i++) {
            Insert(data, temp, i);
        }

        data = temp;
        System.out.println("\nHeapify 배열 : ");
        PrintArray(data);
        HeapSort(data);
    }

    /*
        left_index = 2 * index
        right_index = 2 * index + 1
     */
    private void Insert(int[] data, int[] temp, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        if (temp[index] == -1)
            temp[index] = data[index];
        else if (temp[left] == -1) {
            temp[left] = data[index];
            depth++;
            if (temp[left] > temp[index])
                Swap(temp, index, index / 2);
        } else if (temp[right] == -1) {
            temp[right] = data[index];
            if (temp[right] > temp[index])
                Swap(temp, index, index / 2);
        } else {
            for (int i = index; i < Math.pow(2, depth); i++) {
                if (temp[i] == -1) {
                    Insert(data, temp, i / 2);
                    break;
                }
            }
        }

        // 해당 vertex 가 올바른 위치로 가게하는 알고리즘
        while (temp[index] > temp[index / 2]) {
            if (index / 2 == 0)
                break;
            Swap(temp, index, (index / 2));
            index = index / 2;
        }

    }

    private void HeapSort(int[] data) {
        int high = size;
        for (int i = 1; i <= size - 1; i++) {
            Delete(data, high--);
            System.out.println("\n" + i + "번째 정렬 : ");
            PrintArray(data);
        }
    }

    private void Delete(int[] data, int high) {
        int index = 1;
        int left = 2 * index;
        int right = 2 * index + 1;


        if (data[index] > data[left] || data[index] > data[right])
            Swap(data, index, high--);
        // 해당 vertex 가 올바른 위치로 가게하는 알고리즘
        while (true) { // 왼쪽 오른쪽 둘 다 비어있지 않을때
            if (left > high || right > high)
                break;
            else if (data[index] > data[left] && data[index] > data[right])
                break;
            else if (data[right] < data[left]) { // 왼쪽이 더 클때
                Swap(data, index, left);
                index = left;
                left = 2 * index;
                right = 2 * index + 1;
            } else if (data[left] < data[right]) { // 오른쪽이 더 클때
                Swap(data, index, right);
                index = right;
                left = 2 * index;
                right = 2 * index + 1;
            }
        }
    }

    private void Initialization(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    private void Swap(int[] data, int end_index, int obj_index) {
        int temp;
        temp = data[obj_index];
        data[obj_index] = data[end_index];
        data[end_index] = temp;
    }

    private void PrintArray(int[] obj) {
        for (int i = 1; i <= size; i++) {   // HeapSort 의 데이터 배열은 index = 1 부터 시작
            for (int j = 0; j < obj[i] / density; j++)
                System.out.print("=");
            System.out.print(" " + obj[i] + "\n");
        }
    }
}
