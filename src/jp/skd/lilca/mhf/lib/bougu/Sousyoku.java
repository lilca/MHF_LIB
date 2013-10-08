package jp.skd.lilca.mhf.lib.bougu;

import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * �����i�𒊏ۉ������N���X
 */
public class Sousyoku {
	private String name;
	private boolean isSPs;
	private String skills;
	private int slots;
	private String sozai;
	private String cost;
	private String rank;
	private boolean empty;
	/**
	 * �R���X�g���N�^
	 * @param csvstr ������`���̑����i�f�[�^
	 */
	public Sousyoku(String csvstr){
		this.setString(csvstr);
	}
	/**
	 * ������`���̑����i�f�[�^���p�[�Y�i��́j
	 * @param csvstr ������`���̑����i�f�[�^
	 */
	public void setString(String csvstr){
		empty = true;
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<7)
			return;
		empty = false;
		// ���O
		this.name = fields[0].trim();
		// SP�t���O
		if(fields[1].equals("1"))
			this.isSPs = true;
		else
			this.isSPs = false;
		// �X�L��
		this.skills = fields[2];
		// �X���b�g��
		this.slots = Integer.parseInt(fields[3]);
		// �f��
		this.sozai = fields[4];
		// �R�X�g
		this.cost = fields[5];
		// �����N
		this.rank = fields[6];
		return;
	}
	/**
	 * �����i�f�[�^�𕶎���`���Ƃ��Ď擾
	 * @return ������`���̑����i�f�[�^
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// ���O
		res += this.name+",";
		// SP�t���O
		if(this.isSPs)
			res += "1"+",";
		else
			res += "0"+",";
		// �X�L��
		res += this.skills+",";
		// �X���b�g��
		res += this.slots+",";
		// �f��
		res += this.sozai+",";
		// �R�X�g
		res += this.cost+",";
		// �����N
		res += this.rank;
		return res;
	}
	/**
	 * �����i�f�[�^����ł��邩���擾
	 * @return true=��,false=�����i�f�[�^������
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * �����i�̖��O���擾
	 * @return �����i�̖��O
	 */
	public String getName(){
		if(empty)
			return "�Ȃ�";
		return this.name;
	}
	/**
	 * �����i�̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j��HTML�^�O�����ĕ�����Ŏ擾
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
	 * �����i�̃X�L�����X�L���x�N�g���Ƃ��Ď擾
	 * @return �X�L���x�N�g��
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector s = new SkillVector(this.skills, ":");
		res.assign(s);
		return res;
	}
	/**
	 * �����i�̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j���擾
	 * @return �X�L���̕�����
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * �����i�̏���X���b�g���擾
	 * @return ����X���b�g��
	 */
	public int getSlotCost(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * �����i�̃R�X�g���擾
	 * @return �R�X�g
	 */
	public String getCost(){
		if(empty)
			return "0z";
		return this.cost;
	}
	/**
	 * �����i�̃����N���擾
	 * @return �����N
	 */
	public String getRank(){
		if(empty)
			return "1";
		return this.rank;
	}
	/**
	 * �����i��SP�h���p�ł��邩���擾
	 * @return true=SP�h���p�ł���,false=SP�h���p�łȂ�
	 */
	public boolean isSP(){
		if(empty)
			return false;
		return this.isSPs;
	}
	/**
	 * �����i�̏���X���b�g���𕶎���Ŏ擾�i��F�����[�j
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
	 * �����i�̑f�ނ𕶎���Ŏ擾
	 * @return �����i�̑f��
	 */
	public String getSozai(){
		return this.sozai;
	}
}
