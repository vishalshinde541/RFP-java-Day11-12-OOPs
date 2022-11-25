package com.bridgelabz.StockAccountManagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Account account=new StockAccount();
        Scanner scanner=new Scanner(System.in);
        String projectDirectory=System.getProperty("user.dir");
        File file=new File(projectDirectory+"/StockPortfolioFile.txt");
        account.readStockFile(file);
        account.printReport();

        boolean isRunning=true;
        while (isRunning){
            System.out.println("*************************\nSelect Option: \n1.Show total Portfolio value \n2.buy share \n3.sell share \n4.Print Report \n5.Exit");
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Total Portfolio Value: "+account.valueOf());
                    break;
                case 2:
                    account.buy();
                    break;
                case 3:
                    account.sell();
                    break;
                case 4:
                    account.printReport();
                    break;
                case 5:
                    account.save(file);
                    isRunning=false;
                    break;
                default:
                    System.out.println("Select valid option");
            }
        }

    }
}