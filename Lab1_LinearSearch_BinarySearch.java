package Lab_Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Lab1_LinearSearch_BinarySearch{
    
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.print("User defined number : ");
        String num = scan.next();
        System.out.println("Iterations Required (Linear Search): " + new LinearSearch().Linear(num)); 
        
        SortedArray sorted = new SortedArray();
        int[] array = sorted.SortedArray();
        BinarySearch binary = new BinarySearch();
        System.out.println("Iteration Required (Binary Search): " + binary.BinarySearch(array, Integer.parseInt(num), 0, array.length-1)) ;
    }
    
}

class Random{
    
    public Random() throws IOException{
        FileWriter file = new FileWriter("output.txt");
        for(int i=1; i<1001; i=i+1){
            file.write((int)(Math.random()*99) + System.lineSeparator());
        }
        file.close();
    }
}

class LinearSearch{
    
    public int Linear(String find) throws FileNotFoundException{
        
        File file = new File("output.txt");
        Scanner scan = new Scanner(file);
        
        int iteration = 0;
        
        while(scan.hasNext()){
            if(find.equals(scan.next())){
                return iteration;
            }
            iteration++;
        }
        return iteration;
    }
}

class SortedArray{
    
    public int[] SortedArray() throws FileNotFoundException{
        File file = new File("output.txt");
        Scanner scan = new Scanner(file);
        
        int[] array = new int[1000];
        int i = 0;
        while(scan.hasNextInt()){
            array[i] = scan.nextInt();
            i++;
        }
        
        MergeSort merge = new MergeSort();
        merge.sort(array , 0 ,array.length-1);
       
        return array;
    }
    
}

class MergeSort {
    void merge(int arr[], int l, int m, int r)   {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i){
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j){
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
     void sort(int arr[], int l, int r){
        if (l < r){
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
     
}

class BinarySearch{
    int i = 0;
    
    public int BinarySearch(int[] a, int find, int low , int high){
        
        int mid = low + (high - low)/2;
        if(a[mid] == find){
            return i;
        }
        
        if(a[mid] > find){
            i=i+1;
            return BinarySearch(a , find , low , mid-1);
        }
        
        if(a[mid] < find){
            i=i+1;
            return BinarySearch(a , find , mid+1 , high); 
        }
        return -1;
    }
    
}





