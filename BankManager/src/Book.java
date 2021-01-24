public class Book implements Comparable<Book> {
    int numberOfPages;
    String title;
    String author;


    public int compareTo(Book specifiedBook) {
        // Check if they have different page counts
        if(this.numberOfPages != specifiedBook.numberOfPages){
            return this.numberOfPages - specifiedBook.numberOfPages;
    }
        // If page counts are identifcal, check if titles are different
        if(!this.title.equals((specifiedBook.title))) {
            return this.title.compareTo(specifiedBook.title);
        }
        // If page titles are also identical, return the comparison of authors
        return this.author.compareTo(specifiedBook.author);
}
}
