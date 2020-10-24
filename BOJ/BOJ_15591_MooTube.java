import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube {
	static int N,Q;
	static int arr[][];
	static int value, video, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken()); // 동영상 갯수
		Q = Integer.valueOf(st.nextToken());
		arr = new int[N+1][N+1];
		
		int x, y, score;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			x = Integer.valueOf(st.nextToken());
			y = Integer.valueOf(st.nextToken());
			score = Integer.valueOf(st.nextToken());
			arr[x][y] = score;
			arr[y][x] = score;
		}
		
		for(int i=0; i<Q; i++) {
			ans = 0;
			st = new StringTokenizer(bf.readLine(), " ");
			value = Integer.valueOf(st.nextToken());
			video = Integer.valueOf(st.nextToken());
			
			for(int j=1; j<=N; j++) {
				if(arr[video][j] == 0) {
					arr[video][j] = find(video, j);
				}
			}
		}
	}

	private static int find(int x, int y) {
		int ans = Integer.MAX_VALUE;
		
		return 0;
	}
}
