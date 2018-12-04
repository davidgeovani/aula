package br.com.david_fabio.pics_search.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.Arrays;

import br.com.david_fabio.pics_search.MainActivity;
import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.model.Perfil;
import br.com.david_fabio.pics_search.util.PersistenciaUtil;

public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    ImageView imageView;
    TextView txtUsername, txtEmail;
    String user, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        loginButton = findViewById(R.id.login_button);
        imageView = findViewById(R.id.imageView);
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);


        Button btn = findViewById(R.id.login_button);
        btn.setOnClickListener((View view) -> {
            Perfil perfil = new Perfil();
            user = txtUsername.getText().toString();
            email = txtEmail.getText().toString();

            perfil.setNome(user);
            perfil.setEmail(email);

        });



        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

        if (!loggedOut) {
            Picasso.with(this).load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
            Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());
            logado();
            //Using Graph API
            getUserProfile(AccessToken.getCurrentAccessToken());
        }

        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        callbackManager = CallbackManager.Factory.create();




        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {



            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                loginResult.getAccessToken();
                loginResult.getRecentlyDeniedPermissions();
                loginResult.getRecentlyGrantedPermissions();
                boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
                Log.d("API123", loggedIn + " ??" );
                logado();

            }


            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }//fim oncreate

    private void logado() {
        PersistenciaUtil.setLogado(this, true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data );


        startActivityForResult(new Intent(this, TermosActivity.class), requestCode);

       // StartAPP();

    }

    private void StartAPP() {


        Intent intent = new Intent(this, ControlActivity.class);
        startActivity(intent);


    }








    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, (object, response) -> {
                    Log.d("TAG", object.toString());
                    try {
                        String first_name = object.getString("first_name");
                        String last_name = object.getString("last_name");
                        String email = object.getString("email");
                        String id = object.getString("id");
                        String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";

                        txtUsername.setText("First Name: " + first_name + "\nLast Name: " + last_name);
                        txtEmail.setText(email);
                        Picasso.with(LoginActivity.this).load(image_url).into(imageView);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }






}
