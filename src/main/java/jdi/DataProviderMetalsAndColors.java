package jdi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jdi.entities.MetalsAndColors;
import org.testng.annotations.DataProvider;

public class DataProviderMetalsAndColors {

    @DataProvider(name = "DataProviderJson")
    public Object[][] dataProviderMetalColor() {
        Object[][] object = new Object[0][];
        String path = "src/test/resources/JdiDataSet.json";
        {
            try {
                ObjectMapper mapper = new ObjectMapper();
                FileInputStream fileInputStream = new FileInputStream(path);
                HashMap<String, MetalsAndColors> map = mapper.readValue(fileInputStream,
                        new TypeReference<HashMap<String, MetalsAndColors>>() {
                        });
                int i = 0;
                object = new Object[map.size()][1];
                for (Map.Entry<String, MetalsAndColors> entry : map.entrySet()) {
                    object[i][0] = entry.getValue();
                    i++;
                }
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("error of Data providing");
            }
        }
        return object;
    }
}

