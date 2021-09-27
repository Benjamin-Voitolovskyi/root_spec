public class AlgEquation implements Function {
	protected int n;
	protected double[] a;

	public AlgEquation(int n, double[] a) {
		this.n = n;
		this.a = a;
	}

	@Override
	public double getValue(double x) {
		double result = 0;
		for (int i = 0; i <= n; ++i) {
			result += a[i] * Math.pow(x, i);
		}
		return result;
	}

	@Override
	public double getFiValue(double x) {
		return (-2 * Math.pow(x, 5) + 8 * Math.pow(x, 2) + 61 * x + 20) / 81;
	}

	@Override
	public double firstDerivative(double x) {
		double result = 0;
		for (int i = 1; i <= n; ++i) {
			result += a[i] * i * Math.pow(x, i - 1);
		}
		return result;
	}

	@Override
	public double secondDerivative(double x) {
		double result = 0;
		for (int i = 2; i <= n; ++i) {
			result += a[i] * i * (i - 1) * Math.pow(x, i - 2);
		}
		return result;
	}
}
