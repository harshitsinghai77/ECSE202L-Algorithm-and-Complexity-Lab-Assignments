public class Lab6 {


/* I have done this assignment on my own. I have not copied any code from
another student or any online source. I understand if my code is found
similar to somebody else's code, my case can be sent to the Disciplinary
committee of the institute for appropriate action." */
    
    public static void main(String[] args) {
    
        Scanner num = new Scanner(System.in);
        System.out.println("Enter no. of items: ");
        int a = num.nextInt();
        int val[] = new int[a];
        int wt[] = new int[a];
        int ct = 0;
        int  W = 1;
        
        
        for(int i = 0; i < a; i++)
        {
            System.out.println("Enter value of item: ");
            val[i] = num.nextInt();
            
        }
        
        for(int i = 0 ; i < a; i++)
        {
            System.out.println("Enter weight of item: ");
            wt[i] = num.nextInt();
            ct = wt[i]+ct;
            
        }
        
        int n = val.length;
        Knapsack abc = new Knapsack();
        
        System.out.println("Optimal cost at each weight: ");
        
        for(int i = 1 ; i <=ct; i++)
        {   
            
            System.out.println("At "+i+" = ");
            System.out.println(abc.knapSack(W, wt, val, n));
            W++;
        }
        abc.print();
        
    }
}
    
    class Knapsack
    {
     int tc = 0;  
     int knapSack(int W, int wt[], int val[], int n)
     {
        tc++;
        if (n == 0 || W == 0)
        return 0;
      
        if (wt[n-1] > W)
        return knapSack(W, wt, val, n-1);
      
        else return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                         knapSack(W, wt, val, n-1)
                          );
        
      }
     public void print(){
         System.out.println(tc);
     }    
    }