package org.uniquindio.edu.co.poo.model;

public class Vehiculo {
    private String matricula;
    private String color;
    private String modelo;
    private String marca;

    public Vehiculo(String matricula, String color, String modelo, String marca) {
        this.matricula = matricula;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula; }
    public void setMatricula(String matricula) {
        this.matricula = matricula; }

    public String getColor() {
        return color; }
    public void setColor(String color) {
        this.color = color; }

    public String getModelo() {
        return modelo; }
    public void setModelo(String modelo) {
        this.modelo = modelo; }

    public String getMarca() {
        return marca; }
    public void setMarca(String marca) {
        this.marca = marca; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}