/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartamentoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import model.Departamento;

/**
 *
 * @author josue
 */
@Named(value = "departamentoC")
@SessionScoped
public class DepartamentoC implements Serializable {

    private Departamento departamento;
    private DepartamentoImpl dao;
    private List<Departamento> listadodept;
    private Departamento selectedDept;

    public DepartamentoC() {
        dao = new DepartamentoImpl();
        
    }

    @PostConstruct
    public void init() {
        try {
            listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            listadodept = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public DepartamentoImpl getDao() {
        return dao;
    }

    public void setDao(DepartamentoImpl dao) {
        this.dao = dao;
    }

    public List<Departamento> getListadodept() {
        return listadodept;
    }

    public void setListadodept(List<Departamento> listadodept) {
        this.listadodept = listadodept;
    }

    public Departamento getSelectedDept() {
        return selectedDept;
    }

    public void setSelectedDept(Departamento selectedDept) {
        this.selectedDept = selectedDept;
    }

}
