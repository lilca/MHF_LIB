package jp.skd.lilca.mhf.lib.bougu;

import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * 装飾品を抽象化したクラス
 */
public class Sousyoku {
	private String name;
	private boolean isSPs;
	private String skills;
	private int slots;
	private String sozai;
	private String cost;
	private String rank;
	private boolean empty;
	/**
	 * コンストラクタ
	 * @param csvstr 文字列形式の装飾品データ
	 */
	public Sousyoku(String csvstr){
		this.setString(csvstr);
	}
	/**
	 * 文字列形式の装飾品データをパーズ（解析）
	 * @param csvstr 文字列形式の装飾品データ
	 */
	public void setString(String csvstr){
		empty = true;
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<7)
			return;
		empty = false;
		// 名前
		this.name = fields[0].trim();
		// SPフラグ
		if(fields[1].equals("1"))
			this.isSPs = true;
		else
			this.isSPs = false;
		// スキル
		this.skills = fields[2];
		// スロット数
		this.slots = Integer.parseInt(fields[3]);
		// 素材
		this.sozai = fields[4];
		// コスト
		this.cost = fields[5];
		// ランク
		this.rank = fields[6];
		return;
	}
	/**
	 * 装飾品データを文字列形式として取得
	 * @return 文字列形式の装飾品データ
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// 名前
		res += this.name+",";
		// SPフラグ
		if(this.isSPs)
			res += "1"+",";
		else
			res += "0"+",";
		// スキル
		res += this.skills+",";
		// スロット数
		res += this.slots+",";
		// 素材
		res += this.sozai+",";
		// コスト
		res += this.cost+",";
		// ランク
		res += this.rank;
		return res;
	}
	/**
	 * 装飾品データが空であるかを取得
	 * @return true=空,false=装飾品データがある
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * 装飾品の名前を取得
	 * @return 装飾品の名前
	 */
	public String getName(){
		if(empty)
			return "なし";
		return this.name;
	}
	/**
	 * 装飾品のスキル（複数のときは「:」で区切る）をHTMLタグを入れて文字列で取得
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
	 * 装飾品のスキルをスキルベクトルとして取得
	 * @return スキルベクトル
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector s = new SkillVector(this.skills, ":");
		res.assign(s);
		return res;
	}
	/**
	 * 装飾品のスキル（複数のときは「:」で区切る）を取得
	 * @return スキルの文字列
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * 装飾品の消費スロット数取得
	 * @return 消費スロット数
	 */
	public int getSlotCost(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * 装飾品のコストを取得
	 * @return コスト
	 */
	public String getCost(){
		if(empty)
			return "0z";
		return this.cost;
	}
	/**
	 * 装飾品のランクを取得
	 * @return ランク
	 */
	public String getRank(){
		if(empty)
			return "1";
		return this.rank;
	}
	/**
	 * 装飾品がSP防具専用であるかを取得
	 * @return true=SP防具専用である,false=SP防具専用でない
	 */
	public boolean isSP(){
		if(empty)
			return false;
		return this.isSPs;
	}
	/**
	 * 装飾品の消費スロット数を文字列で取得（例：○○ー）
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
	 * 装飾品の素材を文字列で取得
	 * @return 装飾品の素材
	 */
	public String getSozai(){
		return this.sozai;
	}
}
