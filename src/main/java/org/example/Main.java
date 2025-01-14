class Minimum
{
    public static void main(String[] args)
    {
        int X;
        int Y;
        int Z;
        X = Integer.parseInt(args[0]);
        Y = Integer.parseInt(args[1]);
        Z = Foo.Min(X, Y);
        System.out.println(Z);
    }

}
class Foo extends Minimum {
    int c;
    public static int Min(int U, int V) {
        int T;
        if (U < V) T = U;
        else T = V;
        return T;
    }
}