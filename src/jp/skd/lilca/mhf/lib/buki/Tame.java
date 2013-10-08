package jp.skd.lilca.mhf.lib.buki;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * ����̗��߂𒊏ۉ������N���X
 */
public class Tame {

	private String[] type = new String[4];
	private int[] level = new int[4];

	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str ������`���̗��ߏ��
	 */
	public Tame(String str){
		// |�A��@�g�U@�ђ�|
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
	 * ���ߏ�����͂��Đݒ�
	 * @param str ������`���̗��ߏ��
	 * @param n ���߂̒i�K
	 */
	private void setString(String str, int n){
		if(str.indexOf("�A��")!=-1)
			this.type[n] = "�A��";
		else
		if(str.indexOf("�g�U")!=-1)
			this.type[n] = "�g�U";
		else
		if(str.indexOf("�ђ�")!=-1)
			this.type[n] = "�ђ�";
		else
			this.type[n] = str;
		// ���l
		this.level[n] = Integer.parseInt(str.replaceAll("�A��", "").replaceAll("�g�U", "").replaceAll("�ђ�", ""));
		return;
	}
	/**
	 * �w�肵�����i�K�̗��߂𕶎���ɏo��
	 * @param n �w�肷�闭�ߒi�K
	 * @return ������`���̗��ߏ��
	 */
	public String print(int n){
		if(this.empty)
			return "";
		return this.type[n]+this.level[n];
	}
	/**
	 * ���ߏ��𕶎���ɏo��
	 * @param l4 �i�K4�����Ă��Ԃ��ۂ�
	 * @return ������`���̗��ߏ��
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
	 * �w�肵���i�K�̗��߂̃^�C�v
	 * @param n �w�肷��i�K
	 * @return ���߂̃^�C�v
	 */
	public String getType(int n){
		if(this.empty)
			return "";
		return this.type[n];
	}
	/**
	 * �w�肵���i�K�̗��߃��x��
	 * @param n �w�肷��i�K
	 * @return ���߃��x��
	 */
	public int getLevel(int n){
		if(this.empty)
			return -1;
		return this.level[n];
	}
}
