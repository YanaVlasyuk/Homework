import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpotifyTest {
    WebDriver driver;
    String email = "janusjka30@mail.ru";
    String password = "W40796duotech";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSpotify() throws InterruptedException {
        driver.get("https://open.spotify.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        WebElement profileIcon = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']"));
        Assert.assertTrue(profileIcon.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/search']")).click();
        Thread.sleep(3000);

        WebElement searchBar = driver.findElement(By.xpath("//input[@data-testid='search-input']"));
        searchBar.sendKeys("Adele Hello");
        searchBar.click();
        Thread.sleep(3000);

        WebElement playButton = driver.findElement(By.xpath("//button[@aria-label='Play']"));
        playButton.click();
        Thread.sleep(3000);

        //not uniqe but it founded
        WebElement songName = driver.findElement(By.className("PcH6VnzkkDqD36P93i9Q"));
        String displayedSongName = songName.getText();
        Assert.assertEquals(displayedSongName, "Hello");

        WebElement artistName = driver.findElement(By.xpath("//div[@data-testid='context-item-info-subtitles']"));
        String displayedArtistName = artistName.getText();
        Assert.assertEquals(displayedArtistName, "Adele");

        profileIcon.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@data-testid='username-first-letter']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Log out']")).click();
        Thread.sleep(2000);

       // WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid='login-button']"));
       // Assert.assertTrue(loginButton.isDisplayed());
        //  driver.quit();
    }
        }


