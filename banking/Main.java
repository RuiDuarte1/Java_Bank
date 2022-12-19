package banking;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank inter = new Bank("0001");
        while (true){
            System.out.println("----Banco Inter----\n" +
                    "C = Criar Conta\n" +
                    "E = Sair");
            String op = scanner.nextLine();

            if (op.equals("C")){
                System.out.println("Digite seu nome: ");
                String name = scanner.nextLine();
                Account account = inter.generateAccount(name);
                inter.insertAccount(account);
                System.out.println(account);

                operateAccount(account);

            } else if (op.equals("E")) {
                break;
            }else {
                System.out.println("Comando inválido! Tente novamente");
            }
        }

        List<Account> accountList = inter.getAccounts();
        for (Account cc: accountList){
            System.out.println(cc);
        }

    }
    static void operateAccount(Account account){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("O que desejas fazer?\n" +
                    "D = Depósito\n" +
                    "S = Saque\n" +
                    "E = Sair\n");
            String op = scanner.nextLine();

            if (op.equals("D")){
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                account.withDraw(value);
            } else if (op.equals("E")) {
                break;
            }else {
                System.out.println("Comando inválido, tente novamente");
            }

            scanner = new Scanner(System.in);
        }
    }
}
