/**
 * 
 */
package com.usmilitary.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.usmilitary.R;
import com.usmilitary.USMilitaryApplication;
import com.usmilitary.adapters.RankAdapter;
import com.usmilitary.model.RankModel;

/**
 * @author darshanbidkar Shows the list of ranks of currently selected branch.
 *         eg. all ranks of Army
 */
public class GroupDetailActivity extends ActionBarActivity implements
		OnItemClickListener {

	private ListView mGroupDetailList;
	private RankAdapter mRankAdapter;
	private ArrayList<RankModel> mRanks;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		super.setContentView(R.layout.fragment_home);
		super.setTitle(USMilitaryApplication.getInstance().getmTitleRank());
		this.mGroupDetailList = (ListView) super.findViewById(R.id.home_list);
		this.mRankAdapter = new RankAdapter(this, R.layout.cell_home,
				new ArrayList<RankModel>());
		this.mRanks = USMilitaryApplication.getInstance().getCurrentData();
		this.mRankAdapter.addAll(this.mRanks);
		this.mGroupDetailList.setAdapter(this.mRankAdapter);
		this.mRankAdapter.notifyDataSetChanged();
		this.mGroupDetailList.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		USMilitaryApplication.getInstance().setmRank(this.mRanks.get((int) id));
		super.startActivity(new Intent(this, DetailActivity.class));

	}

}
