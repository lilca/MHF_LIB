package jp.skd.lilca.mhf.lib.buki;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Sousyoku;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * ����𒊏ۉ������N���X
 */
public class Buki{
	/**
	 * ���m�̃f�t�H���g�f�[�^
	 */
	public static String DefKenshi = "�Ў茕,�n���^�[�i�C�t,240,1,84,,28@7@18@0@0@0@28@7@32@3@0@0,0,0,�S�z�΁~2,HR1,,,,,";
	/**
	 * �K���i�[�̃f�t�H���g�f�[�^
	 */
	public static String DefGunner = "���C�g�{�E�K��,�N���X�{�E�K��,325,1,96,��:2@��:3/3@��:3/-@��:3/-@��:3/-,,0,3,�S�z�΁~4:�����y���z�~2,HR1,��:6/6/9+@��:3/3+/3+@�U:2+/2+/2+@�O:3/1+/1+@�g:1+/1+/1+,��:2@�y:2,����,��,";
	// �I���W�i��
	private String org;
	// �e���틤��
	private String type;
//	private boolean sp;	// ����H
	private String name;
	private int cost;
	private int rare;
	private int attack;
	private int def;
	private int kaishin;
	private int slots;
	private String sozai;	
	private int level;
	private String rank;
	private String reach;
	// 2012/1/30�ǉ�
	private boolean oyakata;
	// 12NOV�ǉ�
	private String bukitype;
	// ���m�ŗL
	private String attrType;
	private String spAttrType;
	private int attrAttack;
	private int spAttrAttack;
	private Kire kire;
	// �ŗL
	private Neiro neiro;		// ��J
	private Hougeki hougeki;	// �K�������X
	private Tame tame;			// �|
	private Bin bin;			// �|
	private Gun attrgun;		// ���C�g�{�E�K�����w�r�[�{�E�K��
	private Gun nrmgun;			// ���C�g�{�E�K�����w�r�[�{�E�K��
	private Gun spgun;			// ���C�g�{�E�K�����w�r�[�{�E�K��
	private Reload reload;		// ���C�g�{�E�K�����w�r�[�{�E�K��
	private Handou handou;		// ���C�g�{�E�K�����w�r�[�{�E�K��
	private String super_sokusya;// ���C�g�{�E�K��
	// 
	private boolean empty;
	private ArrayList<Sousyoku> sousyoku;

