import java.io.*;
import java.util.*;

public class WorkSpace {
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    private String name;
    private String lastName;


    List<DVD> list = new ArrayList();
    Scanner reader = new Scanner(System.in);


    public void adder() {
        list.add(new DVD("Kris", "Bis"));
        list.add(new DVD("Mis", "War"));
        list.add(new DVD("Loal", "Kio"));
        saver();
    }

    public void display() {
        for (DVD e : list) {
            System.out.println(e);
        }
        System.out.println("......");
    }

    public void remover() {
        boolean answer = list.contains("Kris");

        if (answer == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        ListIterator<DVD> iter = list.listIterator();
        while (iter.hasNext()){
            if(iter.next().getName().equals("Mis,")){
                iter.remove();

            }
        }


    }

    public void saver(){
        try {
            FileWriter fileWriter = new FileWriter("dvd.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(DVD str:list){
                writer.write(str.toString());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reader(){
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader("dvd.txt"));

            while ((line = br.readLine())!=null){

                StringTokenizer stringTokenizer = new StringTokenizer(line);

                while (stringTokenizer.hasMoreElements()){
                    name = stringTokenizer.nextElement().toString();
                    lastName = stringTokenizer.nextElement().toString();
                    list.add(new DVD(name,lastName));

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

    public void tester(){
        System.out.println("Please insert name: ");
        name = reader.next();
        System.out.println("Please insert last Name: ");
        lastName = reader.next();
        DVD dvdNext = new DVD(name, lastName);
        boolean exist = list.contains(dvdNext);

        if(exist == true){
            System.out.println("true oj");
        }else {
            System.out.println("false oh no");
        }


    }




        /*List<DVD> list = new ArrayList<>();
        list.add(new DVD("Kris", "Bis"));
        list.add(new DVD("Bas", "Mos"));
        list.add(new DVD("Kas", "Pros"));


        for (String e: list){
        System.out.println(e);
    }
        System.out.println(".......");

    boolean answer = list.contains("Kris");

        if (answer == true){
        System.out.println("True");
    }else {
        System.out.println("False");
    }

        System.out.println(".......");

        list.remove("Kris");
        for (String e: list){
        System.out.println(e);
    }


    public WorkSpace() {

    }*/
}


