import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double xp, xk, dx, x, eps, result, s = 0;
        int n = 0;

        System.out.print("xp = "); xp = scan.nextDouble();
        System.out.print("xk = "); xk = scan.nextDouble();
        System.out.print("dx = "); dx = scan.nextDouble();
        System.out.print("eps = "); eps = scan.nextDouble();

        System.out.println("-------------------------------------------------");
        System.out.printf("%s \n", "|     " + "x   " + " | "  +
                "ln((1+x)/(1-x))" + " |    " + "S" + "    |    " + "n" + "   |" );
        System.out.println("-------------------------------------------------");

        x = xp;
        while(x <= xk){
            s = S(x, eps, n, s);

            x = Double.parseDouble(String.format("%.2f", x));
            s = Double.parseDouble(String.format("%.3f", s));
            result = Double.parseDouble(String.format("%.5f", Math.log((1 + x) / (1 - x))));
            System.out.printf("%s \n", "|    " + x + "   |     " +
                    result + "     |   " +
                    s + "   |    " + n + "   |" );
            x += dx;
        }
    }

    static double S(double x, double eps, int n, double s){
        n = 0;
        double a = x;
        s = a;
        do{
            n++;
            a = A(x, n, a);
            s += a;
        }while(Math.abs(a) >= eps);
        return s;
    }

    public static double A(double x, int n, double a){
        double R = (x * x) * ((2 * n - 1) / (2 * n + 1));
        a *= R;
        return a;
    }
}