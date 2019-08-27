class Account
{
    String name;
     protected double balance;

     Account (String str , double amt)
     {
         name = str;
         balance = amt;
     }
     String getName()
     {
         return name;
     }
     double getBalance()
     {
         return balance;
     }

     void deposit(double amt)
     {
         balance += amt;
         System.out.println("Depositing : "+amt);
     }

     void withdraw(double amt)
     {
         balance -= amt;
         System.out.println("withdraw:" + amt);
     }    
}

class SavingAccount extends Account{
    double interestRate;

    SavingAccount(String str , double amt , double rate)
    {
        super(str,amt);
        interestRate = rate;
    }

}

class CheckingAccount extends Account
{
    double overDraft;

    CheckingAccount(String str , double amt)
    {
        super(str,amt);
    }
    CheckingAccount(String str , double amt , double draft)
    {
        super(str,amt);
        overDraft = draft;
    }

    void withdraw(double amt)
    {
        System.out.println("Overdraft Amount:" + overDraft);

        if(amt <= balance)
        {
            System.out.println("Withdrawing:"+amt);
        }
        else
        if((amt>balance) && (amt > (balance + overDraft))){
            System.out.println("Sorry! You cannot withdraw");
        }
        else{
            double result = amt - balance;
            overDraft -= result;
            balance = 0;

            System.out.println("Withdrawing:"+ amt);
            System.out.println("Current Overdraft Amount:" + overDraft);

        }
    }
}

class AccountTest
{
    public static void main(String[] args)
    {
        SavingAccount sAob = new SavingAccount("John",500,4);
        System.out.println("\n Savings Account Details");
        System.out.println("-----------------------------");
        System.out.println(""+sAob.getName() + "has an initial balance of :"+sAob.getBalance());
        sAob.deposit(200);
        sAob.withdraw(200);
        System.out.println(""+ sAob.getName() + "at the end of transaction has balance of:"+sAob.getBalance());

        System.out.println("\n Checking Account Details:");
        System.out.println("------------------------------");
        CheckingAccount cAob = new CheckingAccount("Stephan",200,200);
        System.out.println(""+cAob.getName()+ "has Initial balance of :"+cAob.getBalance());
        cAob.deposit(200);
        cAob.withdraw(500);
        System.out.println("" + cAob.getName() + "has the Balance after the last transaction is:"+cAob.getBalance());
    }
}