package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P01 {
    public P01(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//input[@class='gLFyf gsfi']")
    public WebElement googleSearchBox;

    @FindBy (xpath = "//h3[text()=\"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da\"]")
    public WebElement trendyolLink;

    @FindBy (xpath = "//*[@data-testid='suggestion']")
    public WebElement trendyolSearchBox;

    @FindBy (xpath = "//*[@class='dscrptn']")
    public WebElement trendyolSonucYazisiWE;

    @FindBy (xpath = "//*[@id='pw-search-input']")
    public WebElement morhipoSearchBox;

    @FindBy (xpath = "//*[@id='total-product-count']")
    public WebElement morhipoSonucYazisiWE;

    @FindBy (xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement trendyolCerezKabul;
}
