/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author badar
 */
public class LoginController implements Initializable {
    
    
    @FXML
    private Label label;

    @FXML
    
    private JFXTextField username;

    @FXML
    private JFXTextField password;
    
    @FXML
    public ImageView loginListeners;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RequiredFieldValidator fieldValidator = new RequiredFieldValidator();
        NumberValidator numberValidator = new NumberValidator();
        
        username.getValidators().add(fieldValidator);
        fieldValidator.setMessage("No input is given!");
        
        password.getValidators().add(numberValidator);
        numberValidator.setMessage("No input is given!");
        
        username.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    username.validate();
                }
            }
        });
        
        password.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    password.validate();
                }
            }
        });
    }
    
    @FXML
    void mouseClickLoginGuiHided(MouseEvent event) {
        
    }
    
      
}

    
