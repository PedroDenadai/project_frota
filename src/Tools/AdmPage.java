package Tools;

import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AdmPage implements ActionListener {
    JFrame frame =  new JFrame();
    JButton newUser = new JButton("Inserir Usuario");
    JButton sair = new JButton("Sair");

    DBConnetion connection;


    public AdmPage(DBConnetion conn){
        this.connection = conn;
        newUser.setBounds(50,200,350,50);
        newUser.setFocusable(false);
        newUser.addActionListener(this);
        sair.setBounds(50,300,350,50);
        sair.setFocusable(false);
        sair.addActionListener(this);

        frame.add(sair);
        frame.add(newUser);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newUser){
            frame.setVisible(false);
            NewUserPage newUserPage = new NewUserPage(this.connection);
        }else if(e.getSource() == sair){
            frame.setVisible(false);
            LoginPage loginPage = new LoginPage(connection);
        }
    }
}
