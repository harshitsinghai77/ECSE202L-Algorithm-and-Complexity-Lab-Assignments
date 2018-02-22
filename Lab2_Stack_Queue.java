package Lab_Assignment;

import java.util.EmptyStackException;

    
public class Lab2_Stack_Queue {
        
    public static void main(String[] args) {
        System.out.println("Stack: ");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(1);
        stack.push(50);
        stack.push(20);
        stack.push(80);
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println("Time complexity for Push() is O(1) ");
        System.out.println("Time complexity for Pop() is O(1) ");
        System.out.println("Time complexity for Peek() is O(1) ");
        System.out.println("Time complexity for Display() is O(n) because display method iterates through the size of the stack and prints all the remaining elements of the stack ");
        
        System.out.println("Queue: "); 
        
        Queue queue = new Queue(5);  
          
         queue.enqueue(23);  
         queue.enqueue(2);  
         queue.enqueue(73);  
         queue.enqueue(21); 
         queue.enqueue(27); 
         queue.display();
         queue.dequeue();  
         queue.dequeue();  
         queue.dequeue();  
         queue.display();
         
        System.out.println("Time complexity for Enqueue() is O(1) ");
        System.out.println("Time complexity for Dequeue() is O(1) ");
        System.out.println("Time complexity for Display() is O(n) because display method iterates through the size of the queue and prints all the remaining elements left in the queue ");
        
        
    }
    
}

class Stack {
    
    private int arr[];
    private int size;
    private int top;
    
    public Stack(int size){
        this.size = size;
        arr = new int[size];
    }
    
    public boolean isEmpty(){
        if(top == 0 ){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        if(top == size){
            return true;
        }
        return false;
    }
    
    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        arr[top] = element;
        top++;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException(); 
        }
        return arr[--top];
    }
    
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException(); 
        }
        return arr[top];
    }
    
    public void display(){
        
        for(int i=0;i<top;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    
}

class Queue {  
        int capacity;  
        int arr[];  
        int size = 0;  
        int top = -1;  
        int rear = 0;  
         
        public Queue(int arr_size){
            this.capacity  =  arr_size;
            this.arr = new int[capacity];
        }
        
        public void enqueue(int number) {  
         if (top < capacity - 1) {  
          top++;  
          arr[top] = number;  
         } else {  
          System.out.println("Maximum size reached !");  
         }  

        }  

        public void dequeue() {  
         if (top >= rear) {  
          rear++;  
          
         } else {  
          System.out.println("No elements left to dequeue !");  
         }  
        }  

        public void display() {  
         if (top >= rear) {  
             
          for (int i = rear; i <= top; i++) {  
           System.out.print(arr[i] + " ");  
          }
             System.out.println();
         }  
        }  

       

}  