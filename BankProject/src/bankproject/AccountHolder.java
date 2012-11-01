/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

/**
 *
 * @author s504
 */
public class AccountHolder implements AccountInterface {
    
    public String name = "";
    public double ballance = 0.0;
    // add more options here
    
    public AccountHolder() {
        
    }
    
    public void accountStatus(){
        //return account status - money
    }
    
    public void deposit(double amount){
        this.ballance += amount;
        Vault.getInstance().interfereWithVault(amount, '+');
    }
    
    public void withdraw(double amount){
        Vault.getInstance().interfereWithVault(amount, '-');
    }
    
}
