package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AboutUsPage extends BasePage{
  public final static String ABOUT_US_LOGO= "//h1[@class = 'page-title'][contains(text(), 'About Us')]";
    public static final Logger logger = LogManager.getLogger(AboutUsPage.class);

  public boolean logoIsDisplayed(){
      logger.info("logoIsDisplayed. ");
      return isElementDisplayed(ABOUT_US_LOGO);
  }
}
