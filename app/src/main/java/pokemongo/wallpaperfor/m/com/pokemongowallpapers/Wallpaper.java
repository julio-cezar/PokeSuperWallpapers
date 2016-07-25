package pokemongo.wallpaperfor.m.com.pokemongowallpapers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Wallpaper extends AppCompatActivity implements View.OnClickListener {
    InterstitialAd mInterstitialAd;
    ImageView display, image1, image2, image3, image4, image5;
    Button setWall, bPreview;
    ImageButton ibshare, ibsave;
    int toPhone;
    Uri uri;
    Bundle extras;
    String categoria;
    TextView tvCategoria;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        extras = getIntent().getExtras();
        categoria = "no";

        if (extras != null) {
            categoria = extras.getString("categoria");
        }

        iniciarViews();
        setListeners();

        toPhone = R.drawable.icon_grande;
        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/icon_grande");
        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.icon_grande, 380, 600));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7040951679419231/3579749103");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();

        switch (categoria) {
            case "rocket":
                tvCategoria.setText(R.string.rocket);
                image1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_1, 75, 75));
                image2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_2, 75, 75));
                image3.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_3, 75, 75));
                image4.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_4, 75, 75));
                image5.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_5, 75, 75));
                break;

            case "misty":
                tvCategoria.setText(R.string.misty);
                image1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_1, 75, 75));
                image2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_2, 75, 75));
                image3.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_3, 75, 75));
                image4.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_4, 75, 75));
                image5.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_5, 75, 75));
                break;

            case "pikachu":
                tvCategoria.setText(R.string.misty);
                image1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_1, 75, 75));
                image2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_2, 75, 75));
                image3.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_3, 75, 75));
                image4.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_4, 75, 75));
                image5.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_5, 75, 75));
                break;

            case "brock":
                tvCategoria.setText(R.string.brock);
                image1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_1, 75, 75));
                image2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_2, 75, 75));
                image3.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_3, 75, 75));
                image4.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_4, 75, 75));
                image5.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_5, 75, 75));
                break;
            case "no":
                Toast.makeText(getApplicationContext(), "no Image!", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("F0777154C5F794B0B7A1EF4120502169")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void setListeners() {
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        setWall.setOnClickListener(this);
        bPreview.setOnClickListener(this);
        ibshare.setOnClickListener(this);
        ibsave.setOnClickListener(this);
    }

    private void iniciarViews() {
        display = (ImageView) findViewById(R.id.IVDisplay);
        image1 = (ImageView) findViewById(R.id.IVimage1);
        image2 = (ImageView) findViewById(R.id.IVimage2);
        image3 = (ImageView) findViewById(R.id.IVimage3);
        image4 = (ImageView) findViewById(R.id.IVimage4);
        image5 = (ImageView) findViewById(R.id.IVimage5);
        setWall = (Button) findViewById(R.id.BsetWallpaper);
        bPreview = (Button) findViewById(R.id.BPreview);
        ibshare = (ImageButton) findViewById(R.id.IBSave);
        ibsave = (ImageButton) findViewById(R.id.IBShare);
        tvCategoria = (TextView) findViewById(R.id.tvCategoria);
    }


    public static Bitmap decodeSampledBitmapFromResource(
            Resources res, int resId, int reqWidth,
            int reqHeight) {

        // Primeiro faz a decodificação com
        // inJustDecodeBounds = true para verificar as dimensões
        final BitmapFactory.Options options =
                new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calcula o inSampleSize
        options.inSampleSize =
                calculateInSampleSize(options, reqWidth, reqHeight);

        // Decodifica o bitmap com o inSampleSize configurado
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize( BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Altura e largura da imagem
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calcula as proporções de altura e largura
            // com a altura e largura solicitada
            final int heightRatio =
                    Math.round((float) height / (float) reqHeight);

            final int widthRatio =
                    Math.round((float) width / (float) reqWidth);

            // Escolhe qual a melhor proporção para inSampleSize
            inSampleSize =
                    heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }



    @Override
    public void onClick(View v) {


        switch (categoria) {
            case "rocket":
                switch (v.getId()) {
                    case R.id.IVimage1:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_1, 150, 150));
                        toPhone = R.drawable.back_rocket_1;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_rocket_1");
                        break;
                    case R.id.IVimage2:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_2, 150, 150));
                        toPhone = R.drawable.back_rocket_2;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_rocket_2");
                        break;
                    case R.id.IVimage3:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_3, 150, 150));
                        toPhone = R.drawable.back_rocket_3;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_rocket_3");
                        break;
                    case R.id.IVimage4:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_4, 150, 150));
                        toPhone = R.drawable.back_rocket_4;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_rocket_4");
                        break;
                    case R.id.IVimage5:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_rocket_5, 150, 150));
                        toPhone = R.drawable.back_rocket_5;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_rocket_5");
                        break;
                }
            break;

            case "pikachu":
                switch (v.getId()) {
                    case R.id.IVimage1:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_1, 150, 150));
                        toPhone = R.drawable.back_pikachu_1;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_pikachu_1");
                        break;
                    case R.id.IVimage2:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_2, 150, 150));
                        toPhone = R.drawable.back_pikachu_2;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_pikachu_2");
                        break;
                    case R.id.IVimage3:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_3, 150, 150));
                        toPhone = R.drawable.back_pikachu_3;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_pikachu_3");
                        break;
                    case R.id.IVimage4:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_4, 150, 150));
                        toPhone = R.drawable.back_pikachu_4;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_pikachu_4");
                        break;
                    case R.id.IVimage5:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_pikachu_5, 150, 150));
                        toPhone = R.drawable.back_pikachu_5;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_pikachu_5");
                        break;
                }
                break;

            case "misty":
                switch (v.getId()) {
                    case R.id.IVimage1:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_1, 150, 150));
                        toPhone = R.drawable.back_misty_1;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_misty_1");
                        break;
                    case R.id.IVimage2:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_2, 150, 150));
                        toPhone = R.drawable.back_misty_2;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_misty_2");
                        break;
                    case R.id.IVimage3:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_3, 150, 150));
                        toPhone = R.drawable.back_misty_3;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_misty_3");
                        break;
                    case R.id.IVimage4:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_4, 150, 150));
                        toPhone = R.drawable.back_misty_4;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_misty_4");
                        break;
                    case R.id.IVimage5:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_misty_5, 150, 150));
                        toPhone = R.drawable.back_misty_5;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_misty_5");
                        break;
                }
                break;

            case "brock":
                switch (v.getId()) {
                    case R.id.IVimage1:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_1, 150, 150));
                        toPhone = R.drawable.back_brock_1;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_brock_1");
                        break;
                    case R.id.IVimage2:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_2, 150, 150));
                        toPhone = R.drawable.back_brock_2;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_brock_2");
                        break;
                    case R.id.IVimage3:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_3, 150, 150));
                        toPhone = R.drawable.back_brock_3;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_brock_3");
                        break;
                    case R.id.IVimage4:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_4, 150, 150));
                        toPhone = R.drawable.back_brock_4;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_brock_4");
                        break;
                    case R.id.IVimage5:
                        display.setImageDrawable(null);
                        display.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.back_brock_5, 150, 150));
                        toPhone = R.drawable.back_brock_5;
                        uri = Uri.parse("android.resource://com.m.wallpaperfor.pokemongo/drawable/back_brock_5");
                        break;
                }
                break;


        }

        switch (v.getId()) {
            case R.id.BsetWallpaper:
                setWallpaper();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                break;
            case R.id.IBSave:
                saveImage();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                break;
            case R.id.IBShare:
                shareImage();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                break;
            case R.id.BPreview:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent intentPreview = new Intent(Wallpaper.this, Preview.class);
                intentPreview.putExtra("image", toPhone);
                startActivity(intentPreview);

                //	 moveTaskToBack(true);
                break;
        }


    }

    public void setWallpaper() {
        InputStream is = getResources().openRawResource(toPhone);
        Bitmap bm = BitmapFactory.decodeStream(is);
        try {
            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(500);
            getApplicationContext().setWallpaper(bm);
            Toast.makeText(getApplicationContext(),R.string.set_successfully , Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void shareImage() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        //shareIntent.setType( "text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Best Pokemon Go Wallpapers!");
        shareIntent.putExtra(Intent.EXTRA_TITLE, "SHARE");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(shareIntent, "Share image using"));
    }

    public void saveImage() {
        if (ContextCompat.checkSelfPermission(Wallpaper.this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Wallpaper.this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    14);
        } else {
            String commonPath = Environment.getExternalStorageDirectory().toString() + "/PokemonGoWallpapers";
            File direct = new File(commonPath);

            if (!direct.exists()) {
                if (direct.mkdir()) {
                    Log.d("tag", "directory created");
                    //directory is created;
                }

            }
            Bitmap bm = BitmapFactory.decodeResource(getResources(), toPhone);
            String strtoPhone = "" + toPhone;
            String nameFile = strtoPhone + ".jpeg";
            OutputStream outStream = null;

            File savingFile = new File(commonPath, nameFile);
            if (!savingFile.exists()) {
                Log.d("tag", "file is created");

                try {

                    savingFile.createNewFile();
                    outStream = new FileOutputStream(savingFile);
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                    outStream.flush();
                    outStream.close();

                    Log.d("tag", "Saved");
                    Toast.makeText(getApplicationContext(), "Image Saved Succesfully!", Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }

            } else {
                Toast.makeText(getApplicationContext(), "Image already Saved!", Toast.LENGTH_LONG).show();

            }
        }
    }



    public void onBackPressed() {

        Intent start = new Intent(Wallpaper.this, Dashboard.class);
        startActivity(start);
        finish();
    }

    @Override
    public void onDestroy() {
        Cleanup();
        super.onDestroy();
        // finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

    private void Cleanup() {
        System.gc();
        Runtime.getRuntime().gc();
    }

}
