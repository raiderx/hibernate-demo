package org.karpukhin.hibernatedemo.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.karpukhin.hibernatedemo.dao.JobDao;
import org.karpukhin.hibernatedemo.model.Job;
import org.karpukhin.hibernatedemo.model.JobState;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Karpukhin
 */
public class JobDaoImplTest {

    private static final String JOB_NAME = "Some job";

    private static SessionFactory sessionFactory;

    private Transaction transaction;

    private JobDao jobDao;
    private Job predefinedJob;

    @BeforeClass
    public static void testSetUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Before
    public void setUp() {
        jobDao = new JobDaoImpl(sessionFactory);

        sessionFactory.openSession();
        transaction = sessionFactory.getCurrentSession().beginTransaction();

        predefinedJob = new Job(JOB_NAME, new DateTime(), new DateTime(), JobState.STARTED);
        jobDao.save(predefinedJob);
    }

    @After
    public void tearDown() {
        transaction.rollback();
        sessionFactory.getCurrentSession().close();
    }

    @Test
    public void testSave() {
        Job job = new Job("New job", new DateTime(), new DateTime(), JobState.STARTED);
        jobDao.save(job);
    }

    @Test
    public void testGetByName() {
        Job result = jobDao.getByName(JOB_NAME);
        assertEquals(predefinedJob, result);
    }

    @Test
    public void testGetJobs() {
        List<Job> result = jobDao.getJobs();
        assertEquals(1, result.size());
    }

}
