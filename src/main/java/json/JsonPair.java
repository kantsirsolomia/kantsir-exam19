package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonPair extends Tuple<String, Json>{
    private  String name;
    public Json value;
    public JsonPair(String name, Json value) {
        super(name, value);
        this.name = name;
        this.value = value;

    }
}