package gallery.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String table;
    private String column;
    private Object value;

    public ResourceNotFoundException(String table, String column, Object value){
        super(String.format("%s does not exist with %s: %s", table, column, value));
        this.table=table;
        this.column=column;
        this.value=value;
    }

    public String getTable() {
        return table;
    }

    public String getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }
}
