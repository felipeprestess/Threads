package sample;

/**
 * Created by Felipe.Costa on 8/22/2016.
 */
public class App implements Runnable{

    private int a[][], b[][], c[][];
    private int n, ini = 0, fim = 0;

    public App(int matA[][], int matB[][],int matR[][], int n, int ini, int fim){
        this.a = matA;
        this.b = matB;
        this.n = n;
        this.c = matR;
        this.ini = ini;
        this.fim = fim;
    }

    @Override
    public void run() {

        //função de multiplicação do método MAIN
        for (int i = ini; i <= fim ; i++)//linha matriz A
        {
            for (int j = 0; j < n; j++)//coluna matriz B
            {
                try
                {
                    c[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }catch (Exception ex){

                }
            }
        }

    }
}
