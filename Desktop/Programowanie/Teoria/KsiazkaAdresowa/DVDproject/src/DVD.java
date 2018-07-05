import java.util.Objects;

public class DVD {
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return name + lastName+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DVD)) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(getName(), dvd.getName()) &&
                Objects.equals(getLastName(), dvd.getLastName());
    }


    private String name;
    private String lastName;

    public DVD(String name, String lastName){
        this.name = name;
        this.lastName = lastName;

    }

    /*@Override
    public boolean equals (Object obj){
        return (this.name.equals(((DVD)obj).name)&& this.lastName.equals(((DVD)obj).lastName));
    }*/

}
