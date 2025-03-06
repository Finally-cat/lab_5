package ru.itmo.sigma.data;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;
import java.util.NoSuchElementException;


public class WorkerTreeSet {
    private TreeSet<Worker> wTree = new TreeSet<>();

    public void add(Worker worker) {
        wTree.add(worker);
    }

    public void treeToString() {
        wTree.forEach(System.out::println);
    }

    public void clear() {
        wTree.clear();
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
    public void treeToXml(OutputStream outputStream) {
        XStream xstream = new XStream();
        xstream.alias("worker", Worker.class);
        xstream.alias("workers", WorkerTreeSet.class);

        try (OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            xstream.toXML(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TreeSet<Worker> getWTree() {
        return wTree;
    }

    public void setWTree(TreeSet<Worker> wTree) {
    }


    public Worker findById(long id) {
        return wTree.stream()
                .filter(worker -> worker.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Worker with id " + id + " not found"));
    }

    public void removeAllBySalary(double salary) {
        wTree.removeIf(worker -> worker.getSalary() == salary);
    }
}
