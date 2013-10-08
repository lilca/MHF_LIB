package jp.skd.lilca.mhf.lib.buki;

/**
 * •Ší‚Ì–CŒ‚‚ğ’ŠÛ‰»‚µ‚½ƒNƒ‰ƒX
 */
public class Hougeki {

	private String type;
	private int level;

	private boolean empty;

	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	 * @param str –CŒ‚î•ñ‚ªŠÜ‚Ü‚ê‚é•¶š—ñ
	 */
	public Hougeki(String str){
		// |’Êí ŠgU •úË| |<num>|
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * –CŒ‚î•ñ‚ğ‰ğÍ‚µ‚Äİ’è
	 * @param str ‰ğÍ‚³‚ê‚é•¶š—ñ
	 */
	private void setString(String str){
		if(str.indexOf("’Êí")!=-1)
			this.type = "’Êí";
		else
		if(str.indexOf("ŠgU")!=-1)
			this.type = "ŠgU";
		else
		if(str.indexOf("•úË")!=-1)
			this.type = "•úË";
		else
			return;
		// ”’l
		this.level = Integer.parseInt(str.replaceAll("’Êí", "").replaceAll("ŠgU", "").replaceAll("•úË", ""));
		return;
	}
	/**
	 * –CŒ‚î•ñ‚ğ•¶š—ñ‚Éo—Í
	 * @return •¶š—ñŒ`®‚Ì–CŒ‚î•ñ
	 */
	public String print(){
		if(empty)
			return "";
		return this.type+this.level;
	}
}
