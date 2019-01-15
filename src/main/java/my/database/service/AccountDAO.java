package my.database.service;

import my.database.entity.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
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
    private final SessionFactory sessionFactory;

    private final static String GET_ALL_ACCOUNT = "FROM Account";
    private final static String GET_ACCOUNT_TO_ID = "FROM Account where id=:id";

    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        openSession();
    }

    private void openSession(){
        session = sessionFactory.openSession();
        if(session.getTransaction().getStatus()!= TransactionStatus.ACTIVE)
            session.beginTransaction();
    }

    @Override
    public void insert(String name, String pass, boolean locked, int role) {
        openSession();
        account = new Account(name, pass, locked, role);
        session.save(account);
        session.getTransaction().commit();
        session.close();
        LOG.info("New Account : " + account.toString());
    }

    @Override
    public Account get(int id) {
        try {
            openSession();
            query = session.createQuery(GET_ACCOUNT_TO_ID, Account.class);
            query.setParameter("id", id);
            account = query.getSingleResult();
            LOG.info("Get : " + account.toString());
            return account;
        } catch (Exception e) {
            LOG.error("Can't get Account! error=" + e);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Account> getAll() {
        openSession();
        query = session.createQuery(GET_ALL_ACCOUNT, Account.class);
        session.close();
        return query.getResultList();
    }

    @Override
    public boolean lock(int id) {
        if((account = get(id))!=null){
            openSession();
            account.setLocked(true);
            session.update(account);
            session.getTransaction().commit();
            LOG.info("ACCOUNT id='" + id + "' WAS LOCKED!");
            session.close();
            return true;
        }
        return false;
    }
}
