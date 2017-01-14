package pp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable
{
    Columnar c;
    @FXML
    TextField men, clave, out, alfa;

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
        else if (alfa.getText().isEmpty())
        {
            out.setText("Ingrese el alfabeto");
        }
        else
        {
            c.alfa = alfa.getText();
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
            c.alfa = alfa.getText();
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
            if (!(alfa.getText() + " ").contains(e.getCharacter()))
            {
                e.consume();
            }
        });
        men.setOnKeyTyped(e ->
        {
            if (!(alfa.getText() + " ").contains(e.getCharacter()))
            {
                e.consume();
            }
        });
        alfa.setOnKeyTyped(e ->
        {
            if (alfa.getText().contains(e.getCharacter()))
            {
                e.consume();
            }
        });
    }
}