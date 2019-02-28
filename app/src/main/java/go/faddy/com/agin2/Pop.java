package go.faddy.com.agin2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static go.faddy.com.agin2.Fragments.CalenderFrag.STRING_EXTRA;

public class Pop extends Activity {
    RadioButton filesYes, filesNo, radioButton;
    RadioGroup radioGroup;
    ImageButton button;
    private static final int RQS_OPEN = 1;
    Button buttonOpen;
    EditText editText;
    TextView textUri;
    ArrayList<Uri> uris = new ArrayList<Uri>();
    String typeUp, subUp, desrpUp;
    DatabaseReference mRootref = FirebaseDatabase.getInstance().getReference();
    StorageReference ster;
    ProgressDialog progressDialog;
    View.OnClickListener button_ = new View.OnClickListener() {
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


    String[] typeList = {"Class-Test", "Home-Work", "Assignment", "Lab-Report"};
    String[] subjectList = {"Database Management", "Database Management (Sessional)", "Compiler",
            "Compiler (Sessional)", "Microprocessors & Micro-controllers", "Microprocessors & " +
            "Micro-controllers(Sessional)", "Theory of Computation", "Assembely Language" +
            " Programming(Sessional)", "Computer Network", "Computer Network(Sessional)"
    };
    private List<String> fileNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);
        textUri = findViewById(R.id.filenames);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        fileNameList = new ArrayList<>();
        ster = FirebaseStorage.getInstance().getReference();
        mRootref.orderByChild("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ddsp1 : dataSnapshot.getChildren()) {
                    for (DataSnapshot ddsp2 : dataSnapshot.getChildren()) {

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //getting date intents
        Bundle bundle = getIntent().getExtras();
        Long good = bundle.getLong(STRING_EXTRA);
        Date today = new Date(good);
        String dayOfTheWeek = (String) DateFormat.format("EEEE", today);
        String day = (String) DateFormat.format("dd", today);
        String monthString = (String) DateFormat.format("MMM", today);
        String monthNumber = (String) DateFormat.format("MM", today);
        String year = (String) DateFormat.format("yyyy", today);
        Toast.makeText(this, day + "\n" + monthNumber + "\n" + year,
                Toast.LENGTH_SHORT).show();


        //type drop down
        ArrayAdapter<String> typearrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, typeList);
        MaterialBetterSpinner typebetterSpinner = findViewById(R.id.typespinner);
        typebetterSpinner.setAdapter(typearrayAdapter);
        typebetterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                typeUp = parent.getItemAtPosition(position).toString();
                Toast.makeText(Pop.this, typeUp, Toast.LENGTH_SHORT).show();
            }
        });

        //Subject dropdown
        ArrayAdapter<String> subjectarrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, subjectList);
        MaterialBetterSpinner subjectbetterSpinner = findViewById(R.id.subjectspinner);
        subjectbetterSpinner.setAdapter(subjectarrayAdapter);
        subjectbetterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                subUp = parent.getItemAtPosition(position).toString();
                Toast.makeText(Pop.this, subUp, Toast.LENGTH_SHORT).show();
            }
        });

        // text from description box
        editText = findViewById(R.id.description);



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


        //for uploading posts
        findViewById(R.id.post_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getVisibility() == View.VISIBLE) {
                    progressDialog = new ProgressDialog(Pop.this);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setTitle("Uploading file...");
                    progressDialog.setProgress(0);
                    progressDialog.show();
                    final DatabaseReference conditionRef = mRootref.child("posts").child("type").child(typeUp.trim()).push();
                    DatabaseReference dateRef =  conditionRef.child("date");
                    dateRef.child("day").setValue(day);
                    dateRef.child("month").setValue(monthNumber);
                    dateRef.child("year").setValue(year);
                    conditionRef.child("subject").setValue(subUp.trim());
                    desrpUp = editText.getText().toString();
                    conditionRef.child("description").setValue(desrpUp);
                    final int[] currentProgress = {0};
                    for (int i = 0; i < fileNameList.size(); i++) {
                        StorageReference filetoupload = ster.child("images").child(fileNameList.get(i));
                        final int finalI = i;
                        filetoupload.putFile(uris.get(i)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                                result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String photoStringLink = uri.toString();
                                        conditionRef.child("photos").push().setValue(photoStringLink).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(Pop.this, "Failed to upload file " + fileNameList.get(finalI), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Pop.this, "Failed to upload any files", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                currentProgress[0] = (int) (100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                progressDialog.setProgress(currentProgress[0]);
                            }
                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Toast.makeText(Pop.this, "Done upoading ", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                finish();
                            }
                        });
                    }

                } else {
                    final DatabaseReference conditionRef = mRootref.child("posts").child("type").child(typeUp.trim()).push();
                    DatabaseReference dateRef =  conditionRef.child("date");
                    dateRef.child("day").setValue(day);
                    dateRef.child("month").setValue(monthNumber);
                    dateRef.child("year").setValue(year);
//                    conditionRef.child("enddate").setValue(day + "\\" + monthNumber + "\\" + year);
                    conditionRef.child("subject").setValue(subUp.trim());
                    desrpUp = editText.getText().toString();
                    conditionRef.child("description").setValue(desrpUp).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(Pop.this, "Done upoading ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Pop.this, "Some ERROR happned", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
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
                    Uri uri = data.getData();
                    uris.add(uri);
                    String fileName = getFileName(uri);
                    fileNameList.add(fileName);
                } else {
                    s = new StringBuilder("clipData != null\n");
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        uris.add(uri);
                        String fileName = getFileName(uri);
                        fileNameList.add(fileName);
                        s.append(uri.toString()).append("\n");
                    }
                }
            }
        }
        textUri.setText(s.toString());
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getApplicationContext().getContentResolver()
                    .query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}
