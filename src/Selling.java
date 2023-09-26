import java.util.Scanner;

public class Selling {
    private Participant[] participantList;
    private Product[] productList;
    private int productInProgress=0;
    private String nameEvent;
    Scanner scanner = new Scanner(System.in);
    private int prixPropose;
    private Participant lastParticipant;
    public Selling(Participant[] participantList, Product[] productList, String nameEvent) {
        this.participantList = participantList;
        this.productList = productList;
        this.nameEvent = nameEvent;
        System.out.println("Welcome to "+nameEvent);
    }

    public void startTransaction(){
        System.out.println("Les enchère commencent avec un "+ productList[productInProgress].getTitle()+". Un participant est il interressé");

        for (Product product : productList) {
            if (productList.length>0){
                System.out.println("Nous vendons à present un/une magnifique "+productList[productInProgress].getTitle()+"\n pourla modique somme de "+productList[productInProgress].getStartingPrice()+"dollex");
            }
            boolean achat = false;
            while (!achat) {
                String nbChoisie = "-1";
                boolean choosepart= false;
                while(!choosepart) {
                    System.out.println("choisissez un participant :");
                    int i = 0;

                    for (Participant participant : participantList) {
                        System.out.println("Participant numéro " + i + " : " + participant.getNom());
                        i++;
                    }

                    nbChoisie = scanner.nextLine();
                    try{
                    if (Integer.parseInt(nbChoisie) < participantList.length){
                        choosepart=true;
                    }
                    }catch (Exception e){
                        if (nbChoisie.equals("stop") || nbChoisie.equals("-1") ) {
                            choosepart=true;
                            achat = true;
                            if (lastParticipant!=null) {
                                System.out.println(" le/la " + productList[productInProgress].getTitle() + " est vendu à " + lastParticipant.getNom() + " pour  : " + this.prixPropose);
                                this.lastParticipant.setBudget(this.lastParticipant.getBudget() - this.prixPropose);
                            }
//                            System.out.println(e.getMessage());
                        }
                    }

                }
                if (!achat){
                try {
                    int nombre = Integer.parseInt(nbChoisie);

                    Participant participantCh = participantList[nombre];

                    System.out.println("Proposez un prix " + participantCh.getNom() + " superieur a " + productList[productInProgress].getStartingPrice());
                    boolean prixCorrect = false;

                    while (!prixCorrect) {
                    this.prixPropose = scanner.nextInt();

                        if (this.prixPropose > participantCh.getBudget()) {
                            System.out.println("vous n'avez pas assez de budget, il vous reste : "+participantCh.getBudget() );
                        } else if (this.prixPropose < productList[productInProgress].getStartingPrice()) {
                            System.out.println("Vous avez proposez un prix en dessous du prix precedent");
                        } else {
                            prixCorrect = true;
                            productList[productInProgress].setStartingPrice(this.prixPropose);
                            this.lastParticipant=participantCh;
                            System.out.println("Un autre veut il encherir ? "+productList[productInProgress].getStartingPrice() );
                        }
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                }
            }
            if (productInProgress!=productList.length){
                productInProgress++;
            }

        }



    }
}
