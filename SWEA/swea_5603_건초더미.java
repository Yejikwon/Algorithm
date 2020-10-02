import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 건초더미 {
    static int n,sum,avg,ans;
    static int[] arr;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			n=Integer.parseInt(bf.readLine());
			arr = new int[n];
			
			sum=0;
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(bf.readLine());
				sum+=arr[i];
			}
			
			avg = sum/n;
			ans = 0;

			for(int i=0; i<n; i++) {
				if(arr[i]<avg) ans+=avg-arr[i];
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
