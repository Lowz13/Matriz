package fes.aragon.modelo;


public class Proceso {
    public static void desarrollo(int renglon, int columna, double[][] mtz){
        int encR,encC;
        Operaciones op=new Operaciones();
        for (int i = 0; i < renglon; i++) {
            for (int j = i; j < columna; j++) {
                if (i==j && mtz[i][j]!=1){
                    //encuentra 1
                    encR=op.buscarUno(mtz,renglon,j,i)[0];
                    encC=op.buscarUno(mtz,renglon,j,i)[1];
                    if (encR!=-1 && encC!=-1){
                        System.out.println("se encontro una posibilidad de 1 en el punto ["+encR+"]["+encC+"] para el punto ["+i+"]["+j+"]");
                        mtz=
                    }
                    //sumar un renglon con la diagonal = 1
                }
            }
            System.out.println();
        }
    }
}
