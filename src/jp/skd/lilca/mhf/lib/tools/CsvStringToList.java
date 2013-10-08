package jp.skd.lilca.mhf.lib.tools;

import java.util.ArrayList;
/**
 * 自作の文字列操作のクラス
 */
public class CsvStringToList {
	/**
	 * 文字列分割
	 * @param str 分割前の文字列
	 * @param delim 区切り文字列（１文字でなくともよい）
	 * @return 分割後の文字列配列
	 */
	public static String[] split(String str, String delim){
		final int delimLength = delim.length();
		int pos = 0;
		int index = 0;
		ArrayList<String> list = new ArrayList<String>();
		while((index = str.indexOf(delim, pos))!=-1){
			list.add(str.substring(pos, index));
			pos = index + delimLength;
		}
		list.add(str.substring(pos));
		return ( (String[])list.toArray(new String[0]) );
	}
	/**
	 * 文字列結合
	 * @param list 結合する文字列配列
	 * @param delim 結合に使う区切り文字列（１文字でなくともよい）
	 * @return 結合後の文字列
	 */
	public static String scat(String[] list, String delim){
		String res = list[0];
		for(int idx=1; idx<list.length; idx++)
			res += delim+list[idx];
		return res;
	}
	/**
	 * 文字列結合（空文字列をスキップする）
	 * @param list 結合する文字列配列
	 * @param delim 結合に使う区切り文字列（１文字でなくともよい）
	 * @return 結合後の文字列
	 */
	public static String scatNullSkip(String[] list, String delim){
		String res = "";
		int idx = 0;
		while(list[idx].equals("")){
			idx++;
			if(idx>=list.length)
				return "";
		}
		res = list[idx];
		for(++idx; idx<list.length; idx++)
			if(!list[idx].equals(""))
				res += delim+list[idx];
		return res;
	}
	/**
	 * 区切り文字列で区切った場合の要素数
	 * @param str 確認する文字列
	 * @param delim　区切り文字列（１文字でなくともよい）
	 * @return 要素数
	 */
	public static int getColCnt(String str, String delim){
		final int delimLength = delim.length();
		int pos = 0;
		int index = 0;
		int cnt = 1;
		while((index = str.indexOf(delim, pos))!=-1){
			pos = index + delimLength;
			cnt++;
		}
		return cnt;
	}
}
