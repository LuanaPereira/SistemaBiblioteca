/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemabiblioteca;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author luhpe
 */
public class SistemaBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Gerencia gr = new Gerencia();
        System.out.println("Bem vindo ao sistema bibliotecario!");
        while(true){
            System.out.println("O que deseja realizar?");
            System.out.println("Digite 1 para Adicionar um Livro");
            System.out.println("Digite 2 para Editar um Livro");
            System.out.println("Digite 3 para Excluir um Livro");
            System.out.println("Digite 4 para Buscar um Livro");
            System.out.println("Digite 5 para Listar todos os Livros");
            System.out.println("Digite 6 para Finalizar");
            Scanner escolha = new Scanner(System.in);
            int op = escolha.nextInt();
            if (op==1){
                gr.adicionar();
            }else if (op==2){
                gr.editar();
            }else if (op==3){
                gr.excluir();
            }else if (op==4){
                gr.buscar();
            }else if (op==5){
                gr.listar();
            }else if (op==6){
                System.out.println("Finalizando...");
                break;
            }
        }
        
    
        
    }

}
