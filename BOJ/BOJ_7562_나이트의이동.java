import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.valueOf(bf.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.valueOf(bf.readLine());
			
			st = new StringTokenizer(bf.readLine(), " ");
			int sx = Integer.valueOf(st.nextToken());
			int sy = Integer.valueOf(st.nextToken());
			
			st = new StringTokenizer(bf.readLine(), " ");
			int ex = Integer.valueOf(st.nextToken());
			int ey = Integer.valueOf(st.nextToken());
			
			System.out.println(BFS(N, sx, sy, ex, ey));
		}
	}
	
	static int[] nx = {-2,-2,-1,-1,1,1,2,2};
	static int[] ny = {-1,1,-2,2,-2,2,-1,1};
	private static int BFS(int N, int sx, int sy, int ex, int ey) {
		Queue<Node> Q = new LinkedList<>();
		boolean[][] check = new boolean[N][N];
		check[sx][sy] = true;
		Q.add(new Node(sx,sy,0));
		
		while(!Q.isEmpty()) {
			Node now = Q.poll();
			if(now.x == ex && now.y == ey) {
				return now.cnt;
			}
			
			for(int k=0; k<nx.length; k++) {
				int xx = now.x + nx[k];
				int yy = now.y + ny[k];
				int cnt = now.cnt;
				
				if(xx>=0 && xx<N && yy>=0 && yy<N && !check[xx][yy]) {
					check[xx][yy] = true;
					Q.add(new Node(xx,yy,cnt+1));
				}
			}
		}
		return -1;
	}

	static class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
