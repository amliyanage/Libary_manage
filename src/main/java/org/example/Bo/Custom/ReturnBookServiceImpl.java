package org.example.Bo.Custom;

import org.example.Bo.ReturnBookServiceI;
import org.example.Dao.BookRepository;
import org.example.Dao.BookTransactionRepository;
import org.example.Dao.BorrowBookRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Entity.*;
import org.example.unill.GetIdNumber;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReturnBookServiceImpl implements ReturnBookServiceI {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);

    private final BookTransactionRepository bookTransactionRepository = (BookTransactionRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Book_Transaction);

    private final BorrowBookRepository borrowBookRepository = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.BorrowBook);

    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private Session session;
    @Override
    public ArrayList<Integer> getAllId(){
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        ArrayList<Member> all = memberRepository.getAll();
        ArrayList<Integer> ids = new ArrayList<>();
        for (Member member : all) {
            ids.add(member.getId());
        }
        session.close();
        return ids;
    }

//    @Override
//    public List<Book_Transaction> getPendingData(String value) {
////        int MemberId = GetIdNumber.getIdNumber("M", value);
//       session = SessionFactoryConfiguration.getInstance().getSession();
////
////        borrowBookRepository.SetSession(session);
////        BorrowBook data = borrowBookRepository.getData("" + MemberId);
////
////        int BorrowId = data.getId();
////
////        session = SessionFactoryConfiguration.getInstance().getSession();
////        bookTransactionRepository.SetSession(session);
////        List<Book_Transaction> transactionList = bookTransactionRepository.bookTransactionData("" + BorrowId);
////
////        return transactionList;
//        borrowBookRepository.SetSession(session);
//        BorrowBook borrowBook = borrowBookRepository.getData("a");
//        List<Book_Transaction> details = borrowBook.getDetails();
//
//        for(Book_Transaction bookTransaction : details){
//            int id = bookTransaction.getBook().getId();
//            System.out.println(id);
//        }
//        return null;
//    }


    @Override
    public BorrowBook getPendingData(String value) {

        session = SessionFactoryConfiguration.getInstance().getSession();
        int m = GetIdNumber.getIdNumber("M", value);
        memberRepository.SetSession(session);
        Member data1 = memberRepository.getData(""+m);

        session.close();

        session = SessionFactoryConfiguration.getInstance().getSession();
        borrowBookRepository.SetSession(session);
        BorrowBook data = borrowBookRepository.getData(data1);
        session.close();

//        List<Book_Transaction> details = data.getDetails();

//        for(Book_Transaction bookTransaction : details){
//            int id = bookTransaction.getBook().getId();
//
//            Books books = bookTransaction.getBook();
//            books.setAvailable("Yes");
//
//            session = SessionFactoryConfiguration.getInstance().getSession();
//            bookRepository.SetSession(session);
//            bookRepository.Update(books);
//            session.close();
//        }

        return data;
    }

    @Override
    public boolean returnBook(BorrowBook borrowBook) {

        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Book_Transaction> details = borrowBook.getDetails();

            for(Book_Transaction bookTransaction : details){
                int id = bookTransaction.getBook().getId();

                Books books = bookTransaction.getBook();
                books.setAvailable("Yes");
                System.out.println(books.getId());
                bookRepository.SetSession(session);
                bookRepository.Update(books);
            }

            borrowBookRepository.SetSession(session);
            borrowBook.setStatus("Yes");
            borrowBookRepository.Update(borrowBook);

            transaction.commit();

            session.close();
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public List<BorrowBook> getAllTableData() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        borrowBookRepository.SetSession(session);
        List<BorrowBook> all = borrowBookRepository.getAll();

        session.close();

        return all;
    }

}
