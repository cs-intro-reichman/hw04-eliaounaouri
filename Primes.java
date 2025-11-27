public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n < 2) {
            System.out.println("Prime numbers must be greater than 1.");
            return;
        }

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int i = 2;
        while (i * i <= n) {
            if (isPrime[i]) {
                int j = i * i;
                while (j <= n) {
                    isPrime[j] = false;
                    j += i;
                }
            }
            i++;
        }

        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;

        for (int k = 2; k <= n; k++) {
            if (isPrime[k]) {
                System.out.println(k);
                primeCount++;
            }
        }

        double examplePercentage = (double) primeCount / n * 100;

        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + (int)examplePercentage + "% are primes)");
    }
}