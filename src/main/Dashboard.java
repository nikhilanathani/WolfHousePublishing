package main;

import constants.Constants;
import controllers.*;
import entity.*;
import utility.DatabaseUtility;
import utility.PageUtility;
import utility.PropertiesUtility;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Dashboard {

    private static Scanner scanner;

    private static PublicationController publicationController;
    private static EditorController editorController;
    private static EditsController editsController;
    private  static PublicationTopicController publicationTopicController;
    private  static ArticleController articleController;
    private static PeriodicPublicationController periodicPublicationController;
    private  static HasArticleController hasArticleController;
    private static  BookController bookController;
    private static  ChapterController chapterController;
    private static AuthorController authorController;
    private static  WriteBookController writeBookController;
    private static WritesArticleController writesArticleController;
    private static PeriodicityController periodicityController;
    private static DistributorTypeController distributorTypeController;
    private static DistributorController distributorController;
    private static AddressController addressController;
    private static OrderPlacedController orderPlacedController;
    private static OrderPaymentController orderPaymentController;
    private static OrderContainsController orderContainsController;
    private static OrderController orderController;
    private static RevenueController revenueController;
    private static ContractController contractController;
    private static TransactionController transactionController;
    private static EmployeeController employeeController;
    private static EmployeePaymentController employeePaymentsController;

    private static List<String> mainMenu;
    private static List<String> publicationMenu;
    private static List<String> periodicPublicationMenu;
    private static List<String> bookMenu;
    private static List<String> articleMenu;
    private static List<String> distributorMenu;
    private static List<String> orderMenu;
    private static List<String> revenueMenu;

    private static Map<Integer,Integer> calendar ;

    static{
        scanner = new Scanner(System.in);
        publicationController = new PublicationController();
        editorController = new EditorController();
        editsController = new EditsController();
        publicationTopicController = new PublicationTopicController();
        articleController = new ArticleController();
        periodicPublicationController = new PeriodicPublicationController();
        hasArticleController = new HasArticleController();
        bookController = new BookController();
        chapterController = new ChapterController();
        authorController = new AuthorController();
        writeBookController = new WriteBookController();
        writesArticleController = new WritesArticleController();
        periodicityController = new PeriodicityController();
        distributorTypeController = new DistributorTypeController();
        distributorController = new DistributorController();
        addressController = new AddressController();
        orderPlacedController = new OrderPlacedController();
        orderPaymentController = new OrderPaymentController();
        orderContainsController = new OrderContainsController();
        orderController = new OrderController();
        revenueController = new RevenueController();
        contractController = new ContractController();
        transactionController = new TransactionController();
        employeeController = new EmployeeController();
        employeePaymentsController = new EmployeePaymentController();

        initCalendar();
        initPublicationMenu();
        initMainMenu();
        initPeriodicPublicationMenu();
        initBookMenu();
        initArticleMenu();
        initDistributorMenu();
        initOrderMenu();
        initRevenueMenu();
    }


    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        PropertiesUtility.init();
        DatabaseUtility.init();

        System.out.println("WELCOME TO WOLFHOUSE PUBLISHING HOUSE");
        int option =0;

        start:
        while(true){
            option = displayMenuAndGetOption(mainMenu);
            switch(option){
                case 1:
                    publication:
                    while(true){
                        option = displayMenuAndGetOption(publicationMenu);
                        switch (option){
                            case 1:
                                viewAllPublications();
                                break;
                            case 2:
                                createPublication();
                                break;
                            case 3:
                                updatePublication();
                                break;
                            case 4:
                                getPublicationByTitle();
                                break;
                            case 5:
                                getPublicationByDate();
                                break;
                            case 6:
                                getPublicationByTopic();
                                break;
                            case 7:
                                getPublicationById();
                                break;
                            case 8:
                                assignEditors();
                                break;
                            case 9:
                                getEditorsForPublication();
                                break;
                            case 10:
                                getPublicationForEditors();
                                break;
                            case 11:
                                break publication;
                        }
                    }
                    break;
                case 2:
                    periodicPublication:
                    while(true){
                        option = displayMenuAndGetOption(periodicPublicationMenu);
                        switch (option){
                            case 1:
                                viewAllPeriodicPublications();
                                break;
                            case 2:
                                addNewIssue();
                                break;
                            case 3:
                                updateIssue();
                                break;
                            case 4:
                                deleteIssue();
                                break;
                            case 5:
                                addArticlesToPeriodicPublication();
                                break;
                            case 6:
                                deleteArticlesForPeriodicPublication();
                                break;
                            case 7:
                                break periodicPublication;
                        }
                    }
                    break;
                case 3:
                    book:
                    while(true){
                        option = displayMenuAndGetOption(bookMenu);
                        switch (option){
                            case 1:
                                viewAllBooks();
                                break;
                            case 2:
                                createBook();
                                break;
                            case 3:
                                deleteBook();
                                break;
                            case 4:
                                getBookByTopic();
                                break;
                            case 5:
                                getBooksByAuthorName();
                                break;
                            case 6:
                                getBookByDate();
                                break;
                            case 7:
                                addEdition();
                                break;
                            case 8:
                                updateEdition();
                                break;
                            case 9:
                                deleteEdition();
                                break;
                            case 10:
                                addChaptersToBook();
                                break;
                            case 11:
                                deleteChaptersFromBooks();
                                break;
                            case 12:
                                break book;
                        }
                    }
                    break;
                case 4:
                    article:
                    while(true) {
                        option = displayMenuAndGetOption(articleMenu);
                        switch (option) {
                            case 1:
                                viewAllArticles();
                                break;
                            case 2:
                                createArticle();
                                break;
                            case 3:
                                updateArticle();
                                break;
                            case 4:
                                deleteArticle();
                                break;
                            case 5:
                                getArticlesByTopic();
                                break;
                            case 6:
                                getArticlesByAuthorName();
                                break;
                            case 7:
                                getArticlesByDate();
                                break;
                            case 8:
                                break article;
                        }
                    }
                    break;
                case 5:
                    distributor:
                    while(true) {
                        option = displayMenuAndGetOption(distributorMenu);
                        switch (option) {
                            case 1:
                                viewAllDistributors();
                                break;
                            case 2:
                                addDistributor();
                                break;
                            case 3:
                                updateDistributor();
                                break;
                            case 4:
                                deleteDistributor();
                                break;
                            case 5:
                                break distributor;
                        }
                    }
                    break;
                case 6:
                    order:
                    while(true) {
                        option = displayMenuAndGetOption(orderMenu);
                        switch (option) {
                            case 1:
                                viewAllPaidOrders();
                                break;
                            case 2:
                                viewAllUnpaidOrders();
                                break;
                            case 3:
                                createOrder();
                                break;
                            case 4:
                                generateBill();
                                break;
                            case 5:
                                break order;
                        }
                    }
                    break;
                case 7:
                    revenue:
                    while(true){
                        option = displayMenuAndGetOption(revenueMenu);
                        switch (option){
                            case 1:
                                getPerDistributorPerPublicationPrice();
                                break;
                            case 2:
                                totalRevenue();
                                break;
                            case 3:
                                totalExpense();
                                break;
                            case 4:
                                getTotalRevenuePerCity();
                                break;
                            case 5:
                                getTotalRevenuePerLocation();
                                break;
                            case 6:
                                getTotalRevenuePerDistributor();
                                break;
                            case 7:
                                totalDistributors();
                                break;
                            case 8:
                                getPaymentsPerWorkType();
                                break;
                            case 9:
                                processEmployeePayment();
                                break;
                            case 10:
                                break revenue;
                        }
                    }
                    break;
                case 8:
                    break start;
            }
        }
        System.out.println("Thank you for visiting WolfPrint Publishing House.");
    }

    private static void viewAllUnpaidOrders() {
        System.out.println("------------------ALL UNPAID ORDERS ---------------------");
        List<Object> orders = orderController.getAllOrdersForPayment();
        String columns = "SerialNo\tId\tPrice\tOrder date\tShipping Cost\tDeliveryDate\tTransactionId";
        PageUtility.displayOptions(columns,orders);
    }

    private static void viewAllPaidOrders() {
        System.out.println("------------------ALL PAID ORDERS ---------------------");
        List<Object> orders = orderController.getAllPaidOrders();
        String columns = "SerialNo\tId\tPrice\tOrder date\tShipping Cost\tDeliveryDate\tTransactionId";
        PageUtility.displayOptions(columns,orders);
    }

    private static void viewAllDistributors() {
        System.out.println("------------------ALL DISTRIBUTORS ---------------------");
        List<Object> distributors = distributorController.getAllDistributors();
        String columns = "SerialNo\tId\tName\tPhoneNumber\tBalance\tActiveStatus\tDistributorType";
        PageUtility.displayOptions(columns,distributors);
    }

    private static void viewAllBooks() {
        System.out.println("------------------ALL BOOKS ---------------------");
        List<Object> books = bookController.getAllBooks();
        String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
        PageUtility.displayOptions(columns,books);
    }

    private static void viewAllArticles() {
        System.out.println("------------------ALL ARTICLES ---------------------");
        List<Object> articles = articleController.getAllArticles();
        String column = "SerialNo\tTitle\tDateOfCreation";
        PageUtility.displayOptions(column,articles);
    }


    private static void viewAllPeriodicPublications() {
        System.out.println("------------------ALL PERIODIC PUBLICATIONS ---------------------");
        List<Object> periodicPublications = periodicPublicationController.getAllPeriodicPublications();
        String columns = "SerialNo\tID\tTitle\tPublication Date\tPrice\tTopic\tPeriodicity";
        PageUtility.displayOptions(columns,periodicPublications);

    }

    private static void viewAllPublications() {
        System.out.println("------------------ALL PUBLICATIONS ---------------------");
        List<Object> publications = publicationController.getAllPublications();
        String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
        PageUtility.displayOptions(columns1,publications);

    }


    private static void getPaymentsPerWorkType(){
        System.out.println("------GET TOTAL PAYMENTS PER WORK TYPE -----------");
        List<Integer> answer = revenueController.getPaymentsPerWorkType();
        System.out.println("Payments for BOOK AUTHORS : "+answer.get(0));
        System.out.println("Payments for ARTICLE AUIHORS : "+answer.get(1));
        System.out.println("Payments for Publication EDITORS : "+answer.get(2));
    }

    private static void getPerDistributorPerPublicationPrice() {
        System.out.println("------GET NUMBER OF PUBLICATIONS, COPIES AND PRICE PER DISTRIBUTOR -----------");
        Map<String, List<List<Object>>> answer = revenueController.getPerDistributorPerPublicationPrice();
        System.out.println("DistributorName\tPublicationTitle\tNoOfCopies\tValue\tMonth");
        System.out.println("-----------------------------------------------------------------------");
        for(String key : answer.keySet()){
            String output = "";
            List<List<Object>> current = answer.get(key);
            for(List<Object> list : current){
                output = key+"\t";
                for(Object o : list){
                    output+=o+"\t";
                }
                System.out.println(output);
            }
       }
    }


    private static void getTotalRevenuePerCity(){


        System.out.println("----------------TOTAL REVENUE PER CITY  ------------------------");
        System.out.println("Enter the year and month for which you wish to see the total revenue :(YYYY-MM)");
        String date = scanner.next();
        String values[] = date.split("-");
        Date startDate = Date.valueOf(date+"-01");
        Date endDate = Date.valueOf(date+"-"+Integer.toString(calendar.get(Integer.parseInt(values[1]))));
        Map<String,Integer> answer = revenueController.getTotalRevenuePerCity(startDate,endDate);
        System.out.println("SerialNo\tCity\tPrice");

        System.out.println("--------------------------------------------------------------------");
        int count = 1;
        for(String key : answer.keySet()){
            System.out.println(count+"\t"+key+"\t"+answer.get(key));
            count++;
        }

    }

    private static void generateBill() {
        System.out.println("---------------------GENERATE BILL----------------------------");
        List<Object> orders = orderController.getAllOrdersForPayment();
        System.out.println("Enter the serial number of the order for which you want to generate the bill :");
        String columns = "SerialNo\tId\tPrice\tOrder date\tShipping Cost\tDeliveryDate";
        PageUtility.displayOptions(columns,orders);
        int serialNumber = scanner.nextInt();

        Order order = (Order)orders.get(serialNumber-1);
        //System.out.println("order id "+order.getOrderId());
        int distributorId = orderPlacedController.getDistributorIdForOrder(order);
        System.out.println("Distributor id:  "+distributorId);
        Distributor distributor = null;
        if(distributorId!=-1){
            distributor = distributorController.getDistributorById(distributorId);
            //System.out.println("Found distributor");
        }
        //create transaction
        int transactionId = transactionController.createTransactionForOrder(order);
        System.out.println("Transaction Id: "+transactionId);
        if(transactionId!=-1){
            OrderPayment orderPayment = new OrderPayment(order,new Transaction(transactionId));
            if(orderPaymentController.createOrderPayment(orderPayment)){
                order.setTransactionId(transactionId);
                if(orderController.updateTransactionId(order)){
                    if(distributor!=null){
//                        int payReceievd = (int) ((float)order.getPrice()+order.getShippingCost());
//                        System.out.println("PR : "+payReceievd);
//                        distributor.setBalance((int) (distributor.getBalance()-(order.getPrice()+order.getShippingCost())));
                        distributorController.updateBalance(distributor);
                        System.out.println("Bill generated for Order id : "+order.getOrderId()+" for distributor :"+distributor.getDistributorName());
                        System.out.println("Transaction of amount "+(order.getPrice()+order.getShippingCost())+" generated for the order with id "+order.getOrderId()+" with transaction id :"+transactionId);
                        System.out.println("Updated balance of distributor :"+(distributor.getBalance()));
                    }
                }
            }
        }
    }


    private static void createOrder(){
        System.out.println("-------------------------------- CREATE ORDER--------------------------");
        List<Object> distributors = distributorController.getAllDistributors();
        System.out.println("Enter the serial number of the distributor who wants to place an order : ");
        String columns = "SerialNo\tId\tName\tPhoneNumber\tBalance\tActiveStatus\tDistributorType";
        PageUtility.displayOptions(columns,distributors);
        int serialNumber = scanner.nextInt();
        float price = 0;
        Distributor currentDistributor = (Distributor) distributors.get(serialNumber - 1);

        System.out.println("Select the serial Number of the address for which you wish to place an order : ");
        List<Object> address = addressController.getAddressForDistributor(currentDistributor);
        columns = "SerialNo\tDistributorId\tLocation\tCity\tContactPerson";
        PageUtility.displayOptions(columns,address);
        serialNumber = scanner.nextInt();
        Address currentAddress = (Address) address.get(serialNumber-1);
        List<Object> publications = publicationController.getAllPublications();
        List<OrderContains> orderContains = new ArrayList<>();
        while(true){
            System.out.println("Enter the serial number of the publication you wish to buy: ");
            String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            PageUtility.displayOptions(columns1,publications);
            int publicationSerialNumber= scanner.nextInt();
            Publication currentPublication = (Publication) publications.get(publicationSerialNumber-1);
            for(int i=0;i<orderContains.size();i++){
                if(orderContains.get(i).getPublication().getPublicationId() == currentPublication.getPublicationId()){
                    System.out.println("This publication already exists in your shopping cart, its copies will be overwritten!");
                    price = price - orderContains.get(i).getPublication().getPrice() * orderContains.get(i).getNumberOfCopies();
                    break;
                }
            }
            System.out.println("Enter the number of copies for this publication : ");
            Integer copies = scanner.nextInt();
            price = price + copies * currentPublication.getPrice();
            OrderContains oc = new OrderContains(currentPublication,copies);
            orderContains.add(oc);

            System.out.println("Do you want to add more publications ? (Y/N) ");
            String option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("n")){
                break;
            }
        }
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dateOfOrder = Date.valueOf(dtf.format(localDate));
        //take input sc.. tu nai hota na ..to project hi nai banta
        System.out.println("Enter the shipping cost : ");
        int shippingCost = scanner.nextInt();
        System.out.println("Enter the required delivery date (YYYY-MM-DD): ");
        String date = scanner.next();
        Date deliveryDate = Date.valueOf(date);
