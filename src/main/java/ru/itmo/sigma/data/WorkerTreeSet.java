package ru.itmo.sigma.data;

import com.thoughtworks.xstream.XStream;
import ru.itmo.sigma.filemanaging.XmlWorkerManager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.NoSuchElementException;


public class WorkerTreeSet {
    private TreeSet<Worker> wTree = new TreeSet<>();
    private final TreeSet<Worker> workers;
    private final XmlWorkerManager xmlManager;

    public WorkerTreeSet(String filePath) {
        this.xmlManager = new XmlWorkerManager(filePath);
        this.workers = xmlManager.load();
    }

    public void save() {
        xmlManager.save(workers);
    }

    public void load() {
        workers.clear(); // Очищаем текущую коллекцию
        workers.addAll(xmlManager.load()); // Загружаем из файла
    }

    public void add(Worker worker) {
        wTree.add(worker);
    }

    public void treeToString() {
        wTree.forEach(System.out::println);
    }

    public void clear() {
        wTree.clear();
    }

    public boolean isEmpty() {
        return workers.isEmpty();
    }

    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(workers);
    }

    public String removeId(long id) {
        if (wTree.removeIf(worker -> worker.getId() == id)) {
            return "id " + id + " was removed";
        } else {
            return "id " + id + " was not found";
        }
    }

    //    public void treeToXml() {
//        XStream xstream = new XStream();
//        xstream.alias("worker", Worker.class);
//        xstream.alias("workers", WorkerTreeSet.class);
//        String xml = xstream.toXML(this);
//        System.out.println(xml);
//
//    }

    public Worker findById(long id) {
        return wTree.stream()
                .filter(worker -> worker.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Worker with id " + id + " not found"));
    }

    public void removeAllBySalary(double salary) {
        wTree.removeIf(worker -> worker.getSalary() == salary);
    }

    public String removeByStartDate(LocalDate startDate) {
       if (wTree.removeIf(worker -> worker.getStartDate().equals(startDate))) {
           return "Worker with start date " + startDate + " was removed";
       } else {
           return "Worker with start date " + startDate + " was not found";
       }
    }

}
