/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecryptiontool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
//hola

/**
 * FXML Controller class
 *
 * @author enric
 */
public class EncryptController implements Initializable {

    @FXML
    private TextField encryptinput;
    @FXML
    private Button encryptbutton;
    @FXML
    private TextField encryptoutput;
    @FXML
    private TextField encryptkey;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Encryption(MouseEvent event) {
        String Clave = "31";
        String inputString = encryptinput.getText();
        String encryptedString = AES.encrypt(inputString, Clave);
        encryptoutput.setText(encryptedString) ;
    }
    
}

 
