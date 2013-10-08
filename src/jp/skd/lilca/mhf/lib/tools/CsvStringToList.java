package jp.skd.lilca.mhf.lib.tools;

import java.util.ArrayList;
/**
 * ����̕����񑀍�̃N���X
 */
public class CsvStringToList {
	/**
	 * �����񕪊�
	 * @param str �����O�̕�����
	 * @param delim ��؂蕶����i�P�����łȂ��Ƃ��悢�j
	 * @return ������̕�����z��
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
	 * �����񌋍�
	 * @param list �������镶����z��
	 * @param delim �����Ɏg����؂蕶����i�P�����łȂ��Ƃ��悢�j
	 * @return ������̕�����
	 */
	public static String scat(String[] list, String delim){
		String res = list[0];
		for(int idx=1; idx<list.length; idx++)
			res += delim+list[idx];
		return res;
	}
	/**
	 * �����񌋍��i�󕶎�����X�L�b�v����j
	 * @param list �������镶����z��
	 * @param delim �����Ɏg����؂蕶����i�P�����łȂ��Ƃ��悢�j
	 * @return ������̕�����
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
	 * ��؂蕶����ŋ�؂����ꍇ�̗v�f��
	 * @param str �m�F���镶����
	 * @param delim�@��؂蕶����i�P�����łȂ��Ƃ��悢�j
	 * @return �v�f��
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
