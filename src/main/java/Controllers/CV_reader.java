package Controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.platform.commons.logging.LoggerFactory;

public class CV_reader extends CV_Maker {
    private String name;
    private String major;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String otherAdressInfo;
    private String education;
    private String experience;
    private String skills;
    private String languages;
    private String hobbies;



    public void JSON_writer(){

        Gson gson = new Gson();
        name = gson.toJson("Kiss Tamás");
        major = gson.toJson("1993.05.26");
        phone = gson.toJson("3636556778");
        email = gson.toJson("ktomi200@gmail.com");
        street = gson.toJson("Debrecen");
        city = gson. toJson("Nemlétezik utca 13.");
        otherAdressInfo = gson.toJson("Nincsen");
        education = gson.toJson("Általános iskola, Gimnázium, Főiskola, Egyetem");
        experience = gson.toJson("Valami cég 2014-2016");
        skills = gson.toJson("Java, JavaFX, C, C++");
        languages = gson.toJson("Magyar, Angol, Német, Orosz");
        hobbies = gson.toJson("Játék, Foci, Úszás, DE-IK");



        /*String s2 = gson.toJson("Hello, world!");
        String s3 = gson.toJson(false);
        String s4 = gson.toJson(null);
        String s5 = gson.toJson(new int[] {3, 26, 31, 46, 66});
        CV_Maker cv_maker = new CV_Maker();
        cv_maker.setName("Kiss Tamas");

        String s = gson.toJson(cv_maker);*/
        System.out.println(name);
        System.out.println(major);
        System.out.println(phone);
        System.out.println(email);
        System.out.println(city);
        System.out.println(street);
        System.out.println(otherAdressInfo);
        System.out.println(education);
        System.out.println(experience);
        System.out.println(skills);
        System.out.println(languages);
        System.out.println(hobbies);


        //CV_Maker result = gson.fromJson(s, CV_Maker.class);
        //System.out.println(result);
    }

public void JSON_reader() {
    Gson gson = new Gson();

    String result2 = gson.fromJson(name, String.class);
    String result3 = gson.fromJson(major, String.class);
    String result4 = gson.fromJson(phone, String.class);
    String result5 = gson.fromJson(email, String.class);
    String result6 = gson.fromJson(city, String.class);
    String result7 = gson.fromJson(street, String.class);
    String result8 = gson.fromJson(otherAdressInfo, String.class);
    String result9 = gson.fromJson(education, String.class);
    String result10 = gson.fromJson(experience, String.class);
    String result11 = gson.fromJson(skills, String.class);
    String result12 = gson.fromJson(languages, String.class);
    String result13 = gson.fromJson(hobbies, String.class);
    /*boolean result3 = gson.fromJson(s3, Boolean.class);
    Object result4 = gson.fromJson(s4, Object.class);
    int[] result5 = gson.fromJson(s5, int[].class);*/



}



    public String getName() {

        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    public String getOtherAdressInfo() {
        return otherAdressInfo;
    }

    @Override
    public void setOtherAdressInfo(String otherAdressInfo) {
        this.otherAdressInfo = otherAdressInfo;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    @Override
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    @Override
    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLanguages() {
        return languages;
    }

    @Override
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getHobbies() {
        return hobbies;
    }

    @Override
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}



