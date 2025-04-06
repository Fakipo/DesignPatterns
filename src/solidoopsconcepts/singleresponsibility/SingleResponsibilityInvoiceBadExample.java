package solidoopsconcepts.singleresponsibility;

public class SingleResponsibilityInvoiceBadExample {
    public int calculateTotal(){
        return 3000;
    }

    public void printInvoice(){
        System.out.println("Invoice = " + 3000);
    }

    public void saveInvoiceToDatabase(){
        System.out.println("Saved to database");
    }
}
