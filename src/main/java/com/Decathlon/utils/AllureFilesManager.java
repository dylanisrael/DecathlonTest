package com.Decathlon.utils;

import com.Decathlon.config.Properties;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

public class AllureFilesManager {

    public static Logger logger = getLogger(AllureFilesManager.class);

    public static void createEnvironmentPropertiesFile() throws IOException
    {
        File environment = new File("allure-results/environment.properties");

        if(!environment.exists()){
            FileOutputStream fileOutputStream
                    = new FileOutputStream(
                    "allure-results/environment.properties");
            java.util.Properties properties = new java.util.Properties();
            properties.setProperty("Test URL ☢️", Properties.Config.getEnvironment());
            properties.setProperty("Headless mode 🌀", String.valueOf(Properties.Config.getHeadless()));
            properties.setProperty("Local browser 🌍", String.valueOf(Properties.Config.getBrowser()));

            properties.store(
                    fileOutputStream,
                    "environment allure configuration file");

            fileOutputStream.close();
        }
    }

    public static void createCategorieJsonFile() {

        File categoriesFile = new File("allure-results/categories.json");

        if (!categoriesFile.exists()) {

            JSONObject ignoredTests = new JSONObject();
            ignoredTests.put("name", "Ignored tests");

            JSONArray matchedStatusesIT = new JSONArray();
            matchedStatusesIT.add("skipped");

            ignoredTests.put("matchedStatuses", matchedStatusesIT);


            JSONObject infrastructureProblems = new JSONObject();
            infrastructureProblems.put("name", "Infrastructure problems");

            JSONArray matchedStatusesIP = new JSONArray();
            matchedStatusesIP.add("broken");
            matchedStatusesIP.add("failed");

            infrastructureProblems.put("matchedStatuses", matchedStatusesIP);
            infrastructureProblems.put("messageRegex", ".*bye-bye.*");

            JSONObject outdatedTests = new JSONObject();
            outdatedTests.put("name", "Outdated tests");
            JSONArray matchedStatusesOT = new JSONArray();
            matchedStatusesOT.add("broken");
            outdatedTests.put("matchedStatuses", matchedStatusesOT);
            outdatedTests.put("traceRegex", ".*FileNotFoundException.*");

            JSONObject koTests = new JSONObject();
            koTests.put("name", "KO tests");
            JSONArray matchedStatusesKO = new JSONArray();
            matchedStatusesKO.add("failed");
            koTests.put("matchedStatuses", matchedStatusesKO);

            JSONObject errorDuringTests = new JSONObject();
            errorDuringTests.put("name", "Error during test execution");
            JSONArray matchedStatusesEDE = new JSONArray();
            matchedStatusesEDE.add("broken");
            errorDuringTests.put("matchedStatuses", matchedStatusesEDE);

            JSONArray categories = new JSONArray();
            categories.add(ignoredTests);
            categories.add(infrastructureProblems);
            categories.add(outdatedTests);
            categories.add(koTests);
            categories.add(errorDuringTests);


            //Write JSON file
            try (FileWriter file = new FileWriter("allure-results/categories.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(categories.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createExecutorJsonFile () {

        File executorFile = new File("allure-results/executor.json");

        if (!executorFile.exists()) {

            JSONObject executor = new JSONObject();
            executor.put("name", "Maven");
            executor.put("type", "Maven");
            executor.put("reportName", "airFrance");

            //Write JSON file
            try (FileWriter file = new FileWriter("allure-results/executor.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(executor.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
