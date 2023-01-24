package ru.job4j.concurrent;

public class ConsoleProgress {
    public static void main(String[] args) throws InterruptedException {
        char[] process = new char[]{'-', '\\', '|', '/'};
        Thread progress = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            for (int i = 0; i < process.length; i++) {
                                Thread.sleep(500);
                                System.out.print("\rLoading : " + process[i]);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        progress.start();
        Thread.sleep(5000);
        progress.interrupt();
    }
}
