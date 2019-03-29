package Browser

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions, FirefoxProfile}
import org.openqa.selenium.remote.RemoteWebDriver

object FirefoxDriver {

  def instance(zapMode: Boolean, remoteDriver: Boolean): WebDriver = {
    val options = firefoxOptions(zapMode)
    if (remoteDriver) new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), options)
    else new FirefoxDriver(options)
  }

  private def firefoxOptions(zapMode:Boolean): FirefoxOptions = {
    val options = new FirefoxOptions()
    val profile = new FirefoxProfile()
    if (zapMode) {
      profile.setAcceptUntrustedCertificates(true)
      profile.setPreference("network.proxy.type", 1)
      profile.setPreference("network.proxy.http", "localhost")
      profile.setPreference("network.proxy.http_port", 11000)
      profile.setPreference("network.proxy.share_proxy_settings", true)
      profile.setPreference("network.proxy.no_proxies_on", "")
      options.setProfile(profile)
    }
    else options
  }
}
