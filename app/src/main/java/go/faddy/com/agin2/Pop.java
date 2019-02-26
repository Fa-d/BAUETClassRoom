package go.faddy.com.agin2;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Pop extends Activity {
    RadioButton filesYes, filesNo, radioButton;
    RadioGroup radioGroup;
    ImageButton button;


    TextView txt;
    String[] typeList = {"Class-Test", "Home-Work", "Assignment", "Lab-Report"};
    String[] subjectList = {"Database Management", "Database Management (Sessional)", "Compiler",
    "Compiler (Sessional)", "Microprocessors & Micro-controllers", "Microprocessors & Micro-controllers(Sessional)",
            "Theory of Computation", "Assembely Language Programming(Sessional)",
            "Computer Network", "Computer Network(Sessional)"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int)(height*.7));


        //type drop down
        ArrayAdapter<String> typearrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, typeList);
        MaterialBetterSpinner typebetterSpinner = findViewById(R.id.typespinner);
        typebetterSpinner.setAdapter(typearrayAdapter);
        typebetterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pop.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //Subject dropdown
        ArrayAdapter<String> subjectarrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, subjectList);
        MaterialBetterSpinner subjectbetterSpinner = findViewById(R.id.subjectspinner);
        subjectbetterSpinner.setAdapter(subjectarrayAdapter);
        subjectbetterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pop.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });


        radioGroup = findViewById(R.id.files_grp);
        filesYes = findViewById(R.id.files_yes);
        filesNo = findViewById(R.id.files_no);
        button = findViewById(R.id.files_button);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                if(radioButton == filesYes){
                    button.setVisibility(View.VISIBLE);
                }else{
                    button.setVisibility(View.GONE);
                }
            }
        });

    }
}
