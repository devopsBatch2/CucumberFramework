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
import java.util.List;
import java.util.Map;

public class APIintro {

    @Test
    public void firstGetCall() throws IOException, URISyntaxException {

        ObjectMapper objectMapper =new ObjectMapper();

//creating a client (like postman)
        HttpClient httpClient=HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/1");

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
    @Test
    public void getAllUsersName() throws URISyntaxException, IOException {


//creating a client (like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();
//        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")  //schema or protocol
                .setHost("reqres.in") //host or domain
                .setPath("/api/users").//path parameter
                setCustomQuery("page=2");  //query parameter

        //defining a Get method

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
//deserialisation
        Map<String, Object> allUsers = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {

                });

        List<Map<String, Object>> usersDataList = (List<Map<String, Object>>) allUsers.get("data");

        System.out.println(usersDataList);
        for (int i = 0; i < usersDataList.size(); i++) {
            String firstName = (String) usersDataList.get(i).get("first_name"); //this returning us Object in line 89, because we casting to String
            System.out.println(firstName);
        }

    }
    @Test
    public void getPetByStatus() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
//        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")  //schema or protocol
                .setHost("petstore.swagger.io") //host or domain
                .setPath("v2/pet/findByStatus").//path parameter
                setCustomQuery("status=jan");  //query parameter

        //defining a Get method

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
//deserialisation
        Map<String, Object> map = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {

                });

        Map<String, Object> categoryData = (Map<String, Object>) map.get("category");
       // String categoryName= (String)categoryData.get(name)


        }

    }







