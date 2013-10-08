package jp.skd.lilca.mhf.lib.buki;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Sousyoku;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * 武器を抽象化したクラス
 */
public class Buki{
	/**
	 * 剣士のデフォルトデータ
	 */
	public static String DefKenshi = "片手剣,ハンターナイフ,240,1,84,,28@7@18@0@0@0@28@7@32@3@0@0,0,0,鉄鉱石×2,HR1,,,,,";
	/**
	 * ガンナーのデフォルトデータ
	 */
	public static String DefGunner = "ライトボウガン,クロスボウガン,325,1,96,火:2@回:3/3@毒:3/-@麻:3/-@睡:3/-,,0,3,鉄鉱石×4:竜骨【小】×2,HR1,通:6/6/9+@貫:3/3+/3+@散:2+/2+/2+@徹:3/1+/1+@拡:1+/1+/1+,捕:2@ペ:2,普通,中,";
	// オリジナル
	private String org;
	// 各武器共通
	private String type;
//	private boolean sp;	// いる？
	private String name;
	private int cost;
	private int rare;
	private int attack;
	private int def;
	private int kaishin;
	private int slots;
	private String sozai;	
	private int level;
	private String rank;
	private String reach;
	// 2012/1/30追加
	private boolean oyakata;
	// 12NOV追加
	private String bukitype;
	// 剣士固有
	private String attrType;
	private String spAttrType;
	private int attrAttack;
	private int spAttrAttack;
	private Kire kire;
	// 固有
	private Neiro neiro;		// 狩猟笛
	private Hougeki hougeki;	// ガンランス
	private Tame tame;			// 弓
	private Bin bin;			// 弓
	private Gun attrgun;		// ライトボウガン＆ヘビーボウガン
	private Gun nrmgun;			// ライトボウガン＆ヘビーボウガン
	private Gun spgun;			// ライトボウガン＆ヘビーボウガン
	private Reload reload;		// ライトボウガン＆ヘビーボウガン
	private Handou handou;		// ライトボウガン＆ヘビーボウガン
	private String super_sokusya;// ライトボウガン
	// 
	private boolean empty;
	private ArrayList<Sousyoku> sousyoku;

