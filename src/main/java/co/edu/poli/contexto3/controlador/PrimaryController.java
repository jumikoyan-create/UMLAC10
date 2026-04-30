package co.edu.poli.contexto3.controlador;

import co.edu.poli.contexto3.modelo.*;
import co.edu.poli.contexto3.servicios.ImplementacionOperacionCRUD;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    // ═══════════════════════════════════════════
    //  CAMPOS FXML
    // ═══════════════════════════════════════════
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtExtra1;
    @FXML private TextField txtExtra2;
    @FXML private TextField txtExtra3;

    @FXML private Label lblExtra1;
    @FXML private Label lblExtra2;
    @FXML private Label lblExtra3;

    // ── ComboBoxes ─────────────────────────────
    @FXML private ComboBox<Astronauta> cmbAstronauta;
    @FXML private ComboBox<Cientifico> cmbCientifico;
    @FXML private ComboBox<Suelo>      cmbSuelo;
    @FXML private ComboBox<Planeta>    cmbPlaneta;
    @FXML private ComboBox<Mision>     cmbMision;
    @FXML private ComboBox<Contenedor> cmbContenedor;

    @FXML private Label lblCmbAstronauta;
    @FXML private Label lblCmbCientifico;
    @FXML private Label lblCmbSuelo;
    @FXML private Label lblCmbPlaneta;
    @FXML private Label lblCmbMision;
    @FXML private Label lblCmbContenedor;

    // ── Tabla ──────────────────────────────────
    @FXML private TableView<Entidad>           tabla;
    @FXML private TableColumn<Entidad, String> colId;
    @FXML private TableColumn<Entidad, String> colNombre;
    @FXML private TableColumn<Entidad, String> colTipo;
    @FXML private TableColumn<Entidad, String> colDetalle;
    @FXML private Label lblEstado;

    // ═══════════════════════════════════════════
    //  ESTADO Y DATOS
    // ═══════════════════════════════════════════
    private String modoActual = "MUESTRA";

    private final ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();

    private final ObservableList<Entidad>    data              = FXCollections.observableArrayList();
    private final ObservableList<Astronauta> listaAstronautas  = FXCollections.observableArrayList();
    private final ObservableList<Cientifico> listaCientificos  = FXCollections.observableArrayList();
    private final ObservableList<Mision>     listaMisiones     = FXCollections.observableArrayList();
    private final ObservableList<Contenedor> listaContenedores = FXCollections.observableArrayList();
    // Suelo y Planeta: solo listas locales para ComboBox, no entran al CRUD
    private final ObservableList<Suelo>      listaSuelos       = FXCollections.observableArrayList();
    private final ObservableList<Planeta>    listaPlanetas     = FXCollections.observableArrayList();

    private static final String RUTA    = System.getProperty("user.home") + "/";
    private static final String ARCHIVO = "espacial.dat";

    // ═══════════════════════════════════════════
    //  INICIALIZACIÓN
    // ═══════════════════════════════════════════
    @FXML
    public void initialize() {
        cmbAstronauta.setItems(listaAstronautas);
        cmbCientifico.setItems(listaCientificos);
        cmbSuelo.setItems(listaSuelos);
        cmbPlaneta.setItems(listaPlanetas);
        cmbMision.setItems(listaMisiones);
        cmbContenedor.setItems(listaContenedores);

        // ── Columnas ───────────────────────────
        colId.setCellValueFactory(c ->
            new SimpleStringProperty(c.getValue().getId()));
        colNombre.setCellValueFactory(c ->
            new SimpleStringProperty(c.getValue().getNombre()));
        colTipo.setCellValueFactory(c ->
            new SimpleStringProperty(c.getValue().getClass().getSimpleName()));

        colDetalle.setCellValueFactory(c -> {
            Entidad e = c.getValue();
            if (e instanceof Muestra) {
                Muestra m = (Muestra) e;
                String astro  = m.getRecolector()  != null ? m.getRecolector().getNombre() : "N/A";
                String cient  = m.getAnalizador()  != null ? m.getAnalizador().getNombre()  : "N/A";
                String suelo  = m.getSuelo()        != null ? m.getSuelo().getNombre()       : "N/A";
                String origen = m.getDeDondeViene() != null ? m.getDeDondeViene()            : "N/A";
                return new SimpleStringProperty(
                    "Tipo: " + m.getTipoMuestra() + " | Suelo: " + suelo +
                    " | Planeta: " + origen + " | Astronauta: " + astro +
                    " | Científico: " + cient);
            } else if (e instanceof Astronauta) {
                Astronauta a = (Astronauta) e;
                return new SimpleStringProperty(
                    "Agencia: " + a.getAgenciaEspacial() + " | Rango: " + a.getRango());
            } else if (e instanceof Cientifico) {
                Cientifico ci = (Cientifico) e;
                return new SimpleStringProperty(
                    "Especialidad: " + ci.getEspecialidad() +
                    " | Exp: " + ci.getExperienciaAnios() + " años");
            } else if (e instanceof Mision) {
                Mision m = (Mision) e;
                String planeta = m.getPlaneta() != null ? m.getPlaneta().getNombre() : "N/A";
                return new SimpleStringProperty(
                    "Objetivo: " + m.getObjetivo() + " | Planeta: " + planeta);
            } else if (e instanceof Nave) {
                Nave n = (Nave) e;
                String mision = n.getMision() != null ? n.getMision().getNombre() : "N/A";
                return new SimpleStringProperty(
                    "Material: " + n.getMaterial() + " | Velocidad: " + n.getVelocidad() +
                    " | Misión: " + mision);
            } else if (e instanceof Contenedor) {
                Contenedor co = (Contenedor) e;
                return new SimpleStringProperty(
                    "Tipo: " + co.getTipo() + " | Marca: " + co.getMarca());
            }
            return new SimpleStringProperty("-");
        });

        tabla.setItems(data);
        tabla.getSelectionModel().selectedItemProperty().addListener(
            (obs, old, sel) -> { if (sel != null) cargarEnCampos(sel); });

        activarModoMuestra();
    }

    // ═══════════════════════════════════════════
    //  MODOS
    // ═══════════════════════════════════════════
    @FXML public void activarModoAstronauta() {
        modoActual = "ASTRONAUTA";
        lblExtra1.setText("Agencia espacial:");
        lblExtra2.setText("Rango:");
        ocultarTodosCombos();
        ocultar(txtExtra3, lblExtra3);
        limpiarCampos();
        estado("Modo: registrar astronauta", false);
    }

    @FXML public void activarModoCientifico() {
        modoActual = "CIENTIFICO";
        lblExtra1.setText("Especialidad:");
        lblExtra2.setText("Experiencia (años):");
        ocultarTodosCombos();
        ocultar(txtExtra3, lblExtra3);
        limpiarCampos();
        estado("Modo: registrar científico", false);
    }

    // Suelo: solo ComboBox, no entra al CRUD
    @FXML public void activarModoSuelo() {
        modoActual = "SUELO";
        lblExtra1.setText("Material:");
        lblExtra2.setText("Estado:");
        lblExtra3.setText("Tamaño:");
        ocultarTodosCombos();
        mostrar(txtExtra3, lblExtra3);
        limpiarCampos();
        estado("Modo: registrar suelo", false);
    }

    // Planeta: solo ComboBox, no entra al CRUD
    @FXML public void activarModoPlaneta() {
        modoActual = "PLANETA";
        lblExtra1.setText("Material:");
        lblExtra2.setText("Distancia a la Tierra (km):");
        lblExtra3.setText("Fecha descubrimiento:");
        ocultarTodosCombos();
        mostrar(txtExtra3, lblExtra3);
        mostrar(cmbSuelo, lblCmbSuelo);
        limpiarCampos();
        estado("Modo: registrar planeta", false);
    }

    @FXML public void activarModoMision() {
        modoActual = "MISION";
        lblExtra1.setText("Objetivo:");
        lblExtra2.setText("Encargado:");
        lblExtra3.setText("Beneficio:");
        ocultarTodosCombos();
        mostrar(txtExtra3, lblExtra3);
        mostrar(cmbPlaneta, lblCmbPlaneta);
        limpiarCampos();
        estado("Modo: registrar misión", false);
    }

    @FXML public void activarModoNave() {
        modoActual = "NAVE";
        lblExtra1.setText("Material:");
        lblExtra2.setText("Velocidad:");
        lblExtra3.setText("Fecha creación:");
        ocultarTodosCombos();
        mostrar(txtExtra3, lblExtra3);
        mostrar(cmbMision, lblCmbMision);
        mostrar(cmbAstronauta, lblCmbAstronauta);
        limpiarCampos();
        estado("Modo: registrar nave", false);
    }

    @FXML public void activarModoContenedor() {
        modoActual = "CONTENEDOR";
        lblExtra1.setText("Tipo:");
        lblExtra2.setText("Marca:");
        ocultarTodosCombos();
        ocultar(txtExtra3, lblExtra3);
        limpiarCampos();
        estado("Modo: registrar contenedor", false);
    }

    @FXML public void activarModoMuestra() {
        modoActual = "MUESTRA";
        lblExtra1.setText("Tipo de muestra:");
        lblExtra2.setText("Estado:");
        ocultarTodosCombos();
        ocultar(txtExtra3, lblExtra3);
        mostrar(cmbAstronauta,  lblCmbAstronauta);
        mostrar(cmbCientifico,  lblCmbCientifico);
        mostrar(cmbSuelo,       lblCmbSuelo);
        mostrar(cmbPlaneta,     lblCmbPlaneta);
        mostrar(cmbContenedor,  lblCmbContenedor);
        limpiarCampos();
        estado("Modo: registrar muestra", false);
    }

    // ═══════════════════════════════════════════
    //  CREAR — despacha según modo
    // ═══════════════════════════════════════════
    @FXML public void crear() {
        switch (modoActual) {
            case "ASTRONAUTA": crearAstronauta(); break;
            case "CIENTIFICO": crearCientifico();  break;
            case "SUELO":      crearSuelo();       break;
            case "PLANETA":    crearPlaneta();     break;
            case "MISION":     crearMision();      break;
            case "NAVE":       crearNave();        break;
            case "CONTENEDOR": crearContenedor();  break;
            case "MUESTRA":    crearMuestra();     break;
        }
    }

    private void crearAstronauta() {
        String id = f(txtId), nombre = f(txtNombre);
        String agencia = f(txtExtra1), rango = f(txtExtra2);
        if (vacios(id, nombre, agencia, rango)) return;
        if (idExiste(id)) return;
        Astronauta a = new Astronauta(id, nombre, agencia, rango);
        crud.crear(a);
        refrescar(); limpiarCampos();
        estado("✔ Astronauta \"" + nombre + "\" creado", false);
    }

    private void crearCientifico() {
        String id = f(txtId), nombre = f(txtNombre);
        String esp = f(txtExtra1), expTxt = f(txtExtra2);
        if (vacios(id, nombre, esp, expTxt)) return;
        if (idExiste(id)) return;
        try {
            Cientifico c = new Cientifico(id, nombre, esp, Integer.parseInt(expTxt));
            crud.crear(c);
            refrescar(); limpiarCampos();
            estado("✔ Científico \"" + nombre + "\" creado", false);
        } catch (NumberFormatException e) {
            estado("⚠ La experiencia debe ser un número entero", true);
        }
    }

    // Suelo: solo agrega a la lista local del ComboBox
    private void crearSuelo() {
        String id = f(txtId), nombre = f(txtNombre);
        String material = f(txtExtra1), estadoS = f(txtExtra2);
        if (vacios(id, nombre, material)) return;
        // Verificar que no haya un suelo con el mismo ID en la lista local
        for (Suelo s : listaSuelos) {
            if (s.getId().equals(id)) {
                estado("⚠ Ya existe un suelo con ese ID: " + id, true); return;
            }
        }
        try {
            Suelo s = new Suelo(nombre, id);
            s.setMaterial(material);
            s.setEstado(estadoS);
            String tam = f(txtExtra3);
            if (!tam.isEmpty()) s.setTamanio(Double.parseDouble(tam));
            listaSuelos.add(s);
            limpiarCampos();
            estado("✔ Suelo \"" + nombre + "\" registrado", false);
        } catch (NumberFormatException e) {
            estado("⚠ Tamaño debe ser un número", true);
        }
    }

    // Planeta: solo agrega a la lista local del ComboBox
    private void crearPlaneta() {
        String id = f(txtId), nombre = f(txtNombre);
        String material = f(txtExtra1);
        if (vacios(id, nombre, material)) return;
        // Verificar que no haya un planeta con el mismo ID en la lista local
        for (Planeta p : listaPlanetas) {
            if (p.getId().equals(id)) {
                estado("⚠ Ya existe un planeta con ese ID: " + id, true); return;
            }
        }
        try {
            Planeta p = new Planeta(nombre, id);
            p.setMaterial(material);
            String dist = f(txtExtra2);
            if (!dist.isEmpty()) p.setDistanciaalatierra(Double.parseDouble(dist));
            p.setFechadescubrimiento(f(txtExtra3));
            p.setSuelo(cmbSuelo.getValue());
            listaPlanetas.add(p);
            limpiarCampos();
            estado("✔ Planeta \"" + nombre + "\" registrado", false);
        } catch (NumberFormatException e) {
            estado("⚠ Distancia debe ser un número", true);
        }
    }

    private void crearMision() {
        String id = f(txtId), nombre = f(txtNombre);
        String objetivo = f(txtExtra1);
        if (vacios(id, nombre, objetivo)) return;
        if (idExiste(id)) return;
        Mision m = new Mision(nombre, id);
        m.setObjetivo(objetivo);
        m.setEncargado(f(txtExtra2));
        m.setBeneficio(f(txtExtra3));
        m.setPlaneta(cmbPlaneta.getValue());
        crud.crear(m);
        refrescar(); limpiarCampos();
        estado("✔ Misión \"" + nombre + "\" creada", false);
    }

    private void crearNave() {
        String id = f(txtId), nombre = f(txtNombre);
        String material = f(txtExtra1);
        if (vacios(id, nombre, material)) return;
        if (idExiste(id)) return;
        try {
            Nave n = new Nave(nombre, id);
            n.setMaterial(material);
            String vel = f(txtExtra2);
            if (!vel.isEmpty()) n.setVelocidad(Double.parseDouble(vel));
            n.setFechadecreacion(f(txtExtra3));
            n.setMision(cmbMision.getValue());
            Astronauta cap = cmbAstronauta.getValue();
            if (cap != null) n.setAstronauta(new Astronauta[]{cap});
            crud.crear(n);
            refrescar(); limpiarCampos();
            estado("✔ Nave \"" + nombre + "\" creada", false);
        } catch (NumberFormatException e) {
            estado("⚠ Velocidad debe ser un número", true);
        }
    }

    private void crearContenedor() {
        String id = f(txtId), nombre = f(txtNombre);
        String tipo = f(txtExtra1);
        if (vacios(id, nombre, tipo)) return;
        if (idExiste(id)) return;
        Contenedor c = new Contenedor(nombre, id);
        c.setTipo(tipo);
        c.setMarca(f(txtExtra2));
        crud.crear(c);
        refrescar(); limpiarCampos();
        estado("✔ Contenedor \"" + nombre + "\" creado", false);
    }

    private void crearMuestra() {
        String id = f(txtId), nombre = f(txtNombre), tipo = f(txtExtra1);
        Astronauta astro = cmbAstronauta.getValue();
        Cientifico cient = cmbCientifico.getValue();
        if (vacios(id, nombre, tipo)) return;
        if (astro == null || cient == null) {
            estado("⚠ Selecciona astronauta y científico", true); return;
        }
        if (idExiste(id)) return;
        Muestra m = new Muestra(id, nombre, tipo, astro, cient);
        m.setEstado(f(txtExtra2));
        m.setSuelo(cmbSuelo.getValue());
        Planeta p = cmbPlaneta.getValue();
        m.setDeDondeViene(p != null ? p.getNombre() : "");
        Contenedor cont = cmbContenedor.getValue();
        if (cont != null) cont.setMuestra(m);
        crud.crear(m);
        refrescar(); limpiarCampos();
        estado("✔ Muestra \"" + nombre + "\" registrada" +
               (m.getSuelo() != null ? " | Suelo: " + m.getSuelo().getNombre() : "") +
               (p != null ? " | Planeta: " + p.getNombre() : ""), false);
    }

    // ═══════════════════════════════════════════
    //  BUSCAR
    // ═══════════════════════════════════════════
    @FXML public void buscar() {
        String id = f(txtId);
        if (id.isEmpty()) { estado("⚠ Escribe el ID a buscar", true); return; }
        Entidad found = crud.leer(id);
        if (found == null) {
            estado("⚠ No se encontró entidad con ID: " + id, true); data.clear();
        } else {
            data.clear(); data.add(found);
            tabla.getSelectionModel().selectFirst();
            estado("✔ Encontrado: " + found.getNombre(), false);
        }
    }

    // ═══════════════════════════════════════════
    //  ACTUALIZAR
    // ═══════════════════════════════════════════
    @FXML public void actualizar() {
        Entidad sel = tabla.getSelectionModel().getSelectedItem();
        if (sel == null) { estado("⚠ Selecciona una fila para actualizar", true); return; }
        String id = f(txtId), nombre = f(txtNombre);
        if (id.isEmpty() || nombre.isEmpty()) { estado("⚠ ID y Nombre son obligatorios", true); return; }
        try {
            if (sel instanceof Astronauta) {
                Astronauta nuevo = new Astronauta(id, nombre, f(txtExtra1), f(txtExtra2));
                crud.actualizar(sel.getId(), nuevo);
                int i = listaAstronautas.indexOf(sel);
                if (i >= 0) listaAstronautas.set(i, nuevo);

            } else if (sel instanceof Cientifico) {
                Cientifico nuevo = new Cientifico(id, nombre,
                    f(txtExtra1), Integer.parseInt(f(txtExtra2)));
                crud.actualizar(sel.getId(), nuevo);
                int i = listaCientificos.indexOf(sel);
                if (i >= 0) listaCientificos.set(i, nuevo);

            } else if (sel instanceof Mision) {
                Mision nuevo = new Mision(nombre, id);
                nuevo.setObjetivo(f(txtExtra1)); nuevo.setEncargado(f(txtExtra2));
                nuevo.setBeneficio(f(txtExtra3)); nuevo.setPlaneta(cmbPlaneta.getValue());
                crud.actualizar(sel.getId(), nuevo);
                int i = listaMisiones.indexOf(sel);
                if (i >= 0) listaMisiones.set(i, nuevo);

            } else if (sel instanceof Nave) {
                Nave nuevo = new Nave(nombre, id);
                nuevo.setMaterial(f(txtExtra1));
                String vel = f(txtExtra2);
                if (!vel.isEmpty()) nuevo.setVelocidad(Double.parseDouble(vel));
                nuevo.setFechadecreacion(f(txtExtra3));
                nuevo.setMision(cmbMision.getValue());
                crud.actualizar(sel.getId(), nuevo);

            } else if (sel instanceof Contenedor) {
                Contenedor nuevo = new Contenedor(nombre, id);
                nuevo.setTipo(f(txtExtra1)); nuevo.setMarca(f(txtExtra2));
                crud.actualizar(sel.getId(), nuevo);
                int i = listaContenedores.indexOf(sel);
                if (i >= 0) listaContenedores.set(i, nuevo);

            } else if (sel instanceof Muestra) {
                Astronauta a = cmbAstronauta.getValue();
                Cientifico c = cmbCientifico.getValue();
                if (a == null || c == null) { estado("⚠ Selecciona astronauta y científico", true); return; }
                Muestra nuevo = new Muestra(id, nombre, f(txtExtra1), a, c);
                nuevo.setSuelo(cmbSuelo.getValue());
                Planeta p = cmbPlaneta.getValue();
                nuevo.setDeDondeViene(p != null ? p.getNombre() : "");
                crud.actualizar(sel.getId(), nuevo);
            }
            refrescar(); limpiarCampos();
            estado("✔ Actualizado correctamente", false);
        } catch (NumberFormatException e) {
            estado("⚠ El campo numérico tiene un valor inválido", true);
        }
    }

    // ═══════════════════════════════════════════
    //  ELIMINAR
    // ═══════════════════════════════════════════
    @FXML public void eliminar() {
        Entidad sel = tabla.getSelectionModel().getSelectedItem();
        if (sel == null) {
            String id = f(txtId);
            if (!id.isEmpty() && crud.leer(id) != null) { ejecutarEliminar(id); return; }
            estado("⚠ Selecciona una fila o escribe el ID", true); return;
        }
        ejecutarEliminar(sel.getId());
    }

    private void ejecutarEliminar(String id) {
        Entidad e = crud.leer(id);
        if (e == null) { estado("⚠ No existe entidad con ese ID", true); return; }
        crud.eliminar(id);
        refrescar(); limpiarCampos();
        estado("✔ Eliminado: " + e.getNombre(), false);
    }

    // ═══════════════════════════════════════════
    //  LISTAR / SERIALIZAR / DESERIALIZAR
    // ═══════════════════════════════════════════
    @FXML public void listar() {
        refrescar();
        estado("✔ Total registros: " + data.size(), false);
    }

    @FXML public void serializar() {
        String r = crud.serializar(crud.getEntidades(), RUTA, ARCHIVO);
        estado(r.startsWith("Archivo") ? "✔ " + r : "⚠ " + r, !r.startsWith("Archivo"));
    }

    @FXML public void deserializar() {
        Entidad[] cargadas = crud.deserializar(RUTA, ARCHIVO);
        if (cargadas == null) { estado("⚠ No se pudo leer " + ARCHIVO, true); return; }
        crud.setEntidades(cargadas);
        refrescar();
        estado("✔ Datos cargados: " + data.size() + " registros", false);
    }

    // ═══════════════════════════════════════════
    //  HELPERS
    // ═══════════════════════════════════════════
    private void refrescar() {
        data.clear();
        listaAstronautas.clear(); listaCientificos.clear();
        listaMisiones.clear();    listaContenedores.clear();
        // Suelo y Planeta NO se limpian aquí porque son listas locales
        // que el usuario llena manualmente y no vienen del CRUD

        for (Entidad e : crud.listar()) {
            if (e == null) continue;
            data.add(e);
            if (e instanceof Astronauta)  listaAstronautas.add((Astronauta) e);
            if (e instanceof Cientifico)  listaCientificos.add((Cientifico) e);
            if (e instanceof Mision)      listaMisiones.add((Mision) e);
            if (e instanceof Contenedor)  listaContenedores.add((Contenedor) e);
        }
    }

    @FXML public void limpiarCampos() {
        txtId.clear(); txtNombre.clear();
        txtExtra1.clear(); txtExtra2.clear(); txtExtra3.clear();
        cmbAstronauta.getSelectionModel().clearSelection();
        cmbCientifico.getSelectionModel().clearSelection();
        cmbSuelo.getSelectionModel().clearSelection();
        cmbPlaneta.getSelectionModel().clearSelection();
        cmbMision.getSelectionModel().clearSelection();
        cmbContenedor.getSelectionModel().clearSelection();
        tabla.getSelectionModel().clearSelection();
        lblEstado.setText("");
    }

    private void cargarEnCampos(Entidad e) {
        if (e instanceof Astronauta) {
            activarModoAstronauta();
            Astronauta a = (Astronauta) e;
            txtId.setText(a.getId()); txtNombre.setText(a.getNombre());
            txtExtra1.setText(a.getAgenciaEspacial()); txtExtra2.setText(a.getRango());

        } else if (e instanceof Cientifico) {
            activarModoCientifico();
            Cientifico c = (Cientifico) e;
            txtId.setText(c.getId()); txtNombre.setText(c.getNombre());
            txtExtra1.setText(c.getEspecialidad());
            txtExtra2.setText(String.valueOf(c.getExperienciaAnios()));

        } else if (e instanceof Mision) {
            activarModoMision();
            Mision m = (Mision) e;
            txtId.setText(m.getId()); txtNombre.setText(m.getNombre());
            txtExtra1.setText(m.getObjetivo()); txtExtra2.setText(m.getEncargado());
            txtExtra3.setText(m.getBeneficio()); cmbPlaneta.setValue(m.getPlaneta());

        } else if (e instanceof Nave) {
            activarModoNave();
            Nave n = (Nave) e;
            txtId.setText(n.getId()); txtNombre.setText(n.getNombre());
            txtExtra1.setText(n.getMaterial());
            txtExtra2.setText(String.valueOf(n.getVelocidad()));
            txtExtra3.setText(n.getFechadecreacion()); cmbMision.setValue(n.getMision());

        } else if (e instanceof Contenedor) {
            activarModoContenedor();
            Contenedor c = (Contenedor) e;
            txtId.setText(c.getId()); txtNombre.setText(c.getNombre());
            txtExtra1.setText(c.getTipo()); txtExtra2.setText(c.getMarca());

        } else if (e instanceof Muestra) {
            activarModoMuestra();
            Muestra m = (Muestra) e;
            txtId.setText(m.getId()); txtNombre.setText(m.getNombre());
            txtExtra1.setText(m.getTipoMuestra()); txtExtra2.setText(m.getEstado());
            cmbAstronauta.setValue(m.getRecolector());
            cmbCientifico.setValue(m.getAnalizador());
            cmbSuelo.setValue(m.getSuelo());
        }
    }

    private void ocultarTodosCombos() {
        ocultar(cmbAstronauta, lblCmbAstronauta);
        ocultar(cmbCientifico,  lblCmbCientifico);
        ocultar(cmbSuelo,       lblCmbSuelo);
        ocultar(cmbPlaneta,     lblCmbPlaneta);
        ocultar(cmbMision,      lblCmbMision);
        ocultar(cmbContenedor,  lblCmbContenedor);
        mostrar(txtExtra2, lblExtra2);
    }

    private void ocultar(javafx.scene.Node n, javafx.scene.Node l) {
        n.setVisible(false); n.setManaged(false);
        l.setVisible(false); l.setManaged(false);
    }

    private void mostrar(javafx.scene.Node n, javafx.scene.Node l) {
        n.setVisible(true); n.setManaged(true);
        l.setVisible(true); l.setManaged(true);
    }

    private String f(TextField t) { return t.getText().trim(); }

    private boolean vacios(String... campos) {
        for (String c : campos) {
            if (c == null || c.isEmpty()) {
                estado("⚠ Completa todos los campos obligatorios", true); return true;
            }
        }
        return false;
    }

    private boolean idExiste(String id) {
        if (crud.leer(id) != null) {
            estado("⚠ Ya existe una entidad con ese ID: " + id, true); return true;
        }
        return false;
    }

    private void estado(String msg, boolean esError) {
        lblEstado.setText(msg);
        lblEstado.setStyle(esError ? "-fx-text-fill: #cc3300;" : "-fx-text-fill: #007700;");
    }
}