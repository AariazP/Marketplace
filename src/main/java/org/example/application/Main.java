package org.example.application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.Getter;
import lombok.Setter;
import org.example.controllers.Controller;
import org.example.controllers.PrincipalController;
import org.example.model.Marketplace;
import org.example.model.Vendedor;
import org.example.persitence.Serialize;
import org.example.utilities.PathUtilities;

import java.io.IOException;
import java.util.Objects;

@Setter
@Getter
public class Main extends Application {

    private Stage stage;

    private Vendedor vendedorActivo;


    public static void main(String[] args) {
        deserialize();
        launch();
    }

    private static void deserialize() {
        Marketplace marketplace = Serialize.deserializar("/users/alejandroarias/Desktop/data.txt");
        if (marketplace != null) {
            Marketplace.setInstance(marketplace);
        }else {
           Marketplace.getInstance();
            System.out.println(" La instancia es nulla");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
       loadScene(PathUtilities.LOGIN);
        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            serialize();
            System.out.println(" Serializo " );
        });
    }

    private void serialize() {

        Serialize.serialize("/users/alejandroarias/Desktop/data.txt");


    }

    public void loadScene(String sceneName){
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(sceneName)));
        try {
            Pane pane = loader.load();
            Controller controller = loader.getController();
            controller.setMain(this);

            if(controller instanceof PrincipalController){
                ((PrincipalController) controller).cargarNombre();
            }
            Scene scene = new Scene(pane);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Metodo que agrega un evento al boton de cerrar y serializa los datos
     * en un xml
     *
     */

    public void close(){

    }

}