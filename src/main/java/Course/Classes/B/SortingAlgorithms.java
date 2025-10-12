package Course.Classes.B;

import java.util.Vector;

public class SortingAlgorithms {




    public static void insertionsSort(int[] v){
        int size = v.length;

        for (int i = 1; i < size; i ++) {
            int key = v[i];
            int j = i-1;
            for (; j >= 0 && v[j] > key; j--){
                v[j+1] = v[j];
            }
            v[j+1] = key;
        }
    }

    public static void selectionSort(int[] v){
        for(int j = 0; j< v.length; j++) {
            int minIndex = j;
            for (int i = j+1; i < v.length; i++) {
                if (v[i] < v[minIndex]) {
                    minIndex = i;
                }
            }
            swap(v,j,minIndex);
        }
    }

    public static void swap(int[]v, int a, int b){
        int tmp= v[a];
        v[a] = v[b];
        v[b] = tmp;
    }

    public static void main(String[] args) {

        int[] vet = {2, 7, 6, 40, 1, 30};

        selectionSort(vet);


        for (int i : vet){
            System.out.println(i);
        }
    }


}
