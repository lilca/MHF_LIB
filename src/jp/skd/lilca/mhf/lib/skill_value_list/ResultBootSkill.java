package jp.skd.lilca.mhf.lib.skill_value_list;

/**
 * �X�L���̔������ʂ𒊏ۉ������N���X
 */
public class ResultBootSkill {
	/**
	 * �����X�L����
	 */
	public String	text;
	/**
	 * �����N�A�b�v�L��
	 */
	public boolean	uped;
	/**
	 * �R���X�g���N�^
	 * @param t �����X�L����
	 * @param f �����N�A�b�v�L��
	 */
	public ResultBootSkill(String t, boolean f){
		this.text	= t;
		this.uped	= f;
	}
}
