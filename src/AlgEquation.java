public class AlgEquation implements Function{
    private int n;
    private double[] a;

    public AlgEquation(int n, double[] a) {
        this.n = n;
        this.a = a;
    }

    @Override
    public double getValue(double x) {
        double result = 0;
        for(int i=0; i<=n; ++i){
            result+=a[i]*Math.pow(x, i);
        }
        return result;
    }
}
