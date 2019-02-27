package go.faddy.com.agin2;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Date;
import java.util.Objects;

import static go.faddy.com.agin2.CalenderFrag.STRING_EXTRA;

public class Pop extends Activity {
    RadioButton filesYes, filesNo, radioButton;
    RadioGroup radioGroup;
    ImageButton button;
    private static final int RQS_OPEN = 1;
    Button buttonOpen;
    TextView textUri;
    TextView txt;
    String[] typeList = {"Class-Test", "Home-Work", "Assignment", "Lab-Report"};
    String[] subjectList = {"Database Management", "Database Management (Sessional)", "Compiler",
            "Compiler (Sessional)", "Microprocessors & Micro-controllers", "Microprocessors & " +
            "Micro-controllers(Sessional)", "Theory of Computation", "Assembely Language" +
            " Programming(Sessional)", "Computer Network", "Computer Network(Sessional)"
    };
    View.OnClickListener button_ =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("*/*");
                    String[] extraMimeTypes = {"image/*", "video/*", "audio/*", "text/*",
                            "application/*", "./*", "camera/*"};
                    intent.putExtra(Intent.EXTRA_MIME_TYPES, extraMimeTypes);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    startActivityForResult(intent, RQS_OPEN);
                    Toast.makeText(Pop.this,
                            "Single-selection: Tap on any file.\n" +
                                    "Multi-selection: Tap & Hold on the first file, " +
                                    "tap for more, tap on OPEN to finish.",
                            Toast.LENGTH_LONG).show();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);
        textUri = (TextView) findViewById(R.id.filenames);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        //getting date intents
        Bundle bundle = getIntent().getExtras();
        Long good = bundle.getLong(STRING_EXTRA);
        Date today = new Date(good);
        String dayOfTheWeek = (String) DateFormat.format("EEEE", today);
        String day = (String) DateFormat.format("dd", today);
        String monthString = (String) DateFormat.format("MMM", today);
        String monthNumber = (String) DateFormat.format("MM", today);
        String year = (String) DateFormat.format("yyyy", today);
        Toast.makeText(this, day + "\n" + monthNumber + "\n" + year, Toast.LENGTH_SHORT).show();


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

        //Files spinner

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
        button.setOnClickListener(button_);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        StringBuilder s = new StringBuilder();
        if (resultCode == RESULT_OK) {
            if (requestCode == RQS_OPEN) {
                ClipData clipData = data.getClipData();
                if (clipData == null) {
                    s = new StringBuilder("clipData == null\n");
                    s.append(Objects.requireNonNull(data.getData()).toString());
                } else {
                    s = new StringBuilder("clipData != null\n");
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        s.append(uri.toString()).append("\n");
                    }
                }
            }
        }
        textUri.setText(s.toString());
    }
}
