package fes.aragon.modelo;


public class Proceso {
    public static void desarrollo(int renglon, int columna, double[][] mtz){
        int unoR,unoC,ceroR,ceroC;
        Operaciones op=new Operaciones();
        for (int j = 0; j < columna; j++) {
            for (int i = j; i < renglon; i++) {
                if (!(j==(columna-1))) {
                    if (i == j && mtz[i][j] != 1) {
                        //encuentra 1
                        unoR = op.buscarUno(mtz, renglon, j, i)[0];
                        unoC = op.buscarUno(mtz, renglon, j, i)[1];
                        if (unoC == -1 && unoR == -1) {
                            System.out.println("Se divide el punto [" + i + "][" + j + "] entre si mismo");
                        } else if ((mtz[unoR][unoC] + mtz[i][j]) == 1 || (-1 * mtz[unoR][unoC] + mtz[i][j]) == 1) {
                            System.out.println("Se suma el punto [" + i + "][" + j + "]con el punto [" + unoR + "][" + unoC + "]");
                        } else if (mtz[unoR][unoC] == 1 || mtz[unoR][unoC] == -1) {
                            System.out.println("Se cambia el punto [" + i + "][" + j + "] con el punto [" + unoR + "][" + unoC + "]");
                        }
                        mtz = op.ResolverUno(mtz, columna, i, j, unoC, unoR);
                        for (int k = 0; k < renglon; k++) {
                            for (int l = 0; l < columna; l++) {
                                System.out.printf("    %-4.2f", mtz[k][l]);
                                ;
                            }
                            System.out.println();
                        }
                    }
                    if (i != j && mtz[i][j] != 0) {
                        ceroR = op.BuscarCero(mtz, renglon, columna, i, j)[0];
                        ceroC = op.BuscarCero(mtz, renglon, columna, i, j)[1];
                        System.out.println("se encontro una posibilidad de 0 en el punto [" + ceroR + "][" + ceroC + "] para el punto [" + i + "][" + j + "]");
                        mtz = op.ResolverCero(mtz, i, j, ceroR, ceroC, j, columna);
                        for (int k = 0; k < renglon; k++) {
                            for (int l = 0; l < columna; l++) {
                                System.out.printf("%4.2f ", mtz[k][l]);
                                ;
                            }
                            System.out.println();
                        }
                    }
                }else{
                    j++;
                }
            }
            System.out.println();
        }
    }
}
