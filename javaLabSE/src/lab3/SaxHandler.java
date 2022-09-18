package lab3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class SaxHandler extends DefaultHandler {
    private double calculatedAverage;
    private double avg;
    private boolean averageElement;
    private HashMap<String, Integer> subjects = new HashMap();
    private String lastName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("student")) {
            lastName = attributes.getValue("lastname");
        }
        if (qName.equalsIgnoreCase("subject")) {
            subjects.put(attributes.getValue("title"), Integer.parseInt(attributes.getValue("mark")));
            calculatedAverage += Double.parseDouble(attributes.getValue("mark"));
        }
        if(qName.equalsIgnoreCase("average")) {
            averageElement = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(averageElement) {
            String avgText = new String(ch,start,length).replace("\n", "").trim();
            avg = Double.parseDouble(avgText);
            averageElement = false;
        }

    }

    @Override
    public void endDocument() {
        calculatedAverage = calculatedAverage / subjects.size();
    }

    public double getCalculatedAverage() {
        return calculatedAverage;
    }

    public double getAvg() {
        return avg;
    }

    public HashMap<String, Integer> getSubjects() {
        return subjects;
    }

    public String getLastName() {
        return lastName;
    }
}
