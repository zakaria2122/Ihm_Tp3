import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FenetreNouv  extends Application{
    private TextField t1;
    private TextField t2;

    @Override
    
    public void init(){

        this.t1 = new TextField();
        this.t2 = new TextField();
    }
    private GridPane root(){
        GridPane = new GridPane();

        root.add(new label("User"),0,1,2,1);
        root.add(new label("User"),1,1);  
    
        root.add(t1,1,1 );
        root.add(t1,1,2 );

        root.setPrefSize(500, 200);
        root.setHgap(10);
        root.setVgap(25);
        root.setPadding(new Insets(10));
        return root;
}

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root(), 500, 200);
        stage.setTitle("Zak");
        stage.setScene(scene);
        stage.show();
    }

    public void effaceTF() {
        this.t1.setText("");
        this.t2.setText("");
    }

    public void quitte() {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
