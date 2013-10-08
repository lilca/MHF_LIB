package jp.skd.lilca.mhf.lib.buki;

/**
 * ����̃r���𒊏ۉ������N���X
 */
public class Bin {

	private boolean kyou;
	private boolean doku;
	private boolean mahi;
	private boolean sui;
	private boolean baku;

	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str �Ή��r�����L�q����Ă��镶����
	 */
	public Bin(String str){
		// ���Ŗ�����
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * �����񂩂�Ή����Ă���r����ݒ肷��
	 * @param str �Ή��r�����L�q����Ă��镶����
	 */
	private void setString(String str){
		if(str.indexOf("��")==-1) kyou	= false; else kyou	= true;
		if(str.indexOf("��")==-1) doku	= false; else doku	= true;
		if(str.indexOf("��")==-1) mahi	= false; else mahi	= true;
		if(str.indexOf("��")==-1) sui	= false; else sui	= true;
		if(str.indexOf("��")==-1) baku	= false; else baku	= true;
		return;
	}
	/**
	 * �Ή����Ă���r����\������
	 * @return �Ή����Ă���r��
	 */
	public String printHtml(){
		if(empty)
			return "";
		String res = "";
		if(kyou)
			res += "��";
		if(doku)
			res += "��";
		if(mahi)
			res += "��";
		if(sui)
			res += "��";
		if(baku)
			res += "��";
		return res;
	}
	/**
	 * ���P�e�ɑΉ����Ă��邩����
	 * @return true=�Ή����Ă���,false=����ȊO
	 */
	public boolean isKyou(){
		if(kyou)
			return true;
		return false;
	}
	/**
	 * �Œe�ɑΉ����Ă��邩����
	 * @return true=�Ή����Ă���,false=����ȊO
	 */
	public boolean isDoku(){
		if(doku)
			return true;
		return false;
	}
	/**
	 * ��გe�ɑΉ����Ă��邩����
	 * @return true=�Ή����Ă���,false=����ȊO
	 */
	public boolean isMahi(){
		if(mahi)
			return true;
		return false;
	}
	/**
	 * �����e�ɑΉ����Ă��邩����
	 * @return true=�Ή����Ă���,false=����ȊO
	 */
	public boolean isSui(){
		if(sui)
			return true;
		return false;
	}
	/**
	 * �����e�ɑΉ����Ă��邩����
	 * @return true=�Ή����Ă���,false=����ȊO
	 */
	public boolean isBaku(){
		if(baku)
			return true;
		return false;
	}
}
