import java.util.List;
import java.util.ArrayList;

public class Math {
	public long max(long a, long b) {
		return (a > b) ?
				a :
				b;
	}

	public long max(long a, long b, long c) {
		return (a > b) ?
			   (a > c) ? a : c :
			   (b > c) ? b : c;
	}

	public long maxB(long a, long b, long c) {
		if (a > b)
			if (a > c)
				return a;
			else return c;
		else
			if (b > c)
				return b;
			else return c;
	}

	public int digitCount(int num) {
		int count = 0;
		while (num > 0) {
			num = num / 10;
			count++;
		}
		return count;
	}
	
	public int factorial(int n) {
		int fact = 1;
		for (int i = n; i > 0; i--)
			fact = fact * i;
		return fact;
	}

	public int parseInt(String s) {
		int result = 0;
		for (char ch: s.toCharArray()) {
			int d = ch - '0';
			result = result * 10 + d;
		}
		return result;
	}

	public long factorial(int n) {
		long result = 1L;
		for (int i = n; i > 0; i--)
			result = result * i;
		return result;
	}
		
	public long fibonacci(int n) {
		long first = 0;
		long second = 1;
		long curr = 0;
		for (int i = 3; i <= n; i++) {
			curr = first + second;
			first = second;
			second = curr;
		}
		return curr;
	}

	public boolean isFibonacci(long n) {
		long val = 0;
		int i = 0;
		while ((val = fibonacci(i++)) <= n) {
			if (val == n)
				return true;
		}
		return false;
	}

	public long gcd(long a, long b) {
		while (b != 0) {
			a = b;
			b = a % b;
		}
		return a;
	}

	public long power(int x, int n) {
		long result = 1;
		for (int i = 1; i <= n; i++)
			result = result * x;
		return result;
	}

	public long reverse(long n) {
		long result = 0;
		while (n != 0) {
			long rem = n % 10;
			result = result * 10 + rem;
			n = n / 10;
		}
		return result;
	}

	public int digitCount(long n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n / 10;
		}
		return count;
	}

	public long digitSum(long n) {
		long result = 0;
		while (n != 0) {
			long rem = n % 10;
			result = result + rem;
			n = n / 10;
		}
		return result;
	}

	public long digital(long n) {
		while (n > 9)
			n = digitSum(n);
		return n;
	}

	public boolean isPrime(long n) {
		for (long i = 2; i < n; i++)
			if (n % 2 == 0)
				return false;
		return true;
	}

	public long nthPrime(int n) {
		return 0L;
	}

	public List<Integer> findFactorsB(int n) {
		var factors = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				factors.add(i);
		return factors;
	}

	public List<Integer> findFactors(int n) {
		var factors = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);	
			}
		}
		return factors;
	}

	public static void main(String[] args) throws Exception {
		var alg = new MathAlgorithm();
		System.out.println(alg.digitCount(10893));
	}
}