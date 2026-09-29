package leo.restaurantmenu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
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
        
        tipSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> {
            tipLabel.setText("Tip: " + newValue + "%");
            subTotalLabel.setText("Subtotal: $" );    //
            taxLabel.setText("Tax: $" );    //      //
            tipAmountLabel.setText("Tip: $" );    //
            totalLabel.setText("Total: $" );    //
        });
        
        VBox calc = new VBox(10);
        calc.getChildren().addAll(tipSlider, tipLabel, subtotalLabel, taxLabel,
                tipAmountLabel, totalLabel);
        
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