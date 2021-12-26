package spring.turbo.examples.client;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import spring.turbo.examples.model.Pet;
import spring.turbo.module.feign.FeignClient;

import java.util.List;
import java.util.Map;

@FeignClient(url = "http://localhost:8080/pet")
@ForAllClients
public interface PetClient {

    @RequestLine("GET")
    @Headers({
            "X-Token: {token}"
    })
    public List<Pet> getAll(@Param("token") String tokenValue, @QueryMap Map<String, Object> hello);

}
