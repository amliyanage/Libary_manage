package org.example.Bo.Custom;

import org.example.Bo.BorrowBookService;
import org.example.Dao.BookRepository;
import org.example.Dao.BookTransactionRepository;
import org.example.Dao.BorrowBookRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dto.BookDto;
import org.example.Entity.Book_Transaction;
import org.example.Entity.Books;
import org.example.Entity.BorrowBook;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookServiceImpl implements BorrowBookService {

    private Session session;

    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private final BorrowBookRepository borrowBookRepository = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.BorrowBook);
    private final BookTransactionRepository transactionRepository = (BookTransactionRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Book_Transaction);

    @Override
    public List<String> getTitles() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        return bookRepository.getOneData();
    }

    @Override
    public BookDto getData(String title) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        Books data = bookRepository.getData(title);

        return new BookDto(data.getId(), data.getTitle(), data.getAutor(), data.getDis(), data.getGenre(), data.getAvailable());
    }

    @Override
    public boolean saveTransaction(List<String> data) {

        Member member = MemberServiceImpl.member;

        List<Books> books = new ArrayList<>();

        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        for (String title : data) {
            bookRepository.SetSession(session);
            books.add(bookRepository.getData(title));
        }

        Date date = Date.valueOf(LocalDate.now().plusDays(7));


        try {
            BorrowBook borrowBook = new BorrowBook(
                    -1,
                    data.size(),
                    date,
                    "Pending",
                    null,
                    member,
                    0,
                    new ArrayList<>()
            );

            borrowBookRepository.SetSession(session);
            int saved = borrowBookRepository.saved(borrowBook);

            for (Books book : books) {
                book.setAvailable("No");
                bookRepository.SetSession(session);
                bookRepository.Update(book);

                Book_Transaction bookTransaction = new Book_Transaction(
                        -1,
                        borrowBook,
                        book
                );

                transactionRepository.SetSession(session);
                transactionRepository.saved(bookTransaction);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }

    }
}
