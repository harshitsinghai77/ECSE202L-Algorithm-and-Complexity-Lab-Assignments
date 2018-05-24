package lab10;

/*
"I have done this assignment on my own. I have not copied any code
from another student or any online source. I understand if my code is
found similarto somebody else's code, my case can be sent to the
Disciplinary committee of the institute for appropriate action."

Name: Harshit Singhai
Enroll : E16CSE147
Batch: B2

*/

public class Lab10_Harshit_Singhai_E16CSE147 {

    public static void main(String[] args) {
        String text = "HACKHACKHACKHACKITHACKEREARTH";
        String pattern = "HACKHACKIT";
        Alogirthm algo = new Alogirthm();
        System.out.println("Naive: "+algo.BruteForce(pattern, text));
        algo.Rabin_Karp_Algorithm(pattern, text);
        algo.KMPSearch(pattern,text);
    }

}

class Alogirthm{
    
    public int BruteForce(String pattern, String text){
     int no_of_comparision = 0;
     int no_of_iteration = 0;
     int m = pattern.length();
     int n = text.length();
     for (int i = 0; i < n - m; i++){
        int j;
        no_of_iteration++;
        for (j = 0; j < m; j++){
            no_of_iteration++;
            if (text.charAt(i+j) != pattern.charAt(j)){
                no_of_comparision++;
                break;
            }
        }
        if (j == m) {
                System.out.println("Number of comparision of Bruteforce is "+no_of_comparision);
                System.out.println("Number of iteration of Bruteforce is "+no_of_iteration);
                return i;
        }
    }
      System.out.println("Number of comparision of Bruteforce is "+no_of_comparision);
     return -1;
    }
    
    public final static int d = 256;
     
    public void Rabin_Karp_Algorithm(String pat, String txt){
        int no_of_comparision = 0;
         int no_of_iteration = 0;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; 
        int t = 0; 
        int h = 1;
     
        for (i = 0; i < M-1; i++)
            h = (h*d)%101;
            no_of_iteration++;
     
        for (i = 0; i < M; i++){
            p = (d*p + pat.charAt(i))%101;
            t = (d*t + txt.charAt(i))%101;
            no_of_iteration++;
        }
     
       
        for (i = 0; i <= N - M; i++)
        {
            no_of_iteration++;
     
            if ( p == t )
            {
                no_of_comparision++;
                for (j = 0; j < M; j++)
                {
                    no_of_iteration++;
                    if (txt.charAt(i+j) != pat.charAt(j))
                        no_of_comparision++;
                        break;
                }
     
               
                if (j == M)
                    no_of_comparision++;
                    System.out.println("No of comparision for Rabin karp is "+no_of_comparision);
                    System.out.println("No of iteration for Rabin karp is "+no_of_iteration);
                    System.out.println("Rabin Karp Pattern found at index " + i);
            }
     
           
            if ( i < N-M )
            {
                no_of_comparision++;
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%101;
     
               
                if (t < 0)
                no_of_comparision++;
                t = (t + 101);
            }
        }
    }
    int no_of_comparision = 0;
    int no_of_iteration = 0;
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;  
 
       
        computeLPSArray(pat,M,lps);
 
        int i = 0; 
        while (i < N)
        {   
            no_of_iteration++;
            if (pat.charAt(j) == txt.charAt(i))
            {
                no_of_comparision++;
                j++;
                i++;
            }
            if (j == M)
            {
                no_of_comparision++;
                System.out.println("KMP Found pattern "+"at index " + (i-j));
                System.out.println("No of comparision for Rabin karp is "+no_of_comparision);
                System.out.println("No of iteration for Rabin karp is "+no_of_iteration);
                j = lps[j-1];
            }
 
          
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                no_of_comparision++;
                if (j != 0)
                    j = lps[j-1];
                
                else
                    i = i+1;
            }
        }
    }
 
    void computeLPSArray(String pat, int M, int lps[])
    {
       
        int len = 0;
        int i = 1;
        lps[0] = 0; 
 
     
        while (i < M)
        {
            no_of_iteration++;
            if (pat.charAt(i) == pat.charAt(len))
            {
                no_of_comparision++;
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                no_of_comparision++;
                if (len != 0)
                {
                    len = lps[len-1];
                    no_of_comparision++;
                   
                }
                else  
                {
                    lps[i] = len;
                    i++;
                    no_of_comparision++;
                }
            }
        }
    }
 
}
