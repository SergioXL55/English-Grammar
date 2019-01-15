package my.database.service;

import my.database.entity.Account;

import java.util.List;

/**
 * User: Sushakov
 * Date: 12/28/2018
 * Time: 17:40
 **/

public interface AccountTable {

    void insert(String name,String pass,boolean locked,int role);
    Account get(int id) ;
    boolean lock(int id) ;
    List<Account> getAll();
}
