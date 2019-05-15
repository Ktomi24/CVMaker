package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import cv.maker.CVMaker;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


public class MainFrameController implements Initializable {

    private String path = "";

    @FXML
    private JFXTabPane TabPane;

    @FXML
    private StackPane sp;

    @FXML
    private AnchorPane adress_anch;

    @FXML
    private AnchorPane done__anch;

    @FXML
    private JFXTextField email_txt;

    @FXML
    private JFXTextField name_txt;

    @FXML
    private JFXCheckBox check_driver;

    @FXML
    private AnchorPane skills_anch;

    @FXML
    private JFXTextArea other_adress_txt;

    @FXML
    private AnchorPane personal_anch;

    @FXML
    private JFXCheckBox check_single;

    @FXML
    private JFXTextField path_txt;

    @FXML
    private JFXTextField major_txt;

    @FXML
    private JFXTextArea hobbies_txt;

    @FXML
    private JFXTextField street_txt;

    @FXML
    private JFXTextArea experiance_txt;

    @FXML
    private JFXTextField phone_txt;

    @FXML
    private JFXTextArea skills_txt;

    @FXML
    private AnchorPane experciance_anch;

    @FXML
    private JFXTextArea education_txt;

    @FXML
    private JFXTextField city_txt;

    @FXML
    private AnchorPane main_anch;

    @FXML
    private AnchorPane education_anch;

    @FXML
    private AnchorPane hobbies_anch;

    @FXML
    private JFXTextArea language_txt;

    @FXML
    void path_clikced(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(CVMaker.st);
        path_txt.setText(selectedDirectory.getAbsolutePath());
    }

    public XWPFDocument document;







    @FXML
    void finish_clicked(ActionEvent event) {

        CV_Maker cv = new CV_Maker();
        document = cv.getResultDocument();

        cv.setCity(city_txt.getText());
        cv.setEducation(education_txt.getText());
        cv.setEmail(email_txt.getText());
        cv.setExperience(experiance_txt.getText());
        cv.setHasDriverLicneses(false);
        cv.setHobbies("");
        cv.setIsSingle(true);
        cv.setLanguages(language_txt.getText());
        cv.setMajor(major_txt.getText());
        cv.setName(name_txt.getText());
        cv.setOtherAdressInfo(other_adress_txt.getText());
        cv.setPhone(phone_txt.getText());
        cv.setStreet(street_txt.getText());
        cv.setSkills(skills_txt.getText());

        cv.createHeaddingParagraph();
        cv.createPersonalParagraph();
        cv.createAdressParagraph();
        cv.createEducationParagraph();
        cv.createExperianceParagraph();
        cv.createSkillsParagraph();
        cv.createLanguagesAndHobbiesParagraph();
        cv.createRefrencesParagraph();

        try {
            FileOutputStream output = new FileOutputStream(path_txt.getText() + "/" + name_txt.getText() + " CV.doc");
            document.write(output);
            output.close();
            showMessage("Sikerült!", "Az önéletrajzot előállítottuk és elmentettük az adott helyre", false);
        } catch (Exception e) {
            showMessage("Hiba", "Hiba miatt nem sikerült az önéletrajzot előállítani\nRészletek: " + e.getMessage(), false);
        }

    }



