package config;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


// ≈‰÷√∂¡»°∆˜
public class ConfigReader {
	public static void readConfig() throws Exception{
		SAXReader read = new SAXReader();
		Document doc = read.read("config/cfg.xml");
		Element game = doc.getRootElement();
		Element frame = game.element("frame");
		String str = frame.attributeValue("width");
		System.out.println("frame width: " + str);
		
		List<Element> lays = frame.elements("lay");
		for(Element lay: lays){
			System.out.print(lay.attribute("class") + ", ");
			System.out.print(lay.attribute("x") + ", ");
			System.out.print(lay.attribute("y") + ", ");
			System.out.print(lay.attribute("w") + ", ");
			System.out.print(lay.attribute("h") + ", ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		readConfig();
	}
}
