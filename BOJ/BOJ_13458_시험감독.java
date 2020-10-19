import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1000005;
	static int N, A[], Bcnt, Ccnt;
	static long ans;
	static int [] save = new int [MAX];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(bf.readLine()); // 시험장 개수
		st = new StringTokenizer(bf.readLine(), " ");
		A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.valueOf(st.nextToken()); // 시험장 별 응시자의 수
		}
		st = new StringTokenizer(bf.readLine(), " ");
		Bcnt = Integer.valueOf(st.nextToken());
		Ccnt = Integer.valueOf(st.nextToken());
		
		for(int i=0; i<N; i++) {
			ans += find(A[i]);
		}
		
		System.out.println(ans);
	}

	static int B, C;
	private static int find(int num) {
		if(save[num] != 0) return save[num];
		int last = num - Bcnt;
		
		save[num] += 1;
		if(last <= 0) return save[num];
		
		int add = last/Ccnt;
		add = last%Ccnt == 0 ? add : add+1;
		save[num] += add;
		return save[num];
	}
}
