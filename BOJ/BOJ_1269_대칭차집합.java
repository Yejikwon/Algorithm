import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int A = Integer.valueOf(st.nextToken());
		int B = Integer.valueOf(st.nextToken());

		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();

		st = new StringTokenizer(bf.readLine(), " ");
		String str = "";
		for (int i = 0; i < A; i++) {
			str = st.nextToken();
			map1.put(str, str);
		}

		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < B; i++) {
			str = st.nextToken();
			map2.put(str, str);
		}
		
		int cnt = 0;
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				cnt++;
			}
		}
		
		System.out.println(map1.size() + map2.size() - cnt*2);
	}
}
