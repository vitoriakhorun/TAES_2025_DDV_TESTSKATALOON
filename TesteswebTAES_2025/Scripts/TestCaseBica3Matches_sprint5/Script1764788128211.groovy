import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.testobject.TestObject


// --- ABRIR SITE ---
WebUI.openBrowser('http://localhost:5173/')
WebUI.maximizeWindow()

// --- LOGIN ---
WebUI.waitForElementVisible(findTestObject('btn_login'), 10)
WebUI.click(findTestObject('btn_login'))

WebUI.waitForElementVisible(findTestObject('email'), 10)
WebUI.setText(findTestObject('email'), 'pe@mail.pt')
WebUI.setText(findTestObject('password'), '123')

WebUI.click(findTestObject('btn_signin'))
WebUI.waitForElementVisible(findTestObject('pag_inicial_logada'), 10)

// --- ENTRAR NO JOGO ---
WebUI.click(findTestObject('btn_bisca3match'))
WebUI.waitForElementVisible(findTestObject('pag_tabuleirobisca3'), 10)
WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
WebUI.delay(1)

// --- LOOP DO JOGO ---
boolean fimDoJogo = false

while (!fimDoJogo) {

    // Verifica se apareceu o botão "Jogar Novamente" → fim do jogo
    if (WebUI.verifyElementVisible(findTestObject('btn_jogarnovamente'), FailureHandling.OPTIONAL)) {
        println("Jogo terminou!")
        break
    }

    // Verifica se apareceu o botão "Próxima Ronda"
    if (WebUI.verifyElementVisible(findTestObject('btn_proxima_ronda'), FailureHandling.OPTIONAL)) {
        println("Indo para próxima ronda...")
        WebUI.click(findTestObject('btn_proxima_ronda'))
        WebUI.delay(1)  // espera o tabuleiro atualizar
        continue        // volta para o início do loop
    }

    // Pega as cartas atuais
    List<WebElement> cartas = DriverFactory.getWebDriver()
            .findElements(By.xpath("//img[@alt='Carta']"))

    boolean jogou = false

    // Tenta jogar cada carta
    for (WebElement carta : cartas) {

        // Contagem antes
        int antes = DriverFactory.getWebDriver()
                .findElements(By.xpath("//img[@alt='Carta']")).size()
		WebUI.delay(1)
        carta.click()
       

        // Contagem depois
        int depois = DriverFactory.getWebDriver()
                .findElements(By.xpath("//img[@alt='Carta']")).size()

        if (depois < antes) {
            // Jogada aceita pelo backend!
            jogou = true
            println("Jogou carta com sucesso!")
            break
        }
    }

    // Nenhuma carta válida → esperar vez do oponente
    if (!jogou) {
        WebUI.delay(1)
    }
}
// --- FECHAR ---
WebUI.closeBrowser()