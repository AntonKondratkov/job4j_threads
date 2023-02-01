package ru.job4j.concurrent;

public class ConsoleProgress {
    public static void main(String[] args) throws InterruptedException {
        char[] process = new char[]{'-', '\\', '|', '/'};
        Thread progress = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            for (char charVar : process) {
                                Thread.sleep(500);
                                System.out.print("\rLoading : " + charVar);
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        progress.start();
        Thread.sleep(5000);
        progress.interrupt();
    }
}