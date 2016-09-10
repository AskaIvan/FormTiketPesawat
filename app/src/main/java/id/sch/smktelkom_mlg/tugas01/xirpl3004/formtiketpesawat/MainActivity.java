package id.sch.smktelkom_mlg.tugas01.xirpl3004.formtiketpesawat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bPesan;
    TextView tvHasil, tvNama;
    RadioGroup rgKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bPesan = (Button) findViewById(R.id.btnPesan);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvNama = (TextView) findViewById(R.id.textViewNama);
        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();

            }
        });
    }

    private void doClick() {
        String hasil = null;
        if (rgKelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgKelas.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih Kelas");
        } else {
            tvHasil.setText("Kelas Anda : " + hasil);
        }

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvNama.setText("Terima Kasih Saudara/i " + nama + "\n");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
