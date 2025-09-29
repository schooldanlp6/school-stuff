import ui
import sys
from PyQt6.QtWidgets import QApplication, QMainWindow

class Warteschlange():
    def __init__(self):
        pass

class Knoten():
    def __init__(self):
        pass

class Lied():

    def __init__(self):
        pass 


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.ui = ui.Ui_MainWindow()  # Create an instance of the UI class
        self.ui.setupUi(self)  # Set up the UI in the main window

if __name__ == "__main__":
    app = QApplication(sys.argv)  # Initialize the application
    window = MainWindow()  # Create the MainWindow instance
    window.show()  # Show the window
    sys.exit(app.exec())  # Run the event loop