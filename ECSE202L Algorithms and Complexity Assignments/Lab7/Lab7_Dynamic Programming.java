package Lab7;

	/*
		I have done this assignment on my own. I have not copied any code from another student or any online source. I understand if my code is found similar
		to somebody else's code, my code can be sent to the Disciplinary committee of the institute for appropriate actions
	*/
	
	//Harshit Singhai
	//E16CSE147
	//B2

    class Lab7 {
    
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
       MatrixChainMultiplication matrix = new MatrixChainMultiplication();
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    }
    
}

class Fibonacci {
    public Fibonacci(){
        FibonacciMethod fib = new FibonacciMethod();
        double[] a = new double[99+1];
        System.out.println("Iterative solution " + fib.Iterative(92));
        System.out.println("Recursive solution " + fib.Recursive(30));
        System.out.println("Dynamic solution " + fib.Dynamic(92,a ));
    } 
}

class MatrixChainMultiplication {
    public MatrixChainMultiplication(){
        int[] arr = {10, 20, 30, 40, 30};
        MatrixMultiplication matrix = new MatrixMultiplication();
        System.out.println("The minimum number of multiplications " + matrix.MatrixChainMultiplicationMethod(arr, arr.length));
    }
}

class LongestCommonSubsequence {
    public LongestCommonSubsequence(){
        LongestCommonSubsequenceMethod lcs = new LongestCommonSubsequenceMethod();
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        lcs.LongestCommonSubsequence(s1, s2, s1.length(), s2.length());
    }
}

interface Fibonacci_Overview {
    public double Iterative(int x);
    public int Recursive(int x);
    public double Dynamic(int x , double[] a);
}

interface MatrixChainMultiplication_Overview {
    public int MatrixChainMultiplicationMethod(int[] p ,int n);
    
}

interface LongestCommonSubsequence_Overview {
    public void LongestCommonSubsequence(String s1, String s2, int n, int m);
}

class FibonacciMethod implements Fibonacci_Overview {
    
    public double Iterative(int x){
        if(x <= 1){
            return x;
        }
        double fib = 1;
        double fib_prev = 1;
        
        for(int i=2; i<x; i++){
            double temp = fib;
            fib = fib + fib_prev;
            fib_prev = temp;
        }
        return fib;
    }
    
    public int Recursive(int x){
        
        if(x <= 1){
            return x;
        }else{
            return Recursive(x-1) + Recursive(x-2);
        }
    }
    
    public double Dynamic(int x , double array[]){
        double result = 0;
        if(array[x] != 0){
            return array[x];
        }
        if(x == 1 || x ==2 ){
            result = 1;
        }
        else{
            result = Dynamic(x-1,array) + Dynamic(x-2,array);
        }
        array[x] = result;
        return result;
    }
}

class MatrixMultiplication implements MatrixChainMultiplication_Overview {
    
    public int MatrixChainMultiplicationMethod(int p[], int n){
        int m[][] = new int[n][n];
        int brackets[][] = new int[n][n];
 
        int i, j, k, L, q;
         k =0;
        for (i = 1; i < n; i++){
            m[i][i] = 0;
        }
            
        for (L=2; L<n; L++){
            for (i=1; i<n-L+1; i++){
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++){
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                        brackets[i][j] = k;
                }
            }
        }
        char name = 'A';
        
        return m[1][n-1];
    }
}

class LongestCommonSubsequenceMethod implements LongestCommonSubsequence_Overview {
    public void LongestCommonSubsequence(String X, String Y, int m, int n){
        int[][] L = new int[m+1][n+1];
  
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
  
        int index = L[m][n];
        int temp = index;
  
        char[] lcs = new char[index+1];
        lcs[index] = '\0'; // Set the terminating character
  
        int i = m, j = n;
        while (i > 0 && j > 0){
            if (X.charAt(i-1) == Y.charAt(j-1))            {

                lcs[index-1] = X.charAt(i-1); 
                 
                i--; 
                j--; 
                index--;     
            }
  
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }
  
        System.out.print("LCS of "+X+" and "+Y+" is ");
        for(int k=0;k<=temp;k++){
            System.out.print(lcs[k]);
        }
        System.out.println(" \nLength is " + temp);
        System.out.println();
    }
}
    
