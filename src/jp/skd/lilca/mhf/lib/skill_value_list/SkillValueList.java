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
 * スキル発動を考慮した情報を得るためのクラス
 */
public class SkillValueList {
	/**
	 * スキルのリスト（発動優先順位順）
	 */
	public final static String[] skills = {
	"片手剣技",
	"双剣技",
	"大剣技",
	"太刀技",
	"鎚技",
	"狩猟笛技",
	"槍技",
	"銃槍技",
	"重銃技",
	"軽銃技",
	"弓技",
	"剛撃",
	"一閃",
	"痛撃",
	"速射",
	"反射",
	"鼓舞",
	"装着",
	"調合師",
	"一匹狼",
	"警戒",
	"生命力",
	"怒",
	"鉄腕",
	"ブリーダー",
	"逆境",
	"救援",
	"狩人",
	"耐酔",
	"耐状態異常",
	"剣術",
	"対防御DOWN",
	"いたわり",
	"ナイフ使い",
	"気力回復",
	"属性攻撃",
	"武器捌き",
	"高速設置",
	"根性",
	"麻痺",
	"睡眠",
	"気絶",
	"毒",
	"脱臭",
	"耐雪",
	"気配",
	"体力",
	"回復速度",
	"斬れ味",
	"匠",
	"達人",
	"研ぎ師",
	"ガード性能",
	"自動防御",
	"投擲",
	"装填",
	"連射",
	"反動",
	"通常弾強化",
	"貫通弾強化",
	"散弾強化",
	"通常弾追加",
	"貫通弾追加",
	"散弾追加",
	"榴弾追加",
	"拡散弾追加",
	"特殊攻撃",
	"爆弾強化",
	"はらへり",
	"食いしん坊",
	"攻撃",
	"防御",
	"審判",
	"聴覚保護",
	"盗み無効",
	"広域",
	"運搬",
	"全耐性UP",
	"火耐性",
	"水耐性",
	"氷耐性",
	"雷耐性",
	"龍耐性",
	"耐暑",
	"耐寒",
	"風圧",
	"地図",
	"採取",
	"高速収集",
	"気まぐれ",
	"運気",
	"釣り",
	"千里眼",
	"回復",
	"調合成功率",
	"弾調合",
	"錬金術",
	"回避性能",
	"底力",
	"効果持続",
	"スタミナ",
	"装填数",
	"精密射撃",
	"モンスター",
	"食事",
	"剥ぎ取り",
	"地形",
	"耐震",
	"声帯",
	"肉焼き",
	"砲術師",
	"笛吹き名人",
	"とんずら",
	"体術",
	"強肩",
	"ひらめき",
	"受け身",
	"絆",
	"圧力",
	"捕獲上手",
	"毒瓶追加",
	"麻痺瓶追加",
	"睡眠瓶追加",
	"火属性攻撃",
	"水属性攻撃",
	"雷属性攻撃",
	"氷属性攻撃",
	"龍属性攻撃",
	"断食",
	"爆撃剣",
	"猛毒剣",
	"麻痺剣",
	"睡眠剣",
	"火炎剣",
	"水激剣",
	"雷神剣",
	"氷結剣",
	"龍王剣",
	"溜め短縮",
	};
	/**
	 * スキルランクアップの有無
	 */
	private static HashMap<String, Boolean> rankMap = new HashMap<String, Boolean>(){
		private static final long serialVersionUID = 1L;
	{
		put(	"片手剣技",false);
		put(	"双剣技",false);
		put(	"大剣技",false);
		put(	"太刀技",false);
		put(	"鎚技",false);
		put(	"狩猟笛技",false);
		put(	"槍技",false);
		put(	"銃槍技",false);
		put(	"重銃技",false);
		put(	"軽銃技",false);
		put(	"弓技",false);
		put(	"剛撃",false);
		put(	"一閃",false);
		put(	"痛撃",false);
		put(	"速射",false);
		put(	"反射",false);
		put(	"鼓舞",false);
		put(	"装着",false);
		put(	"調合師",false);
		put(	"一匹狼",false);		
		put(	"警戒",false);
		put(	"生命力",false);
		put(	"怒",false);
		put(	"鉄腕",false);
		put(	"ブリーダー",false);
		put(	"逆境",false);
		put(	"救援",false);
		put(	"狩人",false);
		put(	"耐酔",false);
		put(	"根性",true);
		put(	"高速設置",true);
		put(	"武器捌き",false);
		put(	"属性攻撃",false);
		put(	"気力回復",true);
		put(	"ナイフ使い",true);
		put(	"いたわり",false);
		put(	"対防御DOWN",false);
		put(	"剣術",true);
		put(	"耐状態異常",true);
		put(	"麻痺",true);
		put(	"睡眠",true);
		put(	"気絶",true);
		put(	"毒",true);
		put(	"脱臭",false);
		put(	"耐雪",false);
		put(	"気配",false);
		put(	"体力",true);
		put(	"回復速度",true);
		put(	"斬れ味",true);
		put(	"匠",false);
		put(	"達人",true);
		put(	"研ぎ師",true);
		put(	"ガード性能",true);
		put(	"自動防御",false);
		put(	"投擲",false);
		put(	"装填",true);
		put(	"連射",false);
		put(	"反動",true);
		put(	"通常弾強化",false);
		put(	"貫通弾強化",false);
		put(	"散弾強化",false);
		put(	"通常弾追加",false);
		put(	"貫通弾追加",false);
		put(	"散弾追加",false);
		put(	"榴弾追加",false);
		put(	"拡散弾追加",false);
		put(	"特殊攻撃",false);
		put(	"爆弾強化",false);
		put(	"はらへり",true);
		put(	"食いしん坊",false);
		put(	"攻撃",true);
		put(	"防御",true);
		put(	"審判",true);
		put(	"聴覚保護",true);
		put(	"盗み無効",false);
		put(	"広域",true);
		put(	"運搬",false);
		put(	"全耐性UP",false);
		put(	"火耐性",true);
		put(	"水耐性",true);
		put(	"氷耐性",true);
		put(	"雷耐性",true);
		put(	"龍耐性",true);
		put(	"耐暑",true);
		put(	"耐寒",true);
		put(	"風圧",true);
		put(	"地図",false);
		put(	"採取",true);
		put(	"高速収集",false);
		put(	"気まぐれ",true);
		put(	"運気",true);
		put(	"釣り",false);
		put(	"千里眼",true);
		put(	"回復",false);
		put(	"調合成功率",true);
		put(	"弾調合",false);
		put(	"錬金術",false);
		put(	"回避性能",true);
		put(	"底力",false);
		put(	"効果持続",false);
		put(	"スタミナ",true);
		put(	"装填数",false);
		put(	"精密射撃",true);
		put(	"モンスター",false);
		put(	"食事",false);
		put(	"剥ぎ取り",false);
		put(	"地形",true);
		put(	"耐震",true);
		put(	"声帯",true);
		put(	"肉焼き",true);
		put(	"砲術師",true);
		put(	"笛吹き名人",false);
		put(	"とんずら",false);
		put(	"体術",true);
		put(	"強肩",true);
		put(	"ひらめき",false);
		put(	"受け身",false);
		put(	"絆",false);
		put(	"圧力",true);
		put(	"捕獲上手",true);
		put(	"毒瓶追加",false);
		put(	"麻痺瓶追加",false);
		put(	"睡眠瓶追加",false);
		put(	"火属性攻撃",true);
		put(	"水属性攻撃",true);
		put(	"雷属性攻撃",true);
		put(	"氷属性攻撃",true);
		put(	"龍属性攻撃",true);
		put(	"断食",false);
		put(	"爆撃剣",true);
		put(	"猛毒剣",true);
		put(	"麻痺剣",true);
		put(	"睡眠剣",true);
		put(	"火炎剣",true);
		put(	"水激剣",true);
		put(	"雷神剣",true);
		put(	"氷結剣",true);
		put(	"龍王剣",true);
		put(	"溜め短縮",true);
	}};
	/**
	 * 端末依存の改行コード
	 */
	private final static String BR1 = System.getProperty("line.separator");
	/**
	 * HTML改行コード
	 */
	private final static String BR2 = "<br>";
	/**
	 * 改行データ
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

	// 武器
	Buki curBuki;
	// スキル情報
	SkillInfoData skillInfo;
	// HC防具数
	private int countHC;
	// HS防具数
	private int countHS;
	// 剛種防具数
	private int countGO;
	// 天嵐防具数
	private int countTN;
	// 覇種防具数
	private int countHA;
	// SP防具数
	private int countSP;
	// G級防具数 add 2013/05/27
	private int countGK;
	// G級狩護防具数 add 2013/05/27
	private int countGS;
	// ランクアップ
	private boolean rankUpFlag;

	/**
	 * コンストラクタ
	 * @param srcbuki 武器情報
	 * @param src 防具情報（配列）
	 * @param srckafu カフ情報（リスト）
	 * @param info （スキル情報）
	 * @param htmlmode true=HTMLモード,false=それ以外
	 */
	public SkillValueList(Buki srcbuki, Bougu[] src, ArrayList<Kafus> srckafu, SkillInfoData info, boolean htmlmode){
		if(htmlmode)
			BR = BR2;
		else
			BR = BR1;
		this.curBuki = srcbuki;
		this.mode = htmlmode;
		this.skillInfo = info;
		// 武器
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
		// 防具
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
		// カフ
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
		// 防具タイプの数え上げ
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
			if( src[idx].isBouguType("ＨＣ") ) this.countHC++;
			else
			if( src[idx].isBouguType("狩護") ) this.countHS++;
			else
			if( src[idx].isBouguType("剛種") ) this.countGO++;
			else
			if( src[idx].isBouguType("天嵐") ) this.countTN++;
			else
			if( src[idx].isBouguType("覇種") ) this.countHA++;
			else
			if( src[idx].isBouguType("Ｇ級") ) this.countGK++;	// add 2013/05/27
			else
			if( src[idx].isBouguType("Ｇ狩") ) this.countGS++;	// add 2013/05/27
		}
		// ランクアップ
		if( this.getRankUp() >= 0 )
			rankUpFlag = true;
		else
			rankUpFlag = false;
		return;
	}
	/**
	 * 指定した長さを埋めるスペースを取得
	 * @param src 元の文字列
	 * @param a 指定した長さ
	 * @return スペースで埋められた文字列
	 */
	private String getSpace(String src, int a){
		String res = "";
		if(src.length() >= a)
			return res;
		for(int idx=0; idx<a-src.length(); idx++)
			res += "　";
		return res;
	}
	/**
	 * 発動スキルのリストを取得
	 * @return 発動スキルのリスト
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
	 * スキルのリスト（表示用）を取得
	 * @return スキルのリスト（表示用）
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
					noBoot.add("　" + skills[idx] + getSpace(skills[idx], 6) + "：" + tmp + " " + BR);
				else{
					if(max>0){
						String ex = "";
						if(r.uped)
							ex = "(Up)";
						if(tmp>0)
							res += "　" + skills[idx] + getSpace(skills[idx], 6) + "：" + tmp + getBootFont("aqua", name) +ex+ BR;
						else
							res += "　" + skills[idx] + getSpace(skills[idx], 6) + "：" + tmp + getBootFont("red", name) +ex+ BR;
					}
					else
						res += "　" + skills[idx] + getSpace(skills[idx], 6) + "：" + tmp + " " + name + BR;						
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
	 * 発動時の文字色にHTMLで加工
	 * @param colorStr カラーコード
	 * @param element 元になる発動スキルの文字列
	 * @return 編集後の文字列
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
	 * 斬れ味HTMLの取得
	 * @return 斬れ味HTML
	 */
	public String getBootKireajiHtml(){
		// ガンナーのとき
		if( curBuki.isGunner() )
			return "";
		return curBuki.getKire().getHtml(this.isKireajiPlus1(), false);
	}
	/**
	 * 斬れ味HTMLの取得（拡張版）
	 * @param indent インデント文字列
	 * @param ret 改行コード
	 * @return 斬れ味HTML
	 */
	public String getBootKireajiHtmlEx(String indent, String ret){
		// ガンナーのとき
		if( curBuki.isGunner() )
			return "";
		if( this.curBuki.isBukiType("HC") ){
			return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on (HC)"+ret;
		}
		if( this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
			if( this.countTN+this.countHA >= 2 ){
				return indent+curBuki.getKire().getHtml(this.isKireajiPlus1(), true)+" on (剛覇Ｇ)"+ret;
			}
		return "";
	}
	/**
	 * 斬れ味+1か否か
	 * @return true=斬れ味+1が発動している,false=それ以外
	 */
	public boolean isKireajiPlus1(){
		String name = "匠";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("斬れ味レベル+1"))return true;
		}
		return false;
	}
	/**
	 * 防御力（拡張版）取得
	 * @return 防御力（拡張版）
	 */
	public String getBootExDef(){
		String res = "";
		// SP効果
		if( this.countSP >= 1 ){
			res += ",凄(+100)";
		}
		// HS効果
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += ",HC覇Ｇ(+100)"; }break;
			case 4:{ res += ",HC覇Ｇ(+80)"; }break;
			case 3:{ res += ",HC覇Ｇ(+60)"; }break;
			case 2:{ res += ",HC覇Ｇ(+40)"; }break;
			case 1:{ res += ",HC覇Ｇ(+20)"; }break;
		};
		if( this.curBuki.isBukiType("Ｇ級") )
		switch( this.countGS ){
			case 5:{ res += ",HC覇Ｇ(+100)"; }break;
			case 4:{ res += ",HC覇Ｇ(+80)"; }break;
			case 3:{ res += ",HC覇Ｇ(+60)"; }break;
			case 2:{ res += ",HC覇Ｇ(+40)"; }break;
			case 1:{ res += ",HC覇Ｇ(+20)"; }break;
		};
		return res;
	}
	/**
	 * 会心率（拡張版）の取得
	 * @return 会心率（拡張版）
	 */
	public String getBootExKaishin(){
		String res = "";
		// SP武器
		if( this.curBuki.isSP() ){
			res += ",凄(+20)";
		}
		// HC武器
		if( this.curBuki.isBukiType("ＨＣ") ){
			if(this.curBuki.isGunner())
				res += ",HC(+40)";
		}
		return res;
	}
	/**
	 * 武器倍（拡張版）を取得
	 * @return 武器倍（拡張版）
	 */
	public String getBootExBukibai(){
		String res = "";
		// SP武器
		if( this.curBuki.isSP() )
			res += ",凄(+10)";
		// 武器倍率アップ
		if( this.curBuki.isBukiType("剛種") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",剛覇Ｇ(+80)"; }break;
			case 4:{ res += ",剛覇Ｇ(+60)"; }break;
			case 3:{ res += ",剛覇Ｇ(+45)"; }break;
			case 2:{ res += ",剛覇Ｇ(+30)"; }break;
			case 1:{ res += ",剛覇Ｇ(+15)"; }break;
		};
		// Ｇ級武器倍アップ
		if( this.countGK >= 3 )
			res += ",Ｇ(+30)";
		return res;
	}
	/**
	 * 攻撃力（拡張版）を取得
	 * @return 攻撃力（拡張版）
	 */
	public String getBootExAttack(){
		String res = "";
		Buki b = this.curBuki;
		// SP武器
		if( this.curBuki.isSP() )
			res += ",凄(+"+b.getBukiAttack(10)+")";
		// 武器倍率アップ
		if( this.curBuki.isBukiType("剛種") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += ",剛覇Ｇ(+"+b.getBukiAttack(80)+")"; }break;
			case 4:{ res += ",剛覇Ｇ(+"+b.getBukiAttack(60)+")"; }break;
			case 3:{ res += ",剛覇Ｇ(+"+b.getBukiAttack(45)+")"; }break;
			case 2:{ res += ",剛覇Ｇ(+"+b.getBukiAttack(30)+")"; }break;
			case 1:{ res += ",剛覇Ｇ(+"+b.getBukiAttack(15)+")"; }break;
		};
		// Ｇ級武器倍アップ
		if( this.countGK >= 3 )
			res += ",Ｇ(+"+b.getBukiAttack(30)+")";
		return res;
	}
	/**
	 * スキルランクアップの状態を取得
	 * @param ret 改行コード
	 * @return スキルランクアップの状態
	 */
	public String getRankUpCondition(String ret){
		int a = getRankUp();
		if( a == -1 )
			return "";
		if( a == 0 )
			return "ランクアップ条件【常時】"+ret;
		return "ランクアップ条件【体力"+a+"％以上】"+ret;
	}
	/**
	 * スキル枠増加状態を取得
	 * @param ret 改行コード
	 * @return スキル枠増加状態
	 */
	public String getMaxSkillsCondition(String ret){
		int a = this.getMaxSkills();
		if( a == 10 )
			return "";
		return "スキル枠増加【"+a+"】"+ret;
	}
	/**
	 * スキル枠の算出
	 * @return スキル枠
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
	 * スキルランクアップ条件を取得
	 * @return ランクアップ条件
	 */
	public int getRankUp(){
		// スキルランクアップ
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
	 * 特殊効果リストの取得
	 * @param indent インデント文字列
	 * @param ret 改行コード
	 * @return 特殊効果リスト
	 */
	public String getBootSpecialEffects(String indent, String ret){
		String res = "";
		// SP武器
		if( this.curBuki.isSP() ){
			res += indent+"武器倍+10 on 凄"+ret;
			res += indent+"会心+20 on 凄"+ret;
		}
		// HC武器
		if( this.curBuki.isBukiType("ＨＣ") ){
			if(this.curBuki.isKenshi())
				res += indent+"斬れ味ランクUP on (HC)"+ret;
			else
				res += indent+"会心+40 on (HC)"+ret;
		}
		// SP効果
		if( this.countSP >= 1 ){
			res += indent+"防御+100 on 凄"+ret;
		}
		// 自動回復
		switch( this.countHC + this.countHS + this.countGS ){
			case 5:{ res += indent+"自動回復/1s then st.50 on HC"+ret; }break;
			case 4:{ res += indent+"自動回復/1.5s then st.70 on HC"+ret; }break;
			case 3:{ res += indent+"自動回復/2s then st.100 on HC"+ret; }break;
			case 2:{ res += indent+"自動回復/4s then st.125 on HC"+ret; }break;
			case 1:{ res += indent+"自動回復/8s then st.150 on HC"+ret; }break;
		};
		// ダメージ減
		if( this.curBuki.isBukiType("HC") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countHS + this.countGS ){
			case 5:{ res += indent+"ダメージ30％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+100 on (HC覇Ｇ)"+ret; }break;
			case 4:{ res += indent+"ダメージ27％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+80 on (HC覇Ｇ)"+ret; }break;
			case 3:{ res += indent+"ダメージ24％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+60 on (HC覇Ｇ)"+ret; }break;
			case 2:{ res += indent+"ダメージ17％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+40 on (HC覇Ｇ)"+ret; }break;
			case 1:{ res += indent+"ダメージ10％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+20 on (HC覇Ｇ)"+ret; }break;
		};
		if( this.curBuki.isBukiType("Ｇ級") )
		switch( this.countGS ){
			case 5:{ res += indent+"ダメージ30％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+100 on (HC覇Ｇ)"+ret; }break;
			case 4:{ res += indent+"ダメージ27％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+80 on (HC覇Ｇ)"+ret; }break;
			case 3:{ res += indent+"ダメージ24％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+60 on (HC覇Ｇ)"+ret; }break;
			case 2:{ res += indent+"ダメージ17％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+40 on (HC覇Ｇ)"+ret; }break;
			case 1:{ res += indent+"ダメージ10％減 then SR100 on (HC覇Ｇ)"+ret;
					 res += indent+"防御+20 on (HC覇Ｇ)"+ret; }break;
		};
		// スキルランクアップ
		int ru = getRankUp();
		if( ru > 0 )
			res += indent+"スキルランクUP then hp"+ru+"％"+ret;
		else
		if( ru == 0 )
			res += indent+"スキルランクUP"+ret;
		// 武器倍率アップ
		if( this.curBuki.isBukiType("剛種") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"武器倍+80 on (剛覇Ｇ)"+ret; }break;
			case 4:{ res += indent+"武器倍+60 on (剛覇Ｇ)"+ret; }break;
			case 3:{ res += indent+"武器倍+45 on (剛覇Ｇ)"+ret; }break;
			case 2:{ res += indent+"武器倍+30 on (剛覇Ｇ)"+ret; }break;
			case 1:{ res += indent+"武器倍+15 on (剛覇Ｇ)"+ret; }break;
		};
		// 属性アップ
		if( this.curBuki.isBukiType("剛種") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"属性10％UP on (剛覇Ｇ)"+ret; }break;
			case 4:{ res += indent+"属性8％UP on (剛覇Ｇ)"+ret; }break;
			case 3:{ res += indent+"属性6％UP on (剛覇Ｇ)"+ret; }break;
			case 2:{ res += indent+"属性4％UP on (剛覇Ｇ)"+ret; }break;
			case 1:{ res += indent+"属性2％UP on (剛覇Ｇ)"+ret; }break;
		};
		// 斬れ味色アップ
		if( this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		if( this.countTN+this.countHA >= 2 ){
			if(this.curBuki.isKenshi())
				res += indent+"斬れ味ランクUP on (剛覇Ｇ)"+ret;
			else
				res += indent+"クリティカル強化 on (剛覇Ｇ)"+ret;
		};
		// レア度緩和
		if( this.curBuki.isBukiType("剛種") || this.curBuki.isBukiType("天嵐") || this.curBuki.isBukiType("覇種") )
		switch( this.countTN+this.countHA ){
			case 5:{ res += indent+"レア度緩和５"+ret; }break;
			case 4:{ res += indent+"レア度緩和４"+ret; }break;
			case 3:{ res += indent+"レア度緩和３"+ret; }break;
			case 2:{ res += indent+"レア度緩和２"+ret; }break;
			case 1:{ res += indent+"レア度緩和１"+ret; }break;
		};
		// スキル枠増加
		int ms = this.getMaxSkills();
		if( ms > 10 )
			res += indent+"スキル枠増"+ms+ret;
		// G級防具３つ以上で武器倍アップ
		if( this.countGK >= 3 )
			res += indent+"武器倍+30 on Ｇ"+ret;
		// 何もないとき
		if( res.equals("") )
			res = "なし"+ret;
		return res;
	}
	/**
	 * 発動スキル考慮済みの弾情報
	 * @param indent インデント文字列
	 * @return 発動スキル考慮済みの弾情報
	 */
	public String getBootTamaNrm(String indent){
		// ガンナーのとき
		if( !curBuki.getType().equals("ライトボウガン") && !curBuki.getType().equals("ヘビィボウガン") )
			return "";
		return curBuki.getNrmGun().printNrm(this.isSoutensuUp(), indent);
	}
	/**
	 * 発動スキル考慮済みの弾情報（属性弾）
	 * @param indent インデント文字列
	 * @return 発動スキル考慮済みの弾情報（属性弾）
	 */
	public String getBootTamaAttr(String indent){
		// ガンナーのとき
		if( !curBuki.getType().equals("ライトボウガン") && !curBuki.getType().equals("ヘビィボウガン") )
			return "";
		return curBuki.getAttrGun().printAttr(this.isSoutensuUp(), indent);
	}
	/**
	 * 発動スキル考慮済みの弾情報（属性弾2）
	 * @param indent インデント文字列
	 * @return 発動スキル考慮済みの弾情報（属性弾2）
	 */
	public String getBootTamaAttr2(String indent){
		// ガンナーのとき
		if( !curBuki.getType().equals("ライトボウガン") && !curBuki.getType().equals("ヘビィボウガン") )
			return "";
		return curBuki.getAttrGun().printAttr2(this.isSoutensuUp(), indent);
	}
	public String getBootTamaSp(String indent){
		// ガンナーのとき
		if( !curBuki.getType().equals("ライトボウガン") && !curBuki.getType().equals("ヘビィボウガン") )
			return "";
		return curBuki.getSpGun().printSp(this.isSoutensuUp(), indent);
	}
	/**
	 * 発動スキル考慮済みの弓の溜め情報を取得
	 * @return 発動スキル考慮済みの弓の溜め情報
	 */
	public String getBootTame(){
		// ガンナーのとき
		if( !curBuki.getType().equals("弓") )
			return "";
		return curBuki.getTame().print(this.isSoutensuUp());
	}
	/**
	 * 装填数UPが発動しているか否か
	 * @return true=総テイン数UP発動,false=それ以外
	 */
	public boolean isSoutensuUp(){
		String name = "装填数";
		Integer tmp = this.values.get(name);
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("装填数UP"))return true;
		}
		return false;
	}
	/**
	 * 発動スキル考慮済みのリロード情報を取得
	 * @return 発動スキル考慮済みのリロード情報
	 */
	public String getBootReload(){
		if( this.curBuki.getReload() == null )
			return "";
		String name = "装填";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("装填速度+3")){ boot = 3;}
				else
				if(tmp2.equals("装填速度+2")){ boot = 2;}
				else
				if(tmp2.equals("装填速度+1")){ boot = 1;}
				else
				if(tmp2.equals("装填速度-1")){ boot = -1;}
		}
		return this.curBuki.getReload().print(boot);
	}
	/**
	 * 発動スキル考慮済みの反動情報を取得
	 * @return 発動スキル考慮済みの反動情報
	 */
	public String getBootHandou(){
		if( this.curBuki.getHandou() == null )
			return "";
		String name = "反動";
		Integer tmp = this.values.get(name);
		int boot = 0;
		if( tmp != null ){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if( tmp2 != null )
				if(tmp2.equals("反動軽減+2")){ boot = 4;}
				else
				if(tmp2.equals("反動軽減+1")){ boot = 2;}
		}
		return this.curBuki.getHandou().print(boot);
	}
	/**
	 * 発動スキル考慮済みの会心率を取得
	 * @return 発動スキル考慮済みの会心率
	 */
	public int getBootKaishin(){
		int res = 0;
		String name = "達人";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("見切り+1"))res = 10;
				else
				if(tmp2.equals("見切り+2"))res = 20;
				else
				if(tmp2.equals("見切り+3"))res = 30;
				else
				if(tmp2.equals("見切り+4"))res = 40;
				else
				if(tmp2.equals("見切り+5"))res = 50;
			}
		}
		// 一閃追加 2013/5/14
		name = "一閃";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("一閃+3"))res += 20;
				else
				if(tmp2.equals("一閃+2"))res += 10;
				else
				if(tmp2.equals("一閃+1"))res += 5;
			}
		}
		//--
		return res;
	}
	/**
	 * 発動スキル考慮済みの防御力を取得
	 * @return 発動スキル考慮済みの防御力
	 */
	public int getBootDefence(){
		int res = 0;
		String name = "防御";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("防御+120"))res = 120;
				else
				if(tmp2.equals("防御+90"))res = 90;
				else
				if(tmp2.equals("防御+60"))res = 60;
				else
				if(tmp2.equals("防御+30"))res = 30;
				else
				if(tmp2.equals("防御+20"))res = 20;
				else
				if(tmp2.equals("防御-20"))res = -20;
				else
				if(tmp2.equals("防御-30"))res = -30;
				else
				if(tmp2.equals("防御-40"))res = -40;
			}
		}
		// 生命力追加 2013/5/14
		name = "生命力";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("生命力+3"))res += 90;
				else
				if(tmp2.equals("生命力+2"))res += 45;
				else
				if(tmp2.equals("生命力+1"))res += 15;
				else
				if(tmp2.equals("生命力-1"))res += 0;
			}
		}
		//--
		return res;
	}
	/**
	 * 発動スキル考慮済みの耐性情報を取得
	 * @param attr 指定する耐性
	 * @return 発動スキル考慮済みの耐性情報
	 */
	public int getBootTaisei(String attr){
		int res = 0;
		String name = "全耐性UP";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("各耐性+20"))res = 20;
				else
				if(tmp2.equals("各耐性+10"))res = 10;
				else
				if(tmp2.equals("各耐性+5"))res = 5;
				else
				if(tmp2.equals("各耐性-5"))res = -5;
				else
				if(tmp2.equals("各耐性-10"))res = -10;
				else
				if(tmp2.equals("各耐性-20"))res = -20;
			}
		}
		name = attr+"耐性";
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
	 * 発動スキル考慮済みの武器倍情報を取得
	 * @return 発動スキル考慮済みの武器倍情報
	 */
	public int getBootKougekiWithAttack(){
		int res = 0;
		String name = "攻撃";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("攻撃力UP【絶大】")) res = 50;
				else
				if(tmp2.equals("攻撃力UP【特大】")) res = 30;
				else
				if(tmp2.equals("攻撃力UP【大】")) res = 20;
				else
				if(tmp2.equals("攻撃力UP【中】")) res = 10;
				else
				if(tmp2.equals("攻撃力UP【小】")) res = 5;
			}
		}
		// 剛撃追加 2013/5/14
		int res1 = 0;
		name = "剛撃";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("剛撃+5")) res1 = 150;
				else
				if(tmp2.equals("剛撃+4")) res1 = 80;
				else
				if(tmp2.equals("剛撃+3")) res1 = 50;
				else
				if(tmp2.equals("剛撃+2")) res1 = 35;
				else
				if(tmp2.equals("剛撃+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return this.curBuki.calBairitsu(res1);
		//--
		return this.curBuki.calBairitsu(res);
	}
	/**
	 * 発動スキル考慮済みの攻撃情報を取得
	 * @return 発動スキル考慮済みの攻撃情報
	 */
	public int getBootKougeki(){
		int res = 0;
		String name = "攻撃";
		Integer tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("攻撃力UP【絶大】")) res = 50;
				else
				if(tmp2.equals("攻撃力UP【特大】")) res = 30;
				else
				if(tmp2.equals("攻撃力UP【大】")) res = 20;
				else
				if(tmp2.equals("攻撃力UP【中】")) res = 10;
				else
				if(tmp2.equals("攻撃力UP【小】")) res = 5;
			}
		}
		// 剛撃追加 2013/5/14
		int res1 = 0;
		name = "剛撃";
		tmp = this.values.get(name);
		if(tmp != null){
			String tmp2 = this.skillInfo.getBootSkill(name, tmp, rankUpFlag).text;
			if(tmp2 != null){
				if(tmp2.equals("剛撃+5")) res1 = 150;
				else
				if(tmp2.equals("剛撃+4")) res1 = 80;
				else
				if(tmp2.equals("剛撃+3")) res1 = 50;
				else
				if(tmp2.equals("剛撃+2")) res1 = 35;
				else
				if(tmp2.equals("剛撃+1")) res1 = 20;
			}
		}
		if( res1 > res )
			return res1;
		//--
		return res;
	}
	/**
	 * 発動スキルがランクアップ可能か否か
	 * @param name 発動スキル
	 * @return true=ランクアップ可能,false=それ以外
	 */
	public static boolean isRankUpable(String name){
		return rankMap.get(name);
	}
	/**
	 * 発動したスキルのリストを取得
	 * @return 発動したスキルのリスト
	 */
	public ArrayList<String> getBootedList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src		= this.getValueList();
		String[] list	= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]	= list[idx].replaceAll("　", "");
			String[] list2	= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") )
				res.add(list2[1]);
		}
		return res;
	}
	/**
	 * スキルリストを取得
	 * @return スキルリスト
	 */
	public ArrayList<String> getBootedSkillList(){
		ArrayList<String> res	= new ArrayList<String>();
		res.clear();
		String src				= this.getValueList();
		String[] list			= CsvStringToList.split(src, "\n");
		for(int idx=0; idx<list.length; idx++){
			list[idx]			= list[idx].replaceAll("　", "");
			String[] list2		= CsvStringToList.split(list[idx], " ");
			if( list2.length > 1 && !list2[1].equals("") ){
				String[] list3	= CsvStringToList.split(list2[0], "：");
				res.add(list3[0]);
			}
		}
		return res;
	}
}
