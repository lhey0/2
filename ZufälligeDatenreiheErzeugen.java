/*
IT5: Software zur grafischen Darstellung technischer Prozesse  entwickeln
Im Rahmen des Technik-Kurses (Übung VI)
IT / Herr Grunwald (GRU)

Diese Anwendung erzeugt 4 Textdateien mit je 48 zufälligen, simulierten
Messungen. Das Programm wird als Blackbox betrachtet.
Die Zahl in Zeile 26 und 27 kann beliebig angepasst werden! (Aktuell 400)
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class ZufälligeDatenreiheErzeugen
{
  public static void main(String[] args) throws IOException
  {   
    for (int p=1;p<4;p++) 
    {
      FileWriter fw = new FileWriter("tag"+p+".txt");
      BufferedWriter bw = new BufferedWriter(fw);
      
      for (int i = 0; i<48; i++) 
      {
        int zufallszahl = (int) (Math.random()*400);
        int zufallszahl2 = (int) (Math.random()*400);
        bw.write(zufallszahl + "." + zufallszahl2);
        bw.newLine();
      } // end of for
      bw.close();
    } // end of for  
  }
}
