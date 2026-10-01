class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length;
        int max = 0;
        for (int i = 0; i < (1 << m); i++) {
            int count = 0;
            int[] bal = new int[n];
            boolean valid = true;
            for (int k = 0; k < m; k++) {
                if ((i & (1 << k)) != 0) {
                    int loss = requests[k][0];
                    int gain = requests[k][1];
                    bal[loss]--;
                    bal[gain]++;
                    count++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (bal[j] != 0) {
                    valid = false;
                    break;
                }
                
            }
            if (valid) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}