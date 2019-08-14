package Elementos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementoLogin {

    private WebDriver driver;

    private By usuarioCampoLogin = By.id("username");
    private By senhaCampoLogin = By.id("password");
    private By botaoLogin = By.xpath("//*[@id=\"login\"]/button/i");
    public  By erroLogin = By.xpath("//*[@id=\"flash\"]");
    public By sucessoLogin = By.xpath("//*[@id=\"flash\"]");

    public ElementoLogin(WebDriver driver){
        this.driver = driver;
    }
    public  void clickBotaoLogin(){
        driver.findElement(botaoLogin).click();

    }
    public  void digitaUsuarioCampo(String usuarioCampoDigitado){
        driver.findElement(usuarioCampoLogin).clear();
        driver.findElement(usuarioCampoLogin).sendKeys(usuarioCampoDigitado);
    }
    public  void digitaSenhaCampo(String senhaCampoDigitado){
        driver.findElement(senhaCampoLogin).clear();
        driver.findElement(senhaCampoLogin).sendKeys(senhaCampoDigitado);
    }
    public void loginSucesso (String login, String senha){
        driver.findElement(usuarioCampoLogin).clear();
        driver.findElement(usuarioCampoLogin).sendKeys(login);
        driver.findElement(senhaCampoLogin).clear();
        driver.findElement(senhaCampoLogin).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }
    public String mensagemErro() {
        String msgErroEsperado;
        msgErroEsperado = driver.findElement(erroLogin).getText();
        System.out.println(msgErroEsperado);
        return msgErroEsperado;
    }
    public String mensagemSucesso(){
        String msgSucessoEsperado;
        msgSucessoEsperado = driver.findElement(sucessoLogin).getText();
        System.out.println(msgSucessoEsperado);
        return msgSucessoEsperado;
    }


}
