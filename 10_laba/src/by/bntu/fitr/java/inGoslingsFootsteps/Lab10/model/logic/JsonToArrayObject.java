package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContext;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class JsonToArrayObject {

    private final static String PATH_TO_FILE = "D:\\java\\10_laba\\file.json";

    public static AirTicketOfficeContext DeserializeJson() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(PATH_TO_FILE));
        Gson gson = new Gson();
        return gson.fromJson(reader, AirTicketOfficeContext.class);
    }

    public static void SerializeJson(AirTicketOfficeContext contex) throws IOException {
        Gson gson = new Gson();
        FileWriter writer =new FileWriter(PATH_TO_FILE);
        String string = gson.toJson(contex);
        writer.write(string);
        writer.close();
    }
}
