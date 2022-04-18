package hw9;

public class FibonacciSequence {
    // Simple compute number in Fibonacci sequence
    public int simpleFibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        return simpleFibonacci(number - 2) + simpleFibonacci(number - 1);
    }

    // Memorization compute number in Fibonacci sequence
    public long fibonacciWithMemorization(int n) {
        long[] cache = new long[n + 1];

        return computeOrGetFromCache(n, cache);
    }

    private long computeOrGetFromCache(int n, long[] cache) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (cache[n] == 0) {
            cache[n] = computeOrGetFromCache(n - 2, cache) + computeOrGetFromCache(n - 1, cache);
        }

        return cache[n];
    }
}