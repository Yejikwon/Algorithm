import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		DFS(1,0,"");
		System.out.println(sb.toString());
	}
	private static void DFS(int num, int cnt, String ans) {
		if(cnt==M) {
			sb.append(ans.substring(0, ans.length()-1)+"\n");
			return;
		}
		if(num>N) return;
		
		for(int i=1; i<=N; i++) {
			DFS(num+1, cnt+1, ans+i+" ");
		}
	}
}
