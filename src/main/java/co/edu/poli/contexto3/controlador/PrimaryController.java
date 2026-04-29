package co.edu.poli.contexto3.controlador;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.poli.contexto3.modelo.Astronauta;
import co.edu.poli.contexto3.modelo.Cientifico;
import co.edu.poli.contexto3.modelo.Persona;
import co.edu.poli.contexto3.servicios.ImplementacionOperacionCRUD;

public class PrimaryController {
    @FXML private ComboBox<String> cmbOperacion;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private ComboBox<String> cmbSexo;

    @FXML private VBox  panelFormulario;
    @FXML private Label lblTituloFormulario;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;

    @FXML private Label     lblExperiencia;
    @FXML private TextField txtExperiencia;

    @FXML private Label     lblEspecialidad;
    @FXML private TextField txtEspecialidad;

    @FXML private TableView<Persona>           tablaPersona;
    @FXML private TableColumn<Persona, String> colTipo;
    @FXML private TableColumn<Persona, String> colId;
    @FXML private TableColumn<Persona, String> colNombre;
    @FXML private TableColumn<Persona, String> colSexo;
    @FXML private TableColumn<Persona, String> colExtra; 

    @FXML private TextArea txtResultado;
    @FXML private Button   btnEjecutar;

    private final ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();

  
    @FXML
    public void initialize() {
        cmbOperacion.setItems(FXCollections.observableArrayList(
            "Crear", "Buscar", "Actualizar", "Eliminar"
        ));
        cmbTipo.setItems(FXCollections.observableArrayList(
            "Científico", "Astronauta"
        ));
        cmbSexo.setItems(FXCollections.observableArrayList("M", "F"));

        colId.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getId()));
        colNombre.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getNombre()));
        colSexo.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getSexo()));

        colTipo.setCellValueFactory(data -> {
            String tipo = (data.getValue() instanceof Astronauta)
                ? "🚀 Astronauta" : "🔬 Científico";
            return new SimpleStringProperty(tipo);
        });

        colExtra.setCellValueFactory(data -> {
            Persona p = data.getValue();
            if (p instanceof Astronauta) {
                String esp = ((Astronauta) p).getEspecialidad();
                return new SimpleStringProperty(esp != null ? esp : "-");
            } else if (p instanceof Cientifico) {
                String exp = ((Cientifico) p).getExperiencia();
                return new SimpleStringProperty(exp != null ? exp : "-");
            }
            return new SimpleStringProperty("-");
        });
    }

    @FXML
    private void mostrarFormulario() {
        String operacion = cmbOperacion.getValue();
        String tipo      = cmbTipo.getValue();
        if (operacion == null || tipo == null) return;

        panelFormulario.setVisible(true);
        panelFormulario.setManaged(true);
        lblTituloFormulario.setText(operacion + " → " + tipo);
        
        boolean esCientifico  = "Científico".equals(tipo);
        boolean esAstronauta  = "Astronauta".equals(tipo);

        lblExperiencia.setVisible(esCientifico);
        lblExperiencia.setManaged(esCientifico);
        txtExperiencia.setVisible(esCientifico);
        txtExperiencia.setManaged(esCientifico);

        lblEspecialidad.setVisible(esAstronauta);
        lblEspecialidad.setManaged(esAstronauta);
        txtEspecialidad.setVisible(esAstronauta);
        txtEspecialidad.setManaged(esAstronauta);

        boolean soloId = "Buscar".equals(operacion) || "Eliminar".equals(operacion);
        txtNombre.setDisable(soloId);
        cmbSexo.setDisable(soloId);
        txtExperiencia.setDisable(soloId);
        txtEspecialidad.setDisable(soloId);


        String color;
        switch (operacion) {
            case "Crear":      color = "#27ae60"; break;
            case "Actualizar": color = "#2980b9"; break;
            case "Eliminar":   color = "#c0392b"; break;
            case "Buscar":     color = "#e67e22"; break;
            default:           color = "#27ae60";
        }
        btnEjecutar.setStyle(
            "-fx-background-color: " + color + "; -fx-text-fill: white;" +
            "-fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 7 20 7 20;"
        );
        btnEjecutar.setText("▶ " + operacion);
    }

    @FXML
    private void ejecutarOperacion() {
        String operacion = cmbOperacion.getValue();
        if (operacion == null) { txtResultado.setText("⚠️ Seleccione una operación"); return; }
        switch (operacion) {
            case "Crear":      crear();      break;
            case "Buscar":     buscar();     break;
            case "Actualizar": actualizar(); break;
            case "Eliminar":   eliminar();   break;
        }
    }

    private void crear() {
        try {
            String id     = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String sexo   = cmbSexo.getValue();
            String tipo   = cmbTipo.getValue();

            if (id.isEmpty() || nombre.isEmpty() || sexo == null) {
                txtResultado.setText("⚠️ Complete todos los campos (ID, Nombre, Sexo)");
                return;
            }

            if ("Astronauta".equals(tipo)) {
                String especialidad = txtEspecialidad.getText().trim();
                if (especialidad.isEmpty()) {
                    txtResultado.setText("⚠️ Ingrese la especialidad del astronauta");
                    return;
                }
                crud.crear(new Astronauta(nombre, id, sexo, especialidad));
                txtResultado.setText("✅ Astronauta creado:\n  Nombre: " + nombre +
                    "\n  ID: " + id + "\n  Especialidad: " + especialidad);
            } else {
                String experiencia = txtExperiencia.getText().trim();
                Cientifico c = new Cientifico(nombre, id, sexo);
                if (!experiencia.isEmpty()) c.setExperiencia(experiencia);
                crud.crear(c);
                txtResultado.setText("✅ Científico creado:\n  Nombre: " + nombre +
                    "\n  ID: " + id + "\n  Experiencia: " + (experiencia.isEmpty() ? "-" : experiencia));
            }

            limpiarCampos();
            refrescarTabla();

        } catch (Exception e) {
            txtResultado.setText("❌ Error al crear: " + e.getMessage());
        }
    }

    private void buscar() {
        try {
            String id = txtId.getText().trim();
            if (id.isEmpty()) { txtResultado.setText("⚠️ Ingrese el ID a buscar"); return; }

            Persona p = crud.leer(id);
            if (p == null) { txtResultado.setText("⚠️ No se encontró persona con ID: " + id); return; }

            if (p instanceof Astronauta) {
                Astronauta a = (Astronauta) p;
                txtResultado.setText("🚀 Astronauta encontrado:\n" +
                    "  ID: "           + a.getId()            + "\n" +
                    "  Nombre: "       + a.getNombre()         + "\n" +
                    "  Sexo: "         + a.getSexo()           + "\n" +
                    "  Especialidad: " + a.getEspecialidad());
            } else {
                Cientifico c = (Cientifico) p;
                txtResultado.setText("🔬 Científico encontrado:\n" +
                    "  ID: "          + c.getId()           + "\n" +
                    "  Nombre: "      + c.getNombre()        + "\n" +
                    "  Sexo: "        + c.getSexo()          + "\n" +
                    "  Experiencia: " + c.getExperiencia());
            }

        } catch (Exception e) {
            txtResultado.setText("❌ Error al buscar: " + e.getMessage());
        }
    }

    private void actualizar() {
        try {
            String id     = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String sexo   = cmbSexo.getValue();
            String tipo   = cmbTipo.getValue();

            if (id.isEmpty() || nombre.isEmpty() || sexo == null) {
                txtResultado.setText("⚠️ Complete todos los campos (ID, Nombre, Sexo)");
                return;
            }

            if ("Astronauta".equals(tipo)) {
                String especialidad = txtEspecialidad.getText().trim();
                crud.actualizar(id, new Astronauta(nombre, id, sexo, especialidad));
                txtResultado.setText("🔄 Astronauta actualizado:\n  Nombre: " + nombre +
                    "\n  Especialidad: " + especialidad);
            } else {
                String experiencia = txtExperiencia.getText().trim();
                Cientifico c = new Cientifico(nombre, id, sexo);
                if (!experiencia.isEmpty()) c.setExperiencia(experiencia);
                crud.actualizar(id, c);
                txtResultado.setText("🔄 Científico actualizado:\n  Nombre: " + nombre +
                    "\n  Experiencia: " + (experiencia.isEmpty() ? "-" : experiencia));
            }

            limpiarCampos();
            refrescarTabla();

        } catch (Exception e) {
            txtResultado.setText("❌ Error al actualizar: " + e.getMessage());
        }
    }

    private void eliminar() {
        try {
            String id = txtId.getText().trim();
            if (id.isEmpty()) { txtResultado.setText("⚠️ Ingrese el ID a eliminar"); return; }
            crud.eliminar(id);
            txtResultado.setText("🗑️ Eliminado correctamente (ID: " + id + ")");
            limpiarCampos();
            refrescarTabla();
        } catch (Exception e) {
            txtResultado.setText("❌ Error al eliminar: " + e.getMessage());
        }
    }

    @FXML
    private void guardar() {
        try {
            txtResultado.setText("💾 " + crud.serializar(crud.getPersonas(), "", "personas.dat"));
        } catch (Exception e) {
            txtResultado.setText("❌ Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void cargar() {
        try {
            Persona[] datos = crud.deserializar("", "personas.dat");
            if (datos != null && datos.length > 0) {
                crud.setPersonas(datos);
                refrescarTabla();
                long total = java.util.Arrays.stream(datos).filter(p -> p != null).count();
                txtResultado.setText("📂 Cargados " + total + " registros");
            } else {
                txtResultado.setText("⚠️ No hay datos guardados");
            }
        } catch (Exception e) {
            txtResultado.setText("❌ Error al cargar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void listar() {
        refrescarTabla();
        int total = tablaPersona.getItems().size();
        txtResultado.setText(total > 0
            ? "📋 Mostrando " + total + " registros en la tabla"
            : "📋 No hay registros para mostrar");
    }

    @FXML
    private void salir() { System.exit(0); }
    @FXML
    private void limpiar() {
        limpiarCampos();
        cmbOperacion.setValue(null);
        cmbTipo.setValue(null);
        panelFormulario.setVisible(false);
        panelFormulario.setManaged(false);
        txtResultado.clear();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtExperiencia.clear();
        txtEspecialidad.clear();
        cmbSexo.setValue(null);
    }

    private void refrescarTabla() {
        ObservableList<Persona> lista = FXCollections.observableArrayList();
        for (Persona p : crud.getPersonas()) {
            if (p != null) lista.add(p);
        }
        tablaPersona.setItems(lista);
        tablaPersona.refresh();
    }
   
}
