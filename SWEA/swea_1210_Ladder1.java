import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int sx,sy;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			bf.readLine();
			arr = new int[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
					if(arr[i][j]==2) {
						sx=i;
						sy=j;
					}
				}
			}
			BFS(tc);
		}
		System.out.println(sb.toString());
	}
	
	static int[]dx = {0,0,-1};
	static int[]dy = {-1,1,0};
	
	private static void BFS(int tc) {
		int ans=0;
		boolean[][] check = new boolean[100][100];
		Queue<Node> Q = new LinkedList<>();
		Q.add(new Node(sx,sy));
		check[sx][sy] = true;
		
		while(!Q.isEmpty()) {
			Node now = Q.poll();
			if(now.x==0) {
				ans = now.y;
				break;
			}
			for(int k=0; k<3; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx>=0 && nx<100 && ny>=0 && ny<100 && !check[nx][ny]) {
					if(arr[nx][ny]==1) {
						check[nx][ny] = true;
						Q.add(new Node(nx,ny));
						break;
					}
				}
			}
		}
		
		sb.append("#"+tc+" "+ans+"\n");
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
