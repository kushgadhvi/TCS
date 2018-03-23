package com.gadhvi.tcs;

import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.view.View;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText email_,password_;
    Button auth_;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Link Id to it's Object
        email_ = (EditText) findViewById(R.id.email);
        password_ = (EditText) findViewById(R.id.password);
        auth_ = (Button) findViewById(R.id.auth);

    /*    auth_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_.getText().toString().equals("pravin@gmail.com")&&
                        password_.getText().toString().equals("8237366307"))
                {
                    Intent n=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(n);
                }
            }
        });
    }}
*/

        mAuth =FirebaseAuth.getInstance();
        auth_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =email_.getText().toString().trim();
                String password =password_.getText().toString().trim();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
                {

                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                startActivity(new Intent(Login.this,MainActivity.class));
                                Login.this.finish();

                            }
                            else {
                                Toast.makeText(Login.this,"Email or Password incorrect",Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(Login.this, "Please Enter Fields Correctly ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}