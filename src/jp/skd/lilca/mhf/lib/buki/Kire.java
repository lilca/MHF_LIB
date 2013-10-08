package jp.skd.lilca.mhf.lib.buki;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;


/**
 * ����̎a�ꖡ�𒊏ۉ������N���X
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
	 * �a�ꖡ�̒i�K�̐��i�ʏ��ԂƎa�ꖡ+1��ԁj
	 */
	public static final int STEPS	= 2;
	private int levels;
	private int[][] values;
	
	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str ������`���̎a�ꖡ���
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
	 * ������`���̎a�ꖡ������͂��Đݒ�
	 * @param str ������`���̎a�ꖡ���
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
	 * �a�ꖡ����HTML�����̕�����Ƃ��ďo��
	 * @param plus1 �a�ꖡ+1���������Ă��邩�ۂ�
	 * @param rankup �����N�A�b�v���������Ă��邩�ۂ�
	 * @return HTML�����̎a�ꖡ���̕�����
	 */
	public String getHtml(boolean plus1, boolean rankup){
		if( this.empty )
			return "";
		String res;
		int[] val;
		int shift;
		int total = 0;
		// �w�b�h
		if( plus1 ){
			res = "<table style=\"display: inline-block;\" border=\"0\" frame=\"box\" bordercolor=\"#00ffff\" cellspacing=\"0\" cellpadding=\"0\"><tr>";
			val = this.values[1];
		}
		else{
			res = "<table style=\"display: inline-block;\" border=\"0\" frame=\"box\" bordercolor=\"#000000\" cellspacing=\"0\" cellpadding=\"0\"><tr>";
			val = this.values[0];
		}
		// �o�[
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
		// �e�C��
		res += "</tr></table>";
		return res;
	}
}
