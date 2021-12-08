import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static ArrayList<Students> students = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File xmlFile = new File("src/main/resources/group.xml");
        File editedFile = new File("src/main/resources/group-edit.xml");

        if (editedFile.exists()) {
            editedFile.delete();
            editedFile.createNewFile();
        }

        System.out.println("What parser you want to activate?\n" +
                "\t1. SAX parser. (can't modify XML file)\n" +
                "\t2. DOM parser. (can modify XML file)\n" +
                "\t3. I'm sorry.");

        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        try {
            menu = scanner.nextInt();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        switch (menu) {
            case 1:
                startSAXParser(students, xmlFile);
                return;
            case 2:
                startDOMParser(students, xmlFile, editedFile);
                return;
            case 3:
                System.exit(0);
                return;
            default:
                System.out.println("Something went wrong.");
                return;
        }
    }

    private static void startDOMParser(ArrayList<Students> students, File xmlFile, File editedFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory DOMFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = DOMFactory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        NodeList studentElements = document.getDocumentElement().getElementsByTagName("student");

        for (int i = 0; i < studentElements.getLength(); i++) {
            Node studentNode = studentElements.item(i);

            ArrayList<String> subjectsList = new ArrayList<>();
            ArrayList<Integer> marksList = new ArrayList<>();

            NamedNodeMap studentAttributes = studentNode.getAttributes();

            String firstname = studentAttributes.getNamedItem("firstname").getNodeValue();
            String lastname = studentAttributes.getNamedItem("lastname").getNodeValue();
            String groupnumber = studentAttributes.getNamedItem("groupnumber").getNodeValue();

            double average = 0.0;

            NodeList subjectNodeList = studentNode.getChildNodes();

            for (int j = 0; j < subjectNodeList.getLength(); j++) {
                Node subjectNode = subjectNodeList.item(j);

                NamedNodeMap subjectAttributes = subjectNode.getAttributes();

                if (subjectNode.getNodeName().equals("subject")) {
                    subjectsList.add(subjectAttributes.getNamedItem("title").getNodeValue());
                    try {
                        marksList.add(Integer.parseInt(subjectAttributes.getNamedItem("mark").getNodeValue()));
                    } catch (Exception exc) {
                        marksList.add(0);
                    }
                }

                if (subjectNode.getNodeName().equals("average")) {
                    try {
                        average = Double.parseDouble(subjectNode.getTextContent());
                    } catch (Exception exc) {
                        average = 0.0;
                    }
                }
            }

            students.add(new Students(firstname, lastname, groupnumber, subjectsList, marksList, average));
        }

        for (Students student : students) {
            Helper helper = new Helper(student);
            if (!helper.checkIfAverageIsOk(student.getAverage())) {
                for (int i = 0; i < studentElements.getLength(); i++) {
                    Node studentNode = studentElements.item(i);
                    NamedNodeMap studentAttributes = studentNode.getAttributes();
                    NodeList subjectNodeList = studentNode.getChildNodes();
                    boolean isElementRight = false;

                    if (studentAttributes
                            .getNamedItem("firstname")
                            .getNodeValue()
                            .equals(student.getFirstName()) &&
                            studentAttributes
                                    .getNamedItem("lastname")
                                    .getNodeValue()
                                    .equals(student.getLastName())) {
                        isElementRight = true;
                    }
                    if (isElementRight) {
                        for (int j = 0; j < subjectNodeList.getLength(); j++) {

                            Node subjectNode = subjectNodeList.item(j);


                            if (subjectNode.getNodeName().equals("average")) {
                                subjectNode.setTextContent(String.valueOf(helper.correctAverage));
                            }
                        }
                    }
                }
            }
            student.setAverage(helper.correctAverage);
            System.out.println(student);
        }

        try (FileOutputStream output = new FileOutputStream(editedFile)) {
            writeXml(document, output);
        } catch (IOException | TransformerException e) {
            System.out.println(e.getMessage());;
        }
    }

    private static void startSAXParser(ArrayList<Students> students, File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory SAXFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = SAXFactory.newSAXParser();

        XMLHandler handler = new XMLHandler(students);
        parser.parse(xmlFile, handler);

        for (Students student : students) {
            System.out.println(student.toString());
            Helper helper = new Helper(student);
            if (!helper.checkIfAverageIsOk(student.average)) {
                student.setAverage(helper.correctAverage);
            }
        }

        System.out.println("\n\n");

        for (Students student : students) {
            System.out.println(student.toString());
        }
    }

    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException, UnsupportedEncodingException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        // add a xslt to remove the extra newlines
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}