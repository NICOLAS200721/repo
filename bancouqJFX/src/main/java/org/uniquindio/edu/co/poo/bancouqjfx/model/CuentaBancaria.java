package org.uniquindio.edu.co.poo.bancouqjfx.model;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (cantidad > saldo) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }

    @Override
    public String toString() {
        return numeroCuenta + " (Saldo: " + saldo + ")";
    }
}