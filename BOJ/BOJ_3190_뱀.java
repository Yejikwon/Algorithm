import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], apple;
	static int M, time[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.valueOf(bf.readLine());
		arr = new int[N][N];
		apple = Integer.valueOf(bf.readLine());
		
		int x,y;
		for(int i=0; i<apple; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			x = Integer.valueOf(st.nextToken());
			y = Integer.valueOf(st.nextToken());
			arr[x-1][y-1] = -1; // 사과 저장
		}
		
		M = Integer.valueOf(bf.readLine());
		time = new int[M][2];
		
		String dir;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			time[i][0] = Integer.valueOf(st.nextToken()); // 시간
			dir = st.nextToken();
			if(dir.equals("L")) time[i][1] = 3; // 왼쪽으로
			else time[i][1] = 1; // 오른쪽으로
		}
		solve();
	}
	
	// 상, 우, 하, 좌  순
	static int []dx = {-1,0,1,0};
	static int []dy = {0,1,0,-1};
	private static void solve() {
		Deque<Node> Q = new ArrayDeque<>();
		Q.add(new Node(0, 0)); // 뱀 처음 위치
		arr[0][0] = 1;
		int ans = 0;
		int snakeDir = 1; // 처음엔 오른쪽으로 향함
		
		int timeIdx = 0;
		while(true) {
			Node now = Q.peekLast();
			ans++;

			if(ans == time[timeIdx][0]+1) {
				snakeDir = (snakeDir+time[timeIdx][1]) % 4;
				if(timeIdx < time.length-1) timeIdx++;
			}
			
			int nx = now.x + dx[snakeDir];
			int ny = now.y + dy[snakeDir];
			if(nx <0 || nx>=N || ny<0 || ny>=N || arr[nx][ny]==1) {
				System.out.println(ans);
				return;
			}
		
			// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			Q.add(new Node(nx, ny));
			
			// 만약 이동한 칸에 사과가 없다면, 꼬리삭제
			if(arr[nx][ny] == 0) {
				Node tail = Q.removeFirst();
				arr[tail.x][tail.y] = 0;
			}
			
			// 만약 이동한 칸에 사과가 있다면 (-1 이라면), 꼬리 삭제 안함!
			arr[nx][ny] = 1;
		}
	}
	
	static class Node{
		int x; int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
