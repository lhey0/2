/**
  *
  * Plotter-Klasse
  * Plottet (48) zufällige Daten ODER
  * 4 Tages-TXT-Dateien mit je 48 Daten
  *
  * AUFGABE 1:
  * Die "main"-Methode samt Inhalt, soll ausgegliedert werden. Dazu soll eine neue Klasse Start.java erzeugt werden
  *
  * AUFGABE 2:
  * 48 Zufallsdaten sollen erzeugt werden
  *
  * AUFGABE 3:
  * Die 4 Tagesdaten-Dateien tag1-tag4.txt sollen ausgewertet und geplottet werden
  *
  * @version 2.0 vom 16.01.2021
  * @author GRU
  */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Plotter extends JPanel
{   
  private int[] zufall;
  private int[][] tag;
  private int[] xWert;
  private int[] yWertTag1;
  private int[] yWertTag2;
  private int[] yWertTag3;
  private int[] yWertTag4;
  private boolean leerBoolean;
  private boolean tagBoolean;
  private boolean zufallBoolean;
  
  private JFrame plotFenster;
  private JPanel plotterPanel;
  private JButton clearButton;
  private JButton zufallsButton;
  private JButton tagButton;
  private Scanner scanner1;
  
  public Plotter()
  {   
    zufall = new int[48];
    tag = new int[4][48];
    xWert = new int[48];
    yWertTag1 = new int[48];
    yWertTag2 = new int[48];
    yWertTag3 = new int[48];
    yWertTag4 = new int[48];
    leerBoolean = true;
    tagBoolean = false;
    zufallBoolean = false;
    erstellePlotFenster();
  }
  
  public static void main(String[] args) 
  {
    new Plotter();
  } // end of main
  
  public void erstellePlotFenster()
  {
    plotFenster = new JFrame("Plotter-Test");
    plotterPanel = new JPanel();
    clearButton = new JButton();
    zufallsButton = new JButton();
    tagButton = new JButton();
    
    zufallsButton.setText("Plotte Zufallsdaten");
    zufallsButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        zufallsButton_ActionPerformed(evt);
      }
    });
    
    tagButton.setText("Plotte Tagesdaten");
    tagButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        tagButton_ActionPerformed(evt);
      }
    });
    
    clearButton.setText("Löschen");
    clearButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        clearButton_ActionPerformed(evt);
      }
    });
    
    plotFenster.setSize(600, 500);
    plotFenster.setLocation(600,300);
    plotterPanel.setLayout(new BorderLayout());
    plotterPanel.add(this, BorderLayout.CENTER);
    plotterPanel.add(clearButton, BorderLayout.SOUTH);
    plotterPanel.add(zufallsButton, BorderLayout.WEST);
    plotterPanel.add(tagButton, BorderLayout.NORTH);   
    plotFenster.add(plotterPanel);
    plotFenster.setVisible(true);
  }
  
  @Override
  public void paint(Graphics g) 
  {
    super.paint(g);
    
    g.setColor(Color.BLACK);
    g.drawLine(20, 20, 20, 400);  //x1, y1, x2, y2  --> Y-Achse
    g.drawLine(20, 400, 400, 400); //x1, y1, x2, y2 --> X-Achse
    
    g.drawLine(20, 20, 10, 40);  //x1, y1, x2, y2  --> Y-Achse
    g.drawLine(20, 20, 30, 40);  //x1, y1, x2, y2  --> Y-Achse
    
    g.drawLine(400, 400, 380, 410); //x1, y1, x2, y2 --> X-Achse
    g.drawLine(400, 400, 380, 390); //x1, y1, x2, y2 --> X-Achse
    
    //Button "Plotte Zufallsdaten" betätigt
    if (leerBoolean == false && zufallBoolean) 
    {
      g.setColor(Color.RED);
      
      //(TEIL-)AUFGABE 2: Hier fehlt das plotten der zufälligen Daten mit Hilfe der Methode
      //g.drawLine(x1, y1, x2, y2) siehe auch das Zeichnen der Achsen!. Die Aufgabe ist dann korrekt gelöst, 
      //wenn mit EINEM Aufruf dieser Methode ein entsprechender Plot angezeigt wird!
      
    } // end of if
    
    //Button "Plotte Tagesdaten" betätigt
    if (leerBoolean == false && tagBoolean) 
    {
      g.setColor(Color.RED);
      g.drawPolyline(xWert, yWertTag1, 48);
      g.setColor(Color.MAGENTA);
      g.drawPolyline(xWert, yWertTag2, 48);
      g.setColor(Color.BLUE);
      g.drawPolyline(xWert, yWertTag3, 48);
      g.setColor(Color.GREEN);
      g.drawPolyline(xWert, yWertTag4, 48);
      //AUFGABE 3: Hier fehlt das Plotten der Tagesdaten, welche in den txt-Dateien tag1, tag2, tag3 und tag4
      //stehen. Die benötigten Daten werden bereits in das Array tag[][] korrekt übernommen (s. unten).
      //Die Plots sollen dabei in unterschiedlichen Farben dargestellt werden
      
    } // end of if  
  }
  
  public void clearButton_ActionPerformed(ActionEvent evt) 
  {
    leerBoolean = true;
    tagBoolean = false;
    zufallBoolean = false;
    this.repaint();
  }
  
  public void zufallsButton_ActionPerformed(ActionEvent evt) 
  {
    leerBoolean = false;
    tagBoolean = false;
    zufallBoolean = true;
    
    //(TEIL-)AUFGABE 2: HIER FEHLT die zufällige "Befüllung" des Arrays "zufall[]" mit 48 
    //Beispielwerten im Bereich zwischen 0 und 400
    
    this.repaint();
  } // end of jButton1_ActionPerformed
  
  public void tagButton_ActionPerformed(ActionEvent evt) 
  {
    leerBoolean = false;
    tagBoolean = true;
    zufallBoolean = false;
    for (int p = 0; p<4; p++) 
    {
      try 
      {
        
        scanner1 = new Scanner(new File("tag"+(p+1)+".txt"), "UTF-8");
        scanner1.useLocale(Locale.US);
        int i = 0;
        while (scanner1.hasNext()) 
        {
          if (scanner1.hasNextDouble()) 
          {
            tag[p][i] = (int)(scanner1.nextDouble());
            i++;
          }
          else 
          {
            System.out.println("Fehler in der Datei - Kein Double!");
            scanner1.close();  
          }       
        }
      }
      catch (FileNotFoundException e) 
      {
        System.out.println("Angegebene Datei(en) nicht auffindbar!");
      }
      for (int i=0; i<xWert.length; i++ ) 
      {
       xWert[i] = 20+(i*8); 
      }
      
      for (int i=0; i<yWertTag1.length; i++ ) 
      {
       yWertTag1[i] = tag[0][i]; 
      }
      for (int i=0; i<yWertTag2.length; i++ ) 
      {
       yWertTag2[i] = tag[1][i]; 
      }
      for (int i=0; i<yWertTag3.length; i++ ) 
      {
       yWertTag3[i] = tag[2][i]; 
      }
      for (int i=0; i<yWertTag4.length; i++ ) 
      {
       yWertTag4[i] = tag[3][i]; 
      }
      
      this.repaint();
    } // end of jButton1_ActionPerformed
  } // end of for
  
}
