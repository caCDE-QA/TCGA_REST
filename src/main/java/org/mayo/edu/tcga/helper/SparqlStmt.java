package org.mayo.edu.tcga.helper;

public class SparqlStmt {

    private static String PREFIX = 
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "PREFIX dcterms: <http://purl.org/dc/terms/> " +
                "PREFIX mms: <http://rdf.cdisc.org/mms#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX skos: <http://www.w3.org/2004/02/skos/core#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX tcga: <http://cancergenome.nih.gov/tcga#> " ;
            
    private static String GRAPH = " { GRAPH <http://tcga.org/data>  {  ";
    
    private static String SELECT_ALL = " SELECT * " +GRAPH;
    
    private static String SELECT_VD = " SELECT ?deValueDomain " +GRAPH;
    
    public static String DE_META =                     
                " ?de rdf:type mms:DataElement . " +
                " ?de rdfs:label ?deName . " +
                " ?de skos:definition ?deDescription . " +
                " ?de mms:dataElementLabel ?deLabel . " +
                " ?de skos:notation ?cdeId . " +
                " ?de mms:dataElementValueDomain ?deValueDomain . " ;
    
    public static String PV_META = 
                " ?pv rdf:type mms:PermissibleValue . " +
                " ?pv rdfs:label ?pvName . " +
                " ?pv skos:notation ?cdeId . " +
                " ?pv mms:inValueDomain ?pvValueDomain . " +
                " OPTIONAL { ?pv mms:valuemeaning ?pvMeaning } . " +
                " OPTIONAL { ?pv mms:meaningconcepts ?pvConcepts }  . " +
                " OPTIONAL { ?pv mms:meaningdescription ?pvDescription }  . " ;
    
    public static String END =  " } } ";

    public static String DE_ALL =  PREFIX + SELECT_ALL +DE_META +END;
    
    public static String getDataElementBasedOnId(String id)   { 
            return PREFIX +SELECT_ALL +DE_META +" FILTER (REGEX(STR(?de), \"" +id +"\", \"i\")) "+END;
    }
    
    public static String getValueDomainId(String id)   {
        return PREFIX + SELECT_VD +DE_META +" FILTER (REGEX(STR(?de), \"" +id +"\", \"i\")) " +END;
    }
    
    public static String getPermissibleValues(String id)  {
        return PREFIX +SELECT_ALL + PV_META +" FILTER (REGEX(STR(?pvValueDomain), \"" +id +"\", \"i\")) " +END ;
    }

}



