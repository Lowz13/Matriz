package fes.aragon.inicio;

import fes.aragon.modelo.CrearMtz;
import fes.aragon.modelo.Proceso;
import fes.aragon.modelo.Operaciones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int c,r;
        Scanner sc=new Scanner(System.in);
        System.out.println("ingrese los renglones de la matriz :");
        r=sc.nextInt();
        System.out.println("Ingrese las columnas de la matriz :");
        c=sc.nextInt();
        double [][]matriz=new double[r][c];
        CrearMtz crear=new CrearMtz(r,c);
        matriz=crear.CrearMatriz();
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c; j++) {
                System.out.printf("%4.2f ",matriz[i][j]);
            }
            System.out.println();
        }
        Proceso.desarrollo(r,c,matriz);

    }
}