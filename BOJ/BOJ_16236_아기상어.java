import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][];
	static boolean[][] visited;
	static int sharkX, sharkY;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.valueOf(bf.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j]==9) {
					sharkX = i; sharkY = j;
					arr[i][j] = 0;
				}
			}
		}
		
		BFS();
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static void BFS() {
		int time = 0;
		Shark shark = new Shark(2, 0); // size: 2
		
		while (true) {
			PriorityQueue<Node> feed = new PriorityQueue<>();
			Queue<Node> Q = new LinkedList<>();
			
			visited = new boolean[N][N];
			Q.add(new Node(sharkX, sharkY, 0));
			visited[sharkX][sharkY] = true;
			
			while(!Q.isEmpty()) { // 먹이 찾기
				Node now = Q.poll();

				if(arr[now.x][now.y] != 0 && arr[now.x][now.y] < shark.size) {
					feed.add(now);
				}
				
				for(int i=0; i<4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
					
					if(!visited[nx][ny] && arr[nx][ny] <= shark.size) {
						visited[nx][ny] = true;
						Q.add(new Node(nx, ny, now.dist+1));
					}
				}
			}
			
			Node p = feed.poll();
			
			if(p == null) {
				break;
			}
			time+=p.dist;
			
			arr[p.x][p.y] = 0; // 먹으면 0
			sharkX = p.x; sharkY = p.y;
			
			shark.eatCnt++;
			if(shark.eatCnt == shark.size) {
				shark.size++;
				shark.eatCnt = 0;
			}
		}
		
		System.out.println(time);
	}

	static class Node implements Comparable<Node> {
		int x; int y; int dist;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.dist == o.dist) {
				if(this.x == o.x) return Integer.compare(this.y, o.y);
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	static class Shark {
		int size;
		int eatCnt;
		
		public Shark(int size, int eatCnt) {
			this.size = size;
			this.eatCnt = eatCnt;
		}
	}
}
