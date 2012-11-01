/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

public class Vault {
  private static double bankVault = 0.0;
  // Private constructor prevents instantiation from other classes
  private Vault() {}
 
  /**
   * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
   * or the first access to SingletonHolder.INSTANCE, not before.
   */
  private static class VaultHolder { 
    private static final Vault INSTANCE = new Vault();
  }

  public static Vault getInstance() {
    return VaultHolder.INSTANCE;
  }
  
  /**
     * Function ton interfereWithVault
     * @param valueToInterfere double
     * @param operation  double
     */
    public static void interfereWithVault(double valueToInterfere, char operation) {
        switch (operation) {
            case '+':  
                    bankVault += valueToInterfere;
                     break;
            case '-':  
                    bankVault -= valueToInterfere;
                     break;
        }
    }
    
    /**
     * Return the bank Vault
     * @return bankVault double 
     */
    public static double showVault() {
        return bankVault;
    }
}
