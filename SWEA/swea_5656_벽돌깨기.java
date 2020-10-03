import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N,W,H;
	static int MIN;
	static boolean[] check;
	static int[] bomb; 
	static int cc=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.valueOf(bf.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(bf.readLine()," ");
			N = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken()); // Y
			H = Integer.valueOf(st.nextToken()); // X
			MIN = Integer.MAX_VALUE;
			
			check = new boolean[W];
			bomb = new int[N];
			permutaion(0,0);
			System.out.println(cc);
		}
	}
	private static void permutaion(int idx, int cnt) {
		if(idx==N) {
			cc++;
			System.out.println(Arrays.toString(bomb));
			return;
		}
		if(cnt==W) return;
		
		for(int i=0; i<W; i++) {
			if(!check[i]) {
				check[i] = true;
				bomb[idx] = i;
				permutaion(idx+1, cnt+1);
				check[i] = false;
			}
		}
		
	}
}
