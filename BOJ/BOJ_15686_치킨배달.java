import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M, arr[][], distance[][][][], min = Integer.MAX_VALUE;
	static ArrayList<Node> home, chiken;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		arr = new int[N][N];
		home = new ArrayList<>();
		chiken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j]==1) home.add(new Node(i, j));
				else if(arr[i][j]==2) chiken.add(new Node(i, j));
			}
		}
		
		int dir=0;
		Node nowH, nowC;
		distance = new int[N][N][N][N];
		
		
		for(int i=0; i<home.size(); i++) {
			for(int j=0; j<chiken.size(); j++) {
				nowH = home.get(i);
				nowC = chiken.get(j);
				dir = check(nowH.x, nowH.y, nowC.x, nowC.y);
				if(distance[nowH.x][nowH.y][nowC.x][nowC.y] == 0 || distance[nowH.x][nowH.y][nowC.x][nowC.y] > dir) {
					distance[nowH.x][nowH.y][nowC.x][nowC.y] = dir;
				}
			}
		}
		
		Node[] pick = new Node[M];
		comb(0, 0, pick);
		
		System.out.println(min);
	}
	
	private static void comb(int idx, int cnt, Node[] pick) {
		if(idx==M) {
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				int minVal = Integer.MAX_VALUE;
				for(int j=0; j<pick.length; j++) {
					int dir = distance[home.get(i).x][home.get(i).y][pick[j].x][pick[j].y];
					if(minVal > dir) {
						minVal = dir;
					};
				}
				sum += minVal;
			}
			
			if(min>sum) min = sum;
			return;
		}
		
		if(cnt==chiken.size()) return;
		
		pick[idx] = chiken.get(cnt);
		comb(idx+1, cnt+1, pick);
		comb(idx, cnt+1, pick);
	}

	private static int check(int x, int y, int x2, int y2) {
		return Math.abs(x-x2) + Math.abs(y-y2);
	}

	static class Node {
		int x; int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
