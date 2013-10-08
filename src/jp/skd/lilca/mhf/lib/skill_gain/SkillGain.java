package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * スキルゲインを抽象化したクラス
 */
public class SkillGain {
	/**
	 * 文字列形式のスキル（複数）のスキル値の総和を取得
	 * @param condition 文字列形式のスキル（複数）
	 * @param delim 区切り文字列
	 * @return スキル値の総和
	 */
	public static int getLevel(String condition, String delim){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] list = CsvStringToList.split(condition, delim);
		for(int idx=0; idx<list.length; idx++){
			// 分割
			String skill = list[idx].replace("＋", "+").replace("－", "-");
			int value = 0;
			// 条件スキル
			int c;
			if((c=skill.indexOf("+"))!=-1){
				value = (int)(Double.parseDouble(skill.substring(c).replace("+", "")));
			}
			else{
				c = skill.indexOf("-");
				value = (int)(Double.parseDouble(skill.substring(c)));			
			}
			res += value;
		}
		return res;
	}
	/**
	 * スキルゲインの取得
	 * @param fields 防具、装飾品、カフ等のスキルベクトル（文字列形式）
	 * @param condition 条件のスキルベクトル（文字列形式）
	 * @return スキルゲイン
	 */
	public static int getSkillGain(String fields, String condition){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] fs = CsvStringToList.split(fields, ":");
		String[] cs = CsvStringToList.split(condition, ",");
		// 利得計算
		for(int idx=0; idx<cs.length; idx++)
			for(int jdx=0; jdx<fs.length; jdx++)
				if(!fs[0].equals(""))
					res += getGain(cs[idx].trim(), fs[jdx].trim());
		return res;
	}
	/**
	 * 一つのスキルのスキルゲイン
	 * @param con 条件のスキル
	 * @param fld 防具、装飾品、カフのスキル
	 * @return スキルゲイン
	 */
	private static int getGain(String con, String fld){
		return getGainBase(con, fld, true);
	}
	/**
	 * 一つのスキルのスキルゲイン
	 * @param con 条件のスキル
	 * @param fld 防具、装飾品、カフのスキル
	 * @return スキルゲイン
	 */
	private static int getNegative(String con, String fld){
		return getGainBase(con, fld, false);
	}
	/**
	 * スキルゲインの算出
	 * @param con 条件のスキル
	 * @param fld 防具、装飾品、カフのスキル
	 * @param dflt true=通常用,false=発動抑制用
	 * @return スキルゲイン
	 */
	private static int getGainBase(String con, String fld, boolean dflt){
		String cskill;
		int cvalue;
		String fskill;
		int fvalue;
		con = con.replace("＋", "+").replace("－", "-");
		fld = fld.replace("＋", "+").replace("－", "-");
		// 条件スキル
		int c;
		if((c=con.indexOf("+"))!=-1){
			cskill = con.substring(0, c);
			cvalue = (int)(Double.parseDouble(con.substring(c).replace("+", "")));
		}
		else{
			c = con.indexOf("-");
			cskill = con.substring(0, c);
			cvalue = (int)(Double.parseDouble(con.substring(c)));			
		}
		// 値スキル
		if((c=fld.indexOf("+"))!=-1){
			fskill = fld.substring(0, c);
			fvalue = (int)(Double.parseDouble(fld.substring(c).replace("+", "")));
		}
		else{
			c = fld.indexOf("-");
			fskill = fld.substring(0, c);
			fvalue = (int)(Double.parseDouble(fld.substring(c)));
		}
		// 違うスキルならゼロ
		if(!cskill.equals(fskill))
			return 0;
		// 演算
		if( dflt )
			return getCalGain(cvalue, fvalue);
		return getCalNegative(cvalue, fvalue);
	}
	/**
	 * 利得を算出
	 * @param c 条件のスキル値
	 * @param f スキル値
	 * @return 利得
	 */
	private static int getCalGain(int c, int f){
		// 差を算出
		if( c <= f )
			return c;
		else
		if( c > f )
			return f;
		return -100;
	}
	/**
	 * 利得を算出（発動抑制用）
	 * @param c 条件のスキル値
	 * @param f スキル値
	 * @return 利得
	 */
	private static int getCalNegative(int c, int f){
		// 正のスキルはゼロ
		if( f >= 0 )
			return 0;
		return f;
	}
	/**
	 * 発動抑制用のスキルゲイン取得
	 * @param fields 防具、装飾品、カフ等のスキル
	 * @param condition 指定されたスキル
	 * @return 発動抑制用のスキルゲイン
	 */
	public static int getSkillNegative(String fields, String condition){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] fs = CsvStringToList.split(fields, ":");
		String[] cs = CsvStringToList.split(condition, ",");
		// 利得計算
		for(int idx=0; idx<cs.length; idx++)
			for(int jdx=0; jdx<fs.length; jdx++)
				if(!fs[0].equals(""))
					res += getNegative(cs[idx].trim(), fs[jdx].trim());
		return res;
	}
}
