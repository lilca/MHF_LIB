package jp.skd.lilca.mhf.lib.buki;

/**
 * ����̉��F�𒊏ۉ������N���X
 */
public class Neiro {

	private boolean white;
	private boolean lime;
	private boolean cyan;
	private boolean yellow;
	private boolean red;
	private boolean magenta;
	private boolean blue;
	private boolean pink;

	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str ������`���̉��F���
	 */
	public Neiro(String str){
		// BGCOLOR(black);&size(20);{&color(white){"��"};&color(blue){"��"};&color(red){"��"};}
		if(str.equals("")){
			this.empty = true;
			return;
		}
		this.setString(str);
		this.empty = false;
		return;
	}
	/**
	 * ������`���̉��F������͂��Đݒ�
	 * @param str ������`���̉��F���
	 */
	private void setString(String str){
		if(str.toLowerCase().indexOf("white")==-1)		white   = false; else white   = true;
		if(str.toLowerCase().indexOf("lime")==-1)		lime    = false; else lime    = true;
		if(str.toLowerCase().indexOf("cyan")==-1)		cyan    = false; else cyan    = true;
		if(str.toLowerCase().indexOf("aqua")==-1)		cyan    = false; else cyan    = true;
		if(str.toLowerCase().indexOf("yellow")==-1)		yellow  = false; else yellow  = true;
		if(str.toLowerCase().indexOf("red")==-1)		red     = false; else red     = true;
		if(str.toLowerCase().indexOf("magenta")==-1)	magenta = false; else magenta = true;
		if(str.toLowerCase().indexOf("fuchsia")==-1)	magenta = false; else magenta = true;
		if(str.toLowerCase().indexOf("blue")==-1)		blue    = false; else blue    = true;
		if(str.toLowerCase().indexOf("pink")==-1)		pink    = false; else pink    = true;
		return;
	}
	/**
	 * ���F����HTML�����ŕ�����ɏo��
	 * @return HTML�����̕�����
	 */
	public String printHtml(){
		if(empty)
			return "";
		String res = "";
		if(white)
			res += "<font color=\"white\">"+"��"+"</font>";
		if(lime)
			res += "<font color=\"lime\">"+"��"+"</font>";
		if(cyan)
			res += "<font color=\"aqua\">"+"��"+"</font>";
		if(yellow)
			res += "<font color=\"yellow\">"+"��"+"</font>";
		if(red)
			res += "<font color=\"red\">"+"��"+"</font>";
		if(magenta)
			res += "<font color=\"fuchsia\">"+"��"+"</font>";
		if(blue)
			res += "<font color=\"blue\">"+"��"+"</font>";
		if(pink)
			res += "<font color=\"pink\">"+"��"+"</font>";
		return res;
	}
}
