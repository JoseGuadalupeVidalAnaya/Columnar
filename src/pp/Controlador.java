/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * @author jose
 */
public class Controlador implements Initializable
{

    Columnar c;
    @FXML
    TextField men, clave, out;

    @FXML
    void metodoCifrar(ActionEvent e)
    {
        if (men.getText().isEmpty())
        {
            out.setText("Ingrese el mensaje a cifrar");
        }
        else if (clave.getText().isEmpty())
        {
            out.setText("Ingrese la clave para cifrar");
        }
        else
        {
            c.setClave(clave.getText());
            c.setMensaje(men.getText());
            out.setText(c.cifrar());
        }

    }

    @FXML
    void metodoDecifrar(ActionEvent e)
    {
        if (men.getText().isEmpty())
        {
            out.setText("Ingrese el mensaje a cifrar");
        }
        else if (clave.getText().isEmpty())
        {
            out.setText("Ingrese la clave para cifrar");
        }
        else
        {
            c.setClave(clave.getText());
            c.setMensaje(men.getText());
            out.setText(c.decifrar());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        c = new Columnar();
        clave.setOnKeyTyped(e ->
        {
            if (!c.alfa.contains(e.getCharacter()))
            {
                e.consume();
            }
        });
    }

}
