import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		int K = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++) {
			K = Integer.valueOf(bf.readLine());
			if(K != 0) stack.push(K);
			else stack.pop();
		}
		
		int sum = 0;
		int size = stack.size();
		for(int i=0; i<size; i++) sum += stack.pop();
		
		System.out.println(sum);
	}
}
