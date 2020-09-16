/*
 * 글자의 맨 끝에부터 시작하므로 (커서가 글자의 맨 뒤에 있음)
 * 스택을 이용해서, 글자의 거꾸로부터 커서 조작 & 글자 삽입/삭제 등을 진행한다.
 * 최종으로는 왼쪽 스택을 오른쪽 스택으로 넣은 후 -> 순서대로 출력한다.
 * L -> 오른쪽 스택으로
 * D -> 왼쪽 스택으로
 * B -> 왼쪽 스택의 글자 삭제
 * P -> 왼쪽 스택에 글자 넣기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bf.readLine().split("");
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		
		for(int i=0; i<arr.length; i++) left.push(arr[i]);
		int size = Integer.valueOf(bf.readLine());
		
		for(int i=0; i<size; i++) {
			arr = bf.readLine().split(" ");
			switch(arr[0]) {
			case "L":
				if(left.size() > 0) right.push(left.pop());
				break;
			case "D":
				if(right.size() > 0) left.push(right.pop());
				break;
			case "B":
				if(left.size() > 0) left.pop();
				break;
			case "P":
				left.push(arr[1]);
			}
		}
		
		size = left.size();
		for(int i=0; i<size; i++) right.push(left.pop());
		
		size = right.size();
		for(int i=0; i<size; i++) System.out.print(right.pop());
	}
}
