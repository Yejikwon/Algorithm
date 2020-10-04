import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		TreeMap<String, String> map = new TreeMap<>();
		
		for(int i=0; i<str.length(); i++) {
			String now = str.substring(i,str.length());
			map.put(now, now);
		}
		
		StringBuilder sb = new StringBuilder();
		map.forEach((key, value)->sb.append(key+"\n"));
		System.out.println(sb);
	}
}
