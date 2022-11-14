package guioopdolgozat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class GUIOOPDolgozat {

    public static void main(String[] args) {
        new GUIOOPDolgozat();
    }
    private static final int Bejelent_Gombok = 10;

    private JFrame frame;
    private JButton[] gombok;

    public GUIOOPDolgozat() {
        ini();
    }

    private void ini() {
        /*A fő ablak*/
        frame = new JFrame("GUI-OOP Dolgozat 1.");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width / 2 - 150, kep.height / 2 - 125, 410, 350);

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

        /*Tartalom*/
 /*Layout managers*/
        LayoutManager gomblayout = new GridLayout(3, 3);
        LayoutManager belayout = new GridLayout(1, 2);
        LayoutManager beallitlayout = new GridLayout(1, 1);

        /*Bejelentkezés oldal*/
        JPanel pinpanel = new JPanel(gomblayout);
        pinpanel.setBorder(new TitledBorder("Pin Kód"));

        JPanel beallitpanel = new JPanel();
        beallitpanel.setBorder(new TitledBorder("Beállítás"));

        JPanel bejelentkezpanel = new JPanel(belayout);
        bejelentkezpanel.add(pinpanel);
        bejelentkezpanel.add(beallitpanel);

        /*jatek oldal*/
        JPanel amobapanel = new JPanel();
        amobapanel.setBorder(new TitledBorder("Amőba"));
        JPanel jatekbeallitpanel = new JPanel();
        jatekbeallitpanel.setBorder(new TitledBorder("Beállítás"));

        JPanel jatekpanel = new JPanel();
        jatekpanel.add(amobapanel);
        jatekpanel.add(jatekbeallitpanel);

        /*Oldalak*/
        JTabbedPane oldalak = new JTabbedPane();
        oldalak.addTab("Bejelentkezés", bejelentkezpanel);
        oldalak.addTab("Játék", jatekpanel);
        frame.add(oldalak);

        /*Bejelentkezés oldal funkciok*/
        //Pin kód Gombok
        JButton gomb0 = new JButton("0");
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        JButton gomb4 = new JButton("4");
        JButton gomb5 = new JButton("5");
        JButton gomb6 = new JButton("6");
        JButton gomb7 = new JButton("7");
        JButton gomb8 = new JButton("8");
        JButton gomb9 = new JButton("9");

        pinpanel.add(gomb1);
        pinpanel.add(gomb2);
        pinpanel.add(gomb3);
        pinpanel.add(gomb4);
        pinpanel.add(gomb5);
        pinpanel.add(gomb6);
        pinpanel.add(gomb7);
        pinpanel.add(gomb8);
        pinpanel.add(gomb9);
        pinpanel.add(gomb0);

        gomb0.addActionListener(new PinActionListener());
        gomb1.addActionListener(new PinActionListener());
        gomb2.addActionListener(new PinActionListener());
        gomb3.addActionListener(new PinActionListener());
        gomb4.addActionListener(new PinActionListener());
        gomb5.addActionListener(new PinActionListener());
        gomb6.addActionListener(new PinActionListener());
        gomb7.addActionListener(new PinActionListener());
        gomb8.addActionListener(new PinActionListener());
        gomb9.addActionListener(new PinActionListener());

        gombok = new JButton[Bejelent_Gombok];
        gombok[0] = gomb1;
        gombok[1] = gomb2;
        gombok[2] = gomb3;
        gombok[3] = gomb4;
        gombok[4] = gomb5;
        gombok[5] = gomb6;
        gombok[6] = gomb7;
        gombok[7] = gomb8;
        gombok[8] = gomb9;
        gombok[9] = gomb0;

        /*Beallitas*/
        JCheckBox kever = new JCheckBox();
        JLabel kod = new JLabel("kód:");
        JTextField kodhely = new JTextField();
        kodhely.enableInputMethods(false);

        frame.setVisible(true);
    }

    class PinActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton gomb = (JButton)e.getSource();
            String felirat = gomb.getActionCommand();
            String eredmeny = null;
            for (int i = 0; i < gombok.length; i++) {
                eredmeny = String.valueOf(gombok[i]);
            }
            
            if (eredmeny == null ? felirat == null : eredmeny.equals(felirat)) {
                gomb.setBackground(Color.CYAN);
            }
            
            
        }

    }
}
