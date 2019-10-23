/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.enviocorreo;

import com.opensymphony.xwork2.ActionContext;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author reynel
 */
public class EnviarCorreo {
    
    private String de = "";
    private String contrasenha = "";
    private String para;
    private String asunto;
    private String tipoMensaje;
    private String codigoRecuperacion;

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    public String enviarCorreo() {
        String respuesta = null;
        String mensaje = "";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(de, contrasenha);
                    }
                });
       
        try {
            
            if(tipoMensaje.equals("recuperacionContrasenha")){
                asunto = "RECUPERACIÓN DE CONTRASEÑA";
                HttpServletRequest request = ServletActionContext.getRequest();
                String ip = request.getRequestURL().toString().replaceAll("" + ActionContext.getContext().get(ActionContext.ACTION_NAME), "");
                mensaje = "Hola buen día estimado usuario, para restablecer tu contraseña da clic en el sigueinte link:";
            }
            // ip "http://localhost:8080/Dulceria/img/logo.png"

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(de));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(para));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
            respuesta = "¡En un momento recibirás un correo con tu contraseña!";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
    
}
