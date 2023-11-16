package proyecto.controllers;

import proyecto.application.Aplicacion;
import proyecto.model.Actividad;

import static proyecto.controllers.AppController.INSTANCE;

public class TareasAdminController {
    Aplicacion aplicacion;

    Actividad actividad = INSTANCE.getHerramienta().getActividadActual();


    private void loadTable(){
//        tableTareas.getItems().clear();
//        tableTareas.getItems().addAll(actividad.getTareas());
    }

    public void initialize() {
        loadTable();
    }

    public void crearTarea(){
//        try {
//            String nombre = txtNombre.getText();
//            String descripcion = txtDescripcion.getText();
//            Integer tiempo = Integer.parseInt(txtTiempo.getText());
//            actividad.crearTarea(nombre, descripcion, tiempo);
//            loadTable();
//        } catch (NumberFormatException e) {
//            ShowMessage.showErrorMessage("Error", "El tiempo debe ser un numero");
//        } catch (IncompleteDataException e) {
//            ShowMessage.showErrorMessage("Error", "Faltan datos");
//        } catch (ActivityDontExistException e) {
//            ShowMessage.showErrorMessage("Error", "La actividad no existe");
//        } catch (ActivityAlreadyExistException e) {
//            ShowMessage.showErrorMessage("Error", "La tarea ya existe");
//        }
    }
    public void eliminarTarea(){
//        Tarea tarea = tableTareas.getSelectionModel().getSelectedItem();
//        if(tarea != null){
//            actividad.eliminarTarea(tarea);
//            loadTable();
//        }
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
