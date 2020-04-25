import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Example {

    static{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd-HHmmss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    static Logger logger = Logger.getLogger(Example.class);

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        //Log in console in and log file
        logger.info("Starting the application");
        try {
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(
                    new File("data/student_a.json"), Student.class);

            System.out.println("First name: " + student.getFirstName());
        }
        catch(IOException e){
            logger.fatal("Unable to find the json file");
        }

    }
}
