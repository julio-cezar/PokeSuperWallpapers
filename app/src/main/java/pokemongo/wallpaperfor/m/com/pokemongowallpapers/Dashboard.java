package pokemongo.wallpaperfor.m.com.pokemongowallpapers;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Dashboard extends AppCompatActivity {
    Button btPikachu, btBrock, btRocket, btMisty;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        InitViews();

        if (ContextCompat.checkSelfPermission(Dashboard.this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Dashboard.this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    14);

        }

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7040951679419231~3080221500");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("F0777154C5F794B0B7A1EF4120502169")
                .build();

        mAdView.loadAd(adRequest);

    }

    private void InitViews() {
        btPikachu = (Button) findViewById(R.id.bt_pikachu);
        btBrock = (Button) findViewById(R.id.bt_brock);
        btRocket = (Button) findViewById(R.id.bt_rocket);
        btMisty = (Button) findViewById(R.id.bt_misty);
    }

    public void selecionarOpcao(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.bt_rocket:
                i = new Intent(Dashboard.this, Wallpaper.class);
                i.putExtra("categoria", "rocket");
                startActivity(i);
                finish();
                break;
            case R.id.bt_brock:
                i = new Intent(Dashboard.this, Wallpaper.class);
                i.putExtra("categoria", "brock");
                startActivity(i);
                finish();
                break;
            case R.id.bt_misty:
                i = new Intent(Dashboard.this, Wallpaper.class);
                i.putExtra("categoria", "misty");
                startActivity(i);
                finish();
                break;
            case R.id.bt_pikachu:
                i = new Intent(Dashboard.this, Wallpaper.class);
                i.putExtra("categoria", "pikachu");
                startActivity(i);
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mAdView.pause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }

}
