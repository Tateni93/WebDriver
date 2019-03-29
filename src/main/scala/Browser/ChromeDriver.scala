package Browser

import java.net.URL

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.remote.RemoteWebDriver

object ChromeDriver {

  def instance(zapMode: Boolean, remoteDriver: Boolean):RemoteWebDriver = {
    val options = chromeOptions(zapMode)
    if (remoteDriver) new RemoteWebDriver(new URL(s"http://localhost:4444/wd/hub"), options)
    else new ChromeDriver(options)
  }

  private def chromeOptions(zapMode: Boolean): ChromeOptions = {
    val options = new ChromeOptions()
    if (zapMode) {
      options.addArguments("--proxy-server=http://localhost:11000")
    }
    else options
  }
}
