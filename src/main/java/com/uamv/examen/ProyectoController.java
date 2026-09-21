package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ProyectoController {

    @FXML private TextField txtProyecto;
    @FXML private RadioButton rbWeb;
    @FXML private RadioButton rbMovil;

    @FXML private CheckBox chkJava;
    @FXML private CheckBox chkReact;
    @FXML private CheckBox chkPostgres;

    @FXML private ImageView imgProyecto;

    @FXML
    private void seleccionarImagen() {

        FileChooser fc = new FileChooser();

        File archivo = fc.showSaveDialog(
                (Stage) imgProyecto.getScene().getWindow()
        );

        if (archivo != null) {
            imgProyecto.setImage(
                    new Image(archivo.toURI().toString())
            );
        }
    }

    @FXML
    private void registrar() {

        ToggleGroup grupo = new ToggleGroup();

        rbWeb.setToggleGroup(grupo);
        rbMovil.setToggleGroup(grupo);

        RadioButton tipo =
                (RadioButton) grupo.getSelectedToggle();

        String tecnologias = "";

        if (chkJava.isSelected())
            tecnologias += "Java ";

        if (chkReact.isSelected())
            tecnologias += "React ";

        if (chkPostgres.isSelected())
            tecnologias += "PostgreSQL ";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setContentText(
                "Proyecto: " + txtProyecto.getText()
                        + "\nTipo: " + tipo.getText()
                        + "\nTecnologías: " + tecnologias
        );

        alert.show();
    }
}