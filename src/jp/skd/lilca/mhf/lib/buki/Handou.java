package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

/**
 * 武器の反動を抽象化したクラス
 */
public class Handou {

	private HashMap<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("最大", 0);
			put("中", 2);
			put("やや小", 3);
			put("小", 4);
			put("極小", 5);
			put("最小", 6);
			put("最小'", 7);
			put("最小''", 8);
		}
	};
	private HashMap<Integer, String> pmap = new HashMap<Integer, String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(0, "最大");
			put(2, "中");
			put(3, "やや小");
			put(4, "小");
			put(5, "極小");
			put(6, "最小");
			put(7, "最小+");
			put(8, "最小++");
		}
	};
	private int val;

	/**
	 * コンストラクタ
	 * @param src 反動情報が含まれている文字列
	 */
	public Handou(String src){
		Integer tmp;
		try{
			tmp = this.map.get(src);
		}catch(Exception e){
			this.val = -1;
			return;
		}
		if(tmp == null){
			this.val = -1;
			return;
		}
		this.val = tmp;
		return;
	}
	/**
	 * 反動情報を文字列出力
	 * @param v スキル発動などによるバイアス
	 * @return 文字列による反動情報
	 */
	public String print(int v){
		if( this.val == -1 )
			return "";
		return this.pmap.get(this.val+v);
	}
}
