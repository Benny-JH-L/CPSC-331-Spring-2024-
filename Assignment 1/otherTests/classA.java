package otherTests;

class A
{
    int[] a = new int[m];
    static void main(int n)
    {
        A[][] b = new A[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                b[i][j] = new A(m);
        }
    }
}
