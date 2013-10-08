package jp.skd.lilca.mhf.lib.skill_value_list;

import java.util.ArrayList;
import java.util.HashMap;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * �X�L�����𒊏ۉ������N���X
 */
public class SkillInfoData {

	private ArrayList<String> list;
	private HashMap<String, String> boot2skill;
	private HashMap<String, Integer> boot2value;
	private HashMap<String, Boolean> boot2rank;
	// 12NOV�ǉ��@2�d�̃��R�[�h��ۑ�
	private ArrayList<String> doubleList;
	// 13AUG�ǉ��@�X�L���̔����X�L�����X�g��ۑ�
	private HashMap<String, String> skill2boots;

	/**
	 * �R���X�g���N�^
	 * @param lst �X�L�����t�@�C���̕����񃊃X�g
	 * @param bt2skill �����X�L��=>�X�L�����̃n�b�V���}�b�v
	 * @param bt2value �����X�L��=>�X�L���l�̃n�b�V���}�b�v
	 * @param bt2rank �����X�L��=>�����N�A�b�v�̃n�b�V���}�b�v
	 * @param dlist ��d�����̔����X�L���̃��X�g
	 * @param skill2bts �X�L��=>�����X�L�����X�g�̃n�b�V���}�b�v
	 */
	public SkillInfoData(	ArrayList<String> lst,
							HashMap<String, String> bt2skill,
							HashMap<String, Integer> bt2value,
							HashMap<String, Boolean> bt2rank,
							ArrayList<String> dlist,
							HashMap<String, String> skill2bts){
		list		= lst;
		boot2skill	= bt2skill;
		boot2value	= bt2value;
		boot2rank	= bt2rank;
		doubleList	= dlist;
		skill2boots	= skill2bts;
		return;
	}
	/**
	 * �R���X�g���N�^
	 * @param str ���̓e�L�X�g�t�@�C���i������Łj
	 * @param ret ���s������
	 */
	public SkillInfoData(String str, String ret){
		// ������
		list		= new ArrayList<String>();
		boot2skill	= new HashMap<String, String>();
		boot2value	= new HashMap<String, Integer>();
		boot2rank	= new HashMap<String, Boolean>();
		doubleList	= new ArrayList<String>();
		skill2boots	= new HashMap<String, String>();

		// ���s�ŕ���
		String[] lines = CsvStringToList.split(str, ret);
		//
		String line = "";
        String preName = "";
       	int preVal = 0;
       	for(int idx=0; idx<lines.length; idx++){
       		line	= lines[idx];
       		// ��s���X�L�b�v
       		if( line.replaceAll(" ", "").equals("") )
       			continue;
       		list.add(line);
       		String[] data = CsvStringToList.split(line, ",");
       		String name		= data[0];
       		String valStr	= data[1];
       		String skill	= data[2];
       		// 2�d�̂Ƃ�
       		if( valStr.equals("2�d") ){
       			doubleList.add(line);
       		}
       		else{
       			boot2skill.put(skill, name);
       			boot2value.put(skill, Integer.parseInt(valStr));
       			// �X�L���̍ŏ�ʈȊO
       			if(preName.equals(name))
       				boot2rank.put(skill, SkillValueList.isRankUpable(name));
       			// �X�L���̍ŏ��
       			else{
       				boot2rank.put(skill, false);
       				// �P�O�̒l������������
       				if( preVal < 0 )
           				boot2rank.put(preName, false);
       			}
       			// �������X�g
       			if( skill2boots.get(name) == null ){
       				skill2boots.put(name, skill);
       			}
       			else{
       				skill2boots.put(name, skill2boots.get(name)+":"+skill);
       			}
           		preName = name;
           		preVal	= Integer.parseInt(valStr);
       		}
       	}
       	// �Ō�̃X�L����false
		boot2rank.put(preName, false);
    	
		return;
	}
	/**
	 * �X�L�������擾
	 * @return �X�L�����
	 */
	public SkillInfoData getData(){
		return this;
	}
	/**
	 * �X�L�����t�@�C���̕����񃊃X�g���擾
	 * @return �X�L�����t�@�C���̕����񃊃X�g
	 */
	public ArrayList<String> getSkillList(){
		return this.list;
	}
	/**
	 * �����X�L������X�L�������擾
	 * @param bootSkillName �����X�L��
	 * @return �X�L����
	 */
	public String getSkillName(String bootSkillName){
		return boot2skill.get(bootSkillName);
	}
	/**
	 * �����X�L������X�L���l���擾
	 * @param bootSkillName �����X�L��
	 * @return �X�L���l
	 */
	public Integer getSkillValue(String bootSkillName){
		return boot2value.get(bootSkillName);
	}
	/**
	 * �����X�L�����烉���N�A�b�v�̗L�����擾
	 * @param bootSkillName �����X�L��
	 * @return �����N�A�b�v�̗L��
	 */
	public Boolean getSkillRank(String bootSkillName){
		return boot2rank.get(bootSkillName);
	}
	/**
	 * ���̔����X�L�����擾
	 * �オ�Ȃ��ꍇ�́A�󕶎����Ԃ�
	 * @param bootSkillName �����X�L��
	 * @return ���̔����X�L��
	 */
	public String getAboveBootSkillName(String bootSkillName){
		String skillname	= boot2skill.get(bootSkillName);
		String liststr		= skill2boots.get(skillname);
		String[] list		= CsvStringToList.split(liststr, ":");
		int idx;
		for(idx=0; idx<list.length; idx++){
			if( bootSkillName.equals(list[idx]) ){
				break;
			}
		}
		// ��ԏ�Ȃ�
		if( idx == 0 ){
			return "";
		}else
		return list[idx-1];
	}
	/**
	 * ����̔����X�L�����擾
	 * �����Ȃ��ꍇ�́A�󕶎����Ԃ�
	 * @param bootSkillName �����X�L��
	 * @return ����̔����X�L��
	 */
	public String getBelowBootSkillName(String bootSkillName){
		String skillname	= boot2skill.get(bootSkillName);
		String liststr		= skill2boots.get(skillname);
		String[] list		= CsvStringToList.split(liststr, ":");
		int idx;
		for(idx=0; idx<list.length; idx++){
			if( bootSkillName.equals(list[idx]) ){
				break;
			}
		}
		// ��ԉ��Ȃ�
		if( idx >= list.length - 1 ){
			return "";
		}else
		return list[idx+1];
	}
	/**
	 * �w�肵���X�L�����A�X�L���l�Ŕ�������X�L�����Z�o
	 * @param name �X�L����
	 * @param val �X�L���l
	 * @param rankup true=�����N�A�b�v�l��,false=�l�����Ȃ�
	 * @return ��������
	 */
	public ResultBootSkill getBootSkill(String name, int val, boolean rankup){
		// �Y���̑O��
		String preSkill = "";
		String preLastSkill = "";
		String nxtSkill = "";
		boolean sign	= false;
		//
		String[] possible = null;
		for(int idx=0; idx<this.list.size(); idx++){
			String[] temp = CsvStringToList.split(list.get(idx), ",");
			// 2�d�̃X�L�b�v
			if( temp[1].equals("2�d") )
				continue;
			String[] nextTemp = null;
			if( rankup && boot2rank.get(temp[2]) )
				nextTemp = CsvStringToList.split(list.get(idx+1), ",");
			// �X�L�������Y�����Ȃ�������
			if(!temp[0].equals(name))
				continue;
			int v = Integer.parseInt(temp[1]);
			// �������݂��Ⴂ�Ȃ�
			if((val * v)<0)
				continue;
			// �����ݒ�
			if(val<0)	sign = false;
			else		sign = true;
			// ��Βl���傫��������
			if(Math.abs(val)>=Math.abs(v)){
				// �ŏ��̊Y�����R�[�h
				if(possible == null){
					preLastSkill = preSkill;
					possible = temp;
				}
				// �Q�Ԗڈȍ~�̊Y�����R�[�h
				else{
					// ���m�̒l���傫�����������ւ���
					if(Math.abs(v)>Math.abs(Integer.parseInt(possible[1]))){
						if( rankup && boot2rank.get(temp[2]) )
							nxtSkill	= nextTemp[2];	// �Y�������X�L���̎�
						possible	= temp;
					}
				}
			}
			//
			preSkill = temp[2];
		}
		if(possible==null)
			return new ResultBootSkill("", false);
		if( rankup && boot2rank.get(possible[2]) ){
			if( sign )	return new ResultBootSkill(preLastSkill, true);
			else		return new ResultBootSkill(nxtSkill, true);
		}
		return new ResultBootSkill(possible[2], false);
	}
}
