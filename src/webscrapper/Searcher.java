/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrapper;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ramon
 */
public class Searcher {

    public Searcher() {
    }
    
    /**
     *
     * @param searchUrl = Search url for brazilian portuguese wiki
     * @return Map
     */
    public Map search(String searchUrl){
        searchUrl = searchUrl.replace("https", "http");
        Map<String, String>topics = new HashMap<String, String>();
        try{
            UserAgent userAgent = new UserAgent();
            userAgent.visit(searchUrl);
            
            String mainKey = userAgent.doc.findFirst("<h1>").getText();
            
            String mainTopic = "";
            Elements el = userAgent.doc.findEach("<p>");
            for(Element e: el){
                mainTopic = mainTopic.concat(e.innerText());
            }
            
            topics.put(mainKey, mainTopic);
            
            Elements links = userAgent.doc.findEach("<p>");
            for(Element link: links){
                for(Element lin: link.findEach("<a>")){
                    
                    if(!lin.outerHTML().contains("existe")){
                        String nextPage = lin.getAtString("href");
                        userAgent.visit(nextPage);
                        
                        String key = userAgent.doc.findFirst("<h1>").getText();
                        Elements paragrafos = userAgent.doc.findEach("<p>");

                        String topic = "";
                        
                        for(Element e: paragrafos){
                            topic = topic.concat(System.lineSeparator());
                            topic = topic.concat(e.innerText());
                        }
                        
                        topics.put(key, topic);
                        
                    }
                }
            }

          }
          catch(JauntException e){
            System.err.println(e);
          }
        return topics;
    }
}
