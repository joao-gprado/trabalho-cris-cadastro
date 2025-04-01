package com.mycompany.trabalho.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author joaop
 */
public class FuncionarioDAO {
    private String nomeArq = null;
    
    public FuncionarioDAO(String nomeArq){
        this.nomeArq = nomeArq;
    }
    
    public void grava(Funcionario funcionario) throws IOException{
        FileWriter arquivoSaida = new FileWriter(nomeArq, true);
        PrintWriter  out = new PrintWriter(arquivoSaida);
        
        out.println(funcionario.getCodigo());
        out.println(funcionario.getNome());
        out.println(funcionario.getSalario());
        
        out.close();
        arquivoSaida.close();
        
    }
    
    public Funcionario recupera(String codigo) throws IOException{
        FileReader arquivo = new FileReader("funcionarios.txt");
        
        Scanner leitor = new Scanner(arquivo);
        
        while(leitor.hasNext()){
            String cod = leitor.nextLine();
            String nome = leitor.nextLine();
            String salario = leitor.nextLine();
            
            if(cod.equalsIgnoreCase(codigo)){
                return new Funcionario(cod, nome, Double.parseDouble(salario));
            }
        }
        
        arquivo.close();
        return null;
    }
    
    public Collection<Funcionario> recuperaTodos() throws FileNotFoundException{
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        FileReader arquivo = new FileReader("funcionarios.txt");
        
        Scanner leitor = new Scanner(arquivo);
        
        while(leitor.hasNext()){
            String cod = leitor.nextLine();
            String nome = leitor.nextLine();
            String salario = leitor.nextLine();
            
            funcionarios.add(new Funcionario(cod,nome,Double.parseDouble(salario)));
        }
        
        return funcionarios;
    }
}