package Browser

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}

object BrowserStackDriver {

  def instance(): WebDriver = {
    val desiredCaps = new DesiredCapabilities()
    desiredCaps.setCapability("browserstack.debug", "true")
    desiredCaps.setCapability("browserstack.local", "true")
    desiredCaps.setCapability("acceptSslCerts", "true")
    desiredCaps.setCapability("project", "AWRS")
    desiredCaps.setCapability("build", "Local")
    desiredCaps.setCapability("nativeEvents", "true")

    List("browserstack.os", "browserstack.os_version", "browserstack.browser", "browserstack.device", "browserstack.browser_version", "browserstack.real_mobile")
      .map(k => (k, sys.props.get(k)))
      .collect({case (k, Some(v)) => (k, v)})
      .foreach(x => desiredCaps.setCapability(x._1.replace("browserstack.", ""), x._2.replace("_"," ")))

    val username = sys.props.getOrElse("browserstack.username", "notspecified")
    val automateKey = sys.props.getOrElse("browserstack.key", "notspecified")
    val url = s"http://$username:$automateKey@hub.browserstack.com/wd/hub"

    val remoteDriver = new RemoteWebDriver(new URL(url), desiredCaps)
    remoteDriver
  }
}
