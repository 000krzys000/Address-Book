import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DVD {
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + lastName+birthDate+"\n";
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DVD)) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(getName(), dvd.getName()) &&
                Objects.equals(getLastName(), dvd.getLastName());
    }*/


    private String name;
    private String lastName;
    private String birthDate;



    public DVD(String name, String lastName, String birthDate){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;



    }

/*@Override
    public boolean equals (Object obj){
        return (this.name.equals(((DVD)obj).name)&& this.lastName.equals(((DVD)obj).lastName));
    }*/


}
