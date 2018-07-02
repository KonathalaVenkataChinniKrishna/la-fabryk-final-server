package com.sgcib.lafabryik.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgcib.lafabryik.repository.DashboardDao;
import com.sgcib.lafabryik.model.Dashboard;

/**
 * Created by vkonatha061917 on 4/23/2018.
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/lafabryik")
@Component
public class DashboardClient {

    @Autowired
    DashboardDao<Dashboard> dashboardDao;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadDashboardData() {
        return dashboardDao.loadAll();

    }

    @RequestMapping(value = "/talkCounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadTalkCountsData() {
        return dashboardDao.loadTalkCounts();
    }

    @RequestMapping(value = "/contextCounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadContextCountsData() {
        return dashboardDao.loadContextCounts();
    }

    @RequestMapping(value = "/interactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadInteractionsData() {
        return dashboardDao.loadInteractionCounts();
    }

    @RequestMapping(value = "/interactionsdendo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadInteractionsDataDendo() {
        return dashboardDao.loadInteractionCountsDendo();
    }

}
