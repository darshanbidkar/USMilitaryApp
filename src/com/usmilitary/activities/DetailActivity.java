/**
 * 
 */
package com.usmilitary.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.usmilitary.R;
import com.usmilitary.USMilitaryApplication;
import com.usmilitary.model.RankModel;

/**
 * @author darshanbidkar Shows the details of each category rank such as branch,
 *         logo, rank, paygrade,etc.
 */
public class DetailActivity extends ActionBarActivity {

	private TextView mBranchName, mRankName, mPayGrade, mAbbr;
	private ImageView mBranchLogo, mRankLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_detail);
		super.setTitle(USMilitaryApplication.getInstance().getmTitleRank());

		RankModel currentRank = USMilitaryApplication.getInstance().getmRank();

		this.mBranchName = (TextView) super.findViewById(R.id.branch_name);
		this.mRankName = (TextView) super.findViewById(R.id.detail_rank_name);
		this.mPayGrade = (TextView) super.findViewById(R.id.detail_paygrade);
		this.mAbbr = (TextView) super.findViewById(R.id.detail_abbr);

		this.mBranchLogo = (ImageView) super.findViewById(R.id.branch_logo);
		this.mRankLogo = (ImageView) super.findViewById(R.id.rank_logo);

		this.mBranchName.setText(USMilitaryApplication.getInstance()
				.getmTitleRank());
		this.mRankName.setText("Rank: \n" + currentRank.getTitle());
		this.mPayGrade.setText("Pay grade: \n" + currentRank.getPayGrade());
		if (currentRank.getAbbreviation().equalsIgnoreCase(""))
			this.mAbbr.setText("Abbreviation: \nNA");
		else
			this.mAbbr.setText("Abbreviation: \n"
					+ currentRank.getAbbreviation());

		Picasso.with(this).load(currentRank.getInsigniaImageHD())
				.into(this.mRankLogo);
		Picasso.with(this)
				.load(USMilitaryApplication.getInstance().getmTitleLogo())
				.into(this.mBranchLogo);

	}
}
