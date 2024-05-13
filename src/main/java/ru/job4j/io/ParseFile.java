package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Predicate;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Поправьте код с ошибками в коде.
 * - Избавиться от get set за счет передачи File в конструктор.
 * - Ошибки в многопоточности. Сделать класс Immutable. Все поля final.
 * - Ошибки в IO. Не закрытые ресурсы. Чтение и запись файла без буфера.
 * - Нарушен принцип единой ответственности. Тут нужно сделать два класса.
 * - Методы getContent написаны в стиле копипаста. Нужно применить шаблон стратегия. content(Predicate<Character> filter)
 */
@ThreadSafe
public final class ParseFile {

    @GuardedBy("this")
    private final File file;

    public ParseFile(File file) {
        this.file = file;
    }

    public String getContent() {
        return getContentWithPredicate(data -> true);
    }

    public String getContentWithoutUnicode() {
        return getContentWithPredicate(data -> data < 0x80);
    }

    private synchronized String getContentWithPredicate(Predicate<Character> filter) {
        StringBuilder output = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (filter.test((char) data)) {
                    output.append((char) data);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return output.toString();
    }
}
