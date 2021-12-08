import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLHandler extends DefaultHandler {

    ArrayList<Students> students;
    public static ArrayList<String> subjects = new ArrayList<>();
    public static ArrayList<Integer> marks = new ArrayList<>();
    String firstName;
    String lastName;
    String groupNumber;
    Double average;
    private String lastElem;

    public XMLHandler(ArrayList<Students> students) {
        this.students = students;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Next element wasn't found. Parsing done.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Found element " + qName + ", start parsing...");

        if (qName.equalsIgnoreCase("student")) {
            firstName = attributes.getValue("firstname");
            lastName = attributes.getValue("lastname");
            groupNumber = attributes.getValue("groupnumber");
        }

        if (qName.equalsIgnoreCase("subject")) {
            String subject = attributes.getValue("title");
            String mark = attributes.getValue("mark");
            subjects.add(subject);
            marks.add(Integer.parseInt(mark));

        }


        lastElem = qName;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String info = new String(ch, start, length);

        info = info.replace("\n", "");

        try {
            if (!info.isEmpty()) {
                if (lastElem.equalsIgnoreCase("average")) {
                    average = Double.parseDouble(info);
                }
            }
        } catch (NumberFormatException exc) {
            average = 0.0;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            students.add(new Students(firstName, lastName, groupNumber, subjects, marks, average));

            subjects.clear();
            marks.clear();
        }

        System.out.println("Parsed element " + qName + ", searching for next...");
    }
}