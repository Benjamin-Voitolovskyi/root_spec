public class TransEquation implements Function {
	@Override
	public double getValue(double x) {
		return Math.pow(x - 1.0, 1.0 / 3.0) - Math.exp(-x);
	}

	@Override
	public double getFiValue(double x) {
		return -3 * Math.exp(-3 * x);
	}

	@Override
	public double firstDerivative(double x) {
		return (1 / 3.0) * Math.pow(x, -2 / 3.0) + Math.exp(-x);
	}

	@Override
	public double secondDerivative(double x) {
		return (-2 / 9.0) * Math.pow(x, -5 / 3.0) - Math.exp(-x);
	}
}
