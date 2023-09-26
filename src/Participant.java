public class Participant {
    private String nom;
    private int budget;

    public Participant(String nom, int budget) {
        this.nom = nom;
        this.budget = budget;
    }

    public void print(){
        System.out.println("Hello "+nom);
    }
    public String getNom() {
        return nom;
    }

    public int getBudget() {
        return budget;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
