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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
    private JCheckBox kever;
    private JPanel pinpanel;
    private JPanel beallitpanel;
    private JPanel amobapanel;
    private JPanel jatekpanel;
    private JButton gomb0, gomb1, gomb2, gomb3, gomb4, gomb5, gomb6, gomb7, gomb8, gomb9;
    private JTextField kodhely;
    private JPanel jatekbeallitpanel;
    String kiiras = "";

    public GUIOOPDolgozat() {
        ini();
        PinGombok();
        BeallitasGombok();
    }

    private void ini() {
        /*A fő ablak*/
        frame = new JFrame("GUI-OOP Dolgozat 1.");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
        mnuprgujra.addActionListener(new MenuUjra());
        mnuprgkilep.addActionListener(new Kilepes());
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
        LayoutManager gomblayout = new GridLayout(3, 2);
        LayoutManager belayout = new GridLayout(1, 2);
        LayoutManager beallitlayout = new GridLayout(1, 3);
        

        /*Bejelentkezés oldal*/
        pinpanel = new JPanel(gomblayout);
        pinpanel.setBorder(new TitledBorder("Pin Kód"));
    

        beallitpanel = new JPanel(beallitlayout);
        beallitpanel.setBorder(new TitledBorder("Beállítás"));

        JPanel bejelentkezpanel = new JPanel(belayout);
        bejelentkezpanel.add(pinpanel);
        bejelentkezpanel.add(beallitpanel);

        /*jatek oldal*/
        amobapanel = new JPanel(gomblayout);
        amobapanel.setBorder(new TitledBorder("Amőba"));
        jatekbeallitpanel = new JPanel(beallitlayout);
        jatekbeallitpanel.setBorder(new TitledBorder("Beállítás"));

        jatekpanel = new JPanel(belayout);
        jatekpanel.add(amobapanel);
        jatekpanel.add(jatekbeallitpanel);

        /*Oldalak*/
        JTabbedPane oldalak = new JTabbedPane();
        oldalak.addTab("Bejelentkezés", bejelentkezpanel);
        oldalak.addTab("Játék", jatekpanel);
        frame.getContentPane().add(oldalak);

        /*Bejelentkezés oldal funkciok*/
        frame.addWindowListener(new FormWindowAdapter());

        frame.setVisible(true);
    }

    private void PinGombok() {
        gomb0 = new JButton("0");
        gomb1 = new JButton("1");
        gomb2 = new JButton("2");
        gomb3 = new JButton("3");
        gomb4 = new JButton("4");
        gomb5 = new JButton("5");
        gomb6 = new JButton("6");
        gomb7 = new JButton("7");
        gomb8 = new JButton("8");
        gomb9 = new JButton("9");

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
    }

    private void BeallitasGombok() {
        kever = new JCheckBox("Kever");
        kever.addActionListener(new KeverListener());
        JLabel kod = new JLabel("kód:");
        kodhely = new JTextField();
        kodhely.enableInputMethods(false);

        beallitpanel.add(kever);
        beallitpanel.add(kod);
        beallitpanel.add(kodhely);

        /*Amoba oldal*/
        JButton amoba1 = new JButton();
        JButton amoba2 = new JButton();
        JButton amoba3 = new JButton();
        JButton amoba4 = new JButton();
        JButton amoba5 = new JButton();
        JButton amoba6 = new JButton();
        JButton amoba7 = new JButton();
        JButton amoba8 = new JButton();
        JButton amoba9 = new JButton();

        amobapanel.add(amoba1);
        amobapanel.add(amoba2);
        amobapanel.add(amoba3);
        amobapanel.add(amoba4);
        amobapanel.add(amoba5);
        amobapanel.add(amoba6);
        amobapanel.add(amoba7);
        amobapanel.add(amoba8);
        amobapanel.add(amoba9);

        String[] listaelem = {"3x3", "4x4", "5x5"};
        JList list = new JList(listaelem);
        JScrollPane scroll = new JScrollPane(list);
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton();
        JRadioButton radio2 = new JRadioButton();
        radioGroup.add(radio1);
        radio1.setText("X kezd");
        radioGroup.add(radio2);
        radio2.setText("O kezd");

        
        jatekbeallitpanel.add(scroll);
        jatekbeallitpanel.add(radio1);
        jatekbeallitpanel.add(radio2);
    }


class KeverListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (kever.isSelected()) {
            ArrayList<Integer> checkbox = new ArrayList<>();
            for (int i = 0; i < Bejelent_Gombok; i++) {
                checkbox.add(i);
            }
            Collections.shuffle(checkbox);
            gombok[checkbox.get(0)] = gomb1;
            gombok[checkbox.get(1)] = gomb2;
            gombok[checkbox.get(2)] = gomb3;
            gombok[checkbox.get(3)] = gomb4;
            gombok[checkbox.get(4)] = gomb5;
            gombok[checkbox.get(5)] = gomb6;
            gombok[checkbox.get(6)] = gomb7;
            gombok[checkbox.get(7)] = gomb8;
            gombok[checkbox.get(8)] = gomb9;
            gombok[checkbox.get(9)] = gomb0;

            for (JButton g : gombok) {
                pinpanel.add(g);
            }
           frame.validate();
        } else if (!(kever.isSelected())) {
            for (JButton g : gombok) {
                pinpanel.remove(g);
                
            }
            PinGombok();
        }
    }

}

class MenuUjra implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ujJatek();
    }

    private void ujJatek() {
        kodhely.setText("");
        pinpanel.removeAll();
        kever.setSelected(false);
        frame.validate();
        PinGombok();
    }
}

class PinActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton gomb = (JButton) e.getSource();
        String felirat = gomb.getActionCommand();
        gomb.setBackground(Color.CYAN);
          kiiras += felirat;
          kodhely.setText(kiiras);
           
    }

}

class FormWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        kilep();
    } 

}

class Kilepes implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        kilep();
    }
}

private void kilep() {
        int valasz = JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
        if (valasz == JOptionPane.YES_OPTION) {
            System.exit(valasz);
        }
    }
}