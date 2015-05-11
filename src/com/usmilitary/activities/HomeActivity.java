package com.usmilitary.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.usmilitary.R;
import com.usmilitary.USMilitaryApplication;
import com.usmilitary.fragments.HomeFragment;

/**
 * The home screen which will display list of all branches. eg. army, navy, air
 * force, etc.
 * 
 * @author darshanbidkar
 *
 */
public class HomeActivity extends ActionBarActivity {

	private HomeFragment mHomeFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// Set fragment
		this.mHomeFragment = new HomeFragment();
		FragmentTransaction ft = super.getSupportFragmentManager()
				.beginTransaction();
		ft.replace(R.id.home_container, this.mHomeFragment);
		ft.commit();

		try {
			String json = this.generateData();
			JSONObject object = new JSONObject(json);
			USMilitaryApplication.getInstance().setJson(object);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generates data from json file stored in the project folder. Accesses
	 * assets folder for json file
	 * 
	 * @return the data in json format
	 * @throws IOException
	 */
	private String generateData() throws IOException {

		AssetManager assetManager = super.getAssets();
		InputStream in = assetManager.open("ranks.json");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputLine = "";
		String json = "";
		while ((inputLine = br.readLine()) != null) {
			json += inputLine;
		}
		br.close();
		return json;
	}
}
