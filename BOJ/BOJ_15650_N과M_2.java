import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		DFS(1, 0, "");

		System.out.println(sb.toString());
	}

	private static void DFS(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}
		if (idx > N + 1)
			return;

		for (int i = idx; i <= N; i++) {
			DFS(i + 1, cnt + 1, str + i + " ");
		}
	}
}
