package dem.rodcab.pc01dam21100744r

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = "Login"
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btLogin: Button = findViewById(R.id.btLogin)
        val emailSuccess = "invitado@android.com"
        val passwordSuccess = "123456"

        btLogin.setOnClickListener{
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email == emailSuccess && password == passwordSuccess) {
                val intent  = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                val rootView = findViewById<View>(android.R.id.content)
                Snackbar.make(rootView, "Credenciales incorrectas", Snackbar.LENGTH_SHORT).show();
                etEmail.error = "Credenciales incorrectas"
                etPassword.error = "Credenciales incorrectas"
                etEmail.requestFocus()
            }

        }

    }
}