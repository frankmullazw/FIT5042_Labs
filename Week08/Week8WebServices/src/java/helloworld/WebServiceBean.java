/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mukar
 */
@Named(value = "webServiceBean")
@SessionScoped
public class WebServiceBean implements Serializable {

    private String name;

    private HelloWorldRestServiceClient webServiceClient;

    /**
     * Creates a new instance of WebServiceBean
     */
    public WebServiceBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorldRestServiceClient getWebServiceClient() {
        return webServiceClient;
    }

    public void setWebServiceClient() {
        this.webServiceClient = new HelloWorldRestServiceClient();
        this.webServiceClient.setPostNameForm(this.getName());

    }

    static class HelloWorldRestServiceClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/Week8WebServices/webresources";

        public HelloWorldRestServiceClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("greeting");
        }

        public String getHtml() throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
        }

        public void setPostName() throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
        }

        public void setPostNameForm(String name) throws ClientErrorException {
            //create a form and add to this form information of a user
            Form form = new Form();
            form.param("name", name);
            webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        }

        public String getXml() throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
        }

        public void putXml(Object requestEntity) throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
        }

        public void close() {
            client.close();
        }
    }
}
