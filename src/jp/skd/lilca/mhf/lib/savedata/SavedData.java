package jp.skd.lilca.mhf.lib.savedata;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Bougu;
import jp.skd.lilca.mhf.lib.bougu.Kafus;
import jp.skd.lilca.mhf.lib.bougu.Sousyoku;
import jp.skd.lilca.mhf.lib.buki.Buki;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

//import android.app.Activity;

/**
 * 装備データを抽象化したクラス
 * データを直接編集する「メモリ領域」とデータ保存用の「文字列リスト」の二重構造になっている
 */
public class SavedData {
	/**
	 * 文字列リストのサイズ
	 */
	public static final int DATA_SIZE		= 29;
	/**
	 * 文字列リストの武器情報のインデックス
	 */
	public static final int ID_BUKI			= 0;
	/**
	 * 文字列リストの武器についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_BUKI_TAMA_1	= 1;
	/**
	 * 文字列リストの武器についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_BUKI_TAMA_2	= 2;
	/**
	 * 文字列リストの武器についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_BUKI_TAMA_3	= 3;
	/**
	 * 文字列リストの頭防具情報のインデックス
	 */
	public static final int ID_ATAMA		= 4;
	/**
	 * 文字列リストの頭防具についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_ATAMA_TAMA_1	= 5;
	/**
	 * 文字列リストの頭防具についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_ATAMA_TAMA_2	= 6;
	/**
	 * 文字列リストの頭防具についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_ATAMA_TAMA_3	= 7;
	/**
	 * 文字列リストの胴防具情報のインデックス
	 */
	public static final int ID_DOU			= 8;
	/**
	 * 文字列リストの胴防具についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_DOU_TAMA_1	= 9;
	/**
	 * 文字列リストの胴防具についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_DOU_TAMA_2	= 10;
	/**
	 * 文字列リストの胴防具についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_DOU_TAMA_3	= 11;
	/**
	 * 文字列リストの腕防具情報のインデックス
	 */
	public static final int ID_UDE			= 12;
	/**
	 * 文字列リストの腕防具についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_UDE_TAMA_1	= 13;
	/**
	 * 文字列リストの腕防具についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_UDE_TAMA_2	= 14;
	/**
	 * 文字列リストの腕防具についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_UDE_TAMA_3	= 15;
	/**
	 * 文字列リストの腰防具情報のインデックス
	 */
	public static final int ID_KOSHI		= 16;
	/**
	 * 文字列リストの腰防具についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_KOSHI_TAMA_1	= 17;
	/**
	 * 文字列リストの腰防具についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_KOSHI_TAMA_2	= 18;
	/**
	 * 文字列リストの腰防具についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_KOSHI_TAMA_3	= 19;
	/**
	 * 文字列リストの脚防具情報のインデックス
	 */
	public static final int ID_ASHI			= 20;
	/**
	 * 文字列リストの脚防具についてる装飾品(1)情報のインデックス
	 */
	public static final int ID_ASHI_TAMA_1	= 21;
	/**
	 * 文字列リストの脚防具についてる装飾品(2)情報のインデックス
	 */
	public static final int ID_ASHI_TAMA_2	= 22;
	/**
	 * 文字列リストの脚防具についてる装飾品(3)情報のインデックス
	 */
	public static final int ID_ASHI_TAMA_3	= 23;
	/**
	 * 文字列リストの要求スキルのインデックス
	 */
	public static final int ID_REQ_SKILLS	= 24;
	/**
	 * 文字列リストのカフ(1)情報のインデックス
	 */
	public static final int ID_KAFU_TAMA_1	= 25;
	/**
	 * 文字列リストのカフ(2)情報のインデックス
	 */
	public static final int ID_KAFU_TAMA_2	= 26;
	/**
	 * 文字列リストの拡張情報のインデックス
	 */
	public static final int ID_EXINFO		= 27;
	/**
	 * 文字列リストのタイトルのインデックス
	 */
	public static final int ID_TITLE		= 28;
	// EX_INFOのフィールドID
	/**
	 * 拡張データ内の性別情報のインデックス
	 */
	public static final int ID_EX_GENDER	= 0;	// 男 or 女
	/**
	 * 拡張データ内の性別情報のインデックス
	 */
	public static final int ID_EX_RANK		= 1;	// HR, SR1, SR5, SR100 etc.
	/**
	 * 拡張データ内の護符情報のインデックス
	 */
	public static final int ID_EX_GOFU		= 2;	// NNFF = 力の護符ON,力の爪ON,守りの護符OFF,守りの爪OFF

