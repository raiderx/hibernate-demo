package org.karpukhin.hibernatedemo.model;

import org.joda.time.DateTime;

/**
 * @author Pavel Karpukhin
 */
public class Job {

    private String name;
    private DateTime started;
    private DateTime finished;
    private JobState state;

    /**
     * Default constructor
     */
    public Job() {
    }

    public Job(String name, DateTime started, DateTime finished, JobState state) {
        this.name = name;
        this.started = started;
        this.finished = finished;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getStarted() {
        return started;
    }

    public void setStarted(DateTime started) {
        this.started = started;
    }

    public DateTime getFinished() {
        return finished;
    }

    public void setFinished(DateTime finished) {
        this.finished = finished;
    }

    public JobState getState() {
        return state;
    }

    public void setState(JobState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Job job = (Job) other;
        return name != null ? name.equals(job.name) : job.name == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }
}
