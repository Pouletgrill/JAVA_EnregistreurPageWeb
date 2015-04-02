//EnregistreurPageWeb
//----------------
//Xavier Brosseau
//Charlie Laplante
import java.io.*;
import java.net.*;//HttpURLConnection;
//import java.net.URL;

public class EnregistreurPageWeb
{
	final static int port = 80;
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
		/*-Pink*/
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
		try 
		{
			int numSubstring = 7;
			if (WebPage.contains("https"))
				numSubstring = 8;
			Socket s = new Socket(InetAddress.getByName(WebPage.substring(numSubstring)), port);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			PrintWriter doc = 	new PrintWriter(
								new BufferedWriter(
								new FileWriter(nom_sortie) ) );
								
			pw.println("GET / HTTP/1.1");
			pw.println("Host: " + WebPage.substring(numSubstring));
			pw.println("");		
			pw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result;
			System.out.println("//////////////" + WebPage.substring(numSubstring) +"//////////////");
		
			while((result = br.readLine()) != null)
			{
				System.out.println(result);
				doc.println(result);
			}		
			br.close();
			doc.close();
		}
		catch (Exception ioex)
		{
			System.err.println("Impossible de de connecter a la page hote..");
		}
    }
}
