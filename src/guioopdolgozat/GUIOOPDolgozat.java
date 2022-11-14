package guioopdolgozat;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class GUIOOPDolgozat {

    public static void main(String[] args) {
    new GUIOOPDolgozat();    
    }
    private static final int Bejelent_Gombok = 10;
    
    private JFrame frame;
    private JButton gombok[];

    public GUIOOPDolgozat() {
        ini();
        ujJatek();
    }

    private void ini() {
        /*A fő ablak*/
        frame = new JFrame("GUI-OOP Dolgozat 1.");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-150, kep.height/2-125, 410, 350);
        
        /*Menü*/
        JMenuBar menubar = new JMenuBar();
        JMenu mnuprg = new JMenu("Program");
        JMenu mnujatek = new JMenu("Játék Elrendezés");
        menubar.add(mnuprg);
        menubar.add(mnujatek);
        frame.setJMenuBar(menubar);
        
        /*Program Menu*/
        JMenuItem mnuprgujra = new JMenuItem("Újra");
        JMenuItem mnuprgkilep = new JMenuItem("Kilépés");
        mnuprg.add(mnuprgujra);
        mnuprg.addSeparator();
        mnuprg.add(mnuprgkilep);
        
        /*Elrendezés Menu*/
        JMenuItem mnujatekViz = new JMenuItem("Vízszintes"); 
        JMenuItem mnujatekFugg = new JMenuItem("Függőleges"); 
        mnujatek.add(mnujatekViz);
        mnujatek.add(mnujatekFugg);

        JPanel pinpanel = new JPanel();
        pinpanel.setBorder(new TitledBorder("Pin Kód"));
        
        JPanel beallitpanel = new JPanel();
        beallitpanel.setBorder(new TitledBorder("Beállítás"));
        
        JPanel bejelentkezpanel = new JPanel();
        bejelentkezpanel.add(pinpanel);
        bejelentkezpanel.add(beallitpanel);
       
        JPanel jatekpanel = new JPanel();
        //jatekpanel
        
        /*Oldalak*/
        JTabbedPane oldalak = new JTabbedPane();
        oldalak.addTab("Bejelentkezés", bejelentkezpanel);
        oldalak.addTab("Játék", jatekpanel);
        
        frame.add(oldalak);
        
        
        
        frame.setVisible(true);
    }

    private void ujJatek() {
    }
    
    
    
}
