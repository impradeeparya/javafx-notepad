package notepad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import notepad.util.NotepadUtils;
import notepad.util.PropertyConfigurator;

/**
 * Created by pradeep on 1/1/17.
 */
public class NotepadLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        PropertyConfigurator instance = PropertyConfigurator.INSTANCE;
        boolean isPropertiesLoaded = instance.init();

        if (isPropertiesLoaded) {
            SplitPane root = NotepadUtils.INSTANCE.getRootPane();
            NotepadUtils.addMenuBar(root);

            Scene scene = new Scene(root, 500, 600);

            NotepadUtils.INSTANCE.setPrimaryStage(primaryStage);
            primaryStage.setTitle(instance.getValueOf("application.title"));
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
