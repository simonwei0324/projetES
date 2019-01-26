package xmltomysql.XMLTOSQL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PublicationDaoImp implements PublicationDao {
	public ArrayList<Publication> getParserAuthor() {
		ArrayList<Publication> list= new ArrayList<Publication>();
		//获取DOM解析器
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			   SAXReader reader = new SAXReader();  
			   builder = factory.newDocumentBuilder();
			   Document doc;
			   	//这里所有的xml文档结构要一样好，不然就手动逐个文档解析插入数据库
				String path = "/Users/weiliu/eclipse-workspace/XMLTOSQL/sourceDOCs";		//要遍历的路径
				File file = new File(path);		//获取其file对象
				File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
				for(File f:fs){					//遍历File[]数组
					if(!f.isDirectory())		//若非目录(即文件)，则打印
						System.out.println(f);
						doc = builder.parse(f);
				
			   //doc = builder.parse(new File("AjayGupta.xml"));
		           //得到一个element根元素,获得根节点
			    Element root = doc.getDocumentElement();	    
			    System.out.println("根元素："+root.getNodeName());
			    
			    //子节点
			    NodeList personNodes = root.getElementsByTagName("PubmedArticle");
			    for(int i = 0; i<personNodes.getLength();i++){
			    	Element personElement = (Element) personNodes.item(i);
			    	Publication publication = new Publication();
			    	NodeList childNodes = personElement.getChildNodes();
			    	//System.out.println("*****"+childNodes.getLength());  
			    	
			    	for (int j = 0; j < childNodes.getLength(); j++) {
					if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
						if("PMID".equals(childNodes.item(j).getNodeName())){
							publication.setId(Integer.parseInt(childNodes.item(j).getFirstChild().getNodeValue()));
						}if("ArticleTitle".equals(childNodes.item(j).getNodeName())){
							publication.setTitle(childNodes.item(j).getFirstChild().getNodeValue());
						}if("KeywordList".equals(childNodes.item(j).getNodeName())){
							publication.setKey_word(childNodes.item(j).getFirstChild().getNodeValue());
						}if("AbstractText".equals(childNodes.item(j).getNodeName())){
							publication.setContent(childNodes.item(j).getFirstChild().getNodeValue());
						}if("ArticleIdList".equals(childNodes.item(j).getNodeName())){
							publication.setUrl(childNodes.item(j).getFirstChild().getNodeValue());
						}if("Journal".equals(childNodes.item(j).getNodeName())){
							publication.setReply(childNodes.item(j).getFirstChild().getNodeValue());
						}if("AuthorList".equals(childNodes.item(j).getNodeName())){
							publication.setSource(childNodes.item(j).getFirstChild().getNodeValue());
						}else if("Year".equals(childNodes.item(j).getNodeName())){
							publication.setPostdate(childNodes.item(j).getFirstChild().getNodeValue());
						}
					}
				}
			    	list.add(publication);
			    }
			    for(Publication publication2 : list){  //为了查看数据是否正确，进行打印结果
		             System.out.println(publication2.toString());  
		         } 
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return list;
	       
	}
}
