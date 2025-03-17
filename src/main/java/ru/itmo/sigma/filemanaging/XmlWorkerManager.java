package ru.itmo.sigma.filemanaging;

import ru.itmo.sigma.data.Worker;

import javax.xml.bind.*;
import java.io.File;
import java.util.TreeSet;

/**
 * The type Xml worker manager.
 */
public class XmlWorkerManager {
    private final String filePath;

    /**
     * Instantiates a new Xml worker manager.
     *
     * @param filePath the file path
     */
    public XmlWorkerManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Save.
     *
     * @param workers the workers
     */
    public void save(TreeSet<Worker> workers) {
        try {
            JAXBContext context = JAXBContext.newInstance(WorkersWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            WorkersWrapper wrapper = new WorkersWrapper();
            wrapper.setWorkers(workers);

            marshaller.marshal(wrapper, new File(filePath));
            System.out.println("Коллекция сохранена в файл: " + filePath);
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    /**
     * Load tree set.
     *
     * @return the tree set
     */
    public TreeSet<Worker> load() {
        try {
            File file = new File(filePath);
            if (!file.exists() || file.length() == 0) {
                System.out.println("Файл не найден или пуст, возвращена новая коллекция.");
                return new TreeSet<>();
            }

            JAXBContext context = JAXBContext.newInstance(WorkersWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            WorkersWrapper wrapper = (WorkersWrapper) unmarshaller.unmarshal(file);

            return new TreeSet<>(wrapper.getWorkers());
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке: " + e.getMessage());
            return new TreeSet<>();
        }
    }
}

