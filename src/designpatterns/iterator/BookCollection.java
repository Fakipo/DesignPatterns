package designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Iterator<Book> getIterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator<Book> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            if(this.hasNext()){
                return books.get(index++);
            }
            return null;
        }
    }
}
