package com.sgcib.lafabryik.repository;

import java.util.List;

/**
 * Created by vkonatha061917 on 4/23/2018.
 */
public interface DashboardDao<T> {


    String loadAll();

    String loadTalkCounts();

    String loadInteractionCounts();

    String loadInteractionCountsDendo();

    String loadContextCounts();

}
