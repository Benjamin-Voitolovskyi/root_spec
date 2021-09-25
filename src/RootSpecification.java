import java.util.Scanner;

public class RootSpecification {
    private Function f;
    private int k;

    public RootSpecification(Function f) {
        this.f = f;
    }

    public double divideByTwo(double a, double b, double eps){
        double an = a;
        double bn = b;
        double c;

        k = 0;
        do {
            c = (an + bn) / 2.0;

            if (f.getValue(c) == 0.0)
                break;
            else {
                if (f.getValue(an) * f.getValue(c) < 0)
                    bn = c;
                else an = c;
                ++k;
            }
        } while (Math.abs(bn-an)>=2*eps);

        return (an + bn) / 2.0;
    }

    //write your methods here

    public int getK() {
        return k;
    }

    public static void main(String[] args){
        System.out.println("Algebraic equation");

        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.print("(n>=2) n = ");
            n = in.nextInt();
        } while (n<2);

        System.out.println("Input n+1 coefficients:");
        double[] a = new double[n+1];
        for(int i=0;i<=n;++i)
            a[i] = in.nextDouble();

        AlgEquation algEquation = new AlgEquation(n, a);
        RootSpecification rootSpecification =
                new RootSpecification(algEquation);

        double a1, b;
        do {
            System.out.print("Input a, b (b>a && f(a)*f(b)<0): ");
            a1 = in.nextDouble();
            b = in.nextDouble();
        } while (b<=a1 || algEquation.getValue(a1)*algEquation.getValue(b)>=0);

        System.out.print("epsilon = ");
        double eps = in.nextDouble();

        System.out.println("№\tMethod              x       number of iterations");
        System.out.println("1\tDivide by two\t"+
                rootSpecification.divideByTwo(a1,b,eps)+"         "+
                rootSpecification.getK());
        //write other methods here
        System.out.println();

        System.out.println("Transcendent equation");

        RootSpecification rootSpecification1 =
                new RootSpecification(new TransEquation());

        do {
            System.out.print("Input a, b (b>a && f(a)*f(b)<0): ");
            a1 = in.nextDouble();
            b = in.nextDouble();
        } while (b<=a1 || algEquation.getValue(a1)*algEquation.getValue(b)>=0);

        System.out.print("epsilon = ");
        eps = in.nextDouble();

        System.out.println("№\tMethod              x       number of iterations");
        System.out.println("1\tDivide by two\t"+
                rootSpecification1.divideByTwo(a1,b,eps)+"         "+
                rootSpecification1.getK());
        //write other methods here
    }
}
