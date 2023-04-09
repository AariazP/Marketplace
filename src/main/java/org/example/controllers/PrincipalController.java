package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    private Button btnEnviar;

    private Label labelActivo;

    ArrayList<Label> labels;




    @FXML
    void enviarMensaje(ActionEvent event) {

        String mensaje = txtMensaje.getText();

        if(mensaje != null && !mensaje.isEmpty()){
            Label label = new Label(mensaje);
            label.setStyle("-fx-text-fill: RED");
            label.setStyle("-fx-background-color: WHITE");
            label.setStyle("-fx-background-radius: 10px");
            label.setStyle("-fx-border-radius: 10px");
            label.setStyle("-fx-text-alignment: RIGHT");

            vboxMensajes.getChildren().add(label);


            Vendedor vendedorDestino = getMain().getVendedorActivo().getVendedor(obtenerID(lblChatCon.getText()));
            getMain().getVendedorActivo().addMensaje(mensaje, vendedorDestino);
        }

    }

    private int obtenerID(String text) {
        for (int i = 0; i < text.length(); i++) {
            if("1234567890".contains(text.charAt(i)+"") ){
                return text.charAt(i);
            }
        }
        return 0;
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



    }


    public void cargarNombre(){
        ArrayList<Vendedor> vendedores = getMain().getVendedorActivo().getVendedores();

        for (int i = 0; i < vendedores.size(); i++) {
            labels.get(i).setText(vendedores.get(i).getId()+" "+vendedores.get(i).getNombre());
            labels.get(i).setVisible(true);
        }
    }

    @FXML
    void cambiarChat(MouseEvent event) {

        lblChatCon.setVisible(true);
        vboxMensajes.setVisible(true);
        txtMensaje.setVisible(true);
        btnEnviar.setVisible(true);

        labels.forEach(label -> {
            if(label.equals(event.getSource())){
                labelActivo = label;
                label.setStyle("-fx-background-color: #e6e6e6");
                lblChatCon.setText("Chat con"+ label.getText());
                labelActivo = label;
                System.out.println(obtenerID(label.getText()));
                vendedorSeleccionado = getMain().getVendedorActivo().getVendedor(obtenerID(label.getText()));
                System.out.println("vendedorSeleccionado = " + vendedorSeleccionado);
                System.out.println("VendedorActivo = " + getMain().getVendedorActivo());
                ArrayList<String> mensajes = getMain().getVendedorActivo().getMensajes(vendedorSeleccionado);

                vboxMensajes.getChildren().clear();
                if(mensajes != null) {
                    for (String mensaje : mensajes) {
                        System.out.println("mensaje = " + mensaje);
                        Label labelMensaje = new Label(mensaje);
                        labelMensaje.setStyle("-fx-text-fill: BLACK");
                        labelMensaje.setStyle("-fx-background-color: WHITE");
                        labelMensaje.setStyle("-fx-background-radius: 10px");
                        labelMensaje.setStyle("-fx-border-radius: 10px");
                        labelMensaje.setStyle("-fx-text-alignment: LEFT");
                        vboxMensajes.getChildren().add(labelMensaje);
                    }
                }
            }else{
                label.setStyle("-fx-background-color: BLACK");
            }
        });

    }

}
