package repository;

import base.Base;
import models.Account;
import models.User;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class AccountRepository implements Serializable {
    //private HashMap<String , Account> accounts;

    public AccountRepository()
    {
        //prepareAccounts();
    }

    public void prepareAccounts() {
//        accounts = new HashMap<>();
//        List<User> users = Arrays.asList(
//                new User("anna", "111", "123"),
//                new User("bob", "222", "123"),
//                new User("omar", "333", "123"),
//                new User("ahmad", "111", "123"),
//                new User("abanoub", "222", "123"),
//                new User("Sherif", "333", "123"));
//        List<Account> accountList = Arrays.asList(
//                new Account("Saving", "111", users.get(0)),
//                new Account("Saving", "222", users.get(1)),
//                new Account("Saving", "333", users.get(2)),
//                new Account("Checking", "444", users.get(3)),
//                new Account("Checking", "555", users.get(4)),
//                new Account("Checking", "666", users.get(5)));
//
//        for (Account account : accountList) {
//            accounts.put(account.getAccountNumber(), account);
//        }
    }

    public Account FindAccount(String accountNumber){
        return Base.accounts.get(accountNumber);
    }

    public Account findAccountByUser(String userName){

        Account account = Base.accounts.values().stream()
                .filter(acc-> acc.getCustomer().getUserName().equals(userName))
                .findFirst()
                .orElse(null);

        return account;
    }



    public void addAccount(Account account){
        Base.accounts.put(account.getAccountNumber(),account);
    }

    public HashMap<String, Account> getAllAccounts() {
        return Base.accounts;
    }

    public String createAccount(Account account) {
        if (Base.accounts.containsKey(account.getAccountNumber())) {
            return "Account already exist";
        }
        else {
            Base.accounts.put(account.getAccountNumber(), account);
            return "Account saved successfully.";
        }

    }

    public boolean updateAccount(Account account) {
        Base.accounts.put(account.getAccountNumber(), account);
        return true;
    }


}

