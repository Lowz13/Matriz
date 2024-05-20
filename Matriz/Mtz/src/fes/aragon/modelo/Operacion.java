package fes.aragon.modelo;

import java.util.IdentityHashMap;

public class Operacion {
    private Racional racionalUno;
    private Racional racionalDos;

    public Operacion() {
    }

    public Operacion(Racional r1, Racional r2) {
        this.racionalUno = r1;
        this.racionalDos = r2;
    }

    public Racional suma() {
        int numerador = racionalUno.getNumerador() * racionalDos.getDenominador()
                + racionalUno.getDenominador() * racionalDos.getNumerador();
        int denominador = racionalUno.getDenominador() * racionalDos.getDenominador();

        return new Racional(numerador, denominador);
    }

    public Racional resta() {
        int numerador = racionalUno.getNumerador() * racionalDos.getDenominador()
                - racionalUno.getDenominador() * racionalDos.getNumerador();
        int denominador = racionalUno.getDenominador() * racionalDos.getDenominador();

        return new Racional(numerador, denominador);
    }

    public Racional multiplicacion() {
        int numerador = racionalUno.getNumerador() * racionalDos.getNumerador();
        int denominador = racionalUno.getDenominador() * racionalDos.getDenominador();

        return new Racional(numerador, denominador);
    }

    public Racional division() {
        int numerador = racionalUno.getNumerador() * racionalDos.getDenominador();
        int denominador = racionalUno.getDenominador() * racionalDos.getNumerador();

        return new Racional(numerador, denominador);
    }


}
