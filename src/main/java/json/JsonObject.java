package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private final Map<String, Json> pairs = new HashMap();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair : jsonPairs) {
            pairs.put(pair.key, pair.value);
        }
    }

    @Override
    public String toJson() {


    String lala = "{";
        StringBuilder strr = new StringBuilder("{");

        int index = 0;
        for (String key : pairs.keySet()) {
            lala += "'";
            lala += key;
            lala += "': ";
            lala += pairs.get(key).toJson();
            System.out.println(pairs.keySet().size());
            index++;
            if (index < pairs.keySet().size()) {
                lala += ", ";
            }

        }
        System.out.println(lala + "}");
        return lala + "}";

    }

    public void add(JsonPair jsonPair) {
        pairs.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        if (pairs.containsKey(name)) {
            return pairs.get(name);}
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject proj = new JsonObject();

        for (String n: names){
            Json value = this.find(n);
            if(pairs.containsKey(n)){
                proj.add(new JsonPair(n, value));

            }
        }
        return proj;
    }
}
