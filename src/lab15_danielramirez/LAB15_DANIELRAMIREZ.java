package lab15_danielramirez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LAB15_DANIELRAMIREZ extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
        //PRUEBA ACTUALIZACION GIT
        //SEGUNDA PRUEBA, PARA EL PULL USANDO CMD
        //TERCERA PRUEBA, PARA EL PUSH USANDO CMD
        //CUARTA PRUEBA, PARA EL PULL USANDO NETBEANS
        //QUINTA PRUEBA, PARA EL PUSH USANDO NETBEANS
    }
    
}
