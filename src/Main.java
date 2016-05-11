public class Main {

    public static int gcd(int m, int n){
        if (m==0){
            return n;
        }
        if (n==0){
            return m;
        }
        return gcd(n,m%n);
    }

    public static void main(String[] args) {
        System.out.println(gcd(60,24));
    }
}
