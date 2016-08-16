/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrapper;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Map;

/**
 *
 * @author Ramon
 */
public class WebScrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        /*Map<String, String> topics;
        Searcher s = new Searcher();
        topics = s.search("https://pt.wikipedia.org/wiki/Ga%C3%BAcho");
        PrintWriter writer = new PrintWriter("gaucho.txt", "UTF-8");
        
        for(Map.Entry<String, String> topic : topics.entrySet()){
            writer.println(topic.getKey());
            writer.println();
            writer.println(topic.getValue());
            writer.println("==================");
        }*/
        WebScrapperScreen wss = new WebScrapperScreen();
        wss.setVisible(true);
    
    }
    
}
