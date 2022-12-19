package banking;

public class Account {
    private static final int MAX_LENGTH = 12;
    private String name;
    private String ag;
    private String cc;
    private double balance;
    private Log logger = new Log();


    public Account(String name, String ag, String cc) {
        setName(name);
        this.ag = ag;
        this.cc = cc;
    }

    public void setName(String name){
        if(name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        }else {
            this.name = name;
        }
    }

    public void deposit(double value){
        balance += value;
        logger.out("Depósito de R$ " + value + " Seu saldo é de R$ " + balance);
    }

    public boolean withDraw(double value){
        if (value > balance){
            logger.out("Saldo insuficiente para saque!, Seu saldo é de R$ " + balance);
            return false;
        }else {
            balance -= value;
            logger.out("Saque de R$ " + value + " Saldo: R$ " + balance);
            return true;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "Nome:'" + name + '\'' +
                ", agência:'" + ag + '\'' +
                ", conta:'" + cc + '\'' +
                ", saldo:R$" + balance +
                '}';
    }
}
