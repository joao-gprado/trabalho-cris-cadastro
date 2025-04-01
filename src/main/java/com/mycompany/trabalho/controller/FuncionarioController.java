package com.mycompany.trabalho.controller;

import com.mycompany.trabalho.model.Funcionario;
import com.mycompany.trabalho.model.FuncionarioDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaop
 */
public class FuncionarioController {
    private FuncionarioDAO dao;

    public FuncionarioController() {
        this.dao = new FuncionarioDAO("funcionarios.txt");
    }
    
    public List<Funcionario> recuperaTodos() throws FileNotFoundException{
        return new ArrayList<>(dao.recuperaTodos());
    }

    public void grava(String codigo, String nome, double salario) throws IOException {
        Funcionario funcionario = new Funcionario(codigo, nome, salario);
        dao.grava(funcionario);
    }
}
