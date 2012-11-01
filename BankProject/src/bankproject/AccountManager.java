/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

/**
 *
 * @author s504
 */
public class AccountManager {
    
    private Accounts accountsHolder = new Accounts();
   
    
    
    public void newAccount(AccountHolder element) {
       this.accountsHolder.newAccount(element);
    }
    
    public void deleteAccount(int id) {
        this.accountsHolder.deleteAccount(id);
    }
    
    public AccountHolder getAccount(int id) {
        return this.accountsHolder.getAccount(id);
    }
}
