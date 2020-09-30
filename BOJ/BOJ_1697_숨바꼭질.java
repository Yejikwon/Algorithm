import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[] check = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(N);
		int time = 0;
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			
			for(int s=0; s<size; s++) {
				int now = Q.poll();
				check[now] = true;
				if(now == M) return time;
				
				if(now*2<=100000 && !check[now*2]) Q.add(now*2);
				if(now+1<=100000 && !check[now+1]) Q.add(now+1);
				if(now-1>=0 && !check[now-1]) Q.add(now-1);
			}
			
			time++;
		}
		return time;
	}
}
