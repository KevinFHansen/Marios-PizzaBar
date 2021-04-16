package UI_Menu;

import Menukort_Pizza.Pizza;
import bestillingssystem.Ordre;

import javax.swing.*;
import java.io.FileNotFoundException;

public class BestillingerGUI {

    public void bestillingsVindu(String bestillinger) {

        JFrame ramme = new JFrame("Bestillinger");
        JPanel panel = new JPanel();
        ramme.setSize(600, 300);
        ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramme.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel(bestillinger);
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        ramme.setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BestillingerGUI gui = new BestillingerGUI();
        Ordre nyOrdre = new Ordre();

        Ordre ordreTilBestilling = nyOrdre.opretOrdre();


        gui.bestillingsVindu(ordreTilBestilling.toString());
    }

}
