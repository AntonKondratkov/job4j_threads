package ru.job4j.DCLSingleton;

public final class DCLSingleton {
    /*
     * Ошибка возникает из-за несогласованности кеша и регистра процессора.
     * Поэтому необходимо добавить ключевое слово volatile при обявлении переменной instance,
     * чтобы значение данной переменной записывалось только в регистр процессора и считывалось из него.
     * Таким образом достигается синхронизация операций чтения и записи значения переменной двумя и более потоками.
     */
    private static volatile DCLSingleton instance;

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    private DCLSingleton() {
    }
}
