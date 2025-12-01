package ExercicioModulo7; /**@author Aylan
 *
 * **/

/**
 * @return
 * Texto
 */

class Pessoa {
    String nome;


    Pessoa(String nome) {
        this.nome = nome;
    }
}

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Aylan");


        System.out.println("O nome é: " + pessoa.nome);
    }
}