package org.karpukhin.hibernatedemo.dao;

import org.karpukhin.hibernatedemo.model.Job;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface JobDao {

    /**
     * Saves given job
     * @param job job date
     */
    void save(Job job);

    /**
     * Returns job found by given name
     * @param name unique name of job
     * @return job
     */
    Job getByName(String name);

    /**
     * Returns all jobs
     * @return all jobs
     */
    List<Job> getJobs();
}
