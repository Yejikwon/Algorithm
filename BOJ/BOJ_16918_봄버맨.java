import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static char arr[][];

	static Queue<Node> Q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = bf.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(arr[i][j]=='O') Q.add(new Node(i, j));
			}
		}

		solve();
	}

	private static void solve() {
		int time = 1;
		while (true) {
			if (time == K) break;
			if(time%2==1) addMap();
			else {
				boomMap();
			}
		
			++time;
		}
		printMap();
	}

	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	private static void addMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]=='.') arr[i][j] = 'O';
			}
		}
	}
	
	private static void boomMap() {
		while(!Q.isEmpty()) {
			Node now = Q.poll();
			arr[now.x][now.y] = '.';
			for(int k=0; k<4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					arr[nx][ny]='.';
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]=='O') Q.add(new Node(i, j));
			}
		}
		
	}

	static StringBuilder sb = new StringBuilder();
	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
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
