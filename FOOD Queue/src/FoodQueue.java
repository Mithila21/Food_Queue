import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FoodQueue{
    static int burgerstock = 50;
    static String [] queue1 = {"  X  ","  X  ","     ","     ","     "};
    static String [] queue2 = {"  X  ","  X  ","  X  ","     ","     "};
    static String [] queue3 = {"  X  ","  X  ","  X  ","  X  ","  X  "};
    static String [] wait = {"  X  ","  X  ","  X  ","  X  ","  X  ","  X  ","  X  ","  X  "};

    static String [] custName1 = {"None", "None", "None", "None", "None"};
    static String [] custName2 = {"None", "None", "None", "None", "None"};
    static String [] custName3 = {"None", "None", "None", "None", "None"};
    static String [] waiting = {"None", "None", "None", "None", "None", "None", "None", "None"};

    static int IncomeQueueOne = 0;
    static int IncomeQueueTwo = 0;
    static int IncomeQueueThree = 0;
    // Enter Option Number
    public static void main(String[] args) {
        while (true) {
            System.out.println("100 or VFQ: View all Queues.\n" +
                    "101 or VEQ: View all None Queues.\n" +
                    "102 or ACQ: Add customer to a Queue.\n" +
                    "103 or RCQ: Remove a customer from a Queue.\n" +
                    "104 or PCQ: Remove a served customer.\n" +
                    "105 or VCS: View Customers Sorted in alphabetical order.\n" +
                    "106 or SPD: Store Program Data into file.\n" +
                    "107 or LPD: Load Program Data from file.\n" +
                    "108 or STK: View Remaining burgers Stock.\n" +
                    "109 or AFS: Add burgers to Stock.\n" +
                    "999 or EXT: Exit the Program.");
            // Get Inputs
            Scanner myInput = new Scanner(System.in);
            System.out.print("Enter Option : ");
            String optionNo = myInput.nextLine();
            if (optionNo.equals("100") || optionNo.equals("VFQ")) {

                String[][] queueLength = {(queue1), (queue2), (queue3)};
                // Checking whether specific queues have specific slots
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!queueLength[j][i].equals("X")) {
                            System.out.print(queueLength[j][i]);
                        } else {
                            System.out.print("     ");
                        }
                    }
                    System.out.println();
                }
                System.out.print("waiting list :- ");
                for (String i:wait){
                    System.out.print(i);
                }
                System.out.println();
                //  View all Empty Queues
            } else if (optionNo.equals("101") || optionNo.equals("VEQ")) {
                if (custName1[0].equals("None")){
                    System.out.println("queue 1 is Empty");
                }
                if (custName2[0].equals("None")){
                    System.out.println("queue 2 is Empty");
                }
                if (custName3[0].equals("None")){
                    System.out.println("queue 3 is Empty");
                }
                // Add customer to a Queue
            } else if (optionNo.equals("102") || optionNo.equals("VCQ")) {
                int firstQueueSize = 0;
                int secondQueueSize = 0;
                int thirdQueueSize = 0;
                for (String i : custName1) {
                    if (!i.equals("None")) {
                        firstQueueSize++;
                    }
                }
                for (String i : custName2) {
                    if (!i.equals("None")) {
                        secondQueueSize++;
                    }
                }
                for (String i : custName3) {
                    if (!i.equals("None")) {
                        thirdQueueSize++;
                    }
                } String customerQueue = "0";
                if ((firstQueueSize <= secondQueueSize) && (firstQueueSize < 2)) {
                    if (firstQueueSize <= thirdQueueSize) {
                        //adding to queue 1
                        customerQueue = "1";

                    } else {
                        //adding to queue 3
                        customerQueue = "3";
                    }
                } else {
                    if (thirdQueueSize <= secondQueueSize && thirdQueueSize < 5) {
                        //adding to queue 3
                        customerQueue = "3";
                    } else {
                        if (secondQueueSize < 3) {
                            //adding to queue 2
                            customerQueue = "2";

                        } else {
                            if (thirdQueueSize < 5) {
                                //adding to queue 3
                                customerQueue = "3";
                            } else {
                                //adding to waiting list
                                customerQueue = "4";
                            }
                        }
                    }
                }
                switch (customerQueue) {
                    case "1" -> {
                        int j = 0;
                        for (String i : custName1) {
                            if (i.equals("None")) {
                                String customerName1;
                                String customerName2;
                                while (true){
                                    Scanner cusName1 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 1st Name : ");
                                    customerName1 = cusName1.nextLine();
                                    if (customerName1.length() == 0) {
                                        System.out.println("Enter a name!");
                                    } else {
                                        break;
                                    }
                                }
                                while (true){
                                    Scanner cusName2 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 2nd Name : ");
                                    customerName2 = cusName2.nextLine();
                                    if (customerName2.length() == 0) {
                                        System.out.println("Enter a name!");
                                    } else {
                                        break;
                                    }
                                }
                                int burgers;
                                while (true){
                                    try {
                                        Scanner b = new Scanner(System.in);
                                        System.out.print("Enter how many burgers customer want :");
                                        burgers = b.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input");
                                    }
                                }
                                Customer cusData = new Customer(customerName1, customerName2, burgers);
                                custName1[j] = String.valueOf(cusData);
                                queue1[j] = "  O  ";
                                break;
                            } else {
                                j++;
                            }
                        }
                    }
                    case "2" -> {
                        int j = 0;
                        for (String i : custName2) {
                            if (i.equals("None")) {
                                String customerName1;
                                String customerName2;
                                while (true){
                                    Scanner cusName1 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 1st Name : ");
                                    customerName1 = cusName1.nextLine();
                                    if (customerName1.length() == 0) {
                                        System.out.println("Enter a name!");
                                    } else {
                                        break;
                                    }
                                }
                                while (true){
                                    Scanner cusName2 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 2nd Name : ");
                                    customerName2 = cusName2.nextLine();
                                    if (customerName2.length() == 0) {
                                        System.out.println("Enter a name! ");
                                    } else {
                                        break;
                                    }
                                }
                                int burgers;
                                while (true){
                                    try {
                                        Scanner b = new Scanner(System.in);
                                        System.out.print("Enter how many burgers customer want :");
                                        burgers = b.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input");
                                    }
                                }
                                Customer cusData = new Customer(customerName1, customerName2, burgers);
                                custName2[j] = String.valueOf(cusData);
                                queue2[j] = "  O  ";
                                break;
                            } else {
                                j++;
                            }
                        }

                    }
                    case "3" -> {
                        int j = 0;
                        for (String i : custName3) {
                            if (i.equals("None")) {
                                String customerName1;
                                String customerName2;
                                while (true){
                                    Scanner cusName1 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 1st Name : ");
                                    customerName1 = cusName1.nextLine();
                                    if (customerName1.length() == 0) {
                                        System.out.println("Enter a name!");
                                    } else {
                                        break;
                                    }
                                }
                                while (true){
                                    Scanner cusName2 = new Scanner(System.in);
                                    System.out.print("Enter Customer's 2nd Name : ");
                                    customerName2 = cusName2.nextLine();
                                    if (customerName2.length() == 0) {
                                        System.out.println("Enter a name!");
                                    } else {
                                        break;
                                    }
                                }
                                int burgers;
                                while (true){
                                    try {
                                        Scanner b = new Scanner(System.in);
                                        System.out.print("Enter how many burgers customer want :");
                                        burgers = b.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input");
                                    }
                                }
                                Customer cusData = new Customer(customerName1, customerName2, burgers);
                                custName3[j] = String.valueOf(cusData);
                                queue3[j] = "  O  ";
                                break;
                            } else {
                                j++;
                            }
                        }
                    }
                    case "4" -> {
                        int j = 0;
                        for (String i : waiting) {
                            if (i.equals("None")) {
                                Scanner cusName1 = new Scanner(System.in);
                                System.out.print("Enter Customer's 1st Name : ");
                                String customerName1 = cusName1.nextLine();
                                Scanner cusName2 = new Scanner(System.in);
                                System.out.print("Enter Customer's 2nd Name : ");
                                String customerName2 = cusName2.nextLine();
                                int burgers;
                                while (true){
                                    try {
                                        Scanner b = new Scanner(System.in);
                                        System.out.print("Enter how many burgers customer want :");
                                        burgers = b.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input");
                                    }
                                }
                                Customer cusData = new Customer(customerName1, customerName2, burgers);
                                waiting[j] = String.valueOf(cusData);
                                wait[j] = "  O  ";
                                break;
                            } else {
                                j++;
                            }
                        }
                    }
                }

            } else if (optionNo.equals("103") || optionNo.equals("RCQ")) {
                Scanner removeCusQueue = new Scanner(System.in);
                System.out.print("Enter Queue No : ");
                String removeCusQ = removeCusQueue.nextLine();

                try {
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("Enter position : ");
                    int userIn4 = input4.nextInt();
                    userIn4 = userIn4 - 1;
                    switch (removeCusQ) {
                        case "1" -> {
                            if (custName1[userIn4].equals("None")) {
                                System.out.println("it's None");
                            } else {
                                try {
                                    for (int i = userIn4; i < 2; i++) {
                                        custName1[i] = custName1[i + 1];
                                        queue1[i] = queue1[i + 1];
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    custName1[1] = "None";
                                }
                                queue1[1] = "  X  ";
                                if (!waiting[0].equals("None")){
                                    int j = 0;
                                    for (String i : custName1) {
                                        if (i.equals("None")) {
                                            custName1[j] = waiting[0];
                                            queue1[j] = "  O  ";
                                            try {
                                                for (int x = 0; x < 2; x++) {
                                                    waiting[x] = waiting[x + 1];
                                                    wait[x] = wait[x + 1];
                                                }
                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                custName1[1] = "None";
                                            }
                                            break;
                                        } else {
                                            j++;
                                        }
                                    }
                                }
                            }
                        }
                        case "2" -> {
                            if (custName2[userIn4].equals("None")) {
                                System.out.println("it's None");
                            } else {
                                try {
                                    for (int i = userIn4; i < 3; i++) {
                                        custName2[i] = custName2[i + 1];
                                        queue2[i] = queue2[i + 1];
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    custName2[2] = "None";
                                }
                                queue2[2] = "  X  ";
                                if (!waiting[0].equals("None")){
                                    int j = 0;
                                    for (String i : custName2) {
                                        if (i.equals("None")) {
                                            custName2[j] = waiting[0];
                                            queue2[j] = "  O  ";
                                            try {
                                                for (int x = 0; x < 2; x++) {
                                                    waiting[x] = waiting[x + 1];
                                                    wait[x] = wait[x + 1];
                                                }
                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                custName1[1] = "None";
                                            }
                                            break;
                                        } else {
                                            j++;
                                        }
                                    }
                                }
                            }
                        }
                        case "3" -> {
                            if (custName2[userIn4].equals("None")) {
                                System.out.println("it's None");
                            } else {
                                try {
                                    for (int i = userIn4; i < 5; i++) {
                                        custName3[i] = custName3[i + 1];
                                        queue3[i] = queue3[i + 1];
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    custName3[4] = "None";
                                }
                                queue3[4] = "  X  ";
                                if (!waiting[0].equals("None")){
                                    int j = 0;
                                    for (String i : custName3) {
                                        if (i.equals("None")) {
                                            custName3[j] = waiting[0];
                                            queue3[j] = "  O  ";
                                            try {
                                                for (int x = 0; x < 2; x++) {
                                                    waiting[x] = waiting[x + 1];
                                                    wait[x] = wait[x + 1];
                                                }
                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                custName1[1] = "None";
                                            }
                                            break;
                                        } else {
                                            j++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }


            } else if (optionNo.equals("104") || optionNo.equals("PCQ")) {
                Scanner removeCusQueue = new Scanner(System.in);
                System.out.print("Enter Queue No : ");
                String removeCusQ = removeCusQueue.nextLine();
                switch (removeCusQ) {
                    case "1" -> {
                        String[] valuesOfQueue1 = custName1[0].split(":");
                        int cstBurger01 = Integer.parseInt(valuesOfQueue1[2]);
                        try {
                            for (int i = 0; i < 2; i++) {
                                custName1[i] = custName1[i + 1];
                                queue1[i] = queue1[i + 1];
                                burgerstock=burgerstock-cstBurger01;
                                IncomeQueueOne+=cstBurger01;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            custName1[1] = "None";
                        }
                        queue1[1] = "  X  ";
                        if (!waiting[0].equals("None")){
                            int j = 0;
                            for (String i : custName1) {
                                if (i.equals("None")) {
                                    custName1[j] = waiting[0];
                                    queue1[j] = "  O  ";
                                    try {
                                        for (int x = 0; x < 2; x++) {
                                            waiting[x] = waiting[x + 1];
                                            wait[x] = wait[x + 1];
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        custName1[1] = "None";
                                    }
                                    break;
                                } else {
                                    j++;
                                }
                            }
                        }
                    }
                    case "2" -> {
                        String[] valuesOfQueue1 = custName2[0].split(":");
                        int cstBurger01 = Integer.parseInt(valuesOfQueue1[2]);
                        try {
                            for (int i =0; i < 3; i++) {
                                custName2[i] = custName2[i + 1];
                                queue2[i] = queue2[i + 1];
                                burgerstock=burgerstock-cstBurger01;
                                IncomeQueueTwo+=cstBurger01;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            custName2[2] = "None";
                        }
                        queue2[2] = "  X  ";
                        if (!waiting[0].equals("None")){
                            int j = 0;
                            for (String i : custName2) {
                                if (i.equals("None")) {
                                    custName2[j] = waiting[0];
                                    queue2[j] = "  O  ";
                                    try {
                                        for (int x = 0; x < 2; x++) {
                                            waiting[x] = waiting[x + 1];
                                            wait[x] = wait[x + 1];
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        custName1[1] = "None";
                                    }
                                    break;
                                } else {
                                    j++;
                                }
                            }
                        }
                    }
                    case "3" -> {
                        String[] valuesOfQueue1 = custName3[0].split(":");
                        int cstBurger01 = Integer.parseInt(valuesOfQueue1[2]);
                        try {
                            for (int i = 0; i < 5; i++) {
                                custName3[i] = custName3[i + 1];
                                queue3[i] = queue3[i + 1];
                                burgerstock=burgerstock-cstBurger01;
                                IncomeQueueThree+=cstBurger01;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            custName3[4] = "None";
                        }
                        queue3[3] = "  X  ";
                        if (!waiting[0].equals("None")){
                            int j = 0;
                            for (String i : custName3) {
                                if (i.equals("None")) {
                                    custName3[j] = waiting[0];
                                    queue3[j] = "  O  ";
                                    try {
                                        for (int x = 0; x < 2; x++) {
                                            waiting[x] = waiting[x + 1];
                                            wait[x] = wait[x + 1];
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        custName1[1] = "None";
                                    }
                                    break;
                                } else {
                                    j++;
                                }
                            }
                        }
                    }
                    default -> {System.out.println("Invalid input");}
                }


            } else if (optionNo.equals("105") || optionNo.equals("VCS")) {
                String[] temp1 = {"None", "None", "None", "None", "None"};
                int j=0;
                for (String i:custName1){
                    temp1[j]=i;
                    j++;
                }
                String[] temp2 = {"None", "None", "None", "None", "None"};
                int k=0;
                for (String i:custName2){
                    temp2[k]=i;
                    k++;
                }

                String[] temp3 = {"None", "None", "None", "None", "None"};
                int l=0;
                for (String i:custName3){
                    temp3[l]=i;
                    l++;
                }

                bubbleSort(temp1);
                bubbleSort(temp2);
                bubbleSort(temp3);
                System.out.println("queue One");
                for (String i: temp1){
                    if (!i.equals("None")) {
                        System.out.println(i);
                    }
                }
                System.out.println("queue two");
                for (String i: temp2){
                    if (!i.equals("None")) {
                        System.out.println(i);
                    }
                }
                System.out.println("queue three");
                for (String i: temp3){
                    if (!i.equals("None")) {
                        System.out.println(i);
                    }
                }

            } else if (optionNo.equals("106") || optionNo.equals("SPD")) {
                try {
                    //write file
                    File aaa = new File("log.txt");
                    if (aaa.createNewFile()) {
                        System.out.println("File created");
                    } else {
                        System.out.println("already there");
                    }
                    FileWriter writer = new FileWriter("log.txt");
                    PrintWriter pwriter = new PrintWriter(writer);
                    for (String i : custName1) {
                        if (!i.equals("None")) {
                            pwriter.print(i);
                            pwriter.print(" ");
                        }
                    }
                    pwriter.println("\n");
                    for (String i : custName2) {
                        if (!i.equals("None")) {
                            pwriter.print(i);
                            pwriter.print(" ");
                        }
                    }
                    pwriter.println("\n");
                    for (String i : custName3) {
                        if (!i.equals("None")) {
                            pwriter.print(i);
                            pwriter.print("\n");
                        }
                    }
                    writer.close();
                    System.out.println("Data Saved ");

                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } else if (optionNo.equals("107") || optionNo.equals("LPD")) {
                try {
                    File read = new File("log.txt");
                    Scanner readDetails = new Scanner(read);
                    int x = 0;
                    while (readDetails.hasNextLine()) {
                        String text = readDetails.nextLine();
                        if (!text.equals("")) {
                            System.out.println(text);
                            String[] tArray = text.split(" ");
                            if (x == 0) {
                                int j = 0;
                                for (String i : tArray) {
                                    custName1[j] = i;
                                    j++;
                                }
                            } else if (x == 1) {
                                int j = 0;
                                for (String i : tArray) {
                                    custName2[j] = i;
                                    j++;
                                }
                            } else if (x == 2) {
                                int j = 0;
                                for (String i : tArray) {
                                    custName3[j] = i;
                                    j++;
                                }
                            }
                            x++;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                // View Remaining burgers Stock
            } else if (optionNo.equals("108") || optionNo.equals("STK")) {
                System.out.println(burgerstock+" burgers");

            } else if (optionNo.equals("109") || optionNo.equals("AFS")) {
                try {
                    Scanner add = new Scanner(System.in);
                    System.out.print("How Many Burgers Do You Wanna Add? :");
                    int count = add.nextInt();
                    burgerstock += count;
                    System.out.println(burgerstock + " burgers are now available in stock ");
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
            } else if (optionNo.equals("110") || optionNo.equals("IFQ")) {
                System.out.println("Total income of the queue 01 is - "+(IncomeQueueOne*650));
                System.out.println("Total income of the queue 02 is - "+(IncomeQueueTwo*650));
                System.out.println("Total income of the queue 03 is - "+(IncomeQueueThree*650));
            } else if (optionNo.equals("999") || optionNo.equals("EXT")) {
                System.exit(0);
            }
        }
    }
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop,
            // the array is already sorted
            if (!swapped)
                break;
        }
    }
}

class Customer {
    String firstName;
    String secondName;
    int burgers;
    public Customer(String fstName, String sndName, int burg){
        this.firstName = fstName;
        this.secondName = sndName;
        this.burgers = burg;
    }

    @Override
    public String toString() {
        return firstName + ":" + secondName + ":" + burgers;
    }
}