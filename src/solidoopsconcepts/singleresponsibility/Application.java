package solidoopsconcepts.singleresponsibility;

public class Application {
    public static void main(String [] args){
        System.out.println("This is single responsibility");

        // Here we are considering that operations like calculating invoice, and
        // saving invoice to database and printing the database are a little complex
        // operations and they cannot be clubbed together so the single responsibility principle
        // says that we should not write all of those functions in a single class
        // rather we should write invoice calculate in different class and so on
        // meaning that each class will have a single responsibility.


//      Bad example

//      because a single class has more than one responsibility  - i.e to interact with db
//      and at the same time calculate total of invoice and then also printing the invoice using print
//      command or whatever

        SingleResponsibilityInvoiceBadExample sObj = new SingleResponsibilityInvoiceBadExample();
        sObj.calculateTotal();
        sObj.printInvoice();
        sObj.saveInvoiceToDatabase();

//        Good Example
//        In which all these responsibilities are given to different classes

        Invoice invoice = new Invoice();
        invoice.calculateTotal();
        InvoicePrinter invoicePrinter = new InvoicePrinter();
        invoicePrinter.printInvoice();
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        invoicePrinter.printInvoice();

//        We cannot write all functionalities in a single class because to edit changes in one of the
//        areas might cause an issue or bug in another area
    }
}
