package jp.skd.lilca.mhf.lib.buki;

/**
 * 武器のビンを抽象化したクラス
 */
public class Bin {

	private boolean kyou;
	private boolean doku;
	private boolean mahi;
	private boolean sui;
	private boolean baku;

	private boolean empty;

	/**
	 * コンストラクタ
	 * @param str 対応ビンが記述されている文字列
	 */
	public Bin(String str){
		// 強毒麻睡爆
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * 文字列から対応しているビンを設定する
	 * @param str 対応ビンが記述されている文字列
	 */
	private void setString(String str){
		if(str.indexOf("強")==-1) kyou	= false; else kyou	= true;
		if(str.indexOf("毒")==-1) doku	= false; else doku	= true;
		if(str.indexOf("麻")==-1) mahi	= false; else mahi	= true;
		if(str.indexOf("睡")==-1) sui	= false; else sui	= true;
		if(str.indexOf("爆")==-1) baku	= false; else baku	= true;
		return;
	}
	/**
	 * 対応しているビンを表示する
	 * @return 対応しているビン
	 */
	public String printHtml(){
		if(empty)
			return "";
		String res = "";
		if(kyou)
			res += "強";
		if(doku)
			res += "毒";
		if(mahi)
			res += "麻";
		if(sui)
			res += "睡";
		if(baku)
			res += "爆";
		return res;
	}
	/**
	 * 強襲弾に対応しているか判定
	 * @return true=対応している,false=それ以外
	 */
	public boolean isKyou(){
		if(kyou)
			return true;
		return false;
	}
	/**
	 * 毒弾に対応しているか判定
	 * @return true=対応している,false=それ以外
	 */
	public boolean isDoku(){
		if(doku)
			return true;
		return false;
	}
	/**
	 * 麻痺弾に対応しているか判定
	 * @return true=対応している,false=それ以外
	 */
	public boolean isMahi(){
		if(mahi)
			return true;
		return false;
	}
	/**
	 * 睡眠弾に対応しているか判定
	 * @return true=対応している,false=それ以外
	 */
	public boolean isSui(){
		if(sui)
			return true;
		return false;
	}
	/**
	 * 爆撃弾に対応しているか判定
	 * @return true=対応している,false=それ以外
	 */
	public boolean isBaku(){
		if(baku)
			return true;
		return false;
	}
}
