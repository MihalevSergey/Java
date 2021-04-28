import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Document getPage() throws Exception {
        String url = "http://pogoda.spb.ru";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    //22.04 Суббога погода сегодня
    //22.04
    // \d(2)\.\d(2)
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("can't extract date from string");
    }

    private static int printFromValues(Elements values, int index) {
        int iterationCount = 4;
        if (index == 0) {
            Element valueLine = values.get(3);
            boolean isMorning = valueLine.text().contains("Утро");
            boolean isDay = valueLine.text().contains("День");
            boolean isEvening = valueLine.text().contains("Вечер");
            if (isMorning) {
                iterationCount = 3;
            }else if (isDay) {
                iterationCount = 2;
            }else if (isEvening) {
                iterationCount = 1;
            }
        }

        for (int i = 0; i < iterationCount; i++) {
            Element valueLine = values.get(index + i);
            for (Element td : valueLine.select("td")) {
                System.out.print(td.text() + " ");
            }
            System.out.println();
        }
        return iterationCount;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        // css query language
        Element tablewth = page.select("table[class = wt]").first();
        Elements names = tablewth.select("tr[class = wth]");
        Elements values = tablewth.select("tr[valign = top]");

        int index = 0;


        for (Element name : names) {
            String dateString = name.select("th[id = dt]").text();
            String date = getDateFromString(dateString);
            System.out.println(date + "   Облачность  Влажность Осадки  Температура    Давление      Ветер");
            int iterationCount = printFromValues(values, index);
            index = index + iterationCount;
        }

    }

}