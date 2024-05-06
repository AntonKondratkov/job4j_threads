package ru.job4j.threads;
/**
 * Класс показывает один из способов синхронизации метода.
 * @author Anton Kondratkov
 * @since 06.05.2024
 */
public final class Cache {
    private static Cache cache;

    public static Cache getInstance() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
