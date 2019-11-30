package crear;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author adolfo
 */
public class EscribirLeerXML {

    public static void main(String[] args) {

        String nomArchivo = "mensaje";

        ArrayList<Mensaje> listaMensaje = new ArrayList<Mensaje>();

        listaMensaje.add(new Mensaje("user001", "Hola como esta", "2019-10-24 06:35:12"));

        try {
            //  EscribirXML(listaMensaje);
            LeerXML();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void EscribirXML(ArrayList<Mensaje> listaMensaje) throws IOException {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Mensaje.class);
            Marshaller marshaller = context.createMarshaller();
            Mensaje mensaje = new Mensaje();
       
            for (int i = 0; i < listaMensaje.size(); i++) {

                mensaje.setUsuario(listaMensaje.get(i).getUsuario());
                mensaje.setValor(listaMensaje.get(i).getValor());
                mensaje.setFecha(listaMensaje.get(i).getFecha());

            }
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(mensaje, System.out);

            marshaller.marshal(mensaje, new FileWriter("mensaje.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(EscribirLeerXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void LeerXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Mensaje.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Mensaje mensaje = (Mensaje) unmarshaller.unmarshal(new File("mensaje.xml"));

        System.out.println("Usuario:  " + mensaje.getUsuario());
        System.out.println("Valor:  " + mensaje.getValor());
        System.out.println("Fcha:  " + mensaje.getFecha());

    }
}
