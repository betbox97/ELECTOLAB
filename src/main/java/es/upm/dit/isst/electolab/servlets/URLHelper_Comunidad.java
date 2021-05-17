package es.upm.dit.isst.electolab.servlets;

public class URLHelper_Comunidad {
    public static String getURL() {
            String envValue = System.getenv("ElectoLabSERVICE_SRV_SERVICE_HOST");
            if(envValue == null)
                    return "http://localhost:8080/ElectoLab-SERVICE/rest/Community";
            else
                    return envValue;
    }
}