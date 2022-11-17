package petstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private int id;
    private Category category;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public Pet(int id, Category category, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id && Objects.equals(category, pet.category) && Arrays.equals(photoUrls, pet.photoUrls) && Arrays.equals(tags, pet.tags) && Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, category, status);
        result = 31 * result + Arrays.hashCode(photoUrls);
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }
}
