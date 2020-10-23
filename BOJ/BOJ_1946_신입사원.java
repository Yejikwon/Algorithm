import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,x,y;
	static int comX, comY, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.valueOf(bf.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.valueOf(bf.readLine());
			PriorityQueue<Node> Q = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				x = Integer.valueOf(st.nextToken());
				y = Integer.valueOf(st.nextToken());
				Q.add(new Node(x, y));
			}
			
			Node first = Q.poll();
			comX = first.x;
			comY = first.y;
			ans = 1;
			
			while(!Q.isEmpty()) {
				Node now = Q.poll();
				if(now.x>comX && now.y>comY) continue;
				comX = now.x;
				comY = now.y;
				ans++;
			}
			
			System.out.println(ans);
		}
	}
	
	static class Node implements Comparable<Node>{
		int x; int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.x, o.x);
		}
	}
}
