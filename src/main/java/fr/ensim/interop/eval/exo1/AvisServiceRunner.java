package fr.ensim.interop.eval.exo1;

import javax.xml.ws.Endpoint;

public class AvisServiceRunner {
    public static void main(String[] args) {
        String url = "http://localhost:9090/AvisService?wsdl";
        System.out.println("Web service disponible avec l'hyperlien " + url);
        Endpoint.publish(url, new AvisService());

    }
}
