import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.valueOf(bf.readLine());
		String[] strs;
		Stack<Character> stack = new Stack<>();
		boolean flag = false;

		for (int i = 0; i < N; i++) {
			stack.clear();
			strs = bf.readLine().split("");
			flag = false;

			for (int j = 0; j < strs.length; j++) {
				if (strs[j].equals("("))
					stack.push('(');
				else {
					if (stack.size() != 0)
						stack.pop();
					else {
						sb.append("NO\n");
						flag = true;
						break;
					}
				}
			}

			if (!flag && stack.size() != 0)
				sb.append("NO\n");
			else if (!flag && stack.size() == 0)
				sb.append("YES\n");
		}

		System.out.println(sb.toString());
	}
}
