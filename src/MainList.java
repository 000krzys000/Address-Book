//Podział na klasy. Czy jeszcze jakieś klasy powinni=y istnieć.


// jezeli metody nic nie przyjmuje i nie zwraca to możę być coś nie tak.
// nie wiecej niż 150 linijek kodu to maks
//Podzielić. Operacje na plikach powinny być w jednej klasie. Odwoływać się do klas aby one coś zwracały.
// Mam PersonRepository w której trzymam listę Persons wraz z metodami i funkcjonalnościami przykładowo delete, add Person
//Zrobic test np. negative transfer czy na pewno działa. Testy są po to aby cały czas funkcjonowały przez cały okres działania apki. Jeżeli ktoś bądź ja dodam jakaś zmienną do apki to testy sprawdzą czy na pewno wszystko działa prawidłowo.
// Command E "Recent file"
import java.io.*;
import java.util.*;


public class MainList {
    private int chooseNumber;
    public int personId;
    private String logInName;
    private String logInLastName;



    List<Person> persList = new ArrayList<>();
    Scanner reader = new Scanner(System.in);
    PersonRepository personRepository = new PersonRepository(persList);
    PersonListRepository personListRepository = new PersonListRepository(persList);
    DVDRepository dvdRepository = new DVDRepository(persList/*,personId*/);




    public void chooseList() {
            do {

                    System.out.println("Insert which following operation do you need.");
                    System.out.println("1. Add new person.");
                    System.out.println("2. Delete person.");
                    System.out.println("3. Display all persons.");
                    System.out.println("4. Sort persons by name.");
                    System.out.println("5. Sort persons by last name.");
                    System.out.println("6. Sort persons by phone number.");
                    System.out.println("7. Display all dvd.");
                    System.out.println("8. Display only available dvd.");
                    System.out.println("9. Rent dvd.");
                    System.out.println("10. Return dvd.");
                    chooseNumber = reader.nextInt();
                    if(chooseNumber>=11) {
                        try {
                            throw new Exception("Wrong number!!!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }



            } while (chooseNumber >= 11);


            switch (chooseNumber) {
                case 1:
                    personListRepository.displayList();
                    personRepository.addPerson();
                    personListRepository.displayList();
                    break;

                case 2:
                    personListRepository.displayList();
                    personRepository.deletePerson();
                    personListRepository.displayList();
                    break;

                case 3:
                    personListRepository.displayList();
                    break;

                case 4:
                    personListRepository.sortList();
                    personRepository.writer();
                    personListRepository.displayList();
                    break;

                case 5:
                    personListRepository.sortListLasName();
                    personRepository.writer();
                    personListRepository.displayList();
                    break;

                case 6:
                    personListRepository.sortPhoneNumber();
                    personRepository.writer();
                    personListRepository.displayList();
                    break;

                case 7:
                    dvdRepository.displayAllDVD();
                    break;
                case 8:
                    dvdRepository.displayAvailableDVD();
                    break;

                case 9:
                    personListRepository.displayList();
                    dvdRepository.displayAllDVD();
                    dvdRepository.rentDVD(personId);
                    break;

                case 10:
                    personListRepository.displayList();
                    dvdRepository.displayAllDVD();
                    dvdRepository.removeDVD();
                    break;

                default:
                    System.out.println("Wrong number, please insert number again.");
            }



    }

    public void logIn() {
        System.out.println("Please insert your name: ");
        logInName = reader.next().toUpperCase();
        System.out.println("Please insert last name: ");
        logInLastName = reader.next().toUpperCase();
        for (Person loggedPerson : persList) {
            if (loggedPerson.getName().equals(logInName) && loggedPerson.getLasName().equals(logInLastName)) {
                System.out.println("Found!");
                personId = persList.indexOf(loggedPerson);
            }


        }

    }
}

