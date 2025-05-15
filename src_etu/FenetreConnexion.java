import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FenetreConnexion extends Application {
    private TextField tf1;
    private TextField tf2;

    @Override
    public void init() {
        // Initialisation des champs texte
        this.tf1 = new TextField();
        this.tf2 = new TextField();
    }

    private GridPane root() {
        GridPane root = new GridPane();

        root.add(new Label("Entrez votre identifiant et votre mot de passe"), 1, 0, 2, 1); // (colonne ligne, palce pris colonne, place pris en ligne)
        root.add(new Label("Identifiant"), 0, 1);
        root.add(new Label("Mot de passe"), 0, 2);
        root.add(tf1, 1, 1);
        root.add(tf2, 1, 2);

        Button connexion = new Button("Connexion");
        GridPane.setHalignment(connexion, HPos.RIGHT);
        root.add(connexion, 1, 3);

        root.setPrefSize(500, 200);
        root.setHgap(10);
        root.setVgap(25);
        root.setPadding(new Insets(10));

        return root;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root(), 500, 200);
        stage.setTitle("Allo 45");
        stage.setScene(scene);
        stage.show();
    }

    public void effaceTF() {
        this.tf1.setText("");
        this.tf2.setText("");
    }

    public void quitte() {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
