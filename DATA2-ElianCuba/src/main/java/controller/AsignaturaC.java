/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AsignaturaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import model.Asignatura;

/**
 *
 * @author PC06
 */
@Named(value = "asignaturaC")
@SessionScoped
public class AsignaturaC implements Serializable {

    private Asignatura asignatura;
    private AsignaturaImpl dao;
    private List<Asignatura> listadoasig;
    private Asignatura selectedAsig;
    public AsignaturaC() {
        dao = new AsignaturaImpl();
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
            listadoasig = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public AsignaturaImpl getDao() {
        return dao;
    }

    public void setDao(AsignaturaImpl dao) {
        this.dao = dao;
    }

    public List<Asignatura> getListadoasig() {
        return listadoasig;
    }

    public void setListadoasig(List<Asignatura> listadoasig) {
        this.listadoasig = listadoasig;
    }

    public Asignatura getSelectedAsig() {
        return selectedAsig;
    }

    public void setSelectedAsig(Asignatura selectedAsig) {
        this.selectedAsig = selectedAsig;
    }
    
}
