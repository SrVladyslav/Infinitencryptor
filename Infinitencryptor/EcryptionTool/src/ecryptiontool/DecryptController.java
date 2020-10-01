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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enric
 */
public class DecryptController implements Initializable {

    @FXML
    private Button decryptbutton;
    @FXML
    private TextField decryptoutput;
    @FXML
    private TextField decryptinput;
    @FXML
    private TextField decryptkey;
    @FXML
    private Button decryptback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void decryption(MouseEvent event) {
        String Clave = decryptkey.getText();
        String inputString = decryptinput.getText();
        String decryptedString = AES.decrypt(inputString, Clave);
        decryptoutput.setText(decryptedString) ;
    }

    @FXML
    private void decryptgoback(MouseEvent event) throws IOException {
          FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Entrada.fxml"));
          GridPane root = (GridPane) myLoader.load();
          EcryptionToolFXMLDocumentController e = myLoader.<EcryptionToolFXMLDocumentController>getController();
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.show();
          ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
