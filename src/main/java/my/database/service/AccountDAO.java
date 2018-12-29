package my.database.service;

import my.database.entity.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Sushakov
 * Date: 12/28/2018
 * Time: 17:25
 **/
@Component
public class AccountDAO implements AccountTable {

    private static final Logger LOG = Logger.getLogger(AccountDAO.class);
    private Session session;
    private Query<Account> query;
    private Account account;

    private final static String GET_ALL_ACCOUNT = "FROM Account";
    private final static String GET_ACCOUNT = "FROM Account where id=:id";

    public AccountDAO(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    @Override
    public void insert(String name, String pass, boolean locked, int role) {
        account = new Account(name, pass, locked, role);
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
    }

    @Override
    public Account get(int id) {
        query = session.createQuery(GET_ACCOUNT, Account.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Account> getAll() {
        query = session.createQuery(GET_ALL_ACCOUNT, Account.class);
        return query.getResultList();
    }

}
