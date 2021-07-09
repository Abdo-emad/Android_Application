package com.example.mycompleteproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText txt_words;
    TextView txt_size;

    Button btn_big;
    Button btn_small;
    CheckBox ch_bold;
    CheckBox ch_under;
    Spinner sp_color;
    Spinner sp_font;
    RadioButton r_ltr;
    RadioButton r_rtl;
    RadioButton r_center;
    EditText edit_file;
    Button btn_save;
    Button btn_new;
    Button btn_get;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_words=(EditText)findViewById(R.id.txt_words);
        txt_size =(TextView)findViewById(R.id.txt_size);
        btn_big =(Button)findViewById(R.id.btn_big);
        btn_small = (Button)findViewById(R.id.btn_small);
        ch_bold=(CheckBox)findViewById(R.id.ch_bold);
        ch_under=(CheckBox)findViewById(R.id.ch_under);
        sp_color=(Spinner)findViewById(R.id.sp_color);
        sp_font=(Spinner)findViewById(R.id.sp_font);
         r_ltr=(RadioButton)findViewById(R.id.r_ltr);
         r_rtl=(RadioButton)findViewById(R.id.r_rtl);
         r_center=(RadioButton)findViewById(R.id.r_center);
         edit_file =(EditText)findViewById(R.id.edit_file);
         btn_save =(Button)findViewById(R.id.btn_save);
         btn_new=(Button)findViewById(R.id.btn_new);
         btn_get = (Button)findViewById(R.id.btn_get);

         set_color();
         set_Font();


         ch_bold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 set_bold();
             }
         });
         ch_under.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 set_underline();
             }
         });
        sp_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choseonecolor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_font.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choseonefont();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    btn_big.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Change_Text('+');
        }
    });
    btn_small.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Change_Text('-');
        }
    });
    r_ltr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Check_Radio();
        }
    });
    r_rtl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Check_Radio();
        }
    });
    r_center.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Check_Radio();
        }
    });
btn_new.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        New_file();
    }
});
btn_save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Save_file();
    }
});
    }
    protected  void set_color(){
        String [] color =  {   "YELLOW",
                                "RED",
                                "BLACK",
                                "WHITE",
                                "BLUE",
                                "ROUGE",
                                "ROSE",
                                "NAVY",
                                "BROWN",
                                "PINK",
                                "ORANGE",
                                "GREEN",
                                "GRAY",
                                "ALPHA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item ,color);
        sp_color.setAdapter(adapter);
    }
    protected  void set_Font(){
        String [] font={"sanserif"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,font);
        sp_font.setAdapter(adapter);

    }

    protected  void set_bold(){
        if(ch_bold.isChecked()){
            txt_words.setTypeface(null, Typeface.BOLD);
        }else{
            txt_words.setTypeface(null,Typeface.NORMAL);
        }
    }
    protected  void set_underline(){
        if(ch_under.isChecked()){
            txt_words.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        }else
        {
            txt_words.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
        }
    }
    protected  void choseonecolor(){
        String onecolor= sp_color.getSelectedItem().toString();
        switch (onecolor){
            case "YELLOW":
                txt_words.setTextColor(getResources().getColor(R.color.YELLOW));
                break;
            case "RED":
                txt_words.setTextColor(getResources().getColor(R.color.RED));
                break;
            case "BLACK":
                txt_words.setTextColor(getResources().getColor(R.color.BLACK));
                break;
            case "WHITE":
                txt_words.setTextColor(getResources().getColor(R.color.WHITE));
            case "ROUGE":
                txt_words.setTextColor(getResources().getColor(R.color.ROUGE));
                break;
            case "ROSE":
                txt_words.setTextColor(getResources().getColor(R.color.ROSE));
                break;
            case "NAVY":
                txt_words.setTextColor(getResources().getColor(R.color.NAVY));
                break;
            case "BROWN":
                txt_words.setTextColor(getResources().getColor(R.color.BROWN));
                break;
            case "PINK":
                txt_words.setTextColor(getResources().getColor(R.color.PINK));
                break;
            case "ORANGE":
                txt_words.setTextColor(getResources().getColor(R.color.ORANGE));
                break;
            case "GREEN":
                txt_words.setTextColor(getResources().getColor(R.color.GREEN));
                break;
            case "GRAY":
                txt_words.setTextColor(getResources().getColor(R.color.GRAY));
                break;
            case "ALPHA":
                txt_words.setTextColor(getResources().getColor(R.color.ALPHA));
                break;


        }
    }
    protected  void choseonefont(){
        String sfont = sp_font.getSelectedItem().toString();
        Typeface tf = Typeface.SANS_SERIF;
        switch (sfont){
            case "sanserif":
                tf=Typeface.SANS_SERIF;
                break;
            case "arial":
                tf=Typeface.createFromAsset(getAssets(),"arial.ttf");
                break;

        }




    }

   protected  void Change_Text(char SmallOrBig){
       int size = Integer.parseInt(txt_size.getText().toString());
       if(SmallOrBig == '+') size++;
       else size--;
       txt_words.setTextSize(size);
       txt_size.setText(size+"");
   }
   protected  void Check_Radio(){
        if(r_rtl.isChecked()){
            txt_words.setGravity(Gravity.RIGHT);
        }else if(r_ltr.isChecked()){
            txt_words.setGravity(Gravity.LEFT);

        }else{
            txt_words.setGravity(Gravity.CENTER);
        }
   }
   protected  void New_file(){
        txt_words.setText("");
        txt_size.setTextSize(14);
        btn_big.setTextSize(14);
        btn_small.setTextSize(14);
        ch_bold.setChecked(false);
        ch_under.setChecked(false);
        sp_color.setSelection(0);
        sp_font.setSelection(0);
        r_ltr.setChecked(true);
        edit_file.setText("File Name");
   }
   protected void Save_file(){
        try {


            String str_path = Environment.getExternalStorageDirectory().getPath() + "/My Complete Project";
            File f = new File(str_path);
            f.mkdir();
            PrintWriter pw = new PrintWriter(str_path + "/" + edit_file.getText() + ".txt");
            pw.write(txt_words.getText().toString());
            pw.close();
            PrintWriter pw_Setting=new PrintWriter(str_path+"/"+edit_file.getText()+"Setting.txt");
            String str = txt_size.getText()
                    + "/n" + ch_bold.isChecked()
                    + "/n" + ch_under.isChecked()
                    + "/n" + sp_color.getSelectedItem()
                    + "/n" + sp_font.getSelectedItem()
                    + "/n" + r_ltr.isChecked()
                    + "/n" + r_rtl.isChecked()
                    + "/n" + r_center.isChecked();
            pw_Setting.write(str);
            pw_Setting.close();
            Toast.makeText(this, "File Is Saved", Toast.LENGTH_SHORT).show();
        }catch (Exception c ){
            Toast.makeText(this, c.getMessage(), Toast.LENGTH_LONG).show();
        }
   }
   public boolean Checkpermisson (String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check == PackageManager.PERMISSION_GRANTED);
   }


    }

