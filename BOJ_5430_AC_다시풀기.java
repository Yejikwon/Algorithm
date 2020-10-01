import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static String[] order;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.valueOf(bf.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			order = bf.readLine().split("");
			int n = Integer.valueOf(bf.readLine());
			arr = bf.readLine().replace("[", "").replace("]", "").split(",");
			solved(n);
		}
	}

	// R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수
	private static void solved(int n) {		
		Deque<String> Q = new ArrayDeque<String>();
		for (int i = 0; i < n; i++) {
			Q.add(arr[i]);
		}

		boolean flag = true; // 정방향
		for (int i = 0; i < order.length; i++) {
			switch (order[i]) {
			case "R":
				if (flag) {
					flag = false;
					continue;
				}
				flag = true;
				break;
			case "D":
				if (Q.isEmpty() || n==0) {
					System.out.println("error");
					return;
				}
				if (flag) {
					Q.poll();
					continue;
				}
				Q.pollLast();
				break;
			}
		}

		StringBuilder sb = new StringBuilder("[");
		if (flag) {
			while (!Q.isEmpty()) {
				sb.append(Q.poll() + ",");
			}
		} else {
			while (!Q.isEmpty()) {
				sb.append(Q.pollLast() + ",");
			}
		}
		if(sb.charAt(sb.length()-1)==',') sb = sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		System.out.println(sb.toString());
		return;
	}
}
