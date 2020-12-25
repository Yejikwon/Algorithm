import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int answer;

	static int N;
	static String[][] arr;
	static ArrayList<Node> teacher = new ArrayList<>();
	static ArrayList<Node> wall = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(bf.readLine());
		arr = new String[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = st.nextToken();
				if (arr[i][j].equals("T"))
					teacher.add(new Node(i, j));
				if (arr[i][j].equals("X"))
					wall.add(new Node(i, j));
			}
		}
		
		solved(0, 0);
		
		if (answer==0) System.out.println("NO");
		else System.out.println("YES");
	}

	private static void solved(int idx, int len) {
		if (len == 3) {
			answer += find();
			return;
		}

		for (int i = idx; i < wall.size(); i++) {
			Node now = wall.get(i);
			arr[now.x][now.y] = "O";
			solved(i + 1, len + 1);
			arr[now.x][now.y] = "X";
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int find() {
		for (int i = 0; i < teacher.size(); i++) {
			Node now = teacher.get(i);

			for (int k = 0; k < 4; k++) {
				int nx = now.x;
				int ny = now.y;
				
				while(true) {
					nx += dx[k];
					ny += dy[k];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < N) {						
						if (arr[nx][ny].equals("O")) break;
						else if (arr[nx][ny].equals("S")) return 0;
					}

					else break;
				}
			}
		}

		return 1;
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
