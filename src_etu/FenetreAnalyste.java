import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.chart.PieChart;
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
        
        // Center section
        VBox centre = new VBox();
        Text text1 = new Text("Analyse du sondage sur les habitudes alimentaire");
        ComboBox cmbx1 = new ComboBox<>(); // Generic type added
        HBox h1 = new HBox();

        Image precImage = new Image("../graphics/back.png");
        ImageView view2 = new ImageView(precImage);
        Button b1 = new Button("Question précedente");
        b1.setGraphic(view2);
        
        Button b2 = new Button("Question suivante");
        h1.getChildren().addAll(b1, b2);

        PieChart chart = new PieChart();
        chart.setTitle("Que lisez-vous au petit déjeuner ?");
        chart.getData().addAll(
                new PieChart.Data("Le journal", 21),
                new PieChart.Data("Un livre", 3),
                new PieChart.Data("Le courier", 7),
                new PieChart.Data("La boîte de céréales", 75));
        chart.setLegendSide(Side.LEFT);
        centre.getChildren().addAll(text1, cmbx1, chart, h1);

        // Right section (TilePane with images)
        TilePane droite = new TilePane();
      

        // Assemble the root
        root.setTop(haut);
        root.setCenter(centre);
        root.setRight(droite);

        return root;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root(), 800, 600); // Increased size to accommodate all content
        stage.setTitle("Zak");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}