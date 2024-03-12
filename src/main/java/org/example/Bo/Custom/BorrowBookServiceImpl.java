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
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Date;
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

        return new BookDto( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

//    @Override
//    public boolean saveTransaction(TransactionDto dto, MemberDto member, List<BookDto> books) {
//        BorrowBook entity = dto.toEntity();
//        entity.setMember(MemberServiceImpl.member);
//
//        session = SessionFactoryConfiguration.getInstance().getSession();
//        org.hibernate.Transaction transaction = session.beginTransaction();
//
//        try {
//
//            transactionRepository.SetSession(session);
//            int id = transactionRepository.saved(entity);
//
//            for (BookDto bookDto : books) {
//
//                bookDto.setAvailable("Not Available");
//                bookRepository.SetSession(session);
//                bookRepository.Update(new Books(
//                        bookDto.getId(),
//                        bookDto.getTitle(),
//                        bookDto.getAutor(),
//                        bookDto.getDis(),
//                        bookDto.getGenre(),
//                        bookDto.getAvailable(),
//                        AdminServiceImpl.admin
//                ));
//
//                transactionDetailRepository.SetSession(session);
//                TransactionDetailPK pk = transactionDetailRepository.Saved(new Book_Transaction(
//                        new TransactionDetailPK(entity.getId(), bookDto.getId()),
//                        entity,
//                        new Books()
//                ));
//            }
//
//            transaction.commit();
//            return true;
//
//        } catch (Exception e) {
//
//            transaction.rollback();
//            e.printStackTrace();
//            return false;
//
//        } finally {
//            session.close();
//        }
//    }

    @Override
    public boolean saveTransaction(List<String> data) {
        Member member = MemberServiceImpl.member;

        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        borrowBookRepository.SetSession(session);
        int saved = 0;
        for (int i = 0; i < data.size(); i++) {

            BorrowBook borrowBook = new BorrowBook(
                    data.size(),
                    LocalDate.now().plusDays(7),
                    "Pending",
                    member
            );

            int save = borrowBookRepository.saved( borrowBook );
            if (save < 0) {
                transaction.rollback();
                return false;
            }
            transaction.commit();
            session.close();
            if (save > 0) {

                session = SessionFactoryConfiguration.getInstance().getSession();
                Transaction transaction1 = session.beginTransaction();
                transactionRepository.SetSession(session);
                int saved1 = transactionRepository.saved(new Book_Transaction(1, borrowBook, bookRepository.getData(data.get(i))));
                transaction1.commit();
                System.out.println(saved1);

                if (saved1 < 0) {
                    transaction1.rollback();
                    transaction.rollback();
                    return false;
                }
            }
        }
        return true;
    }

}
