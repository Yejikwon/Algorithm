import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.valueOf(bf.readLine());
		String str;
		
		for(int tc=1; tc<=TC; tc++) {
			str = bf.readLine();
			solved(tc, str);
		}
		
		System.out.println(sb.toString());
	}

	private static void solved(int tc, String str) {
		int cnt = 0;
		char s = '0';
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != s) {
				++cnt;
				if(s == '0') s = '1';
				else s = '0';
			}
		}
		
		sb.append("#"+tc+" "+cnt+"\n");
	}
}
