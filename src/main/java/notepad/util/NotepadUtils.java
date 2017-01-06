package notepad.util;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;

/**
 * Created by pradeep on 1/1/17.
 */
public class NotepadUtils {
    private NotepadUtils() {

    }

    private static SplitPane splitPane = new SplitPane();

    public static SplitPane getRootPane() {
        splitPane.setOrientation(Orientation.VERTICAL);
        return splitPane;
    }

    public static void addMenuBar(SplitPane splitPane) {
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(0, getFileMenu());
        splitPane.getItems().add(0, menuBar);
    }

    private static Menu getFileMenu() {
        Menu fileMenu = new Menu("File");

        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> addTextArea());

        MenuItem saveMenuItem = new MenuItem("Save");

        MenuItem exitMenuItem = new MenuItem("Quit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);

        return fileMenu;
    }

    public static void addTextArea() {
        ObservableList<Node> items = splitPane.getItems();

        TabPane tabPane;
        if (items.size() == 1) {
            tabPane = new TabPane();
            splitPane.getItems().add(1, tabPane);
        } else {
            tabPane = (TabPane) splitPane.getItems().get(1);
        }
        Tab tab = new Tab();
        tab.setText("new");
        TextArea textArea = new TextArea();
        tab.setContent(textArea);
        tabPane.getTabs().add(tab);
    }
}