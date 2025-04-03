package org.uniquindio.edu.co.poo.model;


// polimorfismo estatico Polimorfismo en tiempo de compilación (estático):
//También conocido como sobrecarga de métodos. Ocurre cuando varias funciones
// tienen el mismo nombre pero diferentes parámetros (por ejemplo, diferentes tipos
// o número de parámetros). El compilador decide cuál método llamar en función de la
//  firma del método en el momento de la compilación.

class Calculadora {
    public int suma(int a, int b) {
        return a + b;
    }

    public double suma(double a, double b) {
        return a + b;
    }
}


// polimorfismo dinamico Polimorfismo en tiempo de ejecución (dinámico):
// También conocido como sobrescritura de métodos. Ocurre cuando una c
// lase hija sobrescribe un método de la clase padre. El comportamiento del
//  método es determinado en tiempo de ejecución dependiendo del tipo de objeto que lo invoque.
class Animal {
    public void sonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    public void sonido() {
        System.out.println("El perro ladra");
    }
}

class Gato extends Animal {
    @Override
    public void sonido() {
        System.out.println("El gato maúlla");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal miAnimal = new Perro();
        miAnimal.sonido();  // Imprime: El perro ladra

        miAnimal = new Gato();
        miAnimal.sonido();  // Imprime: El gato maúlla
    }
}


class Impresora {
    void imprimir(String texto) {
        System.out.println(texto);
    }

    void imprimir(int numero) {
        System.out.println(numero);
    }
}

public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        impresora.imprimir("Hola, mundo!");  // Imprime un texto
        impresora.imprimir(100);              // Imprime un número
    }
}


//La sobrecarga de métodos es una forma de polimorfismo en
// Java, que se da cuando varios métodos tienen el mismo nombre
// pero diferentes parámetros (por ejemplo, distinto número de parámetros
// o tipo de datos). El compilador decide qué versión del método invocar según los argumentos pasados.
//Ejemplo de sobrecarga:

class Impresora {
    void imprimir(String texto) {
        System.out.println(texto);
    }

    void imprimir(int numero) {
        System.out.println(numero);
    }
}

public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        impresora.imprimir("Hola, mundo!");  // Imprime un texto
        impresora.imprimir(100);              // Imprime un número
    }
}