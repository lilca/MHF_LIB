package jp.skd.lilca.mhf.lib.skill_value_list;

import java.util.ArrayList;
import java.util.HashMap;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * スキル情報を抽象化したクラス
 */
public class SkillInfoData {

	private ArrayList<String> list;
	private HashMap<String, String> boot2skill;
	private HashMap<String, Integer> boot2value;
	private HashMap<String, Boolean> boot2rank;
	// 12NOV追加　2重のレコードを保存
	private ArrayList<String> doubleList;
	// 13AUG追加　スキルの発動スキルリストを保存
	private HashMap<String, String> skill2boots;

	/**
	 * コンストラクタ
	 * @param lst スキル情報ファイルの文字列リスト
	 * @param bt2skill 発動スキル=>スキル名のハッシュマップ
	 * @param bt2value 発動スキル=>スキル値のハッシュマップ
	 * @param bt2rank 発動スキル=>ランクアップのハッシュマップ
	 * @param dlist 二重装備の発動スキルのリスト
	 * @param skill2bts スキル=>発動スキルリストのハッシュマップ
	 */
	public SkillInfoData(	ArrayList<String> lst,
							HashMap<String, String> bt2skill,
							HashMap<String, Integer> bt2value,
							HashMap<String, Boolean> bt2rank,
							ArrayList<String> dlist,
							HashMap<String, String> skill2bts){
		list		= lst;
		boot2skill	= bt2skill;
		boot2value	= bt2value;
		boot2rank	= bt2rank;
		doubleList	= dlist;
		skill2boots	= skill2bts;
		return;
	}
	/**
	 * コンストラクタ
	 * @param str 入力テキストファイル（文字列で）
	 * @param ret 改行文字列
	 */
	public SkillInfoData(String str, String ret){
		// 初期化
		list		= new ArrayList<String>();
		boot2skill	= new HashMap<String, String>();
		boot2value	= new HashMap<String, Integer>();
		boot2rank	= new HashMap<String, Boolean>();
		doubleList	= new ArrayList<String>();
		skill2boots	= new HashMap<String, String>();

		// 改行で分割
		String[] lines = CsvStringToList.split(str, ret);
		//
		String line = "";
        String preName = "";
       	int preVal = 0;
       	for(int idx=0; idx<lines.length; idx++){
       		line	= lines[idx];
       		// 空行をスキップ
       		if( line.replaceAll(" ", "").equals("") )
       			continue;
       		list.add(line);
       		String[] data = CsvStringToList.split(line, ",");
       		String name		= data[0];
       		String valStr	= data[1];
       		String skill	= data[2];
       		// 2重のとき
       		if( valStr.equals("2重") ){
       			doubleList.add(line);
       		}
       		else{
       			boot2skill.put(skill, name);
       			boot2value.put(skill, Integer.parseInt(valStr));
       			// スキルの最上位以外
       			if(preName.equals(name))
       				boot2rank.put(skill, SkillValueList.isRankUpable(name));
       			// スキルの最上位
       			else{
       				boot2rank.put(skill, false);
       				// １つ前の値が負だったら
       				if( preVal < 0 )
           				boot2rank.put(preName, false);
       			}
       			// 発動リスト
       			if( skill2boots.get(name) == null ){
       				skill2boots.put(name, skill);
       			}
       			else{
       				skill2boots.put(name, skill2boots.get(name)+":"+skill);
       			}
           		preName = name;
           		preVal	= Integer.parseInt(valStr);
       		}
       	}
       	// 最後のスキルもfalse
		boot2rank.put(preName, false);
    	
		return;
	}
	/**
	 * スキル情報を取得
	 * @return スキル情報
	 */
	public SkillInfoData getData(){
		return this;
	}
	/**
	 * スキル情報ファイルの文字列リストを取得
	 * @return スキル情報ファイルの文字列リスト
	 */
	public ArrayList<String> getSkillList(){
		return this.list;
	}
	/**
	 * 発動スキルからスキル名を取得
	 * @param bootSkillName 発動スキル
	 * @return スキル名
	 */
	public String getSkillName(String bootSkillName){
		return boot2skill.get(bootSkillName);
	}
	/**
	 * 発動スキルからスキル値を取得
	 * @param bootSkillName 発動スキル
	 * @return スキル値
	 */
	public Integer getSkillValue(String bootSkillName){
		return boot2value.get(bootSkillName);
	}
	/**
	 * 発動スキルからランクアップの有無を取得
	 * @param bootSkillName 発動スキル
	 * @return ランクアップの有無
	 */
	public Boolean getSkillRank(String bootSkillName){
		return boot2rank.get(bootSkillName);
	}
	/**
	 * 一つ上の発動スキルを取得
	 * 上がない場合は、空文字列を返す
	 * @param bootSkillName 発動スキル
	 * @return 一つ上の発動スキル
	 */
	public String getAboveBootSkillName(String bootSkillName){
		String skillname	= boot2skill.get(bootSkillName);
		String liststr		= skill2boots.get(skillname);
		String[] list		= CsvStringToList.split(liststr, ":");
		int idx;
		for(idx=0; idx<list.length; idx++){
			if( bootSkillName.equals(list[idx]) ){
				break;
			}
		}
		// 一番上なら
		if( idx == 0 ){
			return "";
		}else
		return list[idx-1];
	}
	/**
	 * 一つ下の発動スキルを取得
	 * 下がない場合は、空文字列を返す
	 * @param bootSkillName 発動スキル
	 * @return 一つ下の発動スキル
	 */
	public String getBelowBootSkillName(String bootSkillName){
		String skillname	= boot2skill.get(bootSkillName);
		String liststr		= skill2boots.get(skillname);
		String[] list		= CsvStringToList.split(liststr, ":");
		int idx;
		for(idx=0; idx<list.length; idx++){
			if( bootSkillName.equals(list[idx]) ){
				break;
			}
		}
		// 一番下なら
		if( idx >= list.length - 1 ){
			return "";
		}else
		return list[idx+1];
	}
	/**
	 * 指定したスキル名、スキル値で発動するスキルを算出
	 * @param name スキル名
	 * @param val スキル値
	 * @param rankup true=ランクアップ考慮,false=考慮しない
	 * @return 発動結果
	 */
	public ResultBootSkill getBootSkill(String name, int val, boolean rankup){
		// 該当の前後
		String preSkill = "";
		String preLastSkill = "";
		String nxtSkill = "";
		boolean sign	= false;
		//
		String[] possible = null;
		for(int idx=0; idx<this.list.size(); idx++){
			String[] temp = CsvStringToList.split(list.get(idx), ",");
			// 2重のスキップ
			if( temp[1].equals("2重") )
				continue;
			String[] nextTemp = null;
			if( rankup && boot2rank.get(temp[2]) )
				nextTemp = CsvStringToList.split(list.get(idx+1), ",");
			// スキル名が該当しなかったら
			if(!temp[0].equals(name))
				continue;
			int v = Integer.parseInt(temp[1]);
			// 符号が互い違いなら
			if((val * v)<0)
				continue;
			// 符号設定
			if(val<0)	sign = false;
			else		sign = true;
			// 絶対値が大きかったら
			if(Math.abs(val)>=Math.abs(v)){
				// 最初の該当レコード
				if(possible == null){
					preLastSkill = preSkill;
					possible = temp;
				}
				// ２番目以降の該当レコード
				else{
					// 既知の値より大きかったら入れ替える
					if(Math.abs(v)>Math.abs(Integer.parseInt(possible[1]))){
						if( rankup && boot2rank.get(temp[2]) )
							nxtSkill	= nextTemp[2];	// 該当したスキルの次
						possible	= temp;
					}
				}
			}
			//
			preSkill = temp[2];
		}
		if(possible==null)
			return new ResultBootSkill("", false);
		if( rankup && boot2rank.get(possible[2]) ){
			if( sign )	return new ResultBootSkill(preLastSkill, true);
			else		return new ResultBootSkill(nxtSkill, true);
		}
		return new ResultBootSkill(possible[2], false);
	}
}
