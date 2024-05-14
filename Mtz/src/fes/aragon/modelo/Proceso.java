package fes.aragon.modelo;

public class Proceso {
    public void Proceso(int renglon, int columna, double mtz[][]){
        for (int i = 0; i < renglon; i++) {
            for (int j = i; j < columna; j++) {
                if (i==j && mtz[i][j]!=1){
                    //encuentra 1

                    //sumar un renglon con la diagonal = 1
                }
            }
            System.out.println();
        }
    }
}
