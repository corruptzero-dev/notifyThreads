package ru.corruptzero;


public class ReaderThread extends Thread {
    private final CommonResource res;

    public ReaderThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            read();
        }
    }

    private void read() {
        synchronized (res) {
            while (res.getStr().isBlank()) {
                try {
                    res.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Записано: " + res.getStr());
            res.setStr("");
            System.out.println("___________");
            res.notify();
        }
    }
}
