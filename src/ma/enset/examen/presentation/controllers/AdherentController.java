package ma.enset.examen.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.services.IBibliothequeMetier;
import ma.enset.examen.services.IBibliothequeMetierImp;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AdherentController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField cin;
    @FXML
    private TextField date;
    @FXML
    private TableView<Adherent> tableAdherent;
    @FXML
    private TableColumn<Adherent,String> cNom;
    @FXML
    private TableColumn<Adherent,String> cPrenom;

    @FXML
    private TableColumn<Adherent,String> cEmail;
    @FXML
    private TableColumn<Adherent,String> cTele;
    @FXML
    private TableColumn<Adherent,String> cCin;
    @FXML
    private TableColumn<Adherent,String> cNaissance;
    ObservableList<Adherent> adherents = FXCollections.observableArrayList();
    IBibliothequeMetier iBibliothequeMetier = new IBibliothequeMetierImp();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cTele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        cNaissance.setCellValueFactory(new PropertyValueFactory<>("dateN"));
        tableAdherent.setItems(adherents);
        load();
    }
    public  void  ajouter(){
        String cNom = nom.getText();
        String cPrenom = prenom.getText();
        String cEmail = email.getText();
        String cTele = phone.getText();
        String date1 = date.getText();
        String Cin = cin.getText();
        Adherent cl = new Adherent();
            cl.setNom(cNom);
            cl.setPrenom(cPrenom);
            cl.setEmail(cEmail);
            cl.setTelephone(cTele);
            cl.setCin(Cin);
            cl.setDateN(Date.valueOf(date1));
            iBibliothequeMetier.addAdherent(cl);
            load();
    }
    public void delete(){
        Adherent c = tableAdherent.getSelectionModel().getSelectedItem();
        iBibliothequeMetier.deleteAdherent(c);
        load();
    }
    public  void load(){
        adherents.clear();
        adherents.addAll(iBibliothequeMetier.getAllAdherent());
    }
}
