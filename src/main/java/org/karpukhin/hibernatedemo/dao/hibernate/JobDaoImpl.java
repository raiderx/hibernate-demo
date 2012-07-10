package org.karpukhin.hibernatedemo.dao.hibernate;

import org.hibernate.SessionFactory;
import org.karpukhin.hibernatedemo.dao.JobDao;
import org.karpukhin.hibernatedemo.model.Job;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public class JobDaoImpl extends AbstractDaoImpl implements JobDao {

    public JobDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void save(Job job) {
        getSession().saveOrUpdate(job);
        //getSession().flush();
    }

    @Override
    public Job getByName(String name) {
        return (Job)getSession().get(Job.class, name);
    }

    @Override
    public List<Job> getJobs() {
        return getSession().getNamedQuery("getJobs").list();
    }
}
