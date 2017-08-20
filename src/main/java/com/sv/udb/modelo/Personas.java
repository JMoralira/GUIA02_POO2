/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Jose Lira
 */
public class Personas {
   private int codiPers;
   private String nombrPers;
   private String apelPers;
   private byte[] foto;
   private int codiTipoPers;
   private String genePers;
   private String fechaNaciPers;
   private String duiPers;
   private String nitPers;
   private String tipoSangrePers;
   private int codiUbicPers;
   private String correPers;
   private String fechAltaPers;
   private String fechBajaPers;
   private int estaPers;   
   
   
   public Personas(){
   }

    public Personas(int codiPers, String nombrPers, String apelPers, byte[] foto, int codiTipoPers, String genePers, String fechaNaciPers, String duiPers, String nitPers, String tipoSangrePers, int codiUbicPers, String correPers, String fechAltaPers, String fechBajaPers, int estaPers) {
        this.codiPers = codiPers;
        this.nombrPers = nombrPers;
        this.apelPers = apelPers;
        this.foto = foto;
        this.codiTipoPers = codiTipoPers;
        this.genePers = genePers;
        this.fechaNaciPers = fechaNaciPers;
        this.duiPers = duiPers;
        this.nitPers = nitPers;
        this.tipoSangrePers = tipoSangrePers;
        this.codiUbicPers = codiUbicPers;
        this.correPers = correPers;
        this.fechAltaPers = fechAltaPers;
        this.fechBajaPers = fechBajaPers;
        this.estaPers = estaPers;
    }

    public int getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(int codiPers) {
        this.codiPers = codiPers;
    }

    public String getNombrPers() {
        return nombrPers;
    }

    public void setNombrPers(String nombrPers) {
        this.nombrPers = nombrPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(int codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public String getGenePers() {
        return genePers;
    }

    public void setGenePers(String genePers) {
        this.genePers = genePers;
    }

    public String getFechaNaciPers() {
        return fechaNaciPers;
    }

    public void setFechaNaciPers(String fechaNaciPers) {
        this.fechaNaciPers = fechaNaciPers;
    }

    public String getDuiPers() {
        return duiPers;
    }

    public void setDuiPers(String duiPers) {
        this.duiPers = duiPers;
    }

    public String getNitPers() {
        return nitPers;
    }

    public void setNitPers(String nitPers) {
        this.nitPers = nitPers;
    }

    public String getTipoSangrePers() {
        return tipoSangrePers;
    }

    public void setTipoSangrePers(String tipoSangrePers) {
        this.tipoSangrePers = tipoSangrePers;
    }

    public int getCodiUbicPers() {
        return codiUbicPers;
    }

    public void setCodiUbicPers(int codiUbicPers) {
        this.codiUbicPers = codiUbicPers;
    }

    public String getFechAltaPers() {
        return fechAltaPers;
    }

    public void setFechAltaPers(String fechAltaPers) {
        this.fechAltaPers = fechAltaPers;
    }

    public String getFechBajaPers() {
        return fechBajaPers;
    }

    public void setFechBajaPers(String fechBajaPers) {
        this.fechBajaPers = fechBajaPers;
    }

    public int getEstaPers() {
        return estaPers;
    }

    public void setEstaPers(int estaPers) {
        this.estaPers = estaPers;
    }

    public String getCorrePers() {
        return correPers;
    }

    public void setCorrePers(String correPers) {
        this.correPers = correPers;
    }

    @Override
    public String toString() {
        return nombrPers;
    }
   
   
}
