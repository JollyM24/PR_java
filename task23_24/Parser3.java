package task23_24;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class Parser3 {
    private static String folderName = "C:/Пользователи/Мария/Рабочий стол/Программы/PracticaJava";
    //File folder = new File(folderName);
    private static String filefoldername = folderName + "/";

    public abstract String replace(CharSequence target, CharSequence replacement);

    public static void main(String[] args) throws IOException {
        String strURL = "https://student.mirea.ru/media/photo/#photoDetails"; //галерея МИРЭА
        Document document = Jsoup.connect(strURL).timeout(50 * 1000).get();
        Elements SiteElements = document.select("a[class=\"u-link-v2\"]"); //ссылки на папки галереи

        for (Element SiteElement : SiteElements) {
            String strSiteURL = SiteElement.attr("abs:href"); //открыли папку на сайте
            Document doc = Jsoup.connect(String.valueOf(new URL(strSiteURL))).timeout(50 * 1000).get(); //коннект
            Elements docElements = doc.select("img"); //находим картинки
            String nameoffolder = doc.select("h2[class=\"text-uppercase u-heading-v2__title g-mb-5\"]").text(); //название папки
            //System.out.println(nameoffolder);
            String replacedname = nameoffolder.replaceAll("\"", "«"); //меняем кавычки
            filefoldername += replacedname;
            System.out.println(filefoldername);
            File filefolder = new File(filefoldername); //создание папки
            filefolder.mkdir();

            for (Element docsElement : docElements) {//Все фотографии с папки
                //System.out.println(docsElement);
                String strImageURL = docsElement.attr("abs:src");
                downloadImage(strImageURL);
            }

            filefoldername = folderName + "/";
        }
    }

    private static void downloadImage(String strImageURL){
        String fileName = strImageURL.substring( strImageURL.lastIndexOf("/") + 1);
        try {
            URL urlImage = new URL(strImageURL);
            BufferedImage Img = ImageIO.read(urlImage);
            File file = new File(filefoldername, fileName);
            file.createNewFile();
            ImageIO.write(Img,"jpg" , file);
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
}
