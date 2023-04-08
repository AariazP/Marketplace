package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.example.model.Vendedor;

import java.util.ArrayList;

public class PrincipalController extends Controller{

    @FXML
    private TextField txtMensaje;

    @FXML
    private VBox vboxChats;


    @FXML
    private Label lblChatCon;

    @FXML
    private VBox vboxMensajes;

    private Vendedor vendedorSeleccionado;

    @FXML
    private Label ve1;

    @FXML
    private Label ve2;

    @FXML
    private Label ve3;

    @FXML
    private Label ve4;

    @FXML
    private Label ve5;

    @FXML
    private Label ve6;

    @FXML
    private Label ve7;

    @FXML
    private Label ve8;

    @FXML
    private Label ve9;

    private Label labelActivo;

    ArrayList<Label> labels;




    @FXML
    void enviarMensaje(ActionEvent event) {

    }

    public void initialize(){
        labels = new ArrayList<>();
        labels.add(ve1);
        labels.add(ve2);
        labels.add(ve3);
        labels.add(ve4);
        labels.add(ve5);
        labels.add(ve6);
        labels.add(ve7);
        labels.add(ve8);
        labels.add(ve9);

        ArrayList<Vendedor> vendedores = getMain().getVendedorActivo().getVendedores();

        for (int i = 0; i < vendedores.size(); i++) {
            labels.get(i).setText(vendedores.get(i).getNombre());
        }


    }


    @FXML
    void cambiarChat(MouseEvent event) {

        labels.forEach(label -> {
            if(label.equals(event.getSource())){
                labelActivo = label;
                label.setStyle("-fx-background-color: #e6e6e6");
            }else{
                label.setStyle("-fx-background-color: #233e80");
            }
        });

    }

}
