module co.edu.poli.actividad10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.actividad10.contexto3.vista to javafx.fxml;
    exports co.edu.poli.actividad10.contexto3.vista;
}
