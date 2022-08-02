import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Random;


public class App extends Application {


    @Override
    public void start(Stage stage) {
        HBox header = new HBox();
        header.setAlignment(Pos.TOP_CENTER);
        header.setPrefSize(830, 50);
        Text welcomeText = new Text("Welcome to iShop..");
        header.setStyle("-fx-background-color: black;");
        welcomeText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
        welcomeText.setFill(Color.WHITE);
        header.getChildren().add(welcomeText);

        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setSpacing(10);
        leftPane.setLayoutX(10);
        leftPane.setLayoutY(60);
        leftPane.setPrefSize(400, 400);
        leftPane.setStyle("-fx-border-color: green;");

        VBox rightPane = new VBox();
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setLayoutX(420);
        rightPane.setLayoutY(60);
        rightPane.setPrefSize(400, 300);

        HBox bottomPane = new HBox(100);
        bottomPane.setLayoutX(10);
        bottomPane.setLayoutY(500);
        bottomPane.setPrefSize(810, 90);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setStyle("-fx-background-color: black;");

        ListView<Items> listView = new ListView<>();
        TextField field = new TextField();
        field.setPromptText("Items quantity..");
        field.setPrefWidth(50);
        field.setStyle("-fx-border-color: black;");

        Items items = new Items();
        Random random = new Random();
        int randomNumber = random.nextInt();
        items.setBarcode("" + randomNumber);

        ObservableList<Items> itemsList = FXCollections.observableArrayList();
        itemsList.add(new Items(items.getBarcode(), "\tVanilla Cake    \t\t\t", 29.99));
        itemsList.add(new Items(items.getBarcode(), "\tChocolate Cake  \t\t", 33.49));
        itemsList.add(new Items(items.getBarcode(), "\tPineapple Cake  \t\t", 23.99));
        itemsList.add(new Items(items.getBarcode(), "\tMilk Cake       \t\t\t", 3.99));
        itemsList.add(new Items(items.getBarcode(), "\tSoft Drinks     \t\t\t", 2.99));
        itemsList.add(new Items(items.getBarcode(), "\tChicken Tender  \t\t", 7.99));
        itemsList.add(new Items(items.getBarcode(), "\tChicken Nuggets \t\t", 7.99));
        itemsList.add(new Items(items.getBarcode(), "\tMash Potatoes   \t\t", 3.99));
        itemsList.add(new Items(items.getBarcode(), "\tSundae          \t\t\t", 3.49));
        itemsList.add(new Items(items.getBarcode(), "\tChai Tea        \t\t\t", 2.49));
        itemsList.add(new Items(items.getBarcode(), "\tCoffee          \t\t\t\t", 2.49));
        itemsList.add(new Items(items.getBarcode(), "\tChicken Sandwich    \t", 5.99));
        itemsList.add(new Items(items.getBarcode(), "\tVanilla ice cream  \t\t", 1.49));
        itemsList.add(new Items(items.getBarcode(), "\tChicken Burrito \t\t", 9.99));
        itemsList.add(new Items(items.getBarcode(), "\tMilk Shake       \t\t\t", 2.99));
        itemsList.add(new Items(items.getBarcode(), "\tCheeseburger     \t\t", 4.99));
        itemsList.add(new Items(items.getBarcode(), "\tHamburger  \t\t\t", 4.99));
        itemsList.add(new Items(items.getBarcode(), "\tMuffins  \t\t\t\t", 1.99));
        itemsList.add(new Items(items.getBarcode(), "\tEgg Salad   \t\t\t\t", 9.99));
        itemsList.add(new Items(items.getBarcode(), "\tFried Rice          \t\t\t", 7.49));
        itemsList.add(new Items(items.getBarcode(), "\tOnion Rings        \t\t", 4.49));
        itemsList.add(new Items(items.getBarcode(), "\tDonuts          \t\t\t", 1.99));
        listView.setItems(itemsList);
        itemsList.sort(Comparator.comparing(Items::getName));

        ObservableList<Items> cartList = FXCollections.observableArrayList();
        ListView<Items> cart = new ListView<>();

        Button addToCart = new Button("Add To Cart");
        addToCart.setStyle("-fx-background-color: black;" +
                "-fx-border-color: white;" +
                "-fx-text-fill: white;");
        addToCart.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Button checkout = new Button("Checkout");
        checkout.setStyle("-fx-background-color: black;" +
                "-fx-border-color: white;" +
                "-fx-text-fill: white;");
        checkout.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        Text subtotalLabel = new Text("Sub-Total ");
        subtotalLabel.setFont(Font.font("Times New Roman", 20));
        subtotalLabel.setLayoutX(500);
        subtotalLabel.setLayoutY(400);

        Text taxLabel = new Text("Tax-paid ");
        taxLabel.setFont(Font.font("Times New Roman", 20));
        taxLabel.setLayoutX(500);
        taxLabel.setLayoutY(430);

        Text totalLabel = new Text("Total ");
        totalLabel.setFont(Font.font("Times New Roman", 20));
        totalLabel.setLayoutX(500);
        totalLabel.setLayoutY(460);

        Text subtotal = new Text();
        subtotal.setFont(Font.font("Times New Roman", 20));
        subtotal.setLayoutX(650);
        subtotal.setLayoutY(400);

        Text tax = new Text();
        tax.setFont(Font.font("Times New Roman", 20));
        tax.setLayoutX(650);
        tax.setLayoutY(430);

        Text total = new Text();
        total.setFont(Font.font("Times New Roman", 20));
        total.setLayoutX(650);
        total.setLayoutY(460);

        DecimalFormat f = new DecimalFormat("0.00");

        addToCart.setOnMouseClicked(e-> {
            cartList.add((listView.getSelectionModel().getSelectedItem()));
            cart.setItems(cartList);

            double sub_total = cartList.stream().mapToDouble(Items::getPrize).sum();
            double tax_paid = sub_total * 0.06;
            double total_cost = sub_total + tax_paid;

            String totalAmount = Double.toString(Double.parseDouble(f.format(total_cost)));
            String subTotalAmount = Double.toString(Double.parseDouble(f.format(sub_total)));
            String taxAmount = Double.toString(Double.parseDouble(f.format(tax_paid)));

            subtotal.setText("$" + subTotalAmount);
            tax.setText("$"+ taxAmount);
            total.setText("$" +totalAmount);
        });

        checkout.setOnMouseClicked(e-> {
            if(cart.getItems().size() != 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Confirmation..");
                alert.setContentText("\tThank You for shopping with iShop!\n\tAmount of " + total.getText() +
                        " is deducted from you account!");
                alert.show();

                cartList.clear();
                cart.refresh();
                listView.refresh();
                subtotal.setText("");
                tax.setText("");
                total.setText("");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Empty Cart!");
                alert.setContentText("Your cart is empty..");
                alert.show();
            }
        });

        leftPane.getChildren().addAll(listView);
        bottomPane.getChildren().addAll(addToCart, checkout);
        rightPane.getChildren().add(cart);
        Pane root = new Pane();
        root.getChildren().addAll(header, leftPane, rightPane, bottomPane, subtotal, tax, total,
            subtotalLabel, taxLabel, totalLabel);
        Scene scene = new Scene(root, 830, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Billing System!!");
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}
