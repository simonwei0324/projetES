package xmltomysql.XMLTOSQL;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;


public class Main {
	
	//private static EnglishAnalyzer analyzer = new EnglishAnalyzer(Version.LUCENE_40, EnglishAnalyzer.getDefaultStopSet());
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        /* article_en */
        
        MyXMLHandler handler = new MyXMLHandler();
        parser.parse("/Users/weiliu/eclipse-workspace/XMLTOSQL/sourcedocs/pubmed19n0972.xml", handler);
        //Article article=handler.getArticle();
        List<Article> empList = handler.getarticleList();
        
        for(Article emp : empList) {
            System.out.println(emp);
   
        }
        
    
        
        /* article_fr */
        /*
        MyXMLHandlerFR handler = new MyXMLHandlerFR();
        parser.parse("/Users/weiliu/eclipse-workspace/XMLTOSQL/sourcedocs/articles_fr.xml", handler);
        //Article article=handler.getArticle();
        List<ArticleFR> empList = handler.getarticleList();
        
        for(ArticleFR emp : empList) {
            System.out.println(emp);
   
        }
        */
        
      
		for(int i=0;i<empList.size();i++)
		{			
			if (empList.get(i)!=null)
			
			ConnectSql.writeToMysql(empList.get(i));
		}
	

        
			  	  
	}
	
	
}
