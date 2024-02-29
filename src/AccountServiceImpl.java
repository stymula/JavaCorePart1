interface AccountService { // It's a good and standart practice to have one class and one interface in it's own files.
    /**
     * It finds an account by owner id        // JavaDoc - I like it, good stuff!
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);    // Good and meaningful names, please keep it up! :)
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here 
class AccountServiceImpl implements AccountService {
    private Account[] accounts;

    AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        // this is good, also you can use lambdas and Stream API, and accounts should be List<?> accounts = new ArryaList<>(); to make StreamAPI work.
        // then you code would looks like 
        // return accounts.stream()        
        //                .filter(a -> a.getOwner().getId() == id)
        //                .collect(Collectors.toList()); 
        for(var account : accounts) {
            if(account.getOwner().getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {        
        int count = 0;
        for(var account : accounts) {
            if (account.getBalance() > value) {
                count++;
            }
        }
        return count;
    }
}

class Account {  // It's a good and standart practice to have one class and one interface in it's own files. In this case I'd say it should be the class Account in model package.

    private long id;      // Thumbs up for good incapsulation
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

// You can use Lombok library. Actualy Lombok it's small island near by Java island in Indonesia )
// It's a great timesaver, especially for big models.
// So your class would looks like 
/* 
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
class User {
    private long id;
    private String firstName;
    private String lastName;
}

// These Lombok annotations I'm using very often
// @Setter, @Data, @Builder, @Accessors(chain = true), @SneakyThrows
*/

class User {  // It's a good and standart practice to have one class and one interface in it's own files. In this case I'd say it should be the class User in model package.

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
