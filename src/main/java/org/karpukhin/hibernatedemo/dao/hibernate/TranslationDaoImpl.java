package org.karpukhin.hibernatedemo.dao.hibernate;

import org.hibernate.SessionFactory;
import org.karpukhin.hibernatedemo.dao.TranslationDao;
import org.karpukhin.hibernatedemo.model.Translation;

/**
 * @author Pavel Karpukhin
 */
public class TranslationDaoImpl extends AbstractDaoImpl implements TranslationDao {

    public TranslationDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void save(Translation translation) {
        getSession().save(translation);
        getSession().flush();
    }

    @Override
    public Translation getByCode(String code) {
        return (Translation)getSession().get(Translation.class, code);
    }
}
