package jp.skd.lilca.mhf.lib.skill_gain;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * �X�L���Q�C���𒊏ۉ������N���X
 */
public class SkillGain {
	/**
	 * ������`���̃X�L���i�����j�̃X�L���l�̑��a���擾
	 * @param condition ������`���̃X�L���i�����j
	 * @param delim ��؂蕶����
	 * @return �X�L���l�̑��a
	 */
	public static int getLevel(String condition, String delim){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] list = CsvStringToList.split(condition, delim);
		for(int idx=0; idx<list.length; idx++){
			// ����
			String skill = list[idx].replace("�{", "+").replace("�|", "-");
			int value = 0;
			// �����X�L��
			int c;
			if((c=skill.indexOf("+"))!=-1){
				value = (int)(Double.parseDouble(skill.substring(c).replace("+", "")));
			}
			else{
				c = skill.indexOf("-");
				value = (int)(Double.parseDouble(skill.substring(c)));			
			}
			res += value;
		}
		return res;
	}
	/**
	 * �X�L���Q�C���̎擾
	 * @param fields �h��A�����i�A�J�t���̃X�L���x�N�g���i������`���j
	 * @param condition �����̃X�L���x�N�g���i������`���j
	 * @return �X�L���Q�C��
	 */
	public static int getSkillGain(String fields, String condition){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] fs = CsvStringToList.split(fields, ":");
		String[] cs = CsvStringToList.split(condition, ",");
		// �����v�Z
		for(int idx=0; idx<cs.length; idx++)
			for(int jdx=0; jdx<fs.length; jdx++)
				if(!fs[0].equals(""))
					res += getGain(cs[idx].trim(), fs[jdx].trim());
		return res;
	}
	/**
	 * ��̃X�L���̃X�L���Q�C��
	 * @param con �����̃X�L��
	 * @param fld �h��A�����i�A�J�t�̃X�L��
	 * @return �X�L���Q�C��
	 */
	private static int getGain(String con, String fld){
		return getGainBase(con, fld, true);
	}
	/**
	 * ��̃X�L���̃X�L���Q�C��
	 * @param con �����̃X�L��
	 * @param fld �h��A�����i�A�J�t�̃X�L��
	 * @return �X�L���Q�C��
	 */
	private static int getNegative(String con, String fld){
		return getGainBase(con, fld, false);
	}
	/**
	 * �X�L���Q�C���̎Z�o
	 * @param con �����̃X�L��
	 * @param fld �h��A�����i�A�J�t�̃X�L��
	 * @param dflt true=�ʏ�p,false=�����}���p
	 * @return �X�L���Q�C��
	 */
	private static int getGainBase(String con, String fld, boolean dflt){
		String cskill;
		int cvalue;
		String fskill;
		int fvalue;
		con = con.replace("�{", "+").replace("�|", "-");
		fld = fld.replace("�{", "+").replace("�|", "-");
		// �����X�L��
		int c;
		if((c=con.indexOf("+"))!=-1){
			cskill = con.substring(0, c);
			cvalue = (int)(Double.parseDouble(con.substring(c).replace("+", "")));
		}
		else{
			c = con.indexOf("-");
			cskill = con.substring(0, c);
			cvalue = (int)(Double.parseDouble(con.substring(c)));			
		}
		// �l�X�L��
		if((c=fld.indexOf("+"))!=-1){
			fskill = fld.substring(0, c);
			fvalue = (int)(Double.parseDouble(fld.substring(c).replace("+", "")));
		}
		else{
			c = fld.indexOf("-");
			fskill = fld.substring(0, c);
			fvalue = (int)(Double.parseDouble(fld.substring(c)));
		}
		// �Ⴄ�X�L���Ȃ�[��
		if(!cskill.equals(fskill))
			return 0;
		// ���Z
		if( dflt )
			return getCalGain(cvalue, fvalue);
		return getCalNegative(cvalue, fvalue);
	}
	/**
	 * �������Z�o
	 * @param c �����̃X�L���l
	 * @param f �X�L���l
	 * @return ����
	 */
	private static int getCalGain(int c, int f){
		// �����Z�o
		if( c <= f )
			return c;
		else
		if( c > f )
			return f;
		return -100;
	}
	/**
	 * �������Z�o�i�����}���p�j
	 * @param c �����̃X�L���l
	 * @param f �X�L���l
	 * @return ����
	 */
	private static int getCalNegative(int c, int f){
		// ���̃X�L���̓[��
		if( f >= 0 )
			return 0;
		return f;
	}
	/**
	 * �����}���p�̃X�L���Q�C���擾
	 * @param fields �h��A�����i�A�J�t���̃X�L��
	 * @param condition �w�肳�ꂽ�X�L��
	 * @return �����}���p�̃X�L���Q�C��
	 */
	public static int getSkillNegative(String fields, String condition){
		if(condition.equals(""))
			return 0;
		int res = 0;
		String[] fs = CsvStringToList.split(fields, ":");
		String[] cs = CsvStringToList.split(condition, ",");
		// �����v�Z
		for(int idx=0; idx<cs.length; idx++)
			for(int jdx=0; jdx<fs.length; jdx++)
				if(!fs[0].equals(""))
					res += getNegative(cs[idx].trim(), fs[jdx].trim());
		return res;
	}
}
