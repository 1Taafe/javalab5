package by.bstu.javalab5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialog2 extends AppCompatDialogFragment {

    @NonNull
    public String Name;
    public String Desc;
    public String Image;
    public String Category;
    public Integer Time;
    public MyDialog2(String name, String desc, String image, String category, Integer time){
        Name = name;
        Desc = desc;
        Image = image;
        Category = category;
        Time = time;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Подтверждение действия";
        String message = "Вы действительно хотите изменить активность?";
        String button1String = "Да";
        String button2String = "Отмена";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((EditActivity) getActivity()).editAction(Name, Desc, Image, Category, Time);
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //((MainActivity) getActivity()).cancelClicked();
            }
        });
        builder.setCancelable(true);

        return builder.create();
    }
}
