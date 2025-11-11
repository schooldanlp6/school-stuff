import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BahnhofGUI extends JFrame {
    private Gleis[] gleise = new Gleis[3];
    private ArrayList<Datenelement>[] gleisListen = new ArrayList[3];
    private JTextArea[] gleisAnzeige = new JTextArea[3];
    private JTextField eingabeFeld;
    private JComboBox<String> gleisAuswahl;

    public BahnhofGUI() {
        setTitle("Bahnhof – Gleisverwaltung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        for (int i = 0; i < 3; i++) {
            gleise[i] = new Gleis();
            gleisListen[i] = new ArrayList<>();
        }

        JPanel eingabePanel = new JPanel(new FlowLayout());
        eingabeFeld = new JTextField(10);
        gleisAuswahl = new JComboBox<>(new String[]{"Gleis 1", "Gleis 2", "Gleis 3"});
        JButton addButton = new JButton("Waggon hinzufügen");
        JButton removeButton = new JButton("Waggon entfernen");

        eingabePanel.add(new JLabel("Waggon:"));
        eingabePanel.add(eingabeFeld);
        eingabePanel.add(gleisAuswahl);
        eingabePanel.add(addButton);
        eingabePanel.add(removeButton);

        add(eingabePanel, BorderLayout.NORTH);

        JPanel gleisPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel("Gleis " + (i + 1), SwingConstants.CENTER), BorderLayout.NORTH);
            gleisAnzeige[i] = new JTextArea();
            gleisAnzeige[i].setEditable(false);
            gleisAnzeige[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            panel.add(new JScrollPane(gleisAnzeige[i]), BorderLayout.CENTER);
            gleisPanel.add(panel);
        }

        add(gleisPanel, BorderLayout.CENTER);

        addButton.addActionListener(e -> waggonHinzufuegen());
        removeButton.addActionListener(e -> waggonEntfernen());
    }

    private void waggonHinzufuegen() {
        String name = eingabeFeld.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte einen Waggon-Namen eingeben.");
            return;
        }

        int index = gleisAuswahl.getSelectedIndex();
        Datenelement d = new Wagon(name);

        gleise[index].Einfuegen(d);
        gleisListen[index].add(0, d);
        eingabeFeld.setText("");
        aktualisiereAnzeige();
    }

    private void waggonEntfernen() {
        int index = gleisAuswahl.getSelectedIndex();
        Datenelement entfernt = gleise[index].Entfernen();

        if (entfernt == null) {
            JOptionPane.showMessageDialog(this, "Dieses Gleis ist leer!");
        } else if (!gleisListen[index].isEmpty()) {
            gleisListen[index].remove(0);
        }

        aktualisiereAnzeige();
    }

    private void aktualisiereAnzeige() {
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            for (Datenelement d : gleisListen[i]) {
                sb.append(d.NameGeben()).append("\n");
            }
            gleisAnzeige[i].setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BahnhofGUI().setVisible(true));
    }
}
