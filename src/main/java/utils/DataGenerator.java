package utils;

import com.github.javafaker.Faker;
import org.json.JSONObject;

public class DataGenerator {
    public static String buildNotificationJson(String dni, String brand, int amount, String authCode) {
        JSONObject json = new JSONObject();
        json.put("identification_type", "DNI");
        json.put("identification_number", dni);
        json.put("gender", "M");
        json.put("bin", "1111111");
        json.put("last_four_digits", "1234");
        json.put("brand", brand);
        json.put("encrypted_card_number", "");

        JSONObject transaction = new JSONObject();
        transaction.put("type", "Purchase");
        transaction.put("authorization_code", authCode);
        transaction.put("origin_currency", "ARS");
        transaction.put("origin_amount", amount);

        JSONObject establishment = new JSONObject();
        establishment.put("establishment_number", "55");
        establishment.put("establishment_country", "AR");

        json.put("transaction", transaction);
        json.put("establishment", establishment);

        return json.toString();
    }
}
