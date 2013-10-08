package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * 武器の弾を抽象化したクラス
 */
public class Gun {

	private HashMap<String ,String> list;

	private boolean empty;

	/**
	 * コンストラクタ
	 * @param str 文字列形式の弾情報
	 */
	public Gun(String str){
		// |通:6/6/9@貫:3+/4/4@散:2/2/2+@徹:1+/1+/1+@拡:1+/1/1|
		// |捕:2@ペ:2@鬼:1@硬:1|
		// 領域確保
		list	= new HashMap<String ,String>();
		if(str.equals("")){
			this.empty = true;
			return;
		}
		String[] temp = CsvStringToList.split(str, "@");
		// 解読
		for(int idx=0; idx<temp.length; idx++)
			this.add(temp[idx]);
		this.empty = false;
		return;
	}
	/**
	 * 弾情報追加
	 * @param src 文字列形式の弾情報
	 */
	public void add(String src){
		String[] temp1 = CsvStringToList.split(src, ":");
try{
		// 数値
		this.list.put(temp1[0], temp1[1]);
}catch(Exception e){
	e.printStackTrace();
}

		return;
	}
	/**
	 * 弾情報を文字列に出力
	 * @param sup スキル発動などか弾数がUPしているか否か
	 * @param indent インデント文字列
	 * @return 弾情報を文字列
	 */
	public String printNrm(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("通", sup, "-/-/-")+"<br>"+
				indent+this.printCell("貫", sup, "-/-/-")+"<br>"+
				indent+this.printCell("散", sup, "-/-/-")+"<br>"+
				indent+this.printCell("徹", sup, "-/-/-")+"<br>"+
				indent+this.printCell("拡", sup, "-/-/-");
		return res;
	}
	/**
	 * 弾情報を文字列に出力（異常属性弾など）
	 * @param sup スキル発動などか弾数がUPしているか否か
	 * @param indent インデント文字列
	 * @return 弾情報を文字列（異常属性弾など）
	 */
	public String printAttr(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("回", sup, "-/-")+", "+
				indent+this.printCell("毒", sup, "-/-")+", "+
				indent+this.printCell("麻", sup, "-/-")+", "+
				indent+this.printCell("睡", sup, "-/-");
		return res;
	}
	/**
	 * 弾情報を文字列に出力（属性弾など）
	 * @param sup スキル発動などか弾数がUPしているか否か
	 * @param indent インデント文字列
	 * @return 弾情報を文字列（属性弾など）
	 */
	public String printAttr2(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("火", sup, "-")+", "+
				indent+this.printCell("水", sup, "-")+", "+
				indent+this.printCell("雷", sup, "-")+", "+
				indent+this.printCell("氷", sup, "-")+", "+
				indent+this.printCell("龍", sup, "-");
		return res;
	}
	/**
	 * 弾情報を文字列に出力（捕獲弾など）
	 * @param sup スキル発動などか弾数がUPしているか否か
	 * @param indent インデント文字列
	 * @return 弾情報を文字列（捕獲弾など）
	 */
	public String printSp(boolean sup, String indent){
		String res = "";
		// |捕:2@ペ:2@鬼:1@硬:1|
		res +=	indent+this.printCell("捕", sup, "-")+", "+
				indent+this.printCell("ペ", sup, "-")+", "+
				indent+this.printCell("鬼", sup, "-")+", "+
				indent+this.printCell("硬", sup, "-");
		return res;
	}
	/**
	 * 指定した弾の種類から弾情報を文字列に出力
	 * @param key 弾の種類（「貫」「捕」など）
	 * @param up スキル発動などか弾数がUPしているか否か
	 * @param def 弾数のデフォルト表示（「-/-」「-」など）
	 * @return 文字列形式の弾情報
	 */
	public String printCell(String key, boolean up, String def){
		String v;
		try{
			v = this.list.get(key);
		}catch(Exception e){
			return key+":"+def;
		}
		if( v == null )
			return key+":"+def;
		String[] temp1 = CsvStringToList.split(v, "/");
		// セル処理
		String[] res = new String[temp1.length];
		for(int idx=0; idx<temp1.length; idx++){
			// 装填UPのとき
			if( up )
				res[idx] = temp1[idx].replace("+", "");
			// 通常で+がないとき
			else
			if( temp1[idx].indexOf("+") == -1 )
				res[idx] = temp1[idx];
			// 通常で+があるとき
			else{
				int a=0;
				try{
				a = Integer.parseInt(temp1[idx].replace("+", ""));}
						catch(Exception e){
							e.printStackTrace();			
						}
				if( a-1 == 0)
					res[idx] = "-";
				else
					res[idx] = Integer.toString(a-1);
			}
		}
		return key+":"+CsvStringToList.scat(res, "/");
	}
	/**
	 * ダミー
	 * @param n ダミー
	 * @return 常に空文字列
	 */
	@Deprecated
	public String getType(int n){
		if(empty)
			return "";
		return "";
	}
	/**
	 * ダミー
	 * @param n ダミー
	 * @return 常に空文字列
	 */
	@Deprecated
	public String getLevel(int n){
		if(empty)
			return "";
		return "";
	}
}
