import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.Gold;
import com.pluralsight.finance.Portfolio;
import com.pluralsight.finance.Valuable;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam","123", 12500);
        Valuable account2 = new BankAccount("Gary","456", 1500);
        // try to deposit money into both accounts
        account1.deposit(100);
        
        // It can work if you downcast it
        ((BankAccount) account2).deposit(100);

        // Make assets
        Gold necklace = new Gold("Box chain", 400, 400);
        BankAccount account = new BankAccount("Emily","123", 2500);


        Portfolio portfolio = new Portfolio("My portfolio", "Emily");
        portfolio.addAsset(account);
        portfolio.addAsset(necklace);

        System.out.println("Total value : "+portfolio.getValue());
        System.out.println("Most valuable : "+portfolio.getMostValuable());
        System.out.println("Least valuable : "+portfolio.getLeastValuable());
    }
}
