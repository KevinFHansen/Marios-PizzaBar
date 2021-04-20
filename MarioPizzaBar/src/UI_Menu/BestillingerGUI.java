package UI_Menu;

import bestillingssystem.Ordre;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BestillingerGUI {

    public void opdaterVindue(ArrayList<Ordre> bestillinger) {
        String[] overskrifter = {"Afhentningstidspunkt", "Navn", "Pizza", "Kommentar"};

        // tabel data
        String [][] bestillingerTilTabel = new String[3][4];

        for(int i = 0; i < bestillinger.size(); i++){
            bestillingerTilTabel[i][0] = bestillinger.get(i).ordreStreng()[0];
            bestillingerTilTabel[i][1] = bestillinger.get(i).ordreStreng()[1];
            bestillingerTilTabel[i][2] = bestillinger.get(i).ordreStreng()[2];
            bestillingerTilTabel[i][3] = bestillinger.get(i).ordreStreng()[3];
        }

        JTable tabel = new JTable(bestillingerTilTabel, overskrifter);
        tabel.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(tabel);

        JFrame ramme = new JFrame("Bestillinger");
        ramme.add(sp);
        ramme.setSize(600, 300);
        ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ramme.dispatchEvent(new WindowEvent(ramme, WindowEvent.WINDOW_CLOSING));
        ramme.setVisible(true);

    }
}
