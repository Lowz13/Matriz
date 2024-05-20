package fes.aragon.inicio;

import fes.aragon.modelo.CrearMtz;
import fes.aragon.modelo.Proceso;
import fes.aragon.modelo.Operaciones;
import fes.aragon.modelo.Racional;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int c, r, aux;
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese los renglones de la matriz :");
        r = sc.nextInt();
        System.out.println("Ingrese las columnas de la matriz :");
        c = sc.nextInt();
        double[][] matriz = new double[r][c];
        CrearMtz crear = new CrearMtz(r, c);
        matriz = crear.CrearMatriz();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == c - 1) {
                    System.out.printf("|%4.0f ", matriz[i][j]);
                } else {

                    System.out.printf("%4.0f ", matriz[i][j]);
                }
            }
            System.out.println();
        }
        Proceso.desarrollo(r, c, matriz);
        for (int i = 0; i < r; i++) {
            boolean f = matriz[i][c - 1] == (int) matriz[i][c - 1];
            System.out.println(f);
        }
        System.out.println();
        boolean f=false;
        for (int i = 0; i < r; i++) {
            aux=0;
           do{
               matriz[i][c - 1] = matriz[i][c - 1] * 10;
               System.out.printf("%4f  \n", matriz[i][c - 1]);
               if (matriz[i][c - 1] == (int)matriz[i][c - 1]){
                   f=true;
               }
               aux++;
           }while (f==true||aux==20);
        }
    }
}