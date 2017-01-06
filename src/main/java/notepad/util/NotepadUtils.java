package notepad.util;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradeep on 1/1/17.
 */
public enum NotepadUtils {

    INSTANCE;

    private static Stage primaryStage;
    private static SplitPane splitPane;


    public void setPrimaryStage(Stage primaryStage) {
        if (primaryStage == null) {
            this.primaryStage = primaryStage;
        }
    }

    public SplitPane getRootPane() {
        if (splitPane == null) {
            splitPane = new SplitPane();
        }
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

        MenuItem newMenuItem = new MenuItem(PropertyConfigurator.INSTANCE.getValueOf("menu.file.new"));
        newMenuItem.setOnAction(actionEvent -> addTextArea());

        MenuItem openMenuItem = new MenuItem(PropertyConfigurator.INSTANCE.getValueOf("menu.file.open"));
        openMenuItem.setOnAction(actionEvent -> openFile());

        MenuItem saveMenuItem = new MenuItem(PropertyConfigurator.INSTANCE.getValueOf("menu.file.save"));

        MenuItem exitMenuItem = new MenuItem(PropertyConfigurator.INSTANCE.getValueOf("menu.file.exit"));
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);

        return fileMenu;
    }

    private static void openFile() {
        TabPane tabPane = getTabPane();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(primaryStage);

        List<String> lines = readFile(file);

        Tab tab = new Tab();
        tab.setText(file.getName());
        TextArea textArea = new TextArea();

        lines.stream().forEach(line -> textArea.appendText(line + System.lineSeparator()));


        tab.setContent(textArea);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    private static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void addTextArea() {
        TabPane tabPane = getTabPane();
        Tab tab = new Tab();
        tab.setText(PropertyConfigurator.INSTANCE.getValueOf("new.file.title"));
        TextArea textArea = new TextArea();
        tab.setContent(textArea);
        tabPane.getTabs().add(tab);
    }

    private static TabPane getTabPane() {
        ObservableList<Node> items = splitPane.getItems();
        TabPane tabPane;
        if (items.size() == 1) {
            tabPane = new TabPane();
            splitPane.getItems().add(1, tabPane);
        } else {
            tabPane = (TabPane) splitPane.getItems().get(1);
        }
        return tabPane;
    }

}