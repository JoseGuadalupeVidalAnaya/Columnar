/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp;

/**
 * @author jose
 */
public class Columnar
{

    char clave[];
    int clave2[];
    String mensaje;
    String alfa;

    Columnar()
    {
        alfa = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz";
    }

    public void setClave(String c)
    {
        clave = c.replaceAll(" ", "").toCharArray();
        clave2 = new int[clave.length];
        int cont = 0;

        for (int i = 0; i < alfa.length(); i++)
        {
            for (int j = 0; j < clave.length; j++)
            {
                if (clave[j] == alfa.charAt(i))
                {
                    clave2[j] = cont;
                    cont++;
                }
            }
        }
    }

    void setMensaje(String s)
    {
        mensaje = s.replaceAll(" ", "");
        while ((mensaje.length() % clave2.length) != 0)
            mensaje = mensaje + "x";
    }

    String cifrar()
    {
        String c = "";
        String s[] = dividir();
        String aux[][] = new String[s.length][clave.length];
        for (int i = 0; i < s.length; i++)
        {
            for (int j = 0; j < s[i].length(); j++)
                aux[i][clave2[j]] = s[i].charAt(j) + "";
        }

        for (String[] aux1 : aux)
        {
            for (String aux11 : aux1)
                c = c + aux11;
        }
        return c;
    }

    String[] dividir()
    {
        String s[] = new String[mensaje.length() / clave.length];
        for (int i = 0; i < s.length; i++)
            s[i] = mensaje.substring(clave.length * i, i * clave.length + clave.length);
        return s;
    }

    String decifrar()
    {
        String c = "";
        String s[] = dividir();
        String aux[][] = new String[s.length][clave.length];
        for (int i = 0; i < aux.length; i++)
        {
            for (int j = 0; j < aux[i].length; j++)
                aux[i][j] = s[i].charAt(clave2[j]) + "";
        }
        for (String[] aux1 : aux)
        {
            for (String aux11 : aux1)
                c = c + aux11;
        }
        return c;
    }
}
