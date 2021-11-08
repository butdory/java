package test;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static test.login.a;
import static test.login.c;

public class getTimetableAPI {

    // tag���� ������ �������� �޼ҵ�
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public static void main(String[] args) {
		String class_nm = null;
		String grade = null;
		int page = 1;	// ������ �ʱⰪ 
		try{
			while(true){
				// parsing�� url ����(API Ű �����ؼ�)
				String url = "https://open.neis.go.kr/hub/hisTimetable?ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010536&CLASS_NM"+c+"&GRADE="+a+"&KEY=a182603233f8472fb15ff5bbb226e0b2&TI_FROM_YMD=20211101&TI_TO_YMD=20211105"+page;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// �Ľ��� tag
				NodeList nList = doc.getElementsByTagName("baseinfo");
				//System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						System.out.println("������  : " + getTagValue("kor_co_nm", eElement));
						System.out.println("��ǰ �ڵ�  : " + getTagValue("fin_prdt_cd", eElement));
						System.out.println("��ǰ�� : " + getTagValue("fin_prdt_nm", eElement));
						System.out.println("����� ���ͷ�  : " + getTagValue("avg_prft_rate", eElement));
						System.out.println("���� ����  : " + getTagValue("dcls_rate", eElement));
					}	// for end
				}	// if end
				
				page += 1;
				System.out.println("page number : "+page);
				if(page > 12){	
					break;
				}
			}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
	}	// main end
}	// class end