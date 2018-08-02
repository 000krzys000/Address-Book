import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PersonListRepository {
    List<Person> persList;

    public PersonListRepository(List<Person> persList) {
        this.persList = persList;
    }

    public void displayList(){
        for(Person str: persList){
            System.out.println(str);
        }
    }

    public void sortListLasName(){
        Collections.sort(persList, Person.lasNameComparator);
    }

    public void sortPhoneNumber(){
        Collections.sort(persList, Person.phoneNumberComparator);
    }

    public void sortList(){
        Collections.sort(persList, Person.nameComparator);
    }

    public void readList(){
        BufferedReader br = null;
        String name;
        String lasName;
        int phoneNumber;

        try {
            String line;
            br = new BufferedReader(new FileReader("ksiazkiSort.txt"));

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


}
