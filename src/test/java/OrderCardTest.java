import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Петр Иванович");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79012345678");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();
        assertEquals(expected, actual);
    }

//    @Test
//    void invalidPhone1() {
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Петр Иванович");
//        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("89012345678");
//        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
//        driver.findElement(By.className("button__text")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input_sub")).getText();
//        assertEquals(expected, actual);
//    }


}
