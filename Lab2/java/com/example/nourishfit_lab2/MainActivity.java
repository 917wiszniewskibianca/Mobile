package com.example.nourishfit_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText usernameBox;
    private EditText passwordBox;
    private Button logInButton;
    private Button signUpButton;

    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpLogInClickListener();
        setUpSignUpClickListener();
        setUpForgotPasswordClickListener();
    }

    private void findViews() {
        this.usernameBox = findViewById(R.id.edit_text_username);
        this.passwordBox = findViewById(R.id.edit_text_password);
        this.logInButton = findViewById(R.id.button_log_in);
        this.signUpButton = findViewById(R.id.button_sign_up);
        this.forgotPassword = findViewById(R.id.text_view_forgot_password);
    }

    private void setUpLogInClickListener() {

        this.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkUsernameAndPassword()) {
                    Intent logInIntent = new Intent(MainActivity.this, HomePageActivity.class);
                    startActivity(logInIntent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Login Error")
                            .setMessage("Username and password are incorrect.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss(); // Close the dialog when OK is clicked
                                }
                            })
                            .show(); // Add this to display the dialog
                }
            }
        });
    }



    private void setUpSignUpClickListener() {

        this.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

    }

 //////////////////////////////////////////////////////// Implement those 2 from below \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




    private void setUpForgotPasswordClickListener() {
        // set up the forgetPassword verification
        // send to a page where the user introduces his email address and we send it a verification
        // email in order to change the password

        this.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private boolean checkUsernameAndPassword() {
        // check against the database the username and the password

        String username = this.usernameBox.getText().toString();
        String password = this.passwordBox.getText().toString();

        // implement the checking
        return true;
    }
}