package org.karpukhin.hibernatedemo.dao;

import org.karpukhin.hibernatedemo.model.Translation;

/**
 * @author Pavel Karpukhin
 */
public interface TranslationDao {

    /**
     * Saves given translation
     * @param translation translation data
     */
    void save(Translation translation);

    /**
     * Returns translation found by given code
     * @param code unique translation code
     * @return translation
     */
    Translation getByCode(String code);
}
