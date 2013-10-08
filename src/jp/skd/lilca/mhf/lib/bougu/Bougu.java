package jp.skd.lilca.mhf.lib.bougu;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.skill_gain.SkillDefines;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
/**
 * �h��𒊏ۉ������N���X
 */
public class Bougu{

	private String bui;
	private String name;
	private boolean kenshi;
	private boolean gunner;
	private int level;
	private String cost;
	private int def;
	private int fire;
	private int mizu;
	private int ryu;
	private int thunder;
	private int kori;
	private String skills;
	private int slots;
	private String sozai;
	private String rare;
	private boolean empty;
	private ArrayList<Sousyoku> sousyoku;
	// 12JAN �ǉ��@�L�����N�^�[����
	private int gender;	//1:�j����p�@2:������p�@3:���p
	// 12NOV �ǉ��@�h����
	private String btype;	// ����A�V���A�e��A���Ȃ�

	/**
	 * �R���X�g���N�^�i�����i�ƈꊇ���́j
	 * @param csvstr ������`���̖h��f�[�^
	 * @param t1 ������`���̑����i�f�[�^
	 * @param t2 ������`���̑����i�f�[�^
	 * @param t3 ������`���̑����i�f�[�^
	 */
	public Bougu(String csvstr, String t1, String t2, String t3){
		this.setString(csvstr);
		// ����
		this.sousyoku = new ArrayList<Sousyoku>();
		this.addSousyoku(new Sousyoku(t1));
		this.addSousyoku(new Sousyoku(t2));
		this.addSousyoku(new Sousyoku(t3));
		return;
	}
	/**
	 * �R���X�g���N�^
	 * @param csvstr ������`���̖h��f�[�^
	 */
	public Bougu(String csvstr){
		this(csvstr, "", "", "");
		return;
	}
	/**
	 * ������`���̖h��f�[�^���p�[�Y�i��́j
	 * @param csvstr ������`���̖h��f�[�^
	 */
	public void setString(String csvstr){
		empty = true;
		if(this.sousyoku!=null)
			this.sousyoku.clear();
		String[] fields = CsvStringToList.split(csvstr, ",");
		if(fields.length<16)
			return;
		empty = false;
		// ����
		this.bui = fields[0].trim();
		// ���O
		this.name = fields[1].trim();
		// ���m�t���O
		if(fields[2].equals("1"))
			this.kenshi = true;
		else
			this.kenshi = false;
		// �K���i�[�t���O
		if(fields[3].equals("1"))
			this.gunner = true;
		else
			this.gunner = false;
		// ���x��
		this.level = Integer.parseInt(fields[4]);
		// ���i
		this.cost = fields[5];
		// �h���
		this.def = Integer.parseInt(fields[6]);
		// ��
		this.fire = Integer.parseInt(fields[7]);
		// ��
		this.mizu = Integer.parseInt(fields[8]);
		// ��
		this.thunder = Integer.parseInt(fields[9]);
		// ��
		this.ryu = Integer.parseInt(fields[10]);
		// �X
		this.kori = Integer.parseInt(fields[11]);
		// �X�L��
		this.skills = fields[12];
		// �X���b�g��
		this.slots = Integer.parseInt(fields[13]);
		// �f��
		this.sozai = fields[14];
		// ���A�x
		this.rare = fields[15];
		// ���� (12JAN)
		if(fields.length <= 16 )
			this.gender = 3;	// ���t�H�[�}�b�g�ł͂��ׂċ��p����
		else
			this.gender = Integer.parseInt(fields[16]);
		// �h��^�C�v(12NOV)
		if(fields.length <= 17 )
			this.btype = "";	// ���t�H�[�}�b�g�ł͂��ׂĒʏ�h���
		else
			this.btype = fields[17];
		return;
	}
	/**
	 * �h��f�[�^�𕶎���`���Ƃ��Ď擾
	 * @return ������`���̖h��f�[�^
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// ����
		res += this.bui+",";
		// ���O
		res += this.name+",";
		// ���m�t���O
		if(this.kenshi)
			res += "1"+",";
		else
			res += "0"+",";
		// �K���i�[�t���O
		if(this.gunner)
			res += "1"+",";
		else
			res += "0"+",";
		// ���x��
		res += this.level+",";
		// ���i
		res += this.cost+",";
		// �h���
		res += this.def+",";
		// ��
		res += this.fire+",";
		// ��
		res += this.mizu+",";
		// ��
		res += this.thunder+",";
		// ��
		res += this.ryu+",";
		// �X
		res += this.kori+",";
		// �X�L��
		res += this.skills+",";
		// �X���b�g��
		res += this.slots+",";
		// �f��
		res += this.sozai+",";
		// ���A�x
		res += this.rare+",";
		// ���� (12JAN)
		res += this.gender+",";
		// �h��^�C�v(12NOV)
		res += this.btype;
		return res;
	}
	/**
	 * �h��f�[�^�̍폜�i�������j
	 */
	public void remove(){
		this.setString("");
		return;
	}
	/**
	 * �h��f�[�^����ł��邩���擾
	 * @return true=��,false=�h��f�[�^������
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * �h����m�Ŏg���邩�擾
	 * @return true=�g����,false=�g���Ȃ�
	 */
	public boolean isKenshi(){
		if(empty)
			return true;
		return this.kenshi;
	}
	/**
	 * �h��K���i�[�Ŏg���邩�擾
	 * @return true=�g����,false=�g���Ȃ�
	 */
	public boolean isGunner(){
		if(empty)
			return true;
		return this.gunner;
	}
	/**
	 * �h��Y�����镔�ʂł��邩���擾
	 * @param b �m�F����������(��or��or�ror��or�r)
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isBui(String b){
		if(empty)
			return true;
		if(this.bui.equals("��") && b.equals("��"))
			return true;
		if(this.bui.equals("��") && b.equals("��"))
			return true;
		if(this.bui.equals("�r") && b.equals("�r"))
			return true;
		if(this.bui.equals("��") && b.equals("��"))
			return true;
		if(this.bui.equals("�r") && b.equals("�r"))
			return true;
		return false;
	}
	/**
	 * �h��u���v�ł��邩�擾
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isAtama(){
		if(empty)
			return true;
		if(this.bui.equals("��"))
			return true;
		return false;
	}
	/**
	 * �h��u���v�ł��邩�擾
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isDou(){
		if(empty)
			return true;
		if(this.bui.equals("��"))
			return true;
		return false;
	}
	/**
	 * �h��u�r�v�ł��邩�擾
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isUde(){
		if(empty)
			return true;
		if(this.bui.equals("�r"))
			return true;
		return false;
	}
	/**
	 * �h��u���v�ł��邩�擾
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isKoshi(){
		if(empty)
			return true;
		if(this.bui.equals("��"))
			return true;
		return false;
	}
	/**
	 * �h��u�r�v�ł��邩�擾
	 * @return true=�Y�����镔�ʂł���,false=�Y�����镔�ʂłȂ�
	 */
	public boolean isAshi(){
		if(empty)
			return true;
		if(this.bui.equals("�r"))
			return true;
		return false;
	}
	/**
	 * �h��̖��O���擾
	 * @return �h��̖��O
	 */
	public String getName(){
		if(empty)
			return "�Ȃ�";
		return this.name;
	}
	/**
	 * �h�SP�h��ł��邩���擾
	 * @return true=SP�h��ł���,false=SP�h��łȂ�
	 */
	public boolean isSP(){
		if(empty)
			return false;
		if(this.name.startsWith("SP"))
			return true;
		return false;
	}
	/**
	 * �h��Y������^�C�v�iHC,�e��,��`�Ȃǁj
	 * @param t �m�F�������^�C�v
	 * @return true=�Y������^�C�v�ł���,false=�Y������^�C�v�łȂ�
	 */
	public boolean isBouguType(String t){
		if(empty)
			return false;
		// ��`�h��̓X�L���Ŕ��f
		if( t.indexOf("��`") != -1){
			return this.isIncludeHidenSkill();
		}
		if(this.btype.indexOf(t)!=-1)
			return true;
		return false;
	}
	/**
	 * �h���`�X�L�����܂�ł��邩���擾
	 * @return true=��`�X�L�����܂�ł���,false=��`�X�L�����܂�ł��Ȃ�
	 */
	private boolean isIncludeHidenSkill(){
		boolean res = false;
		for(int idx=0; idx<SkillDefines.hidenNameList.length; idx++)
			if( this.skills.indexOf(SkillDefines.hidenNameList[idx]) != -1 )
				return true;
		return res;
	}
	/**
	 * �h��̃^�C�v�iHC,�e��,��`�Ȃǁj���擾
	 * @return �^�C�v
	 */
	public String getBouguType(){
		if(empty)
			return "";
		return this.btype;
	}
	/**
	 * �h��̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j��HTML�^�O�����ĕ�����Ŏ擾
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
	 * �h��̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j���擾
	 * @return �X�L���̕�����
	 */
	public String getSkills(){
		if(empty)
			return "";
		return this.skills;
	}
	/**
	 * �h��Ƒ����i�����킹���X�L����HTML�^�O����̕�����Ŏ擾
	 * @param sep �����̂Ƃ��̋�؂蕶����
	 * @param color �����̃J���[�R�[�h
	 * @return HTML�^�O����̃X�L���̕�����
	 */
	public String getSkillsWithSousyokuWithColorTag(String sep, String color){
		if(empty)
			return "";
		SkillVector res = new SkillVector(this.skills, ":");
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			res = res.add(new SkillVector(this.sousyoku.get(idx).getSkills(), ":"));
		// �J���[�^�O�t��
		String temp = res.exportSkills(sep);
		String[] list = CsvStringToList.split(temp, sep);
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, sep);
	}
	/**
	 * �h��Ƒ����i�����킹���X�L���𕶎���Ŏ擾
	 * @param sep �����̂Ƃ��̋�؂蕶����
	 * @return �X�L���̕�����
	 */
	public String getSkillsWithSousyoku(String sep){
		if(empty)
			return "";
		SkillVector res = new SkillVector(this.skills, ":");
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			res = res.add(new SkillVector(this.sousyoku.get(idx).getSkills(), ":"));
		return res.exportSkills(sep);
	}
	/**
	 * �h��̃X�L�����X�L���x�N�g���Ƃ��Ď擾
	 * @return �X�L���x�N�g��
	 */
	public SkillVector getSkillVector(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector b = new SkillVector(this.skills, ":");
		res.assign(b);
		return res;
	}
	/**
	 * �h��Ƒ����i�����킹���X�L�����X�L���x�N�g���Ƃ��Ď擾
	 * @return �X�L���x�N�g��
	 */
	public SkillVector getSkillVectorWithSousyoku(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		SkillVector b = new SkillVector(this.skills, ":");
		res.assign(b);
		for(int idx=0; idx<this.sousyoku.size(); idx++){
			SkillVector s= new SkillVector(this.sousyoku.get(idx).getSkills(), ":");
			res = res.add(s);
		}
		return res;
	}
	/**
	 * �h��̃X���b�g���i�󂫃X���b�g�ł͂Ȃ��j
	 * @return �h��̃X���b�g��
	 */
	public int getSlot(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * �h��̃X���b�g���𕶎���Ŏ擾�i��F�����[�j
	 * @return ������`���̃X���b�g��
	 */
	public String getSlotString(){
		if(empty)
			return "---";
		if(this.slots==0)
			return "---";
		if(this.slots==1)
			return "o--";
		if(this.slots==2)
			return "oo-";
		return "ooo";
	}
	/**
	 * �h��̖h��͂��擾
	 * @return �h��̖h���
	 */
	public int getDef(){
		if(empty)
			return 0;
		return this.def;
	}
	/**
	 * �h��̃��x���i������1-7�j���擾
	 * @return �h��̃��x��
	 */
	public int getLevel(){
		if(empty)
			return 1;
		return this.level;
	}
	/**
	 * �h��̑f�ނ𕶎���Ŏ擾
	 * @return �h��̑f��
	 */
	public String getSozai(){
		if(empty)
			return "";
		return this.sozai;
	}
	/**
	 * �h��̃��A�x���擾
	 * @return �h��̃��A�x
	 */
	public int getRare(){
		if(empty)
			return 1;
		// �t�H�[�}�b�g����
		if( this.rare.indexOf("@") != -1 ){
			// �V�t�H�[�}�b�g
			String[] list	= CsvStringToList.split(this.rare, "@");
			return Integer.parseInt( list[0] );
		}
		// ������
		if( this.rare.indexOf("GR") != -1 ){
			int a	= Integer.parseInt( this.rare.replaceAll("GR", "") );
			return a+7;
		}
		return Integer.parseInt( this.rare );
	}
	// 12JAN �j�����g���邩
	/**
	 * �h��j���L�������g���邩���擾
	 * @return true=�g����,false=�g���Ȃ�
	 */
	public boolean canMale(){
		if(empty){
			return true;
		}
		// �j�����g����Ȃ�
		if(this.gender % 2 == 1){
			return true;
		}
		return false;
	}
	// 12JAN �������g���邩
	/**
	 * �h������L�������g���邩���擾
	 * @return true=�g����,false=�g���Ȃ�
	 */
	public boolean canFemale(){
		if(empty){
			return true;
		}
		// �������g����Ȃ�
		if((this.gender / 2) % 2 == 1){
			return true;
		}
		return false;
	}
	/**
	 * �h��̉Αϐ����擾
	 * @return �h��̉Αϐ�
	 */
	public int getFire(){
		if(empty)
			return 0;
		return this.fire;
	}
	/**
	 * �h��̐��ϐ����擾
	 * @return �h��̐��ϐ�
	 */
	public int getMizu(){
		if(empty)
			return 0;
		return this.mizu;
	}
	/**
	 * �h��̗��ϐ����擾
	 * @return �h��̗��ϐ�
	 */
	public int getRyu(){
		if(empty)
			return 0;
		return this.ryu;
	}
	/**
	 * �h��̗��ϐ����擾
	 * @return �h��̗��ϐ�
	 */
	public int getThunder(){
		if(empty)
			return 0;
		return this.thunder;
	}
	/**
	 * �h��̕X�ϐ����擾
	 * @return �h��̕X�ϐ�
	 */
	public int getKori(){
		if(empty)
			return 0;
		return this.kori;
	}
	/**
	 * �^����ꂽ������i�U��+5�A�B�l-4�Ȃǁj�̃X�L�������擾
	 * @param src �m�F������������
	 * @return �X�L����
	 */
	public static String getSkillName(String src){
		String res = null;
		src = src.replace("�{", "+").replace("�|", "-");
		if(src.indexOf("+")!=-1)
			res = src.substring(0, src.indexOf("+"));
		else
			res = src.substring(0, src.indexOf("-"));
		return res;
	}
	/**
	 * �^����ꂽ������i�U��+5�A�B�l-4�Ȃǁj�̃X�L���l���擾
	 * @param src �m�F������������
	 * @return �X�L���l
	 */
	public static Integer getSkillValue(String src){
		Integer res = null;
		src = src.replace("�{", "+").replace("�|", "-");
		if(src.indexOf("+")!=-1)
			res = (int)Double.parseDouble(src.substring(src.indexOf("+")).replace("+", ""));
		else
			res = (int)Double.parseDouble(src.substring(src.indexOf("-")));
		return res;
	}
	// 12JAN ���ʂɂ��e�C�N�I�t
	/**
	 * �w�肳�ꂽ���ʂŎg���Ȃ��ꍇ�A�h��f�[�^��������
	 * @param male true=�j��,false=����
	 */
	public void ifNotTakeoffSexually(boolean male){
		// �L�������j����
		if(male){
			// �j�����g���Ȃ��Ƃ�
			if(!this.canMale())
				this.setString("");
		}
		// �L������������
		else{
			// �������g���Ȃ��Ƃ�
			if(!this.canFemale())
				this.setString("");
		}
		return;
	}
	/**
	 * �w�肳�ꂽ�l�i���mor�K���i�[�j�Ŏg���Ȃ��ꍇ�A�h��f�[�^��������
	 * @param kenshi true=���m,false=�K���i�[
	 */
	public void ifNotTakeoff(boolean kenshi){
		if(kenshi){
			if(!this.isKenshi())
				this.setString("");
		}
		else{
			if(!this.isGunner())
				this.setString("");
		}
		return;
	}
	/**
	 * �h��̋󂫃X���b�g�����擾
	 * @return �󂫃X���b�g��
	 */
	public int getEmptySlots(){
		// ����̃X���b�g���擾
		int slots = this.getSlot();
		// ����Ă���X���b�g��
		int spended = this.getSpendedSlots();
		return (slots - spended);
	}
	/**
	 * �h��̏���X���b�g�����擾
	 * @return ����X���b�g��
	 */
	public int getSpendedSlots(){
		// ����Ă���X���b�g��
		int spended = 0;
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			spended += this.sousyoku.get(idx).getSlotCost();
		return spended;
	}
	/**
	 * �h��ɑ����i�f�[�^��ǉ��i�X���b�g������Ȃ��ꍇ�͒ǉ�����Ȃ��j
	 * @param src �ǉ����鑕���i�f�[�^
	 * @return true=���ȊO,false=�X���b�g��������Ȃ�
	 */
	public boolean addSousyoku(Sousyoku src){
		// ������ۂȂ玸�s
		if(src.isEmpty())
			return false;
		// �I�[�o�[�Ȃ玸�s
		if( this.getEmptySlots() < src.getSlotCost() ){
			return false;
		}
		// �ǉ�
		this.sousyoku.add(src);
		return true;
	}
	/**
	 * �h��ɕt���Ă��鑕���i�̃��X�g���擾
	 * @return �����i�f�[�^�̃��X�g
	 */
	public ArrayList<Sousyoku> getSousyokuList(){
		if(this.sousyoku == null)
			return new ArrayList<Sousyoku>();
		return this.sousyoku;
	}
	/**
	 * �h����Ă��鑕���i�̖��O�𕶎���Ŏ擾
	 * @param seq �����̏ꍇ�̋�؂蕶����
	 * @return �����i�̖��O
	 */
	public String getTamaNames(String seq){
		String res = "";
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(idx==0)
				res += this.sousyoku.get(idx).getName();
			else
				res += seq+this.sousyoku.get(idx).getName();
		return res;
	}
}
