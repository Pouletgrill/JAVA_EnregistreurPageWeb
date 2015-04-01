//EnregistreurPageWeb
//----------------
//Xavier Brosseau
//Charlie Laplante
import com.sun.org.apache.xpath.internal.Arg;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnregistreurPageWeb
{
    public static void main (String args[])
    {
        if (args.length > 0 && args.length <=2) //si 2 parametre
        {
            try
            {
                URL url = new URL(args[0]);
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                huc.getResponseCode();
            }
            catch (IOException eos)
            {
                System.err.println("Adresse URL Invalide");
                System.exit(1);
            }
        }
        else
        {
            System.err.println("Nombre de paramètre invalide");
            System.exit(1);
        }

        /*Gotta get up and try, try,*/try
        {
            if (args.length == 1)
            {
                Enregistreur(args[0],"page.html");
            }
            else
            {
                Enregistreur(args[0],args[1]);
            }
        }
        catch (Exception ioe)
        {
            System.err.println(ioe.getMessage());
        }
    }

    static private void Enregistreur(String WebPage, String nom_sortie)
    {

    }
}
