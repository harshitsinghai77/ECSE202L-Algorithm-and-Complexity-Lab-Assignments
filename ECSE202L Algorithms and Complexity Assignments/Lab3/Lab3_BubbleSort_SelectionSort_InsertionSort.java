package lab_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*"I have done this assignment on my own. I have not copied any code from
another student or any online source. I understand if my code is found
similar to somebody else's code, my case can be sent to the Disciplinary
committee of the institute for appropriate action." */


public class Lab3_BubbleSort_SelectionSort_InsertionSort {

    static FileWriter file_writer;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        file_writer = new FileWriter("output_num.txt");
        
        Random();
        File file = new File("Lab3_input.txt");
        Scanner scan = new Scanner(file);
        
        int[] num = new int[100];
        int i = 0;
        while(scan.hasNextInt()){
            num[i] = scan.nextInt();
            i++;
        }
        
        file_writer.write("Bubble Sort : " + System.lineSeparator());
        BubbleSort(num);
        file_writer.write(System.lineSeparator());
        file_writer.write("Selection Sort : " + System.lineSeparator());
        SelectionSort(num);
        file_writer.write(System.lineSeparator());
        file_writer.write("Insertion Sort : " + System.lineSeparator());
        InsertionSort(num);
        
        
        file_writer.close();
    }
    
    public static void Random() {
      try{
            FileWriter file = new FileWriter("Lab3_input.txt");
            for(int i=0; i<100; i=i+1){
                file.write((int)(Math.random()*100) + System.lineSeparator());
            }
            file.close();  
      } catch (Exception e){
      
      }
    }
    
    public static void BubbleSort (int[] a) throws IOException{
        int[] b = a;
        int length = b.length;
        int complexity = 0;
        for(int i=0; i<length-1; i = i+1){
            complexity++;
            for(int j = 0; j<length-1-i; j=j+1){
                complexity++;
                if(b[j] > b[j+1]){
                    int temp = b[j+1];
                    b[j+1] = b[j];
                    b[j] = temp;
                }
            }
        }
        for(int x : b){
            file_writer.write(x + System.lineSeparator());
        }
        file_writer.write("Complexity for Bubble sort is "+complexity);
    }
    
    public static void SelectionSort (int[] a) throws IOException{
        int[] b = a;
        int length = b.length;
        int complexity = 0;
        for(int i = 0; i<length-1; i=i+1){
            int min_index = i;
            complexity ++;
            for(int j = i+1; j<length; j=j+1){
                if(b[j] < b[min_index]){
                    min_index = j;
                }
                complexity++;
            }
            int temp = b[min_index];
            b[min_index] = b[i];
            b[i] = temp;
        }
        for(int x : b){
            file_writer.write(x + System.lineSeparator());
        }
        file_writer.write("Complexity for Selection sort is "+complexity);
    }
    
    public static void InsertionSort (int[] a) throws IOException{
        int[] b = a;
        int length = b.length;
        int complexity = 0;
        for(int i=0; i<length; i=i+1){
            int current = b[i];
            int j = i-1;
            complexity++;
            while( j >= 0 && b[j] > current){
                b[j+1] = b[j];
                j = j-1;
                complexity++;
            }
            b[j+1] = current ;
        }
        for(int x : b){
            file_writer.write(x + System.lineSeparator());
        }
        file_writer.write("Complexity for Insertion sort is "+complexity);
    }
    
}
    
    
