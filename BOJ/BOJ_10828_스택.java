import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(bf.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		String str = "";
		int num = 0;
		for(int i=0; i<N; i++) {
			str = bf.readLine();
			if(str.contains("push")) {
				num = Integer.valueOf(str.split(" ")[1]);
				stack.push(num);
			}else if(str.contains("top")) {
				if(stack.size() != 0) sb.append(stack.peek()+"\n");
				else sb.append(-1+"\n");
			}else if(str.contains("pop")) {
				if(stack.size() != 0) sb.append(stack.pop()+"\n");
				else sb.append(-1+"\n");
			}else if(str.contains("size")) {
				sb.append(stack.size()+"\n");
			} else {
				if(stack.size() == 0) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
