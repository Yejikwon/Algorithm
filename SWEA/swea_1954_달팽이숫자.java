import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.valueOf(bf.readLine());
		int N, arr[][];
		
		for(int tc=1; tc<=TC; tc++) {
			sb.append("#"+tc+"\n");
			N = Integer.valueOf(bf.readLine());
			arr = new int[N][N];
			int num = 1;
			int sx = 0, sy = 0, ex = N, ey = N;
			int term = 0;
			
			while(num<=N*N) {
				while(sy<ey-term) {
					arr[sx][sy++] = num++;
				}
				sy--; sx++;
				while(sx<ex-term) {
					arr[sx++][sy] = num++;
				}
				sx--; sy--;
				while(sy>=term) {
					arr[sx][sy--] = num++;
				}
				sy++; sx--;
				
				term++;
				while(sx>=term) {
					arr[sx--][sy] = num++;
				}
				sx++;sy++;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
