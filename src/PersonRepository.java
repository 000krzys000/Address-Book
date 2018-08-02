import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersonRepository {
    List<Person> persList;
    String filePath;
    String name;
    String lasName;
    int phoneNumber;
    Scanner reader = new Scanner(System.in); // co zrobić aby nie tworzyć tego obiektu kilka razy? Jakbym miał wszędzie potrzebę użycia Scannera?


    public PersonRepository(List<Person> persList){
        this.persList = persList;
    }


    public void addPerson(){
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
            writer();
        }
    }

    public void deletePerson(){
        String deleteName;


        System.out.println("Insert name which want you canceled. ");
        deleteName = reader.next().toUpperCase();


        ListIterator<Person> iter = persList.listIterator();

        while (iter.hasNext()){
            if(iter.next().getName().equals(deleteName)){

                iter.remove();
            }
        }
        writer();
    }



    public void writer(){
        try {
            FileWriter fileWriter = new FileWriter("ksiazkiSort.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(Person str:persList){
                writer.write(str.toString().toUpperCase());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
