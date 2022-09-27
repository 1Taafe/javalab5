package by.bstu.javalab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        String[] categories = { "Учеба", "Отдых", "Еда", "Сон", "Работа", "Хобби", "Другое"};
        Integer[] stats = new Integer[7];
        for(int i = 0; i < 7; i++){
            stats[i] = 0;
        }

        for (Action a: Action.Collection) {
            if(a.Category.equals(categories[0])){
                stats[0] += a.TookMinutes;
            }
            if(a.Category.equals(categories[1])){
                stats[1] += a.TookMinutes;
            }
            if(a.Category.equals(categories[2])){
                stats[2] += a.TookMinutes;
            }
            if(a.Category.equals(categories[3])){
                stats[3] += a.TookMinutes;
            }
            if(a.Category.equals(categories[4])){
                stats[4] += a.TookMinutes;
            }
            if(a.Category.equals(categories[5])){
                stats[5] += a.TookMinutes;
            }
            if(a.Category.equals(categories[6])){
                stats[6] += a.TookMinutes;
            }
        }

        String statistics = "Общее время затраченное на\n" +
                "Учебу: " + stats[0]/60 + " ч " + (stats[0] - stats[0]/60*60) + " мин\n" +
                "Отдых: " + stats[1]/60 + " ч " + (stats[1] - stats[1]/60*60) + " мин\n" +
                "Еду: " + stats[2]/60 + " ч " + (stats[2] - stats[2]/60*60) + " мин\n" +
                "Сон: " + stats[3]/60 + " ч " + (stats[3] - stats[3]/60*60) + " мин\n" +
                "Работу: " + stats[4]/60 + " ч " + (stats[4] - stats[4]/60*60) + " мин\n" +
                "Хобби: " + stats[5]/60 + " ч " + (stats[5] - stats[5]/60*60) + " мин\n" +
                "Другое: " + stats[6]/60 + " ч " + (stats[6] - stats[6]/60*60) + " мин\n";

        TextView statsView = findViewById(R.id.statsView);
        statsView.setText(statistics);
    }
}