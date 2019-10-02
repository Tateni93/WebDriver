package Browser

import org.openqa.selenium.WebDriver
import scala.util.Try

object Browser extends Browser

class Browser {

 lazy val driver: WebDriver= {
    sys.props.get("browser").map(_.toLowerCase) match {
      case Some("chrome") => ChromeDriver.instance(false, false)
      case Some("zap-chrome") => ChromeDriver.instance(true, false)
      case Some("remote-chrome") => ChromeDriver.instance(false,true)
      case Some("remote-zap-chrome") => ChromeDriver.instance(true, true)
      case Some("firefox") => FirefoxDriver.instance(false, false)
      case Some("zap-firefox") => FirefoxDriver.instance(true, false)
      case Some("remote-firefox") => FirefoxDriver.instance(false, true)
      case Some("remote-zap-firefox") => FirefoxDriver.instance(true, true)
      case Some("ie") => IEDriver.instance
      case Some("remote-ie") => IEDriver.remoteInstance
      case Some("browserstack") => BrowserStackDriver.instance
      case _ =>
        println(s"Browser not recognized! Running tests in Chrome!")
        ChromeDriver.instance(false, false)
    }
  }
}
