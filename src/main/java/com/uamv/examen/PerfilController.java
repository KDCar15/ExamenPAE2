package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PerfilController {

    @FXML private TextField txtNombre;
    @FXML private RadioButton rbEstudiante;
    @FXML private RadioButton rbDocente;

    @FXML private CheckBox chkJava;
    @FXML private CheckBox chkJavaFX;
    @FXML private CheckBox chkSpring;

    @FXML private ImageView imagen;

    @FXML
    private void cargarImagen() {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Seleccione una imagen");

        File archivo = chooser.showSaveDialog(
                (Stage) imagen.getScene().getWindow()
        );

        if (archivo != null) {
            imagen.setImage(
                    new Image(archivo.toURI().toString())
            );
        }
    }

    @FXML
    private void mostrarPerfil() {

        ToggleGroup grupo = new ToggleGroup();

        rbEstudiante.setToggleGroup(grupo);
        rbDocente.setToggleGroup(grupo);

        RadioButton seleccionado =
                (RadioButton) grupo.getSelectedToggle();

        String perfil = seleccionado.getText();

        String cursos = "";

        if (chkJava.isSelected())
            cursos += "Java ";

        if (chkJavaFX.isSelected())
            cursos += "JavaFX ";

        if (chkSpring.isSelected())
            cursos += "Spring Boot ";

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Perfil");
        alerta.setHeaderText("Información del estudiante");

        alerta.setContentText(
                "Nombre: " + txtNombre.getText()
                        + "\nPerfil: " + perfil
                        + "\nCursos: " + cursos
        );

        alerta.show();
    }
}