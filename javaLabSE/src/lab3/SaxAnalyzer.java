package lab3;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SaxAnalyzer implements Strategy {
    @Override
    public void check(String inputFile, String outputFile) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SaxHandler handler = new SaxHandler();
        parser.parse(new File(inputFile), handler);

        if (handler.getAvg() != handler.getCalculatedAverage()) {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(outputFile), "UTF-8");
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeDTD("<!DOCTYPE student SYSTEM \"student.dtd\">");
            xmlStreamWriter.writeStartElement("student");
            xmlStreamWriter.writeAttribute("lastname", handler.getLastName());

            for (Map.Entry<String, Integer> entry : handler.getSubjects().entrySet()) {
                xmlStreamWriter.writeStartElement("subject");
                xmlStreamWriter.writeAttribute("mark", String.valueOf(entry.getValue()));
                xmlStreamWriter.writeAttribute("title", entry.getKey());
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeStartElement("average");
            xmlStreamWriter.writeCharacters(String.valueOf(handler.getCalculatedAverage()));
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
        }
    }
}
