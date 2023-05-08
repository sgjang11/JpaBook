package jpaBook.jpaShop;

import jpaBook.jpaShop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaBook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("ddd");
            entityManager.persist(book);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
