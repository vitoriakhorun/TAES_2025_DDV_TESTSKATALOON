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

// Abre o browser
// Abre o browser e vai para a aplicação
WebUI.openBrowser('http://localhost:3001/')

// Espera o link de Login aparecer e clica
WebUI.waitForElementVisible(findTestObject('btn_login'), 10)
WebUI.click(findTestObject('btn_login'))

// Espera o formulário de login aparecer
WebUI.waitForElementVisible(findTestObject('email'), 10)
WebUI.waitForElementVisible(findTestObject('password'), 10)

// Preenche os campos de login
WebUI.setText(findTestObject('email'), 'teste@email.com')
WebUI.setText(findTestObject('password'), '123456')

// Submete o formulário
WebUI.click(findTestObject('btn_submit'))

// Espera o botão "Jogar Agora" aparecer
WebUI.waitForElementVisible(findTestObject('btn_play_now'), 20)
WebUI.click(findTestObject('btn_play_now'))

// Pequeno delay para o componente SPA carregar
WebUI.delay(2)

// Espera o botão "Jogar" na seção "Modo de Jogo" aparecer
WebUI.waitForElementVisible(findTestObject('btn_play_card'), 20)

// Clica no botão "Jogar"
WebUI.click(findTestObject('btn_play_card'))

// Pequeno delay para o jogo carregar
WebUI.delay(2)

// Espera o input do nome do jogador aparecer
WebUI.waitForElementVisible(findTestObject('input_player_name'), 10)

// Preenche o nome do jogador
WebUI.setText(findTestObject('input_player_name'), 'MeuNome')

// Clica no botão "Conectar"
WebUI.click(findTestObject('btn_conectar'))

// Espera alguns segundos para o jogo iniciar
WebUI.delay(3)

// Se o botão "Novo Jogo" estiver habilitado, clica
WebUI.waitForElementVisible(findTestObject('btn_novojogo'), 10, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('btn_novojogo', FailureHandling.OPTIONAL))
WebUI.closeBrowser()