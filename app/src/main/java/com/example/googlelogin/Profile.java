package com.example.googlelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
private Button logout;
private TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

logout=findViewById(R.id.logout);
name=findViewById(R.id.name);
email=findViewById(R.id.mail);

        GoogleSignInAccount signInAccount= GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null)
        {   name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());

        }
logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();

        Intent intent=new Intent(v.getContext(),MainActivity.class);
        startActivity(intent);
    }
});
    }
}