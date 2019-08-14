package Testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Elementos.ElementoLogin;

import java.util.concurrent.TimeUnit;

public class TesteLogin {

    WebDriver driver;

    //chamada do driver do chrome, abre o site a ser testado e caso demore mais de 5 segundo o teste falha
    @BeforeMethod(description = "entrar no site")
    public void abreSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bella\\OneDrive\\Área de Trabalho\\BKP_Isabela\\FACULDADE\\TCC\\projeto\\IdeaProjects\\TrabalhoGraduacao\\Browser_Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

     // fecha o navegador apos cada teste
    @AfterMethod(description = "encerrar navegador")
    public void setupFinal (){
        driver.quit();
    }

    //Teste de login sucesso usuario e senha validos
    @Test  (description = "fazer login",priority = 1)
    public void login() {
        ElementoLogin ElementoLogin = new ElementoLogin(driver);
        ElementoLogin.digitaUsuarioCampo("tomsmith");
        ElementoLogin.digitaSenhaCampo("SuperSecretPassword!");
        ElementoLogin.clickBotaoLogin();
        Assert.assertEquals("You logged into a secure",ElementoLogin.mensagemSucesso());
    }

    //Teste de login erro (senha invalida)
    @Test (description = "login erro senha invalida", priority = 2)
    public void loginErro(){
        ElementoLogin ElementoLogin2 = new ElementoLogin(driver);
        ElementoLogin2.digitaUsuarioCampo("tomsmith");
        ElementoLogin2.digitaSenhaCampo("123");
        ElementoLogin2.clickBotaoLogin();
        //Assert.assertEquals("Your password is invalid!",ElementoLogin2.mensagemErro());
    }


}
