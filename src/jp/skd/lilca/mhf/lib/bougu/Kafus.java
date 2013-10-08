package jp.skd.lilca.mhf.lib.bougu;

import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * カフを抽象化したクラス
 */
public class Kafus {
	// オリジナル
	private String org;
	// 各武器共通
	private String name;
	private String skills;
	private int slots;
	private String sozai;
	private String cost;
	private boolean empty;

	/**
	 * コンストラクタ
	 * @param csvstr 文字列形式のカフデータ
	 */
	public Kafus(String csvstr){
		this.org = csvstr;
		this.setString(csvstr);
	}
	/**
	 * 文字列形式のカフデータをパーズ（解析）
	 * @param csvstr 文字列形式のカフデータ
	 */
	public void setString(String csvstr){
		empty = true;
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<4)
			return;
		empty = false;
		// 名前
		this.name = fields[0].trim();
		// スキル
		this.skills = fields[1];
		// スロット数
		this.slots = Integer.parseInt(fields[2]);
		// 素材
		this.sozai = fields[3];
		// コスト
		this.cost = fields[4];
		return;
	}
	/**
	 * カフデータを文字列形式として取得
	 * @return 文字列形式のカフデータ
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		return this.org;
	}
	/**
	 * カフデータが空であるかを取得
	 * @return true=空,false=カフデータがある
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * カフの名前を取得
	 * @return カフの名前
	 */
	public String getName(){
		if(empty)
			return "なし";
		return this.name;
	}
	/**
	 * カフのスキル（複数のときは「:」で区切る）をHTMLタグを入れて文字列で取得
	 * @param color 文字のカラーコード
	 * @return HTMLタグ入りのスキルの文字列
	 */
	public String getSkillsWithColorTag(String color){
		String temp = this.getSkills();
		String[] list = CsvStringToList.split(temp, ":");
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, ":");
	}
	/**
	 * カフのスキルをスキルベクトルとして取得
	 * @return スキルベクトル
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector k = new SkillVector(this.skills, ":");
		res.assign(k);
		return res;
	}
	/**
	 * カフのスキル（複数のときは「:」で区切る）を取得
	 * @return スキルの文字列
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * カフの消費スロット数取得
	 * @return 消費スロット数
	 */
	public int getSlotCost(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * カフのコストを取得
	 * @return コスト
	 */
	public String getCost(){
		if(empty)
			return "0z";
		return this.cost;
	}
	/**
	 * カフの消費スロット数を文字列で取得（例：○○ー）
	 * @return 文字列形式の消費スロット数
	 */
	public String getSlotCostString(){
		if(this.slots==1)
			return "o";
		if(this.slots==2)
			return "oo";
		if(this.slots==3)
			return "ooo";
		return "";
	}
	/**
	 * カフの素材を文字列で取得
	 * @return カフの素材
	 */
	public String getSozai(){
		return this.sozai;
	}
}
