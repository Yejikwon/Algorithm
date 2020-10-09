import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[];
	static boolean dp[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.valueOf(bf.readLine());
		arr = new int[N];
		dp = new boolean[N][N];
		
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<N; i++) arr[i] = Integer.valueOf(st.nextToken());
		
		checkPalindrome();
		
		M = Integer.valueOf(bf.readLine());
		int S,E;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			S = Integer.valueOf(st.nextToken());
			E = Integer.valueOf(st.nextToken());
			checkAnswer(S-1, E-1);
		}
		System.out.println(sb.toString());
	}

	private static void checkPalindrome() {
		// 길이 한 개인 녀석
		for(int i=0; i<N; i++) dp[i][i] = true;
		
		// 길이 2개인 녀석
		for(int i=0; i<N-1; i++) {
			if(arr[i]==arr[i+1]) dp[i][i+1] = true;
		}
		
		// 길이가 3이상인 녀석들
		for(int e=2; e<N; e++) {
			for(int s=0; s<N-e; s++) { // 길이 전까지
				if(arr[s] == arr[s+e] && dp[s+1][s+e-1]) dp[s][s+e] = true;
			}
		}
	}

	private static void checkAnswer(int i, int j) {
		if(dp[i][j]) sb.append(1+"\n");
		else sb.append(0+"\n");
	}
}
