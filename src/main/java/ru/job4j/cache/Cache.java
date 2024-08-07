package ru.job4j.cache;
/**
 * Класс показывает один из способов синхронизации метода
 * @author Anton Kondratkov
 * @since 06.05.2024
 */
public final class Cache {
    private static Cache cache;

    public synchronized static Cache getInstance() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