//        System.out.println("You entered "+deliveryDate);
//        price += shippingCost;
        Order o1 = new Order(price,dateOfOrder,shippingCost,deliveryDate,-1);
        int orderId = orderController.createOrder(o1);
        if(orderId !=-1){
            for(int i=0;i<orderContains.size();i++){
                orderContains.get(i).setOrderId(orderId);
            }
            OrderContains result = orderContainsController.createORderContainsForORder(orderContains);
            if(result==null){
                //System.out.println("ORder Contains done : "+orderId);
                OrderPlaced orderPlaced = new OrderPlaced(currentDistributor.getDistributorId(),orderId,currentAddress.getLocation());
                if(orderPlacedController.createOrderPlaced(orderPlaced)){
                    System.out.println("Order has been successfully placed for distributor : "+currentDistributor.getDistributorId()+"! Your order id is : "+orderId);

                    currentDistributor.setBalance(currentDistributor.getBalance()+(int)price+shippingCost);
                    distributorController.updateBalance(currentDistributor);
                }
            }
        }
    }

    private static void processEmployeePayment(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dateOfTransaction = Date.valueOf(dtf.format(localDate));
        List<Object> result = contractController.getContractsForDate(dateOfTransaction);
        List<Contract> contracts = new ArrayList<>();
        for(Object o : result){
            System.out.println(o.toString());
            contracts.add((Contract)o);
        }
        List<Contract> contracts1 = transactionController.createTransactionsForTemporaryEmployees(contracts);
        contractController.updateTransactionIdsForContracts(contracts1);


        List<Employee> permanentEmployees = employeeController.getPermanentEmployeesForPayment(dateOfTransaction);
        for(Employee o : permanentEmployees){
            System.out.println(o.toString());
        }
        if(permanentEmployees.size()==0){
            System.out.println("All employees have already been paid for current pay period!");
        }else{
            List<EmployeePayment> employeePayments = transactionController.createTransactionForEmployee(permanentEmployees);
            EmployeePayment result1 = employeePaymentsController.createPaymentEntryForEmployee(employeePayments);
            if(result1 != null){
                System.out.println("Employee payment failed for : "+result1.toString());
            }else{
                System.out.println("Employees have been paid successfully!");
            }
        }


    }

    private static void totalExpense() {
        System.out.println("---------------------------TOTAL EXPENSE OF THE PUBLISHING HOUSE--------------------------");
        System.out.println("Enter the year and month for which you wish to see the total revenue :(YYYY-MM)");
        String date = scanner.next();
        String values[] = date.split("-");
        Date startDate = Date.valueOf(date+"-01");
        Date endDate = Date.valueOf(date+"-"+Integer.toString(calendar.get(Integer.parseInt(values[1]))));
        long totalExpense = revenueController.getTotalExpense(startDate,endDate);
        if(totalExpense != -1){
            System.out.println("Total Expense for the publishing house is : "+totalExpense  );
        }
    }

    private static void totalRevenue() {
        System.out.println("---------------------------TOTAL REVENUE OF THE PUBLISHING HOUSE--------------------------");
        System.out.println("Enter the year and month for which you wish to see the total revenue :(YYYY-MM)");
        String date = scanner.next();
        String values[] = date.split("-");
        Date startDate = Date.valueOf(date+"-01");
        Date endDate = Date.valueOf(date+"-"+Integer.toString(calendar.get(Integer.parseInt(values[1]))));
        int totalRevenue = revenueController.getTotalRevenue(startDate,endDate);
        if(totalRevenue != -1){
            System.out.println("Total Revenue for the publishing house is : "+totalRevenue  );
        }
    }

    private static void getTotalRevenuePerDistributor() {
        System.out.println("----------------TOTAL REVENUE PER DISTRIBUTOR ------------------------");
        System.out.println("Enter the year and month for which you wish to see the total revenue :(YYYY-MM)");
        String date = scanner.next();
        String values[] = date.split("-");
        Date startDate = Date.valueOf(date+"-01");
        Date endDate = Date.valueOf(date+"-"+Integer.toString(calendar.get(Integer.parseInt(values[1]))));
        Map<Integer,Map<String,Integer>> answer = revenueController.getTotalRevenuePerDistributor(startDate,endDate);

        System.out.println("SerialNo\tDistributor\tPrice");
        System.out.println("--------------------------------------------------------------------");
        int count = 1;
        for(Integer key1 : answer.keySet()){
            Map<String,Integer> map = answer.get(key1);
            for(String key2 : map.keySet()){
                System.out.println(count+"\t\t"+key2+"\t"+map.get(key2));
                count++;
            }
        }
    }

    private static void getTotalRevenuePerLocation() {
        System.out.println("----------------TOTAL REVENUE PER LOCATION ------------------------");
        System.out.println("Enter the year and month for which you wish to see the total revenue :(YYYY-MM)");
        String date = scanner.next();
        String values[] = date.split("-");
        Date startDate = Date.valueOf(date+"-01");
        Date endDate = Date.valueOf(date+"-"+Integer.toString(calendar.get(Integer.parseInt(values[1]))));
        Map<String,Integer> answer = revenueController.getTotalRevenuePerLocation(startDate,endDate);
        System.out.println("SerialNo\tLocation\tPrice");
        System.out.println("--------------------------------------------------------------------");
        int count = 1;
        for(String key : answer.keySet()){
            System.out.println(count+"\t"+key+"\t"+answer.get(key));
            count++;
        }

    }

    private static void totalDistributors() {
        System.out.println("---------------------- TOTAL DISTRIBUTORS ------------------------");
        int totalDistributors = distributorController.getTotalDistributors();
        System.out.println("Total active distributors available are : "+totalDistributors);
    }

    private static void deleteDistributor() {
        System.out.println("---------------------- DELETE DISTRIBUTOR--------------------------");
        List<Object> distributors = distributorController.getAllDistributors();
        System.out.println("Enter the serial number of the distributor which you wish to delete : ");
        String columns = "SerialNo\tId\tName\tPhoneNumber\tBalance\tActiveStatus\tDistibutorType";
        PageUtility.displayOptions(columns,distributors);
        int serialNumber = scanner.nextInt();
        Distributor currentDistributor = (Distributor) distributors.get(serialNumber - 1);
        List<Order> orders = orderPlacedController.getOrdersForDistributor(currentDistributor);
        if(orderPlacedController.deleteOrdersPlacesForDistributor(currentDistributor)){
//            System.out.println("Deleted successfully from orderPlaced");
            Order result = orderPaymentController.deleteTransactionsForOrders(orders);
            if(result != null){
                System.out.println("Deletion of distributor failed due to some reason!");
            }else{
//                System.out.println("Deleted successfully from orderPayment");
                result = orderContainsController.deleteOrderContainsForOrder(orders);
                if(result!=null){
                    System.out.println("Deletion of distributor failed due to some reason!");
                }else{
//                    System.out.println("Deleted successfully from orderContains");
                    result = orderController.deleteOrders(orders);
                    if(result!=null){
//                        System.out.println("Deletion of distributor failed due to some reason!");
                    }else{
//                        System.out.println("Deleted successfully from order");
                        if(addressController.deleteAddressForDistributor(currentDistributor)){
//                            System.out.println("Deleted successfully from address");
                            if(distributorController.deleteDistributor(currentDistributor)){
//                                System.out.println("Deleted successfully from distributor");
                                System.out.println("The distributor has been deleted successfully!");
                            }
                        }
                    }
                }
            }
        }
    }

    private static void updateDistributor() {
        //TODO Should we also update the address? (YES)
        System.out.println("---------------------UPDATE DISTRIBUTOR---------------------");
        List<Object> distributors = distributorController.getAllDistributors();
        System.out.println("Enter the serial number of the distributor which you wish to update : ");
        String columns = "SerialNo\tId\tName\tPhoneNumber\tBalance\tActiveStatus\tDistibutorType";
        PageUtility.displayOptions(columns,distributors);
        int serialNumber = scanner.nextInt();
        Distributor currentDistributor = (Distributor) distributors.get(serialNumber-1);

        System.out.println("Do you want to update 'Name'? (Y/N) ");
        String option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new 'Name' : \t");
            String newTitle = scanner.nextLine();
            String str1 = scanner.nextLine();
            currentDistributor.setDistributorName(str1);
        }

        System.out.println("Do you want to update 'Phone Number'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new 'Phone Number' : \t");
            Long phoneNo  = scanner.nextLong();
            currentDistributor.setPhoneNumber(phoneNo);
        }

        System.out.println("Do you want to update 'Active Status'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new status ( ACTIVE (0) / INACTIVE (1)) : \t");
            int status = scanner.nextInt();
            currentDistributor.setActiveStatus(status == 0? "ACTIVE":"INACTIVE");
        }

        System.out.println("Do you want to update 'Distributor Type'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")) {
            List<Object> distributorTypes = distributorTypeController.getAllDistributorTypes();
            System.out.println("Enter the serial Number of the distributor type you wish to assign for this distributor : ");
            columns = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns,distributorTypes);
            int newTopic = scanner.nextInt();
            currentDistributor.setDistributorType((DistributorType) distributorTypes.get(newTopic-1));
        }

        //option = do u want to update address.
        System.out.println("Do you want to update address of this distributor? (Y/N)");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("Y")){
            List<Object> addresses = addressController.getAddressForDistributor(currentDistributor);
            System.out.println("Enter the seriel number of the address you want to update: ");
            columns = "SerialNo\tDistributorId\tLocation\tCity\tContactPerson";
            PageUtility.displayOptions(columns,addresses);
            serialNumber = scanner.nextInt();
            Address currentAddress = (Address) addresses.get(serialNumber-1);


            System.out.println("Do you want to update Location? (Y/N)");
            option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            String oldLocation = currentAddress.getLocation();
            if (option.equalsIgnoreCase("Y")){
                System.out.println("Enter new location : ");
                String dummy = scanner.nextLine();
                String location = scanner.nextLine();
                currentAddress.setLocation(location);

            }

            System.out.println("Do you want to update City? (Y/N)");
            option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }

            if(option.equalsIgnoreCase("Y")){
                System.out.println("Enter new City : ");
                String dummy = scanner.nextLine();
                String city = scanner.nextLine();
                currentAddress.setCity(city);
            }


            System.out.println("Do you want to update Contact person? (Y/N)");
            option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("Y")){
                System.out.println("Enter new Contact person : ");
                String dummy = scanner.nextLine();
                String cp = scanner.nextLine();
                currentAddress.setContactPerson(cp);
            }
            boolean result = addressController.updateAddressForDistributor(currentAddress, oldLocation);
            if(!result){
                System.out.println("Address has been updated successfully!");
            }
            List<Order> order = orderPlacedController.getOrdersForDistributor(currentDistributor);
            if(order.size()>0){
                orderPlacedController.updateLocation(order,currentAddress.getLocation());
            }
        }

        if(distributorController.updateDistributor(currentDistributor)){
            System.out.println("Distributor has been updated successfully!");
        }

    }

    private static void addDistributor() {
        System.out.println("----------------------ADD DISTRIBUTOR -------------------");
        System.out.println("Enter the name of the distributor :" );
        String dummy = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the phone number : ");
        Long phoneNumber = scanner.nextLong();
        System.out.println("Enter the active status of the distributor (ACTIVE (0)/INACTIVE(1)) :");
        int status = scanner.nextInt();
        String distrirbutorStatus = status == 0? "ACTIVE": status == 1 ? "INACTIVE":"";
        System.out.println("Enter the serial number of the distributor type with which you wish to associate this distributor : ");
        List<Object> distributorTypes = distributorTypeController.getAllDistributorTypes();
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,distributorTypes);
        int dType = scanner.nextInt();
        Distributor d = new Distributor(name,phoneNumber,0,distrirbutorStatus,(DistributorType) distributorTypes.get(dType-1));
        int distributorId =distributorController.createDistributor(d);
        if(distributorId==-1){
            System.out.println("Creation of new distributor failed!");
        }else{
            System.out.println("Distributor created successfully!");
            System.out.println("Enter the address details for the distributor.");
            System.out.println("Enter the location :");
            dummy = scanner.nextLine();
            String location = scanner.nextLine();
            System.out.println("Enter the city :");
            String city = scanner.nextLine();
            System.out.println("Enter the name of contact person :");
            String contactPerson = scanner.nextLine();
            Address a = new Address(distributorId,location,contactPerson,city);
            if(addressController.addAddressForDistributor(a)){
                System.out.println("Address for the given distributor has been added successfully!");
            }
        }


    }

    private static void updateEdition() {
        System.out.println("---------------------- UPDATE EDITION -------------------");
        List<Object> books = bookController.getAllBooks();
        String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
        PageUtility.displayOptions(columns,books);
        System.out.println("Enter the serial number of the book (looking at the respective edition) which you wish to update : ");
        Integer bookSerialNumber = scanner.nextInt();
        Book book = (Book)books.get(bookSerialNumber-1);
        System.out.println("Enter the updated edition for the book :");
        String edition = scanner.next();
        book.setEdition(edition);
        if(bookController.updateBookEdition(book)){
            System.out.println("The edition for the book "+book.getPublication().getPublicationTitle()+" has been changed to "+
                    edition);
        }
    }

    private static void deleteEdition() {
        System.out.println("---------------------- DELETE EDITION -------------------");
        List<Object> books = bookController.getAllBooks();
        String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
        PageUtility.displayOptions(columns,books);
        System.out.println("Enter the serial number of the book (looking at the respective edition) which you wish to delete : ");
        Integer bookSerialNumber = scanner.nextInt();
        Book book = (Book)books.get(bookSerialNumber-1);
        if(bookController.deleteBook(book)) {
            if (publicationController.deletePublication(book.getPublication())) {
                System.out.println("The edition " + book.getEdition() + " for the book "
                        + book.getPublication().getPublicationTitle() + " has been deleted successfully!");
            }
        }
    }

    private static void addEdition() {
        System.out.println("---------------------- ADD NEW EDITION -------------------");
        List<Object> books = bookController.getAllBooks();
        String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
        PageUtility.displayOptions(columns,books);
        System.out.println("Enter the serial number of the book for which you wish to add edition for : ");
        Integer bookSerialNumber = scanner.nextInt();
        Book book = (Book)books.get(bookSerialNumber-1);
        System.out.println("Enter the new edition : ");
        String edition = scanner.next();
        int publicationId = publicationController.createPublicationAndGetId(book.getPublication());
        if(publicationId==-1){
            System.out.println("Creating a publication for the new edition failed!");
        }else{
            book.getPublication().setPublicationId(publicationId);
            book.setEdition(edition);
            if(bookController.createBook(book)){
                System.out.println("New edition for the book "+book.getPublication().getPublicationTitle()+" added succesfully!");
            }
        }


    }

    private static void updateIssue() {
        System.out.println("------------------------ UPDATE ISSUE (PERIODIC PUBLICATION) -------------------------------");
        List<Object> periodicPublications = periodicPublicationController.getAllPeriodicPublications();
        String columns = "SerialNo\tID\tTitle\tPublication Date\tPrice\tTopic\tPeriodicity";
        PageUtility.displayOptions(columns,periodicPublications);
        System.out.println("Enter the serial number of the periodic publication you wish to update : ");
        Integer serielNumber = scanner.nextInt();
        PeriodicPublication currentPeriodicPublication = (PeriodicPublication)periodicPublications.get(serielNumber-1);
        Publication currentPublication = currentPeriodicPublication.getPublication();

        System.out.println("Do you want to update 'Title'? (Y/N) ");
        String option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new title : \t");
            String newTitle = scanner.nextLine();
            String str1 = scanner.nextLine();
            currentPublication.setPublicationTitle(str1);
        }
        System.out.println("Do you want to update 'Publication Date'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new Publication Date (YYYY-MM-DD) : \t");
            String newDate = scanner.next();
            currentPublication.setPublicationDate(Date.valueOf(newDate));
        }
        System.out.println("Do you want to update 'Price'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new Price: \t");
            Integer newPrice = scanner.nextInt();
            currentPublication.setPrice(newPrice);
        }
        System.out.println("Do you want to update 'Publication Topic'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
            System.out.println("Enter the serial Number of the publication topic you wish to assign for this publication : ");
            columns = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns,publicationTopics);
            int newTopic = scanner.nextInt();
            currentPublication.setPublicationTopic((PublicationTopic) publicationTopics.get(newTopic-1));
        }
        System.out.println("Do you want to update 'Periodicity' for the current issue? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            List<Object> periodicities = periodicityController.getAllPeriodicities();
            String columns1 = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns,periodicities);
            int serialNumber = scanner.nextInt();
            currentPeriodicPublication.setPeriodicity((Periodicity) periodicities.get(serialNumber-1));
        }
        currentPeriodicPublication.setPublication(currentPublication);
        if(publicationController.updatePublication(currentPublication)){
            if(periodicPublicationController.updatePeriodicPublication(currentPeriodicPublication)){
                System.out.println("Issue has been updated successfully!");
            }
        }

    }

    private static void deleteIssue() {
        System.out.println("------------------------ DELETE ISSUE (PERIODIC PUBLICATION) -------------------------------");
        List<Object> periodicPublications = periodicPublicationController.getAllPeriodicPublications();
        String columns = "SerialNo\tID\tTitle\tPublication Date\tPrice\tTopic\tPeriodicity";
        PageUtility.displayOptions(columns,periodicPublications);
        System.out.println("Enter the serial number of the periodic publication you wish to delete : ");
        Integer serielNumber = scanner.nextInt();
        PeriodicPublication periodicPublication = (PeriodicPublication)periodicPublications.get(serielNumber-1);
        List<Object> hasArticles = hasArticleController.getArticlesForPeriodicPublication(periodicPublication);
        List<HasArticle> hasArticlesToBeDeleted = new ArrayList<>();
        for(Object o : hasArticles ){
            Article a = (Article)o;
            hasArticlesToBeDeleted.add((new HasArticle(periodicPublication.getPublication().getPublicationId(),a.getArticleId())));
        }
        HasArticle result = hasArticleController.deleteArticlesForPeriodicPublication(hasArticlesToBeDeleted);
        if(result == null){
            if(periodicPublicationController.deletePeriodicPublication(periodicPublication)){
                System.out.println("Issue deleted successfully!");
                if(publicationController.deletePublication(periodicPublication.getPublication())){
                    System.out.println("The publication deleted successfully!");
                }
            }
        }
    }

    private static void addNewIssue() throws SQLException {
        System.out.println("------------------------ ADD NEW ISSUE (PERIODIC PUBLICATION) -------------------------------");
        System.out.println("Enter the Title for the Publication : ");
        String dummy = scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the price for the publication : ");
        Integer price = scanner.nextInt();
        System.out.println("Enter the publication date : (YYYY-MM-DD)");
        String date = scanner.next();
        Date date1 = Date.valueOf(date);
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Select the serial no of publication topic for which you want to create an issue :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        Integer topicId = scanner.nextInt();
        PublicationTopic publicationTopic = (PublicationTopic) publicationTopics.get(topicId-1);
        Publication publication = new Publication(title,date1,price,publicationTopic);
        int publicationId = publicationController.createPublicationAndGetId(publication);
        if(publicationId==-1){
            System.out.println("Entry failed for Publication table!");
        }else{
            publication.setPublicationId(publicationId);
            List<Object> periodicities = periodicityController.getAllPeriodicities();
            System.out.println("Enter the serial no of the periodicty, with which you wish to associate this issue to : ");
            String columns1 = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns,periodicities);
            int serialNumber = scanner.nextInt();
            PeriodicPublication pp = new PeriodicPublication(publication,(Periodicity) periodicities.get(serialNumber-1));
            if(periodicPublicationController.createPeriodicPublication(pp)){
                System.out.println("Periodic publication created successfully!");
            }
        }
    }


    private static void updateArticle(){
        System.out.println("-----------------------------UPDATE ARTICLE -------------------");
        List<Object> articles = articleController.getAllArticles();
        System.out.println("Enter the serial number of article you wish to update : ");
        String column = "SerialNo\tId\tTitle\tDateOfCreation";
        PageUtility.displayOptions(column,articles);
        int serialNumber = scanner.nextInt();

        Article currentArticle = (Article)articles.get(serialNumber-1);


        System.out.println("Do you want to update 'Title'? (Y/N) ");
        String option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new title: \t");
            String newTitle = scanner.nextLine();
            String title = scanner.nextLine();
            currentArticle.setTitle(title);
        }


        System.out.println("Do you want to update 'Date of Creation'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new date of creation (YYYY-MM-DD): \t");
            String newTitle = scanner.nextLine();
            String newDate = scanner.nextLine();
            currentArticle.setDateOfCreation(Date.valueOf(newDate));
        }


        System.out.println("Do you want to update 'Text'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new text : \t");
            String newTitle = scanner.nextLine();
            String text = scanner.nextLine();
            currentArticle.setText(text);
        }
        if(articleController.updateArticle(currentArticle)){
            System.out.println("Article updated successfully!");
        }
    }


    private static void getBooksByAuthorName() {
        System.out.println("-----------------------------GET BOOKS BY AUTHOR NAME -------------------");
        List<Object> authors = authorController.getAllAuthors();
        System.out.println("Enter the serial number of author for whom you will like to fetch the books :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,authors);
        int serialNumber = scanner.nextInt();
        Author a = (Author)authors.get(serialNumber-1);
        List<Object>  books = writeBookController.getBooksByAuthor(a.getEmployee().getEmployeeName());
        if(books.size()==0){
            System.out.println("There are no books yet written by : "+a.getEmployee().getEmployeeName());
        }else{
            System.out.println("The books written by '"+a.getEmployee().getEmployeeName()+"' are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
            PageUtility.displayOptions(columns1,books);
        }

    }

    private static void getArticlesByAuthorName() {
        System.out.println("-----------------------------GET ARTICLES BY AUTHOR NAME -------------------");
        List<Object> authors = authorController.getAllAuthors();
        System.out.println("Enter the serial number of author for whom you would like to fetch the articles :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,authors);
        int serialNumber = scanner.nextInt();
        Author a = (Author)authors.get(serialNumber-1);
        List<Object>  articles = writesArticleController.getArticlesByAuthor(a.getEmployee().getEmployeeName());
        if(articles.size()==0){
            System.out.println("There are no articles yet written by : "+a.getEmployee().getEmployeeName());
        }else{
            System.out.println("The articles written by '"+a.getEmployee().getEmployeeName()+"' are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tDate of creation";
            PageUtility.displayOptions(columns1,articles);
        }

    }

    private static void deleteBook() {
        System.out.println("------------------------ DELETE BOOK -------------------------------");
        List<Object> books = bookController.getAllBooks();
        String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
        PageUtility.displayOptions(columns,books);
        System.out.println("Enter the serial number of the book you wish to delete : ");
        Integer bookSerialNumber = scanner.nextInt();
        Book book = (Book)books.get(bookSerialNumber-1);
        List<Object> writesBook = writeBookController.getWritesBookForBook(book);
        if(writeBookController.deleteBookAuthorMappings(writesBook)) {
            if(bookController.deleteBook(book)){
                System.out.println("Book deleted successfully!");
                if(publicationController.deletePublication(book.getPublication())){
                    //System.out.println("The corresponding publication for the book deleted!");
                    List<Object> chapters = chapterController.getChaptersForABook(book);
                    List<Chapter> chaptersToBeDeleted = new ArrayList<>();
                    for (Object c : chapters){
                        chapters.add((Chapter)c);
                    }
                    Chapter result = chapterController.deleteChapters(chaptersToBeDeleted);
                    if(result==null){
                        System.out.println("Chapters for the given book deleted successfully!");
                    }else{
                        System.out.println("Deletion failed for the given object :\n"+result.toString());
                        System.out.println("All pairs before this have been deleted!");
                        System.out.println("All pairs after this have been skipped!");
                    }
                }
            }
        }

    }

    private static void createBook(){
        System.out.println("------------------------ CREATE BOOK -------------------------------");
        System.out.println("Enter the Title for the Publication : ");
        String dummy = scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the price for the publication : ");
        Integer price = scanner.nextInt();
        System.out.println("Enter the publication date : (YYYY-MM-DD)");
        String date = scanner.next();
        Date date1 = Date.valueOf(date);
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Select the serial number of publication topic for which you want to create  a book :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        Integer topicId = scanner.nextInt();
        PublicationTopic publicationTopic = (PublicationTopic) publicationTopics.get(topicId-1);
        Publication publication = new Publication(title,date1,price,publicationTopic);
        int publicationId = publicationController.createPublicationAndGetId(publication);
        if(publicationId==-1){
            System.out.println("Entry failed for Publication table!");
        }else { publication.setPublicationId(publicationId);
            System.out.println("Enter the ISBN for the book :");
            Integer ISBN = scanner.nextInt();
            System.out.println("Enter the edition of the book : ");
            String edition = scanner.next();
            Book book = new Book(publication,ISBN,edition);
            if(bookController.createBook(book)){
                System.out.println("Book created successfully!");
            }
        }




    }
    private static void deleteArticle() {
        //TODO: Delete from writesArticle table (check TODO of updateArticle)

        System.out.println("------------------------ DELETE ARTICLE -------------------------------");
        List<Object> articles = articleController.getAllArticles();
        System.out.println("Enter the serial number of the article you wish to delete : ");
        String column = "SerialNo\tId\tTitle\tDateOfCreation";
        PageUtility.displayOptions(column,articles);
        int serialNumber = scanner.nextInt();
        Article currentArticle = (Article)articles.get(serialNumber-1);
        if(writesArticleController.deleteWritesArticles(currentArticle)){

            if(hasArticleController.deletePublicationsForArticles(currentArticle)){
                if(articleController.deleteArticle((Article) articles.get(serialNumber-1))){
                    System.out.println("Article deleted successfully!");
                }
            }
        }
    }

    private static void createArticle(){
        System.out.println("------------------------ CREATE ARTICLE -------------------------------");
        System.out.println("Enter the title for article : ");
        String dummy = scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the date of creation for article (YYYY-MM-DD) :");
        String date = scanner.next();
        System.out.println("Enter the text for the article : ");
        dummy = scanner.nextLine();
        String text = scanner.nextLine();
        Article a = new Article(title,Date.valueOf(date),text);
        if(articleController.createArticle(a)){
            System.out.println("Article was created successfully!");
        }
    }

    private static void getArticlesByDate() {
        //This function is written considering date of creation of the article
        System.out.println("----------------------GET ARTICLES BY DATE -------------------------");
        System.out.println("Enter the date of creation of the article you want to retrieve (YYYY-MM-DD): ");
        String date = scanner.next();
        List<Object> articles = articleController.getArticlesByDate(date);
        if(articles.size()!=0) {
            System.out.println("The articles for the provided date are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tTDateOFCreation";
            PageUtility.displayOptions(columns1,articles);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }

    private static void getArticlesByTopic() {
        System.out.println("----------------------GET ARTICLES BY TOPIC -------------------------");
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Select the serial no of publication topic for which you want to retrieve the articles :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        Integer topicId = scanner.nextInt();
        List<Object> articles = articleController.getArticlesByTopic(((PublicationTopic)publicationTopics.get(topicId-1)).getPublicationTopicName());
        if(articles.size()!=0){
            System.out.println("The articles for the topic are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tTDateOFCreation";
            PageUtility.displayOptions(columns1,articles);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }


    private static void getBookByTopic() {
        System.out.println("----------------------GET BOOKS BY TOPIC -------------------------");
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Select the serial no of publication topic for which you want to retrieve the books :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        Integer topicId = scanner.nextInt();
        List<Object> books = bookController.getBookByTopic(((PublicationTopic)publicationTopics.get(topicId-1)).getPublicationTopicName());
        if(books.size()!=0){
            System.out.println("The books for the given topic are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
            PageUtility.displayOptions(columns1,books);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }

    private static void getBookByDate() {
        System.out.println("----------------------GET BOOKS BY DATE -------------------------");
        System.out.println("Enter the publication date of the book you want to retrieve (YYYY-MM-DD): ");
        String date = scanner.next();
        List<Object> books = bookController.getBookSByDate(date);
        if(books.size()!=0){
            System.out.println("The books for the given topic are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tTopic\tISBN\tEdition";
            PageUtility.displayOptions(columns1,books);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }

    private static void deleteChaptersFromBooks() {
            System.out.println("---------------------- DELETE CHAPTERS FROM BOOKS -------------------------");
            List<Object> books = bookController.getAllBooks();
            List<Object> chapters = new ArrayList<>();
            List<Chapter> chaptersToBeDeleted = new ArrayList<>();
            while(true){
                System.out.println("Select the serial number of the book for which you want to delete a chapter : ");
                String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tedition";
                PageUtility.displayOptions(columns,books);
                int num = scanner.nextInt();
                Book book = (Book) books.get(num-1);
                chapters = chapterController.getChaptersForABook(book);
                System.out.println("Enter the serial numbers for chapters you wish to delete for the current book (seperated by \",\") :");
                String columns1 = "SerialNo\tBookId\tBook Name\tChapterNo";
                PageUtility.displayOptions(columns1,chapters);
                String input = scanner.next();
                String serialNochaptersToBeDeleted[] = input.split(",");
                for(String id : serialNochaptersToBeDeleted){
                    chaptersToBeDeleted.add((Chapter) chapters.get(Integer.parseInt(id)-1));
                }
                System.out.println("Do you wish to delete chapters of any other book (Y/N)?");
                String option = scanner.next();
                while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                    System.out.println("Please enter valid option (Y/N).");
                    option = scanner.next();
                }
                if(option.equalsIgnoreCase("N")){
                    break;
                }
            }
            Chapter result = chapterController.deleteChapters(chaptersToBeDeleted);
            if(result == null){
                System.out.println("All the chapters for the respective books have been deleted!");
            }else{
                System.out.println("Deleted of chapter failed for the following chapter :\n"+result.toString());
                System.out.println("All the previous pairs have been successfully deleted.!");
                System.out.println("All the later pairs have been skipped!");
            }
    }

    private static void addChaptersToBook() {
        System.out.println("---------------------- ADD CHAPTERS TO BOOKS -------------------------");
        List<Object> books = bookController.getAllBooks();
        List<Chapter> chapters = new ArrayList<>();
        while(true){
            System.out.println("Select the serial number of the book for which you want to add a chapter : ");
            String columns = "SerialNo\tId\tTitle\tTopic\tISBN\tedition";
            PageUtility.displayOptions(columns,books);
            int num = scanner.nextInt();
            Book book = (Book) books.get(num-1);
            while(true){
                System.out.println("Enter the chapter No for the new chapter :");
                int chapterNo = scanner.nextInt();
                System.out.println("Enter the text for the new chapter : ");
                String dummy = scanner.nextLine();
                String text = scanner.nextLine();
                Chapter chapter = new Chapter(book,chapterNo,text);
                chapters.add(chapter);
                System.out.println("Do you wish to add more chapters to current book (Y/N)?");
                String option = scanner.next();
                while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                    System.out.println("Please enter valid option (Y/N).");
                    option = scanner.next();
                }
                if(option.equalsIgnoreCase("N")){
                    break;
                }
            }
            System.out.println("Do you wish to chapters to any other book (Y/N)?");
            String option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("N")){
                break;
            }
        }

        Chapter result = chapterController.addNewChapters(chapters);
        if(result == null){
            System.out.println("All the chapters for the respective books have been added!");
        }else{
            System.out.println("Addition of chapter failed for the following chapter :\n"+result.toString());
            System.out.println("All the previous pairs have been successfully added!");
            System.out.println("All the later pairs have been skipped!");
        }
    }

    public static void addArticlesToPeriodicPublication(){
        System.out.println("---------------------- ADD ARTICLES TO PERIODIC PUBLICATION -------------------------");

        List<HasArticle> hasArticles = new ArrayList<>();

        List<Object> periodicPublications = periodicPublicationController.getAllPeriodicPublications();
        List<Object> articles = articleController.getAllArticles();

        while(true){
            System.out.println("Select the serial number of the periodic publication to which you want to add an article : ");
            String columns = "SerialNo\tID\tTitle\tPublication Date\tPrice\tTopic\tPeriodicity";
            PageUtility.displayOptions(columns,periodicPublications);
            int num = scanner.nextInt();
            PeriodicPublication periodicPublication = (PeriodicPublication) periodicPublications.get(num-1);

            System.out.println("Enter the articles you wish to add for the given periodic publication :");

            System.out.println("Enter the serial numbers for articles to be assigned the current periodic publication (seperated by \",\") :");
            String columns2 = "SerialNo\tId\tTitle\tDate Of creation";
            PageUtility.displayOptions(columns2,articles);
            String articleSerialNumbers = scanner.next();
            String articlesToBeAssigned[] = articleSerialNumbers.split(",");

            for(String id : articlesToBeAssigned){
                Integer articleId = ((Article)(articles.get(Integer.parseInt(id)-1))).getArticleId();
                hasArticles.add(new HasArticle(periodicPublication.getPublication().getPublicationId(),articleId));
            }
            System.out.println("Do you wish to add articles to more periodic publications (Y/N)?");
            String option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("N")){
                break;
            }
        }

        HasArticle result = hasArticleController.addArticleToPeriodicPublication(hasArticles);
//        System.out.println("Dashboard result : "+result.toString());
        if(result == null){
            System.out.println("Articles have been assigned to given periodic publications successfully!");
        }else {
            //TODO
           System.out.println("Transaction failed due to the assignment of the following tuple :\n"+result.toString());
           System.out.println("Transaction rolled back!");
        }
    }


    public static void deleteArticlesForPeriodicPublication(){
        System.out.println("---------------------- DELETE ARTICLES FOR PERIODIC PUBLICATION -------------------------");
        List<Object> periodicPublications = periodicPublicationController.getAllPeriodicPublications();
        List<Object> articles = new ArrayList<>();
        List<HasArticle> hasArticles = new ArrayList<>();
        while(true){
            System.out.println("Select the serial number of the periodic publication for which you want to delete an article : ");
            String columns = "SerialNo\tID\tTitle\tPublication Date\tPrice\tTopic\tPeriodicity";
            PageUtility.displayOptions(columns,periodicPublications);
            int num = scanner.nextInt();
            PeriodicPublication periodicPublication = (PeriodicPublication) periodicPublications.get(num-1);
            articles = hasArticleController.getArticlesForPeriodicPublication(periodicPublication);
//            System.out.println("Enter the articles you wish to delete for the given periodic publication :");
            if(articles.size()==0){
                System.out.println("There are no articles assigned to this publication");
            } else {
                System.out.println("Enter the serial numbers for articles to be deleted for the current periodic publication (seperated by \",\") :");
                String columns2 = "SerialNo\tId\tTitle\tDate Of creation";
                PageUtility.displayOptions(columns2,articles);
                String articleSerialNumbers = scanner.next();
                String articlesToBeDeleted[] = articleSerialNumbers.split(",");

                for(String id : articlesToBeDeleted){
                    Integer articleId = ((Article)(articles.get(Integer.parseInt(id)-1))).getArticleId();
                    hasArticles.add(new HasArticle(periodicPublication.getPublication().getPublicationId(),articleId));
                }
            }

            System.out.println("Do you wish to delete articles for some more periodic publications (Y/N)?");
            String option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("N")){
                break;
            }
        }

        HasArticle result = hasArticleController.deleteArticlesForPeriodicPublication(hasArticles);
        if(result == null){
            System.out.println("Articles corresponding to given periodic publications have been deleted successfully!");
        }else{
            System.out.println("Deletion failed for the given pair :\n"+result.toString());
            System.out.println("All the previous pairs have been deleted added.!");
            System.out.println("All the later pairs have been skipped!");
        }
    }


    public static void getPublicationByTopic(){
        System.out.println("---------------------- GET PUBLICATION BY TOPIC -------------------------");
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Enter the serial Number of the publication topic you wish to retrieve publications for : ");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        int option = scanner.nextInt();
        PublicationTopic currentPublicationTopic = (PublicationTopic) publicationTopics.get(option-1);
        List<Object> publications = publicationController.getPublicationByTopic(currentPublicationTopic);
        if(publications.size()!=0){
            System.out.println("The publications for the given date are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            PageUtility.displayOptions(columns1,publications);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }

    }


    public static void getPublicationByDate(){
        System.out.println("---------------------- GET PUBLICATION BY DATE -------------------------");
        System.out.println("Enter the date of the publication you want to retrieve (YYYY-MM-DD): ");
        String date = scanner.next();
        List<Object> publications = publicationController.getPublicationByDate(date);
        if(publications.size()!=0){
            System.out.println("The publications for the given date are as follows : ");
            String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            PageUtility.displayOptions(columns1,publications);
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }


    public static void getPublicationById(){
        System.out.println("---------------------- GET PUBLICATION BY ID -------------------------");
        System.out.println("Enter the Id of the publication you want to retrieve : ");
        Integer publicationId = scanner.nextInt();
        Publication publication = publicationController.getPublicationById(publicationId);
        if(publication!=null){
            String columns1 = "\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            System.out.println(columns1);
            System.out.println("-----------------------------------------------------");
            System.out.println(publication.toString());
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }

    public static void getPublicationByTitle(){
        System.out.println("---------------------- GET PUBLICATION BY TITLE -------------------------");
        System.out.println("Enter the title of the publication you want to retrieve : ");
        String dummy = scanner.nextLine();
        String title = scanner.nextLine();
        Publication publication = publicationController.getPublicationByTitle(title);
        if(publication!=null){
            String columns1 = "\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            System.out.println(columns1);
            System.out.println("-----------------------------------------------------");
            System.out.println(publication.toString());
        }else{
            System.out.println(Constants.RECORD_NOT_FOUND.getMessage());
        }
    }

    public static  void updatePublication(){
        System.out.println("---------------------- UPDATE PUBLICATION -------------------------");
        List<Object> publications = publicationController.getAllPublications();
        System.out.println("Enter the serial number of the publication you wish to update: ");
        String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
        PageUtility.displayOptions(columns1,publications);
        int publicationSerialNumber= scanner.nextInt();
        Publication currentPublication = (Publication) publications.get(publicationSerialNumber-1);
        System.out.println("Do you want to update 'Title'? (Y/N) ");
        String option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new title : \t");
            String newTitle = scanner.nextLine();
            String str1 = scanner.nextLine();
            currentPublication.setPublicationTitle(str1);
        }
        System.out.println("Do you want to update 'Publication Date'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new Publication Date (YYYY-MM-DD) : \t");
            String newDate = scanner.next();
            currentPublication.setPublicationDate(Date.valueOf(newDate));
        }
        System.out.println("Do you want to update 'Price'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            System.out.println("Enter new Price: \t");
            Integer newPrice = scanner.nextInt();
            currentPublication.setPrice(newPrice);
        }
        System.out.println("Do you want to update 'Publication Topic'? (Y/N) ");
        option = scanner.next();
        while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("Please enter valid option (Y/N).");
            option = scanner.next();
        }
        if(option.equalsIgnoreCase("y")){
            List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
            System.out.println("Enter the serial Number of the publication topic you wish to assign for this publication : ");
            String columns = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns,publicationTopics);
            int newTopic = scanner.nextInt();
//            System.out.println(publicationTopics.get(newTopic-1).toString());
            currentPublication.setPublicationTopic((PublicationTopic) publicationTopics.get(newTopic-1));
//            System.out.println(currentPublication.toString());
        }
        if (publicationController.updatePublication(currentPublication)){
            System.out.println("Publication updated successfully!");
        }
    }

    public static void createPublication(){
        System.out.println("---------------------- CREATE PUBLICATION -------------------------");
        System.out.println("Enter the Title for the Publication : ");
        String dummy = scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the price for the publication : ");
        Integer price = scanner.nextInt();
        System.out.println("Enter the publication date : (YYYY-MM-DD)");
        String date = scanner.next();
        Date date1 = Date.valueOf(date);
        List<Object> publicationTopics = publicationTopicController.getAllPublicationTopics();
        System.out.println("Enter the serial number of the publication topic you wish to assign for this publication : ");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,publicationTopics);
        int option = scanner.nextInt();
        PublicationTopic currentPublicationTopic = (PublicationTopic) publicationTopics.get(option-1);
        int publicationId = publicationController.createPublicationAndGetId(new Publication(title,date1,price,currentPublicationTopic));
        if(publicationId !=-1){
            System.out.println("The following publication has been created successfully!");
            Publication publication = publicationController.getPublicationById(publicationId);
            System.out.println(publication.toString());
        }
    }


    public static void getEditorsForPublication(){
        System.out.println("------------- GET EDITORS FOR PUBLICATION -----------------------");
        List<Object> publications = publicationController.getAllPublications();
        System.out.println("Choose the publication serial no you want to fetch the editors for : ");
        String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPublicationTopic";
        PageUtility.displayOptions(columns1,publications);
        int publicationSerialNumber= scanner.nextInt();
        Publication publication = (Publication) publications.get(publicationSerialNumber-1);
        List<Object> editors = editsController.getEditorForPublication(publication);
        String columns = "SerialNo\tId\tName\tPay\tPeriodicty";
        System.out.println("The editors assigned to given publication are as follows : ");
        PageUtility.displayOptions(columns,editors);
    }

    public static void getPublicationForEditors(){
        System.out.println("------------- GET PUBLICATION FOR EDITORS -----------------------");
        List<Object> editors = editorController.getAllEditors();
        System.out.println("Enter the serial number of editor for which you will like to see the publications :");
        String columns = "SerialNo\tId\tName";
        PageUtility.displayOptions(columns,editors);
        int editorSerialNuber = scanner.nextInt();
        Editor currentEditor = (Editor) editors.get(editorSerialNuber-1);
        List<Object>publications = editsController.getPublicationsForEditor(currentEditor);
        String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
        System.out.println("The publications assigned to "+currentEditor.getEmployee().getEmployeeName()+" are as follows : ");
        PageUtility.displayOptions(columns1,publications);
    }

    public static void assignEditors(){
        System.out.println("---------------------- ASSIGN EDITORS TO PUBLICATIONS ----------");
        List<Object> publications = publicationController.getAllPublications();
        List<Object> editors = editorController.getAllEditors();
        List<Edits> edits = new ArrayList<>();
        while(true){
            System.out.println("Choose the publication serial no you want to assign editors for : ");
            String columns1 = "SerialNo\tId\tTitle\tPublicationDate\tPrice\tPublicationTopic";
            PageUtility.displayOptions(columns1,publications);
            int publicationSerialNumber= scanner.nextInt();
            Publication currentPublication = (Publication) publications.get(publicationSerialNumber-1);
            System.out.println("Enter the serial numbers for editors to be assigned the current publication (seperated by \",\") :");
            String columns2 = "SerialNo\tId\tName";
            PageUtility.displayOptions(columns2,editors);
            String editorSerialNumebrs = scanner.next();
            String editorsToBeAssigned[] = editorSerialNumebrs.split(",");
            for(String id : editorsToBeAssigned){
                Editor e = (Editor) editors.get(Integer.parseInt(id)-1);
                edits.add(new Edits(e,currentPublication));
            }
            System.out.println("Do you wish to add editors for more publications (Y/N)?");
            String option = scanner.next();
            while(!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
                System.out.println("Please enter valid option (Y/N).");
                option = scanner.next();
            }
            if(option.equalsIgnoreCase("N")){
                break;
            }
        }

        Edits result = editsController.assignEditorToPublication(edits);
        if(result == null){
            System.out.println("Editors have been assigned to given publications successfully!");
        }else{
            System.out.println("Transaction failed due to the assignment of the following tuple :\n"+result.toString());
            System.out.println("Transaction rolled back!");
        }

    }



    private static void initMainMenu(){
        mainMenu = new ArrayList<>();
        mainMenu.add("Publication.");
        mainMenu.add("Periodic Publication.");
        mainMenu.add("Book.");
        mainMenu.add("Article.");
        mainMenu.add("Distributor.");
        mainMenu.add("Order.");
        mainMenu.add("Revenue.");
        mainMenu.add("Exit.");
    }

    private static void initPublicationMenu() {
        publicationMenu = new ArrayList<>();
        publicationMenu.add("View all publications.");
        publicationMenu.add("Enter new publication.");
        publicationMenu.add("Update publication.");
        publicationMenu.add("Get publication by TITLE.");
        publicationMenu.add("Get publication by DATE.");
        publicationMenu.add("Get publication by TOPIC.");
        publicationMenu.add("Get publication by ID.");
        publicationMenu.add("Assign Editors to Publication.");
        publicationMenu.add("Get Editors for publication.");
        publicationMenu.add("Get publications for editor.");
        publicationMenu.add("Go Back.");
    }

    private static void initPeriodicPublicationMenu() {
        periodicPublicationMenu = new ArrayList<>();
        periodicPublicationMenu.add("View all periodic publications");
        periodicPublicationMenu.add("Add new issue.");
        periodicPublicationMenu.add("Update issue.");
        periodicPublicationMenu.add("Delete issue.");
        periodicPublicationMenu.add("Add articles to periodic publication.");
        periodicPublicationMenu.add("Delete articles from periodic publication.");
        periodicPublicationMenu.add("Go Back.");
    }

    private static void initBookMenu(){
        bookMenu = new ArrayList<>();
        bookMenu.add("View all Books");
        bookMenu.add("Add Book.");
        bookMenu.add("Delete Book.");
        bookMenu.add("Get Book by TOPIC.");
        bookMenu.add("Get Book by AUTHOR NAME.");
        bookMenu.add("Get Book by DATE.");
        bookMenu.add("Add Book Edition.");
        bookMenu.add("Update Book Edition.");
        bookMenu.add("Delete Book Edition.");
        bookMenu.add("Add chapters to Book.");
        bookMenu.add("Delete chapters of Book.");
        bookMenu.add("Go Back.");
    }

    private static void initArticleMenu(){
        articleMenu = new ArrayList<>();
        articleMenu.add("View all articles.");
        articleMenu.add("Add article.");
        articleMenu.add("Update article.");
        articleMenu.add("Delete article.");
        articleMenu.add("Get Article by TOPIC.");
        articleMenu.add("Get Article by AUTHOR NAME.");
        articleMenu.add("Get Article by DATE.");

        articleMenu.add("Go Back.");

    }

    private static void initDistributorMenu(){
        distributorMenu = new ArrayList<>();
        distributorMenu.add("View all active distributors.");
        distributorMenu.add("Add distributor.");
        distributorMenu.add("Update distributor.");
        distributorMenu.add("Delete distributor.");
        distributorMenu.add("Go Back.");
    }
    private static void initOrderMenu(){
        orderMenu = new ArrayList<>();
        orderMenu.add("View paid orders");
        orderMenu.add("View unpaid orders.");
        orderMenu.add("Create Order and update Balance");
        orderMenu.add("Generate Bill and update Balance");
        orderMenu.add("Go Back.");
    }
    private static void initRevenueMenu(){
        revenueMenu = new ArrayList<>();
        revenueMenu.add("Number and total price of copies of each publication bought per distributor per month.");
        revenueMenu.add("Total revenue.");
        revenueMenu.add("Total expense.");
        revenueMenu.add("Total revenue per city.");
        revenueMenu.add("Total revenue per location.");
        revenueMenu.add("Total revenue per distributor.");
        revenueMenu.add("Total current number of distributors");
        revenueMenu.add("Total payment per time period and per work type");
//        revenueMenu.add("Total payment per time period and per work type (ARTICLE authorship)");
//        revenueMenu.add("Total payment per time period and per work type (EDITOR authorship)");
        revenueMenu.add("Process Employee Payments.");
        revenueMenu.add("Go Back.");
    }

    private static int displayMenuAndGetOption(List<String> menu){
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|-----------------------------MENU--------------------------------------|");
        System.out.println("|-----------------------------------------------------------------------|");
        String option ="";
        int finalOption =0;
        for(int i=0;i<menu.size();i++){
            System.out.println((i+1)+".\t"+menu.get(i));
        }
        System.out.println("Enter choice : ");
        option = scanner.next();
        try{
            finalOption = Integer.parseInt(option);

        }catch(Exception e){
            System.out.println("Please enter a valid integer!");
        }
        while(finalOption<0 || finalOption > menu.size() ){
            System.out.println("Wrong input! Enter correct choice : ");
            option = scanner.next();
            try{
                finalOption = Integer.parseInt(option);
            }catch(Exception e){
                System.out.println("Please enter a valid integer!");
            }
        }

        return finalOption;
    }


    private static void initCalendar() {
        calendar = new HashMap<>();
        calendar.put(1,31);
        calendar.put(2,28);
        calendar.put(3,31);
        calendar.put(4,30);
        calendar.put(5,31);
        calendar.put(6,30);
        calendar.put(7,31);
        calendar.put(8,31);
        calendar.put(9,30);
        calendar.put(10,31);
        calendar.put(11,30);
        calendar.put(12,31);
    }

}