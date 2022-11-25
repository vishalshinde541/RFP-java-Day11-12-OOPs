package com.bridgelabz.StockAccountManagement;

import java.io.File;
import java.io.IOException;

public interface Account {
    void readStockFile(File file) throws IOException;
    double valueOf();
    void buy();
    void sell();
    void save(File file) throws IOException;
    void printReport();
    void debit(float amount);
}