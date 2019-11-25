

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import javax.swing.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class SampleController implements Initializable {


final ObservableList<masina> data = FXCollections.observableArrayList(

new masina("Audi","A6","500"),
        new masina("Audi","A6","500"),
        new masina("Audi","A8","5010"),
        new masina("BMW","X5","9000")

) ;





    @FXML
    private GridPane Lentele8;

    @FXML
    private Text Tekstas_00;

    @FXML
    private TextField Marke_Laukas;

    @FXML
    private TextField Modelis_Laukas;

    @FXML
    private TextField Kaina_Laukas;

    @FXML
    private GridPane Sarasas;

    @FXML
    private TableView<masina> lentele;

    @FXML
    private Text Netitikimas;

    @FXML
    private Text Laikas;


    @FXML
    private Text Pinigai_Laukas;


    private Pirkejas pirkejas1=  new Pirkejas(5000,"Egidijus");
    private double current_money = pirkejas1.getPinigai();






    @FXML
    void Ideti(ActionEvent event) throws VisiLaukaiException  {



        if(Marke_Laukas.getText().trim().isEmpty() ) {

            throw new VisiLaukaiException("Neuzpildei markes");

        }

        else if(Modelis_Laukas.getText().trim().isEmpty()) {

        throw new VisiLaukaiException("Modelis turi but ivestas");}

        else if(Kaina_Laukas.getText().trim().isEmpty()){

            throw new VisiLaukaiException("Kaina turi buti ivesta");
        }

        else if (Marke_Laukas.getText().trim().isEmpty()||Modelis_Laukas.getText().trim().isEmpty()||Kaina_Laukas.getText().trim().isEmpty()){

        throw new VisiLaukaiException("Uzpildykite laukus");

        }

        else {

                data.add(new masina(Marke_Laukas.getText(), Modelis_Laukas.getText(), Kaina_Laukas.getText()));
            Netitikimas.setText("Skelbimas ikeltas");
        }


    }


    @FXML
    void Istrinti(ActionEvent event) {

        Netitikimas.setText("Nepasirinkai ka nori istrinti");


        for(masina masina: lentele.getSelectionModel().getSelectedItems()){

                Netitikimas.setText("Skelbimas pasalintas");
                data.remove(masina);
            }       }



    @FXML
    void Pirkti(ActionEvent event) {


        Netitikimas.setText("Nepasirinkai ka nori istrinti");


        for(masina masina: lentele.getSelectionModel().getSelectedItems()){


            if((current_money -= Double.parseDouble(masina.getKaina())) < 0) {
                JOptionPane.showMessageDialog(null, "nera lesu");
                //current_money -= Double.parseDouble(masina.getKaina());
            }else {

                JOptionPane.showMessageDialog(null, "likuts:" + current_money);
                Netitikimas.setText("Skelbimas pasalintas");
                data.remove(masina);

                Pinigai_Laukas.setText("Pirkejas:" + pirkejas1.getVardas()+  " Tavo turimi pinigai:"+current_money);
            }       }






    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lentele.setEditable(true);
        TableColumn firstNameCol = new TableColumn("Marke");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<masina ,String>("marke"));

        TableColumn firstNameCol2 = new TableColumn("Modelis");
        firstNameCol2.setMinWidth(100);
        firstNameCol2.setCellValueFactory(
                new PropertyValueFactory<masina ,String>("modelis"));

        TableColumn firstNameCol3 = new TableColumn("Kaina");
        firstNameCol3.setMinWidth(100);
        firstNameCol3.setCellValueFactory(
                new PropertyValueFactory<masina ,String>("kaina"));


        lentele.setItems(data);
        lentele.getColumns().addAll(firstNameCol,firstNameCol2,firstNameCol3);


//Tiesiog data

                Date Laikas1 = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String reportDate = formatter.format(Laikas1);


                Laikas.setText(reportDate);



            Pinigai_Laukas.setText("Pirkejas:" + pirkejas1.getVardas()+  " Tavo turimi pinigai:"+current_money);







    }
}

