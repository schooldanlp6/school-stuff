
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QVBoxLayout, QLineEdit, QListWidget

app = QApplication([])

window = QWidget()
window.setWindowTitle('Layout Example')

layout = QVBoxLayout()

titel_input = QLineEdit()
titel_input.setPlaceholderText("Titel")

künstler_input = QLineEdit()
künstler_input.setPlaceholderText("Künstler")

datum_input = QLineEdit()
datum_input.setPlaceholderText("Datum")

knoten_hinzufügen_btn = QPushButton('Knoten hinzufügen')

list_widget = QListWidget()

layout.addWidget(titel_input)
layout.addWidget(künstler_input)
layout.addWidget(datum_input)
layout.addWidget(knoten_hinzufügen_btn)
layout.addWidget(list_widget)

window.setLayout(layout)

window.show()

class Warteschlange:
    def __init__(self):
        self.anfang = None
        self.ende = None
        knoten_hinzufügen_btn.clicked.connect(lambda: self.einfuegen(Knoten(daten={
        "Titel": titel_input.text(),
        "Künstler": künstler_input.text(),
        "Datum": datum_input.text()
        })))
    def einfuegen(self, knoten):
        list_widget.addItem(str(knoten.daten_geben()))
        if not (self.anfang or self.ende):
            self.anfang = knoten
            return
        self.ende = knoten
        self.ende.nachfolger_setzen(knoten)
    def naechster_knoten(self):
        self.anfang = self.anfang.nachfolger_geben()
    def information_ausgeben(self):
        print(self.anfang, self.ende)

    class Knoten:
        def __init__(self, daten):
            self.nachfolger = None
            self.daten = daten
        def daten_geben(self):
            return self.daten
        def nachfolger_geben(self):
            return self.nachfolger
        def nachfolger_setzen(self, knoten):
            self.nachfolger = knoten
        def information_ausgeben(self):
            print(self.nachfolger, self.daten)

    class Daten:
        def __init__(self, inhalt):
            self.inhalt = inhalt
        def information_ausgeben(self):
            print(self.inhalt)

w1 = Warteschlange()

app.exec()