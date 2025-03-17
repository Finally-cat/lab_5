package ru.itmo.sigma.data;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.filemanaging.XmlWorkerManager;

import java.time.LocalDate;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class WorkerTreeSet {
    private final TreeSet<Worker> workers;
    private final XmlWorkerManager xmlManager;

    public WorkerTreeSet(String filePath) {
        this.xmlManager = new XmlWorkerManager(filePath);
        this.workers = xmlManager.load();
    }

    public void save() {
        xmlManager.save(workers); // Используем workers, а не wTree
    }

    public void load() {
        workers.clear();
        workers.addAll(xmlManager.load());
    }

    public void add(Worker worker) {
        workers.add(worker); // Записываем в workers, а не wTree
    }

    public void printAllWorkers() {
        workers.forEach(System.out::println);
    }

    public void clear() {
        workers.clear();
    }

    public boolean isEmpty() {
        return workers.isEmpty();
    }

    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(workers);
    }

    public String removeId(long id) {
        if (workers.removeIf(worker -> worker.getId() == id)) {
            return "id " + id + " был удалён";
        } else {
            return "id " + id + " не найден";
        }
    }

    public Worker findById(long id) {
        return workers.stream()
                .filter(worker -> worker.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Worker с id " + id + " не найден"));
    }

    public void removeAllBySalary(double salary) {
        workers.removeIf(worker -> worker.getSalary() == salary);
    }

    public String removeByStartDate(LocalDate startDate) {
        if (workers.removeIf(worker -> worker.getStartDate().equals(startDate))) {
            return "Worker с датой начала " + startDate + " удалён";
        } else {
            return "Worker с датой начала " + startDate + " не найден";
        }
    }

    public Worker getMinWorker() {
        return workers.stream()
                .min(Worker::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста, минимальный Worker отсутствует"));
    }
}
