package co.edu.poli.actividad10.contexto3.controlador;

import java.io.IOException;

import co.edu.poli.actividad10.contexto3.vista.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}