import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
	static LinkedList<Integer>[] arr;
	static LinkedList<String> answer;
	static String[] node;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.valueOf(bf.readLine());
			node = new String[N+1];
			arr = new LinkedList[N+1];
			
			String[] str;
			for(int i=1; i<=N; i++) {
				str = bf.readLine().split(" ");
				node[i] = str[1];
				arr[i] = new LinkedList<>();
				
				if(str.length > 2) {
					for(int j=2; j<str.length; j++) {
						arr[i].add(Integer.valueOf(str[j]));
					}
				}
			}
			
			answer = new LinkedList<String>();
			inorder(1);
			
			int result = 1;
			String s1,s2,s3;
			while(!answer.isEmpty()) {
				if(answer.size() == 1) {
					if(answer.poll().equals("-1")) break;
				}
				
				s1 = answer.poll();
				s2 = answer.poll();
				s3 = answer.poll();
				
				if(!s2.equals("+") && !s2.equals("-") && !s2.equals("*") && !s2.equals("/")) {
					result = 0;
					break;
				}
				
				answer.add(0, "-1");
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void inorder(int index) {
		if(arr[index].size() != 0) inorder(arr[index].poll());
		answer.add(node[index]);
		if(arr[index].size() != 0) inorder(arr[index].poll());
	}
}
