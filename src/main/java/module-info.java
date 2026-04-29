module co.edu.poli.actividad10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.contexto3.controlador to javafx.fxml;
    exports co.edu.poli.contexto3.vista;
    
    opens co.edu.poli.contexto3.modelo to javafx.base;
}
