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
WebUI.click(findTestObject('btn_bisca9'))
WebUI.waitForElementVisible(findTestObject('pag_tabuleirobisca9'), 10)

// --- SEMPRE JOGAR CARTA1 ---
TestObject carta1 = findTestObject('carta1')
boolean fimDoJogo = false

while (!fimDoJogo) {

    // Se aparecer o botão "Jogar Novamente", o jogo acabou
    if (WebUI.verifyElementVisible(findTestObject('btn_jogarnovamente'), FailureHandling.OPTIONAL)) {
        println("Jogo terminou!")
        fimDoJogo = true
        break
    }

    // Tenta clicar na carta1
    if (WebUI.verifyElementVisible(carta1, FailureHandling.OPTIONAL)) {
        WebUI.click(carta1)
        WebUI.delay(0.2)
    } else {
        // Aguarda oponente jogar
        WebUI.delay(0.2)
    }
}

// --- OPCIONAL: clicar em jogar novamente ---
if (WebUI.verifyElementVisible(findTestObject('btn_jogarnovamente'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('btn_jogarnovamente'))
}

// --- FECHAR BROWSER ---
WebUI.closeBrowser()
