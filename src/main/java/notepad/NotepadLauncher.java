package notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

/**
 * Created by pradeep on 1/1/17.
 */
public class NotepadLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(NotepadLauncher.class.getResource("/view/notepad.fxml"));
        SplitPane root = loader.load();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
