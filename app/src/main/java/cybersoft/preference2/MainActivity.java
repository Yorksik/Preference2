package cybersoft.preference2;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave;
    Button btnRead;
    SharedPreferences preference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText)findViewById(R.id.editText);
        btnRead = (Button)findViewById(R.id.btnRead);
        btnSave = (Button)findViewById(R.id.btnSave);
        preference = getPreferences(MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preference.edit();
                editor.putString("Text",editText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"Дааные с этого активити успешно записаны " +
                        "и будут использоваться при запуске этого активити " +
                        "постоянно!!",Toast.LENGTH_SHORT).show();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preference.contains("Text")){
                    editText.setText(preference.getString("Text",""));
                }else{
                    Toast.makeText(getApplicationContext(), "В preference ничего нет!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
