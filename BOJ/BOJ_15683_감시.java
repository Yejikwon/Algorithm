import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M, min = 0;
	static int arr[][];
	static ArrayList<CCTV> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>();
		
		// 0은 빈 칸, 6은 벽, 1~5는 CCTV
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j]>=1 && arr[i][j]<=5) {
					list.add(new CCTV(i, j, arr[i][j]));
					continue;
				}
				if(arr[i][j]==6) continue;
				min++;
			}
		}
		
		DFS(0, arr);
		System.out.println(min);
	}
	
	private static void DFS(int idx, int[][] origin) {
		if(idx==list.size()) {
			checkMin(origin);
			return;
		}
		
		int[] checklist;
		
		switch (list.get(idx).num) { // cctv 번호
		case 1: // 0,1,2,3
			for(int i=0; i<4; i++) {
				checklist = new int[1];
				checklist[0]=i;
				DFS(idx+1, go(idx, origin, checklist));
			}
			break;
		case 2: // 2,3 또는 0,1
			checklist = new int[2];
			checklist[0] = 2; checklist[1] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 0; checklist[1] = 1;
			DFS(idx+1, go(idx, origin, checklist));
			break;
		case 3: // 0,3 또는 1,3 또는 1,2 또는 0,2
			checklist = new int[2];
			checklist[0] = 0; checklist[1] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 1; checklist[1] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 1; checklist[1] = 2;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 0; checklist[1] = 2;
			DFS(idx+1, go(idx, origin, checklist));
			break;
		case 4: // 0,2,3 또는 0,1,3 또는 1,2,3 또는 0,2,3
			checklist = new int[3];
			checklist[0] = 0; checklist[1] = 2; checklist[2] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 0; checklist[1] = 1; checklist[2] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 1; checklist[1] = 2; checklist[2] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			
			checklist[0] = 0; checklist[1] = 1; checklist[2] = 2;
			DFS(idx+1, go(idx, origin, checklist));
			break;
		case 5: // 0,1,2,3 한 번에 체크
			checklist = new int[4];
			checklist[0] = 0; checklist[1] = 1; checklist[2] = 2; checklist[3] = 3;
			DFS(idx+1, go(idx, origin, checklist));
			break;
		}
	}

	private static int[][] go(int idx, int[][] origin, int[] checklist) {
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) arr[i] = origin[i].clone();
		CCTV now = list.get(idx);
		int xx = now.x;
		int yy = now.y;
		
		for(int c=0; c<checklist.length; c++) {
			switch (checklist[c]) {
			case 0: // 상
				for(int i=xx-1; i>=0; i--) {
					if(arr[i][yy] == 6) break;
					if(arr[i][yy] == 0) arr[i][yy] = 8;
				}
				break;
			case 1: // 하
				for(int i=xx+1; i<N; i++) {
					if(arr[i][yy] == 6) break;
					if(arr[i][yy] == 0) arr[i][yy] = 8;
				}
				break;
			case 2: // 좌
				for(int j=yy-1; j>=0; j--) {
					if(arr[xx][j] == 6) break;
					if(arr[xx][j] == 0) arr[xx][j] = 8;
				}
				break;
			case 3: // 우
				for(int j=yy+1; j<M; j++) {
					if(arr[xx][j] == 6) break;
					if(arr[xx][j] == 0) arr[xx][j] = 8;
				}
				break;
			}
		}
 		return arr;
	}

	private static void checkMin(int[][] arr) {
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) tmp++;
			}
		}
		min = Math.min(tmp, min);
	}

	static class CCTV {
		int x; int y; int num;

		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
