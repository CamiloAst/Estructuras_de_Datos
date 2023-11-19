package proyecto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.exceptions.AccesDeniedException;
import proyecto.model.Herramienta;
import proyecto.model.Proceso;
import proyecto.model.TipoUsuario;
import proyecto.model.Usuario;
import proyecto.utils.ShowMessage;

import static proyecto.controllers.AppController.INSTANCE;


public class ProcesosController {

    Aplicacion aplicacion;

    Herramienta herramienta = INSTANCE.getHerramienta();
    Usuario usuario;

    @FXML
    private Label abrirActividades;

    @FXML
    private Label actualizarProceso;

    @FXML
    private Label cerrarSesion;

    @FXML
    private TableColumn<Proceso, String> columnId;

    @FXML
    private TableColumn<Proceso, String> columnNombre;

    @FXML
    private TableColumn<Proceso, Integer> columnTiempoMaximo;

    @FXML
    private TableColumn<Proceso, Integer> columnTiempoMinimo;

    @FXML
    private Label crearProceso;

    @FXML
    private Label eliinarProceso;

    @FXML
    private ImageView iconCerrarSesion;

    @FXML
    private TableView<Proceso> tableProcesos;

    @FXML
    private TextField txtNombreProceso;

    @FXML
    private Label nombreUsuario;

    @FXML
    private ImageView iconAbrir;

    @FXML
    private ImageView iconActualizar;

    @FXML
    private ImageView iconCrear;

    @FXML
    private ImageView iconEliminar;

    @FXML
    private ImageView iconConfiguracion;

    Object procesoSeleccion;
    ObservableList<Proceso> listaProcesosData = FXCollections.observableArrayList();

    private void obtenerNombreVendedor(){
        String nombre= INSTANCE.getUsuarioActual().getNombreUsuario();
        nombreUsuario.setText(nombre);
    }

    @FXML
    void abiriActiviadesAction(MouseEvent event) {
        if (procesoSeleccion != null) {
            INSTANCE.setProcesoActual((Proceso) procesoSeleccion);
            aplicacion.mostrarVentanaActividadesAdmin();

        }
    }

    @FXML
    void cerrarSesionAction(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void crearProcesoAction(MouseEvent event) {
        try {
            if (verificarPermisos())
                herramienta.createProcess(txtNombreProceso.getText(),
                    String.valueOf(herramienta.getListaProcesos().size()));
        } catch (AccesDeniedException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear proceso", "No tiene permisos para crear procesos");
        }
        rechargeTable();
    }

    @FXML
    void elimiarProcesoAction(MouseEvent event) {
        try {
            if(verificarPermisos()) {
                if(procesoSeleccion != null)
                    herramienta.deleteProcess(((Proceso) procesoSeleccion).getNombre());
                else
                    herramienta.deleteProcess(txtNombreProceso.getText());
            }
        } catch (AccesDeniedException e) {
            throw new RuntimeException(e);
        }
        rechargeTable();
    }

    @FXML
    void configuracionAction(MouseEvent event) {
        aplicacion.mostrarVentanaConfiguracion();

    }
    public Boolean verificarPermisos() throws AccesDeniedException {
        if(INSTANCE.getUsuarioActual().getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR))
            return true;
        throw new AccesDeniedException();
    }
    @FXML
    void initialize() {
        assert abrirActividades != null : "fx:id=\"abrirActividades\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert actualizarProceso != null : "fx:id=\"actualizarProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert cerrarSesion != null : "fx:id=\"cerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnNombre != null : "fx:id=\"columnNombre\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnTiempoMaximo != null : "fx:id=\"columnTiempoMaximo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnTiempoMinimo != null : "fx:id=\"columnTiempoMinimo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert crearProceso != null : "fx:id=\"crearProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert eliinarProceso != null : "fx:id=\"eliinarProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert iconCerrarSesion != null : "fx:id=\"iconCerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert txtNombreProceso != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";

        loadTable();
        tableProcesos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                procesoSeleccion = newSelection;
            }
        });
    }

    private void loadTable() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTiempoMinimo.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracionMin"));
        columnTiempoMaximo.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracionMax"));

        listaProcesosData.clear();
        listaProcesosData.addAll(herramienta.getListaProcesos());
        tableProcesos.setItems(listaProcesosData);

        System.out.println(herramienta.getListaProcesos().get(0).getTiempoDuracionMax());
    }

    private void rechargeTable(){
        listaProcesosData.clear();
        listaProcesosData.addAll(herramienta.getListaProcesos());
        tableProcesos.setItems(listaProcesosData);
    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
