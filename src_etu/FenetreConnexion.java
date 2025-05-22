import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FenetreConnexion extends GridPane {

    private Button bouton;
    private TextField tf1;
    private TextField tf2;

    public FenetreConnexion(Button bouton) {
        super();
        this.bouton = bouton;
        this.tf1 = new TextField();
        this.tf2 = new TextField();

        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(5);
        this.setPrefSize(500, 200);

        this.add(new Label("Entrez votre identifiant et votre mot de passe"), 0, 0, 2, 1);
        this.add(new Label("Identifiant :"), 0, 1);
        this.add(new Label("Mot de passe :"), 0, 2);

        this.add(tf1, 1, 1);
        this.add(tf2, 1, 2);

        GridPane.setHalignment(this.bouton, HPos.RIGHT);
        this.add(this.bouton, 1, 3);
    }
}
