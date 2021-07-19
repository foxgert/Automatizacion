package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class util extends hooks {
        public static WebDriverWait wait;
       public util() {
          wait = new WebDriverWait(driver, 30 );
    }

       public void ventanaActiva(){
             Set<String> identificadores = driver.getWindowHandles();
                for (String identificador:identificadores){
            driver.switchTo().window(identificador);
        }
    }
       public void ventanaInicial(){
           driver.close();
            driver.switchTo().window("");
    }

    public static void evidencia() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        String path = "C:\\Users\\Christian\\IdeaProjects\\proyectoweb\\target\\evidencias\\";
        String nombre = formato.format(fecha)+"_evidencia.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path+nombre));
    }

}
