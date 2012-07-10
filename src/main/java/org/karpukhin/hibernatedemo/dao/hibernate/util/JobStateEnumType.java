package org.karpukhin.hibernatedemo.dao.hibernate.util;

import org.karpukhin.hibernatedemo.model.JobState;

/**
 * @author Pavel Karpukhin
 */
public class JobStateEnumType extends EnumUserType<JobState> {

    public JobStateEnumType() {
        super(JobState.class);
    }
}
