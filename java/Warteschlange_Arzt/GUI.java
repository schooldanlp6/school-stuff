import java.awt.*;
import java.awt.event.*;

// GUI.java
public class GUI extends Frame {

    private Warteschlange warteschlange = new Warteschlange();
    private double scale = 1.5; // Skalierungsfaktor, 1.5 = 150%
    private Font scaledFont;

    public GUI() {
        super("Patient GUI");
        warteschlange = new Warteschlange();

        scaledFont = new Font("Arial", Font.PLAIN, (int)(14 * scale));

        setLayout(new BorderLayout());

        // Eingabezeile
        Panel eingabePanel = new Panel(new FlowLayout());
        Label label = new Label("Patient:");
        Label Suche = new Label("Suche:");
        label.setFont(scaledFont);
        TextField eingabeFeld = new TextField((int)(20 * scale));
        TextField suchFeld = new TextField((int)(20 * scale));
        eingabeFeld.setFont(scaledFont);

        Button hinzufuegenButton = new Button("Hinzufügen");
        hinzufuegenButton.setFont(scaledFont);
        hinzufuegenButton.setPreferredSize(new Dimension((int)(120 * scale), (int)(40 * scale)));

        Button entfernenButton = new Button("Entfernen");
        entfernenButton.setFont(scaledFont);
        entfernenButton.setPreferredSize(new Dimension((int)(120 * scale), (int)(40 * scale)));

        Button anzeigenButton = new Button("Anzeigen");
        anzeigenButton.setFont(scaledFont);
        anzeigenButton.setPreferredSize(new Dimension((int)(120 * scale), (int)(40 * scale)));

        Button anzeigenKnoten = new Button("Patienten Anzeigen");
        anzeigenKnoten.setFont(scaledFont);
        anzeigenKnoten.setPreferredSize(new Dimension((int)(120 * scale), (int)(40 * scale)));

        Button sucheButton = new Button("Suchen und Aufrufen");
        anzeigenKnoten.setFont(scaledFont);
        anzeigenKnoten.setPreferredSize(new Dimension((int)(120 * scale), (int)(40 * scale)));

        //Main func
        eingabePanel.add(label);
        eingabePanel.add(eingabeFeld);
        eingabePanel.add(hinzufuegenButton);
        eingabePanel.add(entfernenButton);
        eingabePanel.add(anzeigenButton);
        eingabePanel.add(anzeigenKnoten);
        //Suche
        eingabePanel.add(Suche);
        eingabePanel.add(suchFeld);
        eingabePanel.add(sucheButton);
        //init
        add(eingabePanel, BorderLayout.NORTH);

        // Ausgabe-Bereich
        TextArea ausgabeBereich = new TextArea(15, (int)(50 * scale));
        ausgabeBereich.setFont(scaledFont);
        ausgabeBereich.setEditable(false);
        add(ausgabeBereich, BorderLayout.CENTER);

        // Button-Events
        hinzufuegenButton.addActionListener(e -> {
            String name = eingabeFeld.getText().trim();
            if (!name.isEmpty()) {
                warteschlange.HintenEinfügen(new Patient(name));
                ausgabeBereich.append("Hinzugefügt: " + name + "\n");
                eingabeFeld.setText("");
            }
        });

        entfernenButton.addActionListener(e -> {
            Datenelement d = warteschlange.Entfernen();
            if (d != null) {
                ausgabeBereich.append("Entfernt: " + d + "\n");
            } else {
                ausgabeBereich.append("Warteschlange ist leer!\n");
            }
        });

        anzeigenButton.addActionListener(e -> {
            ausgabeBereich.append("Aktuelle Länge: " + warteschlange.WartschlangenLaengeGeben() + "\n");
            warteschlange.InformationAusgeben();
        });

        //anzeigenKnoten.addActionListener(e -> {
        //    ausgabeBereich.append("Patienten: "+ warteschlange.DatenelementGeben(warteschlange.KnotenGeben));
        //});

        sucheButton.addActionListener(e -> {
            String suchName = suchFeld.getText().trim();
            if (!suchName.isEmpty()) {
                // Call PatientAufrufen to search and remove patient
                warteschlange.PatientAufrufen(suchName);
                ausgabeBereich.append("Patient " + suchName + " wurde aufgerufen und entfernt (falls gefunden).\n");
                suchFeld.setText(""); // Clear the search field
            } else {
                ausgabeBereich.append("Bitte einen Namen eingeben.\n");
            }
        });


        // Fenster schließen
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setSize((int)(800 * scale), (int)(600 * scale));
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}