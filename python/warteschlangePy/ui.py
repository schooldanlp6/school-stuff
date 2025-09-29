# -*- coding: utf-8 -*-
# THIS FILE HAS BEEN MODDED
################################################################################
## Form generated from reading UI file 'windowXoeKXR.ui'
##
## Created by: Qt User Interface Compiler version 6.8.2
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PyQt6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PyQt6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PyQt6.QtWidgets import (QApplication, QHBoxLayout, QMainWindow, QMenuBar,
    QSizePolicy, QStatusBar, QLineEdit, QToolButton, QVBoxLayout, QWidget, QTextBrowser)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(800, 600)
#        MainWindow.setWindowTitle("Eww")
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.horizontalLayoutWidget = QWidget(self.centralwidget)
        self.horizontalLayoutWidget.setObjectName(u"horizontalLayoutWidget")
        self.horizontalLayoutWidget.setGeometry(QRect(10, 10, 441, 302))
        self.horizontalLayout = QHBoxLayout(self.horizontalLayoutWidget)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.horizontalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")

        self.horizontalLayout.addLayout(self.horizontalLayout_2)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        
        # Replacing QTextEdit with QLineEdit and setting placeholder text
        self.lineEdit = QLineEdit(self.horizontalLayoutWidget)
        self.lineEdit.setObjectName(u"lineEdit")
        self.lineEdit.setPlaceholderText(QCoreApplication.translate("MainWindow", u"Input Liedname", None))
        
        self.verticalLayout.addWidget(self.lineEdit)

        self.lineEdit_2 = QLineEdit(self.horizontalLayoutWidget)
        self.lineEdit_2.setObjectName(u"lineEdit_2")
        self.lineEdit_2.setPlaceholderText(QCoreApplication.translate("MainWindow", u"Input Artist", None))
        
        self.verticalLayout.addWidget(self.lineEdit_2)

        self.lineEdit_3 = QLineEdit(self.horizontalLayoutWidget)
        self.lineEdit_3.setObjectName(u"lineEdit_3")
        self.lineEdit_3.setPlaceholderText(QCoreApplication.translate("MainWindow", u"Input Länge", None))
        
        self.verticalLayout.addWidget(self.lineEdit_3)

        self.lineEdit_4 = QLineEdit(self.horizontalLayoutWidget)
        self.lineEdit_4.setObjectName(u"lineEdit_4")
        self.lineEdit_4.setPlaceholderText(QCoreApplication.translate("MainWindow", u"Input mp3data", None))
        
        self.verticalLayout.addWidget(self.lineEdit_4)

        self.horizontalLayout.addLayout(self.verticalLayout)

        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.toolButton = QToolButton(self.horizontalLayoutWidget)
        self.toolButton.setObjectName(u"toolButton")

        self.verticalLayout_2.addWidget(self.toolButton)

        self.toolButton_2 = QToolButton(self.horizontalLayoutWidget)
        self.toolButton_2.setObjectName(u"toolButton_2")

        self.verticalLayout_2.addWidget(self.toolButton_2)

        self.toolButton_4 = QToolButton(self.horizontalLayoutWidget)
        self.toolButton_4.setObjectName(u"toolButton_4")

        self.verticalLayout_2.addWidget(self.toolButton_4)

        self.horizontalLayout.addLayout(self.verticalLayout_2)

        self.horizontalLayoutWidget_3 = QWidget(self.centralwidget)
        self.horizontalLayoutWidget_3.setObjectName(u"horizontalLayoutWidget_3")
        self.horizontalLayoutWidget_3.setGeometry(QRect(20, 320, 411, 191))
        self.horizontalLayout_3 = QHBoxLayout(self.horizontalLayoutWidget_3)
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.horizontalLayout_3.setContentsMargins(0, 0, 0, 0)
        self.textBrowser = QTextBrowser(self.horizontalLayoutWidget_3)
        self.textBrowser.setObjectName(u"textBrowser")

        self.horizontalLayout_3.addWidget(self.textBrowser)

        self.toolButton_3 = QToolButton(self.horizontalLayoutWidget_3)
        self.toolButton_3.setObjectName(u"toolButton_3")

        self.horizontalLayout_3.addWidget(self.toolButton_3)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 800, 23))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"Lied GUI", None))
        self.toolButton.setText(QCoreApplication.translate("MainWindow", u"Lied Hinzuf\u00fcgen", None))
        self.toolButton_2.setText(QCoreApplication.translate("MainWindow", u"N\u00e4chstes Lied", None))
        self.toolButton_4.setText(QCoreApplication.translate("MainWindow", u"Warteschlange Leeren", None))
        self.toolButton_3.setText(QCoreApplication.translate("MainWindow", u"Warteschlange Zeigen", None))
    # retranslateUi