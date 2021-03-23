public class Recursion {

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }

    static int fibo(int n) {
        if (n < 2)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    static int fibo_it(int n) {
        int prev = 0, next = 1, result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = prev + next;
            prev = next;
            next = result;
        }
        return result;
    }

    static int weird(int n) {
        if (n <= 100) {
            return weird(weird(n + 11));
        }
        return n-10;
    }
}