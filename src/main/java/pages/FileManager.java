package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static final Logger logger = LogManager.getLogger(FileManager.class);


    public static void createNewFile(List<WebElement> cars, String nameOfFile) {

        File file = new File(nameOfFile + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.info("create file error");
            e.printStackTrace();

        }
        try {
            FileWriter fileWriter = new FileWriter(nameOfFile + ".txt");
            for (int i = 0; i < cars.size(); i++) {
                fileWriter.append(cars.get(i).getText()+ "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            logger.info("file writer error");

        }
    }
}

