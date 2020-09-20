import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder("<");
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken()) - 1; // 인덱스는 0부터니까
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) arr.add(i);
		int idx = K;
		
		while(arr.size() > 1) {
			idx = (idx > arr.size()-1) ? idx % arr.size() : idx;
			sb.append(arr.remove(idx)+", ");
			idx+=K;
		}
		
		sb.append(arr.remove(0)+">");
		System.out.println(sb.toString());
	}
}
