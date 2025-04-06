package solidoopsconcepts.singleresponsibility;

public class Invoice {
    public int calculateTotal(){
        return 3000;
    }
}

class InvoiceRepository{
    public void saveInvoiceToDatabase(){
        System.out.println("Saving to database ");
    }
}

class InvoicePrinter{
    public void printInvoice(){
        System.out.println("total is " + 3000);
    }
}


