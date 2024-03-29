package jp.skd.lilca.mhf.lib.buki;

/**
 * 武器の砲撃を抽象化したクラス
 */
public class Hougeki {

	private String type;
	private int level;

	private boolean empty;

	/**
	 * コンストラクタ
	 * @param str 砲撃情報が含まれる文字列
	 */
	public Hougeki(String str){
		// |通常 拡散 放射| |<num>|
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * 砲撃情報を解析して設定
	 * @param str 解析される文字列
	 */
	private void setString(String str){
		if(str.indexOf("通常")!=-1)
			this.type = "通常";
		else
		if(str.indexOf("拡散")!=-1)
			this.type = "拡散";
		else
		if(str.indexOf("放射")!=-1)
			this.type = "放射";
		else
			return;
		// 数値
		this.level = Integer.parseInt(str.replaceAll("通常", "").replaceAll("拡散", "").replaceAll("放射", ""));
		return;
	}
	/**
	 * 砲撃情報を文字列に出力
	 * @return 文字列形式の砲撃情報
	 */
	public String print(){
		if(empty)
			return "";
		return this.type+this.level;
	}
}
