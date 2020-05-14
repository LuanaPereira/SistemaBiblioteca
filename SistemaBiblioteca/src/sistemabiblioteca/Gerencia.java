/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author luhpe
 */
public class Gerencia {
 
    public void adicionar() throws FileNotFoundException, IOException{
        Livro auxAdd = new Livro();
        ArrayList<Livro> livro = new ArrayList<>();
        BufferedReader leitura = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        
        System.out.println("Nome do livro que deseja adicionar?");
        Scanner nome = new Scanner(System.in);
        auxAdd.nome = nome.next();
        
        System.out.println("Nome do autor do livro que deseja adicionar?");
        Scanner autor = new Scanner(System.in);
        auxAdd.autor = autor.next(); 
        
        System.out.println("Nome do livro que deseja adicionar?");
        Scanner ano = new Scanner(System.in);
        auxAdd.ano = Integer.parseInt(ano.next());
        
        while (leitura.ready()) {
            String linha = leitura.readLine();
            Livro aux = new Livro();
            String[] divisao = linha.split(";");
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            livro.add(aux);
        }
        livro.add(auxAdd);
        leitura.close();
        
        FileWriter arquivo = new FileWriter("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt");
        PrintWriter escrita = new PrintWriter(arquivo);
        for(int i=0; i<livro.size();i++){
            escrita.printf(livro.get(i).nome + ";" + livro.get(i).autor + ";" + livro.get(i).ano);
            escrita.printf("\n");
        }
        System.out.println("Livro Adicionado!");
        arquivo.close();
    }
    
