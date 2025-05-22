import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppliPlusieursFenetres extends Application {

    private Button btnc;
    private Button btnd;
    private Scene scene;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(AppliPlusieursFenetres.class, args);
    }

    @Override
    public void init() {
        this.btnc = new Button("Connexion");
        this.btnd = new Button("Deconnexion");

        ControleBouton controleur = new ControleBouton(this);
        this.btnc.setOnAction(controleur);
        this.btnd.setOnAction(controleur);

    }

    @Override
    public void start(Stage stage) {
        this.stage = stage; // stocke le stage si besoin
        afficheConnexion(); // ou afficheAnalyse()
        stage.setTitle("Appli avec deux fenêtres");
        stage.show();
    }

    private Stage stage; // ajouter un attribut stage

    public void afficheConnexion() {
        Pane root = new FenetreConnexion(this.btnc);
        Scene scene = new Scene(root, 400, 200); // taille adaptée à la connexion
        stage.setScene(scene);
    }

    public void afficheAnalyse() {
        Pane root = new FenetreAnalyste(this.btnd);
        Scene scene = new Scene(root, 1000, 700); // taille adaptée à l'analyse
        stage.setScene(scene);
    }
}
