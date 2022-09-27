package by.bstu.javalab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Action {
    public String Name;
    public String Description;
    public String Image;
    public String Category;
    public Integer TookMinutes;

    public Action(String name, String description, String image, String category, Integer minutes){
        Name = name;
        Description = description;
        Image = image;
        Category = category;
        TookMinutes = minutes;
    }

    public Action(){

    }

    @Override
    public String toString() {
        return Name + "\n" + Description + "\n" + "Категория: " + Category + "\n" + "Длительность: " + TookMinutes + " (в минутах)";
    }

    public static ArrayList<Action> Collection = new ArrayList<Action>();

    public static void Serialize(File dir){
        try{
            Gson gson = new Gson();
            FileWriter fw = new FileWriter(new File(dir, "json.json"));
            String json = gson.toJson(Action.Collection);
            gson.toJson(Action.Collection, fw);
            fw.close();
        }
        catch(Exception ex){

        }
    }

    public static ArrayList<Action> Deserialize(File dir){
        ArrayList<Action> newCollection = new ArrayList<Action>();
        try{
            Gson gson = new Gson();
            FileReader fr = new FileReader(new File(dir, "json.json"));
            newCollection = gson.fromJson(fr, new TypeToken<ArrayList<Action>>(){}.getType());
            Action.Collection = newCollection;
        }
        catch(Exception ex){

        }
        return newCollection;
    }
}
