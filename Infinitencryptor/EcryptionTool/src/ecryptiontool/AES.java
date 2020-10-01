/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecryptiontool;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author enric
 * */
public class AES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Error");
         alert.setHeaderText("An error has ocurred. Use another input/key");
         alert.setContentText("");
         ButtonType buttonOK = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
         alert.getButtonTypes().setAll(buttonOK);
         Optional<ButtonType> result = alert.showAndWait();
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Error");
         alert.setHeaderText("An error has ocurred. Use another input/key");
         alert.setContentText("");
         ButtonType buttonOK = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
         alert.getButtonTypes().setAll(buttonOK);
         Optional<ButtonType> result = alert.showAndWait();
        }
        return null;
    }
}
