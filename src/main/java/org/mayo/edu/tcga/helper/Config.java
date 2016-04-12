package org.mayo.edu.tcga.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class sets the configuration information.  
 * */

public final class Config  {

    /**
     * Configuration file name.
     */
    private String configFileName = "config.properties";
    /**
     * Configuration properties.
     */
    private Properties configProps;

    /**
     * URL to the data repository
     */
    private static String repositoryUrl;

    /**
     * Constructor finds the working directory and loads the configuration properties.
     */
    public Config()  {
        String workingDir = System.getProperty("user.dir");
        int binLoc = workingDir.lastIndexOf("bin");
        if(binLoc > -1)  {
            workingDir = workingDir.substring(0, binLoc); 
        }
        else  {
            workingDir = workingDir + File.separator;
        }
        //TODO: get rid of the hard coded reference to the project name as user may rename war file
        String configFullPath = workingDir + File.separator +"webapps" + File.separator +"tcga"  + File.separator
                +"conf" +File.separator +configFileName;

        configProps = new java.util.Properties();
        try {
            InputStream is = new FileInputStream(configFullPath);
            configProps.load(is);
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    /**
     * get the property value.
     * @param key name of the property
     * @return property value
     */
    public String getProperty(final String key)  {
       String value = this.configProps.getProperty(key);
       return value;
    }

    /**
     * sets the configuration properties.
     */
    public void setConfig()  {
        repositoryUrl = getProperty("REPOSITORY_URL");

        runPropertyCheck();
    }

    /**
     * Get the repository URL
     * @return repository URL
     */
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     * 
     */
    private void runPropertyCheck()  {
        if (repositoryUrl == null)  {
            System.out.println("ERROR - missing parameter REPOSITORY_URL");
        }
    }

}
