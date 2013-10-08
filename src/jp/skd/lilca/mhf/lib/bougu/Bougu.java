package jp.skd.lilca.mhf.lib.bougu;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.skill_gain.SkillDefines;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * 防具を抽象化したクラス
 */
public class Bougu{

	private String bui;
	private String name;
	private boolean kenshi;
	private boolean gunner;
	private int level;
	private String cost;
	private int def;
	private int fire;
	private int mizu;
	private int ryu;
	private int thunder;
	private int kori;
	private String skills;
	private int slots;
	private String sozai;
	private String rare;
	private boolean empty;
	private ArrayList<Sousyoku> sousyoku;
	// 12JAN 追加　キャラクター性別
	private int gender;	//1:男性専用　2:女性専用　3:共用
	// 12NOV 追加　防具種類
	private String btype;	// 剛種、天嵐、覇種、狩護など

	/**
	 * コンストラクタ（装飾品と一括入力）
	 * @param csvstr 文字列形式の防具データ
	 * @param t1 文字列形式の装飾品データ
	 * @param t2 文字列形式の装飾品データ
	 * @param t3 文字列形式の装飾品データ
	 */
	public Bougu(String csvstr, String t1, String t2, String t3){
		this.setString(csvstr);
		// 珠情報
		this.sousyoku = new ArrayList<Sousyoku>();
		this.addSousyoku(new Sousyoku(t1));
		this.addSousyoku(new Sousyoku(t2));
		this.addSousyoku(new Sousyoku(t3));
		return;
	}
	/**
	 * コンストラクタ
	 * @param csvstr 文字列形式の防具データ
	 */
	public Bougu(String csvstr){
		this(csvstr, "", "", "");
		return;
	}
	/**
	 * 文字列形式の防具データをパーズ（解析）
	 * @param csvstr 文字列形式の防具データ
	 */
	public void setString(String csvstr){
		empty = true;
		if(this.sousyoku!=null)
			this.sousyoku.clear();
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<16)
			return;
		empty = false;
		// 部位
		this.bui = fields[0].trim();
		// 名前
		this.name = fields[1].trim();
		// 剣士フラグ
		if(fields[2].equals("1"))
			this.kenshi = true;
		else
			this.kenshi = false;
		// ガンナーフラグ
		if(fields[3].equals("1"))
			this.gunner = true;
		else
			this.gunner = false;
		// レベル
		this.level = Integer.parseInt(fields[4]);
		// 価格
		this.cost = fields[5];
		// 防御力
		this.def = Integer.parseInt(fields[6]);
		// 火
		this.fire = Integer.parseInt(fields[7]);
		// 水
		this.mizu = Integer.parseInt(fields[8]);
		// 雷
		this.thunder = Integer.parseInt(fields[9]);
		// 龍
		this.ryu = Integer.parseInt(fields[10]);
		// 氷
		this.kori = Integer.parseInt(fields[11]);
		// スキル
		this.skills = fields[12];
		// スロット数
		this.slots = Integer.parseInt(fields[13]);
		// 素材
		this.sozai = fields[14];
		// レア度
		this.rare = fields[15];
		// 性別 (12JAN)
		if(fields.length <= 16 )
			this.gender = 3;	// 旧フォーマットではすべて共用扱い
		else
			this.gender = Integer.parseInt(fields[16]);
		// 防具タイプ(12NOV)
		if(fields.length <= 17 )
			this.btype = "";	// 旧フォーマットではすべて通常防具扱い
		else
			this.btype = fields[17];
		return;
	}
	/**
	 * 防具データを文字列形式として取得
	 * @return 文字列形式の防具データ
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// 部位
		res += this.bui+",";
		// 名前
		res += this.name+",";
		// 剣士フラグ
		if(this.kenshi)
			res += "1"+",";
		else
			res += "0"+",";
		// ガンナーフラグ
		if(this.gunner)
			res += "1"+",";
		else
			res += "0"+",";
		// レベル
		res += this.level+",";
		// 価格
		res += this.cost+",";
		// 防御力
		res += this.def+",";
		// 火
		res += this.fire+",";
		// 水
		res += this.mizu+",";
		// 雷
		res += this.thunder+",";
		// 龍
		res += this.ryu+",";
		// 氷
		res += this.kori+",";
		// スキル
		res += this.skills+",";
		// スロット数
		res += this.slots+",";
		// 素材
		res += this.sozai+",";
		// レア度
		res += this.rare+",";
		// 性別 (12JAN)
		res += this.gender+",";
		// 防具タイプ(12NOV)
		res += this.btype;
		return res;
	}
	/**
	 * 防具データの削除（初期化）
	 */
	public void remove(){
		this.setString("");
		return;
	}
	/**
	 * 防具データが空であるかを取得
	 * @return true=空,false=防具データがある
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * 防具が剣士で使えるか取得
	 * @return true=使える,false=使えない
	 */
	public boolean isKenshi(){
		if(empty)
			return true;
		return this.kenshi;
	}
	/**
	 * 防具がガンナーで使えるか取得
	 * @return true=使える,false=使えない
	 */
	public boolean isGunner(){
		if(empty)
			return true;
		return this.gunner;
	}
	/**
	 * 防具が該当する部位であるかを取得
	 * @param b 確認したい部位(頭or胴or腕or腰or脚)
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isBui(String b){
		if(empty)
			return true;
		if(this.bui.equals("頭") && b.equals("頭"))
			return true;
		if(this.bui.equals("胴") && b.equals("胴"))
			return true;
		if(this.bui.equals("腕") && b.equals("腕"))
			return true;
		if(this.bui.equals("腰") && b.equals("腰"))
			return true;
		if(this.bui.equals("脚") && b.equals("脚"))
			return true;
		return false;
	}
	/**
	 * 防具が「頭」であるか取得
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isAtama(){
		if(empty)
			return true;
		if(this.bui.equals("頭"))
			return true;
		return false;
	}
	/**
	 * 防具が「胴」であるか取得
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isDou(){
		if(empty)
			return true;
		if(this.bui.equals("胴"))
			return true;
		return false;
	}
	/**
	 * 防具が「腕」であるか取得
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isUde(){
		if(empty)
			return true;
		if(this.bui.equals("腕"))
			return true;
		return false;
	}
	/**
	 * 防具が「腰」であるか取得
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isKoshi(){
		if(empty)
			return true;
		if(this.bui.equals("腰"))
			return true;
		return false;
	}
	/**
	 * 防具が「脚」であるか取得
	 * @return true=該当する部位である,false=該当する部位でない
	 */
	public boolean isAshi(){
		if(empty)
			return true;
		if(this.bui.equals("脚"))
			return true;
		return false;
	}
	/**
	 * 防具の名前を取得
	 * @return 防具の名前
	 */
	public String getName(){
		if(empty)
			return "なし";
		return this.name;
	}
	/**
	 * 防具がSP防具であるかを取得
	 * @return true=SP防具である,false=SP防具でない
	 */
	public boolean isSP(){
		if(empty)
			return false;
		if(this.name.startsWith("SP"))
			return true;
		return false;
	}
	/**
	 * 防具が該当するタイプ（HC,覇種,秘伝など）
	 * @param t 確認したいタイプ
	 * @return true=該当するタイプである,false=該当するタイプでない
	 */
	public boolean isBouguType(String t){
		if(empty)
			return false;
		// 秘伝防具はスキルで判断
		if( t.indexOf("秘伝") != -1){
			return this.isIncludeHidenSkill();
		}
		if(this.btype.indexOf(t)!=-1)
			return true;
		return false;
	}
	/**
	 * 防具が秘伝スキルを含んでいるかを取得
	 * @return true=秘伝スキルを含んでいる,false=秘伝スキルを含んでいない
	 */
	private boolean isIncludeHidenSkill(){
		boolean res = false;
		for(int idx=0; idx<SkillDefines.hidenNameList.length; idx++)
			if( this.skills.indexOf(SkillDefines.hidenNameList[idx]) != -1 )
				return true;
		return res;
	}
	/**
	 * 防具のタイプ（HC,覇種,秘伝など）を取得
	 * @return タイプ
	 */
	public String getBouguType(){
		if(empty)
			return "";
		return this.btype;
	}
	/**
	 * 防具のスキル（複数のときは「:」で区切る）をHTMLタグを入れて文字列で取得
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
	 * 防具のスキル（複数のときは「:」で区切る）を取得
	 * @return スキルの文字列
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * 防具と装飾品を合わせたスキルをHTMLタグ入りの文字列で取得
	 * @param sep 複数のときの区切り文字列
	 * @param color 文字のカラーコード
	 * @return HTMLタグ入りのスキルの文字列
	 */
	public String getSkillsWithSousyokuWithColorTag(String sep, String color){
		if(empty)
			return "";
		SkillVector res = new SkillVector(this.skills, ":");
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			res = res.add(new SkillVector(this.sousyoku.get(idx).getSkills(), ":"));
		// カラータグ付加
		String temp = res.exportSkills(sep);
		String[] list = CsvStringToList.split(temp, sep);
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, sep);
	}
	/**
	 * 防具と装飾品を合わせたスキルを文字列で取得
	 * @param sep 複数のときの区切り文字列
	 * @return スキルの文字列
	 */
	public String getSkillsWithSousyoku(String sep){
		if(empty)
			return "";
		SkillVector res = new SkillVector(this.skills, ":");
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			res = res.add(new SkillVector(this.sousyoku.get(idx).getSkills(), ":"));
		return res.exportSkills(sep);
	}
	/**
	 * 防具のスキルをスキルベクトルとして取得
	 * @return スキルベクトル
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector b = new SkillVector(this.skills, ":");
		res.assign(b);
		return res;
	}
	/**
	 * 防具と装飾品を合わせたスキルをスキルベクトルとして取得
	 * @return スキルベクトル
	 */
	public SkillVector getSkillVectorWithSousyoku(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector b = new SkillVector(this.skills, ":");
		res.assign(b);
		for(int idx=0; idx<this.sousyoku.size(); idx++){
			SkillVector s= new SkillVector(this.sousyoku.get(idx).getSkills(), ":");
			res = res.add(s);
		}
		return res;
	}
	/**
	 * 防具のスロット数（空きスロットではない）
	 * @return 防具のスロット数
	 */
	public int getSlot(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * 防具のスロット数を文字列で取得（例：○○ー）
	 * @return 文字列形式のスロット数
	 */
	public String getSlotString(){
		if(empty)
			return "---";
		if(this.slots==0)
			return "---";
		if(this.slots==1)
			return "o--";
		if(this.slots==2)
			return "oo-";
		return "ooo";
	}
	/**
	 * 防具の防御力を取得
	 * @return 防具の防御力
	 */
	public int getDef(){
		if(empty)
			return 0;
		return this.def;
	}
	/**
	 * 防具のレベル（多くは1-7）を取得
	 * @return 防具のレベル
	 */
	public int getLevel(){
		if(empty)
			return 1;
		return this.level;
	}
	/**
	 * 防具の素材を文字列で取得
	 * @return 防具の素材
	 */
	public String getSozai(){
		if(empty)
			return "";
		return this.sozai;
	}
	/**
	 * 防具のレア度を取得
	 * @return 防具のレア度
	 */
	public int getRare(){
		if(empty)
			return 1;
		// フォーマット判定
		if( this.rare.indexOf("@") != -1 ){
			// 新フォーマット
			String[] list	= CsvStringToList.split(this.rare, "@");
			return Integer.parseInt( list[0] );
		}
		// 旧処理
		if( this.rare.indexOf("GR") != -1 ){
			int a	= Integer.parseInt( this.rare.replaceAll("GR", "") );
			return a+7;
		}
		return Integer.parseInt( this.rare );
	}
	// 12JAN 男性が使えるか
	/**
	 * 防具が男性キャラが使えるかを取得
	 * @return true=使える,false=使えない
	 */
	public boolean canMale(){
		if(empty){
			return true;
		}
		// 男性が使えるなら
		if(this.gender % 2 == 1){
			return true;
		}
		return false;
	}
	// 12JAN 女性が使えるか
	/**
	 * 防具が女性キャラが使えるかを取得
	 * @return true=使える,false=使えない
	 */
	public boolean canFemale(){
		if(empty){
			return true;
		}
		// 女性が使えるなら
		if((this.gender / 2) % 2 == 1){
			return true;
		}
		return false;
	}
	/**
	 * 防具の火耐性を取得
	 * @return 防具の火耐性
	 */
	public int getFire(){
		if(empty)
			return 0;
		return this.fire;
	}
	/**
	 * 防具の水耐性を取得
	 * @return 防具の水耐性
	 */
	public int getMizu(){
		if(empty)
			return 0;
		return this.mizu;
	}
	/**
	 * 防具の龍耐性を取得
	 * @return 防具の龍耐性
	 */
	public int getRyu(){
		if(empty)
			return 0;
		return this.ryu;
	}
	/**
	 * 防具の雷耐性を取得
	 * @return 防具の雷耐性
	 */
	public int getThunder(){
		if(empty)
			return 0;
		return this.thunder;
	}
	/**
	 * 防具の氷耐性を取得
	 * @return 防具の氷耐性
	 */
	public int getKori(){
		if(empty)
			return 0;
		return this.kori;
	}
	/**
	 * 与えられた文字列（攻撃+5、達人-4など）のスキル名を取得
	 * @param src 確認したい文字列
	 * @return スキル名
	 */
	public static String getSkillName(String src){
		String res = null;
		src = src.replace("＋", "+").replace("－", "-");
		if(src.indexOf("+")!=-1)
			res = src.substring(0, src.indexOf("+"));
		else
			res = src.substring(0, src.indexOf("-"));
		return res;
	}
	/**
	 * 与えられた文字列（攻撃+5、達人-4など）のスキル値を取得
	 * @param src 確認したい文字列
	 * @return スキル値
	 */
	public static Integer getSkillValue(String src){
		Integer res = null;
		src = src.replace("＋", "+").replace("－", "-");
		if(src.indexOf("+")!=-1)
			res = (int)Double.parseDouble(src.substring(src.indexOf("+")).replace("+", ""));
		else
			res = (int)Double.parseDouble(src.substring(src.indexOf("-")));
		return res;
	}
	// 12JAN 性別によるテイクオフ
	/**
	 * 指定された性別で使えない場合、防具データを初期化
	 * @param male true=男性,false=女性
	 */
	public void ifNotTakeoffSexually(boolean male){
		// キャラが男性で
		if(male){
			// 男性が使えないとき
			if(!this.canMale())
				this.setString("");
		}
		// キャラが女性で
		else{
			// 女性が使えないとき
			if(!this.canFemale())
				this.setString("");
		}
		return;
	}
	/**
	 * 指定された値（剣士orガンナー）で使えない場合、防具データを初期化
	 * @param kenshi true=剣士,false=ガンナー
	 */
	public void ifNotTakeoff(boolean kenshi){
		if(kenshi){
			if(!this.isKenshi())
				this.setString("");
		}
		else{
			if(!this.isGunner())
				this.setString("");
		}
		return;
	}
	/**
	 * 防具の空きスロット数を取得
	 * @return 空きスロット数
	 */
	public int getEmptySlots(){
		// 武器のスロット数取得
		int slots = this.getSlot();
		// 消費しているスロット数
		int spended = this.getSpendedSlots();
		return (slots - spended);
	}
	/**
	 * 防具の消費スロット数を取得
	 * @return 消費スロット数
	 */
	public int getSpendedSlots(){
		// 消費しているスロット数
		int spended = 0;
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			spended += this.sousyoku.get(idx).getSlotCost();
		return spended;
	}
	/**
	 * 防具に装飾品データを追加（スロットが足りない場合は追加されない）
	 * @param src 追加する装飾品データ
	 * @return true=左以外,false=スロット数が足りない
	 */
	public boolean addSousyoku(Sousyoku src){
		// からっぽなら失敗
		if(src.isEmpty())
			return false;
		// オーバーなら失敗
		if( this.getEmptySlots() < src.getSlotCost() ){
			return false;
		}
		// 追加
		this.sousyoku.add(src);
		return true;
	}
	/**
	 * 防具に付いている装飾品のリストを取得
	 * @return 装飾品データのリスト
	 */
	public ArrayList<Sousyoku> getSousyokuList(){
		if(this.sousyoku == null)
			return new ArrayList<Sousyoku>();
		return this.sousyoku;
	}
	/**
	 * 防具がつけている装飾品の名前を文字列で取得
	 * @param seq 複数の場合の区切り文字列
	 * @return 装飾品の名前
	 */
	public String getTamaNames(String seq){
		String res = "";
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(idx==0)
				res += this.sousyoku.get(idx).getName();
			else
				res += seq+this.sousyoku.get(idx).getName();
		return res;
	}
}
