package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * �X�L���x�N�g���̍��i�X�L���X�J���[�j�𒊏ۉ������N���X
 */
public class SkillScalar {
	private String name;
	private int	val;

	/**
	 * �R���X�g���N�^
	 * @param s �X�L����
	 * @param v �X�L���l
	 */
	public SkillScalar(String s, int v){
		this.name = s;
		this.val = v;
		return;
	}
	/**
	 * �R���X�g���N�^
	 * @param csv ������`���̃X�L���X�J���[
	 */
	public SkillScalar(String csv){
		String[] temp;
		if(csv.indexOf("+")!=-1){
			temp = CsvStringToList.split(csv, "+");
			this.name = temp[0];
			this.val = Integer.parseInt(temp[1]);
		}
		else
		if(csv.indexOf("-")!=-1){
			temp = CsvStringToList.split(csv, "-");
			this.name = temp[0];
			this.val = -Integer.parseInt(temp[1]);
		}
		return;
	}
	/**
	 * �X�L�������擾
	 * @return �X�L����
	 */
	public String getSkillName(){
		return this.name;
	}
	/**
	 * �X�L���l���擾
	 * @return �X�L���l
	 */
	public int getSkillValue(){
		return this.val;
	}
}
