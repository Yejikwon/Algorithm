import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,X,Y,K;
	static int[][] map;
	static int[] dice;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.valueOf(st.nextToken()); M = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken()); Y = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		dice = new int [7];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i=0; i<K; i++) {
			moveDice(Integer.valueOf(st.nextToken()));
		}
		
		System.out.println(sb.toString());
	}

	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	private static void moveDice(int dir) {
		int nx = X+dx[dir];
		int ny = Y+dy[dir];
		if(nx<0 || nx>=N || ny<0 || ny>=M) return;
		
		X = nx; Y = ny;
		
		switch (dir) {
		case 1: // 동
			move1();
			break;
		case 2: // 서
			move2();
			break;
		case 3: // 븍
			move3();
			break;
		case 4: //남
			move4();
			break;
		}
		
		if(map[X][Y] == 0) {
			map[X][Y] = dice[6];
		} else {
			dice[6] = map[X][Y];
			map[X][Y] = 0;
		}
		sb.append(dice[1]+"\n");
	}
	
	private static void move1() { // 동 (2,5 X)
		int tmp = dice[1];
		dice[1] = dice[4]; dice[4] = dice[6]; 
		dice[6] = dice[3]; dice[3] = tmp;
	}
	
	private static void move2() { // 서 (2,5 X)
		int tmp = dice[1];
		dice[1] = dice[3]; dice[3] = dice[6]; 
		dice[6] = dice[4]; dice[4] = tmp;
	}
	
	private static void move3() { // 북 (3,4 X) 
		int tmp = dice[1];
		dice[1] = dice[5]; dice[5] = dice[6]; 
		dice[6] = dice[2]; dice[2] = tmp;
	}
	
	private static void move4() { // 남 (3,4 X)
		int tmp = dice[1];
		dice[1] = dice[2]; dice[2] = dice[6]; 
		dice[6] = dice[5]; dice[5] = tmp;
	}	
}
