public class Items {
    private String barcode;
    private String name;
    private double prize;

    Items(){}
    Items(String barcode, String name, double prize){
        this.barcode = barcode;
        this.name = name;
        this.prize = prize;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getBarcode(){
        return barcode;
    }

    public double getPrize(){return prize;}
    public String getName(){return name;}

    public String toString() {
        return "iShop!-"+getBarcode() + "\t" + name + "\t\t$"+ prize;
    }
}
