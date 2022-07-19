package com.praktikum3.praktikum3.controller;

import com.praktikum3.praktikum3.entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SupplierController {
    public TextField idSupplier;
    public TextField namaSupplier;
    public TextField alamatSupplier;
    public Button saveSupplier;
    public Button resetSupplier;
    public Button updateSupplier;
    public TableView<Supplier> tableSupplier;
    public TableColumn idColSupplier;
    public TableColumn namaColSupplier;
    public TableColumn alamatColSupplier;

    public ObservableList<Supplier> getSupplierList() {
        return supplierList;
    }
    private ObservableList<Supplier> supplierList;

    private BarangController barang;

    public void initialize(){
        updateSupplier.setDisable(true);
        supplierList = FXCollections.observableArrayList(
                new Supplier(1,"bejo","neraka")
        );
        tableSupplier.setItems(supplierList);
        idColSupplier.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaColSupplier.setCellValueFactory(new PropertyValueFactory<>("nama"));
        alamatColSupplier.setCellValueFactory(new PropertyValueFactory<>("alamat"));
    }

    public void saveSuppliler(ActionEvent actionEvent) {
        supplierList.add(new Supplier(Integer.parseInt(idSupplier.getText()),namaSupplier.getText(),alamatSupplier.getText()));
        resetSupplier();
    }

    public void resetSupplier() {
        idSupplier.setText("");
        namaSupplier.setText("");
        alamatSupplier.setText("");
    }

    public void updateSupplier(ActionEvent actionEvent) {
        tableSupplier.getSelectionModel().getSelectedItem().setNama(namaSupplier.getText());
        tableSupplier.getSelectionModel().getSelectedItem().setAlamat(alamatSupplier.getText());
        tableSupplier.refresh();
        saveSupplier.setDisable(false);
        updateSupplier.setDisable(true);
        resetSupplier.setDisable(false);
        idSupplier.setDisable(false);
        resetSupplier();
    }

    public void selectedSupplier(MouseEvent mouseEvent) {
        if(!tableSupplier.getSelectionModel().getSelectedCells().isEmpty()){
            saveSupplier.setDisable(true);
            updateSupplier.setDisable(false);
            resetSupplier.setDisable(true);
            idSupplier.setDisable(true);
        }
        idSupplier.setText(String.valueOf(tableSupplier.getSelectionModel().getSelectedItem().getId()));
        namaSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getNama());
        alamatSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getAlamat());
    }
}
