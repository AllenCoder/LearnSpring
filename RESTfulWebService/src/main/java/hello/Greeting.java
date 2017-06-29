package hello; /**
 * Created by Allen on 2017/6/29.
 */

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends ResourceSupport {
    private final String content;
    private final String value;

    @JsonCreator
    public Greeting(@JsonProperty("content") String content,@JsonProperty("value") String value) {
        this.content = content;
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public String getValue(){
        return value;
    }
}
