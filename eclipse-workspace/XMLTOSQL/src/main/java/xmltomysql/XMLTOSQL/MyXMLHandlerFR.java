package xmltomysql.XMLTOSQL;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandlerFR extends DefaultHandler{


		
		private String node = null;
		public String pmid;
		public String langue;
		public String titre;
		public String resume;
		private List<ArticleFR> articleList = null;
		public ArticleFR article;
		
	    public List<ArticleFR> getarticleList() {
	        return articleList;
	    }

		   //début du parsing
		   public void startDocument() throws SAXException {
		      System.out.println("Début du parsing");
		   }
		   //fin du parsing
		   public void endDocument() throws SAXException {
			 
		      System.out.println("Fin du parsing");
		   }
		   
		   //Redéfinition de la méthode pour intercepter les événements
		   public void startElement(String namespaceURI, String lname, String qname, Attributes attrs) throws SAXException {
		      node = qname;
		      
		      if(qname.equals("database")) {
		    	 article=new ArticleFR();
		    	 
		    	 if (articleList == null)
		    		 articleList = new ArrayList< ArticleFR>();
		    	 	articleList.add(article);
		      }
		   } 
		   
		   	
		   public void endElement(String uri, String localName, String qName) throws SAXException{ 
			 
			   
		   }
		   
		   //permet de récupérer la valeur d'un nœud
		   public void characters(char[] data, int start, int end) {  
			   
		      //La variable data contient tout notre fichier.
		      //Pour récupérer la valeur, nous devons nous servir des limites en paramètre
		      //"start" correspond à l'indice où commence la valeur recherchée
		      //"end" correspond à la longueur de la chaîne
		      
		      String str = new String(data, start, end);
		      
		      if(node.equals("REF")) {
		    	  article.setId(str);
		      }  else if (node.equals("item")) {
		    	  article.setTitre(str);
		      } else if(node.equals("Resum")) {
		    	  article.setResume(str);
		      } else if(node.equals("DatEdit")) {
		    	  article.setPostdate(str);
		      }else if(node.equals("MotsCles/item")) {
		    	  article.setKeyword(str);
		      }else if(node.equals("Issn")) {
		    	  article.setUrl(str);
		      }else if(node.equals("Ident")) {
		    	  article.setReply(str);
		      }else if(node.equals("TitPerio")) {
		    	  article.setSource(str);
		      }
		      
		      
		    
		   }
		   


}
