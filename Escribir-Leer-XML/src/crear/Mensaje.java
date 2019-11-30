/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crear;

/**
 *
 * @author adolfo
 */
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="mensaje")
@XmlType(propOrder={"usuario","valor", "fecha"})
public class Mensaje {
    private String usuario;
    private String valor;
    private String fecha;
    

    public Mensaje() {
    }

    public Mensaje(String usuario, String valor, String fecha) {
        this.usuario = usuario;
        this.valor = valor;
        this.fecha = fecha;
    }

    
    @XmlElement(name="usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @XmlElement(name = "valor")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    @XmlElement(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}