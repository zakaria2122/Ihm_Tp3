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

public class FenetreAnalyste extends BorderPane {
    private Button bouton;

    public FenetreAnalyste(Button bouton) {
        super();
        this.bouton = bouton;
        this.setPadding(new Insets(10));

        this.setTop(creerHaut());
        this.setCenter(creerCentre());
        this.setRight(creerDroite());
    }

    private BorderPane creerHaut() {
        BorderPane haut = new BorderPane();
        Text text = new Text("Allo 45, Module Analyste");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        haut.setLeft(text);

        Image img = new Image("../graphics/user.png");
        ImageView view = new ImageView(img);
        this.bouton.setGraphic(view);
        haut.setRight(this.bouton);

        BackgroundFill backgroundFill = new BackgroundFill(Color.AQUAMARINE, null, null);
        Background background = new Background(backgroundFill);
        haut.setBackground(background);
        haut.setPadding(new Insets(10, 20, 10, 20));

        return haut;
    }

    private VBox creerCentre() {
        VBox centre = new VBox(15);
        centre.setPadding(new Insets(10));

        Text text1 = new Text("Analyse du sondage sur les habitudes alimentaire");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 

        ComboBox cmbx1 = new ComboBox(); 

        HBox h1 = new HBox(20); 

        Image precImage = new Image("../graphics/back.png");
        ImageView view2 = new ImageView(precImage);
        view2.setFitHeight(20);
        view2.setFitWidth(20);
        Button b1 = new Button("Question précedente");
        b1.setGraphic(view2);
        b1.setPadding(new Insets(5, 10, 5, 10));

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
            new PieChart.Data("La boîte de céréales", 75)
        );
        chart.setLegendSide(Side.LEFT);
        chart.setMinSize(300, 200);

        centre.getChildren().addAll(text1, cmbx1, chart, h1);
        return centre;
    }

    private TilePane creerDroite() {
        TilePane droite = new TilePane();
        droite.setHgap(10);
        droite.setVgap(10);
        droite.setPadding(new Insets(10));

        for (int i = 1; i <= 7; i++) {
            Image mage = new Image("../graphics/chart_" + i + ".png");
            ImageView a1 = new ImageView(mage);
            droite.getChildren().add(a1);
        }

        BackgroundFill backgroundFill1 = new BackgroundFill(Color.AZURE, null, null);
        Background background1 = new Background(backgroundFill1);
        droite.setBackground(background1);

        return droite;
    }
}
