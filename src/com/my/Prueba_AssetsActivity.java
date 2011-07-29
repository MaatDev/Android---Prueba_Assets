package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class Prueba_AssetsActivity extends Activity {
	
	TextView tv=null;
	String cadena="";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        tv = (TextView) findViewById(R.id.texto);
        tv = new TextView(this);
        Log.v("ERROR"," -- "+tv);
        
        try {
			InputStream is = getAssets().open("nombre_ceviche.txt");
			Log.v("Prueba_AssetsActivity", "hohoho");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String leerLinea = null;
			
			while((leerLinea = br.readLine())!=null){
				Log.v("Prueba_AssetsActivity", cadena);
				cadena += leerLinea+'\n';
				
			}
			is.close();
			
			Log.v("Prueba_AssetsActivity", "----"+cadena);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tv.setText(""+cadena);
        addContentView(tv, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        
    }
}