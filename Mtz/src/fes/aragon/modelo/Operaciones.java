package fes.aragon.modelo;

public class Operaciones {

    public static int[] buscarUno(double mtz[][],int r,int dc,int dr){
        int renglon=-1, columna=-1;
        double enc=1+(-1*mtz[dr][dc]);
        for (int i = dr; i < r; i++) {
            //cambio
            if (mtz[i][dc]==1 || mtz[i][dc]==-1){
                renglon=i;
                columna=dc;
                break;
            }
            //suma/resta
            else if(enc==mtz[i][dc] || mtz[i][dc]==(-1*enc)){
                renglon=i;
                columna=dc;
                break;
            }
        }
        return new int[]{renglon,columna};
    }

    public double[][] ResolverUno(double mtz[][],int r, int c, int dr,int dc, int ec,int er){
        double aux[]=new double[c];
        if (mtz[er][ec]==1) {
            for (int i = 0; i < c; i++) {
                aux[i]=mtz[er][i];
                mtz[er][i]=mtz[dr][i];
                mtz[dr][i]=aux[i];
            }
        }

        return mtz;
    }
}
