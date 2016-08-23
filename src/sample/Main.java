package sample;

import java.util.Scanner;

/**
 * Created by Felipe.Costa on 8/22/2016.
 */
public class Main {

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o n�mero de linhas e colunas da matriz: ");
        int n = teclado.nextInt();

        int matrizA[][] = new int[n][n];
        int matrizB[][] = new int[n][n];
        int matrizR[][] = new int[n][n];
        App app1, app2, app3, app4;

        System.out.println("\n\nDigite os valores da primeira matriz:");
        recebeMatriz(matrizA, n, teclado);

        System.out.println("Digite os valores da primeira matriz:");
        recebeMatriz(matrizB, n, teclado);

        System.out.println("Digite a quantidade de Threads:");
        int thread = teclado.nextInt();



        System.out.println("Calculando a matriz Resultante: ");
        /////////////////////////////////////////////////////////////////

        if (thread == 1){
            long inicio = System.currentTimeMillis();
            int iniT1 = 0, fimT1 = n;
            app1 = new App(matrizA, matrizB, matrizR, n, iniT1, fimT1);

            Thread t1 = new Thread(app1);
            t1.start();
            try {
                t1.join();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            long tempo = System.currentTimeMillis() - inicio;
            /////////////////////////////////////////////////////////////////
            System.out.println("A multiplicacao demorou: "+tempo+" milisegundos");
            mostraMatriz(matrizR, n);

        }else if (thread == 2){
            long inicio = System.currentTimeMillis();
            int iniT1 = 0, fimT1 = n / thread,
                iniT2 = fimT1 + 1, fimT2 = n;

            app1 = new App(matrizA, matrizB, matrizR, n, iniT1, fimT1);
            app2 = new App(matrizA, matrizB, matrizR, n, iniT2, fimT2);

            Thread t1 = new Thread(app1);
            Thread t2 = new Thread(app2);

            t1.start();
            t2.start();

            try {

                t1.join();
                t2.join();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


            long tempo = System.currentTimeMillis() - inicio;
            /////////////////////////////////////////////////////////////////
            System.out.println("A multiplicacao demorou: "+tempo+" milisegundos");
            mostraMatriz(matrizR, n);

        }
        else if(thread == 3){
            long inicio = System.currentTimeMillis();
            int iniT1 = 0, fimT1 = n / thread,
                    iniT2 = fimT1 + 1, fimT2 = iniT2 + fimT1,
                    iniT3 = fimT2 + 1 , fimT3 = n;

            app1 = new App(matrizA,matrizB,matrizR,n,iniT1,fimT1);
            app2 = new App(matrizA,matrizB,matrizR,n,iniT2,fimT2);
            app3 = new App(matrizA,matrizB,matrizR,n,iniT3,fimT3);

            Thread t1 = new Thread(app1);
            Thread t2 = new Thread(app2);
            Thread t3 = new Thread(app3);

            t1.start();
            t2.start();
            t3.start();

            try {

                t1.join();
                t2.join();
                t3.join();


            }catch (Exception ex){
                System.out.print("Error: "+ex.getMessage());
            }

            long tempo = System.currentTimeMillis() - inicio;
            /////////////////////////////////////////////////////////////////
            System.out.println("A multiplicacao demorou: "+tempo+" milisegundos");
            mostraMatriz(matrizR, n);

        }
        else if(thread == 4){
            long inicio = System.currentTimeMillis();
            int iniT1 = 0, fimT1 =  n / thread,
                    iniT2 = fimT1 + 1, fimT2 = iniT2 + fimT1,
                    iniT3 = fimT2 + 1, fimT3 = iniT3 + fimT1,
                    iniT4 = fimT3 + 1, fimT4 = n;

            app1 = new App(matrizA,matrizB,matrizR,n,iniT1,fimT1);
            app2 = new App(matrizA,matrizB,matrizR,n,iniT2,fimT2);
            app3 = new App(matrizA,matrizB,matrizR,n,iniT3,fimT3);
            app4 = new App(matrizA,matrizB,matrizR,n,iniT4,fimT4);


            Thread t1 = new Thread(app1);
            Thread t2 = new Thread(app2);
            Thread t3 = new Thread(app3);
            Thread t4 = new Thread(app4);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            try {

                t1.join();
                t2.join();
                t3.join();
                t4.join();

            }catch (Exception ex){
                ex.printStackTrace();
            }

            long tempo = System.currentTimeMillis() - inicio;
            /////////////////////////////////////////////////////////////////
            System.out.println("A multiplicacao demorou: "+tempo+" milisegundos");
            mostraMatriz(matrizR, n);
        }

    }

    public static void recebeMatriz(int matriz[][], int n, Scanner teclado){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[i][j] = teclado.nextInt();
            }
        }
    }


    public static void mostraMatriz(int matriz[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
