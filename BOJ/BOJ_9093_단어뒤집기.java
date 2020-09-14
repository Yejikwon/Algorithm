import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		String str = "";
		
		for(int i=0; i<N; i++) {
			str = bf.readLine();
			reverseWords(str);
		}
	}

	private static void reverseWords(String str) {
		String[] arr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		String word = "";
		
		for(int i=0; i<arr.length; i++) {
			word = arr[i];
			for(int j=word.length()-1; j>=0; j--) {
				sb.append(word.charAt(j));
			}
			if(i!=arr.length-1) sb.append(" ");
		}
    // 왜 개행문자가 안들어가는 건지는 모르겠음 ㅋㅋㅋㅋㅋㅋㅋㅋ
		System.out.println(sb.toString());
	}
}
