package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

public  class GUI {

    // Core elements
    JFrame f=new JFrame("Fräck applikationstitel här...");
    final JLabel instructionLabel=new JLabel("Välj vad du vill göra");
    JButton createCarMenuButton=new JButton("Skapa bil");
    final JLabel currentCommandLabel=new JLabel("");
    JSeparator separator = new JSeparator();
    final JLabel creationStatus = new JLabel("testing testing");

    // Car elements
    final JLabel carBrandLabel = new JLabel("Ange bilmärke");
    final JLabel carRegLabel = new JLabel("Ange registreringsnummer");
    final JTextField carBrand=new JTextField();
    final JTextField carRegNo=new JTextField();
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

    public GUI(){

        // Setting JFrame settings
        f.setSize(1024,800);
        f.setLayout(null);

    // ******* Car specific ********
        // Menubutton: Create Car position
        createCarMenuButton.setBounds(10,50,90,20);
        createCarMenuButton.addActionListener(new ActionListener(){ // OBS: anonym inre klass!
            public void actionPerformed(ActionEvent e){
                hideAllNonObligatoryElements();
                currentCommandLabel.setText("Skapa bil");
                carBrandLabel.setVisible(true);
                carBrand.setVisible(true);
                carRegLabel.setVisible(true);
                carRegNo.setVisible(true);
                createCarButton.setVisible(true);

                //sökResultatTextArea.setText(printQuery(textField.getText()));
            }
        });

        // Car brand
        carBrandLabel.setBounds(10,120,80,20);
        carBrand.setBounds(180,122, 150,20);

        // Car reg no
        carRegLabel.setBounds(10,150,160,20);
        carRegNo.setBounds(180,152, 60,20);

        // createCarButton
        createCarButton.setBounds(10, 190,90,20);
        createCarButton.addActionListener(new ActionListener(){ // OBS: anonym inre klass!
            public void actionPerformed(ActionEvent e){
                if(Car.createCar(carBrand.getText(), carRegNo.getText())){
                    creationStatus.setText("Car was created.");
                    carBrand.setText("");
                    carRegNo.setText("");
                } else {
                    creationStatus.setText("Could not create car. Perhaps it already existed?");
                }
                //sökResultatTextArea.setText(printQuery(textField.getText()));
            }
        });


        // ******** Book specific ************
        bookTitleLabel.setBounds(10,120,80,20);
        bookTitle.setBounds(180,122,150,20);

        bookAuthorNameLabel.setBounds(10,150,160,20);
        bookAuthorName.setBounds(180,152,150,20);

        bookAuthorSurnameLabel.setBounds(10,180,160,20);
        bookAuthorSurname.setBounds(180,182,150,20);

        createBookMenuButton.setBounds(110,50,110,20);
        createBookMenuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
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

        createBookButton.setBounds(10,220,120,20);
        createBookButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Book.createBook(bookTitle.getText(), bookAuthorName.getText(),bookAuthorSurname.getText())){
                    creationStatus.setText("Book was created.");
                    bookTitle.setText("");
                    bookAuthorName.setText("");
                    bookAuthorSurname.setText("");
                } else {
                    creationStatus.setText("Could not create Book. Perhaps it already exists?");
                }
            }
        });


    // ***** Shared
        // Current command label
        currentCommandLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        currentCommandLabel.setBounds(10,100,250,15);

        // Instructionslabel
        instructionLabel.setBounds(10,30,250,15);
        // creation status
        creationStatus.setBounds(10,250,300,15);


        // Separator
        separator.setBounds(10,90,980,20);


        // Adding objects
        f.add(instructionLabel);
        f.add(createCarMenuButton);
        f.add(currentCommandLabel);
        f.add(separator);

        // Cars
        f.add(carBrandLabel);
        f.add(carBrand);
        f.add(carRegLabel);
        f.add(createCarButton);
        f.add(carRegNo);

        //book
        f.add(createBookMenuButton);

        f.add(bookTitleLabel);
        f.add(bookTitle);

        f.add(bookAuthorNameLabel);
        f.add(bookAuthorName);

        f.add(bookAuthorSurnameLabel);
        f.add(bookAuthorSurname);
        f.add(createBookButton);

        f.add(creationStatus);

        f.setVisible(true);
        hideAllNonObligatoryElements();

    }

    public void hideAllNonObligatoryElements(){
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


        // Common
        creationStatus.setText("");

    }

    public void initGUI(){








    }
}
