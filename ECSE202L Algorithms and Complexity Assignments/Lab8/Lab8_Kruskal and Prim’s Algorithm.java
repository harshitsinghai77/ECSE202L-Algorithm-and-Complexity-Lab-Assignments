package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//Harshit Singhai
//E16CSE147
//B2

/*
"I have done this assignment on my own. I have not copied any code
from another student or any online source. I understand if my code is
found similarto somebody else's code, my case can be sent to the
Disciplinary committee of the institute for appropriate action."
*/

class Lab5{
    static FileWriter writer;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File("Lab8_input.txt"));
        writer = new FileWriter("Lab8_output.txt");
       
        int[] array  = new int[scan.nextInt()];
        int i = 0;
        while(scan.hasNext()){
            array[i] = scan.nextInt();
            i++;
        }
        ShellSort sort = new ShellSort();
        sort.sort(array);
        printArray(array);
        
        MinimumSpanningTree();
        writer.close();
        
    }
    
    static void printArray(int arr[]) throws IOException{
        int n = arr.length;
        for (int i=0; i<n; ++i){
            writer.write(arr[i] + " ");
        }
        System.out.println();
    }
    
    static void MinimumSpanningTree(){
        int V = 6;  
        int E = 8;  
        Graph graph = new Graph(V, E);
 
        graph.edge[0].src = 0  ;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 4;
 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 2;
 
        graph.edge[3].src = 2;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 3;
 
        graph.edge[4].src = 2;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
        
        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 4;
        
        graph.edge[6].src = 3;
        graph.edge[6].dest = 5;
        graph.edge[6].weight = 3;
        
        graph.edge[7].src = 4;
        graph.edge[7].dest = 5;
        graph.edge[7].weight = 3;
        
       graph.KruskalMST();
    }
}

class ShellSort{
    
    int sort(int arr[]){
        int n = arr.length;
 
        for (int gap = 5; gap > 0; gap = gap - 2){
            
            for (int i = gap; i < n; i += 1){
                int temp = arr[i];
            
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
                printArray(arr);
            }
            System.out.println("Pass completed");
        }
        return 0;
    }
    
    static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}

class Graph{
    
    class Edge implements Comparable<Edge>{
        int src, dest, weight;
 
        
        public int compareTo(Edge compareEdge){
            return this.weight-compareEdge.weight;
        }
    };
 
    
    class subset{
        int parent, rank;
    };
 
    int V, E;    
    Edge edge[]; 
 
   
    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    
    int find(subset subsets[], int i){
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    void Union(subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
       
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST(){
        Edge result[] = new Edge[V];  
        int e = 0;  
        int i = 0;  
        for (i=0; i<V; ++i)
            result[i] = new Edge();
 
        Arrays.sort(edge);
 

        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
 
        
        for (int v = 0; v < V; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  
       
        while (e < V - 1){
            
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
           
            if (x != y){
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
           
        }
 
        System.out.println("Following are the edges in " + 
                                     "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " + 
                   result[i].dest+" == " + result[i].weight);
    }
}