    @FXML
    void guid_clicked(ActionEvent event) {

        showMessage("Tipp 6/6", "Ha kész vagy mindennel akkor kattints a mentés feliratra és készen is vagy.", false);
        showMessage("Tipp 5/6", "Amikor eléred a végső menüpontot add meg, hogy hova szeretnéd menteni az önéletrajzod.", true);
        showMessage("Tipp 4/6", "Bármikor visszaléphetsz a menüpontok között.", true);
        showMessage("Tipp 3/6", "Az alső menük között tudod kitölteni a kért információkat.", true);
        showMessage("Tipp 2/6", "A program egy World dokumentumba menti az önéletrajzod\nSzóval amiután elkészült is tudod szerkeszteni.", true);
        showMessage("Tipp 1/6", "Üdvözöllek az általam készített Önéletrajz készítő alkalmazásban.", true);

    }
    @FXML
    void read() {
        CV_reader cv_reader = new CV_reader();
        cv_reader.JSON_reader();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("valami.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String t1 = (String) jsonObject.get("name");
            cv_reader.setName(t1);
            String t2 = (String) jsonObject.get("major");
            cv_reader.setMajor(t2);
            String t3 = (String) jsonObject.get("phone");
            cv_reader.setPhone(t3);
            String t4 = (String) jsonObject.get("email");
            cv_reader.setEmail(t4);
            String t5 = (String) jsonObject.get("street");
            cv_reader.setStreet(t5);
            String t6 = (String) jsonObject.get("city");
            cv_reader.setCity(t6);
            String t7 = (String) jsonObject.get("otherAdressInfo");
            cv_reader.setOtherAdressInfo(t7);
            String t8 = (String) jsonObject.get("education");
            cv_reader.setEducation(t8);
            String t9 = (String) jsonObject.get("experience");
            cv_reader.setExperience(t9);
            String t10 = (String) jsonObject.get("skills");
            cv_reader.setSkills(t10);
            String t11 = (String) jsonObject.get("languages");
            cv_reader.setLanguages(t11);
            String t12 = (String) jsonObject.get("hobbies");
            cv_reader.setHobbies(t12);



        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

        name_txt.setText(cv_reader.getName());
        major_txt.setText(cv_reader.getMajor());
        phone_txt.setText(cv_reader.getPhone());
        email_txt.setText(cv_reader.getEmail());
        street_txt.setText(cv_reader.getStreet());
        city_txt.setText(cv_reader.getCity());
        other_adress_txt.setText(cv_reader.getOtherAdressInfo());
        education_txt.setText(cv_reader.getEducation());
        experiance_txt.setText(cv_reader.getExperience());
        skills_txt.setText(cv_reader.getSkills());
        language_txt.setText(cv_reader.getLanguages());
        hobbies_txt.setText(cv_reader.getHobbies());



    }






    @FXML
    void exit_clicked(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intitializeTabs();

    }

    private void intitializeTabs() {

        TabPane.setPrefSize(700, 400);

        Tab main_tab = new Tab();
        Tab personal_tab = new Tab();
        Tab education_tab = new Tab();
        Tab adress_tab = new Tab();
        Tab exprenace_tab = new Tab();
        Tab skills_tab = new Tab();
        Tab hoppies_tab = new Tab();
        Tab done_tab = new Tab();

        main_tab.setText("Főképernyő");
        personal_tab.setText("Személyes Adatok");
        adress_tab.setText("Elérhetőség");
        education_tab.setText("Oktatás");
        exprenace_tab.setText("Munkatapasztalat");
        skills_tab.setText("Kézségek");
        hoppies_tab.setText("Nyelvek & Hobbik");
        done_tab.setText("Kreálás");

        main_tab.setContent(main_anch);
        personal_tab.setContent(personal_anch);
        adress_tab.setContent(adress_anch);
        education_tab.setContent(education_anch);
        exprenace_tab.setContent(experciance_anch);
        skills_tab.setContent(skills_anch);
        hoppies_tab.setContent(hobbies_anch);
        done_tab.setContent(done__anch);

        TabPane.getTabs().addAll(main_tab, personal_tab, adress_tab, education_tab, exprenace_tab, skills_tab, hoppies_tab, done_tab);

    }

    private void showMessage(String title, String message, boolean is) {
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text(title));
        layout.setBody(new Text(message));
        JFXButton bt = new JFXButton("Ok");
        layout.setActions(bt);

        final JFXDialog dialog = new JFXDialog(sp, layout, JFXDialog.DialogTransition.CENTER);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        dialog.show();

    }

}
