/**
 * 
 */
package com.usmilitary;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Application;

import com.google.gson.Gson;
import com.usmilitary.model.RankModel;
import com.usmilitary.model.USMilitaryModel;

/**
 * @author darshanbidkar Looks after the entire application data
 */
public class USMilitaryApplication extends Application {
	private static USMilitaryApplication sApplication;
	private JSONObject mJson;
	private USMilitaryModel model;
	private ArrayList<RankModel> mRankModel;
	private RankModel mRank;
	private String mTitleRank, mTitleLogo;

	/**
	 * @return the mTitleLogo
	 */
	public String getmTitleLogo() {
		return mTitleLogo;
	}

	/**
	 * @param mTitleLogo
	 *            the mTitleLogo to set
	 */
	public void setmTitleLogo(String mTitleLogo) {
		this.mTitleLogo = mTitleLogo;
	}

	/**
	 * @return the mTitleRank
	 */
	public String getmTitleRank() {
		return mTitleRank;
	}

	/**
	 * @param mTitleRank
	 *            the mTitleRank to set
	 */
	public void setmTitleRank(String mTitleRank) {
		this.mTitleRank = mTitleRank;
	}

	/**
	 * @return the mRank
	 */
	public RankModel getmRank() {
		return mRank;
	}

	/**
	 * @param mRank
	 *            the mRank to set
	 */
	public void setmRank(RankModel mRank) {
		this.mRank = mRank;
	}

	/**
	 * oncreate
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		USMilitaryApplication.sApplication = this;

	}

	/**
	 * returns a singleton instance of this class
	 * 
	 * @return instance of USMilitaryApplication
	 */
	public static synchronized USMilitaryApplication getInstance() {
		return USMilitaryApplication.sApplication;
	}

	/**
	 * sets the Json for future use
	 * 
	 * @param object
	 *            json object
	 */
	public void setJson(JSONObject object) {
		this.mJson = object;
		this.generate();
	}

	/**
	 * generates a model class from existing json
	 */
	private final void generate() {
		this.model = new Gson().fromJson(this.mJson.toString(),
				USMilitaryModel.class);
	}

	/**
	 * returns current model
	 * 
	 * @return
	 */
	public USMilitaryModel getModel() {
		return this.model;
	}

	/**
	 * sets current data to be used by listview by current activity
	 * 
	 * @param model
	 */
	public void setCurrentData(ArrayList<RankModel> model) {
		this.mRankModel = model;
	}

	/**
	 * returns the data required by listview by next activity
	 * 
	 * @return
	 */
	public ArrayList<RankModel> getCurrentData() {
		return this.mRankModel;
	}
}
