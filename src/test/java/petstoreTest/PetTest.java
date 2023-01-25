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

    @Test(enabled = true, description = "Добавление животного", priority = 1)
    public void checkPostPet() {
        Category category = new Category(0,"cats");
        Tag tag = new Tag(0, "test");
        Pet pet = new Pet(2, category,new String[] {"string"}, new Tag[] {tag},"sold");

        Specifications.installSpecifications(Specifications.requestSpec(url),Specifications.responseSpecOK200());
        Response response = given().body(pet).when().post("/pet").then().log().all().extract().response();

        Gson gson = new GsonBuilder().create();
        Pet pet2 = gson.fromJson(response.body().asString(), Pet.class);
        Assert.assertTrue(pet.equals(pet2));
    }

    @Test(enabled = true, description = "Получение животного", priority = 2)
    public void checkGetPet() {
        Category category = new Category(0,"cats");
        Tag tag = new Tag(0, "test");
        Pet pet = new Pet(2, category,new String[] {"string"}, new Tag[] {tag},"sold");

        Specifications.installSpecifications(Specifications.requestSpec(url),Specifications.responseSpecOK200());
        Response response = given().when().get("/pet/2").then().log().all().extract().response();

        Gson gson = new GsonBuilder().create();
        Pet pet2 = gson.fromJson(response.body().asString(), Pet.class);
        Assert.assertTrue(pet.equals(pet2));
    }
    @Test(enabled = true, description = "Удаление животного", priority = 3)
    public void checkDeletePet() {
        Category category = new Category(0,"cats");
        Tag tag = new Tag(0, "test");
        Pet pet = new Pet(2, category,new String[] {"string"}, new Tag[] {tag},"sold");

        Specifications.installSpecifications(Specifications.requestSpec(url),Specifications.responseSpecOK200());
        Response response = given().body(pet).when().delete("/pet/2").then().log().all().extract().response();

        DeleteBody deleteBody = new DeleteBody(200,"unknown","2");

        Gson gson = new GsonBuilder().create();
        DeleteBody deleteBody2 = gson.fromJson(response.body().asString(), DeleteBody.class);
        Assert.assertTrue(deleteBody.equals(deleteBody2));
    }
}
