package xmls;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import static com.solvd.practice.Main.logger;

public class BankHierarchyParser {

    public static void main(String[] args) {
        try {
            File xmlFile = new File(".\\src\\main\\java\\bankdao\\xmls\\bankHierarchy.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element bankElement = document.getDocumentElement();
            logger.info("Bank Name: " + getElementTextContent(bankElement, "name"));

            NodeList branchNodes = bankElement.getElementsByTagName("branch");
            for (int i = 0; i < branchNodes.getLength(); i++) {
                Element branchElement = (Element) branchNodes.item(i);
                logger.info("Branch Name: " + getElementTextContent(branchElement, "name"));

                NodeList employeeNodes = branchElement.getElementsByTagName("employee");
                for (int j = 0; j < employeeNodes.getLength(); j++) {
                    Element employeeElement = (Element) employeeNodes.item(j);
                    logger.info("Employee Name: " + getElementTextContent(employeeElement, "name"));
                }

                NodeList customerNodes = branchElement.getElementsByTagName("customer");
                for (int k = 0; k < customerNodes.getLength(); k++) {
                    Element customerElement = (Element) customerNodes.item(k);
                    logger.info("Customer Name: " + getElementTextContent(customerElement, "name"));

                    NodeList accountNodes = customerElement.getElementsByTagName("accountEntity");
                    for (int m = 0; m < accountNodes.getLength(); m++) {
                        Element accountElement = (Element) accountNodes.item(m);
                        logger.info("Account Type: " + getElementTextContent(accountElement, "type"));
                        logger.info("Account Balance: " + getElementTextContent(accountElement, "balance"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getElementTextContent(Element parentElement, String childTagName) {
        NodeList nodeList = parentElement.getElementsByTagName(childTagName);
        if (nodeList.getLength() > 0) {
            Element element = (Element) nodeList.item(0);
            Node textNode = element.getFirstChild();
            if (textNode != null) {
                return textNode.getNodeValue();
            }
        }
        return "";
    }
}