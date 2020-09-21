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
		boolean[] check = new boolean[N+1];
		
		DFS(0, check, "");
		System.out.println(sb.toString());
	}

	private static void DFS(int cnt, boolean[] check, String str) {
		if(cnt==M) {
			sb.append(str+"\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				check[i] = true;
				DFS(cnt+1, check, str+i+" ");
				check[i] = false;
			}
		}
	}
}
