package cv.maker;

import Controllers.CV_reader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CVMaker extends Application {

  public  static Stage st;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Minden.fxml"));

        //CV_reader cv_reader = new CV_reader();
        //cv_reader.JSON_writer();
        //cv_reader.JSON_reader();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        st = stage;
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public static void method() {
        System.out.println("");
    }

}
