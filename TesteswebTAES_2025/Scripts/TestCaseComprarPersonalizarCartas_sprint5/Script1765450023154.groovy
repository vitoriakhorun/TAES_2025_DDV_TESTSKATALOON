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

// --- ABRIR BROWSER E ACEDER AO SITE ---
WebUI.openBrowser('http://localhost:5173/')
WebUI.maximizeWindow()

// --- LOGIN ---
WebUI.waitForElementVisible(findTestObject('btn_login'), 10)
WebUI.click(findTestObject('btn_login'))

WebUI.waitForElementVisible(findTestObject('email'), 10)
WebUI.waitForElementVisible(findTestObject('password'), 10)
WebUI.setText(findTestObject('email'), 'pa@mail.pt')
WebUI.setText(findTestObject('password'), '123')

WebUI.click(findTestObject('btn_signin'))

WebUI.waitForElementVisible(findTestObject('pag_inicial_logada'), 10)

// --- NAVEGAR PARA LOJA ---
WebUI.click(findTestObject('btn_shop'))

// --- VERIFICAR BOTÃO "Comprar Personalização" ---
WebUI.verifyElementVisible(findTestObject('btn_comprarpersonalizacao'), FailureHandling.OPTIONAL)
    WebUI.click(findTestObject('btn_comprarpersonalizacao'))

    // Espera e aceita alert de confirmação
    WebUI.waitForAlert(5)
    WebUI.acceptAlert()

    WebUI.delay(1)

    // Scroll até ao fim da página
    WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
    WebUI.delay(2)


// --- FECHAR BROWSER ---
WebUI.closeBrowser()