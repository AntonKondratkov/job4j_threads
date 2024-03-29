package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Predicate;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public final class ParseFile {

    @GuardedBy("this")
    private final File file;

    public ParseFile(File file) {
        this.file = file;
    }

    public synchronized String getContent(Predicate<Character> filter) {
        String output = "";
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) > 0) {
                if (filter.test((char) data)) {
                    output += (char) data;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return output;
    }
}
