package org.mayo.edu.tcga.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This object contains all the metadata found in common for all data elements
 */
@XmlRootElement
public class DataElementModel {


    private String de;
    private String deName;
    private String deDescription;
    private String deLabel;
    private String cdeId;
    private String deValueDomain;
   
 
    /**
     * The uri of the data element
     * @return
     */
    public String getDe() {
        return de;
    }

    /** 
     * The name of the data element
     * @return
     */
    public String getDeName() {
        return deName;
    }

    /**
     * The description of the data element
     * @return
     */
    public String getDeDescription() {
        return deDescription;
    }

    /**
     * The label of the data element
     * @return
     */
    public String getDeLabel() {
        return deLabel;
    }

    /**
     * The cde id for the data element
     * @return
     */
    public String getCdeId() {
        return cdeId;
    }

    /** 
     * The uri for the data element's value domain
     * @return
     */
    public String getDeValueDomain() {
        return deValueDomain;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setDeName(String deName) {
        this.deName = deName;
    }

    public void setDeDescription(String deDescription) {
        this.deDescription = deDescription;
    }

    public void setDeLabel(String deLabel) {
        this.deLabel = deLabel;
    }

    public void setCdeId(String cdeId) {
        this.cdeId = cdeId;
    }

    public void setDeValueDomain(String deValueDomain) {
        this.deValueDomain = deValueDomain;
    }


    public DataElementModel() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    
    
}
