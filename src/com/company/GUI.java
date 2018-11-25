package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GUI {

    // Core elements
    JFrame jFrame = new JFrame("Fräck applikationstitel här...");

    final JLabel instructionLabel = new JLabel("Välj vad du vill göra");
    JButton createCarMenuButton = new JButton("Skapa bil");
    final JLabel currentCommandLabel = new JLabel("");
    JSeparator separator = new JSeparator();
    final JLabel creationStatus = new JLabel("testing testing");

    // Car elements
    final JLabel carBrandLabel = new JLabel("Ange bilmärke");
    final JLabel carRegLabel = new JLabel("Ange registreringsnummer");
    final JTextField carBrand = new JTextField();
    final JTextField carRegNo = new JTextField();
    JButton createCarButton = new JButton("Skapa bil");

    // Book elements
    JButton createBookMenuButton = new JButton("Skapa bok");

    final JLabel bookTitleLabel = new JLabel("Boktitel");
    final JTextField bookTitle = new JTextField();

    final JLabel bookAuthorNameLabel = new JLabel("Författarens förnamn");
    final JTextField bookAuthorName = new JTextField();

    final JLabel bookAuthorSurnameLabel = new JLabel("Författarens efternamn");
    final JTextField bookAuthorSurname = new JTextField();
    JButton createBookButton = new JButton("Skapa bok");

    // Person elements
    final JLabel personNameLabel = new JLabel("Namn");
    final JTextField personName = new JTextField();

    final JLabel personSurnameLabel = new JLabel("Efternamn");
    final JTextField personSurname = new JTextField();

    final JLabel personPhoneNumberLabel = new JLabel("Telefonnummer");
    final JTextField personPhoneNumber = new JTextField();
    JButton createPersonButton = new JButton("Skapa person");

    JButton createPersonMenuButton = new JButton("Skapa person");

    //View Cars elements
    JButton viewCarsMenuButton = new JButton("Hantera bilar");
    JTable carTable = new JTable(new DefaultTableModel(new Object[]{"Id", "Bilmärke", "Registreringsnummer", "Föremålstyp"}, 0));
    DefaultTableModel carModel = (DefaultTableModel) carTable.getModel();
    JScrollPane carScrollPane = new JScrollPane(carTable);

    // Handle books elements
    JButton viewBooksMenuButton = new JButton("Hantera böcker");
    JTable bookTable = new JTable(new DefaultTableModel(new Object[]{"Id", "Boknamn", "Författare förnamn", "Författare efternamn", "Föremålstyp"}, 0));
    DefaultTableModel bookModel = (DefaultTableModel) bookTable.getModel();
    JScrollPane bookScrollPane = new JScrollPane(bookTable);

    // Handle persons elements
    JButton viewPersonsMenuButton = new JButton("Hantera personer");
    JTable personTable = new JTable(new DefaultTableModel(new Object[]{"Id", "Förnamn", "Efternamn", "Telefonnummer"}, 0));
    DefaultTableModel personModel = (DefaultTableModel) personTable.getModel();
    JScrollPane personScrollPane = new JScrollPane(personTable);


    public GUI() {
        // Setting JFrame settings
        jFrame.setSize(1024, 800);
        jFrame.setLayout(null);

//////////////////////////////////////////

        // ******* Car specific ********
        // Menubutton: Create Car position
        createCarMenuButton.setBounds(10, 50, 90, 20);
        createCarMenuButton.addActionListener(new ActionListener() { // OBS: anonym inre klass!
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Skapa bil");
                carBrandLabel.setVisible(true);
                carBrand.setVisible(true);
                carRegLabel.setVisible(true);
                carRegNo.setVisible(true);
                createCarButton.setVisible(true);
            }
        });

        // Car brand
        carBrandLabel.setBounds(10, 120, 80, 20);
        carBrand.setBounds(180, 122, 150, 20);

        // Car reg no
        carRegLabel.setBounds(10, 150, 160, 20);
        carRegNo.setBounds(180, 152, 60, 20);

        // createCarButton
        createCarButton.setBounds(10, 190, 90, 20);
        createCarButton.addActionListener(new ActionListener() { // OBS: anonym inre klass!
            public void actionPerformed(ActionEvent e) {
                if (Car.createCar(carBrand.getText(), carRegNo.getText())) {
                    creationStatus.setText("Bilen skapades.");
                    carBrand.setText("");
                    carRegNo.setText("");
                } else {
                    creationStatus.setText("Kunde inte skapa bilen. Kanske är den redan registrerad?");
                }
            }
        });


        // ******** Book specific ************
        bookTitleLabel.setBounds(10, 120, 80, 20);
        bookTitle.setBounds(180, 122, 150, 20);

        bookAuthorNameLabel.setBounds(10, 150, 160, 20);
        bookAuthorName.setBounds(180, 152, 150, 20);

        bookAuthorSurnameLabel.setBounds(10, 180, 160, 20);
        bookAuthorSurname.setBounds(180, 182, 150, 20);

        createBookMenuButton.setBounds(110, 50, 110, 20);
        createBookMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Skapa bok");
                bookTitleLabel.setVisible(true);
                bookTitle.setVisible(true);
                bookAuthorNameLabel.setVisible(true);
                bookAuthorName.setVisible(true);
                bookAuthorSurnameLabel.setVisible(true);
                bookAuthorSurname.setVisible(true);
                createBookButton.setVisible(true);
            }
        });

        createBookButton.setBounds(10, 220, 120, 20);
        createBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Book.createBook(bookTitle.getText(), bookAuthorName.getText(), bookAuthorSurname.getText())) {
                    creationStatus.setText("Boken skapades.");
                    bookTitle.setText("");
                    bookAuthorName.setText("");
                    bookAuthorSurname.setText("");
                } else {
                    creationStatus.setText("Kunde inte skapa boken. Kanske finns den redan registrerad?");
                }
            }
        });
        // ***** Create person **************
        createPersonMenuButton.setBounds(230, 50, 130, 20);
        createPersonMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Skapa person");
                personNameLabel.setVisible(true);
                personName.setVisible(true);
                personSurnameLabel.setVisible(true);
                personSurname.setVisible(true);
                personPhoneNumberLabel.setVisible(true);
                personPhoneNumber.setVisible(true);
                createPersonButton.setVisible(true);
            }
        });

        personNameLabel.setBounds(10, 120, 80, 20);
        personName.setBounds(180, 122, 150, 20);

        personSurnameLabel.setBounds(10, 150, 160, 20);
        personSurname.setBounds(180, 152, 150, 20);

        personPhoneNumberLabel.setBounds(10, 180, 160, 20);
        personPhoneNumber.setBounds(180, 182, 150, 20);

        createPersonButton.setBounds(10, 220, 120, 20);
        createPersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Person.createPerson(personName.getText(), personSurname.getText(), personPhoneNumber.getText())) {
                    creationStatus.setText("Personen lades till.");
                    personName.setText("");
                    personSurname.setText("");
                    personPhoneNumber.setText("");
                } else {
                    creationStatus.setText("Personen kunde inte läggas till. Kanske han / hon redan finns i registret?");
                }
            }
        });

        // Show Cars
        viewCarsMenuButton.setBounds(370, 50, 130, 20);
        carScrollPane.setBounds(10, 120, 800, 400);
        viewCarsMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Hantera bilar");
                getAllCars();
                carScrollPane.setVisible(true);
            }
        });

        // Show Books
        viewBooksMenuButton.setBounds(510, 50, 130, 20);
        bookScrollPane.setBounds(10, 120, 800, 400);
        viewBooksMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Hantera böcker");
                getAllBooks();
                bookScrollPane.setVisible(true);
            }
        });

        // Show persons
        viewPersonsMenuButton.setBounds(650, 50, 150, 20);
        personScrollPane.setBounds(10, 120, 800, 400);
        viewPersonsMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Hantera personer");
                getAllPersons();
                personScrollPane.setVisible(true);
            }
        });

        // ***** Shared
        // Current command label
        currentCommandLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        currentCommandLabel.setBounds(10, 100, 250, 15);


        // Instructionslabel
        instructionLabel.setBounds(10, 30, 250, 15);
        // creation status
        creationStatus.setBounds(10, 250, 300, 15);

        // Separator
        separator.setBounds(10, 90, 980, 20);


        // Adding objects
        jFrame.add(instructionLabel);
        jFrame.add(createCarMenuButton);
        jFrame.add(currentCommandLabel);
        jFrame.add(separator);

        // Cars
        jFrame.add(carBrandLabel);
        jFrame.add(carBrand);
        jFrame.add(carRegLabel);
        jFrame.add(createCarButton);
        jFrame.add(carRegNo);

        //book
        jFrame.add(createBookMenuButton);

        jFrame.add(bookTitleLabel);
        jFrame.add(bookTitle);

        jFrame.add(bookAuthorNameLabel);
        jFrame.add(bookAuthorName);

        jFrame.add(bookAuthorSurnameLabel);
        jFrame.add(bookAuthorSurname);
        jFrame.add(createBookButton);

        // person
        jFrame.add(personNameLabel);
        jFrame.add(personName);
        jFrame.add(personSurnameLabel);
        jFrame.add(personSurname);
        jFrame.add(personPhoneNumberLabel);
        jFrame.add(personPhoneNumber);
        jFrame.add(createPersonButton);
        jFrame.add(createPersonMenuButton);

        // View cars
        jFrame.add(viewCarsMenuButton);
        jFrame.add(carScrollPane);

        // View books
        jFrame.add(viewBooksMenuButton);
        jFrame.add(bookScrollPane);


        // View persons
        jFrame.add(viewPersonsMenuButton);
        jFrame.add(personScrollPane);

        // Common

        jFrame.add(creationStatus);


        jFrame.setVisible(true);
        hideAllNonObligatoryElements();

    }

    public void hideAllNonObligatoryElements() {
        // Cars
        carBrandLabel.setVisible(false);
        carBrand.setVisible(false);
        carRegLabel.setVisible(false);
        carRegNo.setVisible(false);
        createCarButton.setVisible(false);

        // Book
        bookTitleLabel.setVisible(false);
        bookTitle.setVisible(false);
        bookAuthorNameLabel.setVisible(false);
        bookAuthorName.setVisible(false);
        bookAuthorSurnameLabel.setVisible(false);
        bookAuthorSurname.setVisible(false);
        createBookButton.setVisible(false);

        // person
        personNameLabel.setVisible(false);
        personName.setVisible(false);
        personSurnameLabel.setVisible(false);
        personSurname.setVisible(false);
        personPhoneNumberLabel.setVisible(false);
        personPhoneNumber.setVisible(false);
        createPersonButton.setVisible(false);

        // View cars
        carScrollPane.setVisible(false);

        // View books
        bookScrollPane.setVisible(false);

        // View persons
        personScrollPane.setVisible(false);

        // Common
        creationStatus.setText("");

    }

    private void getAllCars() {
        Connection con = MySqlCon.getConn();
        String query = "SELECT Cars.ID, Cars.carBrand, Cars.registrationNumber,itemclasses.itemClassName FROM Cars,ItemClasses where Cars.itemClassID=itemClasses.ID order by carBrand;"; // skapa en textsträng med SQL
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            carModel.setRowCount(0);
            while (rs.next()) {
                Vector row = new Vector();

                row.add(rs.getString("ID"));
                row.add(rs.getString("carBrand"));
                row.add(rs.getString("registrationNumber"));
                row.add(rs.getString("itemClassName"));
                carModel.addRow(row);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getAllBooks() {
        Connection con = MySqlCon.getConn();
        String query = "Select book.ID,book.bookName,book.authorName,book.authorSurname,itemclasses.itemClassName from book,itemclasses where book.itemTypeID=itemclasses.ID order by book.bookName;"; // skapa en textsträng med SQL
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookModel.setRowCount(0);
            while (rs.next()) {
                Vector row = new Vector();

                row.add(rs.getString("ID"));
                row.add(rs.getString("bookName"));
                row.add(rs.getString("authorName"));
                row.add(rs.getString("authorSurname"));
                row.add(rs.getString("itemClassName"));
                bookModel.addRow(row);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getAllPersons() {
        Connection con = MySqlCon.getConn();
        String query = "Select * from persons order by surname;"; // skapa en textsträng med SQL
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            personModel.setRowCount(0);
            while (rs.next()) {
                Vector row = new Vector();

                row.add(rs.getString("ID"));
                row.add(rs.getString("name"));
                row.add(rs.getString("surname"));
                row.add(rs.getString("phonenumber"));
                personModel.addRow(row);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
