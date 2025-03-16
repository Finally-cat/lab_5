package ru.itmo.sigma.filemanaging;

import ru.itmo.sigma.data.Worker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
import java.util.TreeSet;


/**
 * The type Workers wrapper.
 */
@XmlRootElement(name = "workers")
public class WorkersWrapper {
    private Set<Worker> workers = new TreeSet<>();

    /**
     * Gets workers.
     *
     * @return the workers
     */
    @XmlElement(name = "worker")
    public Set<Worker> getWorkers() {
        return workers;
    }

    /**
     * Sets workers.
     *
     * @param workers the workers
     */
    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}

