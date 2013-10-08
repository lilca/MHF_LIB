package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * �����X�L�����ƁA���̃X�L�����y�уX�L���l�������N���X
 */
public class SkillItem {
	/**
	 * �X�L����
	 */
	public String skillName;
	/**
	 * �X�L���l
	 */
	public int value;
	/**
	 * �����X�L����
	 */
	public String bootSkillName;

	/**
	 * �R���X�g���N�^
	 * @param csv CSV�`���̃X�L���A�C�e��
	 */
	public SkillItem(String csv){
		String[] temp = CsvStringToList.split(csv, ",");
		this.skillName = temp[0];
		this.value = Integer.parseInt(temp[1]);
		this.bootSkillName = temp[2];
		return;
	}
	/**
	 * �w�肵�������X�L�������ۂ�
	 * @param name �w�蔭���X�L��
	 * @return true=�w�蔭���X�L���Ɠ���,false=����ȊO
	 */
	public boolean isBootSkill(String name){
		if(name.equals(this.bootSkillName))
			return true;
		return false;
	}
}
