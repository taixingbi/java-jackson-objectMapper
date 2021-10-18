package hello;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.model.User;
import hello.model.User;
import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws JAXBException, IOException {
        System.out.println("----------app----------");

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User(1, "hunter", "hunter@gmail.com");
        String userAsString = objectMapper.writeValueAsString(user);
        System.out.println(userAsString);

        String json = "{\"id\":1,\"name\":\"hunter\",\"email\":\"hunter@gmail.com\"}";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user_ = objectMapper.readValue(json, User.class);
        System.out.println( user_.toString() );

        JsonNode jsonNode = objectMapper.readTree(json);
        String email = jsonNode.get("email").asText();
        System.out.println( "email: " + email );


        System.out.println("----------app end----------");
    }
}
