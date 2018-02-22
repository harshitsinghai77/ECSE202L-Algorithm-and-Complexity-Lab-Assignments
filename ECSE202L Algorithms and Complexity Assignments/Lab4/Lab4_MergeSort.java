package lab_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Lab4_MergeSort {
    
    static FileWriter file_write;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File file = new File("Lab4_input.txt");
        Scanner scan = new Scanner(file);
        file_write = new FileWriter("lab4_output.txt");
        int[] a = new int[100];
        int i = 0;
        int iteration = 0;
        while(scan.hasNextInt()){
            a[i] = scan.nextInt();
            i++;
            iteration++;
        }
        
        file_write.write("Number of iteration for reading and writing is "+ iteration +System.lineSeparator());
        MergeSort merge = new MergeSort();
        merge.Sort(a, a.length);
        merge.print_array();
        file_write.close();
    }
}

class MergeSort{
    
    int[] a;
    int[] aux;
    int n;
    int iteration = 0;
    Lab4_MergeSort lab = new Lab4_MergeSort();
    
    public void Sort(int[] a , int length){
        this.a = a;
        this.aux = new int[length];
        MergeSort(a , 0 , length-1);
    }
    
    public void MergeSort(int[] a , int low , int high){
        if(low < high){
            int middle = (low+high)/2;
            MergeSort(a,low,middle);
            MergeSort(a,middle+1,high);
            Merge(a,low,middle,high);
        }
    }
    
    public void Merge(int[] a , int low, int middle, int high){
        
        for(int i = low; i <= high; i=i+1){
            aux[i] = a[i];
        }
        
        int i = low;
        int j = middle+1;
        int k = low;
        
        while( i<= middle && j <= high){
            if(aux[i] <= aux[j]){
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];  
                j++;
            }
            k++;
            iteration++;
        }
        
        while (i <= middle){
            a[k] = aux[i];
            k++;
            i++;
            iteration++;
        }
    }
    public void print_array() throws IOException{
        for(int x: a){
            lab.file_write.write(x + System.lineSeparator());
        }
        lab.file_write.write("Iteration for merge sort are " + iteration+ System.lineSeparator());
        duplicate(a);
    }
    
    public void duplicate(int[] a) throws IOException{
        int[] temp =  new int[a.length];
        int j = 0;
        int n = a.length;
        int iteration = 0;
        for(int i = 0; i < n-1; i=i+1){
            if(a[i] != a[i+1]){
                temp[j++] = a[i];  
                iteration++;
            }
        }
        temp[j++] = a[n-1];     
        
        for (int i=0; i<j; i++){  
            a[i] = temp[i];  
        }   
        
        lab.file_write.write("Removing duplicate number from the array" + System.lineSeparator());
        
        for(int x : temp){
            if(x != 0  ){
                lab.file_write.write(x + System.lineSeparator());
            }
        }
    }
    
}