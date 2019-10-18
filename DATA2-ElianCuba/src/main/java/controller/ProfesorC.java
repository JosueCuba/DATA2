/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProfesorImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import model.Profesor;
import org.primefaces.model.DualListModel;

/**
 *
 * @author josue
 */
@Named(value = "profesorC")
@SessionScoped
public class ProfesorC implements Serializable {

    private Profesor profesor;
    private ProfesorImpl dao;
    
    List<Profesor> listaProfesor1;
    List<Profesor> listaProfesor2;
    
    private DualListModel<Profesor> listadoprof;

    public ProfesorC() {
        dao = new ProfesorImpl();
        profesor = new Profesor();
        listaProfesor1 = new ArrayList();
        listaProfesor2 = new ArrayList();
    }

    @PostConstruct
    public void init() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void registrar() throws Exception {

    }

    public void modificar() throws Exception {

    }

    public void eliminar() throws Exception {

    }

    public void listar() throws Exception {
        try {
            listaProfesor1 = dao.listar();
            listadoprof = new DualListModel(listaProfesor1, listaProfesor2);
        } catch (Exception e) {
            System.out.println("Error al listar en Controller");
            throw e;
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesorImpl getDao() {
        return dao;
    }

    public void setDao(ProfesorImpl dao) {
        this.dao = dao;
    }

    public DualListModel<Profesor> getListadoprof() {
        return listadoprof;
    }

    public void setListadoprof(DualListModel<Profesor> listadoprof) {
        this.listadoprof = listadoprof;
    }

}
