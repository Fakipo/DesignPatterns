package designpatterns.iterator;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world, welcome to the iterator design pattern");
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("A Pale Blue Dot", "Carl Sagan"));
        bookCollection.addBook(new Book("Harry Potter", "JK Rowling"));
        bookCollection.addBook(new Book("A Brief History Of Time", "JK Rowling"));
        Iterator<Book> bookIterator = bookCollection.getIterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.getTitle());
        }
        System.out.println();
        MusicCollection musicCollection = new MusicCollection();
        musicCollection.add(new Music("The Scientist", "Coldplay"));
        musicCollection.add(new Music("Stairway to heaven", "Led Zepplin"));
        musicCollection.add(new Music("Comfortably numb", "Pink Floyd"));
        Iterator<Music> musicIterator = musicCollection.getIterator();
        while (musicIterator.hasNext()) {
            Music music = musicIterator.next();
            System.out.println(music.getName() + " by " + music.getArtist());
        }
    }
}
