package ohtu.miniprojekti5000.logic;

/**
 *
 * @author miniprojekti-5000
 */
public class BibtexGenerator
{
    public BookReference create_new_book_bibtex(String heading, String author, String title, String publisher, String year)
    {
        // check here that values are valid. Must be implemented before wendsday. <------------------------------------------------------ todo here.
        
        return new BookReference(heading, author, title, publisher, year);
    }
}
