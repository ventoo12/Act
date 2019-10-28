package com.example.Act;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.Act.R;

public class StopWatchActivity extends Activity implements Button.OnClickListener {

    private EditText et;
    private Button btn;
    private Handler handler;
    private Vibrator vibrator;
    private long[] pattern = {500, 500, 1000, 1000};

    ArrayAdapter<CharSequence> adspin1, adspin2;
    String choice_do="";
    String choice_se="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final Spinner spin1 = (Spinner)findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner2);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.date_kind, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object obj = adapterView.getItemAtPosition(i);
                SharedPreferences prefs = getSharedPreferences("object",0);
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("object", obj.toString());
                prefsEditor.commit();


                if (adspin1.getItem(i).equals("코어")) {
                    choice_do = "코어";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_core, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                } else if (adspin1.getItem(i).equals("가슴")) {
                    choice_do = "가슴";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_top_name, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("어깨")) {
                    choice_do = "어깨";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_sh, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("복부")) {
                    choice_do = "복부";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_body, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("등")) {
                    choice_do = "등";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_back, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("상완/전완")) {
                    choice_do = "상완/전완";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_arms, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("하체")) {
                    choice_do = "하체";
                    adspin2 = ArrayAdapter.createFromResource(StopWatchActivity.this, R.array.date_bottom_name, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });


                }
                }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        Spinner setSpinner = (Spinner) findViewById(R.id.set);

        ArrayAdapter setAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_set, android.R.layout.simple_spinner_item);
        setAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setSpinner.setAdapter(setAdapter);

        Spinner countSpinner = (Spinner) findViewById(R.id.count);

        ArrayAdapter countAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_count, android.R.layout.simple_spinner_item);
        countAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countSpinner.setAdapter(countAdapter);


        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        handler = new Handler() {
            public void handleMessage(Message msg) {
                toast("휴식 종료");
                startVibrate();
            }
        };
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btn.setOnClickListener(this);

    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void startVibrate() {
        vibrator.vibrate(pattern, 0);
        AlertDialog.Builder builder = new AlertDialog.Builder(StopWatchActivity.this);
        builder.setTitle("휴식 시간 종료")
                .setPositiveButton("알겠따", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        toast("알람 종료");
                        stopVibrate();
                    }
                })
                .setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void stopVibrate() {
        vibrator.cancel();
    }

    public void onClick(View v) {
        final int seconds = Integer.parseInt(et.getText().toString());
        if (seconds <= 0) {
            toast("숫자만 입력하새오..");
            return;
        }
        (new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000 * seconds);
                    Message msg = handler.obtainMessage();
                    msg.arg1 = seconds;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).start();
    }
}