package project;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//XML 데이터를 파싱하는 클래스 (참고한 자료 https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=nonamed0000&logNo=220988048654)
public class getlunchAPI {
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	
	public static String[] ddish_nm = new String[31], mlsv_ymd = new String[31]; 

	public void main() {
		try{
				// parsing할 url 지정(API 키 포함해서)
				String url = "https://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010536&MLSV_FROM_YMD=20211101&MLSV_TO_YMD=20211130&KEY=a182603233f8472fb15ff5bbb226e0b2";

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("row");
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						ddish_nm[temp] = getTagValue("DDISH_NM", eElement);
						mlsv_ymd[temp] = getTagValue("MLSV_YMD", eElement);
					}	
				}	

		} catch (Exception e){	
			e.printStackTrace();
		}	
	}
}
