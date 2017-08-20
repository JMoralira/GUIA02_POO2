/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Personas;
import com.sv.udb.recursos.Conexion;
import java.awt.Image;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jose Lira
 */
public class PersonasCtrl {
     //GUARDAR
    public boolean guar(Personas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into pers values(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cmd.setString(1, obje.getNombrPers());
            cmd.setString(2, obje.getApelPers());
            cmd.setBytes(3, obje.getFoto());
            cmd.setInt(4, obje.getCodiTipoPers());
            cmd.setString(5,obje.getGenePers());
            cmd.setString(6,obje.getFechaNaciPers());
            cmd.setString(7,obje.getDuiPers());
            cmd.setString(8,obje.getNitPers());
            cmd.setString(9,obje.getTipoSangrePers());
            cmd.setInt(10,obje.getCodiUbicPers());
            cmd.setString(11,obje.getCorrePers());
            cmd.setString(12,obje.getFechAltaPers());
            cmd.setString(13,obje.getFechBajaPers());
            cmd.setInt(14,obje.getEstaPers());                   
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Personas: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
     //MOSTRAR
    public List<Personas> constTodo()
    {
        List<Personas> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from pers");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Personas(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getBytes(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),
                        rs.getString(13),rs.getString(14),rs.getInt(15)));
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    public Personas cons(int codi)
    {
        //List<Jugadores> resp = new ArrayList();
        Personas resp = null;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from pers where CODI_PERS = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Personas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBytes(4),
                        rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),
                        rs.getString(13),rs.getString(14),rs.getInt(15)));               
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
      //MODIFICAR
    public boolean modi(Personas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update pers set NOMB_PERS = '"+obje.getNombrPers()+"' , APEL_PERS = '"+obje.getApelPers()+"' , FOTO_PERS = '"+obje.getFoto()+"' , CODI_TIPO_PERS = "+obje.getCodiTipoPers()+" , GENE_PERS = '"+obje.getGenePers()+"' , FECH_NACI_PERS = '"+obje.getFechaNaciPers()+"' , DUI_PERS = '"+obje.getDuiPers()+"' , NIT_PERS = '"+obje.getNitPers()+"'  , TIPO_SANG_PERS = '"+obje.getTipoSangrePers()+"' , CODI_UBIC_GEOG = "+obje.getCodiUbicPers()+" , MAIL_PERS = '"+obje.getCorrePers()+"' , FECH_ALTA = '"+obje.getFechAltaPers()+"' , FECH_BAJA = '"+obje.getFechBajaPers()+"' , ESTA = '"+obje.getEstaPers()+"' where CODI_PERS = "+obje.getCodiPers()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    //ELIMINAR
    public boolean elim(Personas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from pers where CODI_PERS = "+obje.getCodiPers()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
}
