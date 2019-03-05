package go.faddy.com.agin2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.flags.impl.SharedPreferencesFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference registredRef = FirebaseDatabase.getInstance().getReference();
    ProgressBar progressBar;
    EditText email, id_no, pass, pass_again;
    Boolean flag = false;
    Button btn;
    TextView txt;
    static int nav_ID;
    static String nav_NAME;
    SharedPreferences.Editor editor;


    static class for_id {
        static boolean Student_id_list(int x) {
            HashMap<Integer, String> hmap = new HashMap<Integer, String>();
            hmap.put(17104003, "Tasmin Tabussum");
            hmap.put(17104005, "Mohona Tasnim Promy");
            hmap.put(17104006, "Redwan Ahmed");
            hmap.put(17104007, "Abdula Ibnae Masud ");
            hmap.put(17104008, "Snehasish Kumar Kundu");
            hmap.put(17104009, "Tasnia Ibnat Masud");
            hmap.put(17104010, "Akash Kumar Pal");
            hmap.put(17104011, "Md. Tanvir Faysal");
            hmap.put(17104012, "Md. Asadullah Tuhin");
            hmap.put(17104013, "Rahnuma Farhana");
            hmap.put(17104014, "Md. Ashraful Alam Rashed");
            hmap.put(17104015, "Akmar Anjum Ann");
            hmap.put(17104016, "Shumaya Sultana");
            hmap.put(17104017, "Partho Saha");
            hmap.put(17104018, "Most Fahamida Khatun");
            hmap.put(17104019, "Enamul Kabir");
            hmap.put(17104020, "Rehana Aunjoli");
            hmap.put(17104021, "Breeti Suaibia");
            hmap.put(17104022, "Rakibul Hasan ");
            hmap.put(17104023, "Hasnahena Muntarim Mim");
            hmap.put(17104024, "Md. Atikur Rashid");
            hmap.put(17104025, "Hassan Md. Zubair");
            hmap.put(17104026, "Md. Muktadir Mahmud Tashar");
            hmap.put(17104027, "Shafayet Alam");
            hmap.put(17104028, "Ummey Khadiza");
            hmap.put(17104029, "Md. Mehadi Hasan");
            hmap.put(17104030, "Tasmin Tamanna");
            hmap.put(17104031, "Farzana Binte Forhad");
            hmap.put(17104032, "Asif Imran Chowdhury");
            hmap.put(17104033, "Labonna Islam");
            hmap.put(17104034, "Md. Jahangir Hossein");
            hmap.put(17104035, "Barnita Basak Trisha");
            hmap.put(17104036, "Shahrin Sumona");
            hmap.put(17104037, "Samia Tanous");
            hmap.put(17104038, "Md.Sadakat Hussain Fahad");
            hmap.put(17104039, "Ashikur Rahman");
            hmap.put(17104040, "Srayoshi Bashed Mirza");
            hmap.put(17104041, "Tiham Hossain Khan");
            hmap.put(17104042, "Monira Perveen");
            hmap.put(17104044, "Subarna Saha");
            hmap.put(17104045, "Ridhita Saha");
            hmap.put(17104046, "Sourav kumar Sarkar");
            hmap.put(17104047, "Md. Tanjil Mahamud Nion");
            hmap.put(17104048, "Tahmina Tahrim");
            hmap.put(17104049, "Rayhanuzzaman");
            hmap.put(17104050, "Shahin Ahmed Saad");
            hmap.put(17104051, "Abdur Rakib Rony");
            hmap.put(17104052, "Iffa Tabassum Talukder");
            hmap.put(17104053, "Meher-Un-Nesa Meghla");
            hmap.put(17104054, "Md. Taufiqul Islam");
            hmap.put(17104055, "Abdullah Al Imran");
            hmap.put(17104056, "Jahid  Hasan");
            hmap.put(17104057, "Avik Roy");
            hmap.put(17104059, "Farhana Tarajji Payel");
            hmap.put(17104060, "Mahtashan  Mohammad  Mridul");
            hmap.put(17104061, "Md. Rakib Raihan");
            hmap.put(17104062, "Md.  Mohtasim Shariar");
            hmap.put(17104063, "Nusrat Afrin Trisha");
            hmap.put(17104064, "Md. Sujan Molla");
            hmap.put(17104065, "Md. Maruf");
            hmap.put(17104066, "Md. Abdullah Al Mamun");
            hmap.put(17104067, "Md. Nasir Uddin");
            hmap.put(17104068, "Tamim");
            nav_NAME = hmap.get(x);
            nav_ID = x;
            return hmap.containsKey(x);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        id_no = findViewById(R.id.id);
        pass = findViewById(R.id.password);
        pass_again = findViewById(R.id.password2);
        btn = findViewById(R.id.email_sign_in_button);
        txt = findViewById(R.id.forgot);
        final SharedPreferences sp;
        progressBar = findViewById(R.id.progressar);
        final SharedPreferences[] good = new SharedPreferences[1];
        sp = getSharedPreferences("login", MODE_PRIVATE);
        if (sp.getBoolean("logged", false)) {
            goToMainActivity();
        }

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(LoginActivity.this, Forgot_Pass.class);
//                startActivity(i);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(isConnectedToInternet(getApplicationContext()))) {
                    Snackbar.make(view, "Check your internet connection first !!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else {
                    if (TextUtils.isEmpty(id_no.getText().toString().trim()) || TextUtils.isEmpty(pass.getText().toString().trim()) || TextUtils.isEmpty(email.getText().toString().trim()) || TextUtils.isEmpty(pass_again.getText().toString().trim())) {
                        Snackbar.make(view, "Something is null check again", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        int x = Integer.parseInt(id_no.getText().toString().trim());
                        if (for_id.Student_id_list(x)) {
                            if (pass.getText().toString().trim().equals(pass_again.getText().toString().trim())) {
                                mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),
                                        pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(LoginActivity.this, "Registration Sucessful", Toast.LENGTH_SHORT).show();
                                            goToMainActivity();
                                            sp.edit().putBoolean("logged", true).apply();
                                            good[0] = getSharedPreferences("login", MODE_PRIVATE);
                                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                            editor = sharedPreferences.edit();
                                            editor.putString("username", nav_NAME).putString("useID", String.valueOf(nav_ID)).apply();
                                            finish();
                                        } else {
                                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                                Toast.makeText(LoginActivity.this, "You are already registred", Toast.LENGTH_SHORT).show();
                                                mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(LoginActivity.this, "You would have been logged in by now", Toast.LENGTH_SHORT).show();
                                                            goToMainActivity();
                                                            sp.edit().putBoolean("logged", true).apply();
                                                            good[0] = getSharedPreferences("login", MODE_PRIVATE);
                                                            editor = good[0].edit();
                                                            editor.putString("username", nav_NAME).putString("useID", String.valueOf(nav_ID)).apply();
                                                            finish();
                                                        } else {
                                                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    }
                                });
                            } else {
                                pass_again.setError("The passwords didn't match");
                            }
                        } else {
                            id_no.setError("Invalid ID");
                        }
                    }
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("name", nav_NAME);
        registredRef.child("student").child(String.valueOf(nav_ID)).child("name").setValue(nav_NAME);
        registredRef.child("student").child(String.valueOf(nav_ID)).child("registered").setValue("yes");
        i.putExtra("id", nav_ID);
        startActivity(i);
    }

    private boolean isConnectedToInternet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
