package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * スキルベクトルの項（スキルスカラー）を抽象化したクラス
 */
public class SkillScalar {
	private String name;
	private int	val;

	/**
	 * コンストラクタ
	 * @param s スキル名
	 * @param v スキル値
	 */
	public SkillScalar(String s, int v){
		this.name = s;
		this.val = v;
		return;
	}
	/**
	 * コンストラクタ
	 * @param csv 文字列形式のスキルスカラー
	 */
	public SkillScalar(String csv){
		String[] temp;
		if(csv.indexOf("+")!=-1){
			temp = CsvStringToList.split(csv, "+");
			this.name = temp[0];
			this.val = Integer.parseInt(temp[1]);
		}
		else
		if(csv.indexOf("-")!=-1){
			temp = CsvStringToList.split(csv, "-");
			this.name = temp[0];
			this.val = -Integer.parseInt(temp[1]);
		}
		return;
	}
	/**
	 * スキル名を取得
	 * @return スキル名
	 */
	public String getSkillName(){
		return this.name;
	}
	/**
	 * スキル値を取得
	 * @return スキル値
	 */
	public int getSkillValue(){
		return this.val;
	}
}
