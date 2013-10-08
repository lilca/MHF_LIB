package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

/**
 * ����̔����𒊏ۉ������N���X
 */
public class Handou {

	private HashMap<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("�ő�", 0);
			put("��", 2);
			put("��⏬", 3);
			put("��", 4);
			put("�ɏ�", 5);
			put("�ŏ�", 6);
			put("�ŏ�'", 7);
			put("�ŏ�''", 8);
		}
	};
	private HashMap<Integer, String> pmap = new HashMap<Integer, String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(0, "�ő�");
			put(2, "��");
			put(3, "��⏬");
			put(4, "��");
			put(5, "�ɏ�");
			put(6, "�ŏ�");
			put(7, "�ŏ�+");
			put(8, "�ŏ�++");
		}
	};
	private int val;

	/**
	 * �R���X�g���N�^
	 * @param src ������񂪊܂܂�Ă��镶����
	 */
	public Handou(String src){
		Integer tmp;
		try{
			tmp = this.map.get(src);
		}catch(Exception e){
			this.val = -1;
			return;
		}
		if(tmp == null){
			this.val = -1;
			return;
		}
		this.val = tmp;
		return;
	}
	/**
	 * �������𕶎���o��
	 * @param v �X�L�������Ȃǂɂ��o�C�A�X
	 * @return ������ɂ�锽�����
	 */
	public String print(int v){
		if( this.val == -1 )
			return "";
		return this.pmap.get(this.val+v);
	}
}
