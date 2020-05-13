package lab15_danielramirez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import control.ControladorItems;
import entity.Item;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label tituloLabel;
    @FXML
    private TextField supTextField;
    @FXML
    private Spinner<Integer> numSpinner = new Spinner<>();
    @FXML
    private TextField infTextField;
    @FXML
    private Button agregarButton;
    @FXML
    private ChoiceBox<String> listaChoiceBox = new ChoiceBox<>();
    @FXML
    private Button borrarButton;
    @FXML
    private TableView<Item> tablaTableView = new TableView<>();
    @FXML
    private TableColumn<Item, String> articuloTableColumn = new TableColumn<>();
    @FXML
    private TableColumn<Item, String> cantidadTableColumn = new TableColumn<>();
    @FXML
    private TableColumn<Item, String> p_unitarioTableColumn = new TableColumn<>();
    @FXML
    private TableColumn<Item, String> precioTableColumn = new TableColumn<>();
    @FXML
    private Label subTotalLabel;
    @FXML
    private Label ivaLabel;
    @FXML
    private Label totalLabel;

    //RELACIONES
    private ControladorItems control = new ControladorItems();

    @FXML
    private void handleAgregar(ActionEvent event) {
        String nombre = supTextField.getText();
        int cantidad = numSpinner.getValue();
        int precioUnitario = Integer.parseInt(infTextField.getText());
        
        control.agregarItem(nombre, cantidad, precioUnitario);//AGREGUEMOS EL NUEVO ITEM EN CONTROLADOR ITEMS

        //SE MUESTRA ALERTA DE EXITO
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exito");
        alert.setHeaderText("El item ha sido agregado correctamente! :v");
        alert.setContentText("En el sistema hay " + control.getItems().size() + " item(s) diferente(s).");
        alert.showAndWait();
        clearItems();
        fillItems();
        
        //SE CALCULAN TOTALES Y SE MUESTRAN
        
        String subTotal = String.valueOf(control.calcularSubTotal());
        String iva = String.valueOf(control.calcularIva());
        String total = String.valueOf(control.calcularTotal());
        
        subTotalLabel.setText(subTotal);
        ivaLabel.setText(iva);
        totalLabel.setText(total);
        
    }

    @FXML
    private void handleBorrar(ActionEvent event) {
        String nombre = listaChoiceBox.getValue();
        boolean borrado = control.borrarItem(nombre);
        
        if (borrado) { //SI SI SE PUDO BORRAR EL ITEM
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("El item <<" + nombre + ">> ha sido borrado correctamente! :v");
            alert.showAndWait();
            clearItems();
            fillItems();
        } else { //SI NO SE PUDO BORRAR EL ITEM
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No es posible borrar el item! :( ");
            alert.showAndWait();
        }
        
        //SE CALCULAN TOTALES Y SE MUESTRAN
        
        String subTotal = String.valueOf(control.calcularSubTotal());
        String iva = String.valueOf(control.calcularIva());
        String total = String.valueOf(control.calcularTotal());
        
        subTotalLabel.setText(subTotal);
        ivaLabel.setText(iva);
        totalLabel.setText(total);
    }

    private void crearAlerta(AlertType tipo, String titulo, String tituloInterno, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(tituloInterno);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void fillItems() { //LLENA lA TABLA CON LA INFROMACION A CTUALIZADA A CADA RATO
        for (Item item : control.getItems().values()) {
            //Llenar la tabla
            tablaTableView.getItems().add(item);
            //llenar el choicebox
            listaChoiceBox.getItems().add(item.getNombre());
        }
    }

    private void clearItems() { //BORRA LA TABLA DE LOS ITEMS QUE YA NO ESTAN EN ELLA
        listaChoiceBox.getItems().clear();
        tablaTableView.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //SE INDICA EL RANGO EN EL QUE VA A TRABAJAR EL SPINNER
        SpinnerValueFactory<Integer> rangoValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 1);
        numSpinner.setValueFactory(rangoValueFactory);

        fillItems();
        tablaTableView.getColumns().addAll(articuloTableColumn, cantidadTableColumn, p_unitarioTableColumn, precioTableColumn); //SE LE METEN LAS COLUMNAS A LA TABLA
    }

}
