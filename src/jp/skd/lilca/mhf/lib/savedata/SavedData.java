package jp.skd.lilca.mhf.lib.savedata;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Bougu;
import jp.skd.lilca.mhf.lib.bougu.Kafus;
import jp.skd.lilca.mhf.lib.bougu.Sousyoku;
import jp.skd.lilca.mhf.lib.buki.Buki;
import jp.skd.lilca.mhf.lib.skill_gain.SkillVector;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

//import android.app.Activity;

/**
 * �����f�[�^�𒊏ۉ������N���X
 * �f�[�^�𒼐ڕҏW����u�������̈�v�ƃf�[�^�ۑ��p�́u�����񃊃X�g�v�̓�d�\���ɂȂ��Ă���
 */
public class SavedData {
	/**
	 * �����񃊃X�g�̃T�C�Y
	 */
	public static final int DATA_SIZE		= 29;
	/**
	 * �����񃊃X�g�̕�����̃C���f�b�N�X
	 */
	public static final int ID_BUKI			= 0;
	/**
	 * �����񃊃X�g�̕���ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_BUKI_TAMA_1	= 1;
	/**
	 * �����񃊃X�g�̕���ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_BUKI_TAMA_2	= 2;
	/**
	 * �����񃊃X�g�̕���ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_BUKI_TAMA_3	= 3;
	/**
	 * �����񃊃X�g�̓��h����̃C���f�b�N�X
	 */
	public static final int ID_ATAMA		= 4;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_ATAMA_TAMA_1	= 5;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_ATAMA_TAMA_2	= 6;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_ATAMA_TAMA_3	= 7;
	/**
	 * �����񃊃X�g�̓��h����̃C���f�b�N�X
	 */
	public static final int ID_DOU			= 8;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_DOU_TAMA_1	= 9;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_DOU_TAMA_2	= 10;
	/**
	 * �����񃊃X�g�̓��h��ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_DOU_TAMA_3	= 11;
	/**
	 * �����񃊃X�g�̘r�h����̃C���f�b�N�X
	 */
	public static final int ID_UDE			= 12;
	/**
	 * �����񃊃X�g�̘r�h��ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_UDE_TAMA_1	= 13;
	/**
	 * �����񃊃X�g�̘r�h��ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_UDE_TAMA_2	= 14;
	/**
	 * �����񃊃X�g�̘r�h��ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_UDE_TAMA_3	= 15;
	/**
	 * �����񃊃X�g�̍��h����̃C���f�b�N�X
	 */
	public static final int ID_KOSHI		= 16;
	/**
	 * �����񃊃X�g�̍��h��ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_KOSHI_TAMA_1	= 17;
	/**
	 * �����񃊃X�g�̍��h��ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_KOSHI_TAMA_2	= 18;
	/**
	 * �����񃊃X�g�̍��h��ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_KOSHI_TAMA_3	= 19;
	/**
	 * �����񃊃X�g�̋r�h����̃C���f�b�N�X
	 */
	public static final int ID_ASHI			= 20;
	/**
	 * �����񃊃X�g�̋r�h��ɂ��Ă鑕���i(1)���̃C���f�b�N�X
	 */
	public static final int ID_ASHI_TAMA_1	= 21;
	/**
	 * �����񃊃X�g�̋r�h��ɂ��Ă鑕���i(2)���̃C���f�b�N�X
	 */
	public static final int ID_ASHI_TAMA_2	= 22;
	/**
	 * �����񃊃X�g�̋r�h��ɂ��Ă鑕���i(3)���̃C���f�b�N�X
	 */
	public static final int ID_ASHI_TAMA_3	= 23;
	/**
	 * �����񃊃X�g�̗v���X�L���̃C���f�b�N�X
	 */
	public static final int ID_REQ_SKILLS	= 24;
	/**
	 * �����񃊃X�g�̃J�t(1)���̃C���f�b�N�X
	 */
	public static final int ID_KAFU_TAMA_1	= 25;
	/**
	 * �����񃊃X�g�̃J�t(2)���̃C���f�b�N�X
	 */
	public static final int ID_KAFU_TAMA_2	= 26;
	/**
	 * �����񃊃X�g�̊g�����̃C���f�b�N�X
	 */
	public static final int ID_EXINFO		= 27;
	/**
	 * �����񃊃X�g�̃^�C�g���̃C���f�b�N�X
	 */
	public static final int ID_TITLE		= 28;
	// EX_INFO�̃t�B�[���hID
	/**
	 * �g���f�[�^���̐��ʏ��̃C���f�b�N�X
	 */
	public static final int ID_EX_GENDER	= 0;	// �j or ��
	/**
	 * �g���f�[�^���̐��ʏ��̃C���f�b�N�X
	 */
	public static final int ID_EX_RANK		= 1;	// HR, SR1, SR5, SR100 etc.
	/**
	 * �g���f�[�^���̌아���̃C���f�b�N�X
	 */
	public static final int ID_EX_GOFU		= 2;	// NNFF = �͂̌아ON,�͂̒�ON,���̌아OFF,���̒�OFF

