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
 * ƒXƒLƒ‹”­“®‚ğl—¶‚µ‚½î•ñ‚ğ“¾‚é‚½‚ß‚ÌƒNƒ‰ƒX
 */
public class SkillValueList {
	/**
	 * ƒXƒLƒ‹‚ÌƒŠƒXƒgi”­“®—Dæ‡ˆÊ‡j
	 */
	public final static String[] skills = {
	"•ĞèŒ•‹Z",
	"‘oŒ•‹Z",
	"‘åŒ•‹Z",
	"‘¾“‹Z",
	"’È‹Z",
	"ë—Â“J‹Z",
	"‘„‹Z",
	"e‘„‹Z",
	"de‹Z",
	"Œye‹Z",
	"‹|‹Z",
	"„Œ‚",
	"ˆê‘M",
	"’ÉŒ‚",
	"‘¬Ë",
	"”½Ë",
	"ŒÛ•‘",
	"‘•’…",
	"’²‡t",
	"ˆê•C˜T",
	"Œx‰ú",
	"¶–½—Í",
	"“{",
	"“S˜r",
	"ƒuƒŠ[ƒ_[",
	"‹t‹«",
	"‹~‰‡",
	"ël",
	"‘ÏŒ",
	"‘Ïó‘ÔˆÙí",
	"Œ•p",
	"‘Î–hŒäDOWN",
	"‚¢‚½‚í‚è",
	"ƒiƒCƒtg‚¢",
	"‹C—Í‰ñ•œ",
	"‘®«UŒ‚",
	"•ŠíJ‚«",
	"‚‘¬İ’u",
	"ª«",
	"–ƒáƒ",
	"‡–°",
	"‹Câ",
	"“Å",
	"’EL",
	"‘Ïá",
	"‹C”z",
	"‘Ì—Í",
	"‰ñ•œ‘¬“x",
	"a‚ê–¡",
	" ",
	"’Bl",
	"Œ¤‚¬t",
	"ƒK[ƒh«”\",
	"©“®–hŒä",
	"“Š±",
	"‘•“U",
	"˜AË",
	"”½“®",
	"’Êí’e‹­‰»",
	"ŠÑ’Ê’e‹­‰»",
	"U’e‹­‰»",
	"’Êí’e’Ç‰Á",
	"ŠÑ’Ê’e’Ç‰Á",
	"U’e’Ç‰Á",
	"Ö’e’Ç‰Á",
	"ŠgU’e’Ç‰Á",
	"“ÁêUŒ‚",
	"”š’e‹­‰»",
	"‚Í‚ç‚Ö‚è",
	"H‚¢‚µ‚ñ–V",
	"UŒ‚",
	"–hŒä",
	"R”»",
	"’®Šo•ÛŒì",
	"“‚İ–³Œø",
	"Lˆæ",
	"‰^”À",
	"‘S‘Ï«UP",
	"‰Î‘Ï«",
	"…‘Ï«",
	"•X‘Ï«",
	"—‹‘Ï«",
	"—´‘Ï«",
	"‘Ï‹",
	"‘ÏŠ¦",
	"•—ˆ³",
	"’n}",
	"Ìæ",
	"‚‘¬ûW",
	"‹C‚Ü‚®‚ê",
	"‰^‹C",
	"’Ş‚è",
	"ç—¢Šá",
	"‰ñ•œ",
	"’²‡¬Œ÷—¦",
	"’e’²‡",
	"˜B‹àp",
	"‰ñ”ğ«”\",
	"’ê—Í",
	"Œø‰Ê‘±",
	"ƒXƒ^ƒ~ƒi",
	"‘•“U”",
	"¸–§ËŒ‚",
	"ƒ‚ƒ“ƒXƒ^[",
	"H–",
	"”‚¬æ‚è",
	"’nŒ`",
	"‘Ïk",
	"º‘Ñ",
	"“÷Ä‚«",
	"–Cpt",
	"“J‚«–¼l",
	"‚Æ‚ñ‚¸‚ç",
	"‘Ìp",
	"‹­Œ¨",
	"‚Ğ‚ç‚ß‚«",
	"ó‚¯g",
	"ãJ",
	"ˆ³—Í",
	"•ßŠlãè",
	"“Å•r’Ç‰Á",
	"–ƒáƒ•r’Ç‰Á",
	"‡–°•r’Ç‰Á",
	"‰Î‘®«UŒ‚",
	"…‘®«UŒ‚",
	"—‹‘®«UŒ‚",
	"•X‘®«UŒ‚",
	"—´‘®«UŒ‚",
	"’fH",
	"”šŒ‚Œ•",
	"–Ò“ÅŒ•",
	"–ƒáƒŒ•",
	"‡–°Œ•",
	"‰Î‰ŠŒ•",
	"…ŒƒŒ•",
	"—‹_Œ•",
	"•XŒ‹Œ•",
	"—´‰¤Œ•",
	"—­‚ß’Zk",
	};
	/**
	 * ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒv‚Ì—L–³
	 */
	private static HashMap<String, Boolean> rankMap = new HashMap<String, Boolean>(){
		private static final long serialVersionUID = 1L;
	{
		put(	"•ĞèŒ•‹Z",false);
		put(	"‘oŒ•‹Z",false);
		put(	"‘åŒ•‹Z",false);
		put(	"‘¾“‹Z",false);
		put(	"’È‹Z",false);
		put(	"ë—Â“J‹Z",false);
		put(	"‘„‹Z",false);
		put(	"e‘„‹Z",false);
		put(	"de‹Z",false);
		put(	"Œye‹Z",false);
		put(	"‹|‹Z",false);
		put(	"„Œ‚",false);
		put(	"ˆê‘M",false);
		put(	"’ÉŒ‚",false);
		put(	"‘¬Ë",false);
		put(	"”½Ë",false);
		put(	"ŒÛ•‘",false);
		put(	"‘•’…",false);
		put(	"’²‡t",false);
		put(	"ˆê•C˜T",false);		
		put(	"Œx‰ú",false);
		put(	"¶–½—Í",false);
		put(	"“{",false);
		put(	"“S˜r",false);
		put(	"ƒuƒŠ[ƒ_[",false);
		put(	"‹t‹«",false);
		put(	"‹~‰‡",false);
		put(	"ël",false);
		put(	"‘ÏŒ",false);
		put(	"ª«",true);
		put(	"‚‘¬İ’u",true);
		put(	"•ŠíJ‚«",false);
		put(	"‘®«UŒ‚",false);
		put(	"‹C—Í‰ñ•œ",true);
		put(	"ƒiƒCƒtg‚¢",true);
		put(	"‚¢‚½‚í‚è",false);
		put(	"‘Î–hŒäDOWN",false);
		put(	"Œ•p",true);
		put(	"‘Ïó‘ÔˆÙí",true);
		put(	"–ƒáƒ",true);
		put(	"‡–°",true);
		put(	"‹Câ",true);
		put(	"“Å",true);
		put(	"’EL",false);
		put(	"‘Ïá",false);
		put(	"‹C”z",false);
		put(	"‘Ì—Í",true);
		put(	"‰ñ•œ‘¬“x",true);
		put(	"a‚ê–¡",true);
		put(	" ",false);
		put(	"’Bl",true);
		put(	"Œ¤‚¬t",true);
		put(	"ƒK[ƒh«”\",true);
		put(	"©“®–hŒä",false);
		put(	"“Š±",false);
		put(	"‘•“U",true);
		put(	"˜AË",false);
		put(	"”½“®",true);
		put(	"’Êí’e‹­‰»",false);
		put(	"ŠÑ’Ê’e‹­‰»",false);
		put(	"U’e‹­‰»",false);
		put(	"’Êí’e’Ç‰Á",false);
		put(	"ŠÑ’Ê’e’Ç‰Á",false);
		put(	"U’e’Ç‰Á",false);
		put(	"Ö’e’Ç‰Á",false);
		put(	"ŠgU’e’Ç‰Á",false);
		put(	"“ÁêUŒ‚",false);
		put(	"”š’e‹­‰»",false);
		put(	"‚Í‚ç‚Ö‚è",true);
		put(	"H‚¢‚µ‚ñ–V",false);
		put(	"UŒ‚",true);
		put(	"–hŒä",true);
		put(	"R”»",true);
		put(	"’®Šo•ÛŒì",true);
		put(	"“‚İ–³Œø",false);
		put(	"Lˆæ",true);
		put(	"‰^”À",false);
		put(	"‘S‘Ï«UP",false);
		put(	"‰Î‘Ï«",true);
		put(	"…‘Ï«",true);
		put(	"•X‘Ï«",true);
		put(	"—‹‘Ï«",true);
		put(	"—´‘Ï«",true);
		put(	"‘Ï‹",true);
		put(	"‘ÏŠ¦",true);
		put(	"•—ˆ³",true);
		put(	"’n}",false);
		put(	"Ìæ",true);
		put(	"‚‘¬ûW",false);
		put(	"‹C‚Ü‚®‚ê",true);
		put(	"‰^‹C",true);
		put(	"’Ş‚è",false);
		put(	"ç—¢Šá",true);
		put(	"‰ñ•œ",false);
		put(	"’²‡¬Œ÷—¦",true);
		put(	"’e’²‡",false);
		put(	"˜B‹àp",false);
		put(	"‰ñ”ğ«”\",true);
		put(	"’ê—Í",false);
		put(	"Œø‰Ê‘±",false);
		put(	"ƒXƒ^ƒ~ƒi",true);
		put(	"‘•“U”",false);
		put(	"¸–§ËŒ‚",true);
		put(	"ƒ‚ƒ“ƒXƒ^[",false);
		put(	"H–",false);
		put(	"”‚¬æ‚è",false);
		put(	"’nŒ`",true);
		put(	"‘Ïk",true);
		put(	"º‘Ñ",true);
		put(	"“÷Ä‚«",true);
		put(	"–Cpt",true);
		put(	"“J‚«–¼l",false);
		put(	"‚Æ‚ñ‚¸‚ç",false);
		put(	"‘Ìp",true);
		put(	"‹­Œ¨",true);
		put(	"‚Ğ‚ç‚ß‚«",false);
		put(	"ó‚¯g",false);
		put(	"ãJ",false);
		put(	"ˆ³—Í",true);
		put(	"•ßŠlãè",true);
		put(	"“Å•r’Ç‰Á",false);
		put(	"–ƒáƒ•r’Ç‰Á",false);
		put(	"‡–°•r’Ç‰Á",false);
		put(	"‰Î‘®«UŒ‚",true);
		put(	"…‘®«UŒ‚",true);
		put(	"—‹‘®«UŒ‚",true);
		put(	"•X‘®«UŒ‚",true);
		put(	"—´‘®«UŒ‚",true);
		put(	"’fH",false);
		put(	"”šŒ‚Œ•",true);
		put(	"–Ò“ÅŒ•",true);
		put(	"–ƒáƒŒ•",true);
		put(	"‡–°Œ•",true);
		put(	"‰Î‰ŠŒ•",true);
		put(	"…ŒƒŒ•",true);
		put(	"—‹_Œ•",true);
		put(	"•XŒ‹Œ•",true);
		put(	"—´‰¤Œ•",true);
		put(	"—­‚ß’Zk",true);
	}};
	/**
	 * ’[––ˆË‘¶‚Ì‰üsƒR[ƒh
	 */
	private final static String BR1 = System.getProperty("line.separator");
	/**
	 * HTML‰üsƒR[ƒh
	 */
	private final static String BR2 = "<br>";
	/**
	 * ‰üsƒf[ƒ^
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

	// •Ší
	Buki curBuki;
	// ƒXƒLƒ‹î•ñ
	SkillInfoData skillInfo;
	// HC–h‹ï”
	private int countHC;
	// HS–h‹ï”
	private int countHS;
	// „í–h‹ï”
	private int countGO;
	// “V—’–h‹ï”
	private int countTN;
	// ”eí–h‹ï”
	private int countHA;
	// SP–h‹ï”
	private int countSP;
	// G‹‰–h‹ï” add 2013/05/27
	private int countGK;
	// G‹‰ëŒì–h‹ï” add 2013/05/27
	private int countGS;
	// ƒ‰ƒ“ƒNƒAƒbƒv
	private boolean rankUpFlag;

	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	 * @param srcbuki •Šíî•ñ
	 * @param src –h‹ïî•ñi”z—ñj
	 * @param srckafu ƒJƒtî•ñiƒŠƒXƒgj
	 * @param info iƒXƒLƒ‹î•ñj
	 * @param htmlmode true=HTMLƒ‚[ƒh,false=‚»‚êˆÈŠO
	 */
	public SkillValueList(Buki srcbuki, Bougu[] src, ArrayList<Kafus> srckafu, SkillInfoData info, boolean htmlmode){
		if(htmlmode)
			BR = BR2;
		else
			BR = BR1;
		this.curBuki = srcbuki;
		this.mode = htmlmode;
		this.skillInfo = info;
		// •Ší
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
		// –h‹ï
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
		// ƒJƒt
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
		// –h‹ïƒ^ƒCƒv‚Ì”‚¦ã‚°
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
			if( src[idx].isBouguType("‚g‚b") ) this.countHC++;
			else
			if( src[idx].isBouguType("ëŒì") ) this.countHS++;
			else
			if( src[idx].isBouguType("„í") ) this.countGO++;
			else
			if( src[idx].isBouguType("“V—’") ) this.countTN++;
			else
			if( src[idx].isBouguType("”eí") ) this.countHA++;
			else
			if( src[idx].isBouguType("‚f‹‰") ) this.countGK++;	// add 2013/05/27
			else
			if( src[idx].isBouguType("‚fë") ) this.countGS++;	// add 2013/05/27
		}
		// ƒ‰ƒ“ƒNƒAƒbƒv
		if( this.getRankUp() >= 0 )
			rankUpFlag = true;
		else
			rankUpFlag = false;
		return;
	}
	/**
	 * w’è‚µ‚½’·‚³‚ğ–„‚ß‚éƒXƒy[ƒX‚ğæ“¾
	 * @param src Œ³‚Ì•¶š—ñ
	 * @param a w’è‚µ‚½’·‚³
	 * @return ƒXƒy[ƒX‚Å–„‚ß‚ç‚ê‚½•¶š—ñ
	 */
	private String getSpace(String src, int a){
		String res = "";
		if(src.length() >= a)
			return res;
		for(int idx=0; idx<a-src.length(); idx++)
			res += "@";
		return res;
	}
	/**
	 * ”­“®ƒXƒLƒ‹‚ÌƒŠƒXƒg‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹‚ÌƒŠƒXƒg
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
	 * ƒXƒLƒ‹‚ÌƒŠƒXƒgi•\¦—pj‚ğæ“¾
	 * @return ƒXƒLƒ‹‚ÌƒŠƒXƒgi•\¦—pj
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
					noBoot.add("@" + skills[idx] + getSpace(skills[idx], 6) + "F" + tmp + " " + BR);
				else{
					if(max>0){
						String ex = "";
						if(r.uped)
							ex = "(Up)";
						if(tmp>0)
							res += "@" + skills[idx] + getSpace(skills[idx], 6) + "F" + tmp + getBootFont("aqua", name) +ex+ BR;
						else
							res += "@" + skills[idx] + getSpace(skills[idx], 6) + "F" + tmp + getBootFont("red", name) +ex+ BR;
					}
					else
						res += "@" + skills[idx] + getSpace(skills[idx], 6) + "F" + tmp + " " + name + BR;						
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
	 * ”­“®‚Ì•¶šF‚ÉHTML‚Å‰ÁH
	 * @param colorStr ƒJƒ‰[ƒR[ƒh
	 * @param element Œ³‚É‚È‚é”­“®ƒXƒLƒ‹‚Ì•¶š—ñ
	 * @return •ÒWŒã‚Ì•¶š—ñ
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
	 * a‚ê–¡HTML‚Ìæ“¾
	 * @return a‚ê–¡HTML
	 */
	public String getBootKireajiHtml(){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( curBuki.isGunner() )
			return "";
		return curBuki.getKire().getHtml(this.isKireajiPlus1(), false);
	}
	/**
	 * a‚ê–¡HTML‚Ìæ“¾iŠg’£”Åj
	 * @param indent ƒCƒ“ƒfƒ“ƒg•¶š—ñ
	 * @param ret ‰üsƒR[ƒh
	 * @return a‚ê–¡HTML
	 */
	public String getBootKireajiHtmlEx(String indent, String ret){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( curBuki.isGunner() )
			return "";
		if( this.curBuki.isBukiType("HC") ){
			return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on (HC)"+ret;
		}
		if( this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
			if( this.countTN+this.countHA >= 2 ){
				return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on („”e‚f)"+ret;
			}
		return "";
	}
	/**
	 * a‚ê–¡+1‚©”Û‚©
	 * @return true=a‚ê–¡+1‚ª”­“®‚µ‚Ä‚¢‚é,false=‚»‚êˆÈŠO
	 */
	public boolean isKireajiPlus1(){
		String name = " ";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("a‚ê–¡ƒŒƒxƒ‹+1"))return true;
		}
		return false;
	}
	/**
	 * –hŒä—ÍiŠg’£”Åjæ“¾
	 * @return –hŒä—ÍiŠg’£”Åj
	 */
	public String getBootExDef(){
		String res = "";
		// SPŒø‰Ê
		if( this.countSP >= 1 ){
			res += ",¦(+100)";
		}
		// HSŒø‰Ê
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += ",HC”e‚f(+100)"; }break;
			case 4:{ res += ",HC”e‚f(+80)"; }break;
			case 3:{ res += ",HC”e‚f(+60)"; }break;
			case 2:{ res += ",HC”e‚f(+40)"; }break;
			case 1:{ res += ",HC”e‚f(+20)"; }break;
		};
		if( this.curBuki.isBukiType("‚f‹‰") )
		switch( this.countGS ){
			case 5:{ res += ",HC”e‚f(+100)"; }break;
			case 4:{ res += ",HC”e‚f(+80)"; }break;
			case 3:{ res += ",HC”e‚f(+60)"; }break;
			case 2:{ res += ",HC”e‚f(+40)"; }break;
			case 1:{ res += ",HC”e‚f(+20)"; }break;
		};
		return res;
	}
	/**
	 * ‰ïS—¦iŠg’£”Åj‚Ìæ“¾
	 * @return ‰ïS—¦iŠg’£”Åj
	 */
	public String getBootExKaishin(){
		String res = "";
		// SP•Ší
		if( this.curBuki.isSP() ){
			res += ",¦(+20)";
		}
		// HC•Ší
		if( this.curBuki.isBukiType("‚g‚b") ){
			if(this.curBuki.isGunner())
				res += ",HC(+40)";
		}
		return res;
	}
	/**
	 * •Ší”{iŠg’£”Åj‚ğæ“¾
	 * @return •Ší”{iŠg’£”Åj
	 */
	public String getBootExBukibai(){
		String res = "";
		// SP•Ší
		if( this.curBuki.isSP() )
			res += ",¦(+10)";
		// •Ší”{—¦ƒAƒbƒv
		if( this.curBuki.isBukiType("„í") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",„”e‚f(+80)"; }break;
			case 4:{ res += ",„”e‚f(+60)"; }break;
			case 3:{ res += ",„”e‚f(+45)"; }break;
			case 2:{ res += ",„”e‚f(+30)"; }break;
			case 1:{ res += ",„”e‚f(+15)"; }break;
		};
		// ‚f‹‰•Ší”{ƒAƒbƒv
		if( this.countGK >= 3 )
			res += ",‚f(+30)";
		return res;
	}
	/**
	 * UŒ‚—ÍiŠg’£”Åj‚ğæ“¾
	 * @return UŒ‚—ÍiŠg’£”Åj
	 */
	public String getBootExAttack(){
		String res = "";
		Buki b = this.curBuki;
		// SP•Ší
		if( this.curBuki.isSP() )
			res += ",¦(+"+b.getBukiAttack(10)+")";
		// •Ší”{—¦ƒAƒbƒv
		if( this.curBuki.isBukiType("„í") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",„”e‚f(+"+b.getBukiAttack(80)+")"; }break;
			case 4:{ res += ",„”e‚f(+"+b.getBukiAttack(60)+")"; }break;
			case 3:{ res += ",„”e‚f(+"+b.getBukiAttack(45)+")"; }break;
			case 2:{ res += ",„”e‚f(+"+b.getBukiAttack(30)+")"; }break;
			case 1:{ res += ",„”e‚f(+"+b.getBukiAttack(15)+")"; }break;
		};
		// ‚f‹‰•Ší”{ƒAƒbƒv
		if( this.countGK >= 3 )
			res += ",‚f(+"+b.getBukiAttack(30)+")";
		return res;
	}
	/**
	 * ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒv‚Ìó‘Ô‚ğæ“¾
	 * @param ret ‰üsƒR[ƒh
	 * @return ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒv‚Ìó‘Ô
	 */
	public String getRankUpCondition(String ret){
		int a = getRankUp();
		if( a == -1 )
			return "";
		if( a == 0 )
			return "ƒ‰ƒ“ƒNƒAƒbƒvğŒyíz"+ret;
		return "ƒ‰ƒ“ƒNƒAƒbƒvğŒy‘Ì—Í"+a+"“ˆÈãz"+ret;
	}
	/**
	 * ƒXƒLƒ‹˜g‘‰Áó‘Ô‚ğæ“¾
	 * @param ret ‰üsƒR[ƒh
	 * @return ƒXƒLƒ‹˜g‘‰Áó‘Ô
	 */
	public String getMaxSkillsCondition(String ret){
		int a = this.getMaxSkills();
		if( a == 10 )
			return "";
		return "ƒXƒLƒ‹˜g‘‰Áy"+a+"z"+ret;
	}
	/**
	 * ƒXƒLƒ‹˜g‚ÌZo
	 * @return ƒXƒLƒ‹˜g
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
	 * ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒvğŒ‚ğæ“¾
	 * @return ƒ‰ƒ“ƒNƒAƒbƒvğŒ
	 */
	public int getRankUp(){
		// ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒv
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
	 * “ÁêŒø‰ÊƒŠƒXƒg‚Ìæ“¾
	 * @param indent ƒCƒ“ƒfƒ“ƒg•¶š—ñ
	 * @param ret ‰üsƒR[ƒh
	 * @return “ÁêŒø‰ÊƒŠƒXƒg
	 */
	public String getBootSpecialEffects(String indent, String ret){
		String res = "";
		// SP•Ší
		if( this.curBuki.isSP() ){
			res += indent+"•Ší”{+10 on ¦"+ret;
			res += indent+"‰ïS+20 on ¦"+ret;
		}
		// HC•Ší
		if( this.curBuki.isBukiType("‚g‚b") ){
			if(this.curBuki.isKenshi())
				res += indent+"a‚ê–¡ƒ‰ƒ“ƒNUP on (HC)"+ret;
			else
				res += indent+"‰ïS+40 on (HC)"+ret;
		}
		// SPŒø‰Ê
		if( this.countSP >= 1 ){
			res += indent+"–hŒä+100 on ¦"+ret;
		}
		// ©“®‰ñ•œ
		switch( this.countHC + this.countHS + this.countGS ){
			case 5:{ res += indent+"©“®‰ñ•œ/1s then st.50 on HC"+ret; }break;
			case 4:{ res += indent+"©“®‰ñ•œ/1.5s then st.70 on HC"+ret; }break;
			case 3:{ res += indent+"©“®‰ñ•œ/2s then st.100 on HC"+ret; }break;
			case 2:{ res += indent+"©“®‰ñ•œ/4s then st.125 on HC"+ret; }break;
			case 1:{ res += indent+"©“®‰ñ•œ/8s then st.150 on HC"+ret; }break;
		};
		// ƒ_ƒ[ƒWŒ¸
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += indent+"ƒ_ƒ[ƒW30“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+100 on (HC”e‚f)"+ret; }break;
			case 4:{ res += indent+"ƒ_ƒ[ƒW27“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+80 on (HC”e‚f)"+ret; }break;
			case 3:{ res += indent+"ƒ_ƒ[ƒW24“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+60 on (HC”e‚f)"+ret; }break;
			case 2:{ res += indent+"ƒ_ƒ[ƒW17“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+40 on (HC”e‚f)"+ret; }break;
			case 1:{ res += indent+"ƒ_ƒ[ƒW10“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+20 on (HC”e‚f)"+ret; }break;
		};
		if( this.curBuki.isBukiType("‚f‹‰") )
		switch( this.countGS ){
			case 5:{ res += indent+"ƒ_ƒ[ƒW30“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+100 on (HC”e‚f)"+ret; }break;
			case 4:{ res += indent+"ƒ_ƒ[ƒW27“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+80 on (HC”e‚f)"+ret; }break;
			case 3:{ res += indent+"ƒ_ƒ[ƒW24“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+60 on (HC”e‚f)"+ret; }break;
			case 2:{ res += indent+"ƒ_ƒ[ƒW17“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+40 on (HC”e‚f)"+ret; }break;
			case 1:{ res += indent+"ƒ_ƒ[ƒW10“Œ¸ then SR100 on (HC”e‚f)"+ret;
					 res += indent+"–hŒä+20 on (HC”e‚f)"+ret; }break;
		};
		// ƒXƒLƒ‹ƒ‰ƒ“ƒNƒAƒbƒv
		int ru = getRankUp();
		if( ru > 0 )
			res += indent+"ƒXƒLƒ‹ƒ‰ƒ“ƒNUP then hp"+ru+"“"+ret;
		else
		if( ru == 0 )
			res += indent+"ƒXƒLƒ‹ƒ‰ƒ“ƒNUP"+ret;
		// •Ší”{—¦ƒAƒbƒv
		if( this.curBuki.isBukiType("„í") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"•Ší”{+80 on („”e‚f)"+ret; }break;
			case 4:{ res += indent+"•Ší”{+60 on („”e‚f)"+ret; }break;
			case 3:{ res += indent+"•Ší”{+45 on („”e‚f)"+ret; }break;
			case 2:{ res += indent+"•Ší”{+30 on („”e‚f)"+ret; }break;
			case 1:{ res += indent+"•Ší”{+15 on („”e‚f)"+ret; }break;
		};
		// ‘®«ƒAƒbƒv
		if( this.curBuki.isBukiType("„í") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"‘®«10“UP on („”e‚f)"+ret; }break;
			case 4:{ res += indent+"‘®«8“UP on („”e‚f)"+ret; }break;
			case 3:{ res += indent+"‘®«6“UP on („”e‚f)"+ret; }break;
			case 2:{ res += indent+"‘®«4“UP on („”e‚f)"+ret; }break;
			case 1:{ res += indent+"‘®«2“UP on („”e‚f)"+ret; }break;
		};
		// a‚ê–¡FƒAƒbƒv
		if( this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		if( this.countTN+this.countHA >= 2 ){
			if(this.curBuki.isKenshi())
				res += indent+"a‚ê–¡ƒ‰ƒ“ƒNUP on („”e‚f)"+ret;
			else
				res += indent+"ƒNƒŠƒeƒBƒJƒ‹‹­‰» on („”e‚f)"+ret;
		};
		// ƒŒƒA“xŠÉ˜a
		if( this.curBuki.isBukiType("„í") || this.curBuki.isBukiType("“V—’") || this.curBuki.isBukiType("”eí") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"ƒŒƒA“xŠÉ˜a‚T"+ret; }break;
			case 4:{ res += indent+"ƒŒƒA“xŠÉ˜a‚S"+ret; }break;
			case 3:{ res += indent+"ƒŒƒA“xŠÉ˜a‚R"+ret; }break;
			case 2:{ res += indent+"ƒŒƒA“xŠÉ˜a‚Q"+ret; }break;
			case 1:{ res += indent+"ƒŒƒA“xŠÉ˜a‚P"+ret; }break;
		};
		// ƒXƒLƒ‹˜g‘‰Á
		int ms = this.getMaxSkills();
		if( ms > 10 )
			res += indent+"ƒXƒLƒ‹˜g‘"+ms+ret;
		// G‹‰–h‹ï‚R‚ÂˆÈã‚Å•Ší”{ƒAƒbƒv
		if( this.countGK >= 3 )
			res += indent+"•Ší”{+30 on ‚f"+ret;
		// ‰½‚à‚È‚¢‚Æ‚«
		if( res.equals("") )
			res = "‚È‚µ"+ret;
		return res;
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñ
	 * @param indent ƒCƒ“ƒfƒ“ƒg•¶š—ñ
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñ
	 */
	public String getBootTamaNrm(String indent){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( !curBuki.getType().equals("ƒ‰ƒCƒgƒ{ƒEƒKƒ“") && !curBuki.getType().equals("ƒwƒrƒBƒ{ƒEƒKƒ“") )
			return "";
		return curBuki.getNrmGun().printNrm(this.isSoutensuUp(), indent);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñi‘®«’ej
	 * @param indent ƒCƒ“ƒfƒ“ƒg•¶š—ñ
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñi‘®«’ej
	 */
	public String getBootTamaAttr(String indent){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( !curBuki.getType().equals("ƒ‰ƒCƒgƒ{ƒEƒKƒ“") && !curBuki.getType().equals("ƒwƒrƒBƒ{ƒEƒKƒ“") )
			return "";
		return curBuki.getAttrGun().printAttr(this.isSoutensuUp(), indent);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñi‘®«’e2j
	 * @param indent ƒCƒ“ƒfƒ“ƒg•¶š—ñ
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì’eî•ñi‘®«’e2j
	 */
	public String getBootTamaAttr2(String indent){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( !curBuki.getType().equals("ƒ‰ƒCƒgƒ{ƒEƒKƒ“") && !curBuki.getType().equals("ƒwƒrƒBƒ{ƒEƒKƒ“") )
			return "";
		return curBuki.getAttrGun().printAttr2(this.isSoutensuUp(), indent);
	}
	public String getBootTamaSp(String indent){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( !curBuki.getType().equals("ƒ‰ƒCƒgƒ{ƒEƒKƒ“") && !curBuki.getType().equals("ƒwƒrƒBƒ{ƒEƒKƒ“") )
			return "";
		return curBuki.getSpGun().printSp(this.isSoutensuUp(), indent);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‹|‚Ì—­‚ßî•ñ‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‹|‚Ì—­‚ßî•ñ
	 */
	public String getBootTame(){
		// ƒKƒ“ƒi[‚Ì‚Æ‚«
		if( !curBuki.getType().equals("‹|") )
			return "";
		return curBuki.getTame().print(this.isSoutensuUp());
	}
	/**
	 * ‘•“U”UP‚ª”­“®‚µ‚Ä‚¢‚é‚©”Û‚©
	 * @return true=‘ƒeƒCƒ“”UP”­“®,false=‚»‚êˆÈŠO
	 */
	public boolean isSoutensuUp(){
		String name = "‘•“U”";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("‘•“U”UP"))return true;
		}
		return false;
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚ÌƒŠƒ[ƒhî•ñ‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚ÌƒŠƒ[ƒhî•ñ
	 */
	public String getBootReload(){
		if( this.curBuki.getReload() == null )
			return "";
		String name = "‘•“U";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("‘•“U‘¬“x+3")){ boot = 3;}
				else
				if(tmp2.equals("‘•“U‘¬“x+2")){ boot = 2;}
				else
				if(tmp2.equals("‘•“U‘¬“x+1")){ boot = 1;}
				else
				if(tmp2.equals("‘•“U‘¬“x-1")){ boot = -1;}
		}
		return this.curBuki.getReload().print(boot);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì”½“®î•ñ‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì”½“®î•ñ
	 */
	public String getBootHandou(){
		if( this.curBuki.getHandou() == null )
			return "";
		String name = "”½“®";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("”½“®ŒyŒ¸+2")){ boot = 4;}
				else
				if(tmp2.equals("”½“®ŒyŒ¸+1")){ boot = 2;}
		}
		return this.curBuki.getHandou().print(boot);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‰ïS—¦‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‰ïS—¦
	 */
	public int getBootKaishin(){
		int res = 0;
		String name = "’Bl";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("Œ©Ø‚è+1"))res = 10;
				else
				if(tmp2.equals("Œ©Ø‚è+2"))res = 20;
				else
				if(tmp2.equals("Œ©Ø‚è+3"))res = 30;
				else
				if(tmp2.equals("Œ©Ø‚è+4"))res = 40;
				else
				if(tmp2.equals("Œ©Ø‚è+5"))res = 50;
			}
		}
		// ˆê‘M’Ç‰Á 2013/5/14
		name = "ˆê‘M";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("ˆê‘M+3"))res += 20;
				else
				if(tmp2.equals("ˆê‘M+2"))res += 10;
				else
				if(tmp2.equals("ˆê‘M+1"))res += 5;
			}
		}
		//--
		return res;
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì–hŒä—Í‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì–hŒä—Í
	 */
	public int getBootDefence(){
		int res = 0;
		String name = "–hŒä";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("–hŒä+120"))res = 120;
				else
				if(tmp2.equals("–hŒä+90"))res = 90;
				else
				if(tmp2.equals("–hŒä+60"))res = 60;
				else
				if(tmp2.equals("–hŒä+30"))res = 30;
				else
				if(tmp2.equals("–hŒä+20"))res = 20;
				else
				if(tmp2.equals("–hŒä-20"))res = -20;
				else
				if(tmp2.equals("–hŒä-30"))res = -30;
				else
				if(tmp2.equals("–hŒä-40"))res = -40;
			}
		}
		// ¶–½—Í’Ç‰Á 2013/5/14
		name = "¶–½—Í";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("¶–½—Í+3"))res += 90;
				else
				if(tmp2.equals("¶–½—Í+2"))res += 45;
				else
				if(tmp2.equals("¶–½—Í+1"))res += 15;
				else
				if(tmp2.equals("¶–½—Í-1"))res += 0;
			}
		}
		//--
		return res;
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‘Ï«î•ñ‚ğæ“¾
	 * @param attr w’è‚·‚é‘Ï«
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì‘Ï«î•ñ
	 */
	public int getBootTaisei(String attr){
		int res = 0;
		String name = "‘S‘Ï«UP";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("Še‘Ï«+20"))res = 20;
				else
				if(tmp2.equals("Še‘Ï«+10"))res = 10;
				else
				if(tmp2.equals("Še‘Ï«+5"))res = 5;
				else
				if(tmp2.equals("Še‘Ï«-5"))res = -5;
				else
				if(tmp2.equals("Še‘Ï«-10"))res = -10;
				else
				if(tmp2.equals("Še‘Ï«-20"))res = -20;
			}
		}
		name = attr+"‘Ï«";
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
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì•Ší”{î•ñ‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚Ì•Ší”{î•ñ
	 */
	public int getBootKougekiWithAttack(){
		int res = 0;
		String name = "UŒ‚";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("UŒ‚—ÍUPyâ‘åz")) res = 50;
				else
				if(tmp2.equals("UŒ‚—ÍUPy“Á‘åz")) res = 30;
				else
				if(tmp2.equals("UŒ‚—ÍUPy‘åz")) res = 20;
				else
				if(tmp2.equals("UŒ‚—ÍUPy’†z")) res = 10;
				else
				if(tmp2.equals("UŒ‚—ÍUPy¬z")) res = 5;
			}
		}
		// „Œ‚’Ç‰Á 2013/5/14
		int res1 = 0;
		name = "„Œ‚";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("„Œ‚+5")) res1 = 150;
				else
				if(tmp2.equals("„Œ‚+4")) res1 = 80;
				else
				if(tmp2.equals("„Œ‚+3")) res1 = 50;
				else
				if(tmp2.equals("„Œ‚+2")) res1 = 35;
				else
				if(tmp2.equals("„Œ‚+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return this.curBuki.calBairitsu(res1);
		//--
		return this.curBuki.calBairitsu(res);
	}
	/**
	 * ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚ÌUŒ‚î•ñ‚ğæ“¾
	 * @return ”­“®ƒXƒLƒ‹l—¶Ï‚İ‚ÌUŒ‚î•ñ
	 */
	public int getBootKougeki(){
		int res = 0;
		String name = "UŒ‚";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("UŒ‚—ÍUPyâ‘åz")) res = 50;
				else
				if(tmp2.equals("UŒ‚—ÍUPy“Á‘åz")) res = 30;
				else
				if(tmp2.equals("UŒ‚—ÍUPy‘åz")) res = 20;
				else
				if(tmp2.equals("UŒ‚—ÍUPy’†z")) res = 10;
				else
				if(tmp2.equals("UŒ‚—ÍUPy¬z")) res = 5;
			}
		}
		// „Œ‚’Ç‰Á 2013/5/14
		int res1 = 0;
		name = "„Œ‚";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("„Œ‚+5")) res1 = 150;
				else
				if(tmp2.equals("„Œ‚+4")) res1 = 80;
				else
				if(tmp2.equals("„Œ‚+3")) res1 = 50;
				else
				if(tmp2.equals("„Œ‚+2")) res1 = 35;
				else
				if(tmp2.equals("„Œ‚+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return res1;
		//--
		return res;
	}
	/**
	 * ”­“®ƒXƒLƒ‹‚ªƒ‰ƒ“ƒNƒAƒbƒv‰Â”\‚©”Û‚©
	 * @param name ”­“®ƒXƒLƒ‹
	 * @return true=ƒ‰ƒ“ƒNƒAƒbƒv‰Â”\,false=‚»‚êˆÈŠO
	 */
	public static boolean isRankUpable(String name){
		return rankMap.get(name);
	}
	/**
	 * ”­“®‚µ‚½ƒXƒLƒ‹‚ÌƒŠƒXƒg‚ğæ“¾
	 * @return ”­“®‚µ‚½ƒXƒLƒ‹‚ÌƒŠƒXƒg
	 */
	public ArrayList<String> getBootedList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src		= this.getValueList();
		String[] list	= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]	= list[idx].replaceAll("@", "");
			String[] list2	= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") )
				res.add(list2[1]);
		}
		return res;
	}
	/**
	 * ƒXƒLƒ‹ƒŠƒXƒg‚ğæ“¾
	 * @return ƒXƒLƒ‹ƒŠƒXƒg
	 */
	public ArrayList<String> getBootedSkillList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src				= this.getValueList();
		String[] list			= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]			= list[idx].replaceAll("@", "");
			String[] list2		= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") ){
				String[] list3	= CsvStringToList.split(list2[0], "F");
				res.add(list3[0]);
			}
		}
		return res;
	}
}
