package lab3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Strategy {
    void check(String inputFile, String outputFile) throws ParserConfigurationException, TransformerException, IOException, SAXException, XMLStreamException;
}
