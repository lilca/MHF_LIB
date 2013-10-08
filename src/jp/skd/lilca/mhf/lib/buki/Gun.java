package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

import jp.skd.lilca.mhf.lib.tools.CsvStringToList;

/**
 * ����̒e�𒊏ۉ������N���X
 */
public class Gun {

	private HashMap<String ,String> list;

	private boolean empty;

	/**
	 * �R���X�g���N�^
	 * @param str ������`���̒e���
	 */
	public Gun(String str){
		// |��:6/6/9@��:3+/4/4@�U:2/2/2+@�O:1+/1+/1+@�g:1+/1/1|
		// |��:2@�y:2@�S:1@�d:1|
		// �̈�m��
		list	= new HashMap<String ,String>();
		if(str.equals("")){
			this.empty = true;
			return;
		}
		String[] temp = CsvStringToList.split(str, "@");
		// ���
		for(int idx=0; idx<temp.length; idx++)
			this.add(temp[idx]);
		this.empty = false;
		return;
	}
	/**
	 * �e���ǉ�
	 * @param src ������`���̒e���
	 */
	public void add(String src){
		String[] temp1 = CsvStringToList.split(src, ":");
try{
		// ���l
		this.list.put(temp1[0], temp1[1]);
}catch(Exception e){
	e.printStackTrace();
}

		return;
	}
	/**
	 * �e���𕶎���ɏo��
	 * @param sup �X�L�������Ȃǂ��e����UP���Ă��邩�ۂ�
	 * @param indent �C���f���g������
	 * @return �e���𕶎���
	 */
	public String printNrm(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("��", sup, "-/-/-")+"<br>"+
				indent+this.printCell("��", sup, "-/-/-")+"<br>"+
				indent+this.printCell("�U", sup, "-/-/-")+"<br>"+
				indent+this.printCell("�O", sup, "-/-/-")+"<br>"+
				indent+this.printCell("�g", sup, "-/-/-");
		return res;
	}
	/**
	 * �e���𕶎���ɏo�́i�ُ푮���e�Ȃǁj
	 * @param sup �X�L�������Ȃǂ��e����UP���Ă��邩�ۂ�
	 * @param indent �C���f���g������
	 * @return �e���𕶎���i�ُ푮���e�Ȃǁj
	 */
	public String printAttr(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("��", sup, "-/-")+", "+
				indent+this.printCell("��", sup, "-/-")+", "+
				indent+this.printCell("��", sup, "-/-")+", "+
				indent+this.printCell("��", sup, "-/-");
		return res;
	}
	/**
	 * �e���𕶎���ɏo�́i�����e�Ȃǁj
	 * @param sup �X�L�������Ȃǂ��e����UP���Ă��邩�ۂ�
	 * @param indent �C���f���g������
	 * @return �e���𕶎���i�����e�Ȃǁj
	 */
	public String printAttr2(boolean sup, String indent){
		String res = "";
		res +=	indent+this.printCell("��", sup, "-")+", "+
				indent+this.printCell("��", sup, "-")+", "+
				indent+this.printCell("��", sup, "-")+", "+
				indent+this.printCell("�X", sup, "-")+", "+
				indent+this.printCell("��", sup, "-");
		return res;
	}
	/**
	 * �e���𕶎���ɏo�́i�ߊl�e�Ȃǁj
	 * @param sup �X�L�������Ȃǂ��e����UP���Ă��邩�ۂ�
	 * @param indent �C���f���g������
	 * @return �e���𕶎���i�ߊl�e�Ȃǁj
	 */
	public String printSp(boolean sup, String indent){
		String res = "";
		// |��:2@�y:2@�S:1@�d:1|
		res +=	indent+this.printCell("��", sup, "-")+", "+
				indent+this.printCell("�y", sup, "-")+", "+
				indent+this.printCell("�S", sup, "-")+", "+
				indent+this.printCell("�d", sup, "-");
		return res;
	}
	/**
	 * �w�肵���e�̎�ނ���e���𕶎���ɏo��
	 * @param key �e�̎�ށi�u�сv�u�߁v�Ȃǁj
	 * @param up �X�L�������Ȃǂ��e����UP���Ă��邩�ۂ�
	 * @param def �e���̃f�t�H���g�\���i�u-/-�v�u-�v�Ȃǁj
	 * @return ������`���̒e���
	 */
	public String printCell(String key, boolean up, String def){
		String v;
		try{
			v = this.list.get(key);
		}catch(Exception e){
			return key+":"+def;
		}
		if( v == null )
			return key+":"+def;
		String[] temp1 = CsvStringToList.split(v, "/");
		// �Z������
		String[] res = new String[temp1.length];
		for(int idx=0; idx<temp1.length; idx++){
			// ���UUP�̂Ƃ�
			if( up )
				res[idx] = temp1[idx].replace("+", "");
			// �ʏ��+���Ȃ��Ƃ�
			else
			if( temp1[idx].indexOf("+") == -1 )
				res[idx] = temp1[idx];
			// �ʏ��+������Ƃ�
			else{
				int a=0;
				try{
				a = Integer.parseInt(temp1[idx].replace("+", ""));}
						catch(Exception e){
							e.printStackTrace();			
						}
				if( a-1 == 0)
					res[idx] = "-";
				else
					res[idx] = Integer.toString(a-1);
			}
		}
		return key+":"+CsvStringToList.scat(res, "/");
	}
	/**
	 * �_�~�[
	 * @param n �_�~�[
	 * @return ��ɋ󕶎���
	 */
	@Deprecated
	public String getType(int n){
		if(empty)
			return "";
		return "";
	}
	/**
	 * �_�~�[
	 * @param n �_�~�[
	 * @return ��ɋ󕶎���
	 */
	@Deprecated
	public String getLevel(int n){
		if(empty)
			return "";
		return "";
	}
}
