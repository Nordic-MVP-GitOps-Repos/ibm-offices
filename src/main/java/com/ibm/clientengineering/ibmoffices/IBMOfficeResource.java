package com.ibm.clientengineering.ibmoffices;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/offices")
public class IBMOfficeResource {

    private Set<IBMOffice> offices = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public IBMOfficeResource() {
        offices.add(new IBMOffice("Armonk", "Armonk"));
        
        offices.add(new IBMOffice("Astor Place", "Astor Place"));
        offices.add(new IBMOffice("Austin", "Austin"));
        offices.add(new IBMOffice("Research Triangle Park", "Research Triangle Park"));
        offices.add(new IBMOffice("Hursley House", "Hursley House"));
        offices.add(new IBMOffice("Bangalore", "Bangalore"));     
        offices.add(new IBMOffice("Kista", "Kista"));
        offices.add(new IBMOffice("Amsterdam", "Amsterdam"));
        offices.add(new IBMOffice("London", "London"));
        offices.add(new IBMOffice("San Francisco", "San Francisco"));
    }

    @GET
    public Set<IBMOffice> list() {
        System.out.println("Returning all offices... " + new Date());
        return offices;
    }

    @POST
    public Set<IBMOffice> add(IBMOffice office) {
        offices.add(office);
        System.out.println("Adding office: " + office);
        return offices;
    }

    @DELETE
    public Set<IBMOffice> delete(IBMOffice office) {
        offices.removeIf(existingOffice -> existingOffice.name.contentEquals(office.name));
        return offices;
    }
}
