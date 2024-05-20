package fes.aragon.modelo;

public class Operaciones {

    public static int[] buscarUno(double mtz[][], int r, int dc, int dr) {
        int renglon = -1, columna = -1;
        double enc = 1 + (-1 * mtz[dr][dc]);
        for (int i = dr; i < r; i++) {
            //cambio
            if (mtz[i][dc] == 1 || mtz[i][dc] == -1) {
                renglon = i;
                columna = dc;
                break;
            }
            //suma/resta
            else if (enc == mtz[i][dc] || mtz[i][dc] == (-1 * enc)) {
                renglon = i;
                columna = dc;
                break;
            }
        }
        return new int[]{renglon, columna};
    }

    public double[][] ResolverUno(double mtz[][], int c, int dr, int dc, int ec, int er) {
        double aux;
        double enc = 1 + (-1 * mtz[dr][dc]);
        //division
        if ((ec == -1 && er == -1) && mtz[dr][dc] != 0) {
            aux = mtz[dr][dc];
            for (int i = 0; i < c; i++) {
                mtz[dr][i] = mtz[dr][i] / aux;
            }
        }
        //encontrar uno
        else if (mtz[er][ec] == 1) {
            for (int i = 0; i < c; i++) {
                aux = mtz[er][i];
                mtz[er][i] = mtz[dr][i];
                mtz[dr][i] = aux;
            }
        } else if (mtz[er][ec] == -1) {
            for (int i = 0; i < c; i++) {
                aux = (-1 * mtz[er][i]);
                mtz[er][i] = mtz[dr][i];
                mtz[dr][i] = aux;
            }
        }
        //suma
        else if (enc == mtz[er][ec]) {
            for (int i = 0; i < c; i++) {
                mtz[dr][i] = mtz[dr][i] + mtz[er][i];
            }
        } else if (mtz[er][ec] == (-1 * enc)) {
            for (int i = 0; i < c; i++) {
                aux = -1 * mtz[er][i];
                mtz[dr][i] = mtz[dr][i] + aux;
            }
        }
        return mtz;
    }

    public static int[] BuscarCero(double mtz[][], int renglon, int columna, int r, int c, boolean jordan) {
        int eR = -1, eC = -1;
        double aux = 0;
        for (int i = r; i < renglon; i++) {
            if (jordan == false) {
                if (i != r) {
                    if (mtz[r][c] == mtz[i][c] || mtz[r][c] == (-1 * mtz[i][c])) {
                        eR = i;
                        eC = c;
                        break;
                    } else if (mtz[i][c] != 0 && ((mtz[r][c] % mtz[i][c]) == 0 || (mtz[i][c] % mtz[r][c]) == 0)) {
                        eR = i;
                        eC = c;
                        break;
                    }
                }
            } else {
                if (i != r) {
                    if (mtz[r][c] == mtz[i][c] || mtz[r][c] == (-1 * mtz[i][c])) {
                        eR = i;
                        eC = c;
                        break;
                    } else if (mtz[i][c] != 0 && ((mtz[r][c] % mtz[i][c]) == 0 || (mtz[i][c] % mtz[r][c]) == 0)) {
                        eR = i;
                        eC = c;
                        break;
                    }
                }
            }
        }
        return new int[]{eR, eC};
    }

    public double[][] ResolverCero(double mtz[][], int r, int c, int er, int ec, int columna,boolean jordan) {
        double aux;
        //pibotea con la diagonal
        if ((ec == -1 && er == -1) || mtz[r][c] == -1) {
            aux = mtz[r][c];
            for (int i = 0; i < columna; i++) {
                mtz[r][i] = -1 * aux * mtz[c][i] + mtz[r][i];
            }
            for (int i = 0; i < columna; i++) {

            }
        } else {
            if (jordan==false) {
                //suma
                if (mtz[r][c] == mtz[er][ec]) {
                    for (int i = 0; i < columna; i++) {
                        mtz[r][i] = mtz[r][i] - mtz[er][i];
                    }
                } else if (mtz[r][c] == (-1 * mtz[er][ec])) {
                    for (int i = 0; i < columna; i++) {
                        mtz[r][i] = mtz[r][i] + mtz[er][i];
                    }
                }
                //multiplica
                else if ((mtz[r][c] % mtz[er][ec]) == 0) {
                    //r c es el mayor  y  er ec es el menor
                    aux = -1 * (mtz[r][c] / mtz[er][ec]);
                    for (int i = 0; i < columna; i++) {
                        mtz[r][i] = mtz[r][i] + mtz[er][i] * aux;
                    }
                } else if ((mtz[er][ec] % mtz[r][c]) == 0) {
                    //er ec es el mayor  y  r c es el menor
                    aux = -1 * (mtz[er][ec] / mtz[r][c]);
                    for (int i = 0; i < columna; i++) {
                        mtz[r][i] = mtz[er][i] + mtz[r][i] * aux;
                    }
                }
            }
        }
        return mtz;
    }


}