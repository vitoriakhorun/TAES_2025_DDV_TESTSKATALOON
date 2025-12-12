import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
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
WebUI.click(findTestObject('btn_bisca3'))
WebUI.waitForElementVisible(findTestObject('pag_tabuleirobisca3'), 10)

// --- LOOP DO JOGO ---
boolean fimDoJogo = false

while (!fimDoJogo) {

	
	// Verifica fim do jogo
	if (WebUI.verifyElementVisible(findTestObject('btn_jogarnovamente'), FailureHandling.OPTIONAL)) {
		println("Jogo terminou!")
		break
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
		WebUI.delay(0.2)
	}
}

// --- FECHAR ---
WebUI.closeBrowser()
