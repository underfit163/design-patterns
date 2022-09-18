package lab3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomAnalyzer implements Strategy {

    @Override
    public void check(String inputFile, String outputFile) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File(inputFile);
        Document doc = builder.parse(f);
        Element studentElement = doc.getDocumentElement();
        NodeList subNodeList = studentElement.getElementsByTagName("subject");
        double avg = 0;
        for (int i = 0; i < subNodeList.getLength(); i++) {
            Element subElem = (Element) subNodeList.item(i);
            avg += Double.parseDouble(subElem.getAttribute("mark"));
        }
        avg /= subNodeList.getLength();
        NodeList avgNL = studentElement.getElementsByTagName("average");
        Node avgN = avgNL.item(0);
        double avgXML = Double.parseDouble(avgN.getTextContent());

        if (avg != avgXML) {
            Document doc1 = builder.newDocument();
            Element studentEl2XML = doc1.createElement("student");
            studentEl2XML.setAttribute("lastname", studentElement.getAttribute("lastname"));
            doc1.appendChild(studentEl2XML);

            for (int i = 0; i < subNodeList.getLength(); i++) {
                Element subElem1XML = (Element) subNodeList.item(i);
                Element subEl2XML = doc1.createElement("subject");
                subEl2XML.setAttribute("title", subElem1XML.getAttribute("title"));
                subEl2XML.setAttribute("mark", subElem1XML.getAttribute("mark"));
                studentEl2XML.appendChild(subEl2XML);
            }
            Element avgEl2 = doc1.createElement("average");
            Text avgText = doc1.createTextNode(String.valueOf(avg));
            avgEl2.appendChild(avgText);
            studentEl2XML.appendChild(avgEl2);

            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "student.dtd");
            t.transform(new DOMSource(doc1), new StreamResult(new FileOutputStream(outputFile)));
        }
    }
}
