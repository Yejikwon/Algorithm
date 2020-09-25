import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
 
public class Solution {
    static int N;
    static char[][] arr;
    static boolean[][] check;
    static LinkedList<Node> answer;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.valueOf(bf.readLine());
         
        for(int tc=1; tc<=TC; tc++) {
            N = Integer.valueOf(bf.readLine());
            arr = new char[N][N];
            check = new boolean [N][N];
            answer = new LinkedList<>();
             
            for(int i=0; i<N; i++) {
                // 화학 물질의 종류에 따라 ‘1’에서 ‘9’사이의 정수를 저장하였다.
                arr[i] = bf.readLine().replaceAll(" ", "").toCharArray();
            }
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] != '0' && !check[i][j]) {
                        find(i,j);
                    }
                }
            }
             
             
            int cnt = answer.size();
            Collections.sort(answer, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if((o1.x*o1.y) == (o2.x*o2.y)) {
                        if(o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return (o1.x*o1.y) - (o2.x*o2.y);
                }
            });
             
            StringBuilder sb = new StringBuilder("#"+tc+" "+cnt);
            while(!answer.isEmpty()) {
                Node now = answer.poll();
                sb.append(" "+now.x+" "+now.y);
            }
            System.out.println(sb.toString());
        }
         
    }
 
    private static void find(int x, int y) {
        int ex = N, ey = N;
        for(int j=y+1; j<N; j++) {
            if(arr[x][j]=='0') {
                ey = j;
                break;
            }
        }
         
        for(int i=x+1; i<N; i++) {
            if(arr[i][y]=='0') {
                ex = i;
                break;
            }
        }
 
        for(int i=x; i<ex; i++) {
            for(int j=y; j<ey; j++) {
                check[i][j] = true;
            }
        }
         
        answer.add(new Node(ex-x, ey-y));
    }
     
    static class Node {
        int x; int y;
 
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
