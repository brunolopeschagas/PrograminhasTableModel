/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programinhas bruno.chagas
 */
public class TableModelPessoa extends AbstractTableModel {

    private ArrayList<Pessoa> listaDePessoas;
    private final String[] colunas = {"Nome da Pessoa", "Idade da pessoa"};

    public TableModelPessoa(){
        this.listaDePessoas = new ArrayList<>();
    }
    
    /**
     * Retorna uma linha completa da tabela
     * @param rowIndex
     * @return Pessoa
     */
    public Pessoa getPessoa(int rowIndex){
        return this.listaDePessoas.get(rowIndex);
    }
    
    /**
     * Adiciona uma pessoa a tabela (cria uma linha)
     * @param pPessoa 
     */
    public void addPessoa(Pessoa pPessoa){
        this.listaDePessoas.add(pPessoa);
        fireTableDataChanged();
    }
    
    /**
     * Remove uma pessoa da tabela (remove uma linha)
     * @param rowIndex 
     */
    public void removePessoa(int rowIndex){
        this.listaDePessoas.remove(rowIndex);
        fireTableDataChanged();
    }
    
    
    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {

        return this.listaDePessoas.size();
    }

    /**
     * Retorna o numero de colunas da tabela
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o valor especifico de uma celula
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //switch na coluna
        switch (columnIndex) {

            //coluna do nome da pessoa
            case 0:
                return this.listaDePessoas.get(rowIndex).getNome();

            //coluna da idade da pessoa
            case 1:
                return this.listaDePessoas.get(rowIndex).getIdade();

            default:
                return this.listaDePessoas.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
