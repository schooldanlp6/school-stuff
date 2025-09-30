import ui
import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton
#import vlc

#media = vlc.MediaPlayer("oml/Track1.mp3")
#media.play()

class Warteschlange():
    def __init__(self, anfKnoten, endKnoten):
        self.anfKnoten = anfKnoten;
        self.endKnoten = endKnoten;
    def einfuegen(k):
        if(self.anfKnoten==null):
            self.anfKnoten=endKnoten=k
            print(k.id)
        else:
            endKnoten.nachfolgerSetzten(k)
            endKnoten=k
            print(k.id)

    def entfernen():
        if(anfKnoten==endKnoten):
            anfKnoten = endKnoten = null
        else:
            if(anfKnoten==null):
                anfKnoten=null
                endKnoten=null
                print("Empty...")
            else:
                anfKnoten=anfKnoten.nachfolger
    
    def ausgabe():
        pass

class Knoten():
    def __init__(self, l, n, i):
        self.nachfolger = n
        self.lied = l
        self.id = i
    
    def Liedsetzen(l):
        self.lied = l

    def nachfolgerSetzten(n):
        self.nachfolger = n

class Lied():
    def __init__(self, titel, interpret, laenge, mp3data, id):
        self.titel = titel
        self.interpret = interpret
        self.laenge = laenge
        self.mp3data = mp3data
        self.id = id


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.ui = ui.Ui_MainWindow()  # Create an instance of the UI class
        self.ui.setupUi(self)  # Set up the UI in the main window
        # Connect Play/Stop button signal to the slot
#still needs fixes:
#        self.ui.toolButton.clicked.connect(Knoten())
#        self.ui.toolButton_2.clicked.connect(self.nextSong)
        self.ui.toolButton_2.clicked.connect(Warteschlange.entfernen())
#        self.ui.toolButton_3.clicked.connect(self.showQueue)
        self.ui.toolButton_3.clicked.connect(Warteschlange.ausgabe())
        self.ui.toolButton_4.clicked.connect(self.clearQueue)
        self.ui.playStopButton.clicked.connect(self.togglePlayStop)
    
    def toggle_play_stop(self):
        """This method will be called when the Play/Stop button is clicked."""
        if self.ui.playStopButton.text() == "Play":
            self.ui.playStopButton.setText("Stop")
            print("Playing the song..." + Warteschlange.anfKnoten)
        else:
            self.ui.playStopButton.setText("Play")
            print("Stopping the song...")

if __name__ == "__main__":
    app = QApplication(sys.argv)  # Initialize the application
    window = MainWindow()  # Create the MainWindow instance
    window.show()  # Show the window
    sys.exit(app.exec())  # Run the event loop
loop