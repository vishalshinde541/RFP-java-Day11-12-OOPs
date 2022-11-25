package com.bridgelabz.StockAccountManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockAccount implements Account{
    static int totalPortfolioValue;
    float accountBalance;
    static ArrayList <Stock> StockList= new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);

    public void readStockFile(File file) throws IOException {
        Scanner scanner1=new Scanner(file);
        while (scanner1.hasNextLine()){
            Stock stock=new Stock();
            String[] ar=scanner1.nextLine().split(" ");
            stock.shareName=ar[0];
            stock.numberOfShares=Integer.parseInt(ar[1]);
            stock.sharePrice=Float.parseFloat(ar[2]);
            stock.stockValue=stock.sharePrice*stock.numberOfShares;
            StockList.add(stock);
        }
    }

    @Override
    public double valueOf() {
        totalPortfolioValue =0;
        for (Stock stock:StockList) {
            stock.stockValue=stock.sharePrice*stock.numberOfShares;
            totalPortfolioValue +=stock.stockValue;
        }
        return totalPortfolioValue;
    }

    @Override
    public void buy() {
        Stock stock=new Stock();
        System.out.print("Enter Share Name: ");
        stock.shareName=scanner.next();
        System.out.print("Enter Number of Shares: ");
        stock.numberOfShares=scanner.nextInt();
        System.out.println("Enter Share Price: ");
        stock.sharePrice=scanner.nextFloat();
        stock.stockValue=stock.numberOfShares*stock.sharePrice;
        StockList.add(stock);
    }

    @Override
    public void sell() {

    }

    @Override
    public void save(File file) throws IOException {
        FileWriter writer=new FileWriter(file);
        String data="";
        for (Stock stock:StockList) {
            data=(data+stock.shareName+" "+stock.numberOfShares+" "+stock.sharePrice+"\n");
        }
        writer.write(data);
        writer.close();
        System.out.println("Portfolio file saved successfully... \nPath: "+file.getAbsolutePath());
    }

    @Override
    public void printReport() {
        System.out.println("********************\nStock Report: ");
        System.out.println(StockList);
        System.out.println("Total Portfolio Value : "+valueOf());
    }

    @Override
    public void debit(float amount) {
        if (amount <= accountBalance) {
            accountBalance-=amount;
            System.out.println("amount debited: "+amount);
        }else {
            System.out.println("Debit amount exceeded account balance");
        }
        System.out.println("Available Account Balance = "+accountBalance);
    }
}