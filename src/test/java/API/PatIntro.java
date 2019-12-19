package API;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class PatIntro {

    @Test
    public void firstGetCall() throws IOException, URISyntaxException {

        ObjectMapper objectMapper =new ObjectMapper();

//creating a client (like postman)
        HttpClient httpClient= HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/853");

        //defining a Get method

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept","application/json");

//executing the api call
        HttpResponse response =httpClient.execute(httpGet);  //this containing json

        Map<String,Object> firstDeseralization=objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,Object>>(){

                });
        System.out.println(firstDeseralization.get("id"));
        System.out.println(firstDeseralization.get("status"));

        Map<String,Object>categoryMap=(Map<String,Object>)firstDeseralization.get("category");

        String name=categoryMap.get("name").toString();
        Integer id=(Integer) categoryMap.get("id");
        System.out.println(categoryMap);



        Assert.assertEquals(HttpStatus.SC_OK,
                response.getStatusLine().getStatusCode());

    }
}


