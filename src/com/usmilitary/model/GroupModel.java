/**
 * 
 */
package com.usmilitary.model;

import java.util.ArrayList;

/**
 * @author darshanbidkar Model class for all ranks followed by a rank logo
 */
public class GroupModel {
	private ArrayList<RankModel> ranks = new ArrayList<RankModel>();
	private String logo;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ArrayList<RankModel> getRank() {
		return ranks;
	}

	public void setRank(ArrayList<RankModel> rank) {
		this.ranks = rank;
	}

}
