package UI_Menu;

import bestillingssystem.Ordre;
import javax.swing.*;
import java.util.ArrayList;

public class BestillingerGUI {
    private JTable tabel = new JTable();

    public JTable getTabel() {
        return tabel;
    }
    public void setTabel(JTable tabel) {
        this.tabel = tabel;
    }

    public void opretVindue(ArrayList<Ordre> bestillinger) {
        String[] overskrifter = {"Afhentningstidspunkt", "Navn", "Pizza", "Kommentar"};

        // tabel data
        String [][] bestillingerTilTabel = new String[5][4];

        for(int i = 0; i < bestillinger.size(); i++){
            bestillingerTilTabel[i][0] = bestillinger.get(i).ordreStreng()[0];
            bestillingerTilTabel[i][1] = bestillinger.get(i).ordreStreng()[1];
            bestillingerTilTabel[i][2] = bestillinger.get(i).ordreStreng()[2];
            bestillingerTilTabel[i][3] = bestillinger.get(i).ordreStreng()[3];
        }

        tabel = new JTable(bestillingerTilTabel, overskrifter);

        setTabel(tabel);

        tabel.setBounds(30, 40, 300, 200);
        //tabel.doLayout();
        //tabel.setRowHeight(40);

        JScrollPane sp = new JScrollPane(tabel);

        JFrame ramme = new JFrame("Bestillinger");
        ramme.add(sp);
        ramme.setSize(600, 300);

        ramme.setVisible(true);

    }

    public void opdaterVindue(ArrayList<Ordre> bestillinger, JTable tabel){

        for(int i = 0; i < bestillinger.size(); i++){
            tabel.setValueAt(bestillinger.get(i).ordreStreng()[0], i, 0);
            tabel.setValueAt(bestillinger.get(i).ordreStreng()[1], i, 1);
            tabel.setValueAt(bestillinger.get(i).ordreStreng()[2], i, 2);
            tabel.setValueAt(bestillinger.get(i).ordreStreng()[3], i, 3);
        }
        for(int i = bestillinger.size(); i < 5; i++){
            tabel.setValueAt(null, i, 0);
            tabel.setValueAt(null, i, 1);
            tabel.setValueAt(null, i, 2);
            tabel.setValueAt(null, i, 3);
        }
    }
}
