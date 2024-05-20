package fes.aragon.modelo;


public class Proceso {
    public static void desarrollo(int renglon, int columna, double[][] mtz){
        int unoR,unoC,ceroR,ceroC;
        Operaciones op=new Operaciones();
        boolean jordan=false;
        for (int j = 0; j < columna; j++) {
            for (int i = j; i < renglon; i++) {
                //quitar terminos independientes
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
                                if (l == columna - 1) {
                                    System.out.printf("| %4.4f", mtz[k][l]);
                                } else {
                                    System.out.printf("%4.4f ", mtz[k][l]);
                                }
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                    //encontrar 0
                    if ((i != j) && (mtz[i][j] != 0)) {
                        ceroR = op.BuscarCero(mtz, renglon, columna, i, j,jordan)[0];
                        ceroC = op.BuscarCero(mtz, renglon, columna, i, j,jordan)[1];
                        if ((ceroC==-1 && ceroR==-1)||mtz[i][j]==-1){
                            System.out.println("el punto["+i+"]["+j+"] pibotea con el uno");
                        }
                        else {
                            if (mtz[i][j] == mtz[ceroR][j] || mtz[i][j] == (-1 * mtz[ceroR][j])) {
                                System.out.println("Se cambia el punto [" + i + "][" + j + "] con el punto [" + ceroR + "][" + ceroC + "]");
                            }
                            else if (mtz[ceroR][j] != 0 && ((mtz[i][j] % mtz[ceroR][j]) == 0 || (mtz[ceroR][j] % mtz[i][j]) == 0)) {
                                System.out.println("Se suma el punto [" + i + "][" + j + "]con el punto [" + ceroR + "][" + ceroC + "]");
                            }
                        }
                        mtz = op.ResolverCero(mtz, i, j, ceroR, ceroC, columna,jordan);
                        for (int k = 0; k < renglon; k++) {
                            for (int l = 0; l < columna; l++) {
                                if (l == columna - 1) {
                                    System.out.printf("| %4.4f", mtz[k][l]);
                                } else {
                                    System.out.printf("%4.4f ", mtz[k][l]);
                                }
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
        //Gauss Jordan
        jordan=true;
        for (int i = (renglon-1); i > -1 ; i--) {
            for (int j = i; j > -1; j--) {
                if (j!=i && mtz[j][i]!=0){
                    ceroR=op.BuscarCero(mtz,renglon,columna,j,i,jordan)[0];
                    ceroC=op.BuscarCero(mtz,renglon,columna,j,i,jordan)[1];
                    if (ceroC==-1){
                        System.out.println("El punto ["+i+"]["+j+"] interactua con ["+ceroR+"]["+ceroC+"]");
                    }
                    mtz=op.ResolverCero(mtz,j,i,ceroR,ceroC,columna,jordan);
                    for (int k = 0; k < renglon; k++) {
                        for (int l = 0; l <columna ; l++) {
                            if (l == columna - 1) {
                                System.out.printf("| %4.4f", mtz[k][l]);
                            } else {
                                System.out.printf("%4.4f ", mtz[k][l]);
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
    }
}
