package ma.enset.examen.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Livre;
import ma.enset.examen.services.IBibliothequeMetier;
import ma.enset.examen.services.IBibliothequeMetierImp;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class LivreController implements Initializable {
    @FXML
    private TextField  titre;
    @FXML
    private TextField isbn;
    @FXML
    private TextField date;
    @FXML
    private TableView<Livre> tableLivre;
    @FXML
    private TableColumn<Livre,String> cTitre;
    @FXML
    private TableColumn<Livre,String> cIsbn;
    @FXML
    private TableColumn<Livre, Date> cDate;
    ObservableList<Livre> livres = FXCollections.observableArrayList();
    IBibliothequeMetier iBibliothequeMetier = new IBibliothequeMetierImp();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        cIsbn.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
        cDate.setCellValueFactory(new PropertyValueFactory<>("dateE"));
        tableLivre.setItems(livres);
        load();
    }
    public  void  ajouter(){
        String t = titre.getText();
        String i = isbn.getText();
        String date1 = date.getText();
        Livre cl = new Livre();
        cl.setTitre(t);
        cl.setIsbn(i);
        cl.setDateE(Date.valueOf(date1));
        iBibliothequeMetier.addLivre(cl);
        load();
    }
    public void delete(){
        Livre c = tableLivre.getSelectionModel().getSelectedItem();
        iBibliothequeMetier.deleteLivre(c);
        load();
    }
    public void load(){
        livres.clear();
        livres.addAll(iBibliothequeMetier.getAllLivre());
    }
}
