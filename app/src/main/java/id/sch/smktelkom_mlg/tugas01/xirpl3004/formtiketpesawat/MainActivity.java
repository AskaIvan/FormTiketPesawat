package id.sch.smktelkom_mlg.tugas01.xirpl3004.formtiketpesawat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bPesan;
    TextView tvHasil, tvNama, tvMakan, tvAsal, tvTujuan;
    RadioGroup rgKelas;
    CheckBox cbInt, cbInd, cbTra;
    Spinner spAsal, spTujuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bPesan = (Button) findViewById(R.id.btnPesan);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        cbInt = (CheckBox) findViewById(R.id.checkBoxInter);
        cbInd = (CheckBox) findViewById(R.id.checkBoxIndo);
        cbTra = (CheckBox) findViewById(R.id.checkBoxTra);
        spAsal = (Spinner) findViewById(R.id.spinnerAsal);
        spTujuan = (Spinner) findViewById(R.id.spinnerTujuan);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvMakan = (TextView) findViewById(R.id.textViewMakan);
        tvAsal = (TextView) findViewById(R.id.textViewAsal);
        tvTujuan = (TextView) findViewById(R.id.textViewTujuan);
        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doTA();
                doClick();
                doMakan();

            }
        });
    }

    private void doTA() {
        tvAsal.setText("Keberangkatan : " + spAsal.getSelectedItem().toString() + "\n");
        tvTujuan.setText("Tujuan : " + spTujuan.getSelectedItem().toString() + "\n");
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
            tvHasil.setText("Kelas Anda : " + hasil + "\n");
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

    private void doMakan() {
        String makan = "Makanan yang anda pilih:\n";
        int startlen = makan.length();
        if (cbInt.isChecked())
            makan += cbInt.getText() + "\n";
        if (cbInd.isChecked())
            makan += cbInd.getText() + "\n";
        if (cbTra.isChecked())
            makan += cbTra.getText() + "\n";

        if (makan.length() == startlen)
            makan += "Tidak ada pada Pilihan";

        tvMakan.setText(makan);

    }
}
