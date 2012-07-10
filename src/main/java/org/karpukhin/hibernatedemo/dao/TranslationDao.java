package org.karpukhin.hibernatedemo.dao;

import org.karpukhin.hibernatedemo.model.Translation;

/**
 * @author Pavel Karpukhin
 */
public interface TranslationDao {

    void save(Translation translation);

    Translation getByCode(String code);
}
