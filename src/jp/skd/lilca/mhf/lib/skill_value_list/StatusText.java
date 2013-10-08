package jp.skd.lilca.mhf.lib.skill_value_list;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Bougu;
import jp.skd.lilca.mhf.lib.savedata.SavedData;
import jp.skd.lilca.mhf.lib.skill_value_list.SkillInfoData;
import jp.skd.lilca.mhf.lib.skill_value_list.SkillValueList;

/**
 * �����f�[�^�̏���\���p�ɕҏW���郁�\�b�h���W�߂��N���X
 */
public class StatusText {
	private final static String LR = System.getProperty("line.separator");
	private final static String BR = "<br>";
    // �^�O��
	private static String h1s;
	private static String h2s;
	private static String he;
	private static String ret;
	private static boolean htm;
	
	/**
	 * �����f�[�^�̑S�X�e�[�^�X���擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @param sep ���s������
	 * @return �����f�[�^�̑S�X�e�[�^�X
	 */
	public static String getStatusText(SkillInfoData skillInfo, SavedData mem, String sep){
    	h1s = "";
    	h2s = "";
    	he = "";
		ret = sep;
		htm = false;
		return getStatusText(skillInfo, mem);
	}
	/**
	 * �����f�[�^�̑S�X�e�[�^�X���擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @param html true=HTML�����Ĉ���,false=�ʏ�̃e�L�X�g�f�[�^�Ƃ��Ĉ���
	 * @return �����f�[�^�̑S�X�e�[�^�X
	 */
	public static String getStatusText(SkillInfoData skillInfo, SavedData mem, boolean html){
		setHtmlInfo(html);
		return getStatusText(skillInfo, mem);
	}
	/**
	 * �F����s��HTML�Ƃ��邩�ۂ�
	 * @param html true=HTML,false=����ȊO
	 */
	private static void setHtmlInfo(boolean html){
	    if(html){
	    	h1s = "<font color=\"lime\">";
	    	h2s = "<font color=\"yellow\">";
	    	he = "</font>";
	    	ret = BR;
			htm = true;
	    }
	    else{
	    	h1s = "";
	    	h2s = "";
	    	he = "";
	    	ret = LR;
			htm = false;
	    }
	    return;
	}
	/**
	 * �X�L���֘A���̎擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @return �X�L���֘A���
	 */
	public static ArrayList<String> getSkillList(SkillInfoData skillInfo, SavedData mem){
		Bougu[] list = new Bougu[5];
		list[0] = mem.getAtama();
		list[1] = mem.getDou();
		list[2] = mem.getUde();
		list[3] = mem.getKoshi();
		list[4] = mem.getAshi();
        SkillValueList a = new SkillValueList(mem.getBuki(), list, mem.getKafus(), skillInfo, htm);
		return a.getSkillList();
	}
	/**
	 * �����f�[�^�̑S�X�e�[�^�X���擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @return �����f�[�^�̑S�X�e�[�^�X
	 */
	public static String getStatusText(SkillInfoData skillInfo, SavedData mem){
		String res = "";
		Bougu[] list = new Bougu[5];
		list[0] = mem.getAtama();
		list[1] = mem.getDou();
		list[2] = mem.getUde();
		list[3] = mem.getKoshi();
		list[4] = mem.getAshi();
        SkillValueList a = new SkillValueList(mem.getBuki(), list, mem.getKafus(), skillInfo, htm);
        //
      	res =
      		h1s+"�y"+mem.getTitle()+"�z"+he+ret+
        	"��ʁF"+mem.getBuki().getTypeString()+ret+
        	"���ʁF"+mem.getGender()+"��"+ret+
        	"�아�F"+mem.getGofuTsumeString()+ret+
        	h2s+"�y�����z"+he+ret+
        	"����F"+mem.getBuki().getName()+" ("+mem.getBuki().getTamaNames(",")+")"+ret+
        	"���@�F"+mem.getAtama().getName()+" ("+mem.getAtama().getTamaNames(",")+")"+ret+
        	"���@�F"+mem.getDou().getName()+" ("+mem.getDou().getTamaNames(",")+")"+ret+
        	"�r�@�F"+mem.getUde().getName()+" ("+mem.getUde().getTamaNames(",")+")"+ret+
        	"���@�F"+mem.getKoshi().getName()+" ("+mem.getKoshi().getTamaNames(",")+")"+ret+
        	"�r�@�F"+mem.getAshi().getName()+" ("+mem.getAshi().getTamaNames(",")+")"+ret+
        	"�J�t�F"+mem.getKafuNames(", ")+ret+
        	"�󂫁F"+(mem.getBuki().getEmptySlots()+
        		mem.getAtama().getEmptySlots()+
        		mem.getDou().getEmptySlots()+
        		mem.getUde().getEmptySlots()+
        		mem.getKoshi().getEmptySlots()+
        		mem.getAshi().getEmptySlots())+
        		ret+
        	h2s+"�y������ʁz"+he+ret+
        	a.getBootSpecialEffects("�@", ret)+
        	h2s+"�y������z"+he+ret+
        	getBukiInfo(skillInfo, mem, a, htm)+
        	h2s+"�y�U���n�z"+he+ret+
        	getAttackInfo(skillInfo, mem, a, htm)+
        	h2s+"�y�h��n�z"+he+ret+
        	getDefenceInfo(skillInfo, mem, a, htm)+
        	h2s+"�y�X�L���z"+he+ret+
        	a.getRankUpCondition(ret)+
        	a.getMaxSkillsCondition(ret)+
       		a.getValueList()+
       		"-Powered by ���������H-";
		return res;
	}
	/**
	 * �����ɂ��h��͂��擾
	 * @param m �����f�[�^
	 * @return �����ɂ��h���
	 */
	private static int getTotalDef(SavedData m){
		Bougu[] list = new Bougu[5];
		list[0] = m.getAtama();
		list[1] = m.getDou();
		list[2] = m.getUde();
		list[3] = m.getKoshi();
		list[4] = m.getAshi();
		int res = 0;
		for(int idx=0; idx<list.length; idx++)
			res += list[idx].getDef();
		// ����̕�
		res += m.getBuki().getDef();
		return res;
	}
	/**
	 * �����ɂ��ϐ����擾
	 * @param list �h����
	 * @param key �w�肷��ϐ�
	 * @return �����ɂ��ϐ������
	 */
	private static int getTotalTaisei(Bougu[] list, String key){
		int res = 0;
		for(int idx=0; idx<list.length; idx++)
			if(key.equals("��"))
				res += list[idx].getFire();
			else
			if(key.equals("��"))
				res += list[idx].getMizu();
			else
			if(key.equals("��"))
				res += list[idx].getThunder();
			else
			if(key.equals("�X"))
				res += list[idx].getKori();
			else
			if(key.equals("��"))
				res += list[idx].getRyu();
		return res;
	}
	/**
	 * �����I�Ȗh��͎擾
	 * @param skillInfo �X�L�����
	 * @param m �����f�[�^
	 * @return �����I�Ȗh���
	 */
	public static int getDefence(SkillInfoData skillInfo, SavedData m){
		Bougu[] list = new Bougu[5];
		list[0] = m.getAtama();
		list[1] = m.getDou();
		list[2] = m.getUde();
		list[3] = m.getKoshi();
		list[4] = m.getAshi();
        SkillValueList a = new SkillValueList(m.getBuki(), list, m.getKafus(), skillInfo, htm);
    	return getTotalDef(m)+m.getGofuTsumeDefence()+a.getBootDefence();
	}
	/**
	 * �����I�ȕ���{�擾
	 * @param skillInfo �X�L�����
	 * @param data �����f�[�^
	 * @return �����I�ȕ���{
	 */
	public static int getAllAtk(SkillInfoData skillInfo, SavedData data){
		Bougu[] list = new Bougu[5];
		list[0] = data.getAtama();
		list[1] = data.getDou();
		list[2] = data.getUde();
		list[3] = data.getKoshi();
		list[4] = data.getAshi();
        SkillValueList boot = new SkillValueList(data.getBuki(), list, data.getKafus(), skillInfo, false);
 		return data.getBuki().getAttack(data.getGofuTsumePower())+boot.getBootKougekiWithAttack();
	}
	/**
	 * �����I�Ȗh��͎擾
	 * @param skillInfo �X�L�����
	 * @param data �����f�[�^
	 * @return �����I�Ȗh���
	 */
	public static int getAllDef(SkillInfoData skillInfo, SavedData data){
		Bougu[] list = new Bougu[5];
		list[0] = data.getAtama();
		list[1] = data.getDou();
		list[2] = data.getUde();
		list[3] = data.getKoshi();
		list[4] = data.getAshi();
        SkillValueList boot = new SkillValueList(data.getBuki(), list, data.getKafus(), skillInfo, false);
 		return getTotalDef(data)+data.getGofuTsumeDefence()+boot.getBootDefence();
	}
	/**
	 * �e�ϐ��̏����擾
	 * @param skillInfo �X�L�����
	 * @param data �����f�[�^
	 * @param sep1
	 * @param sep2
	 * @return �e�ϐ��̏��
	 */
	public static String getAllTaiseiString(SkillInfoData skillInfo, SavedData data, String sep1, String sep2){
		Bougu[] list = new Bougu[5];
		list[0] = data.getAtama();
		list[1] = data.getDou();
		list[2] = data.getUde();
		list[3] = data.getKoshi();
		list[4] = data.getAshi();
        SkillValueList boot = new SkillValueList(data.getBuki(), list, data.getKafus(), skillInfo, false);
		String res =
			"��"+sep1+(getTotalTaisei(list, "��")+boot.getBootTaisei("��"))+sep2+
			"��"+sep1+(getTotalTaisei(list, "��")+boot.getBootTaisei("��"))+sep2+
			"��"+sep1+(getTotalTaisei(list, "��")+boot.getBootTaisei("��"))+sep2+
			"�X"+sep1+(getTotalTaisei(list, "�X")+boot.getBootTaisei("�X"))+sep2+
			"��"+sep1+(getTotalTaisei(list, "��")+boot.getBootTaisei("��"));
		return res;
	}
	/**
	 * ����֘A�̏����擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @param a �����X�L�����
	 * @param html true=HTML,false=����ȊO
	 * @return ����֘A�̏��
	 */
	public static String getBukiInfo(SkillInfoData skillInfo, SavedData mem, SkillValueList a, boolean html){
		setHtmlInfo(html);
        // �a�ꖡ
        String kireaji = a.getBootKireajiHtml();
        if( kireaji != "" ) kireaji = "�a���F"+kireaji+ret;
        String kireajiEx = a.getBootKireajiHtmlEx("�@�@�@", ret);
        // ���F
        String neiro = mem.getBuki().getNeiro().printHtml();
        if( neiro != "" ) neiro = "���F�F"+neiro+ret;
        // �C��
        String hougeki = mem.getBuki().getHougeki().print();
        if( hougeki != "" ) hougeki = "�C���F"+hougeki+ret;
        // �����[�h
        String reload = a.getBootReload();
        if( reload != "" ) reload = "�����F"+reload+ret;
        // ����
        String handou = a.getBootHandou();
        if( handou != "" ) handou = "�����F"+handou+ret;
        // ����
        String sokusya = "";
        if( mem.getBuki().getType().equals("���C�g�{�E�K��")){
        	sokusya = mem.getBuki().getSokusya();
        	if( mem.getBuki().isBukiType("����") || mem.getBuki().isBukiType("�V��") || mem.getBuki().isBukiType("�e��"))
        		sokusya = "�����F"+sokusya+ret;
        	else
        		sokusya = "���ˁF"+sokusya+ret;
        }
        // �r�M
        String hainetsu = "";
        if( mem.getBuki().getType().equals("�w�r�B�{�E�K��")){
        	if( mem.getBuki().isBukiType("����") || mem.getBuki().isBukiType("�V��") || mem.getBuki().isBukiType("�e��"))
        		hainetsu = "�r�M�F��"+ret;
        	else
        		hainetsu = "�r�M�F�s��"+ret;
        }
        // �r��
        String bin = mem.getBuki().getBin().printHtml();
        if( bin != "" ) bin = "�r���F"+bin+ret;
        // ����
        String tame = a.getBootTame();
        if( tame != "" ) tame = "���߁F"+tame+ret;
        // �e
        String nrmTama = a.getBootTamaNrm("�@");
        if( nrmTama != "" ) nrmTama = "�e�@�F<br>"+nrmTama+ret;
        // �����e
        String attrTama = a.getBootTamaAttr("�@");
        if( attrTama != "" ) attrTama = attrTama+ret;
        // �����e2
        String attrTama2 = a.getBootTamaAttr2("�@");
        if( attrTama2 != "" ) attrTama2 = attrTama2+ret;
        // SP�e
        String spTama = a.getBootTamaSp("�@");
        if( spTama != "" ) spTama = spTama+ret;
		String res = 
    	kireaji+
    	kireajiEx+
    	neiro+
    	hougeki+
    	reload+
    	handou+
    	nrmTama+
    	attrTama+
    	attrTama2+
    	spTama+
    	sokusya+
    	hainetsu+
    	bin+
    	tame;
		return res;
	}
	/**
	 * �U���n�̏����擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @param a �����X�L�����
	 * @param html true=HTML,false=����ȊO
	 * @return �U���n�̏����擾
	 */
	public static String getAttackInfo(SkillInfoData skillInfo, SavedData mem, SkillValueList a, boolean html){
		String res = "";
		setHtmlInfo(html);
    	res += "�U���F"+(mem.getBuki().getAttack(mem.getGofuTsumePower())+a.getBootKougekiWithAttack())+a.getBootExAttack()+ret+
    	"���{�F"+(((int)mem.getBuki().getBukiBairitsu()+mem.getGofuTsumePower()+(int)a.getBootKougeki()))+a.getBootExBukibai()+ret+
    	"��S�F"+(mem.getBuki().getKaishin()+a.getBootKaishin())+a.getBootExKaishin()+ret;
		return res;
	}
	/**
	 * �h��n�̏����擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @param a �����X�L�����
	 * @param html true=HTML,false=����ȊO
	 * @return �h��n�̏��
	 */
	public static String getDefenceInfo(SkillInfoData skillInfo, SavedData mem, SkillValueList a, boolean html){
		String res = "";
		setHtmlInfo(html);
		Bougu[] list = new Bougu[5];
		list[0] = mem.getAtama();
		list[1] = mem.getDou();
		list[2] = mem.getUde();
		list[3] = mem.getKoshi();
		list[4] = mem.getAshi();
    	res += "�h��F"+(getTotalDef(mem)+mem.getGofuTsumeDefence()+a.getBootDefence())+a.getBootExDef()+ret+
    	"�ϐ��F"+ret+
    	"�@�΁@"+(getTotalTaisei(list, "��")+a.getBootTaisei("��"))+ret+
    	"�@���@"+(getTotalTaisei(list, "��")+a.getBootTaisei("��"))+ret+
    	"�@���@"+(getTotalTaisei(list, "��")+a.getBootTaisei("��"))+ret+
    	"�@�X�@"+(getTotalTaisei(list, "�X")+a.getBootTaisei("�X"))+ret+
    	"�@���@"+(getTotalTaisei(list, "��")+a.getBootTaisei("��"))+ret;
		return res;
	}
	/**
	 * �����f�[�^�̃T�}�������擾
	 * @param skillInfo �X�L�����
	 * @param mem �����f�[�^
	 * @return �����f�[�^�̃T�}�����
	 */
	public static String getSoubiSummaryLine(SkillInfoData skillInfo, SavedData mem){
		String res = "";
		res += 
		"�U: "+getAllAtk(skillInfo.getData(), mem)+"  "+
		"�h: "+getAllDef(skillInfo.getData(), mem)+"  "+
		getAllTaiseiString(skillInfo.getData(), mem, ":", ",");
		return res;
	}
}
