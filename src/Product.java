public class Product {
    private int startingPrice;
    private String title;
    private int weight;
    private String owner;

    public Product(int startingPrice, String title, int weight) {
        this.startingPrice = startingPrice;
        this.title = title;
        this.weight = weight;
        this.owner = "";
    }











    public int getStartingPrice() {
        return startingPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public String getOwner() {
        return owner;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
