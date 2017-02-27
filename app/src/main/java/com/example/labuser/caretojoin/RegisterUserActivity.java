package com.example.labuser.caretojoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cyoo0706 on 2/22/17.
 */

public class RegisterUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        private FirebaseAuth mAuth;
// ...
        mAuth = FirebaseAuth.getInstance();
    }
    private FirebaseAuth.AuthStateListener mAuthListener;

// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        // ...
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
