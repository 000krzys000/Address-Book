//Podział na klasy. Czy jeszcze jakieś klasy powinni=y istnieć.
// Klasy Writer i Redaer nie potrafię ich stworzyć.

import java.io.*;
import java.util.*;


public class MainList extends ArrayListClass {
    private int chooseNumber;
    private String name;
    private String lasName;
    private int phoneNumber;
    public String filePath;





    //List<Person> persList = new ArrayList<>();
    Scanner reader = new Scanner(System.in);
    WriterClass writerClass = new WriterClass(filePath);
    //ArrayListClass arrayListClass = new ArrayListClass();




    public void chooseList() {
            do {

                    System.out.println("Insert which following operation do you need.");
                    System.out.println("1. Add new person.");
                    System.out.println("2. Delete person.");
                    System.out.println("3. Display all persons.");
                    System.out.println("4. Sort persons by name.");
                    System.out.println("5. Sort persons by last name.");
                    System.out.println("6. Sort persons phone number.");
                    chooseNumber = reader.nextInt();
                    if(chooseNumber>=7) {
                        try {
                            throw new Exception("Wrong number!!!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }



            } while (chooseNumber >= 7);


            switch (chooseNumber) {
                case 1:
                    addPerson();
                    break;

                case 2:
                    deletePerson();
                    break;

                case 3:
                    displayAllPersons();
                    break;

                case 4:
                    sortList();
                    break;

                case 5:
                    sortListLasName();
                    break;

                case 6:
                    sortPhoneNumber();
                    break;


                default:
                    System.out.println("Wrong number, please insert number again.");
            }



    }

    public void addPerson(){
        readList();
        displayList();
        int choice;
        filePath = "ksiazki.txt";

        System.out.println("Please insert name: ");
        name = reader.next().toUpperCase();
        System.out.println("Please insert last Name: ");
        lasName = reader.next().toUpperCase();
        System.out.println("Please insert phone number: ");
        phoneNumber = reader.nextInt();
        Person personAdd = new Person(name,lasName,phoneNumber);
        boolean exist = persList.contains(personAdd);

        if (exist == true){
            System.out.println("Person is in data base. Insert 1 if you want to correct your data or isert 2 if you want to exit program.");
            choice = reader.nextInt();
            switch (choice){
                case 1:
                    addPerson();
                    break;
                case 2:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Wrong number.");
            }
        }else {
            persList.add(new Person(name,lasName,phoneNumber));
            writerClass.writerClasser();

            //writerSecond();
        }





        displayAllPersons();

    }

    public void deletePerson(){
        String deleteName;

        displayList();

        System.out.println("Insert name which want you canceled. ");
        deleteName = reader.next().toUpperCase();


        ListIterator<Person> iter = persList.listIterator();

        while (iter.hasNext()){
            if(iter.next().getName().equals(deleteName)){

                iter.remove();
            }
        }


        displayAllPersons();

    }

    public void displayAllPersons(){
        displayList();

    }

    public void welcomePage() {
        System.out.println("Welcome in Adress Book!");
        readList();
        chooseList();
    }

    public void readList(){
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader("ksiazki.txt"));

            while ((line = br.readLine())!=null){

                StringTokenizer stringTokenizer = new StringTokenizer(line, ", ");

                while (stringTokenizer.hasMoreElements()){
                     name = stringTokenizer.nextElement().toString();
                     lasName = stringTokenizer.nextElement().toString();
                     phoneNumber = Integer.parseInt(stringTokenizer.nextElement().toString());
                    persList.add(new Person(name,lasName,phoneNumber));

                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (br !=null)
                    br.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }

    public void sortList(){
        filePath = "ksiazkiSort.txt";
        readList();

        //filePath ="ksiazkiSort.txt";
        Collections.sort(persList, Person.nameComparator);
        writerClass.writerClasser();
        //writer();
        displayList();


    }

    public void sortListLasName(){
        Collections.sort(persList, Person.lasNameComparator);
        writer();
        displayList();
    }

    public void sortPhoneNumber(){
        readList();
        Collections.sort(persList, Person.phoneNumberComparator);
        writer();
        displayList();
    }

    public void displayList(){
        for(Person str: persList){
            System.out.println(str);
        }


    }

    public void writer(){
        filePath ="ksiazkiSort.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(Person str:persList){
                writer.write(str.toString().toUpperCase());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writerSecond(){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(Person str:persList){
                writer.write(str.toString().toUpperCase());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test(){
        readList();
        boolean answer= persList.contains(name.equals(" ROMAN"));
        if(answer == true){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

        if(persList.contains(name.equals("KRIS"))){
            System.out.println("dupa");
        }else {
            System.out.println("nie dupa");
        }
    }


}

