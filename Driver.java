package cura.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.SessionId;

import static cura.config.Config.*;

public class Driver {

	public static WebDriver driver;

	public static void intializeDriver() {

		switch (BROWSER.toUpperCase()) {

		case "CHROME":
			System.out.println("Info : Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			ChromeOptions choption = new ChromeOptions();
			choption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(choption);
			SessionId session = ((ChromeDriver) driver).getSessionId();
			System.out.println("Current Chrome Driver Session ID : " + session.toString());
			break;

		case "FIREFOX":
			System.out.println("Info : Launching Firefox Browser");
			System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
			FirefoxOptions ffoption = new FirefoxOptions();
			ffoption.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			driver = new FirefoxDriver(ffoption);
			SessionId FFsession = ((FirefoxDriver) driver).getSessionId();
			System.out.println("Current Firefox Driver Session ID ::" + FFsession.toString());
			break;

		case "IE":
			System.out.println("Info : Launching IE Browser");
			System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
			InternetExplorerOptions ieOption = new InternetExplorerOptions();
			ieOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			driver = new InternetExplorerDriver(ieOption);
			SessionId IESession = ((InternetExplorerDriver) driver).getSessionId();
			System.out.println("Current IE Driver Session ID ::" + IESession.toString());
			break;

		case "EDGE":
			System.out.println("Info : Launching Edge Browser");
			System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);

			EdgeOptions edgeOption = new EdgeOptions();
			edgeOption.setPageLoadStrategy(PageLoadStrategy.NORMAL.toString());

			driver = new EdgeDriver(edgeOption);
			SessionId edgeSession = ((EdgeDriver) driver).getSessionId();
			System.out.println("Current Edge Driver Session ID ::" + edgeSession.toString());
			break;

		case "OPERA":
			System.out.println("Info : Launching Opera Browser");
			System.setProperty("webdriver.opera.driver", OPERA_DRIVER_PATH);

			// OperaOptions operaOption = new OperaOptions();

			driver = new OperaDriver();

			SessionId operaSession = ((OperaDriver) driver).getSessionId();
			System.out.println("Current Opera Driver Session ID ::" + operaSession.toString());
			break;

		default:
			System.out.println("Info : Launching default Browser Chrome");
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			ChromeOptions chOption = new ChromeOptions();
			chOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chOption);
			SessionId chSession = ((ChromeDriver) driver).getSessionId();
			System.out.println("Current Chrome Driver Session ID : " + chSession.toString());
			break;

		}	
	}
	
	public static void navigateToURL() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
	}

	public static void tearDownDriver() {
		driver.quit();
	}
}
