package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import pages.P01;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class P01StepDef {
    P01 p01 = new P01();
    int urunSayisiTrendyol;
    int urunSayisiMorhipo;
    String titleTrendyol;
    String titleMorhipo;
    String sonWindowHandle;

    @Given("Google'a gidiniz")
    public void googleAGidiniz() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }

    @Then("trendyol'u aratiniz")
    public void trendyolUAratiniz() {
        p01.googleSearchBox.sendKeys("Trendyol", Keys.ENTER);
    }

    @And("trendyol linkini bulup siteye gidiniz")
    public void trendyolLinkiniBulupSiteyeGidiniz() {
        p01.trendyolLink.click();
        p01.trendyolCerezKabul.click();

    }

    @Then("makas aratiniz")
    public void makasAratiniz() {
        p01.trendyolSearchBox.sendKeys("makas",Keys.ENTER);
        titleTrendyol=Driver.getDriver().getTitle();
    }

    @And("toplam urun sayisini aliniz")
    public void toplamUrunSayisiniAliniz() {
        String sonucSayisi=p01.trendyolSonucYazisiWE.getText();
        String [] sonucSayisiArr= sonucSayisi.split(" ");
        urunSayisiTrendyol= Integer.parseInt(sonucSayisiArr[3]);
    }

    @Then("yeni sekmede morhipo'ya gidiniz")
    public void yeniSekmedeMorhipoYaGidiniz() {
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.morhipo.com");
    }
    @And("makas aratiniz morhipo")
    public void makasAratinizMorhipo() {
        p01.morhipoSearchBox.sendKeys("makas",Keys.ENTER);
        titleMorhipo=Driver.getDriver().getTitle();
    }
    @Then("toplam urun sayisini aliniz morhipo")
    public void toplamUrunSayisiniAlinizMorhipo() {
        String urunSayisi=p01.morhipoSonucYazisiWE.getText();
        urunSayisiMorhipo=Integer.parseInt(urunSayisi);

    }

    @And("iki sitedeki toplam makas sayisini karsilastiriniz")
    public void ikiSitedekiToplaMakasSayisiniKarsilastiriniz() {
        System.out.println("urunSayisiTrendyol = " + urunSayisiTrendyol);
        System.out.println("urunSayisiMorhipo = " + urunSayisiMorhipo);

        if (urunSayisiTrendyol>urunSayisiMorhipo){
            System.out.println("Trendyol urun sayisi morhipon urun sayisindan fazladir");
        }else{
            System.out.println("Morhipo urun sayisi Trendyol urun sayisindan fazladir");
        }
    }

   @Then("Once urun sayisi fazla olan siteyi kapatiniz")
   public void onceUrunSayisiFazlaOlanSiteyiKapatiniz() {

       System.out.println("titleTrendyol = " + titleTrendyol);
       System.out.println("titleMorhipo = " + titleMorhipo);
       System.out.println("urunSayisiTrendyol = " + urunSayisiTrendyol);
       System.out.println("urunSayisiMorhipo = " + urunSayisiMorhipo);

       if (urunSayisiTrendyol>urunSayisiMorhipo){
            ReusableMethods.switchToWindow(titleTrendyol);
            Driver.closeDriver();
        }else {
            Driver.closeDriver();
        }
       System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
   }
    @And("Sonra diger sayfayida kapatiniz")
    public void sonraDigerSayfayidaKapatiniz()  {
        Driver.quitDriver();
    }
}
