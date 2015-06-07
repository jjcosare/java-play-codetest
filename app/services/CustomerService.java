package services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.google.inject.Singleton;
import models.Customer;
import play.libs.Json;

import java.io.IOException;
import java.util.List;

/**
 * Created by jjcosare on 6/7/15.
 */
@Singleton
public class CustomerService implements ICustomerService {

    @Override
    public String sortByDueDate(String json){
        String result = null;
        try {
            List<Customer> customerList = null;
            customerList = mapper.readValue(json, new TypeReference<List<Customer>>() {});
            customerList.sort((customer1, customer2) -> customer1.getDuetime().compareTo(customer2.getDuetime()));
            result = mapper.writeValueAsString(customerList);
        }catch (JsonParseException ex){
            ex.printStackTrace();
        }catch (JsonMappingException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    private ObjectMapper mapper;
    public CustomerService(){
        mapper = Json.mapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, Boolean.FALSE);
        mapper.registerModule(new JSR310Module());
    }
}

