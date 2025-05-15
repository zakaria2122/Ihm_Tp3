import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.chart.PieChart;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;

public class FenetreAnalyste extends Application {

    @Override
    public void init() {
    }

    private BorderPane root() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10)); // Marge globale autour du BorderPane

        // Top section
        BorderPane haut = new BorderPane();
        Text text = new Text("Allo 45, Module Analyste");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        haut.setLeft(text);
        Image img = new Image("../graphics/user.png");
        ImageView view = new ImageView(img);

        Button deconnexion = new Button("Deconnexion");
        deconnexion.setGraphic(view);
        haut.setRight(deconnexion);

        BackgroundFill backgroundFill = new BackgroundFill(Color.AQUAMARINE, null, null);
        Background background = new Background(backgroundFill);
        haut.setBackground(background);
        haut.setPadding(new Insets(10, 20, 10, 20)); // Padding interne pour le haut
        
        // Center section
        VBox centre = new VBox(15);
        centre.setPadding(new Insets(10));
        Text text1 = new Text("Analyse du sondage sur les habitudes alimentaire");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
        ComboBox cmbx1 = new ComboBox(); 
        HBox h1 = new HBox(20); 

        Image precImage = new Image("../graphics/back.png");
        ImageView view2 = new ImageView(precImage);
        view2.setFitHeight(20); // Taille fixe pour l'image
        view2.setFitWidth(20);
        Button b1 = new Button("Question précedente");
        b1.setGraphic(view2);
        b1.setPadding(new Insets(5, 10, 5, 10)); // Padding pour le bouton

        Image suivImage = new Image("../graphics/next.png");
        ImageView view3 = new ImageView(suivImage);
        view3.setFitHeight(20);
        view3.setFitWidth(20);
        Button b2 = new Button("Question suivante");
        b2.setGraphic(view3);
        b2.setPadding(new Insets(5, 10, 5, 10));

        h1.getChildren().addAll(b1, b2);

        PieChart chart = new PieChart();
        chart.setTitle("Que lisez-vous au petit déjeuner ?");
        chart.getData().addAll(
                new PieChart.Data("Le journal", 21),
                new PieChart.Data("Un livre", 3),
                new PieChart.Data("Le courier", 7),
                new PieChart.Data("La boîte de céréales", 75));
        chart.setLegendSide(Side.LEFT);
        chart.setMinSize(300, 200); // Taille minimale pour le graphique
        centre.getChildren().addAll(text1, cmbx1, chart, h1);

        // Right section (TilePane with images)
        TilePane droite = new TilePane();
        droite.setHgap(10);
        droite.setVgap(10);
        droite.setPadding(new Insets(10)); // Marge interne
        for (int i = 1; i <= 7; i++) {
            Image mage = new Image("../graphics/chart_" + i +".png");
            ImageView a1 = new ImageView(mage);
            droite.getChildren().add(a1);
        }
        BackgroundFill backgroundFill1 = new BackgroundFill(Color.AZURE, null, null);
        Background background1 = new Background(backgroundFill1);
        droite.setBackground(background1);

        // Assemble the root
        root.setTop(haut);
        root.setCenter(centre);
        root.setRight(droite);

        return root;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root(), 1000, 500); // Taille conservée
        stage.setTitle("Zak");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}