package com.praktikum3.praktikum3.controller;

import com.praktikum3.praktikum3.HelloApplication;
import com.praktikum3.praktikum3.entity.Barang;
import com.praktikum3.praktikum3.entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BarangController {
    public TextField idBarang;
    public TextField namaBarang;
    public ComboBox supplier;
    public Button saveBarang;
    public Button resetBarang;
    public Button updateBarang;
    public MenuItem goSupplier;
    public MenuItem close;
    public TableView<Barang> tableBarang;
    public TableColumn idColBarang;
    public TableColumn namaColBarang;
    public TableColumn supplierColBarang;
    private Stage stage;
    private ObservableList<Barang> barangList;
    private ObservableList<Supplier> suppliers;
    public ObservableList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void initialize(){
        stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        updateBarang.setDisable(true);
        barangList = FXCollections.observableArrayList(
                new Barang(1,"bejo","test")
        );
        tableBarang.setItems(barangList);
        idColBarang.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaColBarang.setCellValueFactory(new PropertyValueFactory<>("nama"));
        supplierColBarang.setCellValueFactory(new PropertyValueFactory<>("supplier"));
    }

    public void goSupplier(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("supplier-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        if (stage.getOwner()==null) {
            stage.initOwner(idBarang.getScene().getWindow());
        }

        SupplierController allSuply = fxmlLoader.getController();
        suppliers = allSuply.getSupplierList();
        supplier.setItems(suppliers);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void selectedBarang(MouseEvent mouseEvent) {
        if(!tableBarang.getSelectionModel().getSelectedCells().isEmpty()){
            saveBarang.setDisable(true);
            updateBarang.setDisable(false);
            resetBarang.setDisable(true);
            idBarang.setDisable(true);
        }
        idBarang.setText(String.valueOf(tableBarang.getSelectionModel().getSelectedItem().getId()));
        namaBarang.setText(tableBarang.getSelectionModel().getSelectedItem().getNama());
        supplier.valueProperty().setValue(tableBarang.getSelectionModel().getSelectedItem().getSupplier());
    }

    public void saveBarang(ActionEvent actionEvent) {
        barangList.add(new Barang(Integer.parseInt(idBarang.getText()),namaBarang.getText(), String.valueOf(supplier.getValue())));
        resetBarang();
    }

    public void resetBarang() {
        idBarang.setText("");
        namaBarang.setText("");
        supplier.valueProperty().setValue(null);
    }

    public void updateBarang(ActionEvent actionEvent) {
        tableBarang.getSelectionModel().getSelectedItem().setNama(namaBarang.getText());
        tableBarang.getSelectionModel().getSelectedItem().setSupplier(String.valueOf(supplier.getValue()));
        tableBarang.refresh();
        saveBarang.setDisable(false);
        updateBarang.setDisable(true);
        resetBarang.setDisable(false);
        idBarang.setDisable(false);
        resetBarang();
    }
}
