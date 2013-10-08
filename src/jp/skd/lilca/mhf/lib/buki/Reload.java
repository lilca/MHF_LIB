package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

/**
 * 武器のリロードを抽象化したクラス
 */
public class Reload {

	private HashMap<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("極遅", -1);
			put("遅い", 0);
			put("やや遅い", 1);
			put("普通", 2);
			put("やや速い", 3);
			put("速い", 4);
			put("極速", 5);
			put("最速", 6);
		}
	};
	private HashMap<Integer, String> pmap = new HashMap<Integer, String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(-1, "極遅");
			put( 0, "遅い");
			put( 1, "やや遅い");
			put( 2, "普通");
			put( 3, "やや速い");
			put( 4, "速い");
			put( 5, "極速");
			put( 6, "最速");
			put( 7, "最速+");
		}
	};
	private int val;

	/**
	 * コンストラクタ
	 * @param src 文字列形式のリロード情報
	 */
	public Reload(String src){
		Integer tmp;
		try{
			tmp = this.map.get(src);
		}catch(Exception e){
			this.val = -2;
			return;
		}
		if(tmp == null){
			this.val = -2;
			return;
		}
		this.val = tmp;
		return;
	}
	/**
	 * リロード情報を文字列に出力
	 * @param v スキル発動などによるバイアス
	 * @return 文字列形式のリロード情報
	 */
	public String print(int v){
		if( this.val == -2 )
			return "";
		return this.pmap.get(this.val+v);
	}
}
