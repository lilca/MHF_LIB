package jp.skd.lilca.mhf.lib.skill_value_list;

import java.util.ArrayList;

import jp.skd.lilca.mhf.lib.bougu.Bougu;
import jp.skd.lilca.mhf.lib.savedata.SavedData;
import jp.skd.lilca.mhf.lib.skill_value_list.SkillInfoData;
import jp.skd.lilca.mhf.lib.skill_value_list.SkillValueList;

/**
 * 装備データの情報を表示用に編集するメソッドを集めたクラス
 */
public class StatusText {
	private final static String LR = System.getProperty("line.separator");
	private final static String BR = "<br>";
    // タグ等
	private static String h1s;
	private static String h2s;
	private static String he;
	private static String ret;
	private static boolean htm;
	
	/**
	 * 装備データの全ステータスを取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @param sep 改行文字列
	 * @return 装備データの全ステータス
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
	 * 装備データの全ステータスを取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @param html true=HTMLをして扱う,false=通常のテキストデータとして扱う
	 * @return 装備データの全ステータス
	 */
	public static String getStatusText(SkillInfoData skillInfo, SavedData mem, boolean html){
		setHtmlInfo(html);
		return getStatusText(skillInfo, mem);
	}
	/**
	 * 色や改行をHTMLとするか否か
	 * @param html true=HTML,false=それ以外
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
	 * スキル関連情報の取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @return スキル関連情報
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
	 * 装備データの全ステータスを取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @return 装備データの全ステータス
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
      		h1s+"【"+mem.getTitle()+"】"+he+ret+
        	"種別："+mem.getBuki().getTypeString()+ret+
        	"性別："+mem.getGender()+"性"+ret+
        	"護符："+mem.getGofuTsumeString()+ret+
        	h2s+"【装備】"+he+ret+
        	"武器："+mem.getBuki().getName()+" ("+mem.getBuki().getTamaNames(",")+")"+ret+
        	"頭　："+mem.getAtama().getName()+" ("+mem.getAtama().getTamaNames(",")+")"+ret+
        	"胴　："+mem.getDou().getName()+" ("+mem.getDou().getTamaNames(",")+")"+ret+
        	"腕　："+mem.getUde().getName()+" ("+mem.getUde().getTamaNames(",")+")"+ret+
        	"腰　："+mem.getKoshi().getName()+" ("+mem.getKoshi().getTamaNames(",")+")"+ret+
        	"脚　："+mem.getAshi().getName()+" ("+mem.getAshi().getTamaNames(",")+")"+ret+
        	"カフ："+mem.getKafuNames(", ")+ret+
        	"空き："+(mem.getBuki().getEmptySlots()+
        		mem.getAtama().getEmptySlots()+
        		mem.getDou().getEmptySlots()+
        		mem.getUde().getEmptySlots()+
        		mem.getKoshi().getEmptySlots()+
        		mem.getAshi().getEmptySlots())+
        		ret+
        	h2s+"【特殊効果】"+he+ret+
        	a.getBootSpecialEffects("　", ret)+
        	h2s+"【武器情報】"+he+ret+
        	getBukiInfo(skillInfo, mem, a, htm)+
        	h2s+"【攻撃系】"+he+ret+
        	getAttackInfo(skillInfo, mem, a, htm)+
        	h2s+"【防御系】"+he+ret+
        	getDefenceInfo(skillInfo, mem, a, htm)+
        	h2s+"【スキル】"+he+ret+
        	a.getRankUpCondition(ret)+
        	a.getMaxSkillsCondition(ret)+
       		a.getValueList()+
       		"-Powered by 装備無問題？-";
		return res;
	}
	/**
	 * 装備による防御力を取得
	 * @param m 装備データ
	 * @return 装備による防御力
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
		// 武器の分
		res += m.getBuki().getDef();
		return res;
	}
	/**
	 * 装備による耐性情報取得
	 * @param list 防具情報
	 * @param key 指定する耐性
	 * @return 装備による耐性情報情報
	 */
	private static int getTotalTaisei(Bougu[] list, String key){
		int res = 0;
		for(int idx=0; idx<list.length; idx++)
			if(key.equals("火"))
				res += list[idx].getFire();
			else
			if(key.equals("水"))
				res += list[idx].getMizu();
			else
			if(key.equals("雷"))
				res += list[idx].getThunder();
			else
			if(key.equals("氷"))
				res += list[idx].getKori();
			else
			if(key.equals("龍"))
				res += list[idx].getRyu();
		return res;
	}
	/**
	 * 総合的な防御力取得
	 * @param skillInfo スキル情報
	 * @param m 装備データ
	 * @return 総合的な防御力
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
	 * 総合的な武器倍取得
	 * @param skillInfo スキル情報
	 * @param data 装備データ
	 * @return 総合的な武器倍
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
	 * 総合的な防御力取得
	 * @param skillInfo スキル情報
	 * @param data 装備データ
	 * @return 総合的な防御力
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
	 * 各耐性の情報を取得
	 * @param skillInfo スキル情報
	 * @param data 装備データ
	 * @param sep1
	 * @param sep2
	 * @return 各耐性の情報
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
			"火"+sep1+(getTotalTaisei(list, "火")+boot.getBootTaisei("火"))+sep2+
			"水"+sep1+(getTotalTaisei(list, "水")+boot.getBootTaisei("水"))+sep2+
			"雷"+sep1+(getTotalTaisei(list, "雷")+boot.getBootTaisei("雷"))+sep2+
			"氷"+sep1+(getTotalTaisei(list, "氷")+boot.getBootTaisei("氷"))+sep2+
			"龍"+sep1+(getTotalTaisei(list, "龍")+boot.getBootTaisei("龍"));
		return res;
	}
	/**
	 * 武器関連の情報を取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @param a 発動スキル情報
	 * @param html true=HTML,false=それ以外
	 * @return 武器関連の情報
	 */
	public static String getBukiInfo(SkillInfoData skillInfo, SavedData mem, SkillValueList a, boolean html){
		setHtmlInfo(html);
        // 斬れ味
        String kireaji = a.getBootKireajiHtml();
        if( kireaji != "" ) kireaji = "斬味："+kireaji+ret;
        String kireajiEx = a.getBootKireajiHtmlEx("　　　", ret);
        // 音色
        String neiro = mem.getBuki().getNeiro().printHtml();
        if( neiro != "" ) neiro = "音色："+neiro+ret;
        // 砲撃
        String hougeki = mem.getBuki().getHougeki().print();
        if( hougeki != "" ) hougeki = "砲撃："+hougeki+ret;
        // リロード
        String reload = a.getBootReload();
        if( reload != "" ) reload = "リロ："+reload+ret;
        // 反動
        String handou = a.getBootHandou();
        if( handou != "" ) handou = "反動："+handou+ret;
        // 速射
        String sokusya = "";
        if( mem.getBuki().getType().equals("ライトボウガン")){
        	sokusya = mem.getBuki().getSokusya();
        	if( mem.getBuki().isBukiType("剛種") || mem.getBuki().isBukiType("天嵐") || mem.getBuki().isBukiType("覇種"))
        		sokusya = "超速："+sokusya+ret;
        	else
        		sokusya = "速射："+sokusya+ret;
        }
        // 排熱
        String hainetsu = "";
        if( mem.getBuki().getType().equals("ヘビィボウガン")){
        	if( mem.getBuki().isBukiType("剛種") || mem.getBuki().isBukiType("天嵐") || mem.getBuki().isBukiType("覇種"))
        		hainetsu = "排熱：可"+ret;
        	else
        		hainetsu = "排熱：不可"+ret;
        }
        // ビン
        String bin = mem.getBuki().getBin().printHtml();
        if( bin != "" ) bin = "ビン："+bin+ret;
        // 溜め
        String tame = a.getBootTame();
        if( tame != "" ) tame = "溜め："+tame+ret;
        // 弾
        String nrmTama = a.getBootTamaNrm("　");
        if( nrmTama != "" ) nrmTama = "弾　：<br>"+nrmTama+ret;
        // 属性弾
        String attrTama = a.getBootTamaAttr("　");
        if( attrTama != "" ) attrTama = attrTama+ret;
        // 属性弾2
        String attrTama2 = a.getBootTamaAttr2("　");
        if( attrTama2 != "" ) attrTama2 = attrTama2+ret;
        // SP弾
        String spTama = a.getBootTamaSp("　");
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
	 * 攻撃系の情報を取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @param a 発動スキル情報
	 * @param html true=HTML,false=それ以外
	 * @return 攻撃系の情報を取得
	 */
	public static String getAttackInfo(SkillInfoData skillInfo, SavedData mem, SkillValueList a, boolean html){
		String res = "";
		setHtmlInfo(html);
    	res += "攻撃："+(mem.getBuki().getAttack(mem.getGofuTsumePower())+a.getBootKougekiWithAttack())+a.getBootExAttack()+ret+
    	"武倍："+(((int)mem.getBuki().getBukiBairitsu()+mem.getGofuTsumePower()+(int)a.getBootKougeki()))+a.getBootExBukibai()+ret+
    	"会心："+(mem.getBuki().getKaishin()+a.getBootKaishin())+a.getBootExKaishin()+ret;
		return res;
	}
	/**
	 * 防御系の情報を取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @param a 発動スキル情報
	 * @param html true=HTML,false=それ以外
	 * @return 防御系の情報
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
    	res += "防御："+(getTotalDef(mem)+mem.getGofuTsumeDefence()+a.getBootDefence())+a.getBootExDef()+ret+
    	"耐性："+ret+
    	"　火　"+(getTotalTaisei(list, "火")+a.getBootTaisei("火"))+ret+
    	"　水　"+(getTotalTaisei(list, "水")+a.getBootTaisei("水"))+ret+
    	"　雷　"+(getTotalTaisei(list, "雷")+a.getBootTaisei("雷"))+ret+
    	"　氷　"+(getTotalTaisei(list, "氷")+a.getBootTaisei("氷"))+ret+
    	"　龍　"+(getTotalTaisei(list, "龍")+a.getBootTaisei("龍"))+ret;
		return res;
	}
	/**
	 * 装備データのサマリ情報を取得
	 * @param skillInfo スキル情報
	 * @param mem 装備データ
	 * @return 装備データのサマリ情報
	 */
	public static String getSoubiSummaryLine(SkillInfoData skillInfo, SavedData mem){
		String res = "";
		res += 
		"攻: "+getAllAtk(skillInfo.getData(), mem)+"  "+
		"防: "+getAllDef(skillInfo.getData(), mem)+"  "+
		getAllTaiseiString(skillInfo.getData(), mem, ":", ",");
		return res;
	}
}
