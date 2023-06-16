package bankdao.xmls;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BankHierarchyParser {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse("C:\\Users\\deviv\\IdeaProjects\\solvd-projects\\src\\main\\java\\bankdao\\bankHierarchy.xml");

            // Get the root element
            Element root = document.getDocumentElement();

            //Get the bank element
            NodeList bankList = root.getElementsByTagName("bank");
            Element bankElement = (Element) bankList.item(0);

            // Process the bank element
            String bankName = bankElement.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("Bank Name: " + bankName);

            // Process the branches
            NodeList branchList = bankElement.getElementsByTagName("branch");
            for (int i = 0; i < branchList.getLength(); i++) {
                Element branchElement = (Element) branchList.item(i);
                String branchName = branchElement.getElementsByTagName("name").item(0).getTextContent();
                System.out.println("Branch Name: " + branchName);

                // Process employees
                NodeList employeeList = branchElement.getElementsByTagName("employee");
                for (int j = 0; j < employeeList.getLength(); j++) {
                    Element employeeElement = (Element) employeeList.item(j);
                    String employeeName = employeeElement.getElementsByTagName("name").item(0).getTextContent();
                    System.out.println("Employee Name: " + employeeName);
                }

                // Process customers
                NodeList customerList = branchElement.getElementsByTagName("customer");
                for (int j = 0; j < customerList.getLength(); j++) {
                    Element customerElement = (Element) customerList.item(j);
                    String customerName = customerElement.getElementsByTagName("name").item(0).getTextContent();
                    System.out.println("Customer Name: " + customerName);

                    // Process accounts
                    NodeList accountList = customerElement.getElementsByTagName("account");
                    for (int k = 0; k < accountList.getLength(); k++) {
                        Element accountElement = (Element) accountList.item(k);
                        String accountType = accountElement.getElementsByTagName("type").item(0).getTextContent();
                        double accountBalance = Double.parseDouble(accountElement.getElementsByTagName("balance").item(0).getTextContent());
                        System.out.println("Account Type: " + accountType);
                        System.out.println("Account Balance: " + accountBalance);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}