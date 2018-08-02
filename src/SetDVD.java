public class SetDVD {
    public String getTitle() {
        return title;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public String getDvdId(){
        return dvdId;
    }

    public void setDvdId(String dvdId) {
        this.dvdId = dvdId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }
    public int getRentedNumber() {
        return rentedNumber;
    }

    public void setRentedNumber(int rentedNumber) {
        this.rentedNumber = rentedNumber;
    }


    private String dvdId;
    private String title;
    private int productionDate;
    private int rentedNumber;


    @Override
    public String toString() {

        return dvdId+". "+ title +", " + productionDate+", "+rentedNumber+"\n";

/*
        if (rentedNumber == 0){
            return dvdId+". "+ title +", " + productionDate+","+"AVAILABLE"+"\n";

        }else{
            return dvdId+". "+ title +", " + productionDate+", "+rentedNumber+"\n";

        }*/

    }



    public SetDVD(String dvdId, String title, int productionDate, int rentedNumber){
        this.dvdId = dvdId;
        this.title = title;
        this.productionDate = productionDate;
        this.rentedNumber = rentedNumber;
    }


}