    public void editar() throws FileNotFoundException, IOException{
        ArrayList<Livro> livro = new ArrayList<>();
        BufferedReader leitura = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (leitura.ready()) {
            String linha = leitura.readLine();
            String[] divisao = linha.split(";");
            Livro aux = new Livro();
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            livro.add(aux);
        }
        leitura.close();
        
        System.out.println("Qual nome livro deseja editar?");
        Scanner entrada = new Scanner(System.in);
        String livroEditar = entrada.next();
        for (int i =0; i<livro.size(); i++){
            if (livroEditar.equals(livro.get(i).nome)){
                System.out.println("Qual informação deseja editar");
                System.out.println("Digite 1 para Nome");
                System.out.println("Digite 2 para Autor");
                System.out.println("Digite 3 para Ano");
                Scanner opcao = new Scanner(System.in);
                Scanner editar = new Scanner(System.in);
                String edicao = entrada.next();
                int op = opcao.nextInt();  
                switch (op) {  
                    case 1 : livro.get(i).nome = edicao;
                    break;   
                    case 2 : livro.get(i).autor = edicao;
                    break;   
                    case 3 : livro.get(i).ano = Integer.parseInt(edicao);
                    break;
                    default: System.out.println("Somente numeros entre 1 e 3");  
                }
            }
        }
        
        FileWriter arquivo = new FileWriter("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt");
        PrintWriter escrita = new PrintWriter(arquivo);
        for(int i=0; i<livro.size();i++){
            escrita.printf(livro.get(i).nome + ";" + livro.get(i).autor + ";" + livro.get(i).ano);
            escrita.printf("\n");
        }
        System.out.println("Livro Editado!");
        arquivo.close();
    }
    public void excluir() throws FileNotFoundException, IOException{
        ArrayList<Livro> livro = new ArrayList<>();
        BufferedReader leitura = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (leitura.ready()) {
            String linha = leitura.readLine();
            String[] divisao = linha.split(";");
            Livro aux = new Livro();
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            livro.add(aux);
        }
        leitura.close();
        
        System.out.println("Qual nome livro deseja excluir?");
        Scanner entrada = new Scanner(System.in);
        String livroExcluir = entrada.next();
        for (int i =0; i<livro.size(); i++){
            if (livroExcluir.equals(livro.get(i).nome)){
                livro.remove(i);
            }
        }
        
        FileWriter arquivo = new FileWriter("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt");
        PrintWriter escrita = new PrintWriter(arquivo);
        for(int i=0; i<livro.size();i++){
            escrita.printf(livro.get(i).nome + ";" + livro.get(i).autor + ";" + livro.get(i).ano);
            escrita.printf("\n");
        }
        System.out.println("Livro Excluido!");
        arquivo.close();
        
    }
    public void buscar() throws FileNotFoundException, IOException{
        System.out.println("Deseja buscar livro por:");
        System.out.println("Digite 1 para Nome");
        System.out.println("Digite 2 para Autor");
        System.out.println("Digite 3 para Ano");
        Scanner opcao = new Scanner(System.in);
        int op = opcao.nextInt();  
        switch (op) {  
            case 1 : buscarNome();
            break;   
            case 2 : buscarAutor();  
            break;   
            case 3 : buscarAno();
            break;
            default: System.out.println("Somente numeros entre 1 e 3");  
        }
    }
    public void buscarNome() throws FileNotFoundException, IOException{
        boolean controle = false;
        System.out.println("Qual nome do livro deseja buscar?");
        Scanner entrada = new Scanner(System.in);
        String nomeBusca = entrada.next();
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (arquivo.ready()) {
            String linha = arquivo.readLine();
            Livro aux = new Livro();
            String[] divisao = linha.split(";");
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            if (nomeBusca.trim().equals(aux.nome)){
                System.out.println("Nome : " + aux.nome + " Autor: " + aux.autor + " Ano: " + aux.ano);
                controle = true;
            }
        }
        if (controle==false){
            System.out.println("Livro(s) nao encontrado ");
        }else {
            System.out.println("Livro(s) Encontrado! ");
        }
        arquivo.close();
    }
    public void buscarAutor() throws FileNotFoundException, IOException{
        boolean controle = false;
        System.out.println("Qual autor do livro deseja buscar?");
        Scanner entrada = new Scanner(System.in);
        String autorBusca = entrada.next();
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (arquivo.ready()) {
            String linha = arquivo.readLine();
            Livro aux = new Livro();
            String[] divisao = linha.split(";");
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            if (autorBusca.trim().equals(aux.autor)){
                System.out.println("Nome : " + aux.nome + " Autor: " + aux.autor + " Ano: " + aux.ano);
                controle = true;
            }
        }
        if (controle==false){
            System.out.println("Autor(es) nao encontrado ");
        }else {
            System.out.println("Autor(es) Encontrado! ");
        }
        arquivo.close();
    }
    public void buscarAno() throws FileNotFoundException, IOException{
        boolean controle = false;
        System.out.println("Qual ano do livro deseja buscar?");
        Scanner entrada = new Scanner(System.in);
        String anoBusca = entrada.next();
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (arquivo.ready()) {
            String linha = arquivo.readLine();
            Livro aux = new Livro();
            String[] divisao = linha.split(";");
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            if (anoBusca.trim().equals(aux.ano)){
                System.out.println("Nome : " + aux.nome + " Autor: " + aux.autor + " Ano: " + aux.ano);
                controle = true;
            }
        }
        if (controle==false){
            System.out.println("Ano do livro nao encontrado ");
        }else {
             System.out.println("Ano do livro Encontrado! ");
        }
        arquivo.close();
    }
    public void listar() throws IOException{
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\luhpe\\Documents\\NetBeansProjects\\SistemaBiblioteca\\src\\sistemabiblioteca\\livro.txt"));
        while (arquivo.ready()) {
            String linha = arquivo.readLine();
            Livro aux = new Livro();
            String[] divisao = linha.split(";");
            aux.nome = divisao[0];
            aux.autor = divisao[1];
            aux.ano = Integer.parseInt(divisao[2]);
            System.out.println("Livro: " + aux.nome + " Autor: " + aux.autor + " Ano: " + aux.ano); 
        }
        arquivo.close();
    }
}

//Toda vez que executar o projeto, você tem que abrir o documento de texto e carregar os livros salvos no txt, e toda vez que fechar o projeto você tem que salvar as alterações no documento de texto. 
//Uma dica pra ajudar na hora de fechar o projeto e salvar tudo, você pode excluir o arquivo de texto existente e criar um novo pra salvar todos os livros de novo.

//Para salvar um livro, pode salvar um um .txt da seguinte maneira:
//- Salvar um livro por linha
//- Separando as informações por ;
//- Exemplo: LivroA;AutorB;2019;
