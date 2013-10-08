package jp.skd.lilca.mhf.lib.skill_value_list;

/**
 * スキルの発動結果を抽象化したクラス
 */
public class ResultBootSkill {
	/**
	 * 発動スキル名
	 */
	public String	text;
	/**
	 * ランクアップ有無
	 */
	public boolean	uped;
	/**
	 * コンストラクタ
	 * @param t 発動スキル名
	 * @param f ランクアップ有無
	 */
	public ResultBootSkill(String t, boolean f){
		this.text	= t;
		this.uped	= f;
	}
}
