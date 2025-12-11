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

// 1. Clica no link Registar da landing page
WebUI.waitForElementVisible(findTestObject('btn_registar'), 10)
WebUI.click(findTestObject('btn_registar'))

// 2. Espera o formulário aparecer
WebUI.waitForElementVisible(findTestObject('input_email'), 10)
WebUI.waitForElementVisible(findTestObject('input_Password'), 10)
WebUI.waitForElementVisible(findTestObject('input_nickname'), 10)
WebUI.waitForElementVisible(findTestObject('input_name'), 10)
WebUI.waitForElementVisible(findTestObject('input_AvatarURL'), 10)

// 3. Preenche os campos
WebUI.setText(findTestObject('input_email'), 'teste@email.com')
WebUI.setText(findTestObject('input_nickname'), 'MeuNick')
WebUI.setText(findTestObject('input_name'), 'MeuNome')
WebUI.setText(findTestObject('input_Password'), '123')
WebUI.setText(findTestObject('input_AvatarURL'), 'https://exemplo.com/avatar.jpg')

// 4. Clica no botão Registar
WebUI.click(findTestObject('btn_SubmitRegister'))


// 6. Fica 5 segundos na página logada
WebUI.delay(5)

WebUI.closeBrowser()