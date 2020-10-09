package task11;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Main11 extends Application{
    public static void main(String[] args) { Application.launch(args); }

    @Override
    public void start(Stage stage) {
        Text text = new Text("Hello World!");
        text.setLayoutY(50);
        text.setLayoutX(110);

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Вывод \"Hello World!\"");
        stage.setWidth(300);
        stage.setHeight(150);
        stage.show();
    }
}
