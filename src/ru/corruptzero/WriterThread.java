package ru.corruptzero;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriterThread extends Thread {
    private final Scanner scanner = new Scanner(System.in);
    private final CommonResource res;

    public WriterThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            write();
        }
    }

    private void write() {
        synchronized (res) {
            try (FileWriter writer = new FileWriter("notes3.txt", true)) {
                while (!res.getStr().isBlank()) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("Что записать?: ");
                res.setStr(scanner.nextLine());
                writer.write(res.getStr());
                writer.append('\n');
                writer.flush();
                res.notify();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
