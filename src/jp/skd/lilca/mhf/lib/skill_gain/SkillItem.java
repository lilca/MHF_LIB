package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * 発動スキル名と、そのスキル名及びスキル値を包括したクラス
 */
public class SkillItem {
	/**
	 * スキル名
	 */
	public String skillName;
	/**
	 * スキル値
	 */
	public int value;
	/**
	 * 発動スキル名
	 */
	public String bootSkillName;

	/**
	 * コンストラクタ
	 * @param csv CSV形式のスキルアイテム
	 */
	public SkillItem(String csv){
		String[] temp = CsvStringToList.split(csv, ",");
		this.skillName = temp[0];
		this.value = Integer.parseInt(temp[1]);
		this.bootSkillName = temp[2];
		return;
	}
	/**
	 * 指定した発動スキル名か否か
	 * @param name 指定発動スキル
	 * @return true=指定発動スキルと同じ,false=それ以外
	 */
	public boolean isBootSkill(String name){
		if(name.equals(this.bootSkillName))
			return true;
		return false;
	}
}
