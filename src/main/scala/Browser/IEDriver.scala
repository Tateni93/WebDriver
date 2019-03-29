package Browser

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.ie.{InternetExplorerDriver, InternetExplorerOptions}
import org.openqa.selenium.remote.RemoteWebDriver

object IEDriver {

  def instance: WebDriver = {
    new InternetExplorerDriver()
  }

  def remoteInstance: WebDriver = {
    new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new InternetExplorerOptions())
  }
}
