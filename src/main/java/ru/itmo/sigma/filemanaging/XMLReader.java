package ru.itmo.sigma.filemanaging;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import ru.itmo.sigma.data.Worker;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;


public class XMLReader {
    public static TreeSet<Worker> readWorkersFromXML(String filePath) {
        XStream xstream = new XStream(new DomDriver());

        // Разрешаем XStream работать с любыми классами
        xstream.addPermission(AnyTypePermission.ANY);

        // Настраиваем алиасы для удобного XML
        xstream.alias("worker", Worker.class);
        xstream.alias("workers", TreeSet.class);

        try (FileReader reader = new FileReader(new File(filePath))) {
            // Десериализация XML в TreeSet
            return (TreeSet<Worker>) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new TreeSet<>(); // Возвращаем пустой TreeSet в случае ошибки
        }
    }
}

