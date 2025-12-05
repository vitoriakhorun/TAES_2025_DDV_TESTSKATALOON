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

WebUI.openBrowser('http://localhost:5173/')

// Espera o link Login aparecer
WebUI.waitForElementVisible(findTestObject('btn_login'), 10)

// Clica no link para abrir o formulário de login
WebUI.click(findTestObject('btn_login'))

WebUI.waitForElementVisible(findTestObject('email'), 10)
WebUI.waitForElementVisible(findTestObject('password'), 10)


WebUI.setText(findTestObject('email'), 'pe@mail.pt')
WebUI.setText(findTestObject('password'), '123')

WebUI.click(findTestObject('btn_signin'))

// Espera a pagina aparecer
WebUI.waitForElementVisible(findTestObject('pag_inicial_logada'), 10)

// Espera e hover sobre o menu account
WebUI.waitForElementVisible(findTestObject('btn_account'), 10)
WebUI.mouseOver(findTestObject('btn_account'))

// Agora o botão "profile" aparece
WebUI.waitForElementVisible(findTestObject('btn_profile'), 10)
WebUI.click(findTestObject('btn_profile'))

WebUI.waitForElementVisible(findTestObject('pag_my_profile'), 10)

WebUI.waitForElementVisible(findTestObject('btn_veraccount'), 10)
WebUI.click(findTestObject('btn_veraccount'))

WebUI.delay(1)
WebUI.click(findTestObject('seta_ultimaspartidas'))

WebUI.delay(2)
WebUI.closeBrowser()
