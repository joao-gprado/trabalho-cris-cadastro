package com.mycompany.trabalho.controller;

import com.mycompany.trabalho.model.Funcionario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaop
 */
public class TableController {
    private FuncionarioController funcionarioController;
    
    public TableController(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
    }
    
    public void preencherTabelaFuncionarios(JTable jTableFuncionarios, List<Funcionario> funcionarios) {
        DefaultTableModel modelo = (DefaultTableModel) jTableFuncionarios.getModel();

        modelo.setRowCount(0);

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                modelo.addRow(new Object[]{
                    funcionario.getCodigo(), 
                    funcionario.getNome(), 
                    funcionario.getSalario()
                });
            }
        }
    }
}
