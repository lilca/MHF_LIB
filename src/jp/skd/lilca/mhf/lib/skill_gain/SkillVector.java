package jp.skd.lilca.mhf.lib.skill_gain;

import java.util.HashMap;
import java.util.Iterator;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * スキルベクトルを抽象化したクラス
 */
public class SkillVector {

	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * コンストラクタ
	 */
	public SkillVector(){
		this.map.clear();
		return;
	}
	/**
	 * コンストラクタ
	 * @param csv CSV形式のスキルベクトル
	 */
	public SkillVector(String csv){
		String[] temp = CsvStringToList.split(csv, ",");
		for(int idx=0; idx<temp.length; idx++){
			SkillScalar ss = new SkillScalar(temp[idx]);
			map.put(ss.getSkillName(), ss.getSkillValue());
		}
		return;
	}
	/**
	 * コンストラクタ
	 * @param csv 区切り文字列で区切られたスキルベクトル
	 * @param dlm 区切り文字列
	 */
	public SkillVector(String csv, String dlm){
		String[] temp = CsvStringToList.split(csv, dlm);
		for(int idx=0; idx<temp.length; idx++){
			SkillScalar ss = new SkillScalar(temp[idx]);
			map.put(ss.getSkillName(), ss.getSkillValue());
		}
		return;
	}
	/**
	 * スキルベクトルクラスをコピー
	 * @param src コピー元のスキルベクトルクラス
	 */
	public void assign(SkillVector src){
		this.map.clear();
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			this.map.put(idx, src.getValue(idx));
		}
		return;
	}
	/**
	 * スキルベクトルを加算
	 * @param src 加えるスキルベクトル
	 * @return 加算結果（スキルベクトル）
	 */
	public SkillVector add(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				res.map.put(idx, src.getValue(idx));
			else
				res.map.put(idx, res.getValue(idx)+src.getValue(idx));
		}
		return res;
	}
	/**
	 * スキルベクトルを減算
	 * @param src 引くスキルベクトル
	 * @return 減算結果（スキルベクトル）
	 */
	public SkillVector sub(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				res.map.put(idx, -src.getValue(idx));
			else
				res.map.put(idx, res.getValue(idx)-src.getValue(idx));
		}
		return res;
	}
	/**
	 * スキルベクトルを乗算
	 * @param src 掛けるスキルベクトル
	 * @return 乗算結果
	 */
	public SkillVector mul(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = res.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(src.getValue(idx)==null)
				res.map.put(idx, null);
			else
				res.map.put(idx, res.getValue(idx)*src.getValue(idx));
		}
		return res;
	}
	/**
	 * 単位スキルベクトルを取得
	 * @return 単位スキルベクトル
	 */
	public SkillVector unit(){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				continue;
			else
				res.map.put(idx, 1);
		}
		return res;
	}
	/**
	 * スキルベクトルのハッシュマップを取得
	 * @return スキルベクトルのハッシュマップ
	 */
	public HashMap<String, Integer> getMap(){
		return this.map;
	}
	/**
	 * 指定したスキルのスキル値
	 * @param key 指定スキル名
	 * @return スキル値
	 */
	public Integer getValue(String key){
		if(this.map.get(key)==null)
			return 0;
		return this.map.get(key);
	}
	/**
	 * スキルベクトルを区切り文字列で編集して取得
	 * @param sep 区切り文字列
	 * @return 編集後のスキルベクトル
	 */
	public String exportSkills(String sep){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val >= 0)
				res += sep+key+"+"+Integer.toString(val);
			else
				res += sep+key+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * スキルベクトルを区切り文字列で編集して取得（ゼロ要素を除く）
	 * 区切り文字列は「,」（カンマ）
	 * @return 編集後のスキルベクトル
	 */
	public String exportSkillsWithoutZeroElements(){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val > 0)
				res += ","+key+"+"+Integer.toString(val);
			else
			if(val < 0)
				res += ","+key+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * スキルベクトルを文字列形式にエクスポート
	 * @return 文字列形式のスキルベクトル
	 */
	public String exportString(){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			res += "@"+key+"$"+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * 文字列形式のスキルベクトルをインポート
	 * @param in 文字列形式のスキルベクトル
	 */
	public void importString(String in){
		this.map.clear();
		if(in.equals(""))
			return ;
		String[] skills = CsvStringToList.split(in, "@");
		for(int idx=0; idx<skills.length; idx++){
			String[] item = CsvStringToList.split(skills[idx], "$");
			this.map.put(item[0], Integer.parseInt(item[1]));
		}
		return;
	}
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Integer value){
		this.map.put(key, value);
		return;
	}
	/**
	 * 指定したスキルのスキル値(getValueメソッドの使用を推奨)
	 * @param key 指定スキル名
	 * @return スキル値
	 */
	public Integer get(String key){
		return this.map.get(key);
	}
	/**
	 * 各スキル値が指定値以下の場合、指定値に設定して再格納
	 * @param c 指定値
	 */
	public void roundingup(int c){
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val<=c)
				this.map.put(key, c);
		}
		return;
	}
}
