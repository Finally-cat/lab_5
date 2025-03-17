package ru.itmo.sigma.data;

import ru.itmo.sigma.filemanaging.XmlWorkerManager;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.NoSuchElementException;


/**
 * The type Worker tree set.
 */
public class WorkerTreeSet {
    private TreeSet<Worker> wTree = new TreeSet<>();
    private final TreeSet<Worker> workers;
    private final XmlWorkerManager xmlManager;

    /**
     * Instantiates a new Worker tree set.
     *
     * @param filePath the file path
     */
    public WorkerTreeSet(String filePath) {
        this.xmlManager = new XmlWorkerManager(filePath);
        this.workers = xmlManager.load();
    }

    /**
     * Save.
     */
    public void save() {
        xmlManager.save(workers);
    }

    /**
     * Load.
     */
    public void load() {
        workers.clear();
        workers.addAll(xmlManager.load());
    }

    /**
     * Add.
     *
     * @param worker the worker
     */
    public void add(Worker worker) {
        wTree.add(worker);
    }

    /**
     * Print all workers.
     */
    public void printAllWorkers() {
        wTree.forEach(wTree -> System.out.println(wTree.toString()));
    }

    /**
     * Clear.
     */
    public void clear() {
        wTree.clear();
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return workers.isEmpty();
    }

    /**
     * Gets workers.
     *
     * @return the workers
     */
    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(wTree);
    }

    /**
     * Remove id string.
     *
     * @param id the id
     * @return the string
     */
    public String removeId(long id) {
        if (wTree.removeIf(worker -> worker.getId() == id)) {
            return "id " + id + " was removed";
        } else {
            return "id " + id + " was not found";
        }
    }


    /**
     * Find by id worker.
     *
     * @param id the id
     * @return the worker
     */
    public Worker findById(long id) {
        return wTree.stream()
                .filter(worker -> worker.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Worker with id " + id + " not found"));
    }

    /**
     * Remove all by salary.
     *
     * @param salary the salary
     * @return
     */
    public int removeAllBySalary(double salary) {
        wTree.removeIf(worker -> worker.getSalary() == salary);
        return 0;
    }

    /**
     * Remove by start date string.
     *
     * @param startDate the start date
     * @return the string
     */
    public String removeByStartDate(LocalDate startDate) {
       if (wTree.removeIf(worker -> worker.getStartDate().equals(startDate))) {
           return "Worker with start date " + startDate + " was removed";
       } else {
           return "Worker with start date " + startDate + " was not found";
       }
    }

    /**
     * Gets min worker.
     *
     * @return the min worker
     */
    public Worker getMinWorker() {
        return wTree.stream()
                .min(Worker::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста, минимальный Worker отсутствует"));
    }
}
