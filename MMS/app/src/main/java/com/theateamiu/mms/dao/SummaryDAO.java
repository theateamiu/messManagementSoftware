package com.theateamiu.mms.dao;

import com.theateamiu.mms.models.Summary;

public interface SummaryDAO {
    public Summary getSummary(long managerialId);
    public boolean updateCurrentManagerialSummary(long managerialId);
}
