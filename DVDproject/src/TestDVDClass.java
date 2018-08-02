import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.sql.Date;

//Jak ogarnąc Date aby wczytywał się do arrayListy.


public class TestDVDClass {
    public static void main (String args [])  {


        WorkSpace workSpace = new WorkSpace();
        workSpace.adder();
        workSpace.display();


        //workSpace.adder();
        //workSpace.display();
        //workSpace.reader();
        //workSpace.remover();
        //workSpace.display();
        //workSpace.adder();
        //workSpace.tester();

        /*SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString =  "2018-01-03";
        Date date = sfd.parse(dateInString);
*/
        /*String str = "2015-01-08";
        //Date date = Date.valueOf(str);
        java.sql.Date date = java.sql.Date.valueOf(str);*/

      /* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      // String dateInString = "2012-03-05";
       String insertDate;
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert your date: ");
        insertDate = reader.next();
       try {
           Date date = formatter.parse(insertDate);

           System.out.println(formatter.format(date));

       }catch (ParseException e){
           e.printStackTrace();
       }*/



    }

}
