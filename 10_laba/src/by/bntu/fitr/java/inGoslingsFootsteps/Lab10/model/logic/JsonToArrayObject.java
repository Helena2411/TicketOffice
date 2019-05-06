package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContex;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class JsonToArrayObject {

    private final static String PATH_TO_FILE = "D:\\java\\10_laba\\file.json";

    public static AirTicketOfficeContex DeserializeJson() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(PATH_TO_FILE));
        Gson gson = new Gson();
        AirTicketOfficeContex contex = gson.fromJson(reader, AirTicketOfficeContex.class);
        return contex;
    }

    public static void SerializeeJson(AirTicketOfficeContex contex) throws IOException {
        Gson gson = new Gson();
        FileWriter writer =new FileWriter(PATH_TO_FILE);
        String string = gson.toJson(contex);
        writer.write(string);
        writer.close();
    }
}
