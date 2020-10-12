import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][];
	static int max = 0;

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

		DFS(arr, 0);
		System.out.println(max);
	}

	private static void DFS(int[][] arr, int cnt) {
		check(arr);
		
		if (cnt == 5) {
			return;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			DFS(solved(arr, dir), cnt + 1);
		}
	}

	private static void check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Integer.max(arr[i][j], max);
			}
		}
	}

	private static int[][] solved(int[][] origin, int dir) {
		int[][] arr = move(origin, dir);

		int prev = 0;
		switch (dir) {
		case 0: // 상
			for (int j = 0; j < N; j++) {
				prev = 0;
				for (int i = 0; i < N; i++) {
					if (prev == 0 || (prev != 0 && prev != arr[i][j])) {
						prev = arr[i][j];
						continue;
					} else if (arr[i][j] == prev) {
						arr[i - 1][j] += prev;
						arr[i][j] = 0;
						prev = 0;
					}
				}
			}
			break;
		case 1: // 하
			for (int j = N - 1; j >= 0; j--) {
				prev = 0;
				for (int i = N - 1; i >= 0; i--) {
					if (prev == 0 || (prev != 0 && prev != arr[i][j])) {
						prev = arr[i][j];
						continue;
					} else if (arr[i][j] == prev) {
						arr[i + 1][j] += prev;
						arr[i][j] = 0;
						prev = 0;
					}
				}
			}
			break;
		case 2: // 좌
			for (int i = 0; i < N; i++) {
				prev = 0;
				for (int j = 0; j < N; j++) {
					if (prev == 0 || (prev != 0 && prev != arr[i][j])) {
						prev = arr[i][j];
						continue;
					} else if (arr[i][j] == prev) {
						arr[i][j - 1] += prev;
						arr[i][j] = 0;
						prev = 0;
					}
				}
			}
			break;
		case 3: // 우
			for (int i = N - 1; i >= 0; i--) {
				prev = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (prev == 0 || (prev != 0 && prev != arr[i][j])) {
						prev = arr[i][j];
						continue;
					} else if (arr[i][j] == prev) {
						arr[i][j + 1] += prev;
						arr[i][j] = 0;
						prev = 0;
					}
				}
			}
			break;
		}
		
		arr = move(arr, dir);
		return arr;
	}

	private static int[][] move(int[][] origin, int dir) {
		int[][] arr = new int[N][N];

		int idx = 0;
		switch (dir) {
		case 0: // 상
			for (int j = 0; j < N; j++) {
				idx = 0;
				for (int i = 0; i < N; i++) {
					if (origin[i][j] != 0) {
						arr[idx++][j] = origin[i][j];
					}
				}
			}
			break;
		case 1: // 하
			for (int j = N - 1; j >= 0; j--) {
				idx = N - 1;
				for (int i = N - 1; i >= 0; i--) {
					if (origin[i][j] != 0) {
						arr[idx--][j] = origin[i][j];
					}
				}
			}
			break;
		case 2: // 좌
			for (int i = 0; i < N; i++) {
				idx = 0;
				for (int j = 0; j < N; j++) {
					if (origin[i][j] != 0) {
						arr[i][idx++] = origin[i][j];
					}
				}
			}
			break;
		case 3: // 우
			for (int i = N - 1; i >= 0; i--) {
				idx = N - 1;
				for (int j = N - 1; j >= 0; j--) {
					if (origin[i][j] != 0) {
						arr[i][idx--] = origin[i][j];
					}
				}
			}
			break;
		}
		return arr;
	}
}
