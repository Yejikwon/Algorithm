import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int ansIdx = 0;
		int start, end, pick;

		for (int i = 0; i < commands.length; i++) {
			start = commands[i][0];
			end = commands[i][1];
			pick = commands[i][2];

			int[] tmp = new int[end - start + 1];
			int idx = 0;
			for (int j = start - 1; j < end; j++) {
				tmp[idx++] = array[j];
			}

			Arrays.sort(tmp);
			answer[ansIdx++] = tmp[pick - 1];
		}
		return answer;
	}
}
