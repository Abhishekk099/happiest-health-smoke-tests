package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetResponseData {
    public static List<String> getSufalamLimsServiceNameDataValue(String jsonresponse) {
        List<String> stringList = new ArrayList<>();
        System.out.println(jsonresponse);
        JSONObject jsonObject = new JSONObject(jsonresponse);
        JSONObject Success = jsonObject.getJSONObject("Success");
        JSONArray Data = Success.getJSONArray("Data");
        for (int i = 0; i < Data.length(); i++) {
            JSONObject InnerData = Data.getJSONObject(i);
            String ServiceName = InnerData.getString("ServiceName");
            stringList.add(ServiceName);
        }
        return stringList;
    }

    public static List<String> getSufalamLimsDiseaseNameDataValue(String jsonresponse) {
        List<String> stringList = new ArrayList<>();
        System.out.println(jsonresponse);
        JSONObject jsonObject = new JSONObject(jsonresponse);
        JSONObject Success = jsonObject.getJSONObject("Success");
        JSONArray Data = Success.getJSONArray("Data");
        for (int i = 0; i < Data.length(); i++) {
            JSONObject InnerData = Data.getJSONObject(i);
            String DiseaseName = InnerData.getString("DiseaseName");
            stringList.add(DiseaseName);
        }
        return stringList;
    }

    public static List<String> getSufalamLimsOrganNameDataValue(String jsonresponse) {
        List<String> stringList = new ArrayList<>();
        System.out.println(jsonresponse);
        JSONObject jsonObject = new JSONObject(jsonresponse);
        JSONObject Success = jsonObject.getJSONObject("Success");
        JSONArray Data = Success.getJSONArray("Data");
        for (int i = 0; i < Data.length(); i++) {
            JSONObject InnerData = Data.getJSONObject(i);
            String OrganName = InnerData.getString("OrganName");
            stringList.add(OrganName);
        }
        return stringList;
    }

}
