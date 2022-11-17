package petstoreTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.Category;
import petstore.*;
import petstore.Tag;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static io.restassured.RestAssured.given;

public class PetTest {

    private final static String url = "https://petstore.swagger.io/v2";

    @Test
    public void checkGetPet() {
        Category category = new Category(0,"cats");
        Tag tag = new Tag(0, "string");
        Pet pet = new Pet(9, category,new String[] {"string"}, new Tag[] {tag},"sold");

        Specifications.installSpecifications(Specifications.requestSpec(url),Specifications.responseSpecOK200());
        Response response = given().when().get("/pet/9").then().log().all().extract().response();

        Gson gson = new GsonBuilder().create();
        Pet pet2 = gson.fromJson(response.body().asString(), Pet.class);
        Assert.assertTrue(pet.equals(pet2));
    }
}
