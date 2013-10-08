package jp.skd.lilca.mhf.lib.skill_gain;

import java.util.HashMap;
import java.util.Iterator;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * �X�L���x�N�g���𒊏ۉ������N���X
 */
public class SkillVector {

	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * �R���X�g���N�^
	 */
	public SkillVector(){
		this.map.clear();
		return;
	}
	/**
	 * �R���X�g���N�^
	 * @param csv CSV�`���̃X�L���x�N�g��
	 */
	public SkillVector(String csv){
		String[] temp = CsvStringToList.split(csv, ",");
		for(int idx=0; idx<temp.length; idx++){
			SkillScalar ss = new SkillScalar(temp[idx]);
			map.put(ss.getSkillName(), ss.getSkillValue());
		}
		return;
	}
	/**
	 * �R���X�g���N�^
	 * @param csv ��؂蕶����ŋ�؂�ꂽ�X�L���x�N�g��
	 * @param dlm ��؂蕶����
	 */
	public SkillVector(String csv, String dlm){
		String[] temp = CsvStringToList.split(csv, dlm);
		for(int idx=0; idx<temp.length; idx++){
			SkillScalar ss = new SkillScalar(temp[idx]);
			map.put(ss.getSkillName(), ss.getSkillValue());
		}
		return;
	}
	/**
	 * �X�L���x�N�g���N���X���R�s�[
	 * @param src �R�s�[���̃X�L���x�N�g���N���X
	 */
	public void assign(SkillVector src){
		this.map.clear();
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			this.map.put(idx, src.getValue(idx));
		}
		return;
	}
	/**
	 * �X�L���x�N�g�������Z
	 * @param src ������X�L���x�N�g��
	 * @return ���Z���ʁi�X�L���x�N�g���j
	 */
	public SkillVector add(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				res.map.put(idx, src.getValue(idx));
			else
				res.map.put(idx, res.getValue(idx)+src.getValue(idx));
		}
		return res;
	}
	/**
	 * �X�L���x�N�g�������Z
	 * @param src �����X�L���x�N�g��
	 * @return ���Z���ʁi�X�L���x�N�g���j
	 */
	public SkillVector sub(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = src.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				res.map.put(idx, -src.getValue(idx));
			else
				res.map.put(idx, res.getValue(idx)-src.getValue(idx));
		}
		return res;
	}
	/**
	 * �X�L���x�N�g������Z
	 * @param src �|����X�L���x�N�g��
	 * @return ��Z����
	 */
	public SkillVector mul(SkillVector src){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = res.getMap().keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(src.getValue(idx)==null)
				res.map.put(idx, null);
			else
				res.map.put(idx, res.getValue(idx)*src.getValue(idx));
		}
		return res;
	}
	/**
	 * �P�ʃX�L���x�N�g�����擾
	 * @return �P�ʃX�L���x�N�g��
	 */
	public SkillVector unit(){
		SkillVector res = new SkillVector();
		res.assign(this);
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String idx=ite.next();
			if(res.getValue(idx)==null)
				continue;
			else
				res.map.put(idx, 1);
		}
		return res;
	}
	/**
	 * �X�L���x�N�g���̃n�b�V���}�b�v���擾
	 * @return �X�L���x�N�g���̃n�b�V���}�b�v
	 */
	public HashMap<String, Integer> getMap(){
		return this.map;
	}
	/**
	 * �w�肵���X�L���̃X�L���l
	 * @param key �w��X�L����
	 * @return �X�L���l
	 */
	public Integer getValue(String key){
		if(this.map.get(key)==null)
			return 0;
		return this.map.get(key);
	}
	/**
	 * �X�L���x�N�g������؂蕶����ŕҏW���Ď擾
	 * @param sep ��؂蕶����
	 * @return �ҏW��̃X�L���x�N�g��
	 */
	public String exportSkills(String sep){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val >= 0)
				res += sep+key+"+"+Integer.toString(val);
			else
				res += sep+key+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * �X�L���x�N�g������؂蕶����ŕҏW���Ď擾�i�[���v�f�������j
	 * ��؂蕶����́u,�v�i�J���}�j
	 * @return �ҏW��̃X�L���x�N�g��
	 */
	public String exportSkillsWithoutZeroElements(){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val > 0)
				res += ","+key+"+"+Integer.toString(val);
			else
			if(val < 0)
				res += ","+key+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * �X�L���x�N�g���𕶎���`���ɃG�N�X�|�[�g
	 * @return ������`���̃X�L���x�N�g��
	 */
	public String exportString(){
		String res = "";
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			res += "@"+key+"$"+Integer.toString(val);
		}
		if(res.equals(""))
			return "";
		return res.substring(1);
	}
	/**
	 * ������`���̃X�L���x�N�g�����C���|�[�g
	 * @param in ������`���̃X�L���x�N�g��
	 */
	public void importString(String in){
		this.map.clear();
		if(in.equals(""))
			return ;
		String[] skills = CsvStringToList.split(in, "@");
		for(int idx=0; idx<skills.length; idx++){
			String[] item = CsvStringToList.split(skills[idx], "$");
			this.map.put(item[0], Integer.parseInt(item[1]));
		}
		return;
	}
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Integer value){
		this.map.put(key, value);
		return;
	}
	/**
	 * �w�肵���X�L���̃X�L���l(getValue���\�b�h�̎g�p�𐄏�)
	 * @param key �w��X�L����
	 * @return �X�L���l
	 */
	public Integer get(String key){
		return this.map.get(key);
	}
	/**
	 * �e�X�L���l���w��l�ȉ��̏ꍇ�A�w��l�ɐݒ肵�čĊi�[
	 * @param c �w��l
	 */
	public void roundingup(int c){
		Iterator<String> ite = this.map.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Integer val = this.map.get(key);
			if(val<=c)
				this.map.put(key, c);
		}
		return;
	}
}
