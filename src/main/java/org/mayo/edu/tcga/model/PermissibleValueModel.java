package org.mayo.edu.tcga.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This object contains all the metadata found in common for all data elements
 */
@XmlRootElement
public class PermissibleValueModel {

    private String pv;
    private String pvName;
    private String cdeId;
    private String pvValueDomain;
    private String pvMeaning;
    private String pvConcepts;
    private String pvDescription;
    
    /**
     * The uri of the permissible value
     * @return
     */
    public String getPv() {
        return pv;
    }
    /**
     * The name of the permissible value
     * @return
     */
    public String getPvName() {
        return pvName;
    }
    /**
     * The cdeId of the permissible value
     * @return
     */
    public String getCdeId() {
        return cdeId;
    }
    /**
     * The value domain id of the permissible value
     * @return
     */
    public String getPvValueDomain() {
        return pvValueDomain;
    }
    /**
     * The meaing of the permissible value
     * @return
     */
    public String getPvMeaning() {
        return pvMeaning;
    }
    /**
     * The concepts of the permissible value
     * @return
     */
    public String getPvConcepts() {
        return pvConcepts;
    }
    /**
     * The description of the permissible value
     * @return
     */
    public String getPvDescription() {
        return pvDescription;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public void setPvName(String pvName) {
        this.pvName = pvName;
    }

    public void setCdeId(String cdeId) {
        this.cdeId = cdeId;
    }

    public void setPvValueDomain(String pvValueDomain) {
        this.pvValueDomain = pvValueDomain;
    }

    public void setPvMeaning(String pvMeaning) {
        this.pvMeaning = pvMeaning;
    }

    public void setPvConcepts(String pvConcepts) {
        this.pvConcepts = pvConcepts;
    }

    public void setPvDescription(String pvDescription) {
        this.pvDescription = pvDescription;
    }

    public PermissibleValueModel() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    
    
}
