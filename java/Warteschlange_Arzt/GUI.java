import java.awt.*;
import java.awt.event.*;

class GUI extends Frame {

    private Warteschlange warteschlange;
    private TextField eingabeFeld;
    private TextArea ausgabeBereich;
    private Button hinzufuegenButton, entfernenButton, anzeigenButton;

    public GUI() {
        super("Warteschlange GUI");

        warteschlange = new Warteschlange();

        // Layout
        setLayout(new BorderLayout());

        // Eingabezeile
        Panel eingabePanel = new Panel(new FlowLayout());
        eingabeFeld = new TextField(20);
        hinzufuegenButton = new Button("Hinzufügen");
        entfernenButton = new Button("Entfernen");
        anzeigenButton = new Button("Anzeigen");

        eingabePanel.add(new Label("Patient:"));
        eingabePanel.add(eingabeFeld);
        eingabePanel.add(hinzufuegenButton);
        eingabePanel.add(entfernenButton);
        eingabePanel.add(anzeigenButton);

        add(eingabePanel, BorderLayout.NORTH);

        // Ausgabe-Bereich
        ausgabeBereich = new TextArea(15, 50);
        ausgabeBereich.setEditable(false);
        add(ausgabeBereich, BorderLayout.CENTER);

        // Button-Events
        hinzufuegenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = eingabeFeld.getText().trim();
                if (!name.isEmpty()) {
                    warteschlange.HintenEinfügen(new Patient(name));
                    ausgabeBereich.append("Hinzugefügt: " + name + "\n");
                    eingabeFeld.setText("");
                }
            }
        });

        entfernenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Datenelement d = warteschlange.Entfernen();
                if (d != null) {
                    ausgabeBereich.append("Entfernt: " + d + "\n");
                } else {
                    ausgabeBereich.append("Warteschlange ist leer!\n");
                }
            }
        });

        anzeigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ausgabeBereich.append("Aktuelle Länge: " + warteschlange.WartschlangenLaengeGeben() + "\n");
                warteschlange.InformationAusgeben();
            }
        });

        // Fenster schließen
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}