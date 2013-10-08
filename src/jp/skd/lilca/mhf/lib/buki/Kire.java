package jp.skd.lilca.mhf.lib.buki;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;


/**
 * 武器の斬れ味を抽象化したクラス
 */
public class Kire {

	private static final int MAXBAR = 140;
	private static final String[] htmlColorBar = {
		"\"#ff0000\"",
		"\"#ff8800\"",
		"\"#ffff00\"",
		"\"#44ff44\"",
		"\"#0000ff\"",
		"\"#ffffff\"",
		"\"#ff00ff\"",
		"\"#00ffff\"",
		"\"#000000\"",
	};

	/**
	 * 斬れ味の段階の数（通常状態と斬れ味+1状態）
	 */
	public static final int STEPS	= 2;
	private int levels;
	private int[][] values;
	
	private boolean empty;

	/**
	 * コンストラクタ
	 * @param str 文字列形式の斬れ味情報
	 */
	public Kire(String str){
		// r@o@y@g@b@w@r@o@y@g@b@w
		// r@o@y@g@b@w@m@r@o@y@g@b@w@m
		if(str.equals("")){
			empty = true;
			return;
		}
		this.setString(str);
		empty = false;
		return;
	}
	/**
	 * 文字列形式の斬れ味情報を解析して設定
	 * @param str 文字列形式の斬れ味情報
	 */
	private void setString(String str){
		String[] list = CsvStringToList.split(str, "@");
		this.levels = list.length / 2;
		values = new int[STEPS][levels];
		for(int idx=0; idx<list.length; idx++)
			values[idx/levels][idx%levels] = Integer.parseInt(list[idx]);
		return;
	}
	/**
	 * 斬れ味情報をHTML書式の文字列として出力
	 * @param plus1 斬れ味+1が発動しているか否か
	 * @param rankup ランクアップが発動しているか否か
	 * @return HTML書式の斬れ味情報の文字列
	 */
	public String getHtml(boolean plus1, boolean rankup){
		if( this.empty )
			return "";
		String res;
		int[] val;
		int shift;
		int total = 0;
		// ヘッド
		if( plus1 ){
			res = "<table style=\"display: inline-block;\" border=\"0\" frame=\"box\" bordercolor=\"#00ffff\" cellspacing=\"0\" cellpadding=\"0\"><tr>";
			val = this.values[1];
		}
		else{
			res = "<table style=\"display: inline-block;\" border=\"0\" frame=\"box\" bordercolor=\"#000000\" cellspacing=\"0\" cellpadding=\"0\"><tr>";
			val = this.values[0];
		}
		// バー
		if( rankup )
			shift = 1;
		else
			shift = 0;
		for(int idx=0; idx<val.length; idx++){
			res += "<td bgcolor="+htmlColorBar[idx+shift]+" width=\""+val[idx]+"\" height=\"15\"></td>";
			total += val[idx];
		}
		if( MAXBAR-total > 0)
			res += "<td bgcolor="+htmlColorBar[htmlColorBar.length-1]+" width=\""+(MAXBAR-total)+"\" height=\"15\"></td>";
		// テイル
		res += "</tr></table>";
		return res;
	}
}
