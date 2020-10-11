import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.valueOf(bf.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
//		
//		int[][] tmp = new int[N][N];
//		for(int i=0; i<N; i++) {
//			tmp[i] = arr[i].clone();
//		}

		DFS(arr, 0);
		System.out.println(max);
	}

	private static void DFS(int[][] arr, int cnt) {
		if (cnt == 5) {
			checkMAX(arr);
			return;
		}

		for (int i = 0; i < 4; i++) {
			DFS(merge(arr, i), cnt + 1);
		}
	}

	private static void checkMAX(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
	}

	private static int[][] merge(int[][] origin, int dir) {
		int[][] arr = new int[N][N];
		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; i++)
			arr[i] = origin[i].clone();
		Queue<Node> Q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0)
					Q.add(new Node(i, j, arr[i][j]));
			}
		}

		Node now = null;
		while (!Q.isEmpty()) {
			switch (dir) {
			case 0: // 상
				now = Q.poll();
				for (int i = now.x - 1; i >= 0; i--) {
					if (!check[i][now.y] && !check[now.x][now.y] && arr[i][now.y] == now.value) {
						check[i][now.y] = true;
						arr[now.x][now.y] = 0;
						arr[i][now.y] = now.value * 2;
						Q.add(new Node(i, now.y, now.value * 2));
						break;
					}
				}
				break;
			case 1: // 하
				now = Q.poll();
				for (int i = now.x + 11; i < N; i++) {
					if (!check[i][now.y] && !check[now.x][now.y] && arr[i][now.y] == now.value) {
						check[i][now.y] = true;
						arr[now.x][now.y] = 0;
						arr[i][now.y] = now.value * 2;
						Q.add(new Node(i, now.y, now.value * 2));
						break;
					}
				}
				break;
			case 2: // 좌
				now = Q.poll();
				for (int j = now.y - 1; j >= 0; j--) {
					if (!check[now.x][j] && !check[now.x][now.y] && arr[now.x][j] == now.value) {
						check[now.x][j] = true;
						arr[now.x][now.y] = 0;
						arr[now.x][j] = now.value * 2;
						Q.add(new Node(now.x, j, now.value * 2));
						break;
					}
				}
				break;
			case 3: // 우
				now = Q.poll();
				for (int j = now.y + 1; j < 0; j++) {
					if (!check[now.x][j] && !check[now.x][now.y] && arr[now.x][j] == now.value) {
						check[now.x][j] = true;
						arr[now.x][now.y] = 0;
						arr[now.x][j] = now.value * 2;
						Q.add(new Node(now.x, j, now.value * 2));
						break;
					}
				}
				break;
			}
		}
		
		int nowIdx = 0;
		switch (dir) {
		case 0:
			for(int i=1; i<N; i++) {
				for(int j=0; j<N; j++) {
					nowIdx = i;
					if(arr[nowIdx][j] == 0) continue;
					while(nowIdx>0) {
						if(arr[--nowIdx][j]==0) {
							arr[nowIdx][j] = arr[nowIdx+1][j];
							arr[nowIdx+1][j] = 0;
						} else break;
					}
				}
			}
			break;
		case 1:
			for(int i=N-2; i>=0; i--) {
				for(int j=0; j<N; j++) {
					nowIdx = i;
					if(arr[nowIdx][j] == 0) continue;
					while(nowIdx<N-1) {
						if(arr[++nowIdx][j]==0) {
							arr[nowIdx][j] = arr[nowIdx-1][j];
							arr[nowIdx-1][j] = 0;
						} else break;
					}
				}
			}
			break;
		case 2:
			for(int i=0; i<N; i++) {
				for(int j=1; j<N; j++) {
					nowIdx = j;
					if(arr[i][nowIdx] == 0) continue;
					while(nowIdx>0) {
						if(arr[i][--nowIdx]==0) {
							arr[i][nowIdx] = arr[i][nowIdx+1];
							arr[i][nowIdx+1] = 0;
						} else break;
					}
				}
			}
			break;
		case 3:
			for(int i=0; i<N; i++) {
				for(int j=N-2; j>=0; j--) {
					nowIdx = j;
					if(arr[nowIdx][j] == 0) continue;
					while(nowIdx<N-1) {
						if(arr[i][++nowIdx]==0) {
							arr[i][nowIdx] = arr[i][nowIdx-1];
							arr[i][nowIdx-1] = 0;
						} else break;
					}
				}
			}
			break;
		}
		
		return arr;
	}

	static class Node {
		int x;
		int y;
		int value;

		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
}
