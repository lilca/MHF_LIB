package jp.skd.lilca.mhf.lib.skill_value_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.skd.lilca.mhf.lib.bougu.Bougu;
import jp.skd.lilca.mhf.lib.bougu.Kafus;
import jp.skd.lilca.mhf.lib.buki.Buki;
import jp.skd.lilca.mhf.lib.tools.CsvStringToList;
import jp.skd.lilca.mhf.lib.skill_value_list.SkillInfoData;
import jp.skd.lilca.mhf.lib.skill_value_list.ResultBootSkill;

/**
 * �X�L���������l���������𓾂邽�߂̃N���X
 */
public class SkillValueList {
	/**
	 * �X�L���̃��X�g�i�����D�揇�ʏ��j
	 */
	public final static String[] skills = {
	"�Ў茕�Z",
	"�o���Z",
	"�匕�Z",
	"�����Z",
	"�ȋZ",
	"��J�Z",
	"���Z",
	"�e���Z",
	"�d�e�Z",
	"�y�e�Z",
	"�|�Z",
	"����",
	"��M",
	"�Ɍ�",
	"����",
	"����",
	"�ە�",
	"����",
	"�����t",
	"��C�T",
	"�x��",
	"������",
	"�{",
	"�S�r",
	"�u���[�_�[",
	"�t��",
	"�~��",
	"��l",
	"�ϐ�",
	"�Ϗ�Ԉُ�",
	"���p",
	"�Ζh��DOWN",
	"�������",
	"�i�C�t�g��",
	"�C�͉�",
	"�����U��",
	"����J��",
	"�����ݒu",
	"����",
	"���",
	"����",
	"�C��",
	"��",
	"�E�L",
	"�ϐ�",
	"�C�z",
	"�̗�",
	"�񕜑��x",
	"�a�ꖡ",
	"��",
	"�B�l",
	"�����t",
	"�K�[�h���\",
	"�����h��",
	"����",
	"���U",
	"�A��",
	"����",
	"�ʏ�e����",
	"�ђʒe����",
	"�U�e����",
	"�ʏ�e�ǉ�",
	"�ђʒe�ǉ�",
	"�U�e�ǉ�",
	"�֒e�ǉ�",
	"�g�U�e�ǉ�",
	"����U��",
	"���e����",
	"�͂�ւ�",
	"�H������V",
	"�U��",
	"�h��",
	"�R��",
	"���o�ی�",
	"���ݖ���",
	"�L��",
	"�^��",
	"�S�ϐ�UP",
	"�Αϐ�",
	"���ϐ�",
	"�X�ϐ�",
	"���ϐ�",
	"���ϐ�",
	"�Ϗ�",
	"�ϊ�",
	"����",
	"�n�}",
	"�̎�",
	"�������W",
	"�C�܂���",
	"�^�C",
	"�ނ�",
	"�痢��",
	"��",
	"����������",
	"�e����",
	"�B���p",
	"��𐫔\",
	"���",
	"���ʎ���",
	"�X�^�~�i",
	"���U��",
	"�����ˌ�",
	"�����X�^�[",
	"�H��",
	"�������",
	"�n�`",
	"�ϐk",
	"����",
	"���Ă�",
	"�C�p�t",
	"�J�������l",
	"�Ƃ񂸂�",
	"�̏p",
	"����",
	"�Ђ�߂�",
	"�󂯐g",
	"�J",
	"����",
	"�ߊl���",
	"�ŕr�ǉ�",
	"��ვr�ǉ�",
	"�����r�ǉ�",
	"�Α����U��",
	"�������U��",
	"�������U��",
	"�X�����U��",
	"�������U��",
	"�f�H",
	"������",
	"�ғŌ�",
	"��჌�",
	"������",
	"�Ή���",
	"������",
	"���_��",
	"�X����",
	"������",
	"���ߒZ�k",
	};
	/**
	 * �X�L�������N�A�b�v�̗L��
	 */
	private static HashMap<String, Boolean> rankMap = new HashMap<String, Boolean>(){
		private static final long serialVersionUID = 1L;
	{
		put(	"�Ў茕�Z",false);
		put(	"�o���Z",false);
		put(	"�匕�Z",false);
		put(	"�����Z",false);
		put(	"�ȋZ",false);
		put(	"��J�Z",false);
		put(	"���Z",false);
		put(	"�e���Z",false);
		put(	"�d�e�Z",false);
		put(	"�y�e�Z",false);
		put(	"�|�Z",false);
		put(	"����",false);
		put(	"��M",false);
		put(	"�Ɍ�",false);
		put(	"����",false);
		put(	"����",false);
		put(	"�ە�",false);
		put(	"����",false);
		put(	"�����t",false);
		put(	"��C�T",false);		
		put(	"�x��",false);
		put(	"������",false);
		put(	"�{",false);
		put(	"�S�r",false);
		put(	"�u���[�_�[",false);
		put(	"�t��",false);
		put(	"�~��",false);
		put(	"��l",false);
		put(	"�ϐ�",false);
		put(	"����",true);
		put(	"�����ݒu",true);
		put(	"����J��",false);
		put(	"�����U��",false);
		put(	"�C�͉�",true);
		put(	"�i�C�t�g��",true);
		put(	"�������",false);
		put(	"�Ζh��DOWN",false);
		put(	"���p",true);
		put(	"�Ϗ�Ԉُ�",true);
		put(	"���",true);
		put(	"����",true);
		put(	"�C��",true);
		put(	"��",true);
		put(	"�E�L",false);
		put(	"�ϐ�",false);
		put(	"�C�z",false);
		put(	"�̗�",true);
		put(	"�񕜑��x",true);
		put(	"�a�ꖡ",true);
		put(	"��",false);
		put(	"�B�l",true);
		put(	"�����t",true);
		put(	"�K�[�h���\",true);
		put(	"�����h��",false);
		put(	"����",false);
		put(	"���U",true);
		put(	"�A��",false);
		put(	"����",true);
		put(	"�ʏ�e����",false);
		put(	"�ђʒe����",false);
		put(	"�U�e����",false);
		put(	"�ʏ�e�ǉ�",false);
		put(	"�ђʒe�ǉ�",false);
		put(	"�U�e�ǉ�",false);
		put(	"�֒e�ǉ�",false);
		put(	"�g�U�e�ǉ�",false);
		put(	"����U��",false);
		put(	"���e����",false);
		put(	"�͂�ւ�",true);
		put(	"�H������V",false);
		put(	"�U��",true);
		put(	"�h��",true);
		put(	"�R��",true);
		put(	"���o�ی�",true);
		put(	"���ݖ���",false);
		put(	"�L��",true);
		put(	"�^��",false);
		put(	"�S�ϐ�UP",false);
		put(	"�Αϐ�",true);
		put(	"���ϐ�",true);
		put(	"�X�ϐ�",true);
		put(	"���ϐ�",true);
		put(	"���ϐ�",true);
		put(	"�Ϗ�",true);
		put(	"�ϊ�",true);
		put(	"����",true);
		put(	"�n�}",false);
		put(	"�̎�",true);
		put(	"�������W",false);
		put(	"�C�܂���",true);
		put(	"�^�C",true);
		put(	"�ނ�",false);
		put(	"�痢��",true);
		put(	"��",false);
		put(	"����������",true);
		put(	"�e����",false);
		put(	"�B���p",false);
		put(	"��𐫔\",true);
		put(	"���",false);
		put(	"���ʎ���",false);
		put(	"�X�^�~�i",true);
		put(	"���U��",false);
		put(	"�����ˌ�",true);
		put(	"�����X�^�[",false);
		put(	"�H��",false);
		put(	"�������",false);
		put(	"�n�`",true);
		put(	"�ϐk",true);
		put(	"����",true);
		put(	"���Ă�",true);
		put(	"�C�p�t",true);
		put(	"�J�������l",false);
		put(	"�Ƃ񂸂�",false);
		put(	"�̏p",true);
		put(	"����",true);
		put(	"�Ђ�߂�",false);
		put(	"�󂯐g",false);
		put(	"�J",false);
		put(	"����",true);
		put(	"�ߊl���",true);
		put(	"�ŕr�ǉ�",false);
		put(	"��ვr�ǉ�",false);
		put(	"�����r�ǉ�",false);
		put(	"�Α����U��",true);
		put(	"�������U��",true);
		put(	"�������U��",true);
		put(	"�X�����U��",true);
		put(	"�������U��",true);
		put(	"�f�H",false);
		put(	"������",true);
		put(	"�ғŌ�",true);
		put(	"��჌�",true);
		put(	"������",true);
		put(	"�Ή���",true);
		put(	"������",true);
		put(	"���_��",true);
		put(	"�X����",true);
		put(	"������",true);
		put(	"���ߒZ�k",true);
	}};
	/**
	 * �[���ˑ��̉��s�R�[�h
	 */
	private final static String BR1 = System.getProperty("line.separator");
	/**
	 * HTML���s�R�[�h
	 */
	private final static String BR2 = "<br>";
	/**
	 * ���s�f�[�^
	 */
	private static String BR;
	/**
	 * 
	 */
	private Map<String, Integer> values = new HashMap<String, Integer>();
	/**
	 * 
	 */
	private boolean mode;

	// ����
	Buki curBuki;
	// �X�L�����
	SkillInfoData skillInfo;
	// HC�h�
	private int countHC;
	// HS�h�
	private int countHS;
	// ����h�
	private int countGO;
	// �V���h�
	private int countTN;
	// �e��h�
	private int countHA;
	// SP�h�
	private int countSP;
	// G���h� add 2013/05/27
	private int countGK;
	// G�����h� add 2013/05/27
	private int countGS;
	// �����N�A�b�v
	private boolean rankUpFlag;

	/**
	 * �R���X�g���N�^
	 * @param srcbuki ������
	 * @param src �h����i�z��j
	 * @param srckafu �J�t���i���X�g�j
	 * @param info �i�X�L�����j
	 * @param htmlmode true=HTML���[�h,false=����ȊO
	 */
	public SkillValueList(Buki srcbuki, Bougu[] src, ArrayList<Kafus> srckafu, SkillInfoData info, boolean htmlmode){
		if(htmlmode)
			BR = BR2;
		else
			BR = BR1;
		this.curBuki = srcbuki;
		this.mode = htmlmode;
		this.skillInfo = info;
		// ����
		if(!srcbuki.isEmpty())
			if(!srcbuki.getSkillsWithSousyoku().equals("")){
				String[] tmpbuki = CsvStringToList.split(srcbuki.getSkillsWithSousyoku(), ":");
				for(int jdx=0; jdx<tmpbuki.length; jdx++){
					String key = Bougu.getSkillName(tmpbuki[jdx]);
					int val = Bougu.getSkillValue(tmpbuki[jdx]);
					Integer last = values.get(key);
					if(last == null)
						values.put(key, val);
					else
						values.put(key, val+last);
				}
			}
		// �h��
		for(int idx=0; idx<src.length; idx++){
			if(src[idx].isEmpty())
				continue;
			if(src[idx].getSkillsWithSousyoku(":").equals(""))
				continue;
			String[] tmp = CsvStringToList.split(src[idx].getSkillsWithSousyoku(":"), ":");
			for(int jdx=0; jdx<tmp.length; jdx++){
				String key = Bougu.getSkillName(tmp[jdx]);
				int val = Bougu.getSkillValue(tmp[jdx]);
				Integer last = values.get(key);
				if(last == null)
					values.put(key, val);
				else
					values.put(key, val+last);
			}
		}
		// �J�t
		for(int idx=0; idx<srckafu.size(); idx++){
			if(srckafu.get(idx).isEmpty())
				continue;
			if(srckafu.get(idx).getSkills().equals(""))
				continue;
			String[] tmp = CsvStringToList.split(srckafu.get(idx).getSkills(), ":");
			for(int jdx=0; jdx<tmp.length; jdx++){
				String key = Bougu.getSkillName(tmp[jdx]);
				int val = Bougu.getSkillValue(tmp[jdx]);
				Integer last = values.get(key);
				if(last == null)
					values.put(key, val);
				else
					values.put(key, val+last);
			}
		}
		// �h��^�C�v�̐����グ
		countHC = 0;
		countHS = 0;
		countGO = 0;
		countTN = 0;
		countHA = 0;
		countSP = 0;
		countGK	= 0;	// add 2013/05/27
		countGS	= 0;	// add 2013/05/27
		for(int idx=0; idx<src.length; idx++){
			if( src[idx].isSP() ) this.countSP++;
			else
			if( src[idx].isBouguType("�g�b") ) this.countHC++;
			else
			if( src[idx].isBouguType("���") ) this.countHS++;
			else
			if( src[idx].isBouguType("����") ) this.countGO++;
			else
			if( src[idx].isBouguType("�V��") ) this.countTN++;
			else
			if( src[idx].isBouguType("�e��") ) this.countHA++;
			else
			if( src[idx].isBouguType("�f��") ) this.countGK++;	// add 2013/05/27
			else
			if( src[idx].isBouguType("�f��") ) this.countGS++;	// add 2013/05/27
		}
		// �����N�A�b�v
		if( this.getRankUp() >= 0 )
			rankUpFlag = true;
		else
			rankUpFlag = false;
		return;
	}
	/**
	 * �w�肵�������𖄂߂�X�y�[�X���擾
	 * @param src ���̕�����
	 * @param a �w�肵������
	 * @return �X�y�[�X�Ŗ��߂�ꂽ������
	 */
	private String getSpace(String src, int a){
		String res = "";
		if(src.length() >= a)
			return res;
		for(int idx=0; idx<a-src.length(); idx++)
			res += "�@";
		return res;
	}
	/**
	 * �����X�L���̃��X�g���擾
	 * @return �����X�L���̃��X�g
	 */
	public ArrayList<String> getSkillList(){
		ArrayList<String> res = new ArrayList<String>();
		// modified 2013/05/27
		//int max = 10;
		int max = this.getMaxSkills();
		for(int idx=0; idx<skills.length; idx++){
			Integer tmp = this.values.get(skills[idx]);
			if(tmp != null){
				String name = this.skillInfo.getBootSkill(skills[idx], tmp, rankUpFlag).text;
				if(!name.equals("")){
					if(max>0){
						res.add(name);
					}
					max--;
				}
			}
		}
		return res;
	}
	/**
	 * �X�L���̃��X�g�i�\���p�j���擾
	 * @return �X�L���̃��X�g�i�\���p�j
	 */
	public String getValueList(){
		//
		// modified 2013/05/27
		//int max = 10;
		int max = this.getMaxSkills();
		ArrayList<String> noBoot = new ArrayList<String>();
		String res = "";
		for(int idx=0; idx<skills.length; idx++){
			Integer tmp = this.values.get(skills[idx]);
			if(tmp != null){
				ResultBootSkill r = this.skillInfo.getBootSkill(skills[idx], tmp, rankUpFlag);
				String name = r.text;
				if(name.equals(""))
					noBoot.add("�@" + skills[idx] + getSpace(skills[idx], 6) + "�F" + tmp + " " + BR);
				else{
					if(max>0){
						String ex = "";
						if(r.uped)
							ex = "(Up)";
						if(tmp>0)
							res += "�@" + skills[idx] + getSpace(skills[idx], 6) + "�F" + tmp + getBootFont("aqua", name) +ex+ BR;
						else
							res += "�@" + skills[idx] + getSpace(skills[idx], 6) + "�F" + tmp + getBootFont("red", name) +ex+ BR;
					}
					else
						res += "�@" + skills[idx] + getSpace(skills[idx], 6) + "�F" + tmp + " " + name + BR;						
					max--;
				}
			}
		}
		for(int idx=0; idx<noBoot.size(); idx++){
			res += noBoot.get(idx);
		}
		return res;
	}
	/**
	 * �������̕����F��HTML�ŉ��H
	 * @param colorStr �J���[�R�[�h
	 * @param element ���ɂȂ锭���X�L���̕�����
	 * @return �ҏW��̕�����
	 */
	private String getBootFont(String colorStr, String element){
		String res = "";
		if(mode)
			res = " <font color=\""+colorStr+"\">" + element + "</font>";
		else
			res = " " + element;
		return res;
	}
	/**
	 * �a�ꖡHTML�̎擾
	 * @return �a�ꖡHTML
	 */
	public String getBootKireajiHtml(){
		// �K���i�[�̂Ƃ�
		if( curBuki.isGunner() )
			return "";
		return curBuki.getKire().getHtml(this.isKireajiPlus1(), false);
	}
	/**
	 * �a�ꖡHTML�̎擾�i�g���Łj
	 * @param indent �C���f���g������
	 * @param ret ���s�R�[�h
	 * @return �a�ꖡHTML
	 */
	public String getBootKireajiHtmlEx(String indent, String ret){
		// �K���i�[�̂Ƃ�
		if( curBuki.isGunner() )
			return "";
		if( this.curBuki.isBukiType("HC") ){
			return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on (HC)"+ret;
		}
		if( this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
			if( this.countTN+this.countHA >= 2 ){
				return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on (���e�f)"+ret;
			}
		return "";
	}
	/**
	 * �a�ꖡ+1���ۂ�
	 * @return true=�a�ꖡ+1���������Ă���,false=����ȊO
	 */
	public boolean isKireajiPlus1(){
		String name = "��";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("�a�ꖡ���x��+1"))return true;
		}
		return false;
	}
	/**
	 * �h��́i�g���Łj�擾
	 * @return �h��́i�g���Łj
	 */
	public String getBootExDef(){
		String res = "";
		// SP����
		if( this.countSP >= 1 ){
			res += ",��(+100)";
		}
		// HS����
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += ",HC�e�f(+100)"; }break;
			case 4:{ res += ",HC�e�f(+80)"; }break;
			case 3:{ res += ",HC�e�f(+60)"; }break;
			case 2:{ res += ",HC�e�f(+40)"; }break;
			case 1:{ res += ",HC�e�f(+20)"; }break;
		};
		if( this.curBuki.isBukiType("�f��") )
		switch( this.countGS ){
			case 5:{ res += ",HC�e�f(+100)"; }break;
			case 4:{ res += ",HC�e�f(+80)"; }break;
			case 3:{ res += ",HC�e�f(+60)"; }break;
			case 2:{ res += ",HC�e�f(+40)"; }break;
			case 1:{ res += ",HC�e�f(+20)"; }break;
		};
		return res;
	}
	/**
	 * ��S���i�g���Łj�̎擾
	 * @return ��S���i�g���Łj
	 */
	public String getBootExKaishin(){
		String res = "";
		// SP����
		if( this.curBuki.isSP() ){
			res += ",��(+20)";
		}
		// HC����
		if( this.curBuki.isBukiType("�g�b") ){
			if(this.curBuki.isGunner())
				res += ",HC(+40)";
		}
		return res;
	}
	/**
	 * ����{�i�g���Łj���擾
	 * @return ����{�i�g���Łj
	 */
	public String getBootExBukibai(){
		String res = "";
		// SP����
		if( this.curBuki.isSP() )
			res += ",��(+10)";
		// ����{���A�b�v
		if( this.curBuki.isBukiType("����") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",���e�f(+80)"; }break;
			case 4:{ res += ",���e�f(+60)"; }break;
			case 3:{ res += ",���e�f(+45)"; }break;
			case 2:{ res += ",���e�f(+30)"; }break;
			case 1:{ res += ",���e�f(+15)"; }break;
		};
		// �f������{�A�b�v
		if( this.countGK >= 3 )
			res += ",�f(+30)";
		return res;
	}
	/**
	 * �U���́i�g���Łj���擾
	 * @return �U���́i�g���Łj
	 */
	public String getBootExAttack(){
		String res = "";
		Buki b = this.curBuki;
		// SP����
		if( this.curBuki.isSP() )
			res += ",��(+"+b.getBukiAttack(10)+")";
		// ����{���A�b�v
		if( this.curBuki.isBukiType("����") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",���e�f(+"+b.getBukiAttack(80)+")"; }break;
			case 4:{ res += ",���e�f(+"+b.getBukiAttack(60)+")"; }break;
			case 3:{ res += ",���e�f(+"+b.getBukiAttack(45)+")"; }break;
			case 2:{ res += ",���e�f(+"+b.getBukiAttack(30)+")"; }break;
			case 1:{ res += ",���e�f(+"+b.getBukiAttack(15)+")"; }break;
		};
		// �f������{�A�b�v
		if( this.countGK >= 3 )
			res += ",�f(+"+b.getBukiAttack(30)+")";
		return res;
	}
	/**
	 * �X�L�������N�A�b�v�̏�Ԃ��擾
	 * @param ret ���s�R�[�h
	 * @return �X�L�������N�A�b�v�̏��
	 */
	public String getRankUpCondition(String ret){
		int a = getRankUp();
		if( a == -1 )
			return "";
		if( a == 0 )
			return "�����N�A�b�v�����y�펞�z"+ret;
		return "�����N�A�b�v�����y�̗�"+a+"���ȏ�z"+ret;
	}
	/**
	 * �X�L���g������Ԃ��擾
	 * @param ret ���s�R�[�h
	 * @return �X�L���g�������
	 */
	public String getMaxSkillsCondition(String ret){
		int a = this.getMaxSkills();
		if( a == 10 )
			return "";
		return "�X�L���g�����y"+a+"�z"+ret;
	}
	/**
	 * �X�L���g�̎Z�o
	 * @return �X�L���g
	 */
	public int getMaxSkills(){
		if( this.countGK == 5 )
			return 12;
		else
		if( this.countGK >= 3 )
			return 11;
		return 10;
	}
	/**
	 * �X�L�������N�A�b�v�������擾
	 * @return �����N�A�b�v����
	 */
	public int getRankUp(){
		// �X�L�������N�A�b�v
		if( this.countHA < 1 )
		switch( this.countGO+this.countTN ){
			case 5:{ return 70; }
			case 4:{ return 76; }
			case 3:{ return 83; }
			case 2:{ return 90; }
			case 1:{ return 100; }
		};
		switch( this.countHA ){
			case 5:{ return 0; }
			case 4:{ return 0; }
			case 3:{ return 0; }
			case 2:{ return 34; }
			case 1:{ return 67; }
		};
		return -1;
	}
	/**
	 * ������ʃ��X�g�̎擾
	 * @param indent �C���f���g������
	 * @param ret ���s�R�[�h
	 * @return ������ʃ��X�g
	 */
	public String getBootSpecialEffects(String indent, String ret){
		String res = "";
		// SP����
		if( this.curBuki.isSP() ){
			res += indent+"����{+10 on ��"+ret;
			res += indent+"��S+20 on ��"+ret;
		}
		// HC����
		if( this.curBuki.isBukiType("�g�b") ){
			if(this.curBuki.isKenshi())
				res += indent+"�a�ꖡ�����NUP on (HC)"+ret;
			else
				res += indent+"��S+40 on (HC)"+ret;
		}
		// SP����
		if( this.countSP >= 1 ){
			res += indent+"�h��+100 on ��"+ret;
		}
		// ������
		switch( this.countHC + this.countHS + this.countGS ){
			case 5:{ res += indent+"������/1s then st.50 on HC"+ret; }break;
			case 4:{ res += indent+"������/1.5s then st.70 on HC"+ret; }break;
			case 3:{ res += indent+"������/2s then st.100 on HC"+ret; }break;
			case 2:{ res += indent+"������/4s then st.125 on HC"+ret; }break;
			case 1:{ res += indent+"������/8s then st.150 on HC"+ret; }break;
		};
		// �_���[�W��
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += indent+"�_���[�W30���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+100 on (HC�e�f)"+ret; }break;
			case 4:{ res += indent+"�_���[�W27���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+80 on (HC�e�f)"+ret; }break;
			case 3:{ res += indent+"�_���[�W24���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+60 on (HC�e�f)"+ret; }break;
			case 2:{ res += indent+"�_���[�W17���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+40 on (HC�e�f)"+ret; }break;
			case 1:{ res += indent+"�_���[�W10���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+20 on (HC�e�f)"+ret; }break;
		};
		if( this.curBuki.isBukiType("�f��") )
		switch( this.countGS ){
			case 5:{ res += indent+"�_���[�W30���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+100 on (HC�e�f)"+ret; }break;
			case 4:{ res += indent+"�_���[�W27���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+80 on (HC�e�f)"+ret; }break;
			case 3:{ res += indent+"�_���[�W24���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+60 on (HC�e�f)"+ret; }break;
			case 2:{ res += indent+"�_���[�W17���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+40 on (HC�e�f)"+ret; }break;
			case 1:{ res += indent+"�_���[�W10���� then SR100 on (HC�e�f)"+ret;
					 res += indent+"�h��+20 on (HC�e�f)"+ret; }break;
		};
		// �X�L�������N�A�b�v
		int ru = getRankUp();
		if( ru > 0 )
			res += indent+"�X�L�������NUP then hp"+ru+"��"+ret;
		else
		if( ru == 0 )
			res += indent+"�X�L�������NUP"+ret;
		// ����{���A�b�v
		if( this.curBuki.isBukiType("����") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"����{+80 on (���e�f)"+ret; }break;
			case 4:{ res += indent+"����{+60 on (���e�f)"+ret; }break;
			case 3:{ res += indent+"����{+45 on (���e�f)"+ret; }break;
			case 2:{ res += indent+"����{+30 on (���e�f)"+ret; }break;
			case 1:{ res += indent+"����{+15 on (���e�f)"+ret; }break;
		};
		// �����A�b�v
		if( this.curBuki.isBukiType("����") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"����10��UP on (���e�f)"+ret; }break;
			case 4:{ res += indent+"����8��UP on (���e�f)"+ret; }break;
			case 3:{ res += indent+"����6��UP on (���e�f)"+ret; }break;
			case 2:{ res += indent+"����4��UP on (���e�f)"+ret; }break;
			case 1:{ res += indent+"����2��UP on (���e�f)"+ret; }break;
		};
		// �a�ꖡ�F�A�b�v
		if( this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		if( this.countTN+this.countHA >= 2 ){
			if(this.curBuki.isKenshi())
				res += indent+"�a�ꖡ�����NUP on (���e�f)"+ret;
			else
				res += indent+"�N���e�B�J������ on (���e�f)"+ret;
		};
		// ���A�x�ɘa
		if( this.curBuki.isBukiType("����") || this.curBuki.isBukiType("�V��") || this.curBuki.isBukiType("�e��") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"���A�x�ɘa�T"+ret; }break;
			case 4:{ res += indent+"���A�x�ɘa�S"+ret; }break;
			case 3:{ res += indent+"���A�x�ɘa�R"+ret; }break;
			case 2:{ res += indent+"���A�x�ɘa�Q"+ret; }break;
			case 1:{ res += indent+"���A�x�ɘa�P"+ret; }break;
		};
		// �X�L���g����
		int ms = this.getMaxSkills();
		if( ms > 10 )
			res += indent+"�X�L���g��"+ms+ret;
		// G���h��R�ȏ�ŕ���{�A�b�v
		if( this.countGK >= 3 )
			res += indent+"����{+30 on �f"+ret;
		// �����Ȃ��Ƃ�
		if( res.equals("") )
			res = "�Ȃ�"+ret;
		return res;
	}
	/**
	 * �����X�L���l���ς݂̒e���
	 * @param indent �C���f���g������
	 * @return �����X�L���l���ς݂̒e���
	 */
	public String getBootTamaNrm(String indent){
		// �K���i�[�̂Ƃ�
		if( !curBuki.getType().equals("���C�g�{�E�K��") && !curBuki.getType().equals("�w�r�B�{�E�K��") )
			return "";
		return curBuki.getNrmGun().printNrm(this.isSoutensuUp(), indent);
	}
	/**
	 * �����X�L���l���ς݂̒e���i�����e�j
	 * @param indent �C���f���g������
	 * @return �����X�L���l���ς݂̒e���i�����e�j
	 */
	public String getBootTamaAttr(String indent){
		// �K���i�[�̂Ƃ�
		if( !curBuki.getType().equals("���C�g�{�E�K��") && !curBuki.getType().equals("�w�r�B�{�E�K��") )
			return "";
		return curBuki.getAttrGun().printAttr(this.isSoutensuUp(), indent);
	}
	/**
	 * �����X�L���l���ς݂̒e���i�����e2�j
	 * @param indent �C���f���g������
	 * @return �����X�L���l���ς݂̒e���i�����e2�j
	 */
	public String getBootTamaAttr2(String indent){
		// �K���i�[�̂Ƃ�
		if( !curBuki.getType().equals("���C�g�{�E�K��") && !curBuki.getType().equals("�w�r�B�{�E�K��") )
			return "";
		return curBuki.getAttrGun().printAttr2(this.isSoutensuUp(), indent);
	}
	public String getBootTamaSp(String indent){
		// �K���i�[�̂Ƃ�
		if( !curBuki.getType().equals("���C�g�{�E�K��") && !curBuki.getType().equals("�w�r�B�{�E�K��") )
			return "";
		return curBuki.getSpGun().printSp(this.isSoutensuUp(), indent);
	}
	/**
	 * �����X�L���l���ς݂̋|�̗��ߏ����擾
	 * @return �����X�L���l���ς݂̋|�̗��ߏ��
	 */
	public String getBootTame(){
		// �K���i�[�̂Ƃ�
		if( !curBuki.getType().equals("�|") )
			return "";
		return curBuki.getTame().print(this.isSoutensuUp());
	}
	/**
	 * ���U��UP���������Ă��邩�ۂ�
	 * @return true=���e�C����UP����,false=����ȊO
	 */
	public boolean isSoutensuUp(){
		String name = "���U��";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("���U��UP"))return true;
		}
		return false;
	}
	/**
	 * �����X�L���l���ς݂̃����[�h�����擾
	 * @return �����X�L���l���ς݂̃����[�h���
	 */
	public String getBootReload(){
		if( this.curBuki.getReload() == null )
			return "";
		String name = "���U";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("���U���x+3")){ boot = 3;}
				else
				if(tmp2.equals("���U���x+2")){ boot = 2;}
				else
				if(tmp2.equals("���U���x+1")){ boot = 1;}
				else
				if(tmp2.equals("���U���x-1")){ boot = -1;}
		}
		return this.curBuki.getReload().print(boot);
	}
	/**
	 * �����X�L���l���ς݂̔��������擾
	 * @return �����X�L���l���ς݂̔������
	 */
	public String getBootHandou(){
		if( this.curBuki.getHandou() == null )
			return "";
		String name = "����";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("�����y��+2")){ boot = 4;}
				else
				if(tmp2.equals("�����y��+1")){ boot = 2;}
		}
		return this.curBuki.getHandou().print(boot);
	}
	/**
	 * �����X�L���l���ς݂̉�S�����擾
	 * @return �����X�L���l���ς݂̉�S��
	 */
	public int getBootKaishin(){
		int res = 0;
		String name = "�B�l";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("���؂�+1"))res = 10;
				else
				if(tmp2.equals("���؂�+2"))res = 20;
				else
				if(tmp2.equals("���؂�+3"))res = 30;
				else
				if(tmp2.equals("���؂�+4"))res = 40;
				else
				if(tmp2.equals("���؂�+5"))res = 50;
			}
		}
		// ��M�ǉ� 2013/5/14
		name = "��M";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("��M+3"))res += 20;
				else
				if(tmp2.equals("��M+2"))res += 10;
				else
				if(tmp2.equals("��M+1"))res += 5;
			}
		}
		//--
		return res;
	}
	/**
	 * �����X�L���l���ς݂̖h��͂��擾
	 * @return �����X�L���l���ς݂̖h���
	 */
	public int getBootDefence(){
		int res = 0;
		String name = "�h��";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("�h��+120"))res = 120;
				else
				if(tmp2.equals("�h��+90"))res = 90;
				else
				if(tmp2.equals("�h��+60"))res = 60;
				else
				if(tmp2.equals("�h��+30"))res = 30;
				else
				if(tmp2.equals("�h��+20"))res = 20;
				else
				if(tmp2.equals("�h��-20"))res = -20;
				else
				if(tmp2.equals("�h��-30"))res = -30;
				else
				if(tmp2.equals("�h��-40"))res = -40;
			}
		}
		// �����͒ǉ� 2013/5/14
		name = "������";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("������+3"))res += 90;
				else
				if(tmp2.equals("������+2"))res += 45;
				else
				if(tmp2.equals("������+1"))res += 15;
				else
				if(tmp2.equals("������-1"))res += 0;
			}
		}
		//--
		return res;
	}
	/**
	 * �����X�L���l���ς݂̑ϐ������擾
	 * @param attr �w�肷��ϐ�
	 * @return �����X�L���l���ς݂̑ϐ����
	 */
	public int getBootTaisei(String attr){
		int res = 0;
		String name = "�S�ϐ�UP";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("�e�ϐ�+20"))res = 20;
				else
				if(tmp2.equals("�e�ϐ�+10"))res = 10;
				else
				if(tmp2.equals("�e�ϐ�+5"))res = 5;
				else
				if(tmp2.equals("�e�ϐ�-5"))res = -5;
				else
				if(tmp2.equals("�e�ϐ�-10"))res = -10;
				else
				if(tmp2.equals("�e�ϐ�-20"))res = -20;
			}
		}
		name = attr+"�ϐ�";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals(name+"+30"))res += 30;
				else
				if(tmp2.equals(name+"+20"))res += 20;
				else
				if(tmp2.equals(name+"+10"))res += 10;
				else
				if(tmp2.equals(name+"-10"))res += -10;
				else
				if(tmp2.equals(name+"-20"))res += -20;
				else
				if(tmp2.equals(name+"-30"))res += -30;
			}
		}
		return res;
	}
	/**
	 * �����X�L���l���ς݂̕���{�����擾
	 * @return �����X�L���l���ς݂̕���{���
	 */
	public int getBootKougekiWithAttack(){
		int res = 0;
		String name = "�U��";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("�U����UP�y���z")) res = 50;
				else
				if(tmp2.equals("�U����UP�y����z")) res = 30;
				else
				if(tmp2.equals("�U����UP�y��z")) res = 20;
				else
				if(tmp2.equals("�U����UP�y���z")) res = 10;
				else
				if(tmp2.equals("�U����UP�y���z")) res = 5;
			}
		}
		// �����ǉ� 2013/5/14
		int res1 = 0;
		name = "����";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("����+5")) res1 = 150;
				else
				if(tmp2.equals("����+4")) res1 = 80;
				else
				if(tmp2.equals("����+3")) res1 = 50;
				else
				if(tmp2.equals("����+2")) res1 = 35;
				else
				if(tmp2.equals("����+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return this.curBuki.calBairitsu(res1);
		//--
		return this.curBuki.calBairitsu(res);
	}
	/**
	 * �����X�L���l���ς݂̍U�������擾
	 * @return �����X�L���l���ς݂̍U�����
	 */
	public int getBootKougeki(){
		int res = 0;
		String name = "�U��";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("�U����UP�y���z")) res = 50;
				else
				if(tmp2.equals("�U����UP�y����z")) res = 30;
				else
				if(tmp2.equals("�U����UP�y��z")) res = 20;
				else
				if(tmp2.equals("�U����UP�y���z")) res = 10;
				else
				if(tmp2.equals("�U����UP�y���z")) res = 5;
			}
		}
		// �����ǉ� 2013/5/14
		int res1 = 0;
		name = "����";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("����+5")) res1 = 150;
				else
				if(tmp2.equals("����+4")) res1 = 80;
				else
				if(tmp2.equals("����+3")) res1 = 50;
				else
				if(tmp2.equals("����+2")) res1 = 35;
				else
				if(tmp2.equals("����+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return res1;
		//--
		return res;
	}
	/**
	 * �����X�L���������N�A�b�v�\���ۂ�
	 * @param name �����X�L��
	 * @return true=�����N�A�b�v�\,false=����ȊO
	 */
	public static boolean isRankUpable(String name){
		return rankMap.get(name);
	}
	/**
	 * ���������X�L���̃��X�g���擾
	 * @return ���������X�L���̃��X�g
	 */
	public ArrayList<String> getBootedList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src		= this.getValueList();
		String[] list	= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]	= list[idx].replaceAll("�@", "");
			String[] list2	= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") )
				res.add(list2[1]);
		}
		return res;
	}
	/**
	 * �X�L�����X�g���擾
	 * @return �X�L�����X�g
	 */
	public ArrayList<String> getBootedSkillList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src				= this.getValueList();
		String[] list			= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]			= list[idx].replaceAll("�@", "");
			String[] list2		= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") ){
				String[] list3	= CsvStringToList.split(list2[0], "�F");
				res.add(list3[0]);
			}
		}
		return res;
	}
}
