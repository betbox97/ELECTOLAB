package es.upm.dit.isst.electolab.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class EscenarioComplejoApp extends ResourceConfig {
        public EscenarioComplejoApp() {
                packages("es.upm.dit.isst.electolab.rest");
        }
}
