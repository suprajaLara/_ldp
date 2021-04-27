import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HottestTemp {
    CSVRecord hottestDayOverall() throws IOException {
        CSVRecord largestSoFar = null;
        File directory = new File("/home/supram/Downloads/nc_weather/2015");
        File[] dirListing = directory.listFiles();
        CSVParser parser = null;
        if(dirListing!=null){
            for(File file : dirListing){
                parser = CSVParser.parse(file,StandardCharsets.UTF_8,CSVFormat.EXCEL.withDelimiter(',').withHeader());
                for(CSVRecord currentRow : parser){
                    largestSoFar=getMax(currentRow,largestSoFar);
                }
            }
        }
        return largestSoFar;
    }
    CSVRecord hottestDay(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser){
            largestSoFar=getMax(currentRow,largestSoFar);
        }
        return largestSoFar;
    }
    CSVRecord getMax(CSVRecord currentRow, CSVRecord largestSoFar){
            if(largestSoFar==null){
                largestSoFar=currentRow;
            }
            else {
                double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currTemp>largestTemp){
                    largestSoFar=currentRow;
                }
            }
            return largestSoFar;
    }
    void test() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/weather-2012-01-01.csv");
//        CSVRecord largest = hottestDay(CSVParser.parse(fis, StandardCharsets.UTF_8, CSVFormat.EXCEL.withDelimiter(',').withHeader()));
        CSVRecord largest = hottestDayOverall();
        System.out.println("hottest temp : "+largest.get("TemperatureF")+" at "+largest.get("DateUTC"));
    }

    public static void main(String[] args) throws IOException {
        HottestTemp p = new HottestTemp();
        p.test();
    }
}
