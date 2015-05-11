/**
 * 
 */
package com.usmilitary.model;

import com.google.gson.annotations.Expose;

/**
 * @author darshanbidkar A parent model class for all branches. This class
 *         stores entire data of json
 */
public class USMilitaryModel {
	@Expose
	private GroupModel army, marines, airForce, navy, coastGuard;

	public GroupModel getArmy() {
		return army;
	}

	public void setArmy(GroupModel army) {
		this.army = army;
	}

	public GroupModel getMarines() {
		return marines;
	}

	public void setMarines(GroupModel marines) {
		this.marines = marines;
	}

	public GroupModel getAirForce() {
		return airForce;
	}

	public void setAirForce(GroupModel airForce) {
		this.airForce = airForce;
	}

	public GroupModel getNavy() {
		return navy;
	}

	public void setNavy(GroupModel navy) {
		this.navy = navy;
	}

	public GroupModel getCoastGuard() {
		return coastGuard;
	}

	public void setCoastGuard(GroupModel coastGuard) {
		this.coastGuard = coastGuard;
	}

}