	/**
	 * �R���X�g���N�^
	 * @param csvstr ������`���̕���f�[�^
	 * @param t1 ������`���̑����i�f�[�^
	 * @param t2 ������`���̑����i�f�[�^
	 * @param t3 ������`���̑����i�f�[�^
	 */
	public Buki(String csvstr, String t1, String t2, String t3){
		this.setString(csvstr);
		// ����
		this.sousyoku = new ArrayList<Sousyoku>();
		this.addSousyoku(new Sousyoku(t1));
		this.addSousyoku(new Sousyoku(t2));
		this.addSousyoku(new Sousyoku(t3));
		return;
	}
	/**
	 * �R���X�g���N�^�i�����i�͂Ȃ������j
	 * @param csvstr ������`���̕���f�[�^
	 */
	public Buki(String csvstr){
		this(csvstr, "", "", "");
		return;
	}
	/**
	 * ������`���̕���f�[�^���p�[�Y�i��́j
	 * @param csvstr  ������`���̕���f�[�^
	 */
	public void setString(String csvstr){
		if(csvstr.equals(""))
			csvstr = DefKenshi;
		this.org = csvstr;
try{
		empty = true;
		if(this.sousyoku!=null)
			this.sousyoku.clear();
		String[] fields = CsvStringToList.split(csvstr, ",");
		// �����`�F�b�N
//		if(fields.length<16)
//			return;
		empty = false;
		// �����e�̏���
		this.attrgun = new Gun("");
		// �^�C�v
		this.type = fields[0].trim();
		// ���O
		String[] div = CsvStringToList.split(fields[1], "@");
		//this.name = fields[1].trim(); 12NOV�폜
		this.name = div[0].trim();
		// ����^�C�v
		if( div.length >= 2 )
			this.bukitype = div[1].replace("�i", "").replace("�j", "");
		else
			this.bukitype = "";
		// ��p
		this.cost = Integer.parseInt(fields[2].trim());
		// ���A�x
		this.rare = Integer.parseInt(fields[3].trim());
		// �U����
		this.attack = Integer.parseInt(fields[4].trim());
		// �������h��
		setAttrAttack(fields[5]);
		// �؂ꖡ
		this.kire = new Kire(fields[6]);
		// ��S��
		this.kaishin = Integer.parseInt(fields[7].trim());
		// �X���b�g
		this.slots = Integer.parseInt(fields[8].trim());
		// �f��
		this.sozai = fields[9];
		// �����N
		this.rank = fields[10];
		// ���했
		if(	this.type.equals("��J")){
			this.neiro = new Neiro(fields[11]);
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else
		if(	this.type.equals("�K�������X")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki(fields[11]);
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else
		if(	this.type.equals("���C�g�{�E�K��")||
			this.type.equals("�w�r�B�{�E�K��")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun(fields[11]);
			this.spgun = new Gun(fields[12]);
			this.reload = new Reload(fields[13]);
			this.handou = new Handou(fields[14]);
			this.super_sokusya = fields[15].replaceAll("@", ",");
		}
		else
		if(	this.type.equals("�|")){
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame(fields[11]);
			this.bin = new Bin(fields[12]);
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		else{
			this.neiro = new Neiro("");
			this.hougeki = new Hougeki("");
			this.tame = new Tame("");
			this.bin = new Bin("");
			this.nrmgun = new Gun("");
			this.spgun = new Gun("");
			this.reload = new Reload("");
			this.handou = new Handou("");
			this.super_sokusya = "";
		}
		
}catch(Exception e){
	e.printStackTrace();
}
		return;
	}
	/**
	 * ����f�[�^�̍폜�i�������j
	 */
	public void remove(){
		if(this.isKenshi())
			this.setString("");
		else
			this.setString(DefGunner);
		return;
	}
	/**
	 * �����U���̐ݒ�
	 * @param src ������`���̑����U���f�[�^
	 */
	private void setAttrAttack(String src){
		String[] parts = CsvStringToList.split(src, "@");
		// ������
		this.reach		= "";
		this.oyakata	= false;
		this.def		= 0;
		// �ŏ����󕶎���Ȃ�I���
		if(parts[0].equals(""))
			return;
		// �����
		for(int idx=0; idx<parts.length; idx++){
			String[] temp = CsvStringToList.split(parts[idx], ":");
			if(temp[0].equals(""))
				continue;
			if(temp[0].startsWith("�h"))
				this.def = (int) Double.parseDouble(temp[0].replaceAll("�h", "").replace("+", ""));
			else
			// �e�Ȃ�
			if(parts[idx].indexOf("/")!=-1){
				this.attrgun.add(parts[idx]);
			}
			else
			if(temp[0].equals("���") || temp[0].equals("��") || temp[0].equals("����")){
				this.spAttrType = temp[0];
				this.spAttrAttack = Integer.parseInt(temp[1]);
			}
			else
			if(temp[0].equals("���[�`"))
				this.reach = temp[1];
			else
			if(temp[0].equals("�e����"))
				this.oyakata = true;
			else{
				// �e����Ȃ����
				if(parts[idx].indexOf("/")==-1){
					this.attrType = temp[0];
					this.attrAttack = Integer.parseInt(temp[1]);
				}
				// �e�Ȃ�
				else{
					this.attrgun.add(parts[idx]);
				}
			}
		}
		return;
	}
	/**
	 * ����f�[�^�𕶎���`���Ƃ��Ď擾
	 * @return ������`���̕���f�[�^
	 */
	public String getCsvString(){
		String res = "";
		if(this.isEmpty())
			return res;
		// �I���W�i���R�s�[
		res += this.org;
		return res;
	}
	/**
	 * ����f�[�^����ł��邩���擾
	 * @return true=��,false=�h��f�[�^������
	 */
	public boolean isEmpty(){
		return empty;
	}
	/**
	 * �������擾
	 * @return �����
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * ����̃^�C�v�����擾(���mor�K���i�[)
	 * @return ����̃^�C�v��
	 */
	public String getTypeString(){
		if(this.isKenshi())
			return "���m";
		return "�K���i�[";
	}
	/**
	 * ���m���ۂ��𔻒�
	 * @param src ����햼
	 * @return true=���m,false=����ȊO
	 */
	public static boolean isKenshi(String src){
		if(src.equals(""))
			return true;
		if(src.equals("�Ў茕"))
			return true;
		if(src.equals("�o��"))
			return true;
		if(src.equals("�匕"))
			return true;
		if(src.equals("����"))
			return true;
		if(src.equals("�n���}�["))
			return true;
		if(src.equals("��J"))
			return true;
		if(src.equals("�����X"))
			return true;
		if(src.equals("�K�������X"))
			return true;
		return false;
	}
	/**
	 * �K���i�[���ۂ��𔻒�
	 * @param src ����햼
	 * @return true=�K���i�[,false=����ȊO
	 */
	public static boolean isGunner(String src){
		if(src.equals(""))
			return true;
		if(src.equals("���C�g�{�E�K��"))
			return true;
		if(src.equals("�w�r�B�{�E�K��"))
			return true;
		if(src.equals("�|"))
			return true;
		return false;
	}
	/**
	 * ������`���̃��[�`�𐔒l�Ŏ擾
	 * @param src ������`���̃��[�`
	 * @return ���l�̃��[�`
	 */
	public static int getReachScalar(String src){
		if(src.equals("�ɒZ"))
			return 0;
		if(src.equals("�Z"))
			return 1;
		if(src.equals("��"))
			return 2;
		if(src.equals("��"))
			return 3;
		if(src.equals("�ɒ�"))
			return 4;
		if(src.equals("����`"))
			return 5;
		return -1;
	}
	/**
	 * ���l�̃��[�`�𕶎���`���Ŏ擾
	 * @param src ���l�̃��[�`
	 * @return ������`���̃��[�`
	 */
	public static String getReachString(int src){
		if(src == 0)
			return "�ɒZ";
		if(src == 1)
			return "�Z";
		if(src == 2)
			return "��";
		if(src == 3)
			return "��";
		if(src == 4)
			return "�ɒ�";
		if(src == 5)
			return "����`";
		return "�G���[";
	}
	/**
	 * ����{���畐�����l�����čU���͂��擾
	 * @param bukibai ����{
	 * @return �U����
	 */
	public int getBukiAttack(int bukibai){
		if(empty)
			return 0;
		if(this.type.equals("�Ў茕"))
			return bukibai*14/10;
		if(this.type.equals("�o��"))
			return bukibai*14/10;
		if(this.type.equals("�匕"))
			return bukibai*48/10;
		if(this.type.equals("����"))
			return bukibai*48/10;
		if(this.type.equals("�n���}�["))
			return bukibai*52/10;
		if(this.type.equals("��J"))
			return bukibai*52/10;
		if(this.type.equals("�����X"))
			return bukibai*23/10;
		if(this.type.equals("�K�������X"))
			return bukibai*23/10;
		if(this.type.equals("���C�g�{�E�K��"))
			return bukibai*12/10;
		if(this.type.equals("�w�r�B�{�E�K��"))
			return bukibai*12/10;
		if(this.type.equals("�|"))
			return bukibai*12/10;
		return 0;
	}
	/**
	 * ����킲�Ƃ̕���{���擾
	 * @return ����{
	 */
	public int getBukiBairitsu(){
		if(empty)
			return this.getAttack();
		if(this.type.equals(""))
			return this.getAttack();
		if(this.type.equals("�Ў茕"))
			return this.getAttack()*10/14;
		if(this.type.equals("�o��"))
			return this.getAttack()*10/14;
		if(this.type.equals("�匕"))
			return this.getAttack()*10/48;
		if(this.type.equals("����"))
			return this.getAttack()*10/48;
		if(this.type.equals("�n���}�["))
			return this.getAttack()*10/52;
		if(this.type.equals("��J"))
			return this.getAttack()*10/52;
		if(this.type.equals("�����X"))
			return this.getAttack()*10/23;
		if(this.type.equals("�K�������X"))
			return this.getAttack()*10/23;
		if(this.type.equals("���C�g�{�E�K��"))
			return this.getAttack()*10/12;
		if(this.type.equals("�w�r�B�{�E�K��"))
			return this.getAttack()*10/12;
		if(this.type.equals("�|"))
			return this.getAttack()*10/12;
		return this.getAttack();
	}
	/**
	 * ����{���畐�����l�����čU���͂��擾
	 * @param a ����{
	 * @return �U����
	 */
	public int calBairitsu(int a){
		if(empty)
			return a;
		if(this.type.equals(""))
			return a;
		if(this.type.equals("�Ў茕"))
			return a*14/10;
		if(this.type.equals("�o��"))
			return a*14/10;
		if(this.type.equals("�匕"))
			return a*48/10;
		if(this.type.equals("����"))
			return a*48/10;
		if(this.type.equals("�n���}�["))
			return a*52/10;
		if(this.type.equals("��J"))
			return a*52/10;
		if(this.type.equals("�����X"))
			return a*23/10;
		if(this.type.equals("�K�������X"))
			return a*23/10;
		if(this.type.equals("���C�g�{�E�K��"))
			return a*12/10;
		if(this.type.equals("�w�r�B�{�E�K��"))
			return a*12/10;
		if(this.type.equals("�|"))
			return a*12/10;
		return a;
	}
	/**
	 * ���m���ۂ��𔻒�
	 * @return true=���m,false=����ȊO
	 */
	public boolean isKenshi(){
		if(empty)
			return true;
		if(this.type.equals(""))
			return true;
		if(this.type.equals("�Ў茕"))
			return true;
		if(this.type.equals("�o��"))
			return true;
		if(this.type.equals("�匕"))
			return true;
		if(this.type.equals("����"))
			return true;
		if(this.type.equals("�n���}�["))
			return true;
		if(this.type.equals("��J"))
			return true;
		if(this.type.equals("�����X"))
			return true;
		if(this.type.equals("�K�������X"))
			return true;
		return false;
	}
	/**
	 * �K���i�[���ۂ��𔻒�
	 * @return true=�K���i�[,false=����ȊO
	 */
	public boolean isGunner(){
		if(empty)
			return true;
		if(this.type.equals(""))
			return true;
		if(this.type.equals("���C�g�{�E�K��"))
			return true;
		if(this.type.equals("�w�r�B�{�E�K��"))
			return true;
		if(this.type.equals("�|"))
			return true;
		return false;
	}
	/**
	 * ����̖��O���擾
	 * @return ����̖��O
	 */
	public String getName(){
		if(empty)
			return "�Ȃ�";
		return this.name;
	}
	/**
	 * SP���킩�ۂ��𔻒�
	 * @return true=SP����,false=����ȊO
	 */
	public boolean isSP(){
		if(empty)
			return false;
		if(this.name == null)
			return false;
		if(this.name.indexOf("SP")!=-1)
			return true;
		return false;
	}
	/**
	 * ���킪�w�肵����ށi�e�핐��Ȃǁj
	 * @param t ����̎��
	 * @return true=�w�肵����ނƈ�v,false=����ȊO
	 */
	public boolean isBukiType(String t){
		if(empty)
			return false;
		if(this.bukitype.indexOf(t)!=-1)
			return true;
		return false;
	}
	/**
	 * ����̎�ނ��擾
	 * @return ����̎��
	 */
	public String getBukiType(){
		if(empty)
			return "";
		return this.bukitype;
	}
	/**
	 * ����̍U���͂��擾
	 * @return ����̍U����
	 */
	public int getAttack(){
		return this.getAttack(0);
	}
	/**
	 * ����̍U���͂��擾�i�아���̕���{���l���ł���j
	 * @param gofu �아�Ȃǂ̕���{
	 * @return ����̍U����
	 */
	public int getAttack(int gofu){
		int res = this.attack;
		if(this.type.equals("�Ў茕"))
			res += gofu*14/10;
		if(this.type.equals("�o��"))
			res += gofu*14/10;
		if(this.type.equals("�匕"))
			res += gofu*48/10;
		if(this.type.equals("����"))
			res += gofu*48/10;
		if(this.type.equals("�n���}�["))
			res += gofu*52/10;
		if(this.type.equals("��J"))
			res += gofu*52/10;
		if(this.type.equals("�����X"))
			res += gofu*23/10;
		if(this.type.equals("�K�������X"))
			res += gofu*23/10;
		if(this.type.equals("���C�g�{�E�K��"))
			res += gofu*12/10;
		if(this.type.equals("�w�r�B�{�E�K��"))
			res += gofu*12/10;
		if(this.type.equals("�|"))
			res += gofu*12/10;
		if(this.getType().equals("���C�g�{�E�K��") || this.getType().equals("�w�r�B�{�E�K��"))
			return res+60;
		return res;
	}
	/**
	 * ������`���̑����U���^�C�v���擾
	 * @return ������`���̑����U���^�C�v
	 */
	public String getAttrType(){
		if(empty)
			return "";
		if(this.attrType==null)
			return "";
		return this.attrType;
	}
	/**
	 * ������`���ُ̈푮���U���^�C�v���擾
	 * @return ������`���ُ̈푮���U���^�C�v
	 */
	public String getSpAttrType(){
		if(empty)
			return "";
		if(this.spAttrType==null)
			return "";
		return this.spAttrType;
	}
	/**
	 * ������`���̑����U�����擾
	 * @return ������`���̑����U��
	 */
	public String getAttrAttackString(){
		if(this.attrType == null || this.attrType.trim().equals(""))
			return "";
		return this.attrType+" "+this.attrAttack;
	}
	/**
	 * ������`���ُ̈푮���U�����擾
	 * @return ������`���ُ̈푮���U��
	 */
	public String getSpAttrAttackString(){
		if(this.spAttrType == null || this.spAttrType.trim().equals(""))
			return "";
		return this.spAttrType+" "+this.spAttrAttack;
	}
	/**
	 * ����̃X�L���i�����̂Ƃ��́u:�v�ŋ�؂�j��HTML�^�O�����ĕ�����Ŏ擾�i������g��Ȃ��j
	 * @param color �����̃J���[�R�[�h
	 * @return HTML�^�O����̃X�L���̕�����
	 */
	public String getSkillsWithColorTag(String color){
//		String temp = this.getSkills();
		String temp = "";
		String[] list = CsvStringToList.split(temp, ":");
		for(int idx=0; idx<list.length; idx++)
			if(list[idx].indexOf('-')!=-1)
				list[idx] = "<font color=\""+color+"\">"+list[idx]+"</font>";
		return CsvStringToList.scat(list, ":");
	}
	/**
	 * ����Ƒ����i�����킹���X�L����HTML�^�O����̕�����Ŏ擾�i��؂蕶����́u:�v�j
	 * @return HTML�^�O����̃X�L���̕�����
	 */
	public String getSkillsWithSousyoku(){
		if(empty)
			return "";
		String res = "";	// ����̓X�L�����Ȃ��̂�
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(res.equals(""))
				res += this.sousyoku.get(idx).getSkills();
			else
				res += ":"+this.sousyoku.get(idx).getSkills();
		return res;
	}
	/**
	 * ����Ƒ����i�����킹���X�L�����X�L���x�N�g���Ƃ��Ď擾
	 * @return �X�L���x�N�g��
	 */
	public SkillVector getSkillVectorWithSousyoku(){
		SkillVector res = new SkillVector();
		if(empty)
			return res;
		for(int idx=0; idx<this.sousyoku.size(); idx++){
			SkillVector s= new SkillVector(this.sousyoku.get(idx).getSkills(), ":");
			res = res.add(s);
		}
		return res;
	}
	/**
	 * ����̃X���b�g���i�󂫃X���b�g�ł͂Ȃ��j
	 * @return ����̃X���b�g��
	 */
	public int getSlot(){
		if(empty)
			return 0;
		return this.slots;
	}
	/**
	 * ����̃X���b�g���𕶎���Ŏ擾�i��F�����[�j
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
	 * ����̖h��͂��擾
	 * @return ����̖h���
	 */
	public int getDef(){
		if(empty)
			return 0;
		return this.def;
	}
	/**
	 * ����̃��x���擾�i������g��Ȃ��j
	 * @return ����̃��x��
	 */
	public int getLevel(){
		if(empty)
			return 1;
		return this.level;
	}
	/**
	 * ����̑f�ނ𕶎���Ŏ擾
	 * @return ����̑f��
	 */
	public String getSozai(){
		if(empty)
			return "";
		return this.sozai;
	}
	/**
	 * ����̃��A�x���擾
	 * @return ����̃��A�x
	 */
	public int getRare(){
		if(empty)
			return 1;
		return this.rare;
	}
	/**
	 * ����̃��[�`���擾
	 * @return ����̃��[�`
	 */
	public String getReach(){
		if(empty)
			return "��";
		if(this.reach == null)
			return "��";
		if(this.reach.equals(""))
			return "��";
		return this.reach;
	}
	/**
	 * ����̐e����𕶎���Ŏ擾
	 * @return �u�e����vor�u�v
	 */
	public String getOyakata(){
		if(this.oyakata)
			return "�e����";
		return "";
	}
	/**
	 * ����̉��i���擾
	 * @return ����̉��i
	 */
	public int getCost(){
		return this.cost;
	}
	/**
	 * ����̃����N���擾
	 * @return ����̃����N
	 */
	public String getRank(){
		return this.rank;
	}
	/**
	 * ����̉�S�����擾
	 * @return ����̉�S��
	 */
	public int getKaishin(){
		return this.kaishin;
	}
	/**
	 * ����̎a�ꖡ���擾
	 * @return �a�ꖡ
	 */
	public Kire getKire(){
		return this.kire;
	}
	/**
	 * ����̉��F���擾
	 * @return ����̉��F
	 */
	public Neiro getNeiro(){
		return this.neiro;
	}
	/**
	 * ����̖C�����擾
	 * @return ����̖C��
	 */
	public Hougeki getHougeki(){
		return this.hougeki;
	}
	/**
	 * ����̗��߂��擾
	 * @return ����̗���
	 */
	public Tame getTame(){
		return this.tame;
	}
	/**
	 * ����̃r�������擾
	 * @return ����̃r�����
	 */
	public Bin getBin(){
		return this.bin;
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
	/**
	 * ����̋󂫃X���b�g�����擾
	 * @return ����̋󂫃X���b�g��
	 */
	public int getEmptySlots(){
		// ����̃X���b�g���擾
		int slots = this.getSlot();
		// ����Ă���X���b�g��
		int spended = this.getSpendedSlots();
		return (slots - spended);
	}
	/**
	 * ����̏���X���b�g�����擾
	 * @return ����̏���X���b�g��
	 */
	public int getSpendedSlots(){
		// ����Ă���X���b�g��
		int spended = 0;
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			spended += this.sousyoku.get(idx).getSlotCost();
		return spended;
	}
	/**
	 * ����ɑ����i�f�[�^��ǉ��i�X���b�g������Ȃ��ꍇ�͒ǉ�����Ȃ��j
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
	 * ����ɕt���Ă��鑕���i�̃��X�g���擾
	 * @return �����i�f�[�^�̃��X�g
	 */
	public ArrayList<Sousyoku> getSousyokuList(){
		if(this.sousyoku == null)
			return new ArrayList<Sousyoku>();
		return this.sousyoku;
	}
	/**
	 * ���킪���Ă��鑕���i�̖��O�𕶎���Ŏ擾
	 * @param seq �����̏ꍇ�̋�؂蕶����
	 * @return �����i�̖��O
	 */
	public String getTamaNames(String seq){
		String res = "";
		for(int idx=0; idx<this.sousyoku.size(); idx++)
			if(idx==0)
				res += this.sousyoku.get(idx).getName();
			else
				res += ","+this.sousyoku.get(idx).getName();
		return res;
	}
	/**
	 * ����̃����[�h���擾
	 * @return ����̃����[�h
	 */
	public Reload getReload(){
		return this.reload;
	}
	/**
	 * ����̔������擾
	 * @return ����̔���
	 */
	public Handou getHandou(){
		return this.handou;
	}
	/**
	 * ����̑��˂��擾
	 * @return ����̑���
	 */
	public String getSokusya(){
		if( this.super_sokusya == null)
			return "";
		return this.super_sokusya;
	}
	/**
	 * ����̒e�����擾
	 * @return ����̒e���
	 */
	public Gun getNrmGun(){
		return this.nrmgun;
	}
	/**
	 * ����̒e�����擾�i�����e�Ȃǁj
	 * @return ����̒e���i�����e�Ȃǁj
	 */
	public Gun getAttrGun(){
		return this.attrgun;
	}
	/**
	 * ����̒e�����擾�i�ُ푮���e�Ȃǁj
	 * @return ����̒e���i�ُ푮���e�Ȃǁj
	 */
	public Gun getSpGun(){
		return this.spgun;
	}
}
