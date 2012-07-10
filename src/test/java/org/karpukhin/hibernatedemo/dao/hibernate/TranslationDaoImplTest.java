package org.karpukhin.hibernatedemo.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.karpukhin.hibernatedemo.dao.TranslationDao;
import org.karpukhin.hibernatedemo.model.Translation;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Karpukhin
 */
public class TranslationDaoImplTest {

    private static SessionFactory sessionFactory;

    private Transaction transaction;

    private TranslationDao translationDao;
    private Translation predefinedTranslation;

    @BeforeClass
    public static void testSetUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Before
    public void setUp() {
        translationDao = new TranslationDaoImpl(sessionFactory);

        sessionFactory.openSession();
        transaction = sessionFactory.getCurrentSession().beginTransaction();

        predefinedTranslation = new Translation("some.code", "some text");
        translationDao.save(predefinedTranslation);
        sessionFactory.getCurrentSession().evict(predefinedTranslation);
    }

    @After
    public void tearDown() {
        transaction.rollback();
        sessionFactory.getCurrentSession().close();
    }

    @Test
    public void saveTest() {
        Translation translation = new Translation("new.code", "new.text");
        translationDao.save(translation);
    }

    @Test
    public void getByCodeTest() {
        Translation result = translationDao.getByCode("some.code");
        assertEquals(predefinedTranslation, result);
    }
}
