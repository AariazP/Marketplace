package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.model.Marketplace;
import org.example.utilities.PathUtilities;

public class LoginController extends Controller{

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;




    @FXML
    void iniciarSesion(ActionEvent event) {
        Marketplace marketplace = Marketplace.getInstance();
       if( marketplace.login(txtUser.getText(), txtPassword.getText())){
           getMain().setVendedorActivo(marketplace.getVendedor(txtUser.getText(), txtPassword.getText()));
           getMain().loadScene(PathUtilities.PRINCIPAL);
       }else {
           System.out.println("No se pudo iniciar sesion");
       }
    }



}
