package org.karpukhin.hibernatedemo.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Pavel Karpukhin
 */
public class AbstractDaoImpl {

    private SessionFactory sessionFactory;

    public AbstractDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
