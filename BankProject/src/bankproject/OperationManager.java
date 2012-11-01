/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;


/**
 *
 * @author elegance
 */
public class OperationManager {
    
    
    public void checkBallance(AccountHolder account) {
        account.accountStatus();
    }
    
    public void deposit(AccountHolder account, double amount) {
        account.deposit(amount);
    }
    
    public void withdraw(AccountHolder account, double amount) {
        account.withdraw(amount);
    }
}
