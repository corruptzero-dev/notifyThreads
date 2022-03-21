package ru.corruptzero;

public class Main {
    /* TODO
        Сделать запись в файл всего, что приходит в консоль.
        Запись в файл в одном потоке, чтение из консоли в другом.
        Использовать wait и notify!!!
     */
    public static void main(String[] args) {
        WriterThread writerThread = new WriterThread(CommonResource.getInstance());
        ReaderThread readerThread = new ReaderThread(CommonResource.getInstance());
        writerThread.start();
        readerThread.start();
    }
}