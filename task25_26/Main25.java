package task25_26;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;

public class Main25 {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.fileJson();
    }

    public static class Parser {
        FileWriter file;
        Document doc;
        JsonObject result = new JsonObject();
        String strURL = "https://www.moscowmap.ru/metro.html#lines";

        public Parser() {
            try {
                doc = Jsoup.connect(strURL).maxBodySize(0).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JsonObject stations = new JsonObject();
            JsonArray lines = new JsonArray();

            result.add("stations", stations);
            result.add("lines", lines);

            Elements station = doc.select("span[class=\"js-metro-stations\"]");
            for (Element s : station) {
                JsonArray stationName = new JsonArray();
                Elements sName = s.select("span[class=\"name\"]");
                for (Element elem : sName) stationName.add(elem.text());
                stations.add(s.attr("data-line"), stationName);
            }

            Elements line = doc.select("span[class=\"js-metro-line\"]");
            for (Element l : line) {
                JsonObject lineNumName = new JsonObject();
                lineNumName.addProperty("number", l.attr("data-line"));
                lineNumName.addProperty("name", l.text());
                lines.add(lineNumName);
            }
        }
             public void fileJson(){
                String metro = result.toString();
                try {
                    file = new FileWriter("metro.json", false);
                    file.write(metro);
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    FileReader file2 = new FileReader("metro.json");
                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = (JsonObject) jsonParser.parse(file2);

                    JsonArray count = (JsonArray) jsonObject.get("stations");
                    System.out.println("Количество станций на каждой линии: ");

                    for (int i = 0; i < count.size(); i++) {
                        int stationCount = ((JsonArray) count.get(i)).size();
                        System.out.println(i + ": " + stationCount);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}


