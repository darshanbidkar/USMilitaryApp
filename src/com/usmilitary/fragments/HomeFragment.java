/**
 * 
 */
package com.usmilitary.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.usmilitary.R;
import com.usmilitary.USMilitaryApplication;
import com.usmilitary.activities.GroupDetailActivity;
import com.usmilitary.adapters.HomeListAdapter;
import com.usmilitary.model.USMilitaryGroupModel;
import com.usmilitary.model.USMilitaryModel;

/**
 * @author darshanbidkar Lightweight fragment showing the home screen
 */
public class HomeFragment extends Fragment implements OnItemClickListener {

	private ListView mOptionsList;
	private ArrayList<USMilitaryGroupModel> groups;
	private HomeListAdapter mHomeAdapter;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View inflatedView = inflater.inflate(R.layout.fragment_home, container,
				false);

		this.mOptionsList = (ListView) inflatedView
				.findViewById(R.id.home_list);
		this.mOptionsList.setOnItemClickListener(this);
		this.init();
		return inflatedView;
	}

	private void init() {
		this.groups = new ArrayList<USMilitaryGroupModel>();
		USMilitaryGroupModel model = new USMilitaryGroupModel();
		USMilitaryModel mainModel = USMilitaryApplication.getInstance()
				.getModel();

		model.setLogo(mainModel.getAirForce().getLogo());
		model.setTitle("Air Force");
		this.groups.add(model);

		model = new USMilitaryGroupModel();
		model.setLogo(mainModel.getArmy().getLogo());
		model.setTitle("Army");
		this.groups.add(model);

		model = new USMilitaryGroupModel();
		model.setLogo(mainModel.getCoastGuard().getLogo());
		model.setTitle("Coast Guard");

		this.groups.add(model);
		model = new USMilitaryGroupModel();
		model.setLogo(mainModel.getMarines().getLogo());
		model.setTitle("Marines");
		this.groups.add(model);

		model = new USMilitaryGroupModel();
		model.setLogo(mainModel.getNavy().getLogo());
		model.setTitle("Navy");
		this.groups.add(model);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (this.mHomeAdapter == null) {
			this.mHomeAdapter = new HomeListAdapter(super.getActivity(),
					R.layout.cell_home, new ArrayList<USMilitaryGroupModel>());
			this.mOptionsList.setAdapter(this.mHomeAdapter);
			this.mHomeAdapter.addAll(this.groups);
			this.mHomeAdapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch ((int) id) {
		case 0: // Air Force
			USMilitaryApplication.getInstance().setCurrentData(
					(USMilitaryApplication.getInstance().getModel()
							.getAirForce().getRank()));
			USMilitaryApplication.getInstance().setmTitleLogo(
					this.groups.get(0).getLogo());
			USMilitaryApplication.getInstance().setmTitleRank(
					this.groups.get(0).getTitle());
			break;
		case 1: // Army
			USMilitaryApplication.getInstance().setCurrentData(
					(USMilitaryApplication.getInstance().getModel().getArmy()
							.getRank()));
			USMilitaryApplication.getInstance().setmTitleLogo(
					this.groups.get(1).getLogo());
			USMilitaryApplication.getInstance().setmTitleRank(
					this.groups.get(1).getTitle());
			break;
		case 2: // Coast Guard
			USMilitaryApplication.getInstance().setCurrentData(
					(USMilitaryApplication.getInstance().getModel()
							.getCoastGuard().getRank()));
			USMilitaryApplication.getInstance().setmTitleLogo(
					this.groups.get(2).getLogo());
			USMilitaryApplication.getInstance().setmTitleRank(
					this.groups.get(2).getTitle());
			break;
		case 3: // Marines
			USMilitaryApplication.getInstance().setCurrentData(
					(USMilitaryApplication.getInstance().getModel()
							.getMarines().getRank()));
			USMilitaryApplication.getInstance().setmTitleLogo(
					this.groups.get(3).getLogo());
			USMilitaryApplication.getInstance().setmTitleRank(
					this.groups.get(3).getTitle());
			break;
		case 4: // Navy
			USMilitaryApplication.getInstance().setCurrentData(
					(USMilitaryApplication.getInstance().getModel().getNavy()
							.getRank()));
			USMilitaryApplication.getInstance().setmTitleLogo(
					this.groups.get(4).getLogo());
			USMilitaryApplication.getInstance().setmTitleRank(
					this.groups.get(4).getTitle());
			break;
		}
		super.getActivity().startActivity(
				new Intent(super.getActivity(), GroupDetailActivity.class));
	}
}
