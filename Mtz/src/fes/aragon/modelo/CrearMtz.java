package fes.aragon.modelo;

import java.util.Scanner;

public class CrearMtz {
    private int renglon;
    private int columna;

    public CrearMtz(int renglon, int columna) {
        this.renglon = renglon;
        this.columna = columna;
    }
    public double[][] CrearMatriz(){
        double [][] mtz=new double[renglon][columna];
        Scanner sc=new Scanner(System.in);
        for (int i=0; i<renglon; i++){
            System.out.println("Renglon r"+(i+1));
            for (int j = 0; j < columna; j++) {
                mtz[i][j]=sc.nextDouble();
            }
        }
        return mtz;
    }
}
