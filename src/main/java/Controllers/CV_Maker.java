package Controllers;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CV_Maker {

    private String defaultTxt = "Ne felejtsd el kitölteni";
    private int headFontSize = 20;
    private int fontSize = 15;

    //Személyes inf.
    private String name = defaultTxt;
    private String major = defaultTxt;

    private String phone = defaultTxt;
    private String email = defaultTxt;
    private boolean isSingle = false;
    private boolean hasDriverLicneses = false;

    //Cím
    private String street = defaultTxt;
    private String city = defaultTxt;
    private String otherAdressInfo;

    //Oktatás
    private String education = defaultTxt;

    //Tapasztalat
    private String experience = defaultTxt;

    //Kézségek
    private String skills = defaultTxt;

    //Hobbik és nyelvek
    private String languages = defaultTxt;
    private String hobbies;

    static Logger logger = LoggerFactory.getLogger(CV_Maker.class);


    ////////////////////////////////////////////////////////////////////////////
    private XWPFDocument resultDocument = new XWPFDocument();

    public void createHeaddingParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.CENTER);
        run.setBold(true);
        run.setFontSize(headFontSize);
        run.setText(name.toUpperCase());
        run.addBreak();
        run.setText(major);
        run.addBreak();

    }

    public void createPersonalParagraph() {
        XWPFParagraph personal = resultDocument.createParagraph();
        XWPFRun run = personal.createRun();
        personal.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Személyes információk:");
        run.addBreak();

        run.setText("Telefonszám: " + phone);
        run.addBreak();

        run.setText("Email: " + email);
        run.addBreak();

        String data = (isSingle ? "Egyedülálló" : "Házas");
        run.setText("Családi állapot: " + data);
        run.addBreak();

        if (hasDriverLicneses) {
            run.setText("Rendelkezik érvényes jogosítvánnyal ?");
            run.addBreak();

        }

    }

    public void createAdressParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Lakóhely információk:");
        run.addBreak();

        run.setText("Utca: " + street);
        run.addBreak();

        run.setText("Város: " + city);
        run.addBreak();

        if (otherAdressInfo.length() != 0) {
            run.setText("Egyébb információ: " + otherAdressInfo);
            run.addBreak();

        }

        logger.info("Sikeres paragrafus mentés");

    }

    public void createEducationParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Iskolázottság: ");
        run.addBreak();

        run.setText(education);
        run.addBreak();

    }

    public void createExperianceParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Tapasztalat:");
        run.addBreak();

        run.setText(experience);
        run.addBreak();

    }

    public void createSkillsParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Kézségek: \n");
        run.setText(skills + '\n');

    }

    public void createLanguagesAndHobbiesParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);

        run.setText("Beszélt nyelvek:");
        run.addBreak();

        run.setText(languages);
        run.addBreak();

        if (hobbies.length() != 0) {
            run.setText("Hobbik:");
            run.addBreak();

            run.setText(hobbies);
            run.addBreak();

        }
    }

    public void createRefrencesParagraph() {
        XWPFParagraph headding = resultDocument.createParagraph();
        XWPFRun run = headding.createRun();
        headding.setAlignment(ParagraphAlignment.LEFT);

        run.setFontSize(fontSize);  
        run.setBold(true);

        run.setText("-------------------------------------");

    }

    ////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    public void setHasDriverLicneses(boolean hasDriverLicneses) {
        this.hasDriverLicneses = hasDriverLicneses;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOtherAdressInfo(String otherAdressInfo) {
        this.otherAdressInfo = otherAdressInfo;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public XWPFDocument getResultDocument() {
        return resultDocument;
    }

}
