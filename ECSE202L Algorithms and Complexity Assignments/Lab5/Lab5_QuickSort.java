package lab_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/*
"I have done this assignment on my own. I have not copied any code from
another student or any online source. I understand if my code is found
similar to somebody else's code, my case can be sent to the Disciplinary
committee of the institute for appropriate action."
*/

//Harshit Singhai
//E16CSE147
//B2


public class Lab5_QuickSort {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Number of students in class: ");
        int number_of_students = scan.nextInt();
        
        Read_Input read = new Read_Input();
        read.input(number_of_students);
        
        Read_Output a= new Read_Output();
        Node[] node = a.read_output(number_of_students);
        
        QuickSort_marks quickSort_marks = new QuickSort_marks();
        quickSort_marks.sort(node);
        quickSort_marks.print();
        System.out.println("Sorted Successfully based on marks.. Check output file");
        
        QuickSort_Name quickSort_name = new QuickSort_Name();
        Node[] sorted = quickSort_name.quickSort(node , 0 , node.length-1);
        quickSort_name.print_output(sorted);
        System.out.println("Sorted Successfully based on name.. Check output2 file");
    }
}

class Read_Input {
  
    public void input(int number_of_students) {
    try {
        Scanner scan = new Scanner(System.in);
        FileWriter input_file = new FileWriter("input.txt");
        input_file.write("Number of student in class: " + number_of_students + System.lineSeparator());
        int complexity = 0;
        do {
            String temp = scan.nextLine();
            input_file.write(temp +System.lineSeparator());
            number_of_students = number_of_students-1;
            complexity ++;
        }while(number_of_students > 0);
        
        input_file.close();
        
    }   catch (Exception e){
            System.out.println("Exception");
        }
    }
}

class QuickSort_marks  {
     
    private Node array[];
    private int length;
    int complexity = 0;
    public void sort(Node[] inputArr) {

        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lower, int high) {
        
        int i = lower;
        int j = high;
        int pivot = array[lower+(high-lower)/2].marks;
        
        while (i <= j) {
        
            while (array[i].marks > pivot) {
                i++;
                complexity++;
            }
            while (array[j].marks < pivot) {
                j--;
                complexity++;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
            complexity++;
        }
        if (lower < j)
            quickSort(lower, j);
        if (i < high)
            quickSort(i, high);
        complexity++;
    }
 
    private void exchangeNumbers(int i, int j) {
        Node temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void print() throws IOException{
        FileWriter output_file = new FileWriter("Lab5_output.txt");
        for(Node x : array){
            output_file.write(x.name + " " + x.enroll + " " + x.marks + System.lineSeparator());
        }
        output_file.write("Complexity is "+complexity);
        output_file.close();
    }
}

class QuickSort_Name  {
     static int complexity;
     public static Node[] quickSort(Node[] node_array, int p, int r){
        
         if(p<r){
            int q = partition(node_array,p,r);
            quickSort(node_array,p,q);
            quickSort(node_array,q+1,r);
            complexity++;
            }
        return node_array;
    }
    
    private static int partition(Node[] node_array, int p, int r) {

        String x = node_array[p].name;
        int i = p-1 ;
        int j = r+1 ;
        
        while (true) {
            i++;
            while ( i< r && node_array[i].name.compareTo(x) < 0){
                i++;
                complexity++;
            }
            j--;
            while (j>p && node_array[j].name.compareTo(x) > 0){
                j--;
                complexity++;
            }
            
            if (i < j){
                swap(node_array, i, j);
            }
                
            else{
                return j;
            }
            complexity++;
        }
    }

    private static void swap(Node[] node_array, int i, int j){
        Node temp = node_array[i];
        node_array[i] = node_array[j];
        node_array[j] = temp;
    }
     
    public static void print_output(Node[] node_array) throws IOException{
        FileWriter output_file = new FileWriter("Lab5_output2.txt");
        for(Node x : node_array){
            output_file.write(x.name + " " + x.enroll + " " + x.marks + System.lineSeparator());
        }
        output_file.write("Complexity is "+complexity);
        output_file.close();
    }
}

class Read_Output{
    
    public Node[] read_output(int length) throws FileNotFoundException{
        
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            Node[] node = new Node[length];
            int i = 0;
            scan.nextLine();
            while(scan.hasNextLine()){
                String temp = scan.nextLine();
                String[] temp_array = temp.split(" ");
                node[i] = new Node(temp_array[0] , Integer.parseInt(temp_array[1]),Integer.parseInt(temp_array[2]));
                i++;
            }
            return node;
    }
}

class Node{
    String name;
    int enroll;
    int marks;
    
    public Node(String name, int enroll, int marks){
        this.name = name;
        this.enroll = enroll;
        this.marks = marks;
    }
}