	/**
	 * コンストラクタ
	 * @param csvstr 文字列形式の武器データ
	 * @param t1 文字列形式の装飾品データ
	 * @param t2 文字列形式の装飾品データ
	 * @param t3 文字列形式の装飾品データ
	 */
	public Buki(String csvstr, String t1, String t2, String t3){
		this.setString(csvstr);
		// 珠情報
		this.sousyoku = new ArrayList<Sousyoku>();
		this.addSousyoku(new Sousyoku(t1));
		this.addSousyoku(new Sousyoku(t2));
		this.addSousyoku(new Sousyoku(t3));
		return;
	}
	/**
	 * コンストラクタ（装飾品はない扱い）
	 * @param csvstr 文字列形式の武器データ
	 */
	public Buki(String csvstr){
		this(csvstr, "", "", "");
		return;
	}
	/**
	 * 文字列形式の武器データをパーズ（解析）
	 * @param csvstr  文字列形式の武器データ
	 */
	public void setString(String csvstr){
		if(csvstr.equals(""))
			csvstr = DefKenshi;
		this.org = csvstr;
try{
		empty = true;
		if(this.sousyoku!=null)
			this.sousyoku.clear();
		String[] fields = CsvStringToList.split(csvstr, ",");
		// 長さチェック
//		if(fields.length<16)
//			return;
		empty = false;
		// 属性弾の準備
		this.attrgun = new Gun("");
		// タイプ
		this.type = fields[0].trim();
		// 名前
		String[] div = CsvStringToList.split(fields[1], "@");
		//this.name = fields[1].trim(); 12NOV削除
		this.name = div[0].trim();
		// 武器タイプ
		if( div.length >= 2 )
			this.bukitype = div[1].replace("（", "").replace("）", "");
		else
			this.bukitype = "";
		// 費用
		this.cost = Integer.parseInt(fields[2].trim());
		// レア度
		this.rare = Integer.parseInt(fields[3].trim());
		// 攻撃力
		this.attack = Integer.parseInt(fields[4].trim());
		// 属性＆防御
		setAttrAttack(fields[5]);
		// 切れ味
		this.kire = new Kire(fields[6]);
		// 会心率
		this.kaishin = Integer.parseInt(fields[7].trim());
		// スロット
		this.slots = Integer.parseInt(fields[8].trim());
		// 素材
		this.sozai = fields[9];
		// ランク
		this.rank = fields[10];
		// 武器毎
		if(	this.type.equals("狩猟笛")){
			this.neiro = new Neiro(fields[11]);
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else
		if(	this.type.equals("ガンランス")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki(fields[11]);
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else
		if(	this.type.equals("ライトボウガン")||
			this.type.equals("ヘビィボウガン")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun(fields[11]);
			this.spgun = new Gun(fields[12]);
			this.reload = new Reload(fields[13]);
			this.handou = new Handou(fields[14]);
			this.super_sokusya = fields[15].replaceAll("@", ",");
		}
		else
		if(	this.type.equals("弓")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame(fields[11]);
			this.bin = new Bin(fields[12]);
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else{
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		
}catch(Exception e){
	e.printStackTrace();
}
		return;
	}
	/**
	 * 武器データの削除（初期化）
	 */
	public void remove(){
		if(this.isKenshi())
			this.setString("");
		else
			this.setString(DefGunner);
		return;
	}
	/**
	 * 属性攻撃の設定
	 * @param src 文字列形式の属性攻撃データ
	 */
	private void setAttrAttack(String src){
		String[] parts = CsvStringToList.split(src, "@");
		// 初期化
		this.reach		= "";
		this.oyakata	= false;
		this.def		= 0;
		// 最初が空文字列なら終わる
		if(parts[0].equals(""))
			return;
		// あれば
		for(int idx=0; idx<parts.length; idx++){
			String[] temp = CsvStringToList.split(parts[idx], ":");
			if(temp[0].equals(""))
				continue;
			if(temp[0].startsWith("防"))
				this.def = (int) Double.parseDouble(temp[0].replaceAll("防", "").replace("+", ""));
			else
			// 弾なら
			if(parts[idx].indexOf("/")!=-1){
				this.attrgun.add(parts[idx]);
			}
			else
			if(temp[0].equals("麻痺") || temp[0].equals("毒") || temp[0].equals("睡眠")){
				this.spAttrType = temp[0];
				this.spAttrAttack = Integer.parseInt(temp[1]);
			}
			else
			if(temp[0].equals("リーチ"))
				this.reach = temp[1];
			else
			if(temp[0].equals("親方印"))
				this.oyakata = true;
			else{
				// 弾じゃなければ
				if(parts[idx].indexOf("/")==-1){
					this.attrType = temp[0];
					this.attrAttack = Integer.parseInt(temp[1]);
				}
				// 弾なら
				else{
					this.attrgun.add(parts[idx]);
				}
			}
		}
		return;
	}
	/**
	 * 武器データを文字列形式として取得
	 * @return 文字列形式の武器データ
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// オリジナルコピー
		res += this.org;
		return res;
	}
	/**
	 * 武器データが空であるかを取得
	 * @return true=空,false=防具データがある
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * 武器種を取得
	 * @return 武器種
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * 武器のタイプ名を取得(剣士orガンナー)
	 * @return 武器のタイプ名
	 */
	public String getTypeString(){
		if(this.isKenshi())
			return "剣士";
		return "ガンナー";
	}
	/**
	 * 剣士か否かを判定
	 * @param src 武器種名
	 * @return true=剣士,false=それ以外
	 */
	public static boolean isKenshi(String src){
		if(src.equals(""))
			return true;
		if(src.equals("片手剣"))
			return true;
		if(src.equals("双剣"))
			return true;
		if(src.equals("大剣"))
			return true;
		if(src.equals("太刀"))
			return true;
		if(src.equals("ハンマー"))
			return true;
		if(src.equals("狩猟笛"))
			return true;
		if(src.equals("ランス"))
			return true;
		if(src.equals("ガンランス"))
			return true;
		return false;
	}
	/**
	 * ガンナーか否かを判定
	 * @param src 武器種名
	 * @return true=ガンナー,false=それ以外
	 */
	public static boolean isGunner(String src){
		if(src.equals(""))
			return true;
		if(src.equals("ライトボウガン"))
			return true;
		if(src.equals("ヘビィボウガン"))
			return true;
		if(src.equals("弓"))
			return true;
		return false;
	}
	/**
	 * 文字列形式のリーチを数値で取得
	 * @param src 文字列形式のリーチ
	 * @return 数値のリーチ
	 */
	public static int getReachScalar(String src){
		if(src.equals("極短"))
			return 0;
		if(src.equals("短"))
			return 1;
		if(src.equals("中"))
			return 2;
		if(src.equals("長"))
			return 3;
		if(src.equals("極長"))
			return 4;
		if(src.equals("特殊Ａ"))
			return 5;
		return -1;
	}
	/**
	 * 数値のリーチを文字列形式で取得
	 * @param src 数値のリーチ
	 * @return 文字列形式のリーチ
	 */
	public static String getReachString(int src){
		if(src == 0)
			return "極短";
		if(src == 1)
			return "短";
		if(src == 2)
			return "中";
		if(src == 3)
			return "長";
		if(src == 4)
			return "極長";
		if(src == 5)
			return "特殊Ａ";
		return "エラー";
	}
	/**
	 * 武器倍から武器種を考慮して攻撃力を取得
	 * @param bukibai 武器倍
	 * @return 攻撃力
	 */
	public int getBukiAttack(int bukibai){
		if(empty)
			return 0;
		if(this.type.equals("片手剣"))
			return bukibai*14/10;
		if(this.type.equals("双剣"))
			return bukibai*14/10;
		if(this.type.equals("大剣"))
			return bukibai*48/10;
		if(this.type.equals("太刀"))
			return bukibai*48/10;
		if(this.type.equals("ハンマー"))
			return bukibai*52/10;
		if(this.type.equals("狩猟笛"))
			return bukibai*52/10;
		if(this.type.equals("ランス"))
			return bukibai*23/10;
		if(this.type.equals("ガンランス"))
			return bukibai*23/10;
		if(this.type.equals("ライトボウガン"))
			return bukibai*12/10;
		if(this.type.equals("ヘビィボウガン"))
			return bukibai*12/10;
		if(this.type.equals("弓"))
			return bukibai*12/10;
		return 0;
	}
	/**
	 * 武器種ごとの武器倍を取得
	 * @return 武器倍
	 */
	public int getBukiBairitsu(){
		if(empty)
			return this.getAttack();
		if(this.type.equals(""))
			return this.getAttack();
		if(this.type.equals("片手剣"))
			return this.getAttack()*10/14;
		if(this.type.equals("双剣"))
			return this.getAttack()*10/14;
		if(this.type.equals("大剣"))
			return this.getAttack()*10/48;
		if(this.type.equals("太刀"))
			return this.getAttack()*10/48;
		if(this.type.equals("ハンマー"))
			return this.getAttack()*10/52;
		if(this.type.equals("狩猟笛"))
			return this.getAttack()*10/52;
		if(this.type.equals("ランス"))
			return this.getAttack()*10/23;
		if(this.type.equals("ガンランス"))
			return this.getAttack()*10/23;
		if(this.type.equals("ライトボウガン"))
			return this.getAttack()*10/12;
		if(this.type.equals("ヘビィボウガン"))
			return this.getAttack()*10/12;
		if(this.type.equals("弓"))
			return this.getAttack()*10/12;
		return this.getAttack();
	}
	/**
	 * 武器倍から武器種を考慮して攻撃力を取得
	 * @param a 武器倍
	 * @return 攻撃力
	 */
	public int calBairitsu(int a){
		if(empty)
			return a;
		if(this.type.equals(""))
			return a;
		if(this.type.equals("片手剣"))
			return a*14/10;
		if(this.type.equals("双剣"))
			return a*14/10;
		if(this.type.equals("大剣"))
			return a*48/10;
		if(this.type.equals("太刀"))
			return a*48/10;
		if(this.type.equals("ハンマー"))
			return a*52/10;
		if(this.type.equals("狩猟笛"))
			return a*52/10;
		if(this.type.equals("ランス"))
			return a*23/10;
		if(this.type.equals("ガンランス"))
			return a*23/10;
		if(this.type.equals("ライトボウガン"))
			return a*12/10;
		if(this.type.equals("ヘビィボウガン"))
			return a*12/10;
		if(this.type.equals("弓"))
			return a*12/10;
		return a;
	}
	/**
	 * 剣士か否かを判定
	 * @return true=剣士,false=それ以外
	 */
	public boolean isKenshi(){
		if(empty)
			return true;
		if(this.type.equals(""))
			return true;
		if(this.type.equals("片手剣"))
			return true;
		if(this.type.equals("双剣"))
			return true;
		if(this.type.equals("大剣"))
			return true;
		if(this.type.equals("太刀"))
			return true;
		if(this.type.equals("ハンマー"))
			return true;
		if(this.type.equals("狩猟笛"))
			return true;
		if(this.type.equals("ランス"))
			return true;
		if(this.type.equals("ガンランス"))
			return true;
		return false;
	}
	/**
	 * ガンナーか否かを判定
	 * @return true=ガンナー,false=それ以外
	 */
	public boolean isGunner(){
		if(empty)
			return true;
		if(this.type.equals(""))
			return true;
		if(this.type.equals("ライトボウガン"))
			return true;
		if(this.type.equals("ヘビィボウガン"))
			return true;
		if(this.type.equals("弓"))
			return true;
		return false;
	}
	/**
	 * 武器の名前を取得
	 * @return 武器の名前
	 */
	public String getName(){
		if(empty)
			return "なし";
		return this.name;
	}
	/**
	 * SP武器か否かを判定
	 * @return true=SP武器,false=それ以外
	 */
	public boolean isSP(){
		if(empty)
			return false;
		if(this.name == null)
			return false;
		if(this.name.indexOf("SP")!=-1)
			return true;
		return false;
	}
	/**
	 * 武器が指定した種類（覇種武器など）
	 * @param t 武器の種類
	 * @return true=指定した種類と一致,false=それ以外
	 */
	public boolean isBukiType(String t){
		if(empty)
			return false;
		if(this.bukitype.indexOf(t)!=-1)
			return true;
		return false;
	}
	/**
	 * 武器の種類を取得
	 * @return 武器の種類
	 */
	public String getBukiType(){
		if(empty)
			return "";
		return this.bukitype;
	}
	/**
	 * 武器の攻撃力を取得
	 * @return 武器の攻撃力
	 */
	public int getAttack(){
		return this.getAttack(0);
	}
	/**
	 * 武器の攻撃力を取得（護符等の武器倍を考慮できる）
	 * @param gofu 護符などの武器倍
	 * @return 武器の攻撃力
	 */
	public int getAttack(int gofu){
		int res = this.attack;
		if(this.type.equals("片手剣"))
			res += gofu*14/10;
		if(this.type.equals("双剣"))
			res += gofu*14/10;
		if(this.type.equals("大剣"))
			res += gofu*48/10;
		if(this.type.equals("太刀"))
			res += gofu*48/10;
		if(this.type.equals("ハンマー"))
			res += gofu*52/10;
		if(this.type.equals("狩猟笛"))
			res += gofu*52/10;
		if(this.type.equals("ランス"))
			res += gofu*23/10;
		if(this.type.equals("ガンランス"))
			res += gofu*23/10;
		if(this.type.equals("ライトボウガン"))
			res += gofu*12/10;
		if(this.type.equals("ヘビィボウガン"))
			res += gofu*12/10;
		if(this.type.equals("弓"))
			res += gofu*12/10;
		if(this.getType().equals("ライトボウガン") || this.getType().equals("ヘビィボウガン"))
			return res+60;
		return res;
	}
	/**
	 * 文字列形式の属性攻撃タイプを取得
	 * @return 文字列形式の属性攻撃タイプ
	 */
	public String getAttrType(){
		if(empty)
			return "";
		if(this.attrType==null)
			return "";
		return this.attrType;
	}
	/**
	 * 文字列形式の異常属性攻撃タイプを取得
	 * @return 文字列形式の異常属性攻撃タイプ
	 */
	public String getSpAttrType(){
		if(empty)
			return "";
		if(this.spAttrType==null)
			return "";
		return this.spAttrType;
	}
	/**
	 * 文字列形式の属性攻撃を取得
	 * @return 文字列形式の属性攻撃
	 */
	public String getAttrAttackString(){
		if(this.attrType == null || this.attrType.trim().equals(""))
			return "";
		return this.attrType+" "+this.attrAttack;
	}
	/**
	 * 文字列形式の異常属性攻撃を取得
	 * @return 文字列形式の異常属性攻撃
	 */
	public String getSpAttrAttackString(){
		if(this.spAttrType == null || this.spAttrType.trim().equals(""))
			return "";
		return this.spAttrType+" "+this.spAttrAttack;
	}
	/**
	 * 武器のスキル（複数のときは「:」で区切る）をHTMLタグを入れて文字列で取得（事実上使わない）
	 * @param color 文字のカラーコード
	 * @return HTMLタグ入りのスキルの文字列
	 */
	public String getSkillsWithColorTag(String color){
//		String temp = this.getSkills();
		String temp = "";
		String[] list = CsvStringToList.split(temp, ":");
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, ":");
	}
	/**
	 * 武器と装飾品を合わせたスキルをHTMLタグ入りの文字列で取得（区切り文字列は「:」）
	 * @return HTMLタグ入りのスキルの文字列
	 */
	public String getSkillsWithSousyoku(){
		if(empty)
			return "";
		String res = "";	// 武器はスキルがないので
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(res.equals(""))
				res += this.sousyoku.get(idx).getSkills();
			else
				res += ":"+this.sousyoku.get(idx).getSkills();
		return res;
	}
	/**
	 * 武器と装飾品を合わせたスキルをスキルベクトルとして取得
	 * @return スキルベクトル
	 */
	public SkillVector getSkillVectorWithSousyoku(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		for(int idx=0; idx<this.sousyoku.size(); idx++){
			SkillVector s= new SkillVector(this.sousyoku.get(idx).getSkills(), ":");
			res = res.add(s);
		}
		return res;
	}
	/**
	 * 武器のスロット数（空きスロットではない）
	 * @return 武器のスロット数
	 */
	public int getSlot(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * 武器のスロット数を文字列で取得（例：○○ー）
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
	 * 武器の防御力を取得
	 * @return 武器の防御力
	 */
	public int getDef(){
		if(empty)
			return 0;
		return this.def;
	}
	/**
	 * 武器のレベル取得（事実上使わない）
	 * @return 武器のレベル
	 */
	public int getLevel(){
		if(empty)
			return 1;
		return this.level;
	}
	/**
	 * 武器の素材を文字列で取得
	 * @return 武器の素材
	 */
	public String getSozai(){
		if(empty)
			return "";
		return this.sozai;
	}
	/**
	 * 武器のレア度を取得
	 * @return 武器のレア度
	 */
	public int getRare(){
		if(empty)
			return 1;
		return this.rare;
	}
	/**
	 * 武器のリーチを取得
	 * @return 武器のリーチ
	 */
	public String getReach(){
		if(empty)
			return "中";
		if(this.reach == null)
			return "中";
		if(this.reach.equals(""))
			return "中";
		return this.reach;
	}
	/**
	 * 武器の親方印を文字列で取得
	 * @return 「親方印」or「」
	 */
	public String getOyakata(){
		if(this.oyakata)
			return "親方印";
		return "";
	}
	/**
	 * 武器の価格を取得
	 * @return 武器の価格
	 */
	public int getCost(){
		return this.cost;
	}
	/**
	 * 武器のランクを取得
	 * @return 武器のランク
	 */
	public String getRank(){
		return this.rank;
	}
	/**
	 * 武器の会心率を取得
	 * @return 武器の会心率
	 */
	public int getKaishin(){
		return this.kaishin;
	}
	/**
	 * 武器の斬れ味を取得
	 * @return 斬れ味
	 */
	public Kire getKire(){
		return this.kire;
	}
	/**
	 * 武器の音色を取得
	 * @return 武器の音色
	 */
	public Neiro getNeiro(){
		return this.neiro;
	}
	/**
	 * 武器の砲撃を取得
	 * @return 武器の砲撃
	 */
	public Hougeki getHougeki(){
		return this.hougeki;
	}
	/**
	 * 武器の溜めを取得
	 * @return 武器の溜め
	 */
	public Tame getTame(){
		return this.tame;
	}
	/**
	 * 武器のビン情報を取得
	 * @return 武器のビン情報
	 */
	public Bin getBin(){
		return this.bin;
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
	/**
	 * 武器の空きスロット数を取得
	 * @return 武器の空きスロット数
	 */
	public int getEmptySlots(){
		// 武器のスロット数取得
		int slots = this.getSlot();
		// 消費しているスロット数
		int spended = this.getSpendedSlots();
		return (slots - spended);
	}
	/**
	 * 武器の消費スロット数を取得
	 * @return 武器の消費スロット数
	 */
	public int getSpendedSlots(){
		// 消費しているスロット数
		int spended = 0;
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			spended += this.sousyoku.get(idx).getSlotCost();
		return spended;
	}
	/**
	 * 武器に装飾品データを追加（スロットが足りない場合は追加されない）
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
	 * 武器に付いている装飾品のリストを取得
	 * @return 装飾品データのリスト
	 */
	public ArrayList<Sousyoku> getSousyokuList(){
		if(this.sousyoku == null)
			return new ArrayList<Sousyoku>();
		return this.sousyoku;
	}
	/**
	 * 武器がつけている装飾品の名前を文字列で取得
	 * @param seq 複数の場合の区切り文字列
	 * @return 装飾品の名前
	 */
	public String getTamaNames(String seq){
		String res = "";
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(idx==0)
				res += this.sousyoku.get(idx).getName();
			else
				res += ","+this.sousyoku.get(idx).getName();
		return res;
	}
	/**
	 * 武器のリロードを取得
	 * @return 武器のリロード
	 */
	public Reload getReload(){
		return this.reload;
	}
	/**
	 * 武器の反動を取得
	 * @return 武器の反動
	 */
	public Handou getHandou(){
		return this.handou;
	}
	/**
	 * 武器の速射を取得
	 * @return 武器の速射
	 */
	public String getSokusya(){
		if( this.super_sokusya == null)
			return "";
		return this.super_sokusya;
	}
	/**
	 * 武器の弾情報を取得
	 * @return 武器の弾情報
	 */
	public Gun getNrmGun(){
		return this.nrmgun;
	}
	/**
	 * 武器の弾情報を取得（属性弾など）
	 * @return 武器の弾情報（属性弾など）
	 */
	public Gun getAttrGun(){
		return this.attrgun;
	}
	/**
	 * 武器の弾情報を取得（異常属性弾など）
	 * @return 武器の弾情報（異常属性弾など）
	 */
	public Gun getSpGun(){
		return this.spgun;
	}
}
