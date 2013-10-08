package jp.skd.lilca.mhf.lib.datastruct;

//import java.util.Random;
/**
 * 起動メッセージを抽象化したクラス
 */
public class MessageData {
	/**
	 * 起動メッセージ
	 */
	private static final String[][] messages = {
		{"アプリ公開中止のお知らせ", "諸事情により、2013/09/19 昼12時頃をもって装備無問題？を公開中止に致します。詳細は次のURLをご参照ください。http://skd.backdrop.jp/noproblem/",},
		{"cLoudでサービスを有効に！", "cLoudを登録したら、こちらを参考にサービスを有効にして下さい。http://skd.backdrop.jp/noproblem/editpagemise.php?%C6%C3%BD%B8#c8a518fc",},
		{"ブログに装備無問題？を貼ろう", "宜しければ装備無問題？のブログパーツをブログに貼りませんか。http://skd.backdrop.jp/noproblem/editpagemise.php?%C6%C3%BD%B8#l117eb47",},
	};
	/**
	 * タイトルとメッセージを取得する
	 * @return タイトルとメッセージ
	 */
	public static String[] getMessageAtRandom(){
//		Random rnd = new Random();
//		return messages[rnd.nextInt(messages.length)];
		return messages[0];
	}
}
