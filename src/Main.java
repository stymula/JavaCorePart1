import java.util.Scanner;

public class Main {

    public static void checkIfSortedAsc() {
        System.out.println("CheckIfSorted");
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean isSorted = true;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);
    }

    public static String reverseStringV1(String stringToReverse) {
        StringBuilder str = new StringBuilder((stringToReverse)).reverse();
        return str.toString();
    }

    public static String reverseStringV2(String stringToReverse) {
        StringBuilder str = new StringBuilder();
        for (int i = stringToReverse.length() - 1; i >= 0; i--) {
            str.append(stringToReverse.charAt(i));
        }
        return str.toString();
    }

    public static char[] reverseStringV3(String stringToReverse) {
        char[] charArr = new char[stringToReverse.length()];
        int i = 0, j = stringToReverse.length() - 1;
        while(j >= 0) {
            charArr[i] = stringToReverse.charAt(j);
            i++;
            j--;
        }
        return charArr;
    }

    public static char[] reverseStringV4(String stringToReverse) {
        char[] charArr = stringToReverse.toCharArray();
        for(int i = 0, j = charArr.length - 1; i < j; i++, j--) {
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }
        return charArr;
    }



    public static void main(String[] args) {
        System.out.println("Check if sorted ascending: ");
        checkIfSortedAsc();


        System.out.println("reverseString: ");
        System.out.println(reverseStringV1("I'm going to go to school today morning."));
        System.out.println(reverseStringV2("I'm going to go to school today morning."));
        System.out.println(reverseStringV3("I'm going to go to school today morning."));
        System.out.println(reverseStringV4("I'm going to go to school today morning."));


        System.out.println("Changing identities: ");
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "Szymon"; p1.age = 21;
        p2.name = "Piotr"; p2.age = 20;
        MakingChanges.changeIdentities(p1, p2);
        System.out.println("Szymon after changes: " + p1.name + " " + p1.age);
        System.out.println("Piotr after changes: " + p2.name + " " + p2.age);


        System.out.println("Account Service Implementation: ");
        User u1 = new User(1L, "User1", "USER1");
        User u2 = new User(2L, "User2", "USER2");

        Account[] accounts = new Account[]{
                new Account(10L, 1000L, u1),
                new Account(20L, 2000L, u2)
        };

        AccountService service = new AccountServiceImpl(accounts);
        Account a = service.findAccountByOwnerId(2L);
        if (a == null) {
            System.out.println("Account with that Owner id not found");
        } else {
            System.out.println("Account found: " + a.getId() + " " + a.getBalance());
        }

        long balance = 1500L;
        long count = service.countAccountsWithBalanceGreaterThan(balance);
        System.out.println("Number of accounts with balance greater than: " + balance + " is " + count);
    }
}