	/**
	 * 装備データで装備できるカフの最大数
	 */
	public static final int KAFUS_SIZE		= 2;

	private static final int[] bouguId = {ID_ATAMA,ID_DOU,ID_UDE,ID_KOSHI,ID_ASHI};

	/**
	 * プログラム上での保存領域
	 */
	private String title;
	private String gender;
	private String rank;
	private String gofu;
	private Buki buki;
	private Bougu[] bougu;
	private ArrayList<Kafus> kafus;
	private String[] reqSkills;
	/**
	 * Csv形式での保存領域
	 */
	private String[] elements = new String[DATA_SIZE];
	//

	/**
	 * コンストラクタ
	 */
	public SavedData(){
		this.init();
		this.toMemory();
		return;
	}
	/**
	 * 文字列リストの初期化
	 */
	public void init(){
		for(int idx=0; idx<DATA_SIZE; idx++)
			this.elements[idx] = "";
		return;
	}
	/**
	 * 装備データの初期化（「メモリ領域」、「文字列リスト」ともに）
	 */
	public void clearSoubi(){
		this.toCsv();
		String buffer1 = this.elements[ID_REQ_SKILLS];
		String buffer2 = this.elements[ID_EXINFO];
		String buffer3 = this.elements[ID_TITLE];
		String buffer4 = this.elements[ID_BUKI];
		String buffer5 = this.elements[ID_BUKI_TAMA_1];
		String buffer6 = this.elements[ID_BUKI_TAMA_2];
		String buffer7 = this.elements[ID_BUKI_TAMA_3];
		this.init();
		this.elements[ID_REQ_SKILLS] = buffer1;
		this.elements[ID_EXINFO] = buffer2;
		this.elements[ID_TITLE] = buffer3;
		this.elements[ID_BUKI] = buffer4;
		this.elements[ID_BUKI_TAMA_1] = buffer5;
		this.elements[ID_BUKI_TAMA_2] = buffer6;
		this.elements[ID_BUKI_TAMA_3] = buffer7;
		this.toMemory();
		return;
	}
	/**
	 * 文字列リストの内容をメモリ領域へ反映（上書き）
	 */
	public void toMemory(){
		this.title	= this.elements[ID_TITLE];
		this.buki	= new Buki(
				this.elements[ID_BUKI],
				this.elements[ID_BUKI_TAMA_1],
				this.elements[ID_BUKI_TAMA_2],
				this.elements[ID_BUKI_TAMA_3]);
		this.bougu	= new Bougu[5];
		this.bougu[0] = new Bougu(
				this.elements[ID_ATAMA],
				this.elements[ID_ATAMA_TAMA_1],
				this.elements[ID_ATAMA_TAMA_2],
				this.elements[ID_ATAMA_TAMA_3]);
		this.bougu[1] = new Bougu(
				this.elements[ID_DOU],
				this.elements[ID_DOU_TAMA_1],
				this.elements[ID_DOU_TAMA_2],
				this.elements[ID_DOU_TAMA_3]);
		this.bougu[2] = new Bougu(
				this.elements[ID_UDE],
				this.elements[ID_UDE_TAMA_1],
				this.elements[ID_UDE_TAMA_2],
				this.elements[ID_UDE_TAMA_3]);
		this.bougu[3] = new Bougu(
				this.elements[ID_KOSHI],
				this.elements[ID_KOSHI_TAMA_1],
				this.elements[ID_KOSHI_TAMA_2],
				this.elements[ID_KOSHI_TAMA_3]);
		this.bougu[4] = new Bougu(
				this.elements[ID_ASHI],
				this.elements[ID_ASHI_TAMA_1],
				this.elements[ID_ASHI_TAMA_2],
				this.elements[ID_ASHI_TAMA_3]);
		this.kafus = new ArrayList<Kafus>();
		for(int idx=0; idx<KAFUS_SIZE; idx++){
			String temp = this.elements[ID_KAFU_TAMA_1+idx];
			if(!temp.equals(""))
				this.kafus.add(new Kafus(this.elements[ID_KAFU_TAMA_1+idx]));
		}
		// エキストラ情報
		String temp = this.elements[ID_EXINFO];
		this.gender	= getExInfo(temp, ID_EX_GENDER);
		this.rank	= getExInfo(temp, ID_EX_RANK);
		this.gofu	= getExInfo(temp, ID_EX_GOFU);
		// 必要スキル情報
		if(this.elements[ID_REQ_SKILLS].equals("")){
			this.reqSkills = null;
		}
		else{
			this.reqSkills = CsvStringToList.split(this.elements[ID_REQ_SKILLS], ",");
		}
		return;
	}
	/**
	 * 文字列形式の拡張情報内の指定したインデックスの情報を取得
	 * @param data 文字列形式の拡張情報
	 * @param id 指定インデックス
	 * @return 指定した情報
	 */
	private String getExInfo(String data, int id){
		String [] res = CsvStringToList.split(data, ",");
		if(id == ID_EX_GENDER){
			if(!res[0].equals(""))
				return res[0];
			else
				return "男";
		}
		if(id == ID_EX_RANK){
			if(res.length >= 2)
				return res[1];
			else
				return "HR";
		}
		if(id == ID_EX_GOFU){
			if(res.length >= 3)
				if(res[2].equals(""))
					return "FFFF";
				else
					return res[2];
			else
				return "FFFF";
		}		
		return "";
	}
	/**
	 * メモリ領域の拡張情報を文字列に変換
	 * @return 文字列形式の拡張情報
	 */
	private String getExInfoString(){
		String res = "";
		res += this.gender;
		res += "," + this.rank;
		res += "," + this.gofu;
		return res;
	}
	/**
	 * メモリ領域の内容を文字列リストに反映（上書き）
	 */
	public void toCsv(){
		this.init();
		this.elements[ID_TITLE] = this.title;
		ArrayList<Sousyoku> list;
		this.elements[ID_BUKI]			= this.getBuki().getCsvString();
		list = this.getBuki().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_BUKI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// 頭
		this.elements[ID_ATAMA]			= this.getAtama().getCsvString();
		list = this.getAtama().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_ATAMA_TAMA_1+idx]	= list.get(idx).getCsvString();
		// 胴
		this.elements[ID_DOU]			= this.getDou().getCsvString();
		list = this.getDou().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_DOU_TAMA_1+idx]	= list.get(idx).getCsvString();
		// 腕
		this.elements[ID_UDE]			= this.getUde().getCsvString();
		list = this.getUde().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_UDE_TAMA_1+idx]	= list.get(idx).getCsvString();
		// 腰
		this.elements[ID_KOSHI]			= this.getKoshi().getCsvString();
		list = this.getKoshi().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_KOSHI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// 脚
		this.elements[ID_ASHI]			= this.getAshi().getCsvString();
		list = this.getAshi().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_ASHI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// カフ
		this.elements[ID_KAFU_TAMA_1] = "";
		this.elements[ID_KAFU_TAMA_2] = "";
		for(int idx=0; idx<this.kafus.size(); idx++)
			this.elements[ID_KAFU_TAMA_1+idx] = this.kafus.get(idx).getCsvString();
		// エキストラ情報
		this.elements[ID_EXINFO] = getExInfoString();
		// 必要スキル情報
		if(this.reqSkills == null)
			this.elements[ID_REQ_SKILLS] = "";
		else{
			this.elements[ID_REQ_SKILLS] = CsvStringToList.scat(this.reqSkills, ",");
		}
		return;
	}
	/**
	 * タイトルを取得
	 * @return タイトル
	 */
	public String getTitle(){
		if(this.title == null)
			return "<タイトルなし>";
		if(this.title.equals(""))
			return "<タイトルなし>";
		if(this.title.equals("null"))
			return "<タイトルなし>";
		return this.title;
	}
	/**
	 * 性別を取得
	 * @return 性別
	 */
	public String getGender(){
		return this.gender;
	}
	/**
	 * 性別が男か判別
	 * @return true=男性,false=女性
	 */
	public boolean isMale(){
		if(this.gender.equals("男"))
			return true;
		return false;
	}
	/**
	 * 性別を設定
	 * @param gen 性別
	 */
	public void setGender(String gen){
		this.gender = gen;
		return;
	}
	/**
	 * 攻撃系護符の武器倍を取得
	 * @return 武器倍
	 */
	public int getGofuTsumePower(){
		int res = 0;
		if(this.isPwrGofu())
			res += 5;
		if(this.isPwrTsume())
			res += 9;
		return res;
	}
	/**
	 * 防御系護符の防御力を取得
	 * @return 防御力
	 */
	public int getGofuTsumeDefence(){
		int res = 0;
		if(this.isDefGofu())
			res += 16;
		if(this.isDefTsume())
			res += 24;
		return res;
	}
	/**
	 * 護符情報の表示用文字列を取得
	 * @return 表示用の護符情報
	 */
	public String getGofuTsumeString(){
		String res = "";
		if(isPwrGofu())
			res += "力の護符, ";
		if(isPwrTsume())
			res += "力の爪, ";
		if(isDefGofu())
			res += "守りの護符, ";
		if(isDefTsume())
			res += "守りの爪, ";
		if(res.equals(""))
			return "なし";
		return res.substring(0, res.length()-2);
	}
	/**
	 * 要求スキルを取得
	 * @return 要求スキル
	 */
	public String[] getReqSkills(){
		return this.reqSkills;
	}
	/**
	 * 要求スキルを指定した改行文字列で区切った文字列を取得
	 * @param lr 改行文字列
	 * @return 要求スキル（改行済み）
	 */
	public String getReqSkillsWithReturn(String lr){
		if( this.reqSkills == null )
			return "";
		String res = "";
		for(int idx=0; idx<this.reqSkills.length; idx++)
			res += lr+this.reqSkills[idx];
		return res.substring(lr.length());
	}
	/**
	 * 要求スキル内の指定したインデックスのスキル情報を取得
	 * @param a 指定インデックス
	 * @return スキル情報
	 */
	public String getReqSkill(int a){
		if( this.reqSkills == null )
			return null;
		if( a >= this.reqSkills.length )
			return null;
		return this.reqSkills[a];
	}
	/**
	 * 要求スキルのスキル数を取得
	 * @return 要求スキルのスキル数
	 */
	public int getReqSkillSize(){
		if(this.reqSkills == null)
			return 0;
		return this.reqSkills.length;
	}
	/**
	 * 護符情報を格納
	 * @param pg 力の護符の有無
	 * @param pt 力の爪の有無
	 * @param dg 守りの護符の有無
	 * @param dt 守りの爪の有無
	 */
	public void setGofuTsume(boolean pg, boolean pt, boolean dg, boolean dt){
		String val = "";
		if(pg) val += "T"; else val += "F";
		if(pt) val += "T"; else val += "F";
		if(dg) val += "T"; else val += "F";
		if(dt) val += "T"; else val += "F";
		this.gofu = val;
		return;
	}
	/**
	 * 要求スキルを格納
	 * @param req 要求スキル（配列）
	 */
	public void setReqSkills(String[] req){
		this.reqSkills = req;
		return;
	}
	/**
	 * 力の護符があるか否か
	 * @return true=ある,false=ない
	 */
	public boolean isPwrGofu(){
		if(this.gofu.substring(0, 1).equals("T"))
			return true;
		return false;
	}
	/**
	 * 力の爪があるか否か
	 * @return true=ある,false=ない
	 */
	public boolean isPwrTsume(){
		if(this.gofu.substring(1, 2).equals("T"))
			return true;
		return false;
	}
	/**
	 * 守りの護符があるか否か
	 * @return true=ある,false=ない
	 */
	public boolean isDefGofu(){
		if(this.gofu.substring(2, 3).equals("T"))
			return true;
		return false;
	}
	/**
	 * 守りの爪があるか否か
	 * @return true=ある,false=ない
	 */
	public boolean isDefTsume(){
		if(this.gofu.substring(3, 4).equals("T"))
			return true;
		return false;
	}
	/**
	 * 剣士か否か
	 * @return true=剣士,false=剣士でない
	 */
	public boolean isKenshi(){
		return this.buki.isKenshi();
	}
	/**
	 * ガンナーか否か
	 * @return true=ガンナー,false=ガンナーでない
	 */
	public boolean isGunner(){
		return this.buki.isGunner();
	}
	/**
	 * 武器情報を取得
	 * @return 武器情報
	 */
	public Buki getBuki(){
		return this.buki;
	}
	/**
	 * 頭防具情報を取得
	 * @return 頭防具情報
	 */
	public Bougu getAtama(){
		return this.bougu[0];
	}
	/**
	 * 胴防具情報を取得
	 * @return 胴防具情報
	 */
	public Bougu getDou(){
		return this.bougu[1];
	}
	/**
	 * 腕防具情報を取得
	 * @return 腕防具情報
	 */
	public Bougu getUde(){
		return this.bougu[2];
	}
	/**
	 * 腰防具情報を取得
	 * @return 腰防具情報
	 */
	public Bougu getKoshi(){
		return this.bougu[3];
	}
	/**
	 * 脚防具情報を取得
	 * @return 脚防具情報
	 */
	public Bougu getAshi(){
		return this.bougu[4];
	}
	/**
	 * 指定した部位の防具情報を取得
	 * @param bui 指定部位
	 * @return 防具情報
	 */
	public Bougu getBougu(String bui){
		if(bui.equals("頭"))
			return this.bougu[0];
		else
		if(bui.equals("胴"))
			return this.bougu[1];
		else
		if(bui.equals("腕"))
			return this.bougu[2];
		else
		if(bui.equals("腰"))
			return this.bougu[3];
		else
		if(bui.equals("脚"))
			return this.bougu[4];
		return null;
	}
	/**
	 * カフ情報を取得
	 * @return カフ情報リスト
	 */
	public ArrayList<Kafus> getKafus(){
		return this.kafus;
	}
	/**
	 * タイトルを格納
	 * @param t タイトル
	 */
	public void setTitle(String t){
		this.title = t;
		return;
	}
	/**
	 * 武器情報を格納
	 * @param s 武器情報
	 */
	public void setBuki(Buki s){
		this.buki = s;
		this.elements[ID_BUKI] = s.getCsvString();
		return;
	}
	/**
	 * 頭防具情報を格納
	 * @param s 頭防具情報
	 */
	public void setAtama(Bougu s){
		this.bougu[0] = s;
		this.elements[ID_ATAMA] = s.getCsvString();
		return;
	}
	/**
	 * 胴防具情報を格納
	 * @param s 胴防具情報
	 */
	public void setDou(Bougu s){
		this.bougu[1] = s;
		this.elements[ID_DOU] = s.getCsvString();
		return;
	}
	/**
	 * 腕防具情報を格納
	 * @param s 腕防具情報
	 */
	public void setUde(Bougu s){
		this.bougu[2] = s;
		this.elements[ID_UDE] = s.getCsvString();
		return;
	}
	/**
	 * 腰防具情報を格納
	 * @param s 腰防具情報
	 */
	public void setKoshi(Bougu s){
		this.bougu[3] = s;
		this.elements[ID_KOSHI] = s.getCsvString();
		return;
	}
	/**
	 * 脚防具情報を格納
	 * @param s 脚防具情報
	 */
	public void setAshi(Bougu s){
		this.bougu[4] = s;
		this.elements[ID_ASHI] = s.getCsvString();
		return;
	}
	/**
	 * カフの空きスロット数を取得
	 * @return カフの空きスロット数
	 */
	public int getEmptyKafusSlots(){
		int res = KAFUS_SIZE;
		for(int idx=0; idx<this.kafus.size(); idx++)
			res -= this.kafus.get(idx).getSlotCost();
		return res;
	}
	/**
	 * カフの名前を指定した区切り文字列で編集して変換
	 * @param seq 区切り文字列
	 * @return カフの名前
	 */
	public String getKafuNames(String seq){
		String res = "";
		for(int idx=0; idx<this.kafus.size(); idx++)
			if(idx==0)
				res += this.kafus.get(idx).getName();
			else
				res += seq+this.kafus.get(idx).getName();
		return res;
	}
	/**
	 * 剣士orガンナーから、適合しない防具を外す
	 */
	public void ifNotTakeoff(){
		for(int idx=0; idx<bougu.length; idx++){
			this.bougu[idx].ifNotTakeoff(this.buki.isKenshi());
			this.elements[bouguId[idx]] = this.bougu[idx].getCsvString();
		}
		return;
	}
	/**
	 * 性別から、適合しない防具を外す
	 */
	public void ifNotTakeoffSexually(){
		for(int idx=0; idx<bougu.length; idx++){
			this.bougu[idx].ifNotTakeoffSexually(this.isMale());
			this.elements[bouguId[idx]] = this.bougu[idx].getCsvString();
		}
		return;
	}
	/**
	 * 文字列リストを文字列に変換して取得
	 * @return 文字列形式の装備データ
	 */
	public String getAllElementsToString(){
		return CsvStringToList.scat(this.elements, "<enter>");
	}
	/**
	 * 文字列形式の装備データを、文字列リストに格納
	 * @param src 文字列形式の装備データ
	 */
	public void setAllElementsToString(String src){
		String[] list = CsvStringToList.split(src, "<enter>");
		for(int idx=0; idx<list.length && idx<DATA_SIZE; idx++)
			this.setElement(idx, list[idx]);
		this.toMemory();
		return;
	}
	/**
	 * 文字列リストの指定したインデックに格納
	 * @param id 指定インデックス
	 * @param in 格納する文字列
	 */
	public void setElement(int id, String in){
		this.elements[id] = in;
		return;
	}
	/**
	 * 文字列リストの指定したインデックスの文字列を取得
	 * @param id 指定インデックス
	 * @return 取得する文字列
	 */
	public String getElement(int id){
		return this.elements[id];
	}
	/**
	 * 装備データの全体のスキルベクトルを取得
	 * @return 装備データの全体のスキルベクトル
	 */
	public SkillVector getTotalSkillVector(){
		SkillVector res = new SkillVector();
		for(int idx=0; idx<this.bougu.length; idx++){
			res = res.add(this.bougu[idx].getSkillVectorWithSousyoku());
		}
		res = res.add(this.buki.getSkillVectorWithSousyoku());
		for(int idx=0; idx<this.kafus.size(); idx++)
			res = res.add(this.kafus.get(idx).getSkillVector());
		return res;
	}
	/**
	 * 武器情報を入替え
	 * @param s 新たに格納する武器情報
	 */
	public void replaceBuki(Buki s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getBuki().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setBuki(s);
		return;
	}
	/**
	 * 頭防具情報を入替え
	 * @param s 新たに格納する頭防具情報
	 */
	public void replaceAtama(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getAtama().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setAtama(s);
		return;
	}
	/**
	 * 胴防具情報を入替え
	 * @param s 新たに格納する胴防具情報
	 */
	public void replaceDou(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getDou().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setDou(s);
		return;
	}
	/**
	 * 腕防具情報を入替え
	 * @param s 新たに格納する腕防具情報
	 */
	public void replaceUde(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getUde().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setUde(s);
		return;
	}
	/**
	 * 腰防具情報を入替え
	 * @param s 新たに格納する腰防具情報
	 */
	public void replaceKoshi(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getKoshi().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setKoshi(s);
		return;
	}
	/**
	 * 脚防具情報を入替え
	 * @param s 新たに格納する脚防具情報
	 */
	public void replaceAshi(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getAshi().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setAshi(s);
		return;
	}
	// 29AUG13 add
	/**
	 * 指定したスキルを要求スキルから除外
	 * @param name 除外するスキルの名前
	 */
	public void removeReqSkill(String name){
		ArrayList<String> res = new ArrayList<String>();
		for(int idx=0; idx<this.reqSkills.length; idx++){
			// 該当以外（該当は）
			if( !name.equals(this.reqSkills[idx]) ){
				res.add(reqSkills[idx]);
			}
		}
		this.reqSkills = (String[])res.toArray(new String[0]);
		return;
	}
	/**
	 * 要求スキルを一つ追加
	 * @param name 追加するスキル
	 */
	public void addReqSkill(String name){
		ArrayList<String> res = new ArrayList<String>();
		for(int idx=0; idx<this.reqSkills.length; idx++){
			res.add(reqSkills[idx]);
		}
		res.add(name);
		this.reqSkills = (String[])res.toArray(new String[0]);
		return;
	}
}
