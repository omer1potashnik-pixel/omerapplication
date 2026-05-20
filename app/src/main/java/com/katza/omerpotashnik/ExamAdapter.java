package com.katza.omerpotashnik;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ExamAdapter extends ArrayAdapter<Exam> {

    private Context context;
    private List<Exam> examList;

    public ExamAdapter(Context context, List<Exam> examList) {
        super(context, R.layout.list_item_exam, examList);
        this.context = context;
        this.examList = examList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. ניפוח (Inflate) של ה-XML לשורת תצוגה אם היא עדיין לא קיימת
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_exam, parent, false);
        }

        // 2. קבלת האובייקט הנוכחי לפי המיקום ברשימה
        Exam currentExam = examList.get(position);

        // 3. מציאת רכיבי ה-UI מתוך ה-convertView
        ImageView imgStatus = convertView.findViewById(R.id.imgStatus);
        TextView txtName = convertView.findViewById(R.id.txtExamName);
        TextView txtScore = convertView.findViewById(R.id.txtExamScore);

        // 4. השמת הנתונים ברכיבים המתאימים
        txtName.setText(currentExam.getName());
        txtScore.setText("ציון: " + currentExam.getScore());

        // שינוי התמונה בהתאם להצלחה או כישלון במבחן
        // שינוי התמונה והצבע בהתאם להצלחה או כישלון במבחן באמצעות אייקונים מובנים
        if (currentExam.isPassed()) {
            // אייקון מובנה של "וי" (Checkmark)
            imgStatus.setImageResource(android.R.drawable.checkbox_on_background);

            // צביעת האייקון בירוק מובנה של המערכת
            imgStatus.setColorFilter(context.getResources().getColor(android.R.color.holo_green_dark));
        } else {
            // אייקון מובנה של "סימן אזהרה" או איקס (נשתמש בסימן התראה/חסימה של המערכת)
            imgStatus.setImageResource(android.R.drawable.ic_delete);

            // צביעת האייקון באדום מובנה של המערכת
            imgStatus.setColorFilter(context.getResources().getColor(android.R.color.holo_red_dark));
        }

        // 5. החזרת השורה המוכנה להצגה
        return convertView;
    }
}
