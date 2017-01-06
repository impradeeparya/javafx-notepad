package notepad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import notepad.util.NotepadUtils;

/**
 * Created by pradeep on 1/1/17.
 */
public class NotepadLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        SplitPane root = NotepadUtils.getRootPane();
        NotepadUtils.addMenuBar(root);

        Scene scene = new Scene(root, 500, 600);

        primaryStage.setTitle("NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
