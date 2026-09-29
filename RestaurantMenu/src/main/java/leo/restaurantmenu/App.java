package leo.restaurantmenu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 * 
 * @author Leo Ho 
 * Git repo: https://github.com/Lewl07/RestaurantMenu.git
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        
        VBox vbBeverage = new VBox(10);
        VBox vbAppetizer = new VBox(10);
        VBox vbMainCourse = new VBox(10);
        VBox vbDessert = new VBox(10);
        
        ComboBox<String> beverage = new ComboBox<String>();
        ComboBox<String> appetizer = new ComboBox<String>();
        ComboBox<String> mainCourse = new ComboBox<String>();
        ComboBox<String> dessert = new ComboBox<String>();
        
        String[] beverages = {"Coffee", "Tea", "Soft Drink", "Water", "Milk",
        "Juice"};
        String[] appetizers = {"Soup", "Salad", "Spring Rolls", "Garlic Bread",
        "Chips and Salsa"};
        String[] mCourses = {"Steak", "Grilled Chicken", "Chicken Alfredo",
        "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips"};
        String[] desserts = {"Apple Pie", "Carrot Cake", "Mud Pie", "Pudding",
        "Apple Crisp"};
        
        double[] beveragePrices = {2.50, 2.00, 1.75, 2.95, 1.50, 2.50};
        double[] appetizerPrices = {4.50, 3.75, 5.25, 3.00, 6.95};
        double[] mCoursePrices = {15.00, 13.50, 13.95, 11.90, 18.99, 11.75,
            12.25};
        double[] dessertPrices = {5.95, 4.50, 4.75, 3.25, 5.98};
        
        beverage.setItems(FXCollections.observableArrayList(beverages));
        appetizer.setItems(FXCollections.observableArrayList(appetizers));
        mainCourse.setItems(FXCollections.observableArrayList(mCourses));
        dessert.setItems(FXCollections.observableArrayList(desserts));
        
        Slider tipSlider = new Slider(0, 20, 0);
        Label tipLabel = new Label("Tip: 0%");
        Label subTotalLabel = new Label("Subtotal: $0.00");
        Label taxLabel = new Label("Tax: $0.00");
        Label tipAmountLabel = new Label("Tip: $0.00");
        Label totalLabel = new Label("Total: $0.00");
        
        double[] subtotal = {0.00};
        double taxRate = 0.15;
        
        beverage.setOnAction(e -> {
            int i = beverage.getSelectionModel().getSelectedIndex();
            subtotal[0] += beveragePrices[i];
        });
        
        appetizer.setOnAction(e -> {
            int i = appetizer.getSelectionModel().getSelectedIndex();
            subtotal[0] += appetizerPrices[i];
        });
        
        mainCourse.setOnAction(e -> {
            int i = mainCourse.getSelectionModel().getSelectedIndex();
            subtotal[0] += mCoursePrices[i];
        });
        
        dessert.setOnAction(e -> {
            int i = dessert.getSelectionModel().getSelectedIndex();
            subtotal[0] += dessertPrices[i];
        });
        
        tipSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> {
            String tipValue = String.format("Tip: %.0f%%", newValue);
            String subtotalValue = String.format("Subtotal: $%.2f", subtotal[0]);
            
            double taxValue = subtotal[0] * taxRate;
            String taxFormatted = String.format("Tax: $%.2f", taxValue);
            
            double tipAmount = subtotal[0] * (newValue.doubleValue() / 100.00);
            String tipFormatted = String.format("Tip: $%.2f", tipAmount);
            
            double totalPrice = subtotal[0] + taxValue + tipAmount;
            String totalFormatted = String.format("Total: $%.2f", totalPrice);
            
            tipLabel.setText(tipValue);
            subTotalLabel.setText(subtotalValue);
            taxLabel.setText(taxFormatted);
            tipAmountLabel.setText(tipFormatted);
            totalLabel.setText(totalFormatted);
        });
        
        Button clearBtn = new Button("Clear Bill");
        clearBtn.setOnAction(e -> {
            subtotal[0] = 0.00;
            tipSlider.setValue(0);
            beverage.setSelectionModel(null);
            appetizer.setSelectionModel(null);
            mainCourse.setSelectionModel(null);
            dessert.setSelectionModel(null);
        });

        VBox calc = new VBox(10);
        calc.getChildren().addAll(tipSlider, tipLabel, subTotalLabel, taxLabel,
                tipAmountLabel, totalLabel, clearBtn);
        
        vbBeverage.getChildren().addAll(beverage);
        vbAppetizer.getChildren().addAll(appetizer);
        vbMainCourse.getChildren().addAll(mainCourse);
        vbDessert.getChildren().addAll(dessert);
        
        root.getChildren().addAll(vbBeverage, vbAppetizer,
                vbMainCourse, vbDessert, calc);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}