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
    public void setMensaje(String mensaje)
    {
        mensaje=mensaje.replaceAll(" ","_");
        while(mensaje.length()%clave2.length!=0)
        {
            mensaje=mensaje+"_";
        }
        this.mensaje=mensaje;
    }
    public String cifrar()
    {
        String aux="";
        int cont=0;
        for (int i = 0; i <clave2.length; i++)
        {
            if(clave2[i]==cont)
            {
                for (int j=i;j<mensaje.length();j=j+clave2.length)
                {
                    aux=aux+mensaje.charAt(j);
                }
                i=-1;
                cont++;
                aux=aux+" ";
            }
        }
        return aux;
    }
    public void setMensaje2(String s)
    {
        mensaje=s.replaceAll(" ","");
        mensaje=mensaje.replaceAll("_"," ");
    }
    public String decifrar()
    {
        String aux="";
        for (int i = 0; i < mensaje.length()/clave2.length; i++)
        {
            for (int j=0;j<clave2.length;j++)
            {
               aux=aux+mensaje.charAt(clave2[j]*(mensaje.length()/clave2.length)+i);
            }
        }
        return aux;
    }
}
