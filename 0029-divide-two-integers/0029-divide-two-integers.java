class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long result = 0;

        // Bit manipulation
        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                result += (1L << i);
                dvd -= (dvs << i);
            }
        }

        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}