package jp.skd.lilca.mhf.lib.buki;

/**
 * ����̖C���𒊏ۉ������N���X
 */
public class Hougeki {

	private String type;
	private int level;

	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str �C����񂪊܂܂�镶����
	 */
	public Hougeki(String str){
		// |�ʏ� �g�U ����| |<num>|
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * �C��������͂��Đݒ�
	 * @param str ��͂���镶����
	 */
	private void setString(String str){
		if(str.indexOf("�ʏ�")!=-1)
			this.type = "�ʏ�";
		else
		if(str.indexOf("�g�U")!=-1)
			this.type = "�g�U";
		else
		if(str.indexOf("����")!=-1)
			this.type = "����";
		else
			return;
		// ���l
		this.level = Integer.parseInt(str.replaceAll("�ʏ�", "").replaceAll("�g�U", "").replaceAll("����", ""));
		return;
	}
	/**
	 * �C�����𕶎���ɏo��
	 * @return ������`���̖C�����
	 */
	public String print(){
		if(empty)
			return "";
		return this.type+this.level;
	}
}
