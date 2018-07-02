package com.sgcib.lafabryik.dao;

import java.io.*;
import java.sql.*;
//import java.sql.SQLException;


import java.util.*;
//import java.util.Arrays;
//import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.jdbc.object.GenericStoredProcedure;
//import org.springframework.jdbc.object.StoredProcedure;
//import org.springframework.jdbc.core.SqlParameter;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import com.sgcib.lafabryik.model.Dashboard;
import com.sgcib.lafabryik.repository.DashboardDao;

/**
 * Created by vkonatha061917 on 4/23/2018.
 */
@Repository
public class DashboardDaoImpl implements DashboardDao<Dashboard> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public String loadAll() {
//        String query = "select * from lafabryik.master_data";
//        return jdbcTemplate.query(query, (resultSet, i) -> {
//            return toDashboard(resultSet);
//        });
        String fileAsString = "";
        try {
            InputStream is = new FileInputStream("D:\\Development\\git\\la-fabryk-server\\src\\main\\resources\\all_data.json");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null)
            {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            fileAsString = sb.toString();
            return fileAsString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsString;
    }

    @Override
    public String loadTalkCounts() {
        String fileAsString = "";
        try {
            InputStream is = new FileInputStream("D:\\Development\\git\\la-fabryk-server\\src\\main\\resources\\high_talk_young_entrepreneurs.json");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null)
            {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            fileAsString = sb.toString();
            return fileAsString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsString;
    }

    @Override
    public String loadContextCounts() {
        String fileAsString = "";
        try {
            InputStream is = new FileInputStream("D:\\Development\\git\\la-fabryk-server\\src\\main\\resources\\high_context_young_entrepreneurs.json");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null)
            {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            fileAsString = sb.toString();
            return fileAsString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsString;
    }

    @Override
    public String loadInteractionCounts() {
        String fileAsString = "";
        try {
            InputStream is = new FileInputStream("D:\\Development\\git\\la-fabryk-server\\src\\main\\resources\\interaction_between_entrepreneurs.json");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null)
            {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            fileAsString = sb.toString();
            JSONObject jsonObject = new JSONObject(fileAsString);
            String resultJson = "{ \"nodes\": [";
            List<String> nodeList = new ArrayList<>();
            for (String keyobj : jsonObject.keySet()) {
                if (!nodeList.contains(keyobj)) {
                    nodeList.add(keyobj);
                }
                JSONObject tmp = jsonObject.getJSONObject(keyobj);
                for (String tmpKey : tmp.keySet()) {
                    if (!nodeList.contains(tmpKey)) {
                        nodeList.add(tmpKey);
                    }
                }
            }
            Integer count = 1;
            Integer grp = 1;
            for (String node: nodeList) {
                if (grp == 10) {
                    count = 1;
                    grp = 1;
                }
                if (count/5 == grp && count%5 == 0) {
                    grp ++;
                }
                resultJson += "{\"id\": \""+ node +"\", \"group\": "+ grp +"},";
                count++;
            }
            resultJson = resultJson.substring(0, resultJson.length()-1);
            resultJson += "], \"links\": [";
            for (String keyobj : jsonObject.keySet()) {
                JSONObject tmp = jsonObject.getJSONObject(keyobj);
                for(String tmpKey : tmp.keySet()) {
                    resultJson += "{\"source\": \""+keyobj+"\", \"target\": \""+tmpKey+"\", \"value\": "+ Integer.toString(Integer.parseInt(tmp.getString(tmpKey)))+"},";
                }
            }
            resultJson = resultJson.substring(0, resultJson.length()-1);
            resultJson += "]}";
            JSONObject result = new JSONObject(resultJson);
            return resultJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsString;
    }

    @Override
    public String loadInteractionCountsDendo() {
        String fileAsString = "";
        try {
            InputStream is = new FileInputStream("D:\\Development\\git\\la-fabryk-server\\src\\main\\resources\\interaction_between_entrepreneurs.json");
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null)
            {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            fileAsString = sb.toString();
            JSONObject jsonObject = new JSONObject(fileAsString);
            List<String> baptList = new ArrayList<>();
            String bapt = "Baptiste Johnson";
            String sun = "Charl ne Sun";
            List<String> sunList = new ArrayList<>();
            for (String keyobj : jsonObject.keySet()) {
                JSONObject tmp = jsonObject.getJSONObject(keyobj);
                for (String tmpKey : tmp.keySet()) {
                    if (keyobj.equals(bapt) && !tmpKey.equals(bapt)) {
                        if (!baptList.contains(tmpKey)) {
                            baptList.add(tmpKey);
                        }
                    }
                    if (!keyobj.equals(bapt) && tmpKey.equals(bapt)) {
                        if (!baptList.contains(keyobj)) {
                            baptList.add(keyobj);
                        }
                    }
                }
            }
            for (String keyobj : jsonObject.keySet()) {
                JSONObject tmp = jsonObject.getJSONObject(keyobj);
                for (String tmpKey : tmp.keySet()) {
                    if (keyobj.equals(sun) && !tmpKey.equals(sun)) {
                        if (!sunList.contains(tmpKey)) {
                            sunList.add(tmpKey);
                        }
                    }
                    if (!keyobj.equals(sun) && tmpKey.equals(sun)) {
                        if (!sunList.contains(keyobj)) {
                            sunList.add(keyobj);
                        }
                    }
                }
            }
            String resultJson = "{ \"name\": \""+ bapt +"\",\"children\": [";
            for (String baptPair : baptList) {
                if (baptPair.equals(sun)) {
                    resultJson += "{ \"name\": \""+ baptPair +"\",\"children\": [";
                    for (String sunPair : sunList) {
                        resultJson += "{ \"name\": \""+ sunPair +"\",\"children\":[]},";
                    }
                    resultJson = resultJson.substring(0, resultJson.length()-1);
                    resultJson += "]},";
                    continue;
                }
                resultJson += "{ \"name\": \""+ baptPair +"\",\"children\":[]},";
            }
            resultJson = resultJson.substring(0, resultJson.length()-1);
            resultJson += "]}";
            JSONObject result = new JSONObject(resultJson);
            return resultJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsString;
    }

    private Dashboard toDashboard(ResultSet resultSet) throws SQLException {
        Dashboard dashboard = new Dashboard();

        dashboard.setFacebookMessage(resultSet.getString("FACEBOOK_MESSAGE"));
        dashboard.setFacebookTimestamp(resultSet.getString("FACEBOOK_TIMESTAMP"));
        dashboard.setName(resultSet.getString("NAME"));
        dashboard.setSentiment(resultSet.getString("SENTIMENT"));
        dashboard.setSrcFacebookName(resultSet.getString("SOURCE_FACEBOOK_NAME"));

        return dashboard;
    }
}
