package jp.skd.lilca.mhf.lib.buki;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * 武器の溜めを抽象化したクラス
 */
public class Tame {

	private String[] type = new String[4];
	private int[] level = new int[4];

	private boolean empty;

	/**
	 * コンストラクタ
	 * @param str 文字列形式の溜め情報
	 */
	public Tame(String str){
		// |連射@拡散@貫通|
		if(str.equals("")){
			this.empty = true;
			return;
		}
		String[] temp = CsvStringToList.split(str, "@");
		for(int idx=0; idx<temp.length; idx++)
			this.setString(temp[idx], idx);
		this.empty = false;
		return;
	}
	/**
	 * 溜め情報を解析して設定
	 * @param str 文字列形式の溜め情報
	 * @param n 溜めの段階
	 */
	private void setString(String str, int n){
		if(str.indexOf("連射")!=-1)
			this.type[n] = "連射";
		else
		if(str.indexOf("拡散")!=-1)
			this.type[n] = "拡散";
		else
		if(str.indexOf("貫通")!=-1)
			this.type[n] = "貫通";
		else
			this.type[n] = str;
		// 数値
		this.level[n] = Integer.parseInt(str.replaceAll("連射", "").replaceAll("拡散", "").replaceAll("貫通", ""));
		return;
	}
	/**
	 * 指定したレ段階の溜めを文字列に出力
	 * @param n 指定する溜め段階
	 * @return 文字列形式の溜め情報
	 */
	public String print(int n){
		if(this.empty)
			return "";
		return this.type[n]+this.level[n];
	}
	/**
	 * 溜め情報を文字列に出力
	 * @param l4 段階4が撃てる状態か否か
	 * @return 文字列形式の溜め情報
	 */
	public String print(boolean l4){
		if(this.empty)
			return "";
		int to;
		String res = "";
		if( l4 ) to = 4; else to = 3;
		for(int idx=0; idx<to; idx++){
			if( idx == 0)
				res += this.print(idx);
			else
				res += ","+this.print(idx);
		}
		return res;
	}
	/**
	 * 指定した段階の溜めのタイプ
	 * @param n 指定する段階
	 * @return 溜めのタイプ
	 */
	public String getType(int n){
		if(this.empty)
			return "";
		return this.type[n];
	}
	/**
	 * 指定した段階の溜めレベル
	 * @param n 指定する段階
	 * @return 溜めレベル
	 */
	public int getLevel(int n){
		if(this.empty)
			return -1;
		return this.level[n];
	}
}
