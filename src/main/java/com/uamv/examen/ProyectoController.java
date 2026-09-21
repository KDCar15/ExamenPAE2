package com.uamv.examen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ProyectoController implements Initializable
{
    @FXML private TextField txtProyecto;

    @FXML private ToggleGroup tgTipoProyecto;
    @FXML private RadioButton rbWeb;
    @FXML private RadioButton rbMovil;

    @FXML private CheckBox chkJava;
    @FXML private CheckBox chkReact;
    @FXML private CheckBox chkPostgres;

    @FXML private ImageView imgProyecto;

    @FXML
    private void seleccionarImagen()
    {
        FileChooser fc = new FileChooser();

        File archivo = fc.showOpenDialog(
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
        if(txtProyecto.getText().isEmpty()){
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setContentText(
                    "Debe introducir un nombre del proyecto"
            );
            error.show();
            return;
        }

        RadioButton tipo;
        if(tgTipoProyecto.getSelectedToggle() != null) {
            tipo =
                    (RadioButton) tgTipoProyecto.getSelectedToggle();
        }
        else{
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setContentText(
                    "Debe seleccionar un tipo de proyecto"
            );
            error.show();
            return;
        }

        String tecnologias = "";

        if (chkJava.isSelected())
            tecnologias += "Java ";

        if (chkReact.isSelected())
            tecnologias += "React ";

        if (chkPostgres.isSelected())
            tecnologias += "PostgreSQL ";

        if (tecnologias.isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setContentText(
                    "Debe seleccionar al menos una tecnología"
            );
            error.show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Información del proyecto");
        alert.setHeaderText("");
        alert.setContentText(
                         "Proyecto" + txtProyecto.getText()
                        +"\nTipo: " + tipo.getText()
                        + "\nTecnologías: " + tecnologias
        );

        alert.setGraphic(imgProyecto);

        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tgTipoProyecto = new ToggleGroup();
        rbWeb.setToggleGroup(tgTipoProyecto);
        rbMovil.setToggleGroup(tgTipoProyecto);
    }
}