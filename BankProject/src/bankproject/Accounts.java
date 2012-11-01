/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

import java.util.*;

/**
 *
 * @author s504
 */
public class Accounts {
    
   //array of all acounts
    
    private ArrayList<AccountHolder> accountsList = new ArrayList<AccountHolder>();
    //private AccountHolder[] accountsList =  new AccountHolder[100];
    
    public void newAccount(AccountHolder element) {
        Vault.getInstance().interfereWithVault(element.ballance, '+');
        accountsList.add(element);
    }
    
    public void deleteAccount(int id) {
       //delete Account 
    }
    
    public AccountHolder getAccount(int id) {
        return accountsList.get(id);
    }
}
