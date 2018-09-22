package be.pxl.computerstore.gui;

import be.pxl.computerstore.data.ComputerComponentTypes;
import be.pxl.computerstore.data.Warehouse;
import be.pxl.computerstore.hardware.*;
import be.pxl.computerstore.util.TooManyPeripheralsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ComputerConfiguratorController implements Initializable {
    @FXML
    ComboBox<ComputerComponentTypes> computerComponentTypes;
    @FXML
    ListView<ComputerComponent> computerComponentsListView;
    @FXML
    ListView<ComputerComponent> selectedComputerComponentsListView;
    @FXML
    TextArea computerComponentDescription;
    @FXML
    Label totalPriceLabel;
    @FXML
    Label totalPriceExclLabel;
    @FXML
    Alert informationBox;

    private ComputerSystem computerSystem = new ComputerSystem();

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ComputerComponentTypes> items = FXCollections.observableArrayList();
        items.addAll(Arrays.asList(ComputerComponentTypes.values()));
        computerComponentTypes.setItems(items);
    }

    public void computerComponentTypeChanged(ActionEvent actionEvent) {
        ObservableList<ComputerComponent> items = FXCollections.observableArrayList();
        switch (computerComponentTypes.getValue()) {
            case COMPUTER_CASES:
                items.addAll(Warehouse.computerCases);
                break;
            case HARD_DISK_DRIVES:
                items.addAll(Warehouse.hardDisks);
                break;
            case PROCESSORS:
                items.addAll(Warehouse.processors);
                break;
            case PERIPHERALS:
                items.addAll(Warehouse.peripherals);
                break;
        }
        computerComponentsListView.setItems(items);
        computerComponentDescription.setText("");
    }


    @FXML
    public void displayComputerComponentDetails(MouseEvent mouseEvent) {
        computerComponentDescription.setText(computerComponentsListView.getSelectionModel().getSelectedItem().getFullDescription());
    }

    @FXML
    public void addSelectedComputerComponent(ActionEvent actionEvent) {
        ComputerComponent component = computerComponentsListView.getSelectionModel().getSelectedItem();
        if (component instanceof ComputerCase) {
            computerSystem.setComputerCase((ComputerCase) component);
        } else if (component instanceof Processor) {
            computerSystem.setProcessor((Processor) component);
        } else if (component instanceof HardDisk) {
            computerSystem.setHardDisk((HardDisk) component);
        } else {
            try {
                computerSystem.addPeripheral((Peripheral) component);
            } catch (TooManyPeripheralsException e) {
                informationBox.setContentText("Only " + computerSystem.getNumberOfPeripherals() + " peripherals allowed.");
                informationBox.show();
            }
        }
        showComputerSystem();
    }

    private void showComputerSystem() {
        ObservableList<ComputerComponent> items = FXCollections.observableArrayList();
        if (computerSystem.getProcessor() != null) {
            items.add(computerSystem.getProcessor());
        }
        if (computerSystem.getComputerCase() != null) {
            items.add(computerSystem.getComputerCase());
        }
        if (computerSystem.getHardDisk() != null) {
            items.add(computerSystem.getHardDisk());
        }
        for (int i = 0; i < computerSystem.getNumberOfPeripherals(); i++) {
            items.add(computerSystem.getPeripherals()[i]);
        }
        totalPriceLabel.setText(String.valueOf(computerSystem.totalPriceIncl()));
        totalPriceExclLabel.setText(String.valueOf(computerSystem.totalPriceExcl()));
        selectedComputerComponentsListView.setItems(items);
    }

    @FXML
    public void restart(ActionEvent actionEvent) {
        computerSystem = new ComputerSystem();
        showComputerSystem();
    }
}
