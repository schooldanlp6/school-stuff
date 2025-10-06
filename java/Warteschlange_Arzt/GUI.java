import java.awt.*;
import java.awt.event.*;

// Datenelement.java
interface Datenelement {
    String toString();
}

// Patient.java
class Patient implements Datenelement {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Knoten.java
class Knoten {
    private Datenelement daten;
    private Knoten nachfolger;

    public Knoten(Datenelement daten) {
        this.daten = daten;
        this.nachfolger = null;
    }

    public void HintenEinfügen(Datenelement neu) {
        if (nachfolger == null) {
            nachfolger = new Knoten(neu);
        } else {
            nachfolger.HintenEinfügen(neu);
        }
    }

    public Knoten NachfolgerGeben() {
        return nachfolger;
    }

    public Datenelement DatenelementGeben() {
        return daten;
    }

    public int LaengeGeben() {
        if (nachfolger == null) return 1;
        return 1 + nachfolger.LaengeGeben();
    }

    public void InformationAusgeben() {
        System.out.println(daten);
        if (nachfolger != null) nachfolger.InformationAusgeben();
    }
}

// Warteschlange.java
class Warteschlange {
    private Knoten anfang;

    Warteschlange() {
        anfang = null;
    }

    void HintenEinfügen(Datenelement dneu) {
        if (anfang != null) {
            anfang.HintenEinfügen(dneu);
        } else {
            anfang = new Knoten(dneu);
        }
    }

    Datenelement Entfernen() {
        if (anfang == null) {
            return null;
        }
        Datenelement d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;
    }

    int WartschlangenLaengeGeben() {
        return (anfang != null) ? anfang.LaengeGeben() : 0;
    }

    void InformationAusgeben() {
        if (anfang != null) {
            anfang.InformationAusgeben();
        }
    }
}

// GUI.java
public class GUI extends Frame {

    private Warteschlange warteschlange;
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
        label.setFont(scaledFont);
        TextField eingabeFeld = new TextField((int)(20 * scale));
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

        eingabePanel.add(label);
        eingabePanel.add(eingabeFeld);
        eingabePanel.add(hinzufuegenButton);
        eingabePanel.add(entfernenButton);
        eingabePanel.add(anzeigenButton);
        eingabePanel.add(anzeigenKnoten);
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

        anzeigenKnoten.addActionListener(e -> {
            ausgabeBereich.append("Patienten: "+ warteschlange.DatenelementGeben(warteschlange.KnotenGeben));
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