	/**
	 * �����f�[�^�ő����ł���J�t�̍ő吔
	 */
	public static final int KAFUS_SIZE		= 2;

	private static final int[] bouguId = {ID_ATAMA,ID_DOU,ID_UDE,ID_KOSHI,ID_ASHI};

	/**
	 * �v���O������ł̕ۑ��̈�
	 */
	private String title;
	private String gender;
	private String rank;
	private String gofu;
	private Buki buki;
	private Bougu[] bougu;
	private ArrayList<Kafus> kafus;
	private String[] reqSkills;
	/**
	 * Csv�`���ł̕ۑ��̈�
	 */
	private String[] elements = new String[DATA_SIZE];
	//

	/**
	 * �R���X�g���N�^
	 */
	public SavedData(){
		this.init();
		this.toMemory();
		return;
	}
	/**
	 * �����񃊃X�g�̏�����
	 */
	public void init(){
		for(int idx=0; idx<DATA_SIZE; idx++)
			this.elements[idx] = "";
		return;
	}
	/**
	 * �����f�[�^�̏������i�u�������̈�v�A�u�����񃊃X�g�v�Ƃ��Ɂj
	 */
	public void clearSoubi(){
		this.toCsv();
		String buffer1 = this.elements[ID_REQ_SKILLS];
		String buffer2 = this.elements[ID_EXINFO];
		String buffer3 = this.elements[ID_TITLE];
		String buffer4 = this.elements[ID_BUKI];
		String buffer5 = this.elements[ID_BUKI_TAMA_1];
		String buffer6 = this.elements[ID_BUKI_TAMA_2];
		String buffer7 = this.elements[ID_BUKI_TAMA_3];
		this.init();
		this.elements[ID_REQ_SKILLS] = buffer1;
		this.elements[ID_EXINFO] = buffer2;
		this.elements[ID_TITLE] = buffer3;
		this.elements[ID_BUKI] = buffer4;
		this.elements[ID_BUKI_TAMA_1] = buffer5;
		this.elements[ID_BUKI_TAMA_2] = buffer6;
		this.elements[ID_BUKI_TAMA_3] = buffer7;
		this.toMemory();
		return;
	}
	/**
	 * �����񃊃X�g�̓��e���������̈�֔��f�i�㏑���j
	 */
	public void toMemory(){
		this.title	= this.elements[ID_TITLE];
		this.buki	= new Buki(
				this.elements[ID_BUKI],
				this.elements[ID_BUKI_TAMA_1],
				this.elements[ID_BUKI_TAMA_2],
				this.elements[ID_BUKI_TAMA_3]);
		this.bougu	= new Bougu[5];
		this.bougu[0] = new Bougu(
				this.elements[ID_ATAMA],
				this.elements[ID_ATAMA_TAMA_1],
				this.elements[ID_ATAMA_TAMA_2],
				this.elements[ID_ATAMA_TAMA_3]);
		this.bougu[1] = new Bougu(
				this.elements[ID_DOU],
				this.elements[ID_DOU_TAMA_1],
				this.elements[ID_DOU_TAMA_2],
				this.elements[ID_DOU_TAMA_3]);
		this.bougu[2] = new Bougu(
				this.elements[ID_UDE],
				this.elements[ID_UDE_TAMA_1],
				this.elements[ID_UDE_TAMA_2],
				this.elements[ID_UDE_TAMA_3]);
		this.bougu[3] = new Bougu(
				this.elements[ID_KOSHI],
				this.elements[ID_KOSHI_TAMA_1],
				this.elements[ID_KOSHI_TAMA_2],
				this.elements[ID_KOSHI_TAMA_3]);
		this.bougu[4] = new Bougu(
				this.elements[ID_ASHI],
				this.elements[ID_ASHI_TAMA_1],
				this.elements[ID_ASHI_TAMA_2],
				this.elements[ID_ASHI_TAMA_3]);
		this.kafus = new ArrayList<Kafus>();
		for(int idx=0; idx<KAFUS_SIZE; idx++){
			String temp = this.elements[ID_KAFU_TAMA_1+idx];
			if(!temp.equals(""))
				this.kafus.add(new Kafus(this.elements[ID_KAFU_TAMA_1+idx]));
		}
		// �G�L�X�g�����
		String temp = this.elements[ID_EXINFO];
		this.gender	= getExInfo(temp, ID_EX_GENDER);
		this.rank	= getExInfo(temp, ID_EX_RANK);
		this.gofu	= getExInfo(temp, ID_EX_GOFU);
		// �K�v�X�L�����
		if(this.elements[ID_REQ_SKILLS].equals("")){
			this.reqSkills = null;
		}
		else{
			this.reqSkills = CsvStringToList.split(this.elements[ID_REQ_SKILLS], ",");
		}
		return;
	}
	/**
	 * ������`���̊g�������̎w�肵���C���f�b�N�X�̏����擾
	 * @param data ������`���̊g�����
	 * @param id �w��C���f�b�N�X
	 * @return �w�肵�����
	 */
	private String getExInfo(String data, int id){
		String [] res = CsvStringToList.split(data, ",");
		if(id == ID_EX_GENDER){
			if(!res[0].equals(""))
				return res[0];
			else
				return "�j";
		}
		if(id == ID_EX_RANK){
			if(res.length >= 2)
				return res[1];
			else
				return "HR";
		}
		if(id == ID_EX_GOFU){
			if(res.length >= 3)
				if(res[2].equals(""))
					return "FFFF";
				else
					return res[2];
			else
				return "FFFF";
		}		
		return "";
	}
	/**
	 * �������̈�̊g�����𕶎���ɕϊ�
	 * @return ������`���̊g�����
	 */
	private String getExInfoString(){
		String res = "";
		res += this.gender;
		res += "," + this.rank;
		res += "," + this.gofu;
		return res;
	}
	/**
	 * �������̈�̓��e�𕶎��񃊃X�g�ɔ��f�i�㏑���j
	 */
	public void toCsv(){
		this.init();
		this.elements[ID_TITLE] = this.title;
		ArrayList<Sousyoku> list;
		this.elements[ID_BUKI]			= this.getBuki().getCsvString();
		list = this.getBuki().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_BUKI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// ��
		this.elements[ID_ATAMA]			= this.getAtama().getCsvString();
		list = this.getAtama().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_ATAMA_TAMA_1+idx]	= list.get(idx).getCsvString();
		// ��
		this.elements[ID_DOU]			= this.getDou().getCsvString();
		list = this.getDou().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_DOU_TAMA_1+idx]	= list.get(idx).getCsvString();
		// �r
		this.elements[ID_UDE]			= this.getUde().getCsvString();
		list = this.getUde().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_UDE_TAMA_1+idx]	= list.get(idx).getCsvString();
		// ��
		this.elements[ID_KOSHI]			= this.getKoshi().getCsvString();
		list = this.getKoshi().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_KOSHI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// �r
		this.elements[ID_ASHI]			= this.getAshi().getCsvString();
		list = this.getAshi().getSousyokuList();
		for(int idx=0; idx<list.size(); idx++)
			this.elements[ID_ASHI_TAMA_1+idx]	= list.get(idx).getCsvString();
		// �J�t
		this.elements[ID_KAFU_TAMA_1] = "";
		this.elements[ID_KAFU_TAMA_2] = "";
		for(int idx=0; idx<this.kafus.size(); idx++)
			this.elements[ID_KAFU_TAMA_1+idx] = this.kafus.get(idx).getCsvString();
		// �G�L�X�g�����
		this.elements[ID_EXINFO] = getExInfoString();
		// �K�v�X�L�����
		if(this.reqSkills == null)
			this.elements[ID_REQ_SKILLS] = "";
		else{
			this.elements[ID_REQ_SKILLS] = CsvStringToList.scat(this.reqSkills, ",");
		}
		return;
	}
	/**
	 * �^�C�g�����擾
	 * @return �^�C�g��
	 */
	public String getTitle(){
		if(this.title == null)
			return "<�^�C�g���Ȃ�>";
		if(this.title.equals(""))
			return "<�^�C�g���Ȃ�>";
		if(this.title.equals("null"))
			return "<�^�C�g���Ȃ�>";
		return this.title;
	}
	/**
	 * ���ʂ��擾
	 * @return ����
	 */
	public String getGender(){
		return this.gender;
	}
	/**
	 * ���ʂ��j������
	 * @return true=�j��,false=����
	 */
	public boolean isMale(){
		if(this.gender.equals("�j"))
			return true;
		return false;
	}
	/**
	 * ���ʂ�ݒ�
	 * @param gen ����
	 */
	public void setGender(String gen){
		this.gender = gen;
		return;
	}
	/**
	 * �U���n�아�̕���{���擾
	 * @return ����{
	 */
	public int getGofuTsumePower(){
		int res = 0;
		if(this.isPwrGofu())
			res += 5;
		if(this.isPwrTsume())
			res += 9;
		return res;
	}
	/**
	 * �h��n�아�̖h��͂��擾
	 * @return �h���
	 */
	public int getGofuTsumeDefence(){
		int res = 0;
		if(this.isDefGofu())
			res += 16;
		if(this.isDefTsume())
			res += 24;
		return res;
	}
	/**
	 * �아���̕\���p��������擾
	 * @return �\���p�̌아���
	 */
	public String getGofuTsumeString(){
		String res = "";
		if(isPwrGofu())
			res += "�͂̌아, ";
		if(isPwrTsume())
			res += "�͂̒�, ";
		if(isDefGofu())
			res += "���̌아, ";
		if(isDefTsume())
			res += "���̒�, ";
		if(res.equals(""))
			return "�Ȃ�";
		return res.substring(0, res.length()-2);
	}
	/**
	 * �v���X�L�����擾
	 * @return �v���X�L��
	 */
	public String[] getReqSkills(){
		return this.reqSkills;
	}
	/**
	 * �v���X�L�����w�肵�����s������ŋ�؂�����������擾
	 * @param lr ���s������
	 * @return �v���X�L���i���s�ς݁j
	 */
	public String getReqSkillsWithReturn(String lr){
		if( this.reqSkills == null )
			return "";
		String res = "";
		for(int idx=0; idx<this.reqSkills.length; idx++)
			res += lr+this.reqSkills[idx];
		return res.substring(lr.length());
	}
	/**
	 * �v���X�L�����̎w�肵���C���f�b�N�X�̃X�L�������擾
	 * @param a �w��C���f�b�N�X
	 * @return �X�L�����
	 */
	public String getReqSkill(int a){
		if( this.reqSkills == null )
			return null;
		if( a >= this.reqSkills.length )
			return null;
		return this.reqSkills[a];
	}
	/**
	 * �v���X�L���̃X�L�������擾
	 * @return �v���X�L���̃X�L����
	 */
	public int getReqSkillSize(){
		if(this.reqSkills == null)
			return 0;
		return this.reqSkills.length;
	}
	/**
	 * �아�����i�[
	 * @param pg �͂̌아�̗L��
	 * @param pt �͂̒܂̗L��
	 * @param dg ���̌아�̗L��
	 * @param dt ���̒܂̗L��
	 */
	public void setGofuTsume(boolean pg, boolean pt, boolean dg, boolean dt){
		String val = "";
		if(pg) val += "T"; else val += "F";
		if(pt) val += "T"; else val += "F";
		if(dg) val += "T"; else val += "F";
		if(dt) val += "T"; else val += "F";
		this.gofu = val;
		return;
	}
	/**
	 * �v���X�L�����i�[
	 * @param req �v���X�L���i�z��j
	 */
	public void setReqSkills(String[] req){
		this.reqSkills = req;
		return;
	}
	/**
	 * �͂̌아�����邩�ۂ�
	 * @return true=����,false=�Ȃ�
	 */
	public boolean isPwrGofu(){
		if(this.gofu.substring(0, 1).equals("T"))
			return true;
		return false;
	}
	/**
	 * �͂̒܂����邩�ۂ�
	 * @return true=����,false=�Ȃ�
	 */
	public boolean isPwrTsume(){
		if(this.gofu.substring(1, 2).equals("T"))
			return true;
		return false;
	}
	/**
	 * ���̌아�����邩�ۂ�
	 * @return true=����,false=�Ȃ�
	 */
	public boolean isDefGofu(){
		if(this.gofu.substring(2, 3).equals("T"))
			return true;
		return false;
	}
	/**
	 * ���̒܂����邩�ۂ�
	 * @return true=����,false=�Ȃ�
	 */
	public boolean isDefTsume(){
		if(this.gofu.substring(3, 4).equals("T"))
			return true;
		return false;
	}
	/**
	 * ���m���ۂ�
	 * @return true=���m,false=���m�łȂ�
	 */
	public boolean isKenshi(){
		return this.buki.isKenshi();
	}
	/**
	 * �K���i�[���ۂ�
	 * @return true=�K���i�[,false=�K���i�[�łȂ�
	 */
	public boolean isGunner(){
		return this.buki.isGunner();
	}
	/**
	 * ��������擾
	 * @return ������
	 */
	public Buki getBuki(){
		return this.buki;
	}
	/**
	 * ���h������擾
	 * @return ���h����
	 */
	public Bougu getAtama(){
		return this.bougu[0];
	}
	/**
	 * ���h������擾
	 * @return ���h����
	 */
	public Bougu getDou(){
		return this.bougu[1];
	}
	/**
	 * �r�h������擾
	 * @return �r�h����
	 */
	public Bougu getUde(){
		return this.bougu[2];
	}
	/**
	 * ���h������擾
	 * @return ���h����
	 */
	public Bougu getKoshi(){
		return this.bougu[3];
	}
	/**
	 * �r�h������擾
	 * @return �r�h����
	 */
	public Bougu getAshi(){
		return this.bougu[4];
	}
	/**
	 * �w�肵�����ʂ̖h������擾
	 * @param bui �w�蕔��
	 * @return �h����
	 */
	public Bougu getBougu(String bui){
		if(bui.equals("��"))
			return this.bougu[0];
		else
		if(bui.equals("��"))
			return this.bougu[1];
		else
		if(bui.equals("�r"))
			return this.bougu[2];
		else
		if(bui.equals("��"))
			return this.bougu[3];
		else
		if(bui.equals("�r"))
			return this.bougu[4];
		return null;
	}
	/**
	 * �J�t�����擾
	 * @return �J�t��񃊃X�g
	 */
	public ArrayList<Kafus> getKafus(){
		return this.kafus;
	}
	/**
	 * �^�C�g�����i�[
	 * @param t �^�C�g��
	 */
	public void setTitle(String t){
		this.title = t;
		return;
	}
	/**
	 * ��������i�[
	 * @param s ������
	 */
	public void setBuki(Buki s){
		this.buki = s;
		this.elements[ID_BUKI] = s.getCsvString();
		return;
	}
	/**
	 * ���h������i�[
	 * @param s ���h����
	 */
	public void setAtama(Bougu s){
		this.bougu[0] = s;
		this.elements[ID_ATAMA] = s.getCsvString();
		return;
	}
	/**
	 * ���h������i�[
	 * @param s ���h����
	 */
	public void setDou(Bougu s){
		this.bougu[1] = s;
		this.elements[ID_DOU] = s.getCsvString();
		return;
	}
	/**
	 * �r�h������i�[
	 * @param s �r�h����
	 */
	public void setUde(Bougu s){
		this.bougu[2] = s;
		this.elements[ID_UDE] = s.getCsvString();
		return;
	}
	/**
	 * ���h������i�[
	 * @param s ���h����
	 */
	public void setKoshi(Bougu s){
		this.bougu[3] = s;
		this.elements[ID_KOSHI] = s.getCsvString();
		return;
	}
	/**
	 * �r�h������i�[
	 * @param s �r�h����
	 */
	public void setAshi(Bougu s){
		this.bougu[4] = s;
		this.elements[ID_ASHI] = s.getCsvString();
		return;
	}
	/**
	 * �J�t�̋󂫃X���b�g�����擾
	 * @return �J�t�̋󂫃X���b�g��
	 */
	public int getEmptyKafusSlots(){
		int res = KAFUS_SIZE;
		for(int idx=0; idx<this.kafus.size(); idx++)
			res -= this.kafus.get(idx).getSlotCost();
		return res;
	}
	/**
	 * �J�t�̖��O���w�肵����؂蕶����ŕҏW���ĕϊ�
	 * @param seq ��؂蕶����
	 * @return �J�t�̖��O
	 */
	public String getKafuNames(String seq){
		String res = "";
		for(int idx=0; idx<this.kafus.size(); idx++)
			if(idx==0)
				res += this.kafus.get(idx).getName();
			else
				res += seq+this.kafus.get(idx).getName();
		return res;
	}
	/**
	 * ���mor�K���i�[����A�K�����Ȃ��h����O��
	 */
	public void ifNotTakeoff(){
		for(int idx=0; idx<bougu.length; idx++){
			this.bougu[idx].ifNotTakeoff(this.buki.isKenshi());
			this.elements[bouguId[idx]] = this.bougu[idx].getCsvString();
		}
		return;
	}
	/**
	 * ���ʂ���A�K�����Ȃ��h����O��
	 */
	public void ifNotTakeoffSexually(){
		for(int idx=0; idx<bougu.length; idx++){
			this.bougu[idx].ifNotTakeoffSexually(this.isMale());
			this.elements[bouguId[idx]] = this.bougu[idx].getCsvString();
		}
		return;
	}
	/**
	 * �����񃊃X�g�𕶎���ɕϊ����Ď擾
	 * @return ������`���̑����f�[�^
	 */
	public String getAllElementsToString(){
		return CsvStringToList.scat(this.elements, "<enter>");
	}
	/**
	 * ������`���̑����f�[�^���A�����񃊃X�g�Ɋi�[
	 * @param src ������`���̑����f�[�^
	 */
	public void setAllElementsToString(String src){
		String[] list = CsvStringToList.split(src, "<enter>");
		for(int idx=0; idx<list.length && idx<DATA_SIZE; idx++)
			this.setElement(idx, list[idx]);
		this.toMemory();
		return;
	}
	/**
	 * �����񃊃X�g�̎w�肵���C���f�b�N�Ɋi�[
	 * @param id �w��C���f�b�N�X
	 * @param in �i�[���镶����
	 */
	public void setElement(int id, String in){
		this.elements[id] = in;
		return;
	}
	/**
	 * �����񃊃X�g�̎w�肵���C���f�b�N�X�̕�������擾
	 * @param id �w��C���f�b�N�X
	 * @return �擾���镶����
	 */
	public String getElement(int id){
		return this.elements[id];
	}
	/**
	 * �����f�[�^�̑S�̂̃X�L���x�N�g�����擾
	 * @return �����f�[�^�̑S�̂̃X�L���x�N�g��
	 */
	public SkillVector getTotalSkillVector(){
		SkillVector res = new SkillVector();
		for(int idx=0; idx<this.bougu.length; idx++){
			res = res.add(this.bougu[idx].getSkillVectorWithSousyoku());
		}
		res = res.add(this.buki.getSkillVectorWithSousyoku());
		for(int idx=0; idx<this.kafus.size(); idx++)
			res = res.add(this.kafus.get(idx).getSkillVector());
		return res;
	}
	/**
	 * ���������ւ�
	 * @param s �V���Ɋi�[���镐����
	 */
	public void replaceBuki(Buki s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getBuki().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setBuki(s);
		return;
	}
	/**
	 * ���h�������ւ�
	 * @param s �V���Ɋi�[���铪�h����
	 */
	public void replaceAtama(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getAtama().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setAtama(s);
		return;
	}
	/**
	 * ���h�������ւ�
	 * @param s �V���Ɋi�[���铷�h����
	 */
	public void replaceDou(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getDou().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setDou(s);
		return;
	}
	/**
	 * �r�h�������ւ�
	 * @param s �V���Ɋi�[����r�h����
	 */
	public void replaceUde(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getUde().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setUde(s);
		return;
	}
	/**
	 * ���h�������ւ�
	 * @param s �V���Ɋi�[���鍘�h����
	 */
	public void replaceKoshi(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getKoshi().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setKoshi(s);
		return;
	}
	/**
	 * �r�h�������ւ�
	 * @param s �V���Ɋi�[����r�h����
	 */
	public void replaceAshi(Bougu s){
		s.getSousyokuList().clear();
		ArrayList<Sousyoku> tempList =  this.getAshi().getSousyokuList();
		for(int idx=0; idx<tempList.size(); idx++)
			s.addSousyoku(tempList.get(idx));
		this.setAshi(s);
		return;
	}
	// 29AUG13 add
	/**
	 * �w�肵���X�L����v���X�L�����珜�O
	 * @param name ���O����X�L���̖��O
	 */
	public void removeReqSkill(String name){
		ArrayList<String> res = new ArrayList<String>();
		for(int idx=0; idx<this.reqSkills.length; idx++){
			// �Y���ȊO�i�Y���́j
			if( !name.equals(this.reqSkills[idx]) ){
				res.add(reqSkills[idx]);
			}
		}
		this.reqSkills = (String[])res.toArray(new String[0]);
		return;
	}
	/**
	 * �v���X�L������ǉ�
	 * @param name �ǉ�����X�L��
	 */
	public void addReqSkill(String name){
		ArrayList<String> res = new ArrayList<String>();
		for(int idx=0; idx<this.reqSkills.length; idx++){
			res.add(reqSkills[idx]);
		}
		res.add(name);
		this.reqSkills = (String[])res.toArray(new String[0]);
		return;
	}
}
