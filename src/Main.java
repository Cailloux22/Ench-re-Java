public class Main {
    public static void main(String[] args) {

//        creation participant

        Participant Nicolas = new Participant("Nicolas", 500);
        Nicolas.print();

        Participant Mathieu = new Participant("Mathieu", 1000);
        Mathieu.print();

//        Creation products
        Product avion = new Product(200,"AirbusA380",30000);
        Product voiture = new Product(50,"Chevrolet Matiz",5000);


//        Creation List
        Participant[] participantList = new Participant[]{Nicolas, Mathieu};
        Product[] ProductList = new Product[]{avion,voiture};

//        Creation evt


        Selling evt = new Selling(participantList,ProductList,"EventIncroyable");
        evt.startTransaction();
    }
}