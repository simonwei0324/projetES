package xmltomysql.XMLTOSQL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Publication2DaoImp {
    public ArrayList<Publication> parseBooks(){  
    	ArrayList<Publication> list= new ArrayList<Publication>();
        SAXReader reader = new SAXReader();  
        try {  
            Document doc = reader.read("/Users/weiliu/eclipse-workspace/XMLTOSQL/sourcedocs/unité.xml");  
            Element rootElm =doc.getRootElement();  
            System.out.println("根元素："+rootElm.getName());
           // Node nodeMedlineCitation = doc.selectSingleNode("/PubmedArticle/MedlineCitation");
           // List list = root.selectNodes("PubmedArticle");  
            //List<Element> list = root.selectNodes("PubmedArticle");
            //List<Element> list=((Element) root).elements();
            //List<Element> listMedlineCitation=((Element) nodeMedlineCitation).elements();
            for(Iterator it=rootElm.elementIterator();it.hasNext();){

            	Element element = (Element) it.next();
            	Publication publication = new Publication();
            	if("PMID".equals(element.getName())){
					publication.setPMID(Integer.parseInt(element.getText()));
				}if("ArticleTitle".equals(element.getName())){
					publication.setArticleTitle(element.getText());
				}if("KeywordList".equals(element.getName())){
					publication.setKeywordList(element.getText());
				}if("AbstractText".equals(element.getName())){
					publication.setAbstractText(element.getText());
				}if("ArticleIdList".equals(element.getName())){
					publication.setArticleIdList(element.getText());
				}if("Journal".equals(element.getName())){
					publication.setArticleIdList(element.getText());
				}if("AuthorList".equals(element.getName())){
					publication.setAuthorList(element.getText());
				}else if("Year".equals(element.getName())){
					publication.setYear(element.getText());
				}

            	//do something
				   list.add(publication);
            } 
		    for(Publication publication2 : list){  //为了查看数据是否正确，进行打印结果
	             System.out.println(publication2.toString());  
	         } 
         
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return list;
    }  

}
