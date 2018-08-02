import javafx.scene.PerspectiveCamera;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DVDRepository {
    private String dvdId; // musiałem dać tutaj stringa ponieważ tworzy się spacja na początku w pliku OpenOffice jak i w setDVD jak i w Person. Nie wiem czemu
    private String title;
    private int productionDate;
    private int rentedNumber;
    private int movieNumber;
    private int personId;

    List<Person> persList;
    List<SetDVD> dvdList = new ArrayList<>();
    Scanner reader = new Scanner(System.in);



    public DVDRepository(List<Person> persList/*, int personId*/){
        this.persList = persList;
        //this.personId = personId;

    }

    public void readerDVD(){
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader("setDVD.txt"));

            while ((line = br.readLine())!=null){

                StringTokenizer stringTokenizer = new StringTokenizer(line, ", " + ". ");

                while (stringTokenizer.hasMoreElements()){
                    dvdId = stringTokenizer.nextElement().toString();
                    title = stringTokenizer.nextElement().toString();
                    productionDate = Integer.parseInt(stringTokenizer.nextElement().toString());
                    rentedNumber = Integer.parseInt(stringTokenizer.nextElement().toString());
                    dvdList.add(new SetDVD(dvdId,title,productionDate,rentedNumber));

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

    public void displayAllDVD(){
        readerDVD();
        for(SetDVD str: dvdList){
            if(str.getRentedNumber() == 0){
                System.out.println(str.getDvdId()+". "+str.getTitle()+", "+str.getProductionDate()+", "+"AVAILABLE"+"\n");

            }else {

                System.out.println(str.getDvdId() + ". " + str.getTitle() + ", " + str.getProductionDate() + ", " + persList.get(str.getRentedNumber()));
            }
        }
    }

    public void rentDVD(int personId){
        this.personId = personId;
        System.out.println("Please insert which movie number would you like to rent.");
        movieNumber = reader.nextInt();

        dvdList.get(movieNumber-1).setRentedNumber(personId);


        writerDVD();

    }

    public void writerDVD(){
        String filePath = "setDVD.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(SetDVD str:dvdList){
                writer.write(str.toString().toUpperCase());

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void removeDVD(){
        System.out.println("Please insert which movie number would you like to return.");
        movieNumber = reader.nextInt();

        dvdList.get(movieNumber-1).setRentedNumber(0);
        writerDVD();


    }

    public void displayAvailableDVD(){
        readerDVD();
        for(SetDVD str: dvdList){
            if(str.getRentedNumber() == 0){
                System.out.println(str.getDvdId()+". "+str.getTitle()+", "+str.getProductionDate()+"\n");

            }
        }


    }

}
