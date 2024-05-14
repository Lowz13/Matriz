package fes.aragon.inicio;

import fes.aragon.modelo.CrearMtz;
import fes.aragon.modelo.Proceso;

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
        Proceso desarrollo=new Proceso();
        desarrollo.Proceso(r,c,matriz);
    }
}