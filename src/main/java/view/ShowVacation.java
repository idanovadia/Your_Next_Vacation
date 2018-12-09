package view;

import Contrroller.MasterController;
import Entities.Vacation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ShowVacation implements Initializable {
    //list vacation
    private ArrayList<List<String>> vacation;
    //mc - singleton
    private MasterController mc;
    //
    public AnchorPane ancer_show;
    private StackPane paneDialog ;
    private JFXDialog dialog;
    //vacation 1
    public AnchorPane ancer_1;
    public Button buttonBuy_1;
    public ImageView image_1;
    public Label price_1;
    public Label location_1;
    public Label date_1;
    //vacation 2
    public AnchorPane ancer_2;
    public Button buttonBuy_2;
    public ImageView image_2;
    public Label price_2;
    public Label location_2;
    public Label date_2;
    //vacation 3
    public AnchorPane ancer_3;
    public Button buttonBuy_3;
    public ImageView image_3;
    public Label price_3;
    public Label location_3;
    public Label date_3;
    //vacation 4
    public AnchorPane ancer_4;
    public Button buttonBuy_4;
    public ImageView image_4;
    public Label price_4;
    public Label location_4;
    public Label date_4;
    //do next or back
    public Button button_back;
    public Button button_next;
    private boolean nextPage = true;
    private boolean backPage = false;
    int vacIndex = 0;
    //Deals
    public ImageView image_deal1;
    public ImageView image_deal2;
    public Label price_deal1;
    public Label price_deal2;
    public Label location_deal1;
    public Label location_deal2;
    public Label label_recommended;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = MasterController.getInstance();
        paneDialog = new StackPane();
        //initVec();
    }

    public void setVacation(ArrayList<List<String>> arrayList){
        vacation = arrayList;
    }

    public void initializeFileds() {
        Field[] f = Class.class.getDeclaredFields();
    }

    private void initVec() {



        if (vacation.size() > vacIndex) {
            price_1.setText("price: " + vacation.get(vacIndex).get(4));
            location_1.setText(vacation.get(vacIndex).get(2));
            date_1.setText("from " + vacation.get(vacIndex).get(5) + " to " + vacation.get(vacIndex).get(6));
        }
        else{
            ancer_1.setVisible(false);
        }

        setNextIndexVec(vacIndex);

        if (vacation.size() > vacIndex) {
            price_2.setText("price: " + vacation.get(vacIndex).get(4));
            location_2.setText(vacation.get(vacIndex).get(2));
            date_2.setText("from " + vacation.get(vacIndex).get(5) + " to " + vacation.get(vacIndex).get(6));

        }
        else{
            ancer_2.setVisible(false);
        }

        setNextIndexVec(vacIndex);

        if (vacation.size() > vacIndex) {
            price_3.setText("price: " + vacation.get(vacIndex).get(4));
            location_3.setText(vacation.get(vacIndex).get(2));
            date_3.setText("from " + vacation.get(vacIndex).get(5) + " to " + vacation.get(vacIndex).get(6));

        }
        else{
            ancer_3.setVisible(false);
        }

        setNextIndexVec(vacIndex);

        if (vacation.size() > vacIndex) {
            price_4.setText("price: " + vacation.get(vacIndex).get(4));
            location_4.setText(vacation.get(vacIndex).get(2));
            date_4.setText("from " + vacation.get(vacIndex).get(5) + " to " + vacation.get(vacIndex).get(6));

        }
        else {
            ancer_4.setVisible(false);
        }

        setNextIndexVec(vacIndex);

        nextPage = false;
        backPage = false;
        //}
    }

    private void setNextIndexVec(int Index) {
        if (nextPage)
            vacIndex++;
        else
            vacIndex--;
    }

    public void backClick(javafx.event.ActionEvent event) {
        if(vacIndex>3){
            //initVec();
        }
    }

    public void nextClick(ActionEvent event){
        if(vacIndex<vacation.size()){
            //initVec();
        }
    }

    public void buyVacation() throws IOException {
        //ask for permission
        showInfoDialog();
    }

    public void showInfoDialog() {
        disOrableButtonsVacation(true);
        paneDialog = new StackPane();
        paneDialog.setPrefWidth(ancer_show.getPrefWidth()/2);
        paneDialog.setPrefHeight(ancer_show.getPrefHeight()/2);
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Buying Message"));
        content.setBody(new Text("Thank you for your order"+"\n"+"Message have been send to buyer for approve"));
        dialog = new JFXDialog(paneDialog, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                disOrableButtonsVacation(false);
            }
        });
        content.setActions(button);
        ancer_show.getChildren().add(paneDialog);
        dialog.show();
    }

    private void disOrableButtonsVacation(boolean b) {
        buttonBuy_1.setDisable(b);
        buttonBuy_2.setDisable(b);
        buttonBuy_3.setDisable(b);
        buttonBuy_4.setDisable(b);
        button_next.setDisable(b);
        button_back.setDisable(b);
    }



}
