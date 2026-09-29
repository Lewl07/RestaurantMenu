package leo.restaurantmenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
        VBox root = new VBox();
        
        ComboBox<String> Beverage = new ComboBox<String>();
        ComboBox<String> Appetizer = new ComboBox<String>();
        ComboBox<String> mainCourse = new ComboBox<String>();
        ComboBox<String> dessert = new ComboBox<String>();
        
        Slider tipSlider = new Slider(0, 20, 0);
        Label tipLabel = new Label("Tip: 0%");
        Label subtotalLabel = new Label("Subtotal: $0.00");
        Label taxLabel = new Label("Tax: $0.00");
        Label tipAmountLabel = new Label("Tip: $0.00");
        Label totalLabel = new Label("Total: $0.00");
    }

    public static void main(String[] args) {
        launch();
    }

}