import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class FileUploadTest {
  @Test
  public void uploadFileWithPhantomJS() throws InterruptedException {
    PhantomJSDriver driver = new PhantomJSDriver();
    driver.navigate().to("http://blueimp.github.io/jQuery-File-Upload/basic.html");

//    This line fixes the problem with hanging PhantomJS:
//    driver.executeScript("$('#fileupload').removeAttr('multiple');");
    
    driver.findElement(By.id("fileupload")).sendKeys(new File("build.gradle").getAbsolutePath());

    sleep(2000);

    assertThat(driver.findElement(By.className("progress-bar")).getAttribute("class"), containsString("progress-bar-success"));
    assertThat(driver.findElement(By.id("files")).getText(), containsString("build.gradle"));
  }
}
