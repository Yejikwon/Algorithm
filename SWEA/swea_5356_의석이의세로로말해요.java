import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.valueOf(bf.readLine());
		for(int tc=1; tc<=TC; tc++) {
			sb.append("#"+tc+" ");
			String[] str = new String[15];
			for(int i=0; i<15; i++) str[i] = "";
			
			for(int i=0; i<5; i++) {
				String[] tmp = bf.readLine().split("");
				for(int j=0; j<tmp.length; j++) {
					str[j]+=tmp[j];
				}
			}
			
			for(int i=0; i<15; i++) {
				sb.append(str[i].toString());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
