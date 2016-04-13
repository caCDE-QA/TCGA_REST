# TCGA_REST

This application places REST services on top of TCGA data elements within a 4store repository.  The elements in the 4store repository were created from the TCGS_2RDF project - https://github.com/caCDE-QA/TCGA_2_RDF.git

The REST documentation was created using enunciate.
	http://informatics.mayo.edu/tcga/index.html
Could not figure out how to change the links for the pages to a location different then where services were running so had to hand edit the html to change the service URLs and remove the Swagger documentation.

TODO - The queries are run using Dan Hanley's Store Class which is great, but transforms the results to Strings and therefore the results are sent directly to the caller.  Would like to alter the JSON results to add links so need to write different query mechanism.  Want to insert values which reference self as well as reference it's "relatives".

