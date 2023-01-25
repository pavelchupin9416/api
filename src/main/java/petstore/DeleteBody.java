package petstore;

import java.util.Objects;

public class DeleteBody {
    public int code;
    public String type;
    public String message;

    public DeleteBody(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteBody that = (DeleteBody) o;
        return code == that.code && Objects.equals(type, that.type) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }
}
