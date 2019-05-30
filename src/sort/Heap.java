package sort;

public class Heap {
    private int depth = 0;
    private int size;

    public Heap(int[] data, int size) {
        int[] clone = new int[size + 1];
        System.arraycopy(data, 0, clone, 1, size);
        this.size = size;
        Heapify(clone);
    }


    /*
    private int[] BuildHeap(int[] data) {

    }
    */

    /*
        left_index = 2 * index + 1
        right_index = 2 * index + 2
     */
    private void Insert(int[] data, int[] temp, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        if(temp[index] == -1)
            temp[index] = data[index];
        else if(temp[left] == -1) {
            temp[left] = data[index];
            depth++;
            if(temp[left] > temp[index])
                Swap(temp, index, index / 2);
        } else if (temp[right] == -1){
            temp[right] = data[index];
            if(temp[right] > temp[index])
                Swap(temp, index, index / 2);
        } else {
            for(int i = index; i < Math.pow(2, depth); i++) {
                if(temp[i] == -1) {
                    Insert(data, temp, i/2);
                    break;
                }
            }
        }
        while(temp[index] > temp[index/2]) {
            if(index / 2 == 0)
                break;
            Swap(temp, index, (index / 2));
            index = index / 2;
        }

    }

    private void Heapify(int[] data) {

        int[] temp = new int[size + 1];
        Initialization(temp, -1);

        for(int i = 1; i < data.length; i++) {
            Insert(data, temp, i);
        }
        int[] heap_data = new int[size];
        System.arraycopy(temp, 1, heap_data, 0, size);
        data = heap_data;
        PrintArray(data);
    }

    private void Initialization(int[] data, int value) {
        for(int i = 0; i < data.length; i++) {
            data[i] = value;
        }
    }

    private void Swap(int[] data, int end_index, int obj_index) {
        int temp;
        temp = data[obj_index];
        data[obj_index] = data[end_index];
        data[end_index] = temp;
    }

    /*
    private void HeapSort(int[] data) {

    }
    */

    private void PrintArray(int[] obj) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj[i] / 2; j++)
                System.out.print("=");
            System.out.print(" " + obj[i] + "\n");
        }
    }
}
