/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecryptiontool;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enric
 */
public class EcryptionToolFXMLDocumentController implements Initializable {

    @FXML
    private Button encrypt;
    @FXML
    private Button decrypt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void movetoencrypt(MouseEvent event) throws IOException {
       FXMLLoader myLoader = new FXMLLoader(getClass().getResource("encrypt.fxml"));
          GridPane root = (GridPane) myLoader.load();
          EncryptController e = myLoader.<EncryptController>getController();
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.setTitle("Ecryption Page");
          stage.show();
    }

    @FXML
    private void movetodecrypt(MouseEvent event) throws IOException {
         FXMLLoader myLoader = new FXMLLoader(getClass().getResource("decrypt.fxml"));
          GridPane root = (GridPane) myLoader.load();
          DecryptController e = myLoader.<DecryptController>getController();
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.setTitle("Decryption Page");
          stage.show();
    }
    
}
