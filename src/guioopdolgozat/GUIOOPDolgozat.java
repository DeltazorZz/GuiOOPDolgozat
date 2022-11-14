package guioopdolgozat;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
        frame = new JFrame("GUI-OOP Dolgozat 1.");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-150, kep.height/2-125, 410, 350);
        
        
        
        
        
        
        
        frame.setVisible(true);
    }

    private void ujJatek() {
    }
    
    
    
}
