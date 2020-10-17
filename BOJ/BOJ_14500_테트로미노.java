// DFS로 안되는 ㅗ 모양.. 잊지말자..ㅎㅎㅎ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[][];
	static int MAX = Integer.MIN_VALUE;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		int [] tmp = new int[4];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = true;
				DFS(i,j,arr[i][j],1);
				checkSpecial(i,j); // ㅗ 모양
				check[i][j] = false;
			}
		}
		System.out.println(MAX);
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static void DFS(int i, int j, int sum, int cnt) {
		if(cnt==4) {
			MAX = Math.max(MAX, sum);
			return;
		}
		
		for(int s=0; s<4; s++) {
			int nx = i+dx[s];
			int ny = j+dy[s];
			
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				if(!check[nx][ny]) {
					check[nx][ny] = true;
					DFS(nx, ny, sum+arr[nx][ny], cnt+1);
					check[nx][ny] = false;
				}
			}
		}
	}
	
	private static void checkSpecial(int xx, int yy) {
		int specialSum = 0;
		
		if(yy+2<M && xx+1<N) { // ㅜ
			for(int j=yy; j<=yy+2; j++) {
				specialSum += arr[xx][j];
			}
			specialSum += arr[xx+1][yy+1];
			MAX = Math.max(MAX, specialSum);
		}
		
		specialSum = 0;
		if(xx+2<N && yy+1<M) { // ㅏ
			for(int i=xx; i<=xx+2; i++) {
				specialSum += arr[i][yy];
			}
			specialSum += arr[xx+1][yy+1];
			MAX = Math.max(MAX, specialSum);
		}
		
		specialSum = 0;
		if(xx+1<N && yy+1<M && yy-1 >= 0) { // ㅗ
			for(int j=yy-1; j<=yy+1; j++) {
				specialSum += arr[xx+1][j];
			}
			specialSum += arr[xx][yy];
			MAX = Math.max(MAX, specialSum);
		}
		
		specialSum = 0;
		if(xx+2<N && yy-1 >= 0) { // ㅓ
			for(int i=xx; i<=xx+2; i++) {
				specialSum += arr[i][yy];
			}
			specialSum += arr[xx+1][yy-1];
			MAX = Math.max(MAX, specialSum);
		}
	}
}
