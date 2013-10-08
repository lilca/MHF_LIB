package jp.skd.lilca.mhf.lib.bougu;

import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * �J�t�𒊏ۉ������N���X
 */
public class Kafus {
	// �I���W�i��
	private String org;
	// �e���틤��
	private String name;
	private String skills;
	private int slots;
	private String sozai;
	private String cost;
	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param csvstr ������`���̃J�t�f�[�^
	 */
	public Kafus(String csvstr){
		this.org = csvstr;
		this.setString(csvstr);
	}
	/**
	 * ������`���̃J�t�f�[�^���p�[�Y�i��́j
	 * @param csvstr ������`���̃J�t�f�[�^
	 */
	public void setString(String csvstr){
		empty = true;
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<4)
			return;
		empty = false;
		// ���O
		this.name = fields[0].trim();
		// �X�L��
		this.skills = fields[1];
		// �X���b�g��
		this.slots = Integer.parseInt(fields[2]);
		// �f��
		this.sozai = fields[3];
		// �R�X�g
		this.cost = fields[4];
		return;
	}
	/**
	 * �J�t�f�[�^�𕶎���`���Ƃ��Ď擾
	 * @return ������`���̃J�t�f�[�^
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		return this.org;
	}
	/**
	 * �J�t�f�[�^����ł��邩���擾
	 * @return true=��,false=�J�t�f�[�^������
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * �J�t�̖��O���擾
	 * @return �J�t�̖��O
	 */
	public String getName(){
		if(empty)
			return "�Ȃ�";
		return this.name;
	}
	/**
	 * �J�t�̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j��HTML�^�O�����ĕ�����Ŏ擾
	 * @param color �����̃J���[�R�[�h
	 * @return HTML�^�O����̃X�L���̕�����
	 */
	public String getSkillsWithColorTag(String color){
		String temp = this.getSkills();
		String[] list = CsvStringToList.split(temp, ":");
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, ":");
	}
	/**
	 * �J�t�̃X�L�����X�L���x�N�g���Ƃ��Ď擾
	 * @return �X�L���x�N�g��
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector k = new SkillVector(this.skills, ":");
		res.assign(k);
		return res;
	}
	/**
	 * �J�t�̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j���擾
	 * @return �X�L���̕�����
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * �J�t�̏���X���b�g���擾
	 * @return ����X���b�g��
	 */
	public int getSlotCost(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * �J�t�̃R�X�g���擾
	 * @return �R�X�g
	 */
	public String getCost(){
		if(empty)
			return "0z";
		return this.cost;
	}
	/**
	 * �J�t�̏���X���b�g���𕶎���Ŏ擾�i��F�����[�j
	 * @return ������`���̏���X���b�g��
	 */
	public String getSlotCostString(){
		if(this.slots==1)
			return "o";
		if(this.slots==2)
			return "oo";
		if(this.slots==3)
			return "ooo";
		return "";
	}
	/**
	 * �J�t�̑f�ނ𕶎���Ŏ擾
	 * @return �J�t�̑f��
	 */
	public String getSozai(){
		return this.sozai;
	}
}
