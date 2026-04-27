package co.edu.poli.actividad10.contexto3.controlador;

import java.io.IOException;

import co.edu.poli.actividad10.contexto3.vista.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
