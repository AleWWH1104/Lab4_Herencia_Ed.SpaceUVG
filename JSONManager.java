import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSONManager implements GenerarArchivosI, CargarArchivosI<HashMap<String, Object>> {

    @Override
    public List<HashMap<String, Object>> loadData(String filePath) {
        JSONParser parser = new JSONParser();
        List<HashMap<String, Object>> data = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                if (o instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) o;
                    HashMap<String, Object> item = new HashMap<>(jsonObject);
                    data.add(item);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return data;
    }
}
