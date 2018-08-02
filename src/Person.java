import org.jetbrains.annotations.NotNull;
//zmienne później konstruktor, metody, to Stringi + equlsy na końcu.

import java.util.Comparator;
import java.util.Objects;

public class Person {
    public String getName() {
        return name;
    }

    public String getLasName() {
        return lasName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber &&
                Objects.equals(name, person.name) &&
                Objects.equals(lasName, person.lasName);
    }


    private String lasName;
    private int phoneNumber;




    public Person(String name, String lasName ,int phoneNumber){
        this.name = name;
        this.lasName = lasName;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return name +", " + lasName +", " + phoneNumber+"\n";
    }


    public static Comparator<Person> nameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            String PersonName1 = o1.getName().toUpperCase();
            String PersonName2 = o2.getName().toUpperCase();
            return PersonName1.compareTo(PersonName2);
        }
    };

    public static Comparator<Person> lasNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            String PersonLasName1 = o1.getLasName().toUpperCase();
            String PersonLasName2 = o2.getLasName().toUpperCase();
            return PersonLasName1.compareTo(PersonLasName2);

        }
    };

    public static Comparator<Person> phoneNumberComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int phoneNumber1 = o1.getPhoneNumber();
            int phoneNumber2 = o2.getPhoneNumber();
            return phoneNumber1 - phoneNumber2;
        }
    };



}
