package Controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class CV_readerTest {
    public CV_reader reader;


    @BeforeEach
   public void setUp() {
        reader = new CV_reader();
        reader.JSON_writer();

    }

    @AfterEach
   public void tearDown() {
        reader = null;
    }

    @Test
    public void testResult() {
        String name="\"Kiss Tamás\"";
        assertEquals(name, reader.getName() );
        String major="\"1993.05.26\"";
        assertEquals(major, reader.getMajor());
        String phone="\"3636556778\"";
        assertEquals(phone, reader.getPhone());
        String email="\"ktomi200@gmail.com\"";
        assertEquals(email, reader.getEmail());
        String street="\"Debrecen\"";
        assertEquals(street, reader.getStreet());
        String city="\"Nemlétezik utca 13.\"";
        assertEquals(city, reader.getCity());
        String otherAdressInfo="\"Nincsen\"";
        assertEquals(otherAdressInfo, reader.getOtherAdressInfo());
        String education="\"Általános iskola, Gimnázium, Főiskola, Egyetem\"";
        assertEquals(education, reader.getEducation());
        String experience="\"Valami cég 2014-2016\"";
        assertEquals(experience, reader.getExperience());
        String skills="\"Java, JavaFX, C, C++\"";
        assertEquals(skills, reader.getSkills());
        String languages="\"Magyar, Angol, Német, Orosz\"";
        assertEquals(languages, reader.getLanguages());
        String hobbies="\"Játék, Foci, Úszás, DE-IK\"";
        assertEquals(hobbies, reader.getHobbies());

        File file = new File("/Users/kisstamas/Desktop/Kiss Tamás CV.doc");
        assertTrue(file.exists());



    }



    @Test
    public void testJSON_writer() {
    }

    @Test
   public void testJSON_reader() {
    }
}