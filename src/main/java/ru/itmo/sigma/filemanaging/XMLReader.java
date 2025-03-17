package ru.itmo.sigma.filemanaging;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import ru.itmo.sigma.data.Worker;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;


/**
 * The type Xml reader.
 */
public class XMLReader {
    /**
     * Read workers from xml tree set.
     *
     * @param filePath the file path
     * @return the tree set
     */
    public static TreeSet<Worker> readWorkersFromXML(String filePath) {
        XStream xstream = new XStream(new DomDriver());

        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("worker", Worker.class);
        xstream.alias("workers", TreeSet.class);

        try (FileReader reader = new FileReader(new File(filePath))) {

            return (TreeSet<Worker>) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new TreeSet<>();
        }
    }
}

