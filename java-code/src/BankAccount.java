import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a simple bank account domain object.
 * <p>
 * Stub-only: declarations and Javadoc; no implementations.
 */
public class BankAccount {
    private String accountName;
    private String accountNumber;
    private BigDecimal balance;
    private BigDecimal minimumBalance;
    private final List<String> transactions;
    /**
     * Constructs a new account.
     *
     * @param accountName   human-readable name for the account owner
     * @param accountNumber unique account identifier
     * @param openingBalance initial balance; non-negative
     */
    public BankAccount(String accountName, String accountNumber, BigDecimal openingBalance) {
        if (accountName == null || accountName.isBlank()) {
            throw new IllegalArgumentException("Account name cannot be null or blank.");
        }
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or blank.");
        }
        if (openingBalance == null || openingBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Opening balance must be non-negative.");
        }

        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.minimumBalance = BigDecimal.ZERO; // default threshold
        this.transactions = new ArrayList<>();
        this.transactions.add("Account opened with balance: " + openingBalance);

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", minimumBalance=" + minimumBalance +
                ", transactions=" + transactions +
                '}';
    }

    /**
     * Returns an immutable snapshot of core account details.
     *
     * @return details record containing name, number, balance, and transaction count
     */
    public Details getDetails() { return null; }

    /**
     * Transfers funds to another {@code BankAccount}.
     *
     * @param destination the receiving account
     * @param amount      amount to transfer; must be positive and not exceed available funds
     */
    public void transferTo(BankAccount destination, BigDecimal amount) { }

    /**
     * Transfers funds to an external account by account number.
     * Implementations may delegate to a payment network or repository layer.
     *
     * @param destinationAccountNumber target account number
     * @param amount                   amount to transfer; must be positive and not exceed available funds
     */
    public void transferTo(String destinationAccountNumber, BigDecimal amount) { }

    /**
     * Pays one or more bills encoded as strings (e.g., {@code "ABC_Company - 123.45"}).
     * Each entry should include a payee label and a decimal amount.
     *
     * @param billEntries list of bill strings to pay in a single batch
     */
    public void payBills(List<String> billEntries) { }

    /**
     * Returns a read-only view of transaction descriptions.
     * The format and level of detail are implementation-defined.
     *
     * @return ordered list of transaction strings, newest first
     */
    public List<String> listTransactions() { return null; }

    /**
     * Sets a minimum balance constraint used by validation or alerts.
     *
     * @param minimumBalance non-negative threshold; {@code null} clears the constraint
     */
    public void setMinimumBalance(BigDecimal minimumBalance) { }

    /**
     * Gets the configured minimum balance threshold.
     *
     * @return current minimum balance or {@code null} if not set
     */
    public BigDecimal getMinimumBalance() { return null; }

    /**
     * Changes the human-readable account name.
     *
     * @param newName new display name; non-empty
     */
    public void setAccountName(String newName) { }

    /**
     * Returns the human-readable account name.
     *
     * @return current account name
     */
    public String getAccountName() { return null; }

    /**
     * Returns the unique account number.
     *
     * @return account number string
     */
    public String getAccountNumber() { return null; }

    /**
     * Returns the current ledger balance.
     *
     * @return monetary balance
     */
    public BigDecimal getBalance() { return null; }


    public static final class Details {
        public final String accountName;
        public final String accountNumber;
        public final BigDecimal balance;
        public final int transactionCount;

        /**
         * Lightweight immutable details carrier.
         *
         * @param accountName     display name
         * @param accountNumber   identifier
         * @param balance         current balance
         * @param transactionCount number of stored transactions
         */
        public Details(String accountName, String accountNumber, BigDecimal balance, int transactionCount) {
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.transactionCount = transactionCount;
        }
    }
}
