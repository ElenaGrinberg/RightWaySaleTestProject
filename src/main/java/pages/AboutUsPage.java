package pages;

public class AboutUsPage extends BasePage{
  public final static String ABOUT_US_LOGO= "//h1[text() = ' About Us  ']";

  public boolean logoIsDisplayed(){
      return isElementDisplayed(ABOUT_US_LOGO);
  }